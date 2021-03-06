package com.dinner.snqjf.sys.service;

import com.dinner.snqjf.sys.dao.RoleAssociateTreeDao;
import com.dinner.snqjf.sys.entity.RoleAssociateTree;
import com.dinner.snqjf.sys.entity.Tree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dinner.snqjf.common.base.service.GenericService;
import com.dinner.snqjf.common.base.dao.GenericDao;

import com.dinner.snqjf.sys.entity.UserRole;
import com.dinner.snqjf.sys.entity.QueryUserRole;
import com.dinner.snqjf.sys.dao.UserRoleDao;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 *@author linzf
 **/
@Service("userRoleService")
@Transactional(rollbackFor={IllegalArgumentException.class})
public class UserRoleService extends GenericService<UserRole, QueryUserRole> {
	@Autowired
	@SuppressWarnings("SpringJavaAutowiringInspection")
	private UserRoleDao userRoleDao;
	@Autowired
	@SuppressWarnings("SpringJavaAutowiringInspection")
	private RoleAssociateTreeDao roleAssociateTreeDao;

	@Override
	protected GenericDao<UserRole, QueryUserRole> getDao() {
		return userRoleDao;
	}

	/**
	 * 功能描述：获取权限菜单数据
	 * @param entity
	 * @return
	 */
	public UserRole getUserRoleAssociate(UserRole entity){
		return userRoleDao.getUserRoleAssociate(entity);
	}

	/**
	 * 功能描述：删除角色数据
	 * @param entityList
	 * @return
	 * @throws Exception
	 */
	@Override
	public boolean removeBath(List<UserRole> entityList) throws Exception {
        for(UserRole userRole:entityList){
			roleAssociateTreeDao.removeTreeByRoleId(userRole);
		}
		return super.removeBath(entityList);
	}

	/**
	 * 增加角色数据
	 * @param entity 保存对象
	 * @return
	 * @throws Exception
	 */
	@Override
	public boolean save(UserRole entity) throws Exception {
		entity.packagingTrees(entity.getTreeArray());
		List<Tree> treeList = entity.getTreeList();
		boolean success = super.save(entity);
		for(Tree tree:treeList){
			roleAssociateTreeDao.save(new RoleAssociateTree(entity.getId(),tree.getId()));
		}
		return success;
	}

	@Override
	public boolean update(UserRole entity) throws Exception {
		entity.packagingTrees(entity.getTreeArray());
		List<Tree> treeList = entity.getTreeList();
		roleAssociateTreeDao.removeTreeByRoleId(entity);
		for(Tree tree:treeList){
			roleAssociateTreeDao.save(new RoleAssociateTree(entity.getId(),tree.getId()));
		}
		return super.update(entity);
	}
}