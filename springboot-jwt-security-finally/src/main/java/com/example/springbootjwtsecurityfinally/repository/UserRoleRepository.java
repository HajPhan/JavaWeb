package com.example.springbootjwtsecurityfinally.repository;

import com.example.springbootjwtsecurityfinally.model.UserRoleEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRoleRepository extends CrudRepository<UserRoleEntity,Integer> {
    @Query(value = "select r.name from user_role u join role r where u.roleId = r.id and u.userId = ?1", nativeQuery = true)
    List<String> findRoleNameByUserId(int id);
}
