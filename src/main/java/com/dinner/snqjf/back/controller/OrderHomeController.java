package com.dinner.snqjf.back.controller;

import com.dinner.snqjf.back.entity.*;
import com.dinner.snqjf.back.service.*;
import com.dinner.snqjf.common.base.constant.SystemStaticConst;
import com.dinner.snqjf.sys.service.WebsocketService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
import java.util.*;

/*
* 类描述：实现点菜员在线点菜
* @auther linzf
* @create 2017/11/13 0013 
*/
@Controller
@RequestMapping("/orderHome")
public class OrderHomeController {

    @Inject
    private DinerService dinerService;

    @Inject
    private FoodTypeService foodTypeService;

    @Inject
    private DiningTableService diningTableService;

    @Inject
    private OrderService orderService;

    @Inject
    private OrderDetailService orderDetailService;

    @Inject
    private OrderHomeService orderHomeService;

    @Inject
    private WebsocketService websocketService;

    /**
     * 功能描述：提交订单数据
     *
     * @return
     */
    @RequestMapping(value = "/submitOrder",  method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String, Object> submitOrder(DiningTable entity) throws Exception {
        Map<String, Object> result = new HashMap<String, Object>();
        String orderId = entity.getOrderId()+"";
        entity = orderHomeService.submitOrder(entity);
        if(entity!=null){
            if(orderId.equalsIgnoreCase("0")){
                orderId = entity.getOrderId()+"";
            }
            // 下单成功，推送消息到前端来实现订单明细的打印功能
            websocketService.printOrder(orderId,entity.getOrderDetailId());
            result.put(SystemStaticConst.RESULT,SystemStaticConst.SUCCESS);
            result.put(SystemStaticConst.MSG,"下单成功！");
        }else{
            result.put(SystemStaticConst.RESULT,SystemStaticConst.FAIL);
            result.put(SystemStaticConst.MSG,"下单失败！");
        }
        return result;
    }

    /**
     * 功能描述：根据桌号来获取订单数据
     *
     * @return
     */
    @RequestMapping(value = "/getOrderByDiningTable",  method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String, Object> getOrderByDiningTable(DiningTable entity){
        Map<String, Object> result = new HashMap<String, Object>();
        result.put(SystemStaticConst.RESULT,SystemStaticConst.FAIL);
        entity = diningTableService.get(entity);
        if(entity.getOrderId()!=0){
            Order order = new Order();
            order.setId(entity.getOrderId());
            order = orderService.get(order);
            if(order!=null&&order.getState().equals(Order.STATE_PENDING_PAY)){
                result.put(SystemStaticConst.RESULT,SystemStaticConst.SUCCESS);
                OrderDetail orderDetail = new OrderDetail();
                orderDetail.setOrderId(order.getId());
                result.put("data",orderDetailService.getOrderDetailByOrderId(orderDetail));
            }
        }
        return result;
    }

    /**
     * 功能描述：跳转到点餐页面
     *
     * @return
     */
    @RequestMapping(value = "/toOrderHome", method = RequestMethod.GET)
    public ModelAndView orderHome(DiningTable entity){
        return new ModelAndView("/back/orderHome/main","entity",diningTableService.get(entity));
    }

    /**
     * 功能描述：加载餐桌数据
     *
     * @return
     */
    @RequestMapping(value = "/loadDiningTable", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String, Object> loadDiningTable(){
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("data",diningTableService.query(null));
        return result;
    }

    /**
     * 功能描述：加载菜单数据
     *
     * @return
     */
    @RequestMapping(value = "/loadDiner", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String, Object> loadDiner() {
        Map<String, Object> result = new HashMap<String, Object>();
        JSONObject jobj = new JSONObject();
        QueryDiner query = null;
        for (FoodType f : foodTypeService.loadAll()) {
            query = new QueryDiner();
            query.setGoodTypeId(f.getId());
            jobj.put(f.getType(),dinerService.query(query));
        }
        result.put("data",jobj.toString());
        return result;
    }


}
