package com.example.springbootjwtsecurityfinally.repository;

import com.example.springbootjwtsecurityfinally.model.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserEntity,Integer> {
    UserEntity findUserByUsername(String username);
}
