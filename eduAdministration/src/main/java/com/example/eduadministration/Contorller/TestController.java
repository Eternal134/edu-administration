package com.example.eduadministration.Contorller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 秋猫
 * @version 2021-05-26 21:16
 * @description 测试用
 */
@RestController
public class TestController {
    @GetMapping("/hello")
    public String hello() {
        return "Hello";
    }
}
