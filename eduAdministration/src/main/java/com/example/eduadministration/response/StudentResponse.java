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
}
