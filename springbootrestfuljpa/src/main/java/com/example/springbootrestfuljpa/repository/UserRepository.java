package com.example.springbootrestfuljpa.repository;

import com.example.springbootrestfuljpa.model.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserEntity,Integer> {
    @Query(value = "SELECT u.u_Username FROM user u WHERE u.u_Username LIKE CONCAT('%',:name,'%')", nativeQuery = true)
    boolean isExistUserByName(@Param("name") String name);
}
