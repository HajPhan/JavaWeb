package com.example.springbootjwtjpasecurity.controller;

import com.example.springbootjwtjpasecurity.model.UserEntity;
import com.example.springbootjwtjpasecurity.service.JwtService;
import com.example.springbootjwtjpasecurity.service.UserService;
import com.example.springbootjwtjpasecurity.utils.PasswordEncoderUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class UserRestController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtService jwtService;

    @RequestMapping(value = "/user/", method = RequestMethod.GET)
    public ResponseEntity<List<UserEntity>> listUserEntity() {
        List<UserEntity> user = (List<UserEntity>) this.userService.getAllUserEntity();
        return new ResponseEntity<List<UserEntity>>(user, HttpStatus.OK);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> getUserEntity(@PathVariable int id) {
        UserEntity user = this.userService.getUserEntityById(id);
        if (user == null) {
            return new ResponseEntity<Object>("User Not Found!", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Object>(user, HttpStatus.OK);
    }

    @RequestMapping(value = "/user/", method = RequestMethod.POST)
    public ResponseEntity<String> createUserEntity(@RequestBody UserEntity userEntity) {
        userEntity.setPassword(PasswordEncoderUtils.passwordEncoder(userEntity.getPassword()));
        this.userService.saveUserEntity(userEntity);
        return new ResponseEntity<String>("Created!", HttpStatus.OK);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
    public ResponseEntity<String> updateUserEntity(@RequestBody UserEntity userEntity, @PathVariable int id) {
        UserEntity user = this.userService.getUserEntityById(id);
        if (user == null) {
            return new ResponseEntity<>("User Not Found!", HttpStatus.NOT_FOUND);
        }

        /* Update c1 */
//        user.setFullname(userEntity.getFullname());
//        user.setUsername(userEntity.getUsername());
//        user.setPassword(userEntity.getPassword());
//        this.userService.saveUserEntity(user);

        /* Update c2 */
        userEntity.setId(id);
        this.userService.saveUserEntity(userEntity);
        return new ResponseEntity<String>("Updated!", HttpStatus.OK);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteUserEntity(@PathVariable int id) {
        UserEntity user = this.userService.getUserEntityById(id);
        if (user == null) {
            return new ResponseEntity<String>("User Not Found!", HttpStatus.NOT_FOUND);
        }
        this.userService.deleteUserEntityById(id);
        return new ResponseEntity<String>("Deleted!", HttpStatus.OK);
    }


    /*-------------------------- Login USER ---------------------------------*/
    @RequestMapping(value = "/login/", method = RequestMethod.POST)
    public ResponseEntity<String> loginPage(HttpServletRequest request, @RequestBody UserEntity userEntity) {
        String result = "";
        HttpStatus httpStatus = null;
        try {
            if (this.userService.checkLogin(userEntity)) {
                result = jwtService.generateTokenLogin(userEntity.getUsername());
                httpStatus = HttpStatus.OK;
            } else {
                result = "Wrong Password or Username!";
                httpStatus = HttpStatus.BAD_REQUEST;
            }
        } catch (Exception e) {
            result = "Server error!";
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<String>(result, httpStatus);
    }

}
