package com.example.springbootrestful.controller;

import com.example.springbootrestful.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/rest")
public class UserRestController {
    public static HashMap<Integer, User> mapUser = new HashMap<Integer, User>();

    static {
        mapUser.put(1, new User(1, "phan", "123456"));
        mapUser.put(2, new User(2, "van", "admin1234"));
        mapUser.put(3, new User(3, "hai", "123hai"));
        mapUser.put(4, new User(4, "peter", "123"));
        mapUser.put(5, new User(5, "john", "john123"));
    }

    /* Get All User */
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ResponseEntity<List<User>> getAllUser() {
        List<User> listUser = new ArrayList<User>(mapUser.values());
        return new ResponseEntity<List<User>>(listUser, HttpStatus.OK);
    }


    /* Get User By Id */
    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> getUserById(@PathVariable int id) {
        User user = mapUser.get(id);
        if (user != null) {
            return new ResponseEntity<Object>(user, HttpStatus.OK);
        }
        return new ResponseEntity<Object>("Not Found User", HttpStatus.NOT_FOUND);
    }


    /* Create New User */
    public ResponseEntity<String> createUser(@RequestBody User user){
        if(mapUser.containsKey(user.getId())){
            return new ResponseEntity<String>("User Already Exitst!",HttpStatus.CONFLICT);
        }
        mapUser.put(user.getId(),user);
        return new ResponseEntity<String>("Create!",HttpStatus.CREATED);
    }

    /* Delete User */
    public ResponseEntity<String> deleteUserById(@PathVariable int id){
        User user = mapUser.get(id);
        if(user == null){
            return new ResponseEntity<String>("Not Found User",HttpStatus.OK);
        }
        mapUser.remove(id);
        return new ResponseEntity<String>("Deleted!",HttpStatus.OK);
    }

    /* Update User */
    public ResponseEntity<String> updateUser(@RequestBody User user){
        User oldUser = mapUser.get(user.getId());
        if(oldUser == null){
            return new ResponseEntity<String>("Not Found User",HttpStatus.NOT_FOUND);
        }

        // replace old user by new user
        mapUser.put(user.getId(),user);
        return new ResponseEntity<String>("Updated!",HttpStatus.OK);
    }
}


