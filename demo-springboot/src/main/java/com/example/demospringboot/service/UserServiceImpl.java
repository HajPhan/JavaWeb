package com.example.demospringboot.service;

import com.example.demospringboot.model.UserEntity;
import com.example.demospringboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserEntity getUserByUsername(String name) {
        return this.userRepository.findUserByUsername(name);
    }

    @Override
    public Iterable<UserEntity> getAllUser() {
        return this.userRepository.findAll();
    }

}
