package com.example.eduadministration.request;

import lombok.Data;

@Data
public class OriginGrade {

    private String courseId;

    private String studentId;

    private String usualGradePercentage;

    private String usualGrade;

    private String examGrade;
}
