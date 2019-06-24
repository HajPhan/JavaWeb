package com.example.springsercurityformlogin.repository;

import com.example.springsercurityformlogin.model.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity,Integer> {
    UserEntity findUserEntityByUsername(String username);
}
