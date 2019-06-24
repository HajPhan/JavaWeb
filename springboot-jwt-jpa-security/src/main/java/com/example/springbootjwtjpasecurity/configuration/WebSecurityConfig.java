package com.example.springbootjwtjpasecurity.configuration;

import com.example.springbootjwtjpasecurity.filter.JWTAuthenticationFilter;
import com.example.springbootjwtjpasecurity.filter.JWTAuthenticationFilter1;
import com.example.springbootjwtjpasecurity.filter.JWTLoginFilter;
import com.example.springbootjwtjpasecurity.service.UserDetailServiceImpl;
import com.example.springbootjwtjpasecurity.us.CustomAccessDeniedHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    public UserDetailServiceImpl userDetailService;

    @Bean
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Bean
    public JWTAuthenticationFilter1 jwtAuthenticationFilter1() throws Exception {
        JWTAuthenticationFilter1 jwtAuthenticationFilter1 = new JWTAuthenticationFilter1();
        jwtAuthenticationFilter1.setAuthenticationManager(authenticationManager());
        return jwtAuthenticationFilter1;
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        BCryptPasswordEncoder bCryptPasswordEncoder =new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailService).passwordEncoder(NoOpPasswordEncoder.getInstance());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().ignoringAntMatchers("/api/**");
        http.authorizeRequests()
                .antMatchers("/api/login/**").permitAll()
                .antMatchers(HttpMethod.GET,"/api/user/**").access("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
                .antMatchers(HttpMethod.POST,"/api/user/**").access("hasRole('ROLE_ADMIN')")
                .antMatchers(HttpMethod.PUT,"/api/user/**").access("hasRole('ROLE_ADMIN')")
                .antMatchers(HttpMethod.DELETE,"/api/user/**").access("hasRole('ROLE_ADMIN')")
                .and()
                .addFilterBefore(jwtAuthenticationFilter1(),UsernamePasswordAuthenticationFilter.class)
                .exceptionHandling().accessDeniedHandler(new CustomAccessDeniedHandler());

//                .addFilterBefore(new JWTLoginFilter("/login",authenticationManager()), UsernamePasswordAuthenticationFilter.class)
//                .addFilterBefore(new JWTAuthenticationFilter(),UsernamePasswordAuthenticationFilter.class);
    }
}
