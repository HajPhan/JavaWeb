package com.example.springsecurity02mysql.controller;

import com.example.springsecurity02mysql.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping(value = {"/", "/home"})
    public String home() {
        return "home";
    }

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/test")
    public String test(Model model){
        model.addAttribute("listUser",userService.getUserByName("haipv"));
        return "test";
    }
}
