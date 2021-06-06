package com.example.eduadministration.Contorller;

import com.example.eduadministration.DAO.CourseStudentRepository;
import com.example.eduadministration.DAO.StudentGrade;
import com.example.eduadministration.Service.StudentCourseService;
import com.example.eduadministration.Service.StudentCourseServiceImpl;
import com.example.eduadministration.request.QueryGradeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author 秋猫
 * @version 2021-06-01 16:34
 * @description 描述
 */
@RestController
public class CourseStudentController {

    private final StudentCourseServiceImpl service;

    /**
     * 构造器DI注入
     */
    @Autowired
    public CourseStudentController(StudentCourseServiceImpl service) {

        this.service = service;
    }

    @PostMapping("/student/queryGrade")
    public List<StudentGrade> queryGrade(QueryGradeRequest request) {
        return service.queryGrade(request);
    }
}
