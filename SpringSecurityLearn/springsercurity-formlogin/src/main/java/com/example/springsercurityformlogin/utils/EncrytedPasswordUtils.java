package com.example.springsercurityformlogin.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncrytedPasswordUtils {
    public  static void encoder(){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String code = encoder.encode("123");
        System.out.println("code: " + code);
    }

    public static void main(String [] args){
        encoder();
    }
}
