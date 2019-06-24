package com.example.springbootjwtsecurityfinally.filter;

import com.example.springbootjwtsecurityfinally.service.JwtService;
import com.example.springbootjwtsecurityfinally.service.UserDetailsServiceImpl;
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

public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final static String TOKEN_HEADER = "Authorization";  //header.payload.signature

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        System.out.println("Remote Host: " + req.getRemoteHost());
        System.out.println("Remote Address: " + req.getRemoteAddr());
        System.out.println("Remote AuthType: " + ((HttpServletRequest) req).getAuthType());


        String authToken = request.getHeader(TOKEN_HEADER);
        if (jwtService.validateTokenLogin(authToken)) {
            String username = jwtService.getUsernameFormToken(authToken);
            UserDetails user = userDetailsService.loadUserByUsername(username);
            if (user != null) {
                boolean enabled = true;
                boolean accountNonExpired = true;
                boolean credentialsNonExpired = true;
                boolean accountNonLocked = true;

                // User => UserDetails => Seriablizable
                // User => CredenitalsContailer => Serializable
                UserDetails userDetails = new User(user.getUsername(), user.getPassword(), enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, user.getAuthorities());

                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                // SecurityContextHolder => SecurityContext => Authentication
                // SecurityContextHolder
                // SecurityContext => Serializable
                // Authentication => Principal => Serializable
            }
        }
        chain.doFilter(req, res);
    }
}
