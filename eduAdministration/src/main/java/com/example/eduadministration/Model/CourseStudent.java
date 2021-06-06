package com.example.eduadministration.Model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author 秋猫
 * @version 2021-05-25 12:03
 * @description 学生选课表，学生选完课没有成绩时成绩字段为NULL
 */
@Entity
@Data
@NoArgsConstructor
@Table(name = "course_student")
@IdClass(CourseStudentPrimaryKey.class)
public class CourseStudent {

    /**
     * 学生学号
     */
    @Id
    @Column(length = 20)
    private String studentId;

    /**
     * 课程代码
     */
    @Id
    private int courseId;

    /**
     * 分数
     */
    @Column(precision = 5, scale = 1)
    private double score;
}

/**
 * 主键类，用于定义实体类的主键
 */
class CourseStudentPrimaryKey implements Serializable {

    String studentId;

    String courseId;
}
