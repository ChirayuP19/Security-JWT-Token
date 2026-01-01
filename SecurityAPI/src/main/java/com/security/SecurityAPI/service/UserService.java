package com.security.SecurityAPI.service;

import com.security.SecurityAPI.entity.UserEntity;
import com.security.SecurityAPI.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;


    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public UserEntity addUser(UserEntity user){
        user.setPassword(encoder.encode(user.getPassword()));
       return userRepository.save(user);
    }

    public List<UserEntity> printData(){
        return userRepository.findAll();
    }

}




