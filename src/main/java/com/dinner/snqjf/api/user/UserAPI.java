package com.dinner.snqjf.api.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/api/user")
public class UserAPI {

    /**
     * 功能描述：实现移动端客户登陆的接口
     * @return
     */
    public Map<String,Object> userLogin(){
        Map<String,Object> result = new HashMap<String, Object>();

        return result;
    }

}
