package com.example.SpringBootRestfulJpaNotSecurity.service;

import com.example.SpringBootRestfulJpaNotSecurity.model.UserEntity;

import java.util.List;

public interface UserService {
    Iterable<UserEntity> findAllUsers();
    UserEntity findUserById(int id);
    UserEntity saveUser(UserEntity user);
    void deleteUserById(int id);
    void deleteAllUsers();
    boolean isUserExist(UserEntity user);
    List<UserEntity> searchUser(String userEntity);
}
