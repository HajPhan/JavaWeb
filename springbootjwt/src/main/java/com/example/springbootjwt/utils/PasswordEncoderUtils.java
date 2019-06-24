package com.example.springbootjwt.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoderUtils {
    public static void passwordCoder(){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String code = bCryptPasswordEncoder.encode("123");
        System.out.println("code = " + code);
    }

    public static void main(String [] args){
        passwordCoder();
    }
}
