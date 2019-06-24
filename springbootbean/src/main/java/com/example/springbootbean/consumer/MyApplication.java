package com.example.springbootbean.consumer;

import com.example.springbootbean.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

//@Component
//@Controller
@Service
public class MyApplication {

    //field-based dependency injection
//    @Autowired
    private MessageService service;
//
//    constructor-based dependency injection
//    @Autowired
//    public MyApplication(MessageService svc){
//        this.service =svc;
//    }

    @Autowired
    public void setService(MessageService svc){
        this.service = svc;
    }

    public boolean processMessage(String msg, String rec){
        // some magic like validation, logging etc
        return this.service.sendMessage(msg,rec);
    }
}
