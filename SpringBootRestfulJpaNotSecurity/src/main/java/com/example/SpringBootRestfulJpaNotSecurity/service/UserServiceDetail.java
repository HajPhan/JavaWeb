package com.example.SpringBootRestfulJpaNotSecurity.service;

import com.example.SpringBootRestfulJpaNotSecurity.model.UserEntity;
import com.example.SpringBootRestfulJpaNotSecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        UserEntity user = this.userRepository.findById(id).orElse(null);
        if (user == null) {
            return user;
        }
        return user;
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
        String userEntity = this.userRepository.isExistUserByName(user.getUserName());
        if(userEntity == null){
            return false;
        }
        return true;
    }

    @Override
    public List<UserEntity> searchUser(String name) {
        return this.userRepository.searchUserByName(name);
    }
}
