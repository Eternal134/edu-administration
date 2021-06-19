package com.example.eduadministration.Contorller;

import com.example.eduadministration.Exception.LoginException;
import com.example.eduadministration.Mapper.Security;
import com.example.eduadministration.Service.UserServiceImpl;
import com.example.eduadministration.response.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@RestController
public class UserController {

    private final UserServiceImpl userService;

    @Autowired
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    BaseResponse<?> login(@RequestBody Security user) {

        try {
            userService.verifyUser(user);
            String userType = user.getUserId().contains("E") ? "student" : "teacher";
            return BaseResponse.<String>builder()
                    .code("0")
                    .data(Collections.singletonList(userType))
                    .build();
        } catch (Exception loginException) {
            return BaseResponse.builder()
                    .code("1")
                    .errorMessage(loginException.getMessage())
                    .build();
        }
    }

    @PostMapping("/user/add")
    BaseResponse<?> addUser(@RequestBody Security user) {

        try {
            userService.addRecord(user);
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

    @GetMapping("/user/all")
    BaseResponse<?> findAllUser() {
        try {
            return BaseResponse.<Security>builder()
                    .code("0")
                    .data(userService.findAllUser())
                    .build();
        } catch (Exception e) {
            return BaseResponse.builder()
                    .code("1")
                    .errorMessage(e.getMessage())
                    .build();
        }
    }
}
