package com.example.demospringboot.service;

import com.example.demospringboot.model.UserEntity;

public interface UserService {
    UserEntity getUserByUsername(String name);
    Iterable<UserEntity> getAllUser();
}
