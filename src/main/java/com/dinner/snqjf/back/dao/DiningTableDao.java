package com.dinner.snqjf.back.dao;

import com.dinner.snqjf.common.base.dao.GenericDao;

import com.dinner.snqjf.back.entity.DiningTable;
import com.dinner.snqjf.back.entity.QueryDiningTable;

/**
 *@author linzf
 **/
public interface DiningTableDao extends GenericDao<DiningTable, QueryDiningTable> {

    /**
     * 功能描述：订单结账或者撤单的时候更新餐桌的订单的ID来恢复餐桌的订餐
     * @param entity
     * @return
     */
    int completeOrderDiningTable(DiningTable entity);

    /**
     * 功能描述： 新增订单的时候更新餐桌的订单ID
     * @param entity
     * @return
     */
    int updateDiningTableOrder(DiningTable entity);
	
}