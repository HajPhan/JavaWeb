package com.example.springbootjwtjpasecurity.service;

import com.example.springbootjwtjpasecurity.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRoleServiceImpl implements UserRoleService{

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Override
    public List<String> getUserRoleNameByUserId(int id) {
        return this.userRoleRepository.findUserRoleByUserId(id);
    }

}
