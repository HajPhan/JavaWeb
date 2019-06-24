package com.example.springbootjwt.service;

import com.example.springbootjwt.model.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    public static List<User> listUser = new ArrayList<User>();

    static {
        User user1 = new User(1, "hai", "123");
        user1.setRole(new String[]{"ROLE_ADMIN"});

        User user2 = new User(2, "van", "123");
        user2.setRole(new String[]{"ROLE_USER"});

        listUser.add(user1);
        listUser.add(user2);
    }

    public List<User> findAll() {
        return listUser;
    }

    public User findById(int id) {
        for (User user : listUser) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    public boolean add(User user) {
        for (User userExist : listUser) {
            if (user.getId() == userExist.getId() || StringUtils.equals(user.getUsername(), userExist.getUsername())) {
                return false;
            }
        }
        listUser.add(user);
        return true;
    }

    public boolean update(User user, int id){
        for (User userExist : listUser){
            if(id == userExist.getId()){
                userExist.setUsername(user.getUsername());
                userExist.setPassword(user.getPassword());
                userExist.setRole(user.getRole());
                return true;
            }
        }
        return false;
    }

    public void delete(int id) {
        listUser.removeIf(user -> user.getId() == id);
    }

    public User loadUserByUsername(String username) {
        for (User user : listUser) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    public boolean checkLogin(User user) {
        for (User userExist : listUser) {
            if (StringUtils.equals(user.getUsername(), userExist.getUsername())
                    && StringUtils.equals(user.getPassword(), userExist.getPassword())) {
                return true;
            }
        }
        return false;
    }
}
