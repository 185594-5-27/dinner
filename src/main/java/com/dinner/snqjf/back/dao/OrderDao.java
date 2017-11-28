package com.dinner.snqjf.back.dao;

import com.dinner.snqjf.common.base.dao.GenericDao;

import com.dinner.snqjf.back.entity.Order;
import com.dinner.snqjf.back.entity.QueryOrder;

/**
 *@author linzf
 **/
public interface OrderDao extends GenericDao<Order, QueryOrder> {

    /**
     * 功能描述：实现统计最近一个月内的收入
     * @return
     */
    double sumRecentlyIncome();

    /**
     * 功能描述：根据时间来获取相应的时间的当日收入
     * @param orderTime
     * @return
     */
    double sumDayIncome(String orderTime);

    /**
     * 功能描述：加菜的时候更新订单金额
     * @param entity
     * @return
     */
    int updateOrderByAddDish(Order entity);

    /**
     * 功能描述：实现结账功能
     * @param entity
     * @return
     */
     int checkout(Order entity);

    /**
     * 功能描述：实现取消订单功能
     * @param entity
     * @return
     */
     int cancelOrder(Order entity);

	
}