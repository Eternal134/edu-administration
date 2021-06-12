package com.example.eduadministration.Mapper;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author 秋猫
 * @version 2021-05-11 19:56
 * @description 教师用户
 */
@Data
@Entity
@NoArgsConstructor
@Table(name = "teacher")
public class Teacher {

    /**
     * 教师工号
     * 主键
     */
    @Id
    @Column(length = 10)
    private String teacherId;

    /**
     * 用户姓名
     */
    @Column(nullable = false, length = 5)
    private String name;

    /**
     * 邮箱
     */
    @Column(length = 30)
    private String mail;

    /**
     * 性别
     */
    @Column(length = 2, nullable = false)
    private String sex;
}
