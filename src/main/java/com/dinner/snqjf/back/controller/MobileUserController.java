package com.dinner.snqjf.back.controller;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import com.dinner.snqjf.common.base.controller.GenericController;
import com.dinner.snqjf.common.base.service.GenericService;

import com.dinner.snqjf.back.entity.MobileUser;
import com.dinner.snqjf.back.entity.QueryMobileUser;
import com.dinner.snqjf.back.service.MobileUserService;

/**
 *@author linzf
 **/
@Controller
@RequestMapping("/mobileUser")
public class MobileUserController extends GenericController<MobileUser, QueryMobileUser> {
	@Inject
	private MobileUserService mobileUserService;
	@Override
	protected GenericService<MobileUser, QueryMobileUser> getService() {
		return mobileUserService;
	}
}