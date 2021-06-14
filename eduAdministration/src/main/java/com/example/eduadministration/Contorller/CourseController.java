package com.example.eduadministration.Contorller;

import com.example.eduadministration.Mapper.Course;
import com.example.eduadministration.Service.BaseService;
import com.example.eduadministration.Service.CourseServiceImpl;
import com.example.eduadministration.response.BaseResponse;
import org.springframework.web.bind.annotation.*;

/**
 * @author 秋猫
 * @version 2021-06-04 16:34
 * @Description 课程相关
 */
@RestController
@RequestMapping("/course")
public class CourseController {

    private final CourseServiceImpl service;

    public CourseController(CourseServiceImpl service) {
        this.service = service;
    }

    @PostMapping("/add")
    BaseResponse<?> addCourse(@RequestBody Course course) {

        try {
            service.addRecord(course);
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

    @GetMapping("/all")
    BaseResponse<?> findAllCourse() {
        try {
            return BaseResponse.<Course>builder()
                    .code("0")
                    .data(service.findAllRecord())
                    .build();
        } catch (Exception e) {
            return BaseResponse.builder()
                    .code("1")
                    .errorMessage(e.getMessage())
                    .build();
        }
    }
}
