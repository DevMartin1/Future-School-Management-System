package com.example.demo.web.dto;

public class SchoolMsgDto {

    private String query_code;
    private String dscription;


    public SchoolMsgDto(String query_code, String dscription) {
        this.query_code = query_code;
        this.dscription = dscription;
    }

    public SchoolMsgDto() {
    }

    public String getDscription() {
        return dscription;
    }

    public void setDscription(String dscription) {
        this.dscription = dscription;
    }

    public String getQuery_code() {
        return query_code;
    }

    public void setQuery_code(String query_code) {
        this.query_code = query_code;
    }
}
