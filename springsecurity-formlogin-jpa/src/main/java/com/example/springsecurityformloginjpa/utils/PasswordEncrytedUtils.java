package com.example.springsecurityformloginjpa.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncrytedUtils {
    public static String encoder(String password){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String code = bCryptPasswordEncoder.encode(password);
        return code;
    }

//    public static void main(String [] args){
//        encoder("123");
//    }
}
