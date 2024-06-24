package com.example.demo.web.dto;

public class MessageDto {

    private String title;
    private String posted_by;
    private String Grade;
    private String description;

    public MessageDto() {
    }

    public MessageDto(String title, String from, String grade, String description) {
        this.title = title;
        this.posted_by = from;
        this.Grade = grade;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPosted_by() {
        return posted_by;
    }

    public void setPosted_by(String posted_by) {
        this.posted_by = posted_by;
    }

    public String getGrade() {
        return Grade;
    }

    public void setGrade(String grade) {
        Grade = grade;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
