package com.example.springbootsecurity.service;

import com.example.springbootsecurity.model.AppUser;
import com.example.springbootsecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public AppUser findUserAccountByName(String name) {
        return this.userRepository.findUserAccount(name);
    }

}
