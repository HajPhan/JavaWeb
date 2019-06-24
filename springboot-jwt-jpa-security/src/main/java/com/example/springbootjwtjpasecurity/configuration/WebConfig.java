package com.example.springbootjwtjpasecurity.configuration;

import com.example.springbootjwtjpasecurity.filter.JWTAuthenticationFilter;
import com.example.springbootjwtjpasecurity.filter.JWTLoginFilter;
import com.example.springbootjwtjpasecurity.us.CustomAccessDeniedHandler;
import com.example.springbootjwtjpasecurity.us.JwtAuthenticationTokenFilter;
import com.example.springbootjwtjpasecurity.us.RestAuthenticationEntryPoint;
import com.example.springbootjwtjpasecurity.service.UserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


public class WebConfig {

//    @Autowired
//    private UserDetailServiceImpl userDetailService;
//
//    @Bean
//    public BCryptPasswordEncoder passwordEncoder(){
//        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
//        return bCryptPasswordEncoder;
//    }

//    @Autowired
//    public void configGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetailService).passwordEncoder(passwordEncoder());
//    }


//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
////        auth.userDetailsService(userDetailService).passwordEncoder(passwordEncoder());
//        auth.userDetailsService(userDetailService).passwordEncoder(NoOpPasswordEncoder.getInstance());
//    }

//    @Bean
//    @Override
//    protected AuthenticationManager authenticationManager() throws Exception {
//        return super.authenticationManager();
//    }

//    // Thực hiện xác thực người dùng
//    @Bean
//    public JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter() throws Exception {
//        JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter = new JwtAuthenticationTokenFilter();
//        jwtAuthenticationTokenFilter.setAuthenticationManager(authenticationManager());
//        return jwtAuthenticationTokenFilter;
//    }


    // Xử lý nghững request chưa được xác thực
//    @Bean
//    public RestAuthenticationEntryPoint restAuthenticationEntryPoint(){
//        return new RestAuthenticationEntryPoint();
//    }
//
//    // Xử lý user không có quyền truy cập
//    @Bean
//    public CustomAccessDeniedHandler customAccessDeniedHandler(){
//        return new CustomAccessDeniedHandler();
//    }

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().ignoringAntMatchers("/api/**");
//        http.authorizeRequests().antMatchers("/api/login/**","/logout/**").permitAll();
//        http.authorizeRequests().antMatchers(HttpMethod.GET,"/api/**").permitAll();
//        http.authorizeRequests().antMatchers(HttpMethod.POST,"/api/**").permitAll();
//        http.authorizeRequests().antMatchers(HttpMethod.DELETE,"/api/**").permitAll();
//        http.authorizeRequests().antMatchers(HttpMethod.PUT,"/api/**").permitAll();
//
//    http.csrf().ignoringAntMatchers("/api/**");
//
//    http.authorizeRequests().antMatchers("/api/login/**").permitAll();
//    http.authorizeRequests().antMatchers(HttpMethod.GET,"/login").permitAll();
//    http.authorizeRequests().antMatchers(HttpMethod.POST,"/login").permitAll();
//
//    http.antMatcher("/api/**")
//            .httpBasic().authenticationEntryPoint(restAuthenticationEntryPoint())
//            .and()
//            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//            .and()
//            .authorizeRequests()
//                .antMatchers(HttpMethod.GET,"/api/**").access("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
//                .antMatchers(HttpMethod.POST,"/api/**").access("hasRole('ROLE_ADMIN')")
//                .antMatchers(HttpMethod.PUT,"/api/**").access("hasRole('ROLE_ADMIN')")
//                .antMatchers(HttpMethod.DELETE,"/api/**").access("hasRole('ROLE_ADMIN')")
//                .and()
//            // Add Filter 1 - JWTLoginFilter
//            .addFilterBefore(new JWTLoginFilter("/login",authenticationManager()), UsernamePasswordAuthenticationFilter.class)
//            // Add Filter 2 - JWTAuthenticationFilter
//            .addFilterBefore(new JWTAuthenticationFilter(),UsernamePasswordAuthenticationFilter.class)
//            .exceptionHandling()
//                .accessDeniedHandler(customAccessDeniedHandler());


//        http.csrf().disable().authorizeRequests()
//                // No need autentication
//                .antMatchers("/","/home").permitAll()//
//                .antMatchers(HttpMethod.POST,"/login").permitAll()//
//                .antMatchers(HttpMethod.GET,"/login").permitAll() // For Test On Browser
//                // Need authentication
//                .anyRequest().authenticated() //
//                .and() //
//                .authorizeRequests()
//                    .antMatchers(HttpMethod.GET,"/api/**").access("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
//                    .antMatchers(HttpMethod.POST,"/api/user/**").access("hasRole('ROLE_ADMIN')")
//                    .antMatchers(HttpMethod.POST,"/api/user/**").access("hasRole('ROLE_ADMIN')")
//                    .antMatchers(HttpMethod.DELETE,"/api/user/**").access("hasRole('ROLE_ADMIN')")
//                .and()
//                //
//                // Add Filter 1 - JWTLoginFiter
//                //
//                .addFilterBefore(new JWTLoginFilter("/login",authenticationManager()),UsernamePasswordAuthenticationFilter.class) //
//                //
//                // Add Filter 2 - JWTAuthenticationFilter
//                //
//                .addFilterBefore(new JWTAuthenticationFilter(),UsernamePasswordAuthenticationFilter.class);
//    }
}
