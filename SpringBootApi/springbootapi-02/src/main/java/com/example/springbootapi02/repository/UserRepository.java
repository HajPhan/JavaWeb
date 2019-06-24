package com.example.springbootapi02.repository;

import com.example.springbootapi02.model.UserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<UserEntity,Integer> {
    List<UserEntity> findUserEntitiesByFullnameContaining(String fullname);
    UserEntity findUserEntitiesByUsername(String username);
}
