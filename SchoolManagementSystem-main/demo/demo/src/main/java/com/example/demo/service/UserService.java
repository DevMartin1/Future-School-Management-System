package com.example.demo.service;

import com.example.demo.entities.User;
import com.example.demo.web.dto.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    /*Method that will the save the user register*/
    User save(UserRegistrationDto userRegistrationDto, String role);

    boolean userExist(String username);
    public User findUser(String username);


}
