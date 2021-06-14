package com.example.eduadministration.Mapper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author 秋猫
 * @version 2021-05-25 17:48
 * @description 课程表
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "course")
public class Course {

    /**
     * 课程代号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "course_id", nullable = false)
    private int courseId;

    /**
     * 课程名
     */
    @Column(length = 20)
    private String name;

    /**
     * 学分
     */
    private int credit;

    /**
     * 此课程开设的学年
     */
    @Column(nullable = false, length = 20)
    private String schoolYear;

    /**
     * 此课程开设的学期
     */
    @Column(nullable = false, length = 2)
    private String schoolTerm;
}
