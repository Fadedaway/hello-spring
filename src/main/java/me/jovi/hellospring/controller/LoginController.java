package me.jovi.hellospring.controller;

import me.jovi.hellospring.entity.ReqResult;
import me.jovi.hellospring.entity.User;
import me.jovi.hellospring.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by joyce on 2017/4/1.
 */
@Controller
@RequestMapping(value = "/user")
public class LoginController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/doLogin")
    @ResponseBody
    public ReqResult doLogin(User user){
        boolean result = userService.checkPassword(user);

        if (result){
            return ReqResult.success("登录成功！");
        }else{
            return ReqResult.failure("登录失败！");
        }
    }

    @RequestMapping(value = "/main")
    public String toMainPage(){
        return "main";
    }

    @RequestMapping(value = "/gotoRegister")
    public String toRegister(){
        return "register";
    }

    @RequestMapping(value = "/doRegister")
    @ResponseBody
    public ReqResult doRegister(User user){
        try{
            userService.addUser(user);
            return ReqResult.success("注册成功！");
        }catch (Exception e){
            LOGGER.error("注册失败："+e.getMessage());
            return ReqResult.failure("注册失败："+e.getMessage());
        }

    }
}
