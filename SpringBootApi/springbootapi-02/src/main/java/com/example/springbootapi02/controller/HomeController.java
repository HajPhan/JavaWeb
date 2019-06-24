package com.example.springbootapi02.controller;

import com.example.springbootapi02.model.UserEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import java.security.Principal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {

    private static final String REST_SERVICE_URL = "http://localhost:8282/api/user/";

    private static final String REST_SERVICE_URI = "http://localhost:8282/api/user/list/";

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home() {
        return "home";
    }

    @RequestMapping(value = "/")
    public String listUser(Model model) {
        RestTemplate restTemplate = new RestTemplate();
        List<LinkedHashMap<String, Object>> mapUser = restTemplate.getForObject(REST_SERVICE_URL, List.class);
        List<UserEntity> list = new ArrayList<UserEntity>();
        for (LinkedHashMap<String, Object> map : mapUser) {
            UserEntity user = new UserEntity();
            user.setId(Integer.valueOf(String.valueOf(map.get("id")))); // Object => String => Integer
            user.setFullname(String.valueOf(map.get("fullname")));      // Object => String
            user.setUsername(String.valueOf(map.get("username")));      // Object => String
            user.setPassword(String.valueOf(map.get("password")));      // Object => String

            list.add(user);
        }
        model.addAttribute("userList", list);
        return "user-list";
    }

    @RequestMapping(value = "/user-save")
    public String saveUser(Model model) {
        model.addAttribute("user", new UserEntity());
        return "user-save";
    }

    @RequestMapping(value = "/saveUser")
    public String doSaveUser(Model mode, @ModelAttribute UserEntity userEntity) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.postForLocation(REST_SERVICE_URL, userEntity, UserEntity.class);
        return "redirect:/";
    }

    @RequestMapping(value = "/user-update/{id}")
    public String updateUser(Model model, @PathVariable int id) {
        RestTemplate restTemplate = new RestTemplate();
        LinkedHashMap<String, UserEntity> mapUser = restTemplate.getForObject(REST_SERVICE_URL + id, LinkedHashMap.class);
        List<Object> list = new ArrayList<Object>();

        for (Map.Entry<String, UserEntity> map : mapUser.entrySet()) {
            list.add(map.getValue());
        }

        model.addAttribute("user", list);
        return "user-update";
    }

    @RequestMapping(value = "/updateUser/{id}")
    public String doUpdateUser(Model model, @ModelAttribute UserEntity userEntity, @PathVariable int id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.put(REST_SERVICE_URL + id, userEntity, UserEntity.class);
        return "redirect:/";
    }

    @RequestMapping(value = "/deleteUser/{id}")
    public String doDeleteUser(@PathVariable int id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(REST_SERVICE_URL + id);
        return "redirect:/";
    }


    // Login
    @RequestMapping(value = "/login")
    public String loginPage() {
        return "login-page";
    }

    @RequestMapping(value = "/logout")
    public String logoutSuccess(Model model) {
        return "redirect:/login?message=logout";
    }

    @RequestMapping(value = "/admin")
    public String adminPage(Model model) {
        return "redirect:/";
    }

    @RequestMapping(value = "/403")
    public String errorPage(Model model, Principal principal) {
        if (principal != null) {
            String message = "Hi " + principal.getName() + "<br/> Yo don't have permisstion to access this page!";
            model.addAttribute("message", message);
        }
        return "403-page";
    }
}
