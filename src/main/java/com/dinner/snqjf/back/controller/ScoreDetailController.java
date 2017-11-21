package com.dinner.snqjf.back.controller;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import com.dinner.snqjf.common.base.controller.GenericController;
import com.dinner.snqjf.common.base.service.GenericService;

import com.dinner.snqjf.back.entity.ScoreDetail;
import com.dinner.snqjf.back.entity.QueryScoreDetail;
import com.dinner.snqjf.back.service.ScoreDetailService;

/**
 *@author linzf
 **/
@Controller
@RequestMapping("/scoreDetail")
public class ScoreDetailController extends GenericController<ScoreDetail, QueryScoreDetail> {
	@Inject
	private ScoreDetailService scoreDetailService;
	@Override
	protected GenericService<ScoreDetail, QueryScoreDetail> getService() {
		return scoreDetailService;
	}
}