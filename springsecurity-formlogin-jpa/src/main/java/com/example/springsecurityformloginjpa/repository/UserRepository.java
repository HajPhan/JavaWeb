package com.example.springsecurityformloginjpa.repository;

import com.example.springsecurityformloginjpa.model.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<UserEntity,Integer>, PagingAndSortingRepository<UserEntity,Integer> {
    UserEntity findUserByUsername(String username);
    List<UserEntity> findUserEntitiesByFullname(String fullname);

    // Using Like: select ... like %:username%
    Page<UserEntity> findUserEntitiesByFullnameContaining(String name, Pageable pageable);

    // Starting With: select ... like :username%
//    Page<UserEntity> findUserEntitiesByFullnameStartingWith(String name, Pageable pageable);

    // Starting With: select ... like %:username
//    Page<UserEntity> findUserEntitiesByFullnameEndingWith(String name, Pageable pageable);


}
