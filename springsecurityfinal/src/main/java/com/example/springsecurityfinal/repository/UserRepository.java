package com.example.springsecurityfinal.repository;

import com.example.springsecurityfinal.model.UserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserEntity,Integer> {
    @Query(value = "SELECT u.* FROM user u WHERE u.user_name = :user",nativeQuery = true)
    UserEntity findUserByName (@Param("user") String user);
}
