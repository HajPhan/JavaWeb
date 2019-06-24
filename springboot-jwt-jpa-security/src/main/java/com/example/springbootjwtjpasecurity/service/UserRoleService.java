package com.example.springbootjwtjpasecurity.service;

import java.util.List;

public interface UserRoleService {
    List<String> getUserRoleNameByUserId(int id);
}
