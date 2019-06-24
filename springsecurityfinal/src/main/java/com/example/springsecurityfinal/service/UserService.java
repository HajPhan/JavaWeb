package com.example.springsecurityfinal.service;

import com.example.springsecurityfinal.model.UserEntity;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    UserEntity getUserByName(String name);
}
