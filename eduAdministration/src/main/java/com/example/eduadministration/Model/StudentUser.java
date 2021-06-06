package com.example.eduadministration.Model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.Generated;
import javax.persistence.*;

/**
 * @author 秋猫
 * @version 2021-05-11 19:48
 * @description 学生用户
 */
@Entity
@NoArgsConstructor
@Table(name = "student")
public class StudentUser extends User{

    /**
     * 学号
     * 主键
     */
    @Id
    @Column(length = 10)
    private String studentId;
}
