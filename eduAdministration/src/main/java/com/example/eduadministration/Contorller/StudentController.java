package com.example.eduadministration.Contorller;

import com.example.eduadministration.response.StudentGrade;
import com.example.eduadministration.Mapper.Student;
import com.example.eduadministration.Service.GradeServiceImpl;
import com.example.eduadministration.Service.StudentServiceImpl;
import com.example.eduadministration.request.QueryGradeRequest;
import com.example.eduadministration.response.BaseResponse;
import com.example.eduadministration.response.GradeAnalyse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

/**
 * @author 秋猫
 * @version 2021-06-01 16:34
 * @description 描述
 */
@RestController
public class StudentController {

    private final GradeServiceImpl service;
    
    private final StudentServiceImpl studentSqlService;

    /**
     * 构造器DI注入
     */
    @Autowired
    public StudentController(GradeServiceImpl service, StudentServiceImpl baseSqlService) {

        this.service = service;
        this.studentSqlService = baseSqlService;
    }

    /**
     * @param request 查成绩请求模型，包括学号、学期、学年等
     * @return 成绩列表
     */
    @PostMapping("/student/queryGrade")
    public BaseResponse<?> queryGrade(@RequestBody QueryGradeRequest request) {

        try {
            return BaseResponse.<StudentGrade>builder()
                    .code("0")
                    .data(service.queryGrade(request))
                    .build();
        } catch (Exception e) {
            return BaseResponse.builder()
                    .code("1")
                    .errorMessage(e.getMessage())
                    .build();
        }
    }

    @GetMapping("/student/analyze")
    public BaseResponse<?> analyseGrade(@Param("studentId") String studentId) {

        try {
            return BaseResponse.<GradeAnalyse>builder()
                    .code("0")
                    .data(Collections.singletonList(service.analyzeGrade(studentId)))
                    .build();
        } catch (Exception e) {
            return BaseResponse.builder()
                    .code("1")
                    .errorMessage(e.getMessage())
                    .build();
        }
    }

    @PostMapping("/student/add")
    public BaseResponse<?> addStudent(@RequestBody Student student) {

        try {
            studentSqlService.addRecord(student);
            return BaseResponse.builder()
                    .code("0")
                    .build();
        } catch (Exception e) {
            return BaseResponse.builder()
                    .code("1")
                    .errorMessage(e.getMessage())
                    .build();
        }
    }

    @GetMapping("/student/all")
    public BaseResponse<?> getAllStudent() {
        try {
            return BaseResponse.<Student>builder()
                    .code("0")
                    .data(studentSqlService.findAllStudent())
                    .build();
        } catch (Exception e) {
            return BaseResponse.builder()
                    .code("1")
                    .errorMessage(e.getMessage())
                    .build();
        }
    }
}
