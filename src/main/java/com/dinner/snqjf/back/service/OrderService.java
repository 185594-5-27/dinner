package com.dinner.snqjf.back.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import com.dinner.snqjf.common.base.service.GenericService;
import com.dinner.snqjf.common.base.dao.GenericDao;

import com.dinner.snqjf.back.entity.Order;
import com.dinner.snqjf.back.entity.QueryOrder;
import com.dinner.snqjf.back.dao.OrderDao;

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
}