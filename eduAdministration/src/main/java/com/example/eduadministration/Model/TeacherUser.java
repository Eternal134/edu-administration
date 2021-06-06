package com.example.eduadministration.Model;

import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author 秋猫
 * @version 2021-05-11 19:56
 * @description 教师用户
 */
@Entity
@NoArgsConstructor
@Table(name = "teacher")
public class TeacherUser extends User{

    /**
     * 教师工号
     * 主键
     */
    @Id
    @Column(length = 10)
    private String teacherId;
}
