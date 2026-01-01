package com.security.SecurityAPI.service;

import com.security.SecurityAPI.entity.UserEntity;
import com.security.SecurityAPI.entity.UserPrincipal;
import com.security.SecurityAPI.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user=userRepository.findByUsername(username);
        if(user==null){
            throw  new UsernameNotFoundException("User not found");
        }
        return new UserPrincipal(user);
    }
}
