package com.dinner.snqjf.back.dao;

import com.dinner.snqjf.common.base.dao.GenericDao;

import com.dinner.snqjf.back.entity.Diner;
import com.dinner.snqjf.back.entity.QueryDiner;

/**
 *@author linzf
 **/
public interface DinerDao extends GenericDao<Diner, QueryDiner> {

    /**
     * 功能描述：更新菜单的销量数据
     * @param diner
     * @return
     */
    int updateDinerSel(Diner diner);
}