package com.example.demospringboot.configuration;

import com.example.demospringboot.service.UserDetailsServiceImpl;
import com.example.demospringboot.utils.AuthenticationFilterUtils;
import com.example.demospringboot.utils.CustomAccessDeniedHandler;
import com.example.demospringboot.utils.CustomAuthenticationEntryPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class WebSercurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Autowired
    protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }


    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers("/home/**","/css/**","/js/**");
    }

    @Bean
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Bean
    public AuthenticationFilterUtils authenticationFilterUtils() throws Exception {
        AuthenticationFilterUtils authenticationFilterUtils = new AuthenticationFilterUtils();
        authenticationFilterUtils.setAuthenticationManager(authenticationManager());
        return authenticationFilterUtils;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers("/","/login/**","/logout/**","/js/**","/css/**").permitAll()
//                .antMatchers("/userInfo/**","/user-view/**").access("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
//                .antMatchers("/admin/**","/user-save/**","/user-update/**","/deleteUser/**").access("hasRole('ROLE_ADMIN')")
//                .and()
//                .exceptionHandling().accessDeniedPage("/403")
//                .and()
//                .formLogin()
//                    .loginProcessingUrl("/j_spring_security_check")
//                    .loginPage("/login")
//                    .defaultSuccessUrl("/userInfo")
//                    .failureForwardUrl("/login?message=error")
//                    .usernameParameter("username")
//                    .passwordParameter("password")
//                .and()
//                .logout()
//                    .logoutUrl("/j_spring_security_logout")
//                    .logoutSuccessUrl("/logout?message=logout");

        http
                .httpBasic().authenticationEntryPoint(new CustomAuthenticationEntryPoint())
                .and()
                .authorizeRequests()
                    .antMatchers("/user-view/**").access("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
                    .antMatchers("/user-save/**","/user-update/**","/deleteUser/**").access("hasRole('ROLE_ADMIN')")
                    .anyRequest()
                    .hasAnyAuthority("ROLE_USER","ROLE_ADMIN")
                .and()
                .formLogin()
                    .loginPage("/login")
                    .defaultSuccessUrl("/userInfo")
                    .failureUrl("/login?message=error")
                    .permitAll()
                    .and()
                .logout()
                    .logoutUrl("/logout")
                    .logoutSuccessUrl("/login?message=logout")
                    .permitAll()
                    .and()
                .csrf()
                    .disable()
                .addFilterBefore(authenticationFilterUtils(), UsernamePasswordAuthenticationFilter.class)
                .exceptionHandling()
                    .accessDeniedHandler(new CustomAccessDeniedHandler());
//                    .accessDeniedPage("/403");
    }
}
