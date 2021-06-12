package com.example.eduadministration.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddStudentRequest {

    private String studentId;

    private String name;

    private String sex;

    private String mail;
}
