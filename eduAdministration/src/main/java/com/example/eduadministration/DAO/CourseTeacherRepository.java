package com.example.eduadministration.DAO;

import com.example.eduadministration.Mapper.Course;
import com.example.eduadministration.Mapper.CourseTeacher;
import org.hibernate.mapping.PrimaryKey;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseTeacherRepository extends CrudRepository<CourseTeacher, PrimaryKey> {

    /**
     * @param teacherId 老师的工号
     * @return 老师带的所有课
     */
    @Query("SELECT NEW Course (b.courseId, b.name, b.credit, b.schoolYear, b.schoolTerm) " +
            "FROM CourseTeacher as a, Course as b " +
            "WHERE a.teacherId = :teacher_id AND a.courseId = b.courseId")
    List<Course> fetchCourseByTeacherId(@Param("teacher_id") String teacherId);
}
