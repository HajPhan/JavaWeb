package com.example.springbootsecurity.repository;

import com.example.springbootsecurity.model.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<AppRole,Integer> {
    @Query(value = "SELECT a.role_name user FROM user_role u JOIN app_role a WHERE u.role_id=a.role_id and u.user_id = :user_id", nativeQuery = true)
//    public List<String> getRoleNames(Param("user_id") int userId);
    public List<String> getRoleNames(@Param("user_id") Integer user_id);
}
