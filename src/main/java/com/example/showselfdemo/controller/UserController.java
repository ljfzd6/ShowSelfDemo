package com.example.showselfdemo.controller;

import com.example.showselfdemo.dao.R;
import com.example.showselfdemo.dao.User;
import com.example.showselfdemo.mapper.UserMapper;
import com.example.showselfdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping("/getuserbyusername")
    public R getUserByUsername(String username) {
        User userByUsername = userService.getUserByUsername(username);
        if (userByUsername!=null&& !StringUtils.isEmpty(userByUsername)){
            return R.builder().code(HttpStatus.OK).msg("请求成功").Data(userByUsername).build();
        }else
        {return R.builder().code(HttpStatus.FAILED_DEPENDENCY).msg("数据库无该用户").build();}
    }
}
