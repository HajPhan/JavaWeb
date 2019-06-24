package com.example.springsecurityformloginjpa.repository;

import com.example.springsecurityformloginjpa.dto.UserRole;
import com.example.springsecurityformloginjpa.model.UserRoleEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.List;

@Repository
public interface UserRoleRepository extends CrudRepository<UserRoleEntity,Integer> {

    @Query(value = "select r.name from user_role u join role r where u.roleId = r.id and u.userId = ?1", nativeQuery = true)
    List<String> findUserRoleByUserId(int id);

    @Query(value = "select u.* from user_role u", nativeQuery = true)
    List<UserRoleEntity> findUser();

    @Query(value = "select u.* from user_role u", nativeQuery = true)
    ResultSet findUserDemo();
}
