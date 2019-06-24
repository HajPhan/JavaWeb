package com.example.springbootjwtsecurityfinally.service;

import org.springframework.stereotype.Repository;

import java.util.List;

public interface UserRoleService {
    List<String> getAllRoleNameByUserId(int id);
}
