package com.example.demospringboot.repository;

import com.example.demospringboot.model.UserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRoleRepository extends CrudRepository<UserEntity, Integer> {
    @Query(value = "SELECT r.name FROM user_role u JOIN role r WHERE u.roleId = r.id AND u.userId=?", nativeQuery = true)
    List<String> findRoleNameByUserId(int id);
}
