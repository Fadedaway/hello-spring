package me.jovi.hellospring.controller.config;

import me.jovi.hellospring.entity.ReqResult;
import me.jovi.hellospring.entity.Role;
import me.jovi.hellospring.service.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by joyce on 2017/6/28.
 */
@Controller
@RequestMapping(value = "/config/role")
public class RoleController {

    private static final Logger LOGGER = LoggerFactory.getLogger(RoleController.class);

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

    @RequestMapping(value = "/getRoleWithAuthStatus", method = RequestMethod.GET)
    @ResponseBody
    public ReqResult<?> getRoleWithAuthStatus(String userId){
        return ReqResult.success(roleService.getRoleWithAuthStatus(userId));
    }

    @RequestMapping(value = "/authRole", method = RequestMethod.POST)
    @ResponseBody
    public ReqResult<?> authRole(String ids, String userId){
        try{
            roleService.authRole(ids,userId);
            return ReqResult.success("授权成功！");
        }catch (Exception e){
            LOGGER.error(e.getMessage(), e);
            return ReqResult.failure("授权失败！");
        }
    }

    /**
     * 跳转至分配许可页面
     * @param id
     * @return
     * @author jovi
     */
    @RequestMapping(value = "/authPermission", method = RequestMethod.GET)
    public ModelAndView authPermission(String id){
        ModelAndView mav = new ModelAndView("config/role/role-auth-list");
        mav.addObject("id",id);
        return mav;
    }
}
