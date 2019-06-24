package com.example.SpringBootRestfulJpaNotSecurity.controller;

import com.example.SpringBootRestfulJpaNotSecurity.model.UserEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class ControllerTest {

    public static final String REST_SERVICE_URI = "http://localhost:7070/api/user/";

//    public static void listAllUsers(){
//        System.out.println("Testing list all users api =================> ");
//        RestTemplate restTemplate = new RestTemplate();
//        List<LinkedHashMap<String,Object>>usersMap = restTemplate.getForObject(REST_SERVICE_URI+"/user/",List.class);
//
//        if(usersMap != null){
//            for (LinkedHashMap<String,Object> map : usersMap){
//                System.out.println("User: id = " + map.get("id") + ", Name = " + map.get("fullName") + ", User = " + map.get("userName") + ", Password = " + map.get("passWord"));
//            }
//        }
//        else {
//            System.out.println("No user exist =================> ");
//        }
//    }


//    public static void main(String [] args){
//        listAllUsers();
//    }
//    @RequestMapping(value = {"/","/home"})
    public String home(Model model){
        RestTemplate restTemplate = new RestTemplate();
        List<LinkedHashMap<String,Object>> userMap = restTemplate.getForObject(REST_SERVICE_URI,List.class);
        List<UserEntity> list = new ArrayList<UserEntity>();
//        if(userMap != null){
//            model.addAttribute("userList",userMap);
//        }
        if (userMap != null) {
            for(LinkedHashMap<String,Object> map : userMap){
                UserEntity userEntity = new UserEntity();
                System.out.println("User: Id = " + map.get("id") + " FullName = " + map.get("fullName") +
                        " Username = " + map.get("userName") + " Password = " + map.get("passWord"));
                userEntity.setId(Integer.valueOf(String.valueOf(map.get("id"))));
                userEntity.setFullName(String.valueOf(map.get("fullName")));
                userEntity.setUserName(String.valueOf(map.get("userName")));
                userEntity.setPassWord(String.valueOf(map.get("passWord")));
                list.add(userEntity);
            }
            model.addAttribute("userList",list);
        } else {
            System.out.println("No user exist =================> ");
        }
        return "home";
    }
}
