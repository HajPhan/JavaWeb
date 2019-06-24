package com.example.demospringboot.service;

import java.util.List;

public interface UserRoleService {
    List<String> getAllRoleNameByUserId(int id);
}
