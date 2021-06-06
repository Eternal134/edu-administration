package com.example.eduadministration.DAO;

import com.example.eduadministration.Model.CourseStudent;
import org.hibernate.mapping.PrimaryKey;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author eleme
 * @version $Id: CourseStudentRepository.java, v 0.1 2021-05-31 6:56 下午 eleme Exp $$
 */
public interface CourseStudentRepository extends CrudRepository<CourseStudent, PrimaryKey> {

    /**
     * @param studentId 学号
     * @return 所有已修课程成绩
     */
    @Query(nativeQuery = true, value =
            "SELECT student_id, course_id, course_name, grade, school_year, school_term" +
            "FROM student AS a, CourseStudent AS b" +
            "WHERE a.student_id = :studentId AND b.student_id = a.student_id")
    List<StudentGrade> fetchAllCourseByStudentId(@Param("studentId") String studentId);
}
