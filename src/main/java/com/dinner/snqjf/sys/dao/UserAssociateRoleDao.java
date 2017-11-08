package com.dinner.snqjf.sys.dao;

import com.dinner.snqjf.common.base.dao.GenericDao;

import com.dinner.snqjf.sys.entity.User;
import com.dinner.snqjf.sys.entity.UserAssociateRole;
import com.dinner.snqjf.sys.entity.QueryUserAssociateRole;

/**
 *@author linzf
 **/
public interface UserAssociateRoleDao extends GenericDao<UserAssociateRole, QueryUserAssociateRole> {

    /**
     * 功能描述：根据用户的ID来删除用户的权限数据
     * @param user
     * @return
     */
    int removeUserRole(User user);
}