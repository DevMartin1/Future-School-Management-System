package com.example.demo.web.dto;

import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotBlank;

public class StaffDto {

    private Long id;

    private String name;
    private String last_name;
    @NotBlank
    private String username;
    private String grade;
    private String contact;
    private String password;
    private String picture;


    public StaffDto() {
    }

    public StaffDto(String name, String last_name, String username, String grade, String contact, String password, String picture) {
        this.name = name;
        this.last_name = last_name;
        this.username = username;
        this.grade = grade;
        this.contact = contact;
        this.password = password;
        this.picture = picture;


    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public @NotBlank String getUsername() {
        return username;
    }

    public void setUsername(@NotBlank String username) {
        this.username = username;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    @Transient
    public String getFileLocation(){
        return "/uploads/staff/" + id + "/" + picture;
    }
}
