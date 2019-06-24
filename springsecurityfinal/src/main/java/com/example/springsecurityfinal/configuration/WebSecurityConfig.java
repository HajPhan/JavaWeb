package com.example.springsecurityfinal.configuration;

import com.example.springsecurityfinal.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsServiceImpl userDetailsServiceImpl;

//    @Bean
//    public PasswordEncoder passwordEncoder(){
//        return new BCryptPasswordEncoder();
//    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetailsServiceImpl).passwordEncoder(passwordEncoder());
        auth.userDetailsService(userDetailsServiceImpl).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http //  phan quyen request
//           .authorizeRequests()//khai bao duong dan request
//                .antMatchers("/register").permitAll() // cho phep tat ca cac use deu dc phep truy cap
//                .antMatchers("/").access("hasRole('ROLE_MEMEBER')")  // chi cho phep user co quyen la ROLE_MEMBER moi dc access
//                .antMatchers("/admin").access("hasAnyRole('ROLE_ADMIN','ROLE_USER')")  // chi cho phep user co quyen la ROLE_ADMIN moi dc access
////                .antMatchers("/user").access("hasRole.('ROLE_USER')")
//                .and()//
//           .formLogin()  // dang nhap nguoi dung
////                .loginPage("/login")   // duong dan toi trang chua form login
//                    .loginProcessingUrl("/j_spring_security_check")
//                    .loginPage("/login")
//                    .usernameParameter("username")   // gia tri cua thuoc tinh name="username" trong <input name="username">
//                    .passwordParameter("password")   // gia tri cua thuoc tinh name="password" trong <input name="password">
//                    .defaultSuccessUrl("/userInfo")         // duong dan toi trang dang nhap khi user duoc xac thuc thanh cong
//                    .failureUrl("/login?error")     // duong dan toi trang dang nhap khi user khong duoc xac thuc (xac thuc fail)
//                    .and() //
//                .logout() //
//                    .logoutUrl("/logout")
//                    .logoutSuccessUrl("/login?message=logout")
//                    .and()
//                .exceptionHandling()
//                    .accessDeniedPage("/403");


        http.csrf().disable();

        // Các trang không yêu cầu login
        http.authorizeRequests().antMatchers("/","login","/logout").permitAll();

        // Trang /userInfo yêu cầu phải login với vai trò ROLE_USER hoặc ROLE_ADMIN.
        // Nếu chưa login, nó sẽ redirect tới trang /login.
        http.authorizeRequests().antMatchers("/userInfo")
                .access("hasAnyRole('ROLE_USER','ROLE_ADMIN')");

//        http.authorizeRequests().antMatchers("/userInfo").access("hasRole('ROLE_USER')");
        http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");

        // Trang chỉ dành cho ADMIN
        http.authorizeRequests().antMatchers("/admin")
                .access("hasRole('ROLE_ADMIN')");

        // Cấu hình cho Login Form.
        http.authorizeRequests().and().formLogin()//
                .loginProcessingUrl("/j_spring_security_check")//
                .loginPage("/login")//
                .defaultSuccessUrl("/userInfo")//
                .failureUrl("/login?error=true")//
                .usernameParameter("username")//
                .passwordParameter("password")
                // Cấu hình cho Logout Page.
//                .and().logout().logoutUrl("/j_spring_security_logout").logoutSuccessUrl("/login?message=logout");
                .and().logout().logoutUrl("/j_spring_security_logout").logoutSuccessUrl("/login?message=logout");

    }
}
