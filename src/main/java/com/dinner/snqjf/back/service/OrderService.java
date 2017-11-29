package com.dinner.snqjf.back.service;

import com.dinner.snqjf.back.dao.*;
import com.dinner.snqjf.back.entity.*;
import com.dinner.snqjf.common.base.dao.GenericDao;
import com.dinner.snqjf.common.base.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *@author linzf
 **/
@Service("orderService")
@Transactional(rollbackFor={IllegalArgumentException.class})
public class OrderService extends GenericService<Order, QueryOrder> {
	@Autowired
	@SuppressWarnings("SpringJavaAutowiringInspection")
	private OrderDao orderDao;
	@Autowired
	@SuppressWarnings("SpringJavaAutowiringInspection")
	private DiningTableDao diningTableDao;

	@Autowired
	@SuppressWarnings("SpringJavaAutowiringInspection")
	private OrderDetailDao orderDetailDao;
	@Autowired
	@SuppressWarnings("SpringJavaAutowiringInspection")
	private DinerDao dinerDao;
	@Autowired
	@SuppressWarnings("SpringJavaAutowiringInspection")
	private MobileUserDao mobileUserDao;
	@Autowired
	@SuppressWarnings("SpringJavaAutowiringInspection")
	private ScoreDetailDao scoreDetailDao;

	@Override
	protected GenericDao<Order, QueryOrder> getDao() {
		return orderDao;
	}

	/**
	 * 功能描述：实现统计最近一个月内的收入
	 * @return
	 */
	public double sumRecentlyIncome(){
		return orderDao.sumRecentlyIncome();
	}

	 /**
	 * 功能描述：根据时间来获取相应的时间的当日收入
	 * @param orderTime
	 * @return
	 */
	 public double sumDayIncome(String orderTime){
		return orderDao.sumDayIncome(orderTime);
	}

	/**
	 * 功能描述：统计收入构成
	 * @return
	 */
	public List<Order> sumIncomeComposition(){
		return orderDao.sumIncomeComposition();
	}

	/**
	 * 功能描述：实现结账功能
	 * @param entity
	 * @return
	 */
	public boolean checkout(Order entity) throws Exception {
		int dinnerId = 0;
		entity.setConsumeTime(new Date());
		entity.setState(Order.STATE_READY_PAY);
		// 更新餐桌数据
		DiningTable diningTable = new DiningTable(entity.getId());
		diningTableDao.completeOrderDiningTable(diningTable);
		Map<Integer,Integer> orderMap = new HashMap<Integer,Integer>();
		// 更新菜单表的销量的数据
        for(OrderDetail orderDetail:orderDetailDao.getOrderDetailByOrderId(new OrderDetail(entity.getId()))){
			dinnerId = orderDetail.getDinnerId();
           if(orderMap.get(dinnerId)!=null){
			   orderMap.put(dinnerId,orderDetail.getNum()+orderMap.get(dinnerId));
		   }else{
			   orderMap.put(dinnerId,orderDetail.getNum());
		   }
		}
		// 更新菜单表的销量数据
		orderMap.forEach((k,v)->{
			dinerDao.updateDinerSel(new Diner(k,v));
		});
		// 更新用户的积分并保存用户积分流水数据
		if(entity.getConsumeUserPhone()!=null&&!entity.getConsumeUserPhone().equalsIgnoreCase("")){
			MobileUser mobileUser = mobileUserDao.getUserByPhone(new MobileUser(entity.getConsumeUserPhone()));
			if(mobileUser!=null){
				// 增加用户积分
				ScoreDetail scoreDetail = new ScoreDetail();
				scoreDetail.setCreateTime(new Date());
				scoreDetail.setOrderId(entity.getId());
				scoreDetail.setOrderNo(entity.getOrderNum());
				scoreDetail.setScore(entity.getScore());
				scoreDetail.setType(ScoreDetail.ADD_TYPE);
				scoreDetail.setUserId(mobileUser.getId());
				scoreDetail.setUserName(mobileUser.getName());
				scoreDetailDao.save(scoreDetail);
				// 更新用户积分
				mobileUser.setScore(mobileUser.getScore()+entity.getScore());
				mobileUserDao.updateUserScore(mobileUser);
			}
		}
		// 表示实际支付金额和订单金额不对等
		if(!entity.getOrderPrice().equals(entity.getRealIncome())){
           double price = Double.parseDouble(entity.getRealIncome()) - Double.parseDouble(entity.getOrderPrice());
			OrderDetail orderDetail = new OrderDetail();
			orderDetail.setOrderId(entity.getId());
			orderDetail.setPrice(price+"");
			orderDetail.setOrderTime(new Date());
			orderDetail.setPreferentialPrice(price+"");
			orderDetail.setIsPreferential("1");
			orderDetail.setState(OrderDetail.STATE_NORMAL);
			orderDetail.setType(OrderDetail.TYPE_FAVOURABLE);
			orderDetail.setNum(1);
			orderDetail.setName("优惠金额");
			orderDetail.setGoodTypeName("优惠");
			orderDetail.setDinnerId(dinnerId);
			orderDetailDao.save(orderDetail);
		}

		return orderDao.checkout(entity)>0;
	}

	/**
	 * 功能描述：实现取消订单功能
	 * @param entity
	 * @return
	 */
	public boolean cancelOrder(Order entity){
		entity.setConsumeTime(new Date());
		entity.setState(Order.STATE_CANCEL_ORDER);
		// 更新餐桌数据
		DiningTable diningTable = new DiningTable(entity.getId());
		diningTableDao.completeOrderDiningTable(diningTable);
		return orderDao.cancelOrder(entity)>0;
	}
}