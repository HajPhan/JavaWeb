package com.example.springbootjwtsecurityfinally.controller;

import com.example.springbootjwtsecurityfinally.model.UserEntity;
import com.example.springbootjwtsecurityfinally.service.JwtService;
import com.example.springbootjwtsecurityfinally.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
public class UserRestController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtService jwtService;

    @RequestMapping(value = "/user/", method = RequestMethod.GET)
    public ResponseEntity<Iterable<UserEntity>> listUser() {
        Iterable<UserEntity> list = this.userService.getAllUser();
        return new ResponseEntity<Iterable<UserEntity>>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> getUser(@PathVariable int id) {
        try {
            UserEntity user = this.userService.getUserById(id);
            if (user == null) {
                return new ResponseEntity<Object>("User not found!", HttpStatus.NOT_FOUND);
            }

            return new ResponseEntity<Object>(user, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Server Error!", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/user/", method = RequestMethod.POST)
    public ResponseEntity<String> createUser(@RequestBody UserEntity userEntity) {
        this.userService.saveUser(userEntity);
        String result = "Created!";
        return new ResponseEntity<String>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
    public ResponseEntity<String> updateUser(@RequestBody UserEntity userEntity, @PathVariable int id) {
        UserEntity user = this.userService.getUserById(id);
        if (user == null) {
            return new ResponseEntity<String>("User not found!", HttpStatus.NOT_FOUND);
        }
        userEntity.setId(id);
        this.userService.saveUser(userEntity);
        return new ResponseEntity<String>("Updated!", HttpStatus.OK);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteUser(@PathVariable int id) {
        UserEntity user = this.userService.getUserById(id);
        if (user == null) {
            new ResponseEntity<String>("User not found!", HttpStatus.NOT_FOUND);
        }
        this.userService.deleteUserById(id);
        return new ResponseEntity<String>("Deleted!", HttpStatus.OK);
    }

    @RequestMapping(value = "/login/", method = RequestMethod.POST)
    public ResponseEntity<String> loginPage(@RequestBody UserEntity userEntity) {
        String result = "";
        HttpStatus status = null;
        if (this.userService.checkLogin(userEntity)) {
            result = jwtService.generateTokenLogin(userEntity.getUsername());
            status = HttpStatus.OK;
        } else {
            result = "Username or Password not correct!";
            status = HttpStatus.BAD_REQUEST;
        }
        return new ResponseEntity<String>(result, HttpStatus.OK);
    }
}
