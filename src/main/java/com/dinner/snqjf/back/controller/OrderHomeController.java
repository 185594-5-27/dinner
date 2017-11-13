package com.dinner.snqjf.back.controller;

import com.dinner.snqjf.back.entity.Diner;
import com.dinner.snqjf.back.entity.FoodType;
import com.dinner.snqjf.back.entity.QueryDiner;
import com.dinner.snqjf.back.service.DinerService;
import com.dinner.snqjf.back.service.FoodTypeService;
import net.sf.json.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
