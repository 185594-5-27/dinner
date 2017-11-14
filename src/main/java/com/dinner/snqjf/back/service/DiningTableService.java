package com.dinner.snqjf.back.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import com.dinner.snqjf.common.base.service.GenericService;
import com.dinner.snqjf.common.base.dao.GenericDao;

import com.dinner.snqjf.back.entity.DiningTable;
import com.dinner.snqjf.back.entity.QueryDiningTable;
import com.dinner.snqjf.back.dao.DiningTableDao;

/**
 *@author linzf
 **/
@Service("diningTableService")
@Transactional(rollbackFor={IllegalArgumentException.class})
public class DiningTableService extends GenericService<DiningTable, QueryDiningTable> {
	@Autowired
	@SuppressWarnings("SpringJavaAutowiringInspection")
	private DiningTableDao diningTableDao;
	@Override
	protected GenericDao<DiningTable, QueryDiningTable> getDao() {
		return diningTableDao;
	}
}