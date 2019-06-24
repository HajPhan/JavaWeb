package com.example.springboot2.configuration;

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class MainSecurityConfig extends WebSecurityConfigurerAdapter {
}
