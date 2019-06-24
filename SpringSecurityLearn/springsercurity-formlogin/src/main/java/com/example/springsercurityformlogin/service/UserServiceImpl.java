package com.example.springsercurityformlogin.service;

import com.example.springsercurityformlogin.model.UserEntity;
import com.example.springsercurityformlogin.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserEntity getUserByUserName(String name) {
        UserEntity user = this.userRepository.findUserEntityByUsername(name);
        return user;
    }
}
