package com.example.springsercurityformlogin.service;

import com.example.springsercurityformlogin.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceDetailsImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = this.userService.getUserByUserName(username);

        if(userEntity == null){
            throw new UsernameNotFoundException("Not Found 404");
        }
        return new UserPrincipalImpl(userEntity);
    }
}
