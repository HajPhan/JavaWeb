package com.example.springbootjwt.controller;

import com.example.springbootjwt.model.User;
import com.example.springbootjwt.service.JwtService;
import com.example.springbootjwt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@RestController
@RequestMapping("/rest")
public class UserRestController {

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserService userService;


    /*-------------------------- GET ALL USER ---------------------------------*/
    @RequestMapping(value = "/user/", method = RequestMethod.GET)
    public ResponseEntity<List<User>> getAllUser() {
        return new ResponseEntity<List<User>>(userService.findAll(), HttpStatus.OK);
    }

    /*-------------------------- GET USER BY ID---------------------------------*/
    @RequestMapping(value = "/user/{id}",method = RequestMethod.GET)
    public ResponseEntity<Object> getUserById(@PathVariable int id){
        User user = userService.findById(id);;
        if(user != null){
            return new ResponseEntity<Object>(user, HttpStatus.OK);
        }
        return new ResponseEntity<Object>("Note Found User!",HttpStatus.NO_CONTENT);
    }


    /*-------------------------- CREATE NEW USER ---------------------------------*/
    @RequestMapping(value = "/user/",method = RequestMethod.POST)
    public ResponseEntity<String> createUser(@RequestBody User user){
        if(userService.add(user)){
            return new ResponseEntity<String>("Created!",HttpStatus.CREATED);
        } else {
            return new ResponseEntity<String>("User Existed!",HttpStatus.BAD_REQUEST);
        }
    }

    /*-------------------------- UPDATE USER ---------------------------------*/
    @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
    public ResponseEntity<String> updateUser(@PathVariable int id, @RequestBody User user){
        boolean isCheck = this.userService.update(user,id);
        if(isCheck == true){
            return new ResponseEntity<String>("Updated!",HttpStatus.OK);
        }
        return new ResponseEntity<String>("Update Fail!",HttpStatus.OK);
    }


    /*-------------------------- DELETE USER ---------------------------------*/
    @RequestMapping(value = "/user/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteUser(@PathVariable int id){
        this.userService.delete(id);
        return new ResponseEntity<String>("Deleted!",HttpStatus.OK);
    }


    /*-------------------------- LOGIN USER ---------------------------------*/

    @RequestMapping(value = "/login/", method = RequestMethod.POST)
    public ResponseEntity<String> login(HttpServletRequest request, @RequestBody User user) {
        String result = "";
        HttpStatus httpStatus = null;
        try {
            if (userService.checkLogin(user)) {
                result = jwtService.generateTokenLogin(user.getUsername());
                httpStatus = HttpStatus.OK;
            } else {
                result = "Wrong userId and password";
                httpStatus = HttpStatus.BAD_REQUEST;
            }
        } catch (Exception e) {
            result = "Server error!";
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<String>(result, httpStatus);
    }


}
