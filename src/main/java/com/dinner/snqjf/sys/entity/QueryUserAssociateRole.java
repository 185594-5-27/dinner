package com.dinner.snqjf.sys.entity;

import com.dinner.snqjf.common.base.entity.QueryBase;

/**
 *@author linzf
 **/
public class QueryUserAssociateRole extends QueryBase {
	private Integer userId;
	private Long roleId;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

}
