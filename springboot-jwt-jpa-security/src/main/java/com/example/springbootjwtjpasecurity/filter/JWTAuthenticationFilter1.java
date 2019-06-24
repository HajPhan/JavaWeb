package com.example.springbootjwtjpasecurity.filter;

import com.example.springbootjwtjpasecurity.model.UserEntity;
import com.example.springbootjwtjpasecurity.service.JwtService;
import com.example.springbootjwtjpasecurity.service.UserDetailServiceImpl;
import com.example.springbootjwtjpasecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class JWTAuthenticationFilter1 extends UsernamePasswordAuthenticationFilter {

    private final static String TOKEN_HEADER = "Authorization";

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserDetailServiceImpl userDetailService;

    @Autowired
    private UserService userService;

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)req;
        String authToken = request.getHeader(TOKEN_HEADER);
        if(jwtService.validateTokenLogin(authToken)){
            String username = jwtService.getUsernameFromToken(authToken);
            UserDetails user = userDetailService.loadUserByUsername(username);
            UserEntity userReal = this.userService.getUserEntityByUserName(username);
            if(userReal != null){
                boolean enabled = true;
                boolean accountNonExpired = true;
                boolean credentialsNonExpired = true;
                boolean accountNonLoked = true;

                UserDetails userDetails = new User(user.getUsername(),user.getPassword(),enabled,accountNonExpired,credentialsNonExpired,accountNonExpired,user.getAuthorities());
                UsernamePasswordAuthenticationToken authenticaion = new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(authenticaion);
            }
        }
        super.doFilter(req, res, chain);
    }
}
