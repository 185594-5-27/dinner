package com.dinner.snqjf.back.service;

import com.dinner.snqjf.back.dao.DinerDao;
import com.dinner.snqjf.back.dao.DiningTableDao;
import com.dinner.snqjf.back.dao.OrderDao;
import com.dinner.snqjf.back.dao.OrderDetailDao;
import com.dinner.snqjf.back.entity.*;
import com.dinner.snqjf.common.base.dao.GenericDao;
import com.dinner.snqjf.common.base.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
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

	@Override
	protected GenericDao<Order, QueryOrder> getDao() {
		return orderDao;
	}

	/**
	 * 功能描述：实现结账功能
	 * @param entity
	 * @return
	 */
	public boolean checkout(Order entity){
		entity.setConsumeTime(new Date());
		entity.setState(Order.STATE_READY_PAY);
		// 更新餐桌数据
		DiningTable diningTable = new DiningTable(entity.getId());
		diningTableDao.completeOrderDiningTable(diningTable);
		Map<Integer,Integer> orderMap = new HashMap<Integer,Integer>();
		// 更新菜单表的销量的数据
        for(OrderDetail orderDetail:orderDetailDao.getOrderDetailByOrderId(new OrderDetail(entity.getId()))){
           if(orderMap.get(orderDetail.getDinnerId())!=null){
			   orderMap.put(orderDetail.getDinnerId(),orderDetail.getNum()+orderMap.get(orderDetail.getDinnerId()));
		   }else{
			   orderMap.put(orderDetail.getDinnerId(),orderDetail.getNum());
		   }
		}
		// 更新菜单表的销量数据
		orderMap.forEach((k,v)->{
			dinerDao.updateDinerSel(new Diner(k,v));
		});
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