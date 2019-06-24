package com.example.springbootjwtsecurityfinally.service;

import com.example.springbootjwtsecurityfinally.model.UserEntity;
import com.example.springbootjwtsecurityfinally.repository.UserRepository;
import com.example.springbootjwtsecurityfinally.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = this.userRepository.findUserByUsername(username);

        List<String> roleName = this.userRoleRepository.findRoleNameByUserId(userEntity.getId());

        List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();

        if (roleName != null) {
            for (String role : roleName) {
                GrantedAuthority authority = new SimpleGrantedAuthority(role);
                grantList.add(authority);
            }
        }

        UserDetails userDetails = new User(userEntity.getUsername(), userEntity.getPassword(), grantList);

        return userDetails;
    }
}
