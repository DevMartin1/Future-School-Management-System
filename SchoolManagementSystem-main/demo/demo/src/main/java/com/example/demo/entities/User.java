package com.example.demo.entities;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Date;

@Entity
@Table(name="user_tbl", uniqueConstraints = @UniqueConstraint(columnNames = "username"))
public class User {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;
    private String user_name;
    private String username;
    private String password;
    private String grade;
    @Temporal(TemporalType.TIMESTAMP)
    private Date creation_time;
    @ManyToMany(fetch = FetchType.EAGER, cascade =  CascadeType.ALL)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(
                    name = "user_id",referencedColumnName = "id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id"))
    private Collection<Role> roles;

    public User(String user_name, String username, Date creation_time, String password, Collection<Role> roles, String grade) {
        this.user_name = user_name;
        this.username = username;
        this.creation_time = creation_time;
        this.password = password;
        this.roles = roles;
        this.grade = grade;

    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Date getCreation_time() {
        return creation_time;
    }

    public void setCreation_time(Date creation_time) {
        this.creation_time = creation_time;
    }

    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
