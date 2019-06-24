package com.example.springsecurityfinal.controller;

import com.example.springsecurityfinal.utils.WebUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;

@Controller
public class MainController {

    @RequestMapping(value = {"/","/login"}, method = RequestMethod.GET)
    public String getLogin(){
        return "login";
    }

    @RequestMapping(value = "/userInfo", method = RequestMethod.GET)
    public String userInfo(Model model, Principal principal){
        // sau khi use login thanh cong se co principal
        String username = principal.getName();
        System.out.println("User Name: " + username);
//        Object loginedUser = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = (User)((Authentication)principal).getPrincipal();
        String userInfo = WebUtils.toString(user);
        model.addAttribute("userInfo",user);
        return "user-info";
    }


    @RequestMapping(value = "/admin")
    public String adminPage(Model model, Principal principal){
        Object object = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = (User)object;
        String userInfo = WebUtils.toString(user);
        model.addAttribute("userInfo",user);
        return "admin-page";
    }


    @RequestMapping(value = "/403")
    public String accessDenied(Model model, Principal pirPrincipal){
        if (pirPrincipal != null){
            User loginedUser = (User)((Authentication)pirPrincipal).getPrincipal();

            String userInfo = WebUtils.toString(loginedUser);

            model.addAttribute("userInfo",userInfo);

            String message = "Hi " + pirPrincipal.getName() + "<br> You do not have permission to access this page!";
            model.addAttribute("message",message);
        }
        return "403Page";
    }


    @RequestMapping(value = "/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if(auth != null){
            new SecurityContextLogoutHandler().logout(request,response,auth);
        }
        return "redirect:/";
    }


    @RequestMapping(value = "/home")
    public String home(Model model){

        return "home";
    }
}
