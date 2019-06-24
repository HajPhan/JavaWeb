package com.example.springsecurityfinal.service;

import com.example.springsecurityfinal.model.UserEntity;
import com.example.springsecurityfinal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserEntity getUserByName(String name) {
        return this.userRepository.findUserByName(name);
    }
}
