package com.example.springbootjwtjpasecurity.service;

import com.example.springbootjwtjpasecurity.model.UserEntity;
import com.example.springbootjwtjpasecurity.repository.UserRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserEntity getUserEntityByUserName(String username) {
        return this.userRepository.findUserEntitiesByUsername(username);
    }

    @Override
    public Iterable<UserEntity> getAllUserEntity() {
        return this.userRepository.findAll();
    }

    @Override
    public List<UserEntity> getAllUserEntityByFullName(String fullName) {
        return this.userRepository.findUserEntitiesByFullnameContaining(fullName);
    }

    @Override
    public UserEntity getUserEntityById(int id) {
        return this.userRepository.findById(id).get();
    }

    @Override
    public void saveUserEntity(UserEntity userEntity) {
        this.userRepository.save(userEntity);
    }

    @Override
    public void deleteUserEntityById(int id) {
        this.userRepository.deleteById(id);
    }

    @Override
    public boolean checkLogin(UserEntity userEntity) {
        UserEntity user = this.userRepository.findUserEntitiesByUsername(userEntity.getUsername());
        if (user != null) {
//            if (passwordEncoder.matches(user.getPassword(), userEntity.getPassword())) {
//                return true;
//            }
            if(user.getPassword().equals(userEntity.getPassword())){
                return true;
            }
        }
        return false;
    }
}
