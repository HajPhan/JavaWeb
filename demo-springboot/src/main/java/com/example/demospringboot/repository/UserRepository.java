package com.example.demospringboot.repository;

import com.example.demospringboot.model.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity,Integer> {
    UserEntity findUserByUsername(String name);
}
