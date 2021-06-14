package com.example.eduadministration.DAO;

import com.example.eduadministration.Mapper.Student;
import com.example.eduadministration.response.StudentResponse;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 学生用户表DAO层接口
 * @author eleme
 * @version $Id: UserRepository.java, v 0.1 2021-05-11 8:08 下午 eleme Exp $$
 */
@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {

    /**
     * 根据用户的工号查询用户，只能查到一个
     * @param studentId 工号
     * @return StudentUser对象
     */
    Student findByStudentId(String studentId);

    /**
     * 根据姓名查询用户，可能查到多个
     * @param name 姓名
     * @return 所有查到的学生用户
     */
    List<Student> findByName(String name);

    /**
     * 根据课程id查询所有选修了这门课的已有成绩的学生
     * @param courseId 课程号
     */
    @Query("SELECT new com.example.eduadministration.response.StudentResponse (a.studentId, a.name, a.sex, a.mail, " +
            "b.score) FROM Student as a, CourseStudent as b " +
            "WHERE a.studentId = b.studentId AND b.courseId = :course_id AND b.score IS NOT NULL")
    List<StudentResponse> fetchAllStudentGradeByCourseId(@Param("course_id") int courseId);

    /**
     * @param courseId 课程号
     * @return 选择了这门课但是还没有成绩的学生
     */
    @Query("SELECT new com.example.eduadministration.response.StudentResponse (a.studentId, a.name, a.sex, a.mail)" +
            " FROM Student as a, CourseStudent as b " +
            "WHERE a.studentId = b.studentId AND b.courseId = :course_id AND b.score IS NULL")
    List<StudentResponse> fetchAllStudentNonGradeByCourseId(@Param("course_id") int courseId);
}
