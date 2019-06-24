package com.example.springsecurityfinal.controller;

import com.example.springsecurityfinal.service.UserRoleService;
import com.example.springsecurityfinal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRoleService userRoleService;

    @RequestMapping(value = "/test")
    public String test(Model model){
        model.addAttribute("userList",this.userService.getUserByName("haipv"));
        model.addAttribute("roleList",this.userRoleService.getRoleNameByUserId(1));
        return "test";
    }
}
