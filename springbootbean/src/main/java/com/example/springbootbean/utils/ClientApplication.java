package com.example.springbootbean.utils;

import com.example.springbootbean.consumer.MyApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class ClientApplication {
    public static void main(String [] args){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DIConfiguration.class);
        MyApplication app = context.getBean(MyApplication.class);
        app.processMessage("Hi Hai", "hai@gmail.com");

        ClassPathXmlApplicationContext context1 = new ClassPathXmlApplicationContext("");

        FileSystemXmlApplicationContext context2 = new FileSystemXmlApplicationContext("");

        AnnotationConfigApplicationContext context3 = new AnnotationConfigApplicationContext("");

        //close the contex
        context.close();

    }
}
