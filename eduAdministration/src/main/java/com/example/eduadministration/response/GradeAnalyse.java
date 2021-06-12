package com.example.eduadministration.response;

import lombok.Data;

/**
 * 成绩分析结果模型
 */
@Data
public class GradeAnalyse {

    private int totalCredits;

    private double gradePoint;

    private double gradePointAverage;

    private int lostCredits;

    public GradeAnalyse(int totalCredits, double gradePoint, double gradePointAverage, int lostCredits) {
        this.totalCredits = totalCredits;
        this.gradePoint = gradePoint;
        this.gradePointAverage = gradePointAverage;
        this.lostCredits = lostCredits;
    }
}
