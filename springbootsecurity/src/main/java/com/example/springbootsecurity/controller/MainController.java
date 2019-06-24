package com.example.springbootsecurity.controller;

import com.example.springbootsecurity.dao.AppRoleDao;
import com.example.springbootsecurity.dao.AppUserDao;
import com.example.springbootsecurity.model.AppUser;
import com.example.springbootsecurity.service.RoleService;
import com.example.springbootsecurity.service.UserService;
import com.example.springbootsecurity.utils.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

@Controller
public class MainController {

    @RequestMapping(value = {"/","/welcome"}, method = RequestMethod.GET)
    public String welcomePage(Model model){
        model.addAttribute("title","Welcome");
        model.addAttribute("message","This is welcome page!");
        return "welcomePage";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String adminPage(Model model, Principal principal){
        User loginedUser = (User) ((Authentication)principal).getPrincipal();

        String userInfo = WebUtils.toString(loginedUser);
        model.addAttribute("userInfo",userInfo);

        return "adminPage";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(Model model){
        return "loginPage";
    }

    @RequestMapping(value = "/logoutSuccessfulPage", method = RequestMethod.GET)
    public String logoutSuccessfullPage(Model model){
        model.addAttribute("title","Logout");
        return "logoutSuccessfulPage";
    }

    @RequestMapping(value = "/userAccountInfo"
            , method = RequestMethod.GET)
    public String userInfo(Model model, Principal principal){
        // Sau khi user login thanh cong se co principal
        String userName = principal.getName();
        System.out.println("User Name: " + userName);
        User loginedUser = (User)((Authentication)principal).getPrincipal();
//        Object principalObject = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        User us = (User) principalObject;
        String userInfo = WebUtils.toString(loginedUser);
        model.addAttribute("userInfo",userInfo);

        return "userInfoPage";
    }

    @RequestMapping(value = "/403")
    public String accessDenied(Model model, Principal principal){
        if(principal != null){
            User loginedUser = (User)((Authentication)principal).getPrincipal();

            String userInfo = WebUtils.toString(loginedUser);

            model.addAttribute("userInfo",userInfo);

            String message = "Hi " + principal.getName() + "<br> Yo do not have permission to access this page!";
            model.addAttribute("message", message);
        }
        return "403Page";
    }

    @Autowired
    private AppUserDao appUserDao;
    @Autowired
    private AppRoleDao appRoleDao;

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserService userService;

//    Test Database
    @RequestMapping(value = "/test")
    public String test(Model model){
        model.addAttribute("listUser",userService.findUserAccountByName("dbadmin1"));
        model.addAttribute("listRole",roleService.getNameRolleById(1));
        return "test";
    }
}
