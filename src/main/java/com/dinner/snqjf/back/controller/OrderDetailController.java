package com.dinner.snqjf.back.controller;

import javax.inject.Inject;

import com.dinner.snqjf.back.entity.Order;
import com.dinner.snqjf.back.service.OrderService;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import com.dinner.snqjf.common.base.controller.GenericController;
import com.dinner.snqjf.common.base.service.GenericService;

import com.dinner.snqjf.back.entity.OrderDetail;
import com.dinner.snqjf.back.entity.QueryOrderDetail;
import com.dinner.snqjf.back.service.OrderDetailService;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *@author linzf
 **/
@Controller
@RequestMapping("/orderDetail")
public class OrderDetailController extends GenericController<OrderDetail, QueryOrderDetail> {
	@Inject
	private OrderDetailService orderDetailService;
	@Inject
	private OrderService orderService;
	@Override
	protected GenericService<OrderDetail, QueryOrderDetail> getService() {
		return orderDetailService;
	}

	/**
	 * 功能描述：直接跳转到更新数据的页面
	 * @return
	 */
	@RequestMapping(value = "/toOrderDetail",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public ModelAndView toOrderDetail(Order entity) throws Exception{
		entity = orderService.get(entity);
		return new ModelAndView("/back/orderDetail/orderDetail","entity",entity);
	}
}