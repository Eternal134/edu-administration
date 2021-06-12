package com.example.eduadministration.Mapper;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * @author 秋猫
 * @version 2021-05-25 18:17
 * @description 教师开课表
 */
@IdClass(CourseTeacherPrimaryKey.class)
@Entity
@Data
@NoArgsConstructor
@Table(name = "course_teacher")
public class CourseTeacher {

    /**
     * 教师的工号
     */
    @Id
    @Column(length = 20)
    private String teacherId;

    /**
     * 课程代号
     */
    @Id
    private int courseId;

    /**
     * 此课程是否已经结束，true表示已结束，false或NULL表示未结束
     */
    @Column(length = 1, name = "is_over")
    private String isOver;
}

class CourseTeacherPrimaryKey implements Serializable {

    String teacherId;

    String courseId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseTeacherPrimaryKey that = (CourseTeacherPrimaryKey) o;
        return teacherId.equals(that.teacherId) && courseId.equals(that.courseId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(teacherId, courseId);
    }
}
