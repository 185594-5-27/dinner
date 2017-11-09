package com.dinner.snqjf.back.service;

import com.dinner.snqjf.back.dao.OrderDao;
import com.dinner.snqjf.back.entity.Order;
import com.dinner.snqjf.back.entity.QueryOrder;
import com.dinner.snqjf.common.base.dao.GenericDao;
import com.dinner.snqjf.common.base.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 *@author linzf
 **/
@Service("orderService")
@Transactional(rollbackFor={IllegalArgumentException.class})
public class OrderService extends GenericService<Order, QueryOrder> {
	@Autowired
	@SuppressWarnings("SpringJavaAutowiringInspection")
	private OrderDao orderDao;

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
		return orderDao.checkout(entity)>0;
	}
}