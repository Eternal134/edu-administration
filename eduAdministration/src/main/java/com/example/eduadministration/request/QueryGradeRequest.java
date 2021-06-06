package com.example.eduadministration.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 秋猫
 * @version 2021-06-01 10:42
 * @description 学生查询成绩请求
 */
@Data
@NoArgsConstructor
public class QueryGradeRequest {

    /**
     * 学号
     */
    private String studentId;

    /**
     * 学年
     */
    private String schoolYear;

    /**
     * 学期
     */
    private String schoolTerm;

    /**
     * 构造函数
     * @param studentId 学号
     */
    public QueryGradeRequest(String studentId) {
        this.studentId = studentId;
    }

    public QueryGradeRequest(String studentId, String schoolYear) {
        this.studentId = studentId;
        this.schoolYear = schoolYear;
    }

    public QueryGradeRequest(String studentId, String schoolYear, String schoolTerm) {
        this.studentId = studentId;
        this.schoolYear = schoolYear;
        this.schoolTerm = schoolTerm;
    }
}
