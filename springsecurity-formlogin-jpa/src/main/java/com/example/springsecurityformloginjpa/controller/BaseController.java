package com.example.springsecurityformloginjpa.controller;

import com.example.springsecurityformloginjpa.service.UserService;
import com.example.springsecurityformloginjpa.utils.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

@Controller
public class BaseController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/")
    public String home() {
        return "home";
    }

    @RequestMapping(value = "/login")
    public String loginPage(Model model) {
        return "login-page";
    }

    @RequestMapping(value = "/userInfo", method = RequestMethod.GET)
    public String userInfo(Model model, Principal principal) {
        String userName = principal.getName();
        System.out.println("User name: " + userName);
        User user = (User)((Authentication)principal).getPrincipal();

        String userInfo = WebUtils.toString(user);
        model.addAttribute("userInfo",user);
        model.addAttribute("userList",this.userService.getAllUser());
        return "userInfo-page";
    }

//    @RequestMapping(value = "/admin", method = RequestMethod.GET)
//    public String adminPage(Model model, Principal principal) {
//        User user = (User) ((Authentication) principal).getPrincipal();
//
//        String userInfo = WebUtils.toString(user);
//        model.addAttribute("userInfo",user);
//
//        model.addAttribute("userList",this.userService.getAllUser());
//
//        return "admin-page";
//    }



    @RequestMapping(value = "/403")
    public String erroPage(Model model,Principal principal) {
        if(principal != null){
            User loginedUser = (User)((Authentication)principal).getPrincipal();

            String userInfo = WebUtils.toString(loginedUser);

            model.addAttribute("userInfo",userInfo);

            String message = "Hi " + principal.getName() + "<br/> You do not have permisstion to access this page!";
            model.addAttribute("message",message);
        }
        return "403-page";
    }

    @RequestMapping(value = "/logout")
    public String logoutSuccess(Model model){
        return "redirect:/login?message=logout";
    }


}
