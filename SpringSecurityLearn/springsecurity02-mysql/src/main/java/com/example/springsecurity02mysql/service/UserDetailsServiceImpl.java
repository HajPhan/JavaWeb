package com.example.springsecurity02mysql.service;

import com.example.springsecurity02mysql.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        UserEntity userEntity = this.userService.getUserByName(username);
        UserEntity userEntity = this.userService.getUserByUserName(username);
        if(userEntity == null){
            throw new UsernameNotFoundException("User 404");
        }
        return new UserPrincipal(userEntity);
    }
}
