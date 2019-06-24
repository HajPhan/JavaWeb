package com.example.springbootrestfuljpa.service;

import com.example.springbootrestfuljpa.model.UserEntity;
import com.example.springbootrestfuljpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceDetail implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Iterable<UserEntity> findAllUsers() {
        return this.userRepository.findAll();
    }

    @Override
    public UserEntity findUserById(int id) {
        return this.userRepository.findById(id).get();
    }

    @Override
    public UserEntity saveUser(UserEntity user) {
        return this.userRepository.save(user);
    }

    @Override
    public void deleteUserById(int id) {
        this.userRepository.deleteById(id);
    }

    @Override
    public void deleteAllUsers() {
        this.userRepository.deleteAll();
    }

    @Override
    public boolean isUserExist(UserEntity user) {
        return this.userRepository.isExistUserByName(user.getUserName());
    }
}
