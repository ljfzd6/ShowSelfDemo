package com.example.showselfdemo.controller;

import com.example.showselfdemo.mapper.UserMapper;
import com.example.showselfdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UserService userService;
    @RequestMapping("/testsql")
    public String test() {
        return  userService.getAllUser().toString();
    }
}
