package com.example.SpringBootRestfulJpaNotSecurity.repository;

import com.example.SpringBootRestfulJpaNotSecurity.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Integer> {
    @Query(value = "SELECT u.u_Username FROM user u WHERE u.u_Username LIKE CONCAT('%',:name,'%')", nativeQuery = true)
    String isExistUserByName(@Param("name") String name);

    @Query(value = "SELECT u.* FROM user u WHERE u.u_Fullname LIKE CONCAT('%',:search,'%')", nativeQuery = true)
    List<UserEntity>searchUserByName(@Param("search") String search);
}
