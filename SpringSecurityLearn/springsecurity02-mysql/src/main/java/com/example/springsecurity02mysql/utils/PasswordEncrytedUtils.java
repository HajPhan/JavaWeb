package com.example.springsecurity02mysql.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncrytedUtils {
    public static void encrytPassword(String password){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String pass = bCryptPasswordEncoder.encode(password);
        System.out.println(pass);
    }

    public static void main(String [] args){
        encrytPassword("hai123");
    }
}
