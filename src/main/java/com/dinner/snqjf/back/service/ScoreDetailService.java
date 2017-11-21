package com.dinner.snqjf.back.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import com.dinner.snqjf.common.base.service.GenericService;
import com.dinner.snqjf.common.base.dao.GenericDao;

import com.dinner.snqjf.back.entity.ScoreDetail;
import com.dinner.snqjf.back.entity.QueryScoreDetail;
import com.dinner.snqjf.back.dao.ScoreDetailDao;

/**
 *@author linzf
 **/
@Service("scoreDetailService")
@Transactional(rollbackFor={IllegalArgumentException.class})
public class ScoreDetailService extends GenericService<ScoreDetail, QueryScoreDetail> {
	@Autowired
	@SuppressWarnings("SpringJavaAutowiringInspection")
	private ScoreDetailDao scoreDetailDao;
	@Override
	protected GenericDao<ScoreDetail, QueryScoreDetail> getDao() {
		return scoreDetailDao;
	}
}