package me.jovi.hellospring.controller;

import me.jovi.hellospring.entity.ReqResult;
import me.jovi.hellospring.entity.User;
import me.jovi.hellospring.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
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
        //boolean result = userService.checkPassword(user);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getLoginName(), user.getPassword());

        try {
            subject.login(token);

            return ReqResult.success("登录成功");
        } catch (UnknownAccountException ue) {
            return ReqResult.failure("用户名/密码错误");
        } catch (IncorrectCredentialsException ie){
            return ReqResult.failure("用户名/密码错误");
        } catch (AuthenticationException ae){
            return ReqResult.failure("账号状态异常");
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
