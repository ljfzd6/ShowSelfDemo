package com.example.showselfdemo.controller;

import com.example.showselfdemo.dao.Log;
import com.example.showselfdemo.dao.R;
import com.example.showselfdemo.dao.User;
import com.example.showselfdemo.service.LogService;
import com.example.showselfdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    LogService logService;
    //通过邮箱查询用户信息
    @GetMapping("/getuserbyusername")
    public R getUserByUsername(String email,String loguser) {
        User userByUsername = userService.getUserByEmail(email);
        if (userByUsername!=null&& !StringUtils.isEmpty(userByUsername)){
            Integer integer = logService.addLog(Log.builder().logtime(new Date()).logcontext(loguser + "查询了" + userByUsername.getUsername() + "的个人信息").loguser(loguser).build());
            if (integer==0){

            }
            return R.builder().code(HttpStatus.OK.value()).msg("请求成功").Data(userByUsername).build();
        }else
        {return R.builder().code(HttpStatus.NOT_FOUND.value()).msg("数据库无该用户").build();}
    }
    //添加用户
    @PostMapping("/adduser")
    public R addUser(@RequestBody User user){
        Integer integer = userService.addUser(user);
        if (integer.equals(1)){
            return R.builder().code(HttpStatus.OK.value()).msg("添加成功").build();
        }else
        {
            return R.builder().code(HttpStatus.EXPECTATION_FAILED.value()).msg("添加失败").build();
        }
    }
    //根据Id更改用户信息
    @PutMapping("/updateuser")
    public R updateUser(@RequestBody User user)
    {
        Integer integer = userService.updateUser(user);
        if (integer.equals(1)){
            return R.builder().code(HttpStatus.OK.value()).msg("添加成功").build();
        }else {
            return R.builder().code(HttpStatus.EXPECTATION_FAILED.value()).msg("添加失败").build();
        }
    }

}
