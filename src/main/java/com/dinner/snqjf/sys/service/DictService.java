package com.dinner.snqjf.sys.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dinner.snqjf.common.base.service.GenericService;
import com.dinner.snqjf.common.base.dao.GenericDao;

import com.dinner.snqjf.sys.entity.Dict;
import com.dinner.snqjf.sys.entity.QueryDict;
import com.dinner.snqjf.sys.dao.DictDao;
import org.springframework.transaction.annotation.Transactional;

/**
 *@author linzf
 **/
@Service("dictService")
@Transactional(rollbackFor={IllegalArgumentException.class})
public class DictService extends GenericService<Dict, QueryDict> {
	@Autowired
	@SuppressWarnings("SpringJavaAutowiringInspection")
	private DictDao dictDao;
	@Override
	protected GenericDao<Dict, QueryDict> getDao() {
		return dictDao;
	}
}