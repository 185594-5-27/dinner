package com.dinner.snqjf.back.controller;

import javax.inject.Inject;

import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import com.dinner.snqjf.common.base.controller.GenericController;
import com.dinner.snqjf.common.base.service.GenericService;

import com.dinner.snqjf.back.entity.MobileUser;
import com.dinner.snqjf.back.entity.QueryMobileUser;
import com.dinner.snqjf.back.service.MobileUserService;
import org.springframework.web.bind.annotation.RequestMethod;

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

	/**
	 * 功能描述：跳转到查看积分明细的页面
	 * @param entity
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/toUserScoreDetailList",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public String toUserScoreDetailList(MobileUser entity,Model model) throws Exception {
		model.addAttribute("entity",entity);
		return getPageBaseRoot()+"/userScoreDetailList";
	}
}