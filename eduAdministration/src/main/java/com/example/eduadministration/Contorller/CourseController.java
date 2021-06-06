package com.example.eduadministration.Contorller;

import com.example.eduadministration.Model.Course;
import com.example.eduadministration.Service.BaseSqlService;
import com.example.eduadministration.Service.CourseBaseSqlServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 秋猫
 * @version 2021-06-04 16:34
 * @Description 课程相关
 */
@RestController
@RequestMapping("/course")
public class CourseController {

    private final BaseSqlService service;

    public CourseController(CourseBaseSqlServiceImpl service) {
        this.service = service;
    }

    @PostMapping("/add")
    void addCourse(@RequestBody Course course) {
        service.addRecord(course);
    }

}
