package com.example.demospringboot.service;

import com.example.demospringboot.model.UserEntity;
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
        UserEntity userEntity = this.userService.getUserByUsername(username);

        System.out.println("User found: " + username);
        List<String> roleName = this.userRoleService.getAllRoleNameByUserId(userEntity.getId());

        List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
        if(roleName != null) {
            for (String role : roleName) {
                grantList.add(new SimpleGrantedAuthority(role));
            }
        }
        UserDetails userDetails = new User(userEntity.getUsername(), userEntity.getPassword(), grantList);

        return userDetails;
    }
}
