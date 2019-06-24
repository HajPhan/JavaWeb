package com.example.springbootrestbasicauthentication.configuration;

import com.example.springbootrestbasicauthentication.authentication.AuthenticationEntryPointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.InMemoryUserDetailsManagerConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    AuthenticationEntryPointImpl authEntryPoint;

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder managerBuilder) throws Exception {
        String password = "123";
        String encrytedPassword = this.passwordEncoder().encode(password);
        InMemoryUserDetailsManagerConfigurer<AuthenticationManagerBuilder> managerConfigurer = managerBuilder.inMemoryAuthentication();

        // Định nghĩa 2 người dùng, lưu trữ trong bộ nhớ.
        // Spring auto add ROLE_...
        UserDetails user1 = User.withUsername("hai").password(encrytedPassword).roles("USER").build();
        UserDetails user2 = User.withUsername("van").password(encrytedPassword).roles("USER").build();

        managerConfigurer.withUser(user1);
        managerConfigurer.withUser(user2);

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest().authenticated().and()  // Tất cả các request gửi tới Web Server yêu cầu phải xác th
                .httpBasic().authenticationEntryPoint(authEntryPoint);
    }
}
