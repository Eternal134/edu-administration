package com.example.eduadministration.Contorller;

import com.example.eduadministration.Mapper.Student;
import com.example.eduadministration.Mapper.Teacher;
import com.example.eduadministration.Service.BaseSqlService;
import com.example.eduadministration.Service.GradeSqlServiceImpl;
import com.example.eduadministration.Service.StudentServiceImpl;
import com.example.eduadministration.Service.TeacherServiceImpl;
import com.example.eduadministration.request.OriginGrade;
import com.example.eduadministration.response.BaseResponse;
import com.example.eduadministration.response.StudentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TeacherController {

    private final BaseSqlService gradeService;

    private final StudentServiceImpl studentUserService;

    private final TeacherServiceImpl teacherService;

    @Autowired
    public TeacherController(GradeSqlServiceImpl service, StudentServiceImpl studentUserService,
                             TeacherServiceImpl teacherService) {

        this.gradeService = service;
        this.studentUserService = studentUserService;
        this.teacherService = teacherService;
    }

    /**
     * @param originGrade 原始成绩数据，即计算最终成绩前的数据
     */
    @PostMapping("/teacher/addGrade")
    BaseResponse addGrade(@RequestBody OriginGrade originGrade) {
        try {
            gradeService.addRecord(originGrade);
            return new BaseResponse("0");
        } catch (Exception e) {
            return new BaseResponse("1", e.getMessage());
        }
    }

    @GetMapping("/teacher/findStudent")
    public List<StudentResponse> findStudentByCourseId(@Param("courseId") int courseId) {
        return studentUserService.findAllStudentByCourseId(courseId);
    }

    @PostMapping("/teacher/add")
    public BaseResponse addTeacher(@RequestBody Teacher teacher) {
        try {
            teacherService.addRecord(teacher);
            return new BaseResponse("0", "");
        } catch (Exception e) {
            return new BaseResponse("1", e.getMessage());
        }
    }

    /**
     * @return 所有老师
     */
    @GetMapping("/teacher/all")
    public BaseResponse findAllTeacher() {

        try {
            return BaseResponse.builder()
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
}
