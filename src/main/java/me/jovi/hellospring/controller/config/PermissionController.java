package me.jovi.hellospring.controller.config;

import me.jovi.hellospring.entity.Permission;
import me.jovi.hellospring.entity.ReqResult;
import me.jovi.hellospring.service.PermissionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger LOGGER = LoggerFactory.getLogger(PermissionController.class);

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

    /**
     * 获取角色下的所有许可
     * @param roleId
     * @return
     * @author jovi
     */
    @RequestMapping(value = "/getPermissionWithAuthStatus", method = RequestMethod.GET)
    @ResponseBody
    public ReqResult<?> getPermissionWithAuthStatus(String roleId){
        try{
            LOGGER.info("开始查询许可列表......");
            return ReqResult.success(permissionService.getPermissionWithAuthStatus(roleId));
        }catch (Exception e){
            LOGGER.error(e.getMessage(), e);
            return ReqResult.failure("获取许可列表异常！");
        }
    }

    /**
     * 给角色分配许可
     * @param roleId
     * @param ids
     * @return
     * @author jovi
     */
    @RequestMapping(value = "/authPermission", method = RequestMethod.POST)
    @ResponseBody
    public ReqResult<?> authPermission(String roleId, String ids){
        try{
            permissionService.authPermission(roleId,ids);
            return ReqResult.success("授权成功！");
        }catch (Exception e){
            LOGGER.error(e.getMessage(), e);
            return ReqResult.failure("授权失败！");
        }
    }
}
