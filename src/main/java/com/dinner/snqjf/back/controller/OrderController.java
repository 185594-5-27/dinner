package com.dinner.snqjf.back.controller;

import javax.inject.Inject;

import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import com.dinner.snqjf.common.base.controller.GenericController;
import com.dinner.snqjf.common.base.service.GenericService;

import com.dinner.snqjf.back.entity.Order;
import com.dinner.snqjf.back.entity.QueryOrder;
import com.dinner.snqjf.back.service.OrderService;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *@author linzf
 **/
@Controller
@RequestMapping("/order")
public class OrderController extends GenericController<Order, QueryOrder> {
	@Inject
	private OrderService orderService;
	@Override
	protected GenericService<Order, QueryOrder> getService() {
		return orderService;
	}

	/**
	 * 功能描述：直接跳转到更新数据的页面
	 * @param entity
	 * @return
	 */
	@RequestMapping(value = "/toCheckout",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public String toCheckout(Order entity,Model model) throws Exception{
		entity = orderService.get(entity);
		model.addAttribute("entity",entity);
		return getPageBaseRoot()+"/checkout";
	}
}