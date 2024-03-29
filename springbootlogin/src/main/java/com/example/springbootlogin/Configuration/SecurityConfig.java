package com.example.springbootlogin.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().passwordEncoder(passwordEncoder())
                .withUser("hai").password("$2a$04$Q2Cq0k57zf2Vs/n3JXwzmerql9RzElr.J7aQd3/Sq0fw/BdDFPAj.").roles("ADMIN");

        auth.inMemoryAuthentication().passwordEncoder(passwordEncoder())
                .withUser("van").password("$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu").roles("USER");
//        auth.inMemoryAuthentication().passwordEncoder()

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Chỉ cho phép user có quyền ADMIN truy cập đường dẫn /admin/**
        http.authorizeRequests().antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')");

        // Chỉ cho phép user có quyền ADMIN hoặc USER truy cập đường dẫn /user/**
        http.authorizeRequests().antMatchers("/user/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')");

        // Khi người dùng login, với vai trò USER, nhưng truy cập vào trang yêu cầu ADMIN, sẽ chuyển hướng tới trang /403
        http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");

//        // Cấu hình cho Login Form
        http.authorizeRequests().and().formLogin().loginProcessingUrl("/j_spring_security_login").loginPage("/login").defaultSuccessUrl("/user").failureUrl("/login?message=error").usernameParameter("username").passwordParameter("password").and().logout().logoutUrl("/j_spring_security_logout").logoutSuccessUrl("/login?message=logout");
//        http.authorizeRequests().and().formLogin().loginProcessingUrl("/j_spring_security_login").loginPage("/login").defaultSuccessUrl("/user").failureUrl("/login?message=error").usernameParameter("username").passwordParameter("password").and().logout().logoutUrl("/j_spring_security_logout").logoutSuccessUrl("/login?message=logout");


        // Cấu hình cho Login Form.
        http.authorizeRequests().and().formLogin()//
                .loginProcessingUrl("/j_spring_security_login")//
                .loginPage("/login")//
                .defaultSuccessUrl("/user")//
                .failureUrl("/login?message=error")//
                .usernameParameter("username")//
                .passwordParameter("password")
                // Cấu hình cho Logout Page.
                .and().logout().logoutUrl("/j_spring_security_logout").logoutSuccessUrl("/login?message=logout");
    }
}
