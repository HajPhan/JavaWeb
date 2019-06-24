package com.example.springbootjwtsecurityfinally.service;

import com.example.springbootjwtsecurityfinally.model.UserEntity;

public interface UserService {
    UserEntity getUserByUsername(String username);
    Iterable<UserEntity> getAllUser();
    UserEntity getUserById(int id);
    void saveUser(UserEntity userEntity);
    void deleteUserById(int id);
    boolean checkLogin(UserEntity userEntity);
}
