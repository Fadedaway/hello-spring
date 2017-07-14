package me.jovi.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by fanjiawei on 2017/7/13.
 */
@Controller
@RequestMapping("/error")
public class ErrorController {

    @RequestMapping(value = "/unauthorized", method = RequestMethod.GET)
    public String unauthorized(){
        return "error/unauthorized";
    }

    @RequestMapping(value = "/error404", method = RequestMethod.GET)
    public String error404(){
        return "error/error404";
    }

    @RequestMapping(value = "/error500", method = RequestMethod.GET)
    public String error500(){
        return "error/error500";
    }
}
