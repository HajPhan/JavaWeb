package com.example.springsecurityfinal.repository;

import com.example.springsecurityfinal.model.UserRoleEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRoleRepository extends CrudRepository<UserRoleEntity,Integer> {
    @Query(value = "SELECT r.name FROM user_role ur JOIN role r WHERE ur.role_id = r.id AND ur.user_id = :id",nativeQuery = true)
    List<String> findNameRoleByUserId(@Param("id") int id);
}
