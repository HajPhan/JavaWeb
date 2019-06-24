package com.websystique.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.LinkedHashMap;
import java.util.List;

@Controller
public class BaseController {
    public final String REST_SERVICE_URI = "http://localhost:7070/api/user/";

    @RequestMapping(value = {"/", "/home"})
    public String home(Model model) {
        RestTemplate restTemplate = new RestTemplate();
        List<LinkedHashMap<String, Object>> usersMap = restTemplate.getForObject(REST_SERVICE_URI + "/user/", List.class);
        if (usersMap != null) {
            model.addAttribute("accountList", usersMap);
        }

        return "home";
    }


}
