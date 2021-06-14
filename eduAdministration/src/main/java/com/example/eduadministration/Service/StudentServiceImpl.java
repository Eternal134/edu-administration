package com.example.eduadministration.Service;

import com.example.eduadministration.DAO.CourseStudentRepository;
import com.example.eduadministration.DAO.StudentRepository;
import com.example.eduadministration.Mapper.CourseStudent;
import com.example.eduadministration.Mapper.Student;
import com.example.eduadministration.response.StudentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 秋猫
 * @version 2021-05-12 15:05
 * @description 学生用户Service层
 */
@Service
public class StudentServiceImpl implements BaseService {

    /**
     * 数据库控制对象
     */
    private final StudentRepository repository;

    private final CourseStudentRepository courseStudentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository repository, CourseStudentRepository courseStudentRepository) {
        this.repository = repository;
        this.courseStudentRepository = courseStudentRepository;
    }

    /**
     * @param courseId 课程号
     * @return 选择了此课程，有成绩的学生
     */
    public List<StudentResponse> findAllStudentHasGradeByCourseId(int courseId) {
        return repository.fetchAllStudentGradeByCourseId(courseId);
    }

    /**
     * @param courseId 课程号
     * @return 选择了此课程，没有成绩的学生
     */
    public List<StudentResponse> findAllStudentNonGradeByCourseId(int courseId) {
        return repository.fetchAllStudentNonGradeByCourseId(courseId);
    }

    @Override
    public void addRecord(Object object) {
        Student student = (Student) object;
        repository.save(student);
    }

    public Student findStudentById(String studentId) {
        return repository.findByStudentId(studentId);
    }

    public List<Student> findAllStudent() {
        List<Student> studentResponseList = new ArrayList<>();
        repository.findAll().forEach(studentResponseList::add);
        return studentResponseList;
    }

    public List<CourseStudent> findAllCourseStudent() {
        List<CourseStudent> courseStudentList = new ArrayList<>();
        courseStudentRepository.findAll().forEach(courseStudentList::add);
        return courseStudentList;
    }
}
