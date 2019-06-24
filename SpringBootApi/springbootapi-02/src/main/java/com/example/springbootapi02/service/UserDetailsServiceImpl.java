package com.example.springbootapi02.service;

import com.example.springbootapi02.model.UserEntity;
import com.example.springbootapi02.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRoleService userRoleService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserEntity userEntity = this.userService.getUserByUserName(username);

        List<String> roleName = this.userRoleService.getUserRoleByUserId(userEntity.getId());

        List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();

        for (String role : roleName) {
            GrantedAuthority authority = new SimpleGrantedAuthority(role);
            grantList.add(authority);
        }

        UserDetails userDetails = new User(userEntity.getUsername(), userEntity.getPassword(), grantList);

        return userDetails;
    }
}
