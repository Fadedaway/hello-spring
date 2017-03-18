package me.jovi.hellospring.controller;

import me.jovi.hellospring.entity.User;
import me.jovi.hellospring.repositoryies.UserRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;

/**
 * Created by joyce on 2017/3/14.
 */
@Controller
public class HelloController {

    protected static final Logger logger = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    private UserRepo userRepo;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    //@ResponseBody
    public String helloWorld(Model model){
        logger.info("In HelloController: >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> Have you seen!");
        User user = new User();

        user.setName("Jovi Van (发发)");
//        user.setPhone("18084475738");
        model.addAttribute("user",user);
        return "hello";
        //return "你好," + "世界！";
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.GET)
    public void addUser(){
        User user = new User();

        user.setName("测试");
        user.setAge(11);
        user.setSex(0);
        user.setLoginName("jj123");
        user.setPassword("hello123");

        userRepo.save(user);
    }

//    @RequestMapping(value = "/", method = RequestMethod.GET)
//    public String index(){
//        return "index";
//    }
}
