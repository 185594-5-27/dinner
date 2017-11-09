package com.dinner.snqjf.back.dao;

import com.dinner.snqjf.common.base.dao.GenericDao;

import com.dinner.snqjf.back.entity.Order;
import com.dinner.snqjf.back.entity.QueryOrder;

/**
 *@author linzf
 **/
public interface OrderDao extends GenericDao<Order, QueryOrder> {

    /**
     * 功能描述：实现结账功能
     * @param entity
     * @return
     */
    public int checkout(Order entity);

	
}