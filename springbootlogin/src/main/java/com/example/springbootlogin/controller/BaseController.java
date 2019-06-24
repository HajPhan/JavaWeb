package com.example.springbootlogin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BaseController {
    @RequestMapping(value = {"/","/login"})
    public String login(){
        return "login";
    }

    @RequestMapping(value = "/user")
    public String user(){
        return "user";
    }

    @RequestMapping(value = "/admin")
    public String admin(){
        return "admin";
    }

    @RequestMapping("/403")
    public String accessDenied(){
        return "403";
    }
}
