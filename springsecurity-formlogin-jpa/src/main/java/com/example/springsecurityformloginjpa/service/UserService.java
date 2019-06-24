package com.example.springsecurityformloginjpa.service;

import com.example.springsecurityformloginjpa.model.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface UserService {
    UserEntity getUserByUserName(String username);
    Iterable<UserEntity> getAllUser();
    UserEntity getUserById(int id);
    UserEntity saveUser(UserEntity userEntity);
    List<UserEntity> searchUserByName(String name);
    Page<UserEntity> getAllUserPagination(Pageable pageable);
    Page<UserEntity> getUserPaginationByName(String name, Pageable pageable);
    void deleteUserById(int id);
}
