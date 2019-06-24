package com.example.springsecurity02mysql.service;

import com.example.springsecurity02mysql.model.UserEntity;
import com.example.springsecurity02mysql.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserEntity getUserByName(String name) {
        UserEntity user = userRepository.findUserByName(name);
        return user;
    }

    @Override
    public UserEntity getUserByUserName(String name) {
        return this.userRepository.findUserEntityByUserName(name);
    }
}
