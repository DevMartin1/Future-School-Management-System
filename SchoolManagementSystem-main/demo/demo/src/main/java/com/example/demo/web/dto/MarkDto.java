package com.example.demo.web.dto;

public class MarkDto {

    private String term;
    private String grade;
    private String learner_id;
    private Double pyhiscal_edu;
    private Double english;
    private Double maths;
    private Double science;
    private String comment;
    private Double marks_average;


    public MarkDto(String term, Double maths, String grade, String learner_id, Double pyhiscal_edu, Double english, Double science, String comment, Double marks_average) {
        this.term = term;
        this.maths = maths;
        this.grade = grade;
        this.learner_id = learner_id;
        this.pyhiscal_edu = pyhiscal_edu;
        this.english = english;
        this.science = science;
        this.comment = comment;
        this.marks_average = marks_average;
    }

    public MarkDto() {
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
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
}
