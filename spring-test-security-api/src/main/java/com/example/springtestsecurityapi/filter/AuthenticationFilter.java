package com.example.springtestsecurityapi.filter;

import com.example.springtestsecurityapi.utils.GetTokenForLogin;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        System.out.println("Filter!");
        HttpServletRequest request = (HttpServletRequest) req;
        HttpSession session = request.getSession();
        System.out.println("username = " + req.getParameter("username"));
        System.out.println("password = " + req.getParameter("password"));

        String token = String.valueOf(session.getAttribute("token"));
        if(token == null){
            System.out.println("Token = " + token);
        }
        chain.doFilter(req,res);
    }
}
