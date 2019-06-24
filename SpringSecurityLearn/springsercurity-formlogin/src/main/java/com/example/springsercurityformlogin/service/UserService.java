package com.example.springsercurityformlogin.service;

import com.example.springsercurityformlogin.model.UserEntity;

public interface UserService {
    UserEntity getUserByUserName(String name);
}
