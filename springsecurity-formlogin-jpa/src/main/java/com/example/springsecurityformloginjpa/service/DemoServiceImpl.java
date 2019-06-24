package com.example.springsecurityformloginjpa.service;

import com.example.springsecurityformloginjpa.model.UserRoleEntity;
import com.example.springsecurityformloginjpa.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DemoServiceImpl implements DemoService{

    @Autowired
    UserRoleRepository userRoleRepository;

    @Override
    public List<UserRoleEntity> getUserQuery() {
        return this.userRoleRepository.findUser();
    }

    @Override
    public void getUserDemo() {
        this.userRoleRepository.findUserDemo();
    }
}
