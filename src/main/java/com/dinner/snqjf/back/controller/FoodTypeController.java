package com.dinner.snqjf.back.controller;

import javax.inject.Inject;

import com.dinner.snqjf.common.base.constant.SystemStaticConst;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import com.dinner.snqjf.common.base.controller.GenericController;
import com.dinner.snqjf.common.base.service.GenericService;

import com.dinner.snqjf.back.entity.FoodType;
import com.dinner.snqjf.back.entity.QueryFoodType;
import com.dinner.snqjf.back.service.FoodTypeService;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	@RequestMapping(value = "/loadAllFoodType",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Map<String,Object> loadAllFoodType(){
		Map<String,Object> result = new HashMap<String, Object>();
		List<FoodType> foodTypeList =foodTypeService.query(new QueryFoodType());
		result.put(SystemStaticConst.RESULT,SystemStaticConst.SUCCESS);
		result.put("entity",foodTypeList);
		return result;
	}
}