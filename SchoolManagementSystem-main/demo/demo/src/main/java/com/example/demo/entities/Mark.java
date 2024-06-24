package com.example.demo.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Mark {

    @Id
    @GeneratedValue( strategy =  GenerationType.IDENTITY)
    private Long id;
    private String term;
    private String grade;
    private String learner_id;
    private Double pyhiscal_edu;
    private Double english;
    private Double maths;
    private Double science;
    private String comment;
    private Double marks_average;
    @Temporal(TemporalType.DATE)
    private Date submission_date;

    public Mark() {

    }

    public Mark(String term, String grade, String learner_id, Double pyhiscal_edu, Double english, Double maths, Double science, String comment, Double marks_average, Date submission_date) {
        this.term = term;
        this.grade = grade;
        this.learner_id = learner_id;
        this.pyhiscal_edu = pyhiscal_edu;
        this.english = english;
        this.maths = maths;
        this.science = science;
        this.comment = comment;
        this.marks_average = marks_average;
        this.submission_date = submission_date;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getLearner_id() {
        return learner_id;
    }

    public void setLearner_id(String learner_id) {
        this.learner_id = learner_id;
    }

    public Double getPyhiscal_edu() {
        return pyhiscal_edu;
    }

    public void setPyhiscal_edu(Double pyhiscal_edu) {
        this.pyhiscal_edu = pyhiscal_edu;
    }

    public Double getEnglish() {
        return english;
    }

    public void setEnglish(Double english) {
        this.english = english;
    }

    public Double getMaths() {
        return maths;
    }

    public void setMaths(Double maths) {
        this.maths = maths;
    }

    public Double getScience() {
        return science;
    }

    public void setScience(Double science) {
        this.science = science;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Double getMarks_average() {
        return marks_average;
    }

    public void setMarks_average(Double marks_average) {
        this.marks_average = marks_average;
    }

    public Date getSubmission_date() {
        return submission_date;
    }

    public void setSubmission_date(Date submission_date) {
        this.submission_date = submission_date;
    }
}
