package com.dinner.snqjf.back.dao;

import com.dinner.snqjf.common.base.dao.GenericDao;

import com.dinner.snqjf.back.entity.OrderDetail;
import com.dinner.snqjf.back.entity.QueryOrderDetail;

import java.util.List;

/**
 *@author linzf
 **/
public interface OrderDetailDao extends GenericDao<OrderDetail, QueryOrderDetail> {

    /**
     * 功能描述：根据订单号来查找订单明细
     * @param entity
     * @return
     */
    public List<OrderDetail> getOrderDetailByOrderId(OrderDetail entity);
	
}