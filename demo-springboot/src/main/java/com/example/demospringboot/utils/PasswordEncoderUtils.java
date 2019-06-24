package com.example.demospringboot.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoderUtils {
    public static void passwordEncoder(){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String code = bCryptPasswordEncoder.encode("123");
        System.out.println("code = " + code);
    }

    public static void main(String [] args){
        passwordEncoder();
    }
}
