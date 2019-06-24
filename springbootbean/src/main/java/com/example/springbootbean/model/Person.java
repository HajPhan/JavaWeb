package com.example.springbootbean.model;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Person {

    private String name;

    public Person() {

    }

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private void init() {
        System.out.println("\n|====================================================================>");
        System.out.println("|============================| Bat dau bean. |=======================>");
        System.out.println("|====================================================================>\n");

    }

    private void destroy() {
        System.out.println("\n|====================================================================>");
        System.out.println("|============================| Huy bean.     |=======================>");
        System.out.println("|====================================================================>\n");
    }

    private void khoitao() {
        System.out.println("\n|====================================================================>");
        System.out.println("|============================| Ham Khoi Tao.     |=======================>");
        System.out.println("|====================================================================>\n");

    }

    private void cleanUp() {
        System.out.println("\n|====================================================================>");
        System.out.println("|============================| Ham Clean Up.     |=======================>");
        System.out.println("|====================================================================>\n");

    }

    @PostConstruct
    public void turnOn(){
        System.err.println("Load operating system");
    }

    @PreDestroy
    public void turnOff(){
        System.err.println("Close all programs");
    }
}
