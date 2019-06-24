package com.example.SpringBootRestfulJpaNotSecurity.controller;

import com.example.SpringBootRestfulJpaNotSecurity.model.UserEntity;
import com.example.SpringBootRestfulJpaNotSecurity.service.UserService;
import com.example.SpringBootRestfulJpaNotSecurity.util.CustomErrorType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class RestApiController {
    public static final Logger logger = LoggerFactory.getLogger(RestApiController.class);

    @Autowired
    UserService userService;

    //-------------------------- Retrieve All Users -----------------------------//
    @RequestMapping(value = "/user/", method = RequestMethod.GET)
    public ResponseEntity<List<UserEntity>> listAllUsers() {
        List<UserEntity> users = (List<UserEntity>) userService.findAllUsers();
        if (users.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<UserEntity>>(users, HttpStatus.OK);
    }


    //-------------------------- Retrieve Single User -------------------------//
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getUser(@PathVariable int id) {
        logger.info("Fetching User With Id{}", id);
        UserEntity user = userService.findUserById(id);
        if (user == null) {
            logger.error("User with id {} not found.", id);
            return new ResponseEntity(new CustomErrorType("User with id " +
                    id + " not found"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<UserEntity>(user, HttpStatus.OK);
    }


    //-------------------------- Create a User ------------------------------//
    @RequestMapping(value = "/user/", method = RequestMethod.POST)
    public ResponseEntity<?> createUser(@RequestBody UserEntity user, UriComponentsBuilder ucBuilder) {
        logger.info("Creating User : {}", user);
        if (userService.isUserExist(user)) {
            logger.error("Ubable to create. A User with name {} already exits", user.getFullName());
            return new ResponseEntity(new CustomErrorType("Unable to crate. A User with name " +
                    user.getUserName() + " already exist."), HttpStatus.CONFLICT);
        }
        userService.saveUser(user);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/api/user/{id}").buildAndExpand(user.getId()).toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }


    //--------------------------- Update a User ----------------------------//
    @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateUser(@PathVariable int id, @RequestBody UserEntity user) {
        logger.info("Updating User with id {}", id);

        UserEntity currentUser = userService.findUserById(id);
        if (currentUser == null) {
            logger.error("Unable to update. User with id {} not found.", id);
            return new ResponseEntity(new CustomErrorType("Unable to update. User with id " + id + " not found"), HttpStatus.NOT_FOUND);
        }
        currentUser.setFullName(user.getFullName());
        currentUser.setUserName(user.getUserName());
        currentUser.setPassWord(user.getPassWord());
//        if (userService.isUserExist(user)) {
//            logger.error("Ubable to create. A User with name {} already exits", user.getFullName());
//            return new ResponseEntity(new CustomErrorType("Unable to crate. A User with name " +
//                    user.getUserName() + " already exist."), HttpStatus.CONFLICT);
//        }
        userService.saveUser(currentUser);
        return new ResponseEntity<UserEntity>(currentUser, HttpStatus.OK);
    }

    //------------------------ Delete a User -----------------------------//
    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteUser(@PathVariable int id) {
        logger.info("Fetching & Deleting User with id {}", id);

        UserEntity user = userService.findUserById(id);
        if (user == null) {
            logger.error("Unable to delete. User with id {} not found.", id);
            return new ResponseEntity(new CustomErrorType("Unable to delete. User with id " + id + " not found"), HttpStatus.NOT_FOUND);
        }
        userService.deleteUserById(id);
        return new ResponseEntity<UserEntity>(HttpStatus.NO_CONTENT);
    }

    //----------------------- Delete All Users ---------------------------//
    @RequestMapping(value = "/user/", method = RequestMethod.DELETE)
    public ResponseEntity<UserEntity> deleteAllUsers() {
        logger.info("Deleteing All Users");
        userService.deleteAllUsers();
        return new ResponseEntity<UserEntity>(HttpStatus.NO_CONTENT);
    }

    //---------------------- Search User ------------------------------------//
    @RequestMapping(value = "/user/search", method = RequestMethod.GET)
    public ResponseEntity<List<UserEntity>> searchUserByName(@RequestParam("stringSearch") String stringSearch, Model model){
        logger.info("Search User");
        List<UserEntity> list = userService.searchUser(stringSearch);
        if(list.isEmpty()){
            logger.error("User with fullname {} not found."+stringSearch);
            return new ResponseEntity(new CustomErrorType("User with name " + stringSearch + " not found!"),HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<UserEntity>>(list,HttpStatus.OK);
    }
}



