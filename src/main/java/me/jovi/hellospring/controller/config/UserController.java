package me.jovi.hellospring.controller.config;

import me.jovi.hellospring.entity.ReqResult;
import me.jovi.hellospring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by fanjiawei on 2017/7/4.
 */
@Controller
@RequestMapping(value = "/config/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String gotoUserListPage(){
        return "config/user/user-list";
    }

    @ResponseBody
    @RequestMapping(value = "/getUserList", method = RequestMethod.GET)
    public ReqResult<?> getUserList(){
        return ReqResult.success(userService.getUserList());
    }

    @ResponseBody
    @RequestMapping(value = "/deleteUserById")
    public ReqResult<?> deleteUserById(String id){
        userService.deleteUserById(id);
        return ReqResult.success("删除成功！");
    }

    @RequestMapping(value = "/getUserById", method = RequestMethod.GET)
    @ResponseBody
    public ReqResult<?> getUserById(String id){
        return ReqResult.success(userService.getUserById(id));
    }

    @RequestMapping(value = "/viewUser", method = RequestMethod.GET)
    public ModelAndView viewUser(String id){
        ModelAndView mav = new ModelAndView("config/user/user-view");
        mav.addObject("id", id);
        return mav;
    }

    @RequestMapping(value = "/authUser", method = RequestMethod.GET)
    public ModelAndView authUser(String id){
        ModelAndView mav = new ModelAndView("config/user/user-auth-list");
        mav.addObject("id", id);
        return mav;
    }

}
