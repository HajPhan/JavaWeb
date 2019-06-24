package com.example.springjwttest.controller;

import com.example.springjwttest.Test1.Login;
import com.example.springjwttest.Test1.User;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

@Controller
public class HomeController {

    private final static String URL_API_USER = "http://localhost:8081/api/user/";

    @RequestMapping(value = "/home")
    public String home(Model model, HttpSession session){
        String token = String.valueOf(session.getAttribute("token"));
//        String token = Login.getToken("haipv","123");
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization",token);
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        HttpEntity<String> httpEntity = new HttpEntity<>(headers);
        RestTemplate restTemplate = new RestTemplate();
        List<LinkedHashMap<String,Object>> mapUser = restTemplate.exchange(URL_API_USER, HttpMethod.GET,httpEntity,List.class).getBody();
        List<User> list = new ArrayList<User>();
        for (LinkedHashMap<String,Object> map : mapUser){
            User user = new User();
            user.setId(Integer.valueOf(String.valueOf(map.get("id"))));
            user.setFullname(String.valueOf(map.get("fullname")));
            user.setUsername(String.valueOf(map.get("username")));
            user.setPassword(String.valueOf(map.get("password")));

            list.add(user);
        }
        model.addAttribute("userList",list);
        return "home";
    }

    @RequestMapping(value = "/login-page")
    public String loginPage(){
        return "login-page";
    }

    @RequestMapping(value = "/login")
    public String login(HttpServletRequest request, HttpSession session){

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        String token = Login.getToken(username,password);
        session.setAttribute("token",token);
        System.out.println("token = " + token);
        return "redirect:/home";
    }

}
