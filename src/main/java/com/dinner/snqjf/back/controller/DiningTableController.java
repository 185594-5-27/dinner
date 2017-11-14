package com.dinner.snqjf.back.controller;

import javax.inject.Inject;

import com.dinner.snqjf.common.util.user.UserInfo;
import com.dinner.snqjf.sys.entity.User;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import com.dinner.snqjf.common.base.controller.GenericController;
import com.dinner.snqjf.common.base.service.GenericService;

import com.dinner.snqjf.back.entity.DiningTable;
import com.dinner.snqjf.back.entity.QueryDiningTable;
import com.dinner.snqjf.back.service.DiningTableService;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.Map;

/**
 *@author linzf
 **/
@Controller
@RequestMapping("/diningTable")
public class DiningTableController extends GenericController<DiningTable, QueryDiningTable> {
	@Inject
	private DiningTableService diningTableService;
	@Override
	protected GenericService<DiningTable, QueryDiningTable> getService() {
		return diningTableService;
	}

	/**
	 * 功能描述：根据餐桌流水来获取餐桌数据
	 * @param entity
	 * @return
	 */
	@RequestMapping(value = "/getDiningTable",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public DiningTable getDiningTable(DiningTable entity){
		return diningTableService.get(entity);
	}

	/**
	 * 功能描述：增加桌子数据
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	@Override
	public Map<String, Object> save(DiningTable entity) throws Exception {
		entity.setState(DiningTable.STATE_WAIT_USE);
		User user = UserInfo.getUser();
		entity.setCrtDate(new Date());
		entity.setCrtUser(user.getUserName());
		entity.setCrtUserId(user.getId());
		return super.save(entity);
	}
}