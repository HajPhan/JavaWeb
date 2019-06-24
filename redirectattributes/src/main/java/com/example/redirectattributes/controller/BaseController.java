package com.example.redirectattributes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class BaseController {
    @RequestMapping(value = "/")
    public String page1(){
        return "page1";
    }

    @RequestMapping(value = "/redirect")
    public RedirectView redirect(@RequestParam("name") String name, RedirectAttributes redirectAttributes){
        System.out.println(name);
        redirectAttributes.addAttribute("name",name);
        return new RedirectView("page2");
    }

    @RequestMapping("/page2")
    public String page2(@RequestParam("name") String name, Model model){
        model.addAttribute("name",name.toUpperCase());
        return "page2";
    }
}
