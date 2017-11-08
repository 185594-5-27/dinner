package com.dinner.snqjf.back.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import com.dinner.snqjf.common.base.service.GenericService;
import com.dinner.snqjf.common.base.dao.GenericDao;

import com.dinner.snqjf.back.entity.Diner;
import com.dinner.snqjf.back.entity.QueryDiner;
import com.dinner.snqjf.back.dao.DinerDao;

/**
 *@author linzf
 **/
@Service("dinerService")
@Transactional(rollbackFor={IllegalArgumentException.class})
public class DinerService extends GenericService<Diner, QueryDiner> {
	@Autowired
	@SuppressWarnings("SpringJavaAutowiringInspection")
	private DinerDao dinerDao;
	@Override
	protected GenericDao<Diner, QueryDiner> getDao() {
		return dinerDao;
	}
}