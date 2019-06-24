package com.example.springbootapi02.service;

import com.example.springbootapi02.model.UserEntity;

import java.util.List;

public interface UserService {
    Iterable<UserEntity> getAllUser();
    UserEntity getUserById(int id);
    List<UserEntity> getAllUserByFullName(String fullName);
    UserEntity getUserByUserName(String username);
    void saveUser(UserEntity userEntity);
    void deleteUserById(int id);
}
