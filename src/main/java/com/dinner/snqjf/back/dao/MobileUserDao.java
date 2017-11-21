package com.dinner.snqjf.back.dao;

import com.dinner.snqjf.common.base.dao.GenericDao;

import com.dinner.snqjf.back.entity.MobileUser;
import com.dinner.snqjf.back.entity.QueryMobileUser;

/**
 *@author linzf
 **/
public interface MobileUserDao extends GenericDao<MobileUser, QueryMobileUser> {

    /**
     * 功能描述：更新用户积分
     * @param entity
     * @return
     */
    int updateUserScore(MobileUser entity);

    /**
     * 功能描述：根据用户电话来获取用户信息
     * @param entity
     * @return
     */
    MobileUser getUserByPhone(MobileUser entity);

}