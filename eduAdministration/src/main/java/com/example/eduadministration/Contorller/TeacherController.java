package com.example.eduadministration.Contorller;

import com.example.eduadministration.Mapper.Course;
import com.example.eduadministration.Mapper.Teacher;
import com.example.eduadministration.Service.GradeServiceImpl;
import com.example.eduadministration.Service.StudentServiceImpl;
import com.example.eduadministration.Service.TeacherServiceImpl;
import com.example.eduadministration.request.OriginGrade;
import com.example.eduadministration.response.BaseResponse;
import com.example.eduadministration.response.GradeStatistics;
import com.example.eduadministration.response.StudentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
public class TeacherController {

    private final GradeServiceImpl gradeService;

    private final StudentServiceImpl studentUserService;

    private final TeacherServiceImpl teacherService;

    @Autowired
    public TeacherController(GradeServiceImpl service, StudentServiceImpl studentUserService,
                             TeacherServiceImpl teacherService) {

        this.gradeService = service;
        this.studentUserService = studentUserService;
        this.teacherService = teacherService;
    }

    /**
     * @param originGrade 原始成绩数据，即计算最终成绩前的数据
     */
    @PostMapping("/teacher/addGrade")
    public BaseResponse<?> addGrade(@RequestBody OriginGrade originGrade) {
        try {
            gradeService.addRecord(originGrade);
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

    /**
     * @param courseId 课程号
     * @return 根据课程号查找这门课所有已经有成绩的学生成绩信息
     */
    @GetMapping("/teacher/findStudentGrade")
    public BaseResponse<?> findStudentHasGradeByCourseId(@Param("courseId") int courseId) {
        try {
            return BaseResponse.<StudentResponse>builder()
                       .code("0")
                       .data(studentUserService.findAllStudentHasGradeByCourseId(courseId))
                       .build();
        } catch (Exception e) {
            return BaseResponse.builder()
                    .code("1")
                    .errorMessage(e.getMessage())
                    .build();
        }
    }

    /**
     * @param courseId 课程号
     * @return 根据课程号查找这门课所有没有成绩的学生信息
     */
    @GetMapping("/teacher/findStudentNonGrade")
    public BaseResponse<?> findAllStudentNonGradeByCourseId(@Param("courseId") int courseId) {
        try {
            return BaseResponse.<StudentResponse>builder()
                    .code("0")
                    .data(studentUserService.findAllStudentNonGradeByCourseId(courseId))
                    .build();
        } catch (Exception e) {
            return BaseResponse.builder()
                    .code("1")
                    .errorMessage(e.getMessage())
                    .build();
        }
    }

    /**
     * 添加一个教师
     * @param teacher 教师模型
     * @return 添加结果（是否成功）
     */
    @PostMapping("/teacher/add")
    public BaseResponse<?> addTeacher(@RequestBody Teacher teacher) {
        try {
            teacherService.addRecord(teacher);
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

    /**
     * @return 所有老师
     */
    @GetMapping("/teacher/all")
    public BaseResponse<?> findAllTeacher() {

        try {
            return BaseResponse.<Teacher>builder()
                    .code("0")
                    .data(teacherService.findAll())
                    .build();
        } catch (Exception e) {
            return BaseResponse.builder()
                    .code("1")
                    .errorMessage(e.getMessage())
                    .build();
        }
    }

    /**
     * @param courseId 课程号
     * @return 一门课的成绩统计结果，包括平均分、最高分、及格率、优秀率等
     */
    @GetMapping("/teacher/gradeCount")
    public BaseResponse<?> countGradeByCourseId(@Param("courseId") int courseId) {

        try {
            return BaseResponse.<GradeStatistics>builder()
                    .code("0")
                    .data(Collections.singletonList(gradeService.countGrade(courseId)))
                    .build();
        } catch (Exception e) {
            return BaseResponse.builder()
                    .code("1")
                    .errorMessage(e.getMessage())
                    .build();
        }
    }

    /**
     * @param teacherId 教师工号
     * @return 该老师带的所有课程
     */
    @GetMapping("/teacher/getCourses")
    public BaseResponse<?> getCourses(@Param("teacherId") String teacherId) {
        try {
            return BaseResponse.<Course>builder()
                    .code("0")
                    .data(teacherService.getCourseByTeacherId(teacherId))
                    .build();
        } catch (Exception e) {
            return BaseResponse.builder()
                    .code("1")
                    .errorMessage(e.getMessage())
                    .build();
        }
    }
}
