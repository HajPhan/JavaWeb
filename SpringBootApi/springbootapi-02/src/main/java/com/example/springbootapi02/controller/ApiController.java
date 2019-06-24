package com.example.springbootapi02.controller;

import com.example.springbootapi02.model.UserEntity;
import com.example.springbootapi02.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class ApiController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user/", method = RequestMethod.GET)
    public Iterable<UserEntity> listUser() {
        Iterable<UserEntity> user = this.userService.getAllUser();
        return this.userService.getAllUser();
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public UserEntity getUser(@PathVariable int id) {
        return this.userService.getUserById(id);
    }

    @RequestMapping(value = "/user/", method = RequestMethod.POST)
    public void createUser(@RequestBody UserEntity userEntity) {
        this.userService.saveUser(userEntity);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
    public void updateUser(@RequestBody UserEntity userEntity, @PathVariable int id) {
        userEntity.setId(id);
        this.userService.saveUser(userEntity);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable int id) {
        this.userService.deleteUserById(id);
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//    @RequestMapping(value = "/user/list/", method = RequestMethod.GET)
//    public ResponseEntity<List<UserEntity>> getAllUserEntity() {
//        List<UserEntity> list = (List<UserEntity>) this.userService.getAllUser();
//        if (list == null) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<List<UserEntity>>(list, HttpStatus.OK);
//    }
//
//    @RequestMapping(value = "/user/list/{id}", method = RequestMethod.GET)
//    public ResponseEntity<UserEntity> getUserEntityById(@PathVariable int id) {
//        UserEntity user = this.userService.getUserById(id);
//        return new ResponseEntity<UserEntity>(user, HttpStatus.OK);
//    }
//
//    @RequestMapping(value = "/user/list/", method = RequestMethod.POST)
//    public void createUserEntity(@RequestBody UserEntity userEntity, UriComponentsBuilder ucBuilder) {
//        this.userService.saveUser(userEntity);
//        HttpHeaders headers = new HttpHeaders();
//        headers.setLocation(ucBuilder.path("/api/user/list/{id}").buildAndExpand(userEntity.getId()).toUri());
//        return new ResponseEntity<String>(headers, HttpStatus.OK);
//    }





}
