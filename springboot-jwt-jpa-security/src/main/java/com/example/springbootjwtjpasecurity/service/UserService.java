package com.example.springbootjwtjpasecurity.service;

import com.example.springbootjwtjpasecurity.model.UserEntity;

import java.util.List;

public interface UserService {
    UserEntity getUserEntityByUserName(String username);
    Iterable<UserEntity> getAllUserEntity();
    List<UserEntity> getAllUserEntityByFullName(String fullName);
    UserEntity getUserEntityById(int id);
    void saveUserEntity(UserEntity userEntity);
    void deleteUserEntityById(int id);
    boolean checkLogin(UserEntity userEntity);
}
