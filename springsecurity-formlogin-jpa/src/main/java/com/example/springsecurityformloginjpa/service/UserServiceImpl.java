package com.example.springsecurityformloginjpa.service;

import com.example.springsecurityformloginjpa.model.UserEntity;
import com.example.springsecurityformloginjpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserEntity getUserByUserName(String username) {
        return this.userRepository.findUserByUsername(username);
    }

    @Override
    public Iterable<UserEntity> getAllUser() {
        return this.userRepository.findAll();
    }

    @Override
    public UserEntity getUserById(int id) {
        return this.userRepository.findById(id).get();
    }

    @Override
    public UserEntity saveUser(UserEntity userEntity) {
        return this.userRepository.save(userEntity);
    }

    @Override
    public List<UserEntity> searchUserByName(String name) {
        return this.userRepository.findUserEntitiesByFullname(name);
    }

    @Override
    public Page<UserEntity> getAllUserPagination(Pageable pageable) {
        return this.userRepository.findAll(pageable);
    }

    @Override
    public Page<UserEntity> getUserPaginationByName(String name, Pageable pageable) {
        return this.userRepository.findUserEntitiesByFullnameContaining(name,pageable);
    }

    @Override
    public void deleteUserById(int id) {
        this.userRepository.deleteById(id);
    }


}
