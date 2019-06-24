package com.example.learnspringcore.model;

public class Student {
    private String name;

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public void displayInfo(){
        System.out.println("Hello: " + name);
    }
}
