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
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

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
    public  String toMainPage(){
        return "main";
    }
}
