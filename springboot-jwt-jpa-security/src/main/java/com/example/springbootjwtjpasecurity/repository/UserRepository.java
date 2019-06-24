package com.example.springbootjwtjpasecurity.repository;

import com.example.springbootjwtjpasecurity.model.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<UserEntity,Integer> {
    UserEntity findUserEntitiesByUsername(String username);
    List<UserEntity> findUserEntitiesByFullnameContaining(String fullName);
}
