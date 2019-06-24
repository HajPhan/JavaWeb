package com.example.springsecurityformloginjpa.configuration;

import com.example.springsecurityformloginjpa.service.UserDetailsSeriveImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.InMemoryTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsSeriveImpl userDetailsSerives;

    @Autowired
    private DataSource dataSource;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }

    @Autowired
    public void configGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsSerives).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

//        http.csrf().disable();
//
//        http.authorizeRequests().antMatchers("/", "login", "/logout").permitAll();
//
////        http.authorizeRequests().antMatchers("/userInfo").access("hasAnyRole('USER','ADMIN')");
//        http.authorizeRequests().antMatchers("/userInfo","/user-view")
//                .access("hasAnyRole('ROLE_USER','ROLE_ADMIN')");
//
////        http.authorizeRequests().antMatchers("/userInfo").hasAnyRole("USER");
//
//        http.authorizeRequests().antMatchers("/admin/**","/user-save","/user-update/**","/deleteUser/**").access("hasRole('ROLE_ADMIN')");
//
//        http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");
//
//        http.authorizeRequests().and().formLogin()
//                .loginProcessingUrl("/j_spring_security_check")
//                .loginPage("/login")
//                .defaultSuccessUrl("/userInfo")
//                .failureForwardUrl("/login?message=error")
//                .usernameParameter("username")
//                .passwordParameter("password")
//                .and().logout().logoutUrl("/j_spring_security_logout")
//                .logoutSuccessUrl("/logout?message=logout");


        http.authorizeRequests()
                .antMatchers("/", "login/**", "/logout/**", "/js/**", "/css/**","/demo/**").permitAll()
                .antMatchers("/userInfo/**", "/user-view/**").access("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
                .antMatchers("/admin/**", "/user-save/**", "/user-update/**", "/deleteUser/**").access("hasRole('ROLE_ADMIN')")
                .and().exceptionHandling().accessDeniedPage("/403")
                .and()
                .formLogin()
                    .loginProcessingUrl("/j_spring_security_check")
                    .loginPage("/login")
                    .defaultSuccessUrl("/userInfo")
                    .failureForwardUrl("/login?message=error")
                    .usernameParameter("username")
                    .passwordParameter("password")
                    .and()
                .logout()
                    .logoutUrl("/j_spring_security_logout")
                    .logoutSuccessUrl("/logout?message=logout")
                    .and()
                .rememberMe()
                    .rememberMeParameter("remember-me")
                    .tokenRepository(this.persistentTokenRepository())
                    .tokenValiditySeconds(1 * 24 * 60 * 60)
                    .userDetailsService(userDetailsSerives)
                    .and()
                .csrf().disable();

    }


    public PersistentTokenRepository persistentTokenRepository() {
        JdbcTokenRepositoryImpl db = new JdbcTokenRepositoryImpl();
        db.setDataSource(dataSource);
        return db;
    }
}
