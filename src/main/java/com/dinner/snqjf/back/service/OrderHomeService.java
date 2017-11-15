package com.dinner.snqjf.back.service;

import com.dinner.snqjf.back.dao.DinerDao;
import com.dinner.snqjf.back.dao.DiningTableDao;
import com.dinner.snqjf.back.dao.OrderDao;
import com.dinner.snqjf.back.dao.OrderDetailDao;
import com.dinner.snqjf.back.entity.Diner;
import com.dinner.snqjf.back.entity.DiningTable;
import com.dinner.snqjf.back.entity.Order;
import com.dinner.snqjf.back.entity.OrderDetail;
import com.dinner.snqjf.common.util.date.DateUtil;
import com.dinner.snqjf.common.util.user.UserInfo;
import com.dinner.snqjf.sys.entity.User;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*
* 类描述：
* @auther linzf
* @create 2017/11/15 0015 
*/
@Service("orderHomeService")
@Transactional(rollbackFor={IllegalArgumentException.class})
public class OrderHomeService {

    @Autowired
    @SuppressWarnings("SpringJavaAutowiringInspection")
    private DinerDao dinerDao;

    @Autowired
    @SuppressWarnings("SpringJavaAutowiringInspection")
    private OrderDao orderDao;

    @Autowired
    @SuppressWarnings("SpringJavaAutowiringInspection")
    private OrderDetailDao orderDetailDao;

    @Autowired
    @SuppressWarnings("SpringJavaAutowiringInspection")
    private DiningTableDao diningTableDao;

    public boolean submitOrder(DiningTable entity) throws Exception {
        boolean success = true;
        List<OrderDetail> orderDetailList = this.getOrderDetail(entity);
        // 订单ID不为0说明是加菜
        if(entity.getOrderId()!=0){
            Order order = new Order();
            order.setId(entity.getOrderId());
            order = orderDao.get(order);
            order.setOrderPrice((Double.parseDouble(order.getOrderPrice())+this.countOrderDetail(orderDetailList))+"");
            for(OrderDetail orderDetail:orderDetailList){
                orderDetailDao.save(orderDetail);
            }
            orderDao.updateOrderByAddDish(order);
        }else{
            entity = diningTableDao.get(entity);
            Order order = new Order();
            order.setOrderPrice((this.countOrderDetail(orderDetailList))+"");
            order.setState(Order.STATE_PENDING_PAY);
            order.setPrivateRoom(entity.getName());
            order.setOrderTime(new Date());
            User user = UserInfo.getUser();
            order.setOrderUser(user.getUserName());
            order.setOrderUserId(user.getId());
            order.setTableNum(entity.getId()+"");
            order.setOrderNum(DateUtil.format(new Date(),"yyyyMMddHHmmssSSS"));
            // 保存订单数据
            orderDao.save(order);
            // 保存订单明细数据
            for(OrderDetail orderDetail:orderDetailList){
                orderDetail.setOrderId(order.getId());
                orderDetail.setType("1");
                orderDetailDao.save(orderDetail);
            }
            // 更新订单数据到餐桌表
            entity.setOrderId(order.getId());
            diningTableDao.updateDiningTableOrder(entity);
        }
        return success;
    }


    // 组装订单数据
    private List<OrderDetail> getOrderDetail(DiningTable entity){
        JSONArray jarray = JSONArray.fromObject(entity.getOrderDetail());
        List<OrderDetail> orderDetailList = new ArrayList<OrderDetail>();
        OrderDetail orderDetail = null;
        Diner diner = null;
        JSONObject jobj = null;
        for(int i=0;i<jarray.size();i++){
            orderDetail = new OrderDetail();
            jobj = jarray.getJSONObject(i);
            diner = new Diner();
            diner.setId(jobj.getInt("id"));
            diner = dinerDao.get(diner);
            orderDetail.setDinnerId(diner.getId());
            orderDetail.setGoodTypeName(diner.getGoodTypeName());
            orderDetail.setImageUrl(diner.getImageUrl());
            orderDetail.setIsPreferential(diner.getIsPreferential());
            orderDetail.setName(diner.getName());
            orderDetail.setNum(jobj.getInt("num"));
            orderDetail.setPreferentialPrice(diner.getPreferentialPrice());
            orderDetail.setOrderTime(new Date());
            orderDetail.setPrice(diner.getPrice());
            orderDetail.setState("1");
            // 订单明细类型为加菜
            if(entity.getOrderId()!=0){
                orderDetail.setOrderId(entity.getOrderId());
                orderDetail.setType("2");
            }else{// 订单明细类型为正常
                orderDetail.setType("1");
            }
            orderDetailList.add(orderDetail);
        }
        return orderDetailList;
    }

    // 统计订单明细总价
    private double countOrderDetail(List<OrderDetail> orderDetailList){
        double totalMoney = 0;
        for(OrderDetail orderDetail:orderDetailList){
            if(orderDetail.getIsPreferential().equals(OrderDetail.ORDER_DETAIL_HAS_PREFERENTIAL)){
                totalMoney = totalMoney + orderDetail.getNum() * Double.parseDouble(orderDetail.getPreferentialPrice());
            }else{
                totalMoney = totalMoney + orderDetail.getNum() * Double.parseDouble(orderDetail.getPrice());
            }
        }
        return totalMoney;
    }

}
