package com.example.springbootlogingoogle.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

//    private

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().passwordEncoder(passwordEncoder()).withUser("hai")
                .password("$2a$10$wyFNCd9e4d/5oTBP3/G/c.6nwNkUmB0YuGLz1tr5SPgW62z4QKU1y")
                .roles("ADMIN");

        auth.inMemoryAuthentication().passwordEncoder(passwordEncoder()).withUser("va")
                .password("$2a$10$wyFNCd9e4d/5oTBP3/G/c.6nwNkUmB0YuGLz1tr5SPgW62z4QKU1y")
                .roles("USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // chỉ cho phép user có quyền ADMIN truy cập đường dẫn /admin/**
        http.authorizeRequests().antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')");

        // Chỉ cho phép user có quyền ADMIN hoặc USER truy cập đường dẫn /user/**
        http.authorizeRequests().antMatchers("/user/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')");

        // Khi người dùng đã login, với vài trò USER, nhưng truy cập vào trang yêu cầu vai trò ADMIN, thì sẽ chuyển tới trang /403
        http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");

        // Cấu hình login form
        http.authorizeRequests().and()
                .formLogin()
                    .loginProcessingUrl("/j_spring_security_login")
                    .loginPage("/login")
                    .defaultSuccessUrl("/user")
                    .failureUrl("/login?message=error")
                    .usernameParameter("username")
                    .passwordParameter("password")
                    .and()
                .logout()
                    .logoutUrl("/j_spring_security_logout")
                    .logoutSuccessUrl("/login?message=logout");
    }
}
