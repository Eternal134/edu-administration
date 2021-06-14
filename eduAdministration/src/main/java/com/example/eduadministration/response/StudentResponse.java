package com.example.eduadministration.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StudentResponse {

    private String studentId;

    private String name;

    private String sex;

    private String mail;

    private double score;

    public StudentResponse(String studentId, String name, String sex, String mail) {
        this.studentId = studentId;
        this.name = name;
        this.sex = sex;
        this.mail = mail;
        this.score = -1;
    }
}
