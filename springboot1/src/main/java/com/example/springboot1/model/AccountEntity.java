package com.example.springboot1.model;

import javax.persistence.*;

@Table(name = "account", schema = "demo")
@Entity
public class AccountEntity{
    private int id;
    private String name;
    private String email;

    public AccountEntity(){

    }

    @Id
    @Column(name = "a_Id")
    public int getId(){
        return this.id;
    }

    public void setId(int id){
        this.id = id;
    }

    @Basic
    @Column(name = "a_Name")
    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    @Basic
    @Column(name = "a_Mail")
    public String getEmail(){
        return this.email;
    }

    public void setEmail(String email){
        this.email = email;
    }

}
