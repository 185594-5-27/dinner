package com.dinner.snqjf.back.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import com.dinner.snqjf.common.base.service.GenericService;
import com.dinner.snqjf.common.base.dao.GenericDao;

import com.dinner.snqjf.back.entity.FoodType;
import com.dinner.snqjf.back.entity.QueryFoodType;
import com.dinner.snqjf.back.dao.FoodTypeDao;

/**
 *@author linzf
 **/
@Service("foodTypeService")
@Transactional(rollbackFor={IllegalArgumentException.class})
public class FoodTypeService extends GenericService<FoodType, QueryFoodType> {
	@Autowired
	@SuppressWarnings("SpringJavaAutowiringInspection")
	private FoodTypeDao foodTypeDao;
	@Override
	protected GenericDao<FoodType, QueryFoodType> getDao() {
		return foodTypeDao;
	}
}