package com.example.springbootdemojwt.filter;

import com.example.springbootdemojwt.service.TokenAuthenticationService;
import com.nimbusds.jose.KeyLengthException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;

/*
    - Khi một request với đường dẫn /login gửi đến Server, nó sẽ được xử lý bởi JWTLoginFilter
    - Lớp này sẽ kiểm tra username/password nếu hợp lệ một chuỗi ủy quyền (Authorization string) sẽ được
    - đính kèm vào Response Header trả về cho Client.
 */

public class JWTLoginFilter extends AbstractAuthenticationProcessingFilter {

    public JWTLoginFilter(String url, AuthenticationManager authManager) {
        super(new AntPathRequestMatcher(url));
        setAuthenticationManager(authManager);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        System.out.printf("JWTLoginFilter.atamptAuthentication: username/password=%s,%s",username,password);
        System.out.println();
        System.out.println("-----> " + getAuthenticationManager().authenticate(new UsernamePasswordAuthenticationToken(username,password, Collections.emptyList())).getPrincipal().toString());
        return getAuthenticationManager().authenticate(new UsernamePasswordAuthenticationToken(username,password, Collections.emptyList()));
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        System.out.println("JWTLoginFilter.successfulAuthentication.");

        //Write Authorization to Headers of Response
        try {
            TokenAuthenticationService.addAuthentication(response, authResult.getName());
        } catch (KeyLengthException e) {
            e.printStackTrace();
        }

        String authorizationString = response.getHeader("Authorization");

        System.out.println("Authorization String = " + authorizationString);
    }
}
