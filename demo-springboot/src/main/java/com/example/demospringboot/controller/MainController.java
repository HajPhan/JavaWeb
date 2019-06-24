package com.example.demospringboot.controller;

import com.example.demospringboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    private final static String URL_API_USER = "http://localhost:8081/api/user/";

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/home")
    public String home(){
        return "home";
    }

    @RequestMapping(value = "/userInfo")
    public String userList(Model model){
        model.addAttribute("userList",this.userService.getAllUser());
        return "user-info";
    }

    @RequestMapping(value = "/login")
    public String loginPage(){
        return "login-page";
    }

    @RequestMapping(value = "/403")
    public String errorPage(){
        return "/403-page";
    }
}
