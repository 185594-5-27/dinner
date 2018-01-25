package com.dinner.snqjf.back.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import com.dinner.snqjf.common.base.service.GenericService;
import com.dinner.snqjf.common.base.dao.GenericDao;

import com.dinner.snqjf.back.entity.UserInfo;
import com.dinner.snqjf.back.entity.QueryUserInfo;
import com.dinner.snqjf.back.dao.UserInfoDao;

/**
 *@author linzf
 **/
@Service("userInfoService")
@Transactional(rollbackFor={IllegalArgumentException.class})
public class UserInfoService extends GenericService<UserInfo, QueryUserInfo> {
	@Autowired
	@SuppressWarnings("SpringJavaAutowiringInspection")
	private UserInfoDao userInfoDao;
	@Override
	protected GenericDao<UserInfo, QueryUserInfo> getDao() {
		return userInfoDao;
	}
}