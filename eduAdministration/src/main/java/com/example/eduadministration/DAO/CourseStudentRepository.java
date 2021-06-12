package com.example.eduadministration.DAO;

import com.example.eduadministration.Mapper.CourseStudent;
import com.example.eduadministration.DAO.StudentGrade;
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
    @Query("SELECT new com.example.eduadministration.DAO.StudentGrade(a.studentId, b.courseId, c.name, b.score, " +
            "c.schoolYear, c.schoolTerm, c.credit) " +
            "FROM Student AS a, CourseStudent AS b, Course AS c " +
            "WHERE a.studentId = :studentId AND b.studentId = a.studentId AND c.courseId = b.courseId")
    List<StudentGrade> fetchAllCourseByStudentId(@Param("studentId") String studentId);
}
