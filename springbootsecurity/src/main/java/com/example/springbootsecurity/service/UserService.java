package com.example.springbootsecurity.service;

import com.example.springbootsecurity.model.AppUser;

public interface UserService {
    AppUser findUserAccountByName(String name);
}
