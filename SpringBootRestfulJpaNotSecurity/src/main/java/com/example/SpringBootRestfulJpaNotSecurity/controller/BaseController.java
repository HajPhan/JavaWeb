package com.example.SpringBootRestfulJpaNotSecurity.controller;

import com.example.SpringBootRestfulJpaNotSecurity.model.UserEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Controller
public class BaseController {

    public static final String REST_SERVICE_URI = "http://localhost:7070/api/user/";

    @RequestMapping(value = "/user-view/{id}", method = RequestMethod.GET)
    public String viewUser(Model model, @PathVariable int id) {
        RestTemplate restTemplate = new RestTemplate();
        LinkedHashMap<String,UserEntity> userObject = restTemplate.getForObject(REST_SERVICE_URI +id, LinkedHashMap.class);
        List<Object> list = new ArrayList<Object>();

        for(Map.Entry<String, UserEntity> m : userObject.entrySet()){
            list.add(m.getValue());
        }

        model.addAttribute("user",list);
        return "user-view";
    }

    @RequestMapping(value = {"/", "/home"})
    public String home(Model model) {
        RestTemplate restTemplate = new RestTemplate();
        List<LinkedHashMap<String, Object>> userMap = restTemplate.getForObject(REST_SERVICE_URI, List.class);
        List<UserEntity> list = new ArrayList<UserEntity>();
        if (userMap != null) {
            for (LinkedHashMap<String, Object> map : userMap) {
                UserEntity userEntity = new UserEntity();
                userEntity.setId(Integer.valueOf(String.valueOf(map.get("id"))));
                userEntity.setFullName(String.valueOf(map.get("fullName")));
                userEntity.setUserName(String.valueOf(map.get("userName")));
                userEntity.setPassWord(String.valueOf(map.get("passWord")));
                list.add(userEntity);
            }
            model.addAttribute("userList", list);
        }
        return "home";
    }

    @RequestMapping(value = "/user-save")
    public String saveUser(Model model) {
        model.addAttribute("user", new UserEntity());
        return "user-save";
    }

    @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    public String doSaveUser(Model model, @ModelAttribute("UserEntity") UserEntity user) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.postForLocation(REST_SERVICE_URI, user, UserEntity.class);
        return "redirect:/";
    }

    @RequestMapping(value = "/user-update/{id}", method = RequestMethod.GET)
    public String updateUser(Model model, @PathVariable int id) {
        RestTemplate restTemplate = new RestTemplate();
        LinkedHashMap<String,UserEntity> userObject = restTemplate.getForObject(REST_SERVICE_URI +id, LinkedHashMap.class);
        List<Object> list = new ArrayList<Object>();

        for(Map.Entry<String, UserEntity> m : userObject.entrySet()){
            list.add(m.getValue());
        }

        model.addAttribute("user",list);
        return "user-update";
    }

    @RequestMapping(value = "/updateUser/{id}", method = RequestMethod.POST)
    public String doUpdateUser(@PathVariable int id, @ModelAttribute("UserEntity") UserEntity user, Model model){
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.put(REST_SERVICE_URI+id,user,UserEntity.class);
        return "redirect:/";
    }

    @RequestMapping(value = "/deleteUser/{id}",method = RequestMethod.GET)
    public String doDeleteUser(@PathVariable int id, Model model){
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(REST_SERVICE_URI+id);
        return "redirect:/";
    }

    @RequestMapping(value = "/search")
    public String doSearchUser(@RequestParam("stringSearch") String stringSearch, Model model){
        RestTemplate restTemplate = new RestTemplate();
        List<LinkedHashMap<String,Object>> userMap = restTemplate.getForObject(REST_SERVICE_URI+"search?stringSearch="+stringSearch,List.class);
        List<UserEntity> list = new ArrayList<UserEntity>();
        if (userMap != null) {
            for (LinkedHashMap<String, Object> map : userMap) {
                UserEntity userEntity = new UserEntity();
                userEntity.setId(Integer.valueOf(String.valueOf(map.get("id"))));
                userEntity.setFullName(String.valueOf(map.get("fullName")));
                userEntity.setUserName(String.valueOf(map.get("userName")));
                userEntity.setPassWord(String.valueOf(map.get("passWord")));
                list.add(userEntity);
            }
            model.addAttribute("userList", list);
        }
        return "home";
    }
}
