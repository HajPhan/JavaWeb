package com.example.springsecurity02mysql.service;

import com.example.springsecurity02mysql.model.UserEntity;

public interface UserService {
    UserEntity getUserByName(String name);
    UserEntity getUserByUserName(String name);
}
