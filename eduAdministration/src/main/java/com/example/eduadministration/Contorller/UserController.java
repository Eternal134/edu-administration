package com.example.eduadministration.Contorller;

import com.example.eduadministration.Mapper.Security;
import com.example.eduadministration.Service.UserServiceImpl;
import com.example.eduadministration.response.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserServiceImpl userService;

    @Autowired
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    BaseResponse login(@RequestBody Security user) {

        try {
            return userService.verifyUser(user);
        } catch (Exception e) {
            return new BaseResponse("1", e.getMessage());
        }
    }

    @PostMapping("/user/add")
    BaseResponse addUser(@RequestBody Security user) {

        try {
            userService.addRecord(user);
        } catch (Exception e) {
            return new BaseResponse("1", e.getMessage());
        }

        return new BaseResponse("0", "");
    }
}
