package com.example.springsecurityformloginjpa.controller;

import com.example.springsecurityformloginjpa.dto.UserRole;
import com.example.springsecurityformloginjpa.model.UserRoleEntity;
import com.example.springsecurityformloginjpa.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DemoController {

    @Autowired
    DemoService demoService;

    @RequestMapping(value = "/demo", method = RequestMethod.GET)
    public List<UserRoleEntity> getUserQueryDemo() {
        List<UserRoleEntity> list = this.demoService.getUserQuery();
        List<UserRole> obj = this.demoService.getUserDemo();
        List<UserRole> demo = new ArrayList<UserRole>();
        UserRole d1 = new UserRole();
//        d1.setId((Integer) ((Object[])obj.get(0))[0]);
//        d1.setUserId((Integer) ((Object[])obj.get(0))[1]);
//        d1.setRoleId((Integer) ((Object[])obj.get(0))[2]);

        demo.add(d1);

//        System.err.println(demo.get(0).getId() + " :: " + demo.get(0).getUserId() + " :: " + demo.get(0).getRoleId());

//        System.err.println(((Object[])obj.get(0))[1]);

//        ((Object[])obj.get(0))[1];

        return this.demoService.getUserQuery();
    }

}
