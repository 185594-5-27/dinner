package com.dinner.snqjf.back.controller;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import com.dinner.snqjf.common.base.controller.GenericController;
import com.dinner.snqjf.common.base.service.GenericService;

import com.dinner.snqjf.back.entity.FoodType;
import com.dinner.snqjf.back.entity.QueryFoodType;
import com.dinner.snqjf.back.service.FoodTypeService;

/**
 *@author linzf
 **/
@Controller
@RequestMapping("/foodType")
public class FoodTypeController extends GenericController<FoodType, QueryFoodType> {
	@Inject
	private FoodTypeService foodTypeService;
	@Override
	protected GenericService<FoodType, QueryFoodType> getService() {
		return foodTypeService;
	}
}