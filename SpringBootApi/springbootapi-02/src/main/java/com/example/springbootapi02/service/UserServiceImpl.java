package com.example.springbootapi02.service;

import com.example.springbootapi02.model.UserEntity;
import com.example.springbootapi02.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public Iterable<UserEntity> getAllUser() {
        return this.userRepository.findAll();
    }

    @Override
    public UserEntity getUserById(int id) {
        return this.userRepository.findById(id).get();
    }

    @Override
    public List<UserEntity> getAllUserByFullName(String fullName) {
        return this.userRepository.findUserEntitiesByFullnameContaining(fullName);
    }

    @Override
    public UserEntity getUserByUserName(String username) {
        return this.userRepository.findUserEntitiesByUsername(username);
    }

    @Override
    public void saveUser(UserEntity userEntity) {
        this.userRepository.save(userEntity);
    }

    @Override
    public void deleteUserById(int id) {
        this.userRepository.deleteById(id);
    }
}
