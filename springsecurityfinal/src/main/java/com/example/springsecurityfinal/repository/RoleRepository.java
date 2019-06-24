package com.example.springsecurityfinal.repository;

import com.example.springsecurityfinal.model.RoleEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.management.relation.Role;

@Repository
public interface RoleRepository extends CrudRepository<RoleEntity,Integer> {
}
