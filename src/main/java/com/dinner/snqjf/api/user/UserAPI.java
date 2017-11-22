package com.dinner.snqjf.api.user;

import com.dinner.snqjf.api.entity.MobileUserLogin;
import com.dinner.snqjf.back.service.MobileUserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/api/user")
public class UserAPI {

    @Inject
    private MobileUserService mobileUserService;

    /**
     * 功能描述：实现移动端客户登陆的接口
     * @return
     */
    @RequestMapping(value = "/userLogin",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String,Object> userLogin(MobileUserLogin entity){
        Map<String,Object> result = new HashMap<String, Object>();

        return result;
    }

}
