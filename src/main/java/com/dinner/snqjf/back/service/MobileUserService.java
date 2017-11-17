package com.dinner.snqjf.back.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import com.dinner.snqjf.common.base.service.GenericService;
import com.dinner.snqjf.common.base.dao.GenericDao;

import com.dinner.snqjf.back.entity.MobileUser;
import com.dinner.snqjf.back.entity.QueryMobileUser;
import com.dinner.snqjf.back.dao.MobileUserDao;

/**
 *@author linzf
 **/
@Service("mobileUserService")
@Transactional(rollbackFor={IllegalArgumentException.class})
public class MobileUserService extends GenericService<MobileUser, QueryMobileUser> {
	@Autowired
	@SuppressWarnings("SpringJavaAutowiringInspection")
	private MobileUserDao mobileUserDao;
	@Override
	protected GenericDao<MobileUser, QueryMobileUser> getDao() {
		return mobileUserDao;
	}
}