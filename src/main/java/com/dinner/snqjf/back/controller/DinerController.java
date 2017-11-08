package com.dinner.snqjf.back.controller;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import com.dinner.snqjf.common.base.controller.GenericController;
import com.dinner.snqjf.common.base.service.GenericService;

import com.dinner.snqjf.back.entity.Diner;
import com.dinner.snqjf.back.entity.QueryDiner;
import com.dinner.snqjf.back.service.DinerService;

/**
 *@author linzf
 **/
@Controller
@RequestMapping("/diner")
public class DinerController extends GenericController<Diner, QueryDiner> {
	@Inject
	private DinerService dinerService;
	@Override
	protected GenericService<Diner, QueryDiner> getService() {
		return dinerService;
	}
}