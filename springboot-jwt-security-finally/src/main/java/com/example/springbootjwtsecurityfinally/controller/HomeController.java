package com.example.springbootjwtsecurityfinally.controller;

import com.example.springbootjwtsecurityfinally.model.UserEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;

@Controller
public class HomeController {

    public static final String URL_REST_LOGIN = "http://localhost:8081/api/login/";

    @RequestMapping(value = "/home")
    public String login(Model model) {
        model.addAttribute("user", new UserEntity());
        return "home";
    }

    @RequestMapping(value = {"/login-page"})
    public String home(Model model, @ModelAttribute UserEntity userEntity) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> token = restTemplate.getForEntity(URL_REST_LOGIN,String.class,userEntity);
        model.addAttribute("token");
        return "home";
    }
}
