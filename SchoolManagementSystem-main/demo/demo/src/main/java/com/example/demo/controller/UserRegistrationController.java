package com.example.demo.controller;


import com.example.demo.service.UserService;
import com.example.demo.web.dto.UserRegistrationDto;
import jakarta.validation.Valid;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserRegistrationController {

    private UserService userService;



    public UserRegistrationController(UserService userService) {
        this.userService = userService;


    }


    /* Used to trim inputs from the view --> removing whitespaces*/
    @InitBinder
    public  void initBinder(WebDataBinder dataBinder)
    {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }


    /*Return an empty object to the register page*/
    @GetMapping("/register")
    public String register(@ModelAttribute UserRegistrationDto userRegistrationDto, Model model)
    {

        model.addAttribute("user", userRegistrationDto);
        return "register";

    }


    /*Handle method*/
    /*its parameter user model attribute anno we parse the user object this object contains the form data and we bind the form data to the userRegisterDto object */

    @PostMapping("/register")
    public String registerUser(@Valid @ModelAttribute("user")UserRegistrationDto userRegistrationDto, BindingResult bindingResult, RedirectAttributes redirectAttributes)
    {

        if (userService.userExist(userRegistrationDto.getUsername()))
        {
            bindingResult.addError(new FieldError("user", "username","Username exist or taken, Enter new username."));
        }

        if(bindingResult.hasErrors())
        {
            return "register";

        }else{

            userService.save(userRegistrationDto, "USER");

            redirectAttributes.addFlashAttribute("message", "You have successfully registered, Please login.");
            /*return the registration view*/
            return "redirect:/login";
        }


    }
}
