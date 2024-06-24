package com.example.demo.web.dto;


import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

import java.util.Date;

public class UserRegistrationDto {

    @NotBlank(message = "Enter your name")
    private String user_name;
    @NotBlank(message = "Enter your username")
    private String username;
    @NotBlank(message ="Enter your grade")
    private String grade;
    @NotBlank(message = "Enter your password")
    @Length(min = 7, message = "Password must be at least 6 characters")
    private String password;
    private Date creation_time;

    public UserRegistrationDto() {
    }

    public UserRegistrationDto(String user_name, String username, String password, String grad, Date creation_time) {
        this.user_name = user_name;
        this.username = username;
        this.password = password;
        this.grade = grade;
        this.creation_time = creation_time;
    }

    public @NotBlank(message = "Enter your grade") String getGrade() {
        return grade;
    }

    public void setGrade(@NotBlank(message = "Enter your grade") String grade) {
        this.grade = grade;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreation_time() {
        return creation_time;
    }

    public void setCreation_time(Date creation_time) {
        this.creation_time = creation_time;
    }
}
