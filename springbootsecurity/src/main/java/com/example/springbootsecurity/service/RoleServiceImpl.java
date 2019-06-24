package com.example.springbootsecurity.service;

import com.example.springbootsecurity.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<String> getNameRolleById(int id) {
        return this.roleRepository.getRoleNames(id);
    }
}
