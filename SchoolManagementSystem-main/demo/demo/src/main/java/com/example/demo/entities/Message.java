package com.example.demo.entities;

import jakarta.persistence.*;

import java.util.Date;
@Entity
@Table(name = "message_tbl")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String posted_by;
    private String grade;
    private String description;
    @Temporal(TemporalType.DATE)
    private Date creation_date;

    public Message(String title, String from, String grade, String description, Date creation_date) {
        this.posted_by = from;
        this.title = title;
        this.grade = grade;
        this.description = description;
        this.creation_date = creation_date;
    }

    public Message() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPosted_by() {
        return posted_by;
    }

    public void setPosted_by(String posted_by) {
        this.posted_by = posted_by;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(Date creation_date) {
        this.creation_date = creation_date;
    }
}


