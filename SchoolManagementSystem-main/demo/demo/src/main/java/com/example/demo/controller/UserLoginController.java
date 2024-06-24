package com.example.demo.controller;

import com.example.demo.entities.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class UserLoginController {



    @Autowired
    UserService userService ;


    @GetMapping("/login")
    public String login()
    {
        return "login";
    }


    @GetMapping("/home_page")
    public String home(Model model, Principal principal)
    {

        UserDetails userDetails = userService.loadUserByUsername(principal.getName());
        String role = userDetails.getAuthorities().toString();

        model.addAttribute("userDetail",userDetails);
        model.addAttribute("role",role);

        return "home_page";
    }
}
