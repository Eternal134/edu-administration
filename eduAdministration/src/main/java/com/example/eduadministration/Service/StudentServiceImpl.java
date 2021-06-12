package com.example.eduadministration.Service;

import com.example.eduadministration.DAO.StudentUserRepository;
import com.example.eduadministration.Mapper.Student;
import com.example.eduadministration.response.StudentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 秋猫
 * @version 2021-05-12 15:05
 * @description 学生用户Service层
 */
@Service
public class StudentServiceImpl implements BaseSqlService{

    /**
     * 数据库控制对象
     */
    private StudentUserRepository repository;

    /**
     * 基于setter的依赖注入
     * @param repository 数据库类型
     */
    @Autowired
    public void setRepository(StudentUserRepository repository) {

        this.repository = repository;
    }

    public List<StudentResponse> findAllStudentByCourseId(int courseId) {
        return repository.fetchAllStudentByCourseId(courseId);
    }

    @Override
    public void addRecord(Object object) {
        Student student = (Student) object;
        repository.save(student);
    }

    public Student findStudentById(String studentId) {
        return repository.findByStudentId(studentId);
    }
}
