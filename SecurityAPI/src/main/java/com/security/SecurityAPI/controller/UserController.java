package com.security.SecurityAPI.controller;

import com.security.SecurityAPI.entity.UserEntity;
import com.security.SecurityAPI.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/home")
    public String welcome(){
        return  "hello";
    }

    @PostMapping("/add")
    public ResponseEntity<UserEntity> userAdd(@RequestBody UserEntity userEntity){


        UserEntity user = userService.addUser(userEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @GetMapping("/print")
    public List<UserEntity> printData(){
       return userService.printData();
    }

    @PostMapping("/login")
    public String login(@RequestBody UserEntity user){
    return "Sucess";
    }
}





