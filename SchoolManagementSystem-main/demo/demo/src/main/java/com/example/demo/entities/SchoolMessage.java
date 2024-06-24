package com.example.demo.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class SchoolMessage {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;
    private String query_code;
    private String dscription;
    @Temporal(TemporalType.DATE)
    private Date creation_date;


    public SchoolMessage(String query_code, String dscription, Date creation_date) {

        this.query_code = query_code;
        this.dscription = dscription;
        this.creation_date = creation_date;
    }

    public SchoolMessage() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuery_code() {
        return query_code;
    }

    public void setQuery_code(String query_code) {
        this.query_code = query_code;
    }

    public String getDscription() {
        return dscription;
    }

    public void setDscription(String dscription) {
        this.dscription = dscription;
    }

    public Date getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(Date creation_date) {
        this.creation_date = creation_date;
    }
}
