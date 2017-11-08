package com.dinner.snqjf.sys.dao;

import com.dinner.snqjf.common.base.dao.GenericDao;

import com.dinner.snqjf.sys.entity.Tree;
import com.dinner.snqjf.sys.entity.QueryTree;
import com.dinner.snqjf.sys.entity.User;

import java.util.List;

/**
 *@author linzf
 **/
public interface TreeDao extends GenericDao<Tree, QueryTree> {

    /**
     * 功能描述：加载用户的菜单树的数据
     * @param user
     * @return
     */
	List<Tree> loadUserTree(User user);
}