package com.example.springbootapi02.service;

import com.example.springbootapi02.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRoleServiceImpl implements UserRoleService{
    @Autowired
    private UserRoleRepository userRoleRepository;

    @Override
    public List<String> getUserRoleByUserId(int id) {
        return this.userRoleRepository.findUserRoleByUserId(id);
    }
}
