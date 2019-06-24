package com.example.springbootjwtjpasecurity.repository;

import com.example.springbootjwtjpasecurity.model.UserRoleEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRoleRepository extends CrudRepository<UserRoleEntity,Integer> {
    @Query(value = "select r.name from user_role u join role r where u.roleId = r.id and u.userId = ?1", nativeQuery = true)
    List<String> findUserRoleByUserId(int id);
}
