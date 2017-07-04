package me.jovi.hellospring.controller.config;

import me.jovi.hellospring.entity.Permission;
import me.jovi.hellospring.entity.ReqResult;
import me.jovi.hellospring.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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

    @RequestMapping(value = "/addPermission", method = RequestMethod.GET)
    public String addPermission(){
        return "config/permission/permission-add";
    }

    @RequestMapping(value = "/addPermission", method = RequestMethod.POST)
    @ResponseBody
    public ReqResult<?> addPermission(Permission permission){
        permissionService.addPermission(permission);
        return ReqResult.success("新增许可成功！");
    }

    @RequestMapping(value = "/editPermission", method = RequestMethod.GET)
    public ModelAndView editPermission(String id){
        ModelAndView mav = new ModelAndView("config/permission/permission-edit");
        mav.addObject("id", id);
        return mav;
    }

    @RequestMapping(value = "/editPermission", method = RequestMethod.POST)
    @ResponseBody
    public ReqResult<?> editPermission(Permission permission){
        permissionService.editPermission(permission);
        return ReqResult.success("更新许可成功！");
    }

    @ResponseBody
    @RequestMapping(value = "/getPermissionById", method = RequestMethod.GET)
    public ReqResult<?> getPermissionById(String id){
        return ReqResult.success(permissionService.getPermissionById(id));
    }

    @ResponseBody
    @RequestMapping(value = "/deletePermissionById")
    public ReqResult<?> deletePermissionById(String id){
        permissionService.deletePermissionById(id);
        return ReqResult.success("删除成功！");
    }

    @RequestMapping(value = "/viewPermission", method = RequestMethod.GET)
    public ModelAndView viewPermission(String id){
        ModelAndView mav = new ModelAndView("config/permission/permission-view");
        mav.addObject("id",id);
        return mav;
    }
}
