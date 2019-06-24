package com.example.springsecurityfinal.service;

import com.example.springsecurityfinal.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Override
    public List<String> getRoleNameByUserId(int id) {
        return this.userRoleRepository.findNameRoleByUserId(id);
    }
}
