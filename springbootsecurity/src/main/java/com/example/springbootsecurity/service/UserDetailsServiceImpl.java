package com.example.springbootsecurity.service;

import com.example.springbootsecurity.dao.AppRoleDao;
import com.example.springbootsecurity.dao.AppUserDao;
import com.example.springbootsecurity.model.AppUser;
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
    private AppUserDao appUserDao;

    @Autowired
    private AppRoleDao appRoleDao;

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        AppUser appUser = this.appUserDao.findUserAccount(username);
        AppUser appUser = this.userService.findUserAccountByName(username);

        if(appUser == null){
            System.out.println("User not found! " + username);
            throw new UsernameNotFoundException("User " + username + " was not found in th database");
        }

        System.out.println("Found User: " + appUser);

        //[ROLE_USER, ROLE_ADMIN,...] (danh sách Role ứng với User)
//        List<String> roleName = this.appRoleDao.getRoleNames(appUser.getUserId());
        List<String> roleName = this.roleService.getNameRolleById(appUser.getUserId());


        List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
        if(roleName != null){
            for(String role : roleName){
                //ROLE_USER, ROLE_ADMIN...
                    GrantedAuthority authority = new SimpleGrantedAuthority(role);
                    grantList.add(authority);
            }
        }

        UserDetails userDetails = (UserDetails)new User(appUser.getUserName(),appUser.getEncrytedPassword(),grantList);

        return userDetails;
    }
}
