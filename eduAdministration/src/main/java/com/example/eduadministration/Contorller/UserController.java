package com.example.eduadministration.Contorller;

import com.example.eduadministration.Model.StudentUser;
import com.example.eduadministration.Model.User;
import com.example.eduadministration.DAO.StudentUserRepository;
import com.example.eduadministration.Service.StudentUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;

/**
 * @author 秋猫
 * @version 2021-05-11 20:19
 * @description 描述
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private final StudentUserServiceImpl userService;

    /**
     * 构造器依赖注入
     */
    @Autowired
    public UserController(StudentUserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("/student/all")
    public Iterable<?> getAllStudentUser() {
        return userService.allUser();
    }
}
