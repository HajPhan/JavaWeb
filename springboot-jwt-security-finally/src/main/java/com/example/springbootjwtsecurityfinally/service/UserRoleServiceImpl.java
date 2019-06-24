package com.example.springbootjwtsecurityfinally.service;

import com.example.springbootjwtsecurityfinally.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRoleServiceImpl implements UserRoleService{

//    @Autowired
    private UserRoleRepository userRoleRepository;

    @Override
    public List<String> getAllRoleNameByUserId(int id) {
        return this.userRoleRepository.findRoleNameByUserId(id);
    }
}
