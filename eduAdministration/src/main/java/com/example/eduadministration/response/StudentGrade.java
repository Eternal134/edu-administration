package com.example.eduadministration.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author 秋猫
 * @version 2021-05-31 19:04
 * @description 表示学生成绩的模型
 */
@Data
@AllArgsConstructor
public class StudentGrade {

    /**
     * 学生学号
     */
    private String studentId;

    /**
     * 课程代号
     */
    private int courseId;

    /**
     * 课程名称
     */
    private String courseName;

    /**
     * 课程成绩
     */
    private double score;

    /**
     * 学年
     */
    private String schoolYear;

    /**
     * 学期
     */
    private String schoolTerm;

    /** 学分*/
    private int credit;
}
