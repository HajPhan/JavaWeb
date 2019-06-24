package com.example.springbootjwtsecurityfinally.service;

import com.example.springbootjwtsecurityfinally.model.UserEntity;
import com.example.springbootjwtsecurityfinally.repository.UserRepository;
import com.example.springbootjwtsecurityfinally.utils.PasswordEncoderUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

//    @Autowired
//    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserEntity getUserByUsername(String username) {
        return this.userRepository.findUserByUsername(username);
    }

    @Override
    public Iterable<UserEntity> getAllUser() {
        return this.userRepository.findAll();
    }

    @Override
    public UserEntity getUserById(int id) {
        return this.userRepository.findById(id).get();
    }

    @Override
    public void saveUser(UserEntity userEntity) {
        this.userRepository.save(userEntity);
    }

    @Override
    public void deleteUserById(int id) {
        this.userRepository.deleteById(id);
    }

    @Override
    public boolean checkLogin(UserEntity userEntity) {
        UserEntity user = this.userRepository.findUserByUsername(userEntity.getUsername());
        if (user != null) {
//            if (user.getPassword().equals(userEntity.getPassword())) {
//                return true;
//            }
            if (passwordEncoder.matches(userEntity.getPassword(), user.getPassword())) {
                return true;
            }
        }
        return false;
    }
}
