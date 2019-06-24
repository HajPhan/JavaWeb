package com.example.springbootjwtjpasecurity.us;

// Thực hiện xác thực người dùng

import com.example.springbootjwtjpasecurity.model.UserEntity;
import com.example.springbootjwtjpasecurity.service.JwtService;
import com.example.springbootjwtjpasecurity.service.UserDetailServiceImpl;
import com.example.springbootjwtjpasecurity.service.UserRoleService;
import com.example.springbootjwtjpasecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JwtAuthenticationTokenFilter extends UsernamePasswordAuthenticationFilter {

    private final static String TOKEN_HEADER = "Authorization";

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserService userService;

    @Autowired
    private UserRoleService userRoleService;

    @Autowired
    private UserDetailServiceImpl userDetailService;

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) req;
        String authToken = httpRequest.getHeader(TOKEN_HEADER);

        if(jwtService.validateTokenLogin(authToken)){
            String username = jwtService.getUsernameFromToken(authToken);

            UserEntity userEntity = this.userService.getUserEntityByUserName(username);
//            UserDetails userDetails = this.userDetailService.loadUserByUsername(username);

            if(userEntity != null){

                boolean enabled = true;
                boolean accountNonExpired = true;
                boolean credentialNonExpired = true;
                boolean accountNonLocked = true;

                List<String> grantList = this.userRoleService.getUserRoleNameByUserId(userEntity.getId());
                List<GrantedAuthority> roleName = new ArrayList<GrantedAuthority>();
                if(grantList != null){
                    for (String role : grantList){
//                        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role);
//                        roleName.add(grantedAuthority);
                        roleName.add(new SimpleGrantedAuthority(role));
                    }
                }
                UserDetails userDetails = new User(username,userEntity.getPassword(),enabled,accountNonExpired,
                        credentialNonExpired,accountNonLocked,roleName);

                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                        userDetails,null,userDetails.getAuthorities());

                authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpRequest));
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }
        }

       chain.doFilter(req,res);
    }
}
