package com.dinner.snqjf.back.controller;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import com.dinner.snqjf.common.base.controller.GenericController;
import com.dinner.snqjf.common.base.service.GenericService;

import com.dinner.snqjf.back.entity.UserInfo;
import com.dinner.snqjf.back.entity.QueryUserInfo;
import com.dinner.snqjf.back.service.UserInfoService;

/**
 *@author linzf
 **/
@Controller
@RequestMapping("/userInfo")
public class UserInfoController extends GenericController<UserInfo, QueryUserInfo> {
	@Inject
	private UserInfoService userInfoService;
	@Override
	protected GenericService<UserInfo, QueryUserInfo> getService() {
		return userInfoService;
	}
}