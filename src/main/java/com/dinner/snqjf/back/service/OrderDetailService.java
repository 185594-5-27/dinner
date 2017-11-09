package com.dinner.snqjf.back.service;

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
	@Override
	protected GenericDao<OrderDetail, QueryOrderDetail> getDao() {
		return orderDetailDao;
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