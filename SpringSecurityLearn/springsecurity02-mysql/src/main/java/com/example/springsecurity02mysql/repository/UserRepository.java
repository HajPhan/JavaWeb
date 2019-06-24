package com.example.springsecurity02mysql.repository;

import com.example.springsecurity02mysql.model.UserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Integer> {
    @Query(value = "SELECT u.* FROM user u WHERE u.username LIKE CONCAT('%',:name,'%')",nativeQuery = true)
    UserEntity findUserByName(@Param("name") String name);

    UserEntity findUserEntityByUserName(String name);
}
