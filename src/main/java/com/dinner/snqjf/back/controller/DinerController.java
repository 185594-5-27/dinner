package com.dinner.snqjf.back.controller;

import javax.inject.Inject;

import com.dinner.snqjf.back.entity.FoodType;
import com.dinner.snqjf.back.service.FoodTypeService;
import com.dinner.snqjf.common.util.user.UserInfo;
import com.dinner.snqjf.sys.entity.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import com.dinner.snqjf.common.base.controller.GenericController;
import com.dinner.snqjf.common.base.service.GenericService;

import com.dinner.snqjf.back.entity.Diner;
import com.dinner.snqjf.back.entity.QueryDiner;
import com.dinner.snqjf.back.service.DinerService;

import java.util.Date;
import java.util.Map;

/**
 *@author linzf
 **/
@Controller
@RequestMapping("/diner")
public class DinerController extends GenericController<Diner, QueryDiner> {
	@Inject
	private DinerService dinerService;
	@Inject
	private FoodTypeService foodTypeService;

	@Override
	protected GenericService<Diner, QueryDiner> getService() {
		return dinerService;
	}

	@Override
	public Map<String, Object> save(Diner entity) throws Exception {
		User user = UserInfo.getUser();
		entity.setCreateTime(new Date());
		entity.setCreateUser(user.getUserName());
		entity.setCreateUserId(user.getId());
		FoodType foodType = new FoodType();
		foodType.setId(entity.getGoodTypeId());
		foodType = foodTypeService.get(foodType);
		entity.setGoodTypeName(foodType.getType());

		return super.save(entity);
	}


}