package com.dinner.snqjf.sys.dao;

import com.dinner.snqjf.common.base.dao.GenericDao;

import com.dinner.snqjf.sys.entity.User;
import com.dinner.snqjf.sys.entity.UserRole;
import com.dinner.snqjf.sys.entity.QueryUserRole;

/**
 *@author linzf
 **/
public interface UserRoleDao extends GenericDao<UserRole, QueryUserRole> {

    /**
     * 功能描述：获取权限菜单数据
     * @param entity
     * @return
     */
    UserRole getUserRoleAssociate(UserRole entity);
	
}