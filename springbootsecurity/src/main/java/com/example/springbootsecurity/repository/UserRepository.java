package com.example.springbootsecurity.repository;

import com.example.springbootsecurity.model.AppRole;
import com.example.springbootsecurity.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<AppUser,Integer> {
    @Query(value = "SELECT u.* FROM app_user u WHERE u.user_name = :name",nativeQuery = true)
    public AppUser findUserAccount(@Param("name") String name);
}
