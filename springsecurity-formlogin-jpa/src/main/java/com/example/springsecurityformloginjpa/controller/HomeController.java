package com.example.springsecurityformloginjpa.controller;

import com.example.springsecurityformloginjpa.model.UserEntity;
import com.example.springsecurityformloginjpa.service.UserService;
import com.example.springsecurityformloginjpa.utils.PasswordEncrytedUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/home")
    public String home(Model model){
        model.addAttribute("userList",this.userService.getAllUser());
        return "home";
    }

    @RequestMapping(value = "/user-view/{id}")
    public String viewUser(Model model, @PathVariable int id){
//        UserEntity user = this.userService.getUserById(id);
        model.addAttribute("user",this.userService.getUserById(id));
        return "user-view";
    }

    @RequestMapping(value = "/user-save")
    public String saveUser(Model model){
        model.addAttribute("user",new UserEntity());
        return "user-save";
    }

    @RequestMapping(value = "/saveUser")
    public String doSaveUser(Model model, @ModelAttribute UserEntity userEntity){
        userEntity.setPassword(PasswordEncrytedUtils.encoder(userEntity.getPassword()));
        this.userService.saveUser(userEntity);
        return "redirect:/home";
    }

    @RequestMapping(value = "/user-update/{id}")
    public String updateUser(Model model, @PathVariable int id){
        model.addAttribute("user",this.userService.getUserById(id));
        return "user-update";
    }

    @RequestMapping(value = "/updateUser/{id}")
    public String doUpdateUser(Model model, @ModelAttribute UserEntity userEntity, @PathVariable int id){
        userEntity.setId(id);
        userEntity.setPassword(PasswordEncrytedUtils.encoder(userEntity.getPassword()));
        this.userService.saveUser(userEntity);
//        model.addAttribute("userList",this.userService.getAllUser());
        return "redirect:/home";
    }

    @RequestMapping(value = "/deleteUser/{id}")
    public String doDeleteUser(Model model, @PathVariable int id){
        this.userService.deleteUserById(id);
//        model.addAttribute("userList")
        return "redirect:/home";
    }

//    @RequestMapping(value = "/searchUser")
//    public String searchUser(Model model, @RequestParam("searchString") String searchString){
//        model.addAttribute("userList",this.userService.searchUserByName(searchString));
//        return "userInfo-page";
//    }

    @RequestMapping(value = "/searchUser")
    public String searchUser(Pageable pageable, @RequestParam(defaultValue = "0") int nPage, Model model, @RequestParam("searchString") String searchString){
        pageable = PageRequest.of(nPage,10);
        Page page = this.userService.getUserPaginationByName(searchString,pageable);
        model.addAttribute("pageList",page);
        return "admin-page";
    }


    @RequestMapping(value = "/admin")
    public String homePagination(Pageable pageable, Model model,@RequestParam(defaultValue = "0") int nPage){
        pageable = PageRequest.of(nPage,10);
        Page page = this.userService.getAllUserPagination(pageable);
        model.addAttribute("pageList",page);
        return "admin-page";
    }

}
