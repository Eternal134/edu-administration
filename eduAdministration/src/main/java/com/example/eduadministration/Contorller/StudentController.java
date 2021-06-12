package com.example.eduadministration.Contorller;

import com.example.eduadministration.DAO.StudentGrade;
import com.example.eduadministration.Mapper.Student;
import com.example.eduadministration.Service.BaseSqlService;
import com.example.eduadministration.Service.GradeSqlServiceImpl;
import com.example.eduadministration.Service.StudentServiceImpl;
import com.example.eduadministration.request.AddStudentRequest;
import com.example.eduadministration.request.QueryGradeRequest;
import com.example.eduadministration.response.BaseResponse;
import com.example.eduadministration.response.GradeAnalyse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 秋猫
 * @version 2021-06-01 16:34
 * @description 描述
 */
@RestController
public class StudentController {

    private final GradeSqlServiceImpl service;
    
    private final BaseSqlService studentSqlService;

    /**
     * 构造器DI注入
     */
    @Autowired
    public StudentController(GradeSqlServiceImpl service, StudentServiceImpl baseSqlService) {

        this.service = service;
        this.studentSqlService = baseSqlService;
    }

    @PostMapping("/student/queryGrade")
    public List<StudentGrade> queryGrade(@RequestBody QueryGradeRequest request) {

        return service.queryGrade(request);
    }

    @GetMapping("/student/analyze")
    public GradeAnalyse analyseGrade(@Param("studentId") String studentId) {

        return service.analyzeGrade(studentId);
    }

    @PostMapping("/student/add")
    public BaseResponse addStudent(@RequestBody Student student) {

        try {
            studentSqlService.addRecord(student);
            return new BaseResponse("0", "");
        } catch (Exception e) {
            return new BaseResponse("1", e.getMessage());
        }
    }
}
