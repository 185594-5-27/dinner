package com.dinner.snqjf.back.controller;

import com.dinner.snqjf.back.entity.*;
import com.dinner.snqjf.back.service.*;
import com.dinner.snqjf.common.base.constant.SystemStaticConst;
import net.sf.json.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.Map;

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
