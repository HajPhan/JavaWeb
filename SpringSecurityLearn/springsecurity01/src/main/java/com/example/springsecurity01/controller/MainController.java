package com.example.springsecurity01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
    @RequestMapping(value = {"/", "/admin", "/home"})
    public String home() {
        return "home";
    }
}
