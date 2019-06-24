package com.example.springsecurityformloginjpa.service;

import com.example.springsecurityformloginjpa.model.UserRoleEntity;

import java.util.List;

public interface DemoService {
    List<UserRoleEntity> getUserQuery();
        void getUserDemo();
}
