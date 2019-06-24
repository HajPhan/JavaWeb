package com.example.springsecurityformloginjpa.service;

import com.example.springsecurityformloginjpa.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Override
    public List<String> getUserRoleByUserId(int id) {
        List<String> list = this.userRoleRepository.findUserRoleByUserId(id);
        return list;
    }
}
