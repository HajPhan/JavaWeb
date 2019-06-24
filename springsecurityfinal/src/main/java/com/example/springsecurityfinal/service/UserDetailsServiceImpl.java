package com.example.springsecurityfinal.service;

import com.example.springsecurityfinal.model.UserEntity;
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
        UserEntity userEntity = this.userService.getUserByName(username);

        if(userEntity == null){
            System.out.println("User not found! " + username);
            throw new UsernameNotFoundException("User " + username + " was not found in the database");
        }

        System.out.println("Found User: " + username);

        // get Role Name by user id
        List<String> rollName = this.userRoleService.getRoleNameByUserId(userEntity.getUserId());

        //
        List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
        if(rollName != null){
            for(String role : rollName){
                GrantedAuthority authority = new SimpleGrantedAuthority(role);  //ep kieu role (string => GrantedAuthority)
                grantList.add(authority);
            }
        }

        UserDetails userDetails = new User(userEntity.getUserName(),userEntity.getUserPassword(),grantList);
        return userDetails;
    }
}
