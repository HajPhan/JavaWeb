package com.example.springsecurityformloginjpa.service;

import org.springframework.stereotype.Repository;

import java.util.List;

public interface UserRoleService {
    List<String> getUserRoleByUserId(int id);
}
