package com.dinner.snqjf.back.controller;

import javax.inject.Inject;

import com.dinner.snqjf.back.entity.OrderDetail;
import com.dinner.snqjf.back.service.OrderDetailService;
import com.dinner.snqjf.common.base.constant.SystemStaticConst;
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
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *@author linzf
 **/
@Controller
@RequestMapping("/order")
public class OrderController extends GenericController<Order, QueryOrder> {
	@Inject
	private OrderService orderService;
	@Inject
	private OrderDetailService orderDetailService;
	@Override
	protected GenericService<Order, QueryOrder> getService() {
		return orderService;
	}

	/**
	 * 功能描述：根据订单号来查找订单消费明细
	 * @param entity
	 * @return
	 */
	@RequestMapping(value = "/getOrderDetailByOrderId",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public  Map<String,Object> getOrderDetailByOrderId(OrderDetail entity){
		Map<String,Object> result = new HashMap<String, Object>();
		result.put(SystemStaticConst.RESULT,SystemStaticConst.SUCCESS);
		result.put(SystemStaticConst.MSG,"获取订单数据成功！");
		result.put("data",orderDetailService.getOrderDetailByOrderId(entity));
		return result;
	}

	/**
	 * 功能描述：实现订单的结账处理
	 * @param entity
	 * @return
	 */
	@RequestMapping(value = "/cancelOrder",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Map<String,Object> cancelOrder(Order entity){
		Map<String,Object> result = new HashMap<String, Object>();
		if(orderService.cancelOrder(entity)){
			result.put(SystemStaticConst.RESULT,SystemStaticConst.SUCCESS);
			result.put(SystemStaticConst.MSG,"取消订单成功！");
		}else{
			result.put(SystemStaticConst.RESULT,SystemStaticConst.FAIL);
			result.put(SystemStaticConst.MSG,"取消订单失败！");
		}
		return result;
	}

	/**
	 * 功能描述：实现订单的结账处理
	 * @param entity
	 * @return
	 */
	@RequestMapping(value = "/checkout",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Map<String,Object> checkout(Order entity){
		Map<String,Object> result = new HashMap<String, Object>();
		if(orderService.checkout(entity)){
			result.put(SystemStaticConst.RESULT,SystemStaticConst.SUCCESS);
			result.put(SystemStaticConst.MSG,"订单结账成功！");
		}else{
			result.put(SystemStaticConst.RESULT,SystemStaticConst.FAIL);
			result.put(SystemStaticConst.MSG,"订单结账失败！");
		}
		return result;
	}

	/**
	 * 功能描述：直接跳转到结账页面
	 * @param entity
	 * @return
	 */
	@RequestMapping(value = "/toCheckout",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public String toCheckout(Order entity,Model model) throws Exception{
		entity = orderService.get(entity);
		OrderDetail orderDetail = new OrderDetail();
		orderDetail.setOrderId(entity.getId());
		int orderPrice = 0;
		for(OrderDetail o:orderDetailService.getOrderDetailByOrderId(orderDetail)){
            if(o.getIsPreferential().equalsIgnoreCase(OrderDetail.ORDER_DETAIL_HAS_PREFERENTIAL)){
				orderPrice = orderPrice + o.getNum() * Integer.parseInt(o.getPreferentialPrice());
			}else{
				orderPrice = orderPrice + o.getNum() * Integer.parseInt(o.getPrice());
			}
		}
		entity.setOrderPrice(orderPrice+"");
		entity.setRealIncome(orderPrice+"");
		model.addAttribute("entity",entity);
		return getPageBaseRoot()+"/checkout";
	}
}