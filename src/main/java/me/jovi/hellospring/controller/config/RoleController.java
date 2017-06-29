package me.jovi.hellospring.controller.config;

import me.jovi.hellospring.entity.ReqResult;
import me.jovi.hellospring.entity.Role;
import me.jovi.hellospring.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by joyce on 2017/6/28.
 */
@Controller
@RequestMapping(value = "/config/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping(value = "")
    public String gotoRoleListPage(){
        return "config/role/role-list";
    }

    /**
     * 获取所有角色
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getRoleList")
    public ReqResult<?> getRoleList(){
        return ReqResult.success(roleService.getRoleList());
    }

    @RequestMapping(value = "/addRole", method = RequestMethod.GET)
    public String addRole(){
        return "config/role/role-add";
    }

    @RequestMapping(value = "/addRole", method = RequestMethod.POST)
    @ResponseBody
    public ReqResult<?> addRole(Role role){
        roleService.addRole(role);
        return ReqResult.success("保存成功！");
    }

    @ResponseBody
    @RequestMapping(value = "/deleteRoleById")
    public ReqResult<?> deleteRoleById(String id){
        roleService.deleteRoleById(id);
        return ReqResult.success("删除成功！");
    }

    @RequestMapping(value = "/editRole", method = RequestMethod.GET)
    public ModelAndView editRole(String id){
        ModelAndView mav = new ModelAndView("config/role/role-edit");
        mav.addObject("id", id);
        return mav;
    }

    @RequestMapping(value = "/editRole", method = RequestMethod.POST)
    @ResponseBody
    public ReqResult<?> editRole(Role role){
        roleService.editRole(role);
        return ReqResult.success("角色更新成功！");
    }

    @RequestMapping(value = "/getRoleById", method = RequestMethod.GET)
    @ResponseBody
    public ReqResult<?> getRoleById(String id){
        return ReqResult.success(roleService.getRoleById(id));
    }

    @RequestMapping(value = "/viewRole", method = RequestMethod.GET)
    public ModelAndView viewRole(String id){
        ModelAndView mav = new ModelAndView("config/role/role-view");
        mav.addObject("id", id);
        return mav;
    }
}
