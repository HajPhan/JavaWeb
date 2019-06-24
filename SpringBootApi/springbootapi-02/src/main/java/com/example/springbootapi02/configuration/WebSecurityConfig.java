package com.example.springbootapi02.configuration;

import com.example.springbootapi02.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }

    @Autowired
    public void configGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().ignoringAntMatchers("/api/**");
        http.authorizeRequests().antMatchers("/**","/css/**","/js/**").permitAll();
        http.authorizeRequests().antMatchers(HttpMethod.GET,"/api/**").permitAll();
        http.authorizeRequests().antMatchers(HttpMethod.POST,"/api/**").permitAll();
        http.authorizeRequests().antMatchers(HttpMethod.PUT,"/api/**").permitAll();
        http.authorizeRequests().antMatchers(HttpMethod.DELETE,"/api/**").permitAll();

//        http.authorizeRequests()
//                .antMatchers("/login/**","/logout/**","/js/**","/css/**").permitAll()
//                .antMatchers("/","/user-view/**").access("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
//                .antMatchers("/user-save/**","/saveUser/**","/user-update/**","/updateUser/**","/deleteUser/**","/admin/**").access("hasRole('ROLE_ADMIN')")
//                .antMatchers(HttpMethod.GET,"/api/**").access("hasRole('ROLE_USER')")
//                .antMatchers(HttpMethod.POST,"/api/**").access("hasRole('ROLE_ADMIN')")
//                .antMatchers(HttpMethod.PUT,"/api/**").access("hasRole('ROLE_AMDIN')")
//                .antMatchers(HttpMethod.DELETE,"/api/**").access("hasRole('ROLE_AMDIN')")
//                .and()
//                .exceptionHandling().accessDeniedPage("/403")
//                .and()
//                .formLogin()
//                    .loginProcessingUrl("/j_spring_security_check")
//                    .loginPage("/login")
//                    .defaultSuccessUrl("/")
//                    .failureForwardUrl("/login?message=error")
//                    .usernameParameter("username")
//                    .passwordParameter("password")
//                    .and()
//                .logout()
//                    .logoutUrl("/j_spring_security_logout")
//                    .logoutSuccessUrl("/logout?message=logout")
//                    .and()
//                .csrf().disable();
    }
}
