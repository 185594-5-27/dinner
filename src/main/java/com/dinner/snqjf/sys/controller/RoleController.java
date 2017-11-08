package com.dinner.snqjf.sys.controller;

import com.dinner.snqjf.common.base.constant.SystemStaticConst;
import com.dinner.snqjf.common.base.controller.GenericController;
import com.dinner.snqjf.common.base.service.GenericService;
import com.dinner.snqjf.sys.entity.QueryUserRole;
import com.dinner.snqjf.sys.entity.Tree;
import com.dinner.snqjf.sys.entity.UserRole;
import com.dinner.snqjf.sys.mapper.TreeMapper;
import com.dinner.snqjf.sys.service.TreeService;
import com.dinner.snqjf.sys.service.UserRoleService;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
* 类描述：
* @auther linzf
* @create 2017/10/10 0010 
*/
@Controller
@RequestMapping("/role")
public class RoleController extends GenericController<UserRole,QueryUserRole> {

    @Inject
    private UserRoleService userRoleService;

    @Inject
    private TreeService treeService;

    @Inject
    private TreeMapper treeMapper;

    @Override
    protected GenericService<UserRole, QueryUserRole> getService() {
        return userRoleService;
    }

    /**
     * 功能描述：根据用户的权限去加载角色数据
     * @return
     */
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @RequestMapping(value = "/loadRoleTree",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String,Object> loadRoleTree(UserRole entity){
        entity = userRoleService.get(entity);
        List<Tree> treeList = treeService.query(null);
        for(Tree tree:entity.getTreeList()){
            treeList.stream().forEach(t->{
                if(t.getId()==tree.getId()){
                    t.setChecked(true);
                }
            });
        }
        Map<String,Object> result = new HashMap<String, Object>();
        result.put(SystemStaticConst.RESULT, SystemStaticConst.SUCCESS);
        result.put("data",treeMapper.treesToTressDTOs(treeList));
        return result;
    }

}
