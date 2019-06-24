package com.example.springtestsecurityapi.configuration;

import com.example.springtestsecurityapi.filter.AuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/**","/login/**","/logout/**","/css/**","/js/**","/common/**");
    }

    @Bean
    protected PasswordEncoder passwordEncoder(){
        return  new BCryptPasswordEncoder();
    }

//    @Bean
//    @Override
//    protected AuthenticationManager authenticationManager() throws Exception {
//        return super.authenticationManager();
//    }
//
//    @Bean
//    public AuthenticationFilter authenticationFilter() throws Exception {
//        AuthenticationFilter filter = new AuthenticationFilter();
//        filter.setAuthenticationManager(authenticationManager());
//        return filter;
//    }

    @Autowired
    protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().passwordEncoder(passwordEncoder())
                .withUser("haipv")
                .password("$2a$10$wyFNCd9e4d/5oTBP3/G/c.6nwNkUmB0YuGLz1tr5SPgW62z4QKU1y")
                .roles("USER")
                .and()
                .passwordEncoder(passwordEncoder())
                .withUser("van")
                .password("$2a$10$wyFNCd9e4d/5oTBP3/G/c.6nwNkUmB0YuGLz1tr5SPgW62z4QKU1y")
                .roles("ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests().anyRequest().permitAll();
        http.authorizeRequests()
                .anyRequest().hasAnyAuthority("ROLE_USER","ROLE_ADMIN")
                .antMatchers("/user-view/**","/userInfo/**").access("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
                .antMatchers("/user-save/**","/user-update/**","/deleteUser/**","/admin/**").access("hasRole('ROLE_ADMIN')")
                .and()
                .formLogin()
                    .loginPage("/login")
                    .defaultSuccessUrl("/userInfo")
                    .failureUrl("/login?message=error")
                    .usernameParameter("username")
                    .passwordParameter("password")
                    .and()
                .logout()
                    .logoutUrl("/j_spring_security_logout")
                    .logoutSuccessUrl("/login?message=logout")
                    .and()
                .csrf()
                    .disable()
                .exceptionHandling()
                    .accessDeniedPage("/403");
//                    .and()
//                .addFilterBefore(authenticationFilter(), UsernamePasswordAuthenticationFilter.class);

    }
}
