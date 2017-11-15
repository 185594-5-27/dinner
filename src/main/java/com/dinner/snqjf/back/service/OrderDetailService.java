package com.dinner.snqjf.back.service;

import com.dinner.snqjf.back.dao.OrderDao;
import com.dinner.snqjf.back.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import com.dinner.snqjf.common.base.service.GenericService;
import com.dinner.snqjf.common.base.dao.GenericDao;

import com.dinner.snqjf.back.entity.OrderDetail;
import com.dinner.snqjf.back.entity.QueryOrderDetail;
import com.dinner.snqjf.back.dao.OrderDetailDao;

import java.util.List;

/**
 *@author linzf
 **/
@Service("orderDetailService")
@Transactional(rollbackFor={IllegalArgumentException.class})
public class OrderDetailService extends GenericService<OrderDetail, QueryOrderDetail> {
	@Autowired
	@SuppressWarnings("SpringJavaAutowiringInspection")
	private OrderDetailDao orderDetailDao;
	@Autowired
	@SuppressWarnings("SpringJavaAutowiringInspection")
	private OrderDao orderDao;
	@Override
	protected GenericDao<OrderDetail, QueryOrderDetail> getDao() {
		return orderDetailDao;
	}

	@Override
	public boolean update(OrderDetail entity) throws Exception {
		// 根据订单号来获取所有的订单明细数据
		List<OrderDetail> orderDetailList =  orderDetailDao.getOrderDetailByOrderId(entity);
		double totalMoney = 0;
        for(OrderDetail orderDetail:orderDetailList){
        	if(orderDetail.getId()==entity.getId()){
        		// 撤单的数据不统计金额
        		if(entity.getState().equalsIgnoreCase(OrderDetail.STATE_CANCEL)){
                     continue;
				}
				if(orderDetail.getIsPreferential().equals(OrderDetail.ORDER_DETAIL_HAS_PREFERENTIAL)){
					totalMoney = totalMoney + entity.getNum() * Double.parseDouble(orderDetail.getPreferentialPrice());
				}else{
					totalMoney = totalMoney + entity.getNum() * Double.parseDouble(orderDetail.getPrice());
				}
			}else{
				if(orderDetail.getState().equalsIgnoreCase(OrderDetail.STATE_CANCEL)){
					continue;
				}
				if(orderDetail.getIsPreferential().equals(OrderDetail.ORDER_DETAIL_HAS_PREFERENTIAL)){
					totalMoney = totalMoney + orderDetail.getNum() * Double.parseDouble(orderDetail.getPreferentialPrice());
				}else{
					totalMoney = totalMoney + orderDetail.getNum() * Double.parseDouble(orderDetail.getPrice());
				}
			}
		}
		// 更新订单的金额数据
		Order order = new Order();
		order.setOrderPrice(totalMoney+"");
		order.setId(entity.getOrderId());
		orderDao.updateOrderByAddDish(order);
		return super.update(entity);
	}

	/**
	 * 功能描述：根据订单号来查找订单明细
	 * @param entity
	 * @return
	 */
	public List<OrderDetail> getOrderDetailByOrderId(OrderDetail entity){
		return orderDetailDao.getOrderDetailByOrderId(entity);
	}
}