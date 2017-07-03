package me.jovi.hellospring.controller.config;

import me.jovi.hellospring.entity.ReqResult;
import me.jovi.hellospring.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by fanjiawei on 2017/7/3.
 */
@RequestMapping(value = "/config/permission")
@Controller
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    @RequestMapping(value = "")
    public String gotoPermissionListPage(){
        return "config/permission/permission-list";
    }

    /**
     * 获取所有角色
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getPermissionList")
    public ReqResult<?> getPermissionList(){
        return ReqResult.success(permissionService.getPermissionList());
    }
}
