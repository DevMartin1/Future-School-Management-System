package com.example.demo.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.Collection;

@Entity
@Table(name="Staff_tbl")
public class Staff {


    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name")
    private String name;
    private String last_name;
    private String username;
    private String grade;
    private String contact;
    private String password;
    private String picture;

    @ManyToMany(fetch = FetchType.EAGER, cascade =  CascadeType.ALL)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(
                    name = "user_id",referencedColumnName = "id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id"))
    private Collection<Role> roles;

    public Staff(String name, String last_name, String username, String grade, String contact, String password, Collection<Role> roles, String picture) {
        this.name = name;
        this.last_name = last_name;
        this.username = username;
        this.grade = grade;
        this.contact = contact;
        this.password = password;
        this.roles = roles;
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

    public Staff() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }


    @Override
    public String toString() {
        return "Staff{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", username='" + username + '\'' +
                ", grade='" + grade + '\'' +
                ", contact='" + contact + '\'' +
                ", password='" + password + '\'' +
                ", picture='" + picture + '\'' +
                ", roles=" + roles +
                '}';
    }

    @Transient
    public String getFileLocation(){
        return "/uploads/staff/" + id + "/" + picture;
    }
}
