package com.example.demo.service;

import com.example.demo.entities.Role;
import com.example.demo.entities.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.web.dto.UserRegistrationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl  implements UserService {


    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;

    }

    /*Method from userService that uses the repository class to save the user*/
    @Override
    public User save(UserRegistrationDto userRegistrationDto, String role) {
        User user = new User(userRegistrationDto.getUser_name(), userRegistrationDto.getUsername(), new Date(), bCryptPasswordEncoder.encode(userRegistrationDto.getPassword()), Arrays.asList(new Role(role)), userRegistrationDto.getGrade());

        /*Save user to the data base*/
        return userRepository.save(user);
    }
    @Override
    public User findUser(String username)
    {
        return userRepository.findByUsername(username);
    }
    public boolean userExist(String username)
    {

        if (userRepository.findByUsername(username) != null) {
            return true;
        }
        return false;

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);

        if (user== null)
        {
            throw new UsernameNotFoundException("Error 404");
        }else{
            return new CustomUserDetails(user);
        }

    }

}
