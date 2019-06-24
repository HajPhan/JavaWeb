package com.example.springbootlogingoogle.controller;

import com.example.springbootlogingoogle.common.GooglePojo;
import com.example.springbootlogingoogle.common.GoogleUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.security.Principal;

@Controller
public class BaseController {

    @Autowired
    private GoogleUtils googleUtils;

    @RequestMapping(value = {"/", "/login"})
    public String login() {
        return "login";
    }


    @RequestMapping(value = "/login-google")
    public String loginGoogle(HttpServletRequest request) throws IOException {
        String code = request.getParameter("code");

        if(code == null || code.isEmpty()){
            return "redirect:/login?google=error";
        }

        String accessToken = googleUtils.getToken(code);

        GooglePojo googlePojo = googleUtils.getUserInfo(accessToken);
        UserDetails userDetails = googleUtils.buildUser(googlePojo);
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        return "redirect:/user";
    }

    @RequestMapping(value = "/user")
    public String user(){
        return "user";
    }


    @RequestMapping(value = "/admin")
    public String admin(Principal principal){
        System.out.println(principal);
        return "admin";
    }


    @RequestMapping(value = "/403")
    public String accessDenied(){
        return "403";
    }

}
