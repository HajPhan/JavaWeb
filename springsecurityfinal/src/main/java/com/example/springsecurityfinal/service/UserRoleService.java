package com.example.springsecurityfinal.service;

import com.example.springsecurityfinal.model.UserEntity;

import java.util.List;

public interface UserRoleService {
    List<String> getRoleNameByUserId (int id);
}
