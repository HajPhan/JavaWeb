package com.example.springbootrestfuljpa.service;

import com.example.springbootrestfuljpa.model.UserEntity;

public interface UserService {
    Iterable<UserEntity> findAllUsers();
    UserEntity findUserById(int id);
    UserEntity saveUser(UserEntity user);
    void deleteUserById(int id);
    void deleteAllUsers();
    boolean isUserExist(UserEntity user);
}
