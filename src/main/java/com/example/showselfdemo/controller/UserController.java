package com.example.showselfdemo.controller;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.ShearCaptcha;
import com.example.showselfdemo.dao.Log;
import com.example.showselfdemo.dao.R;
import com.example.showselfdemo.dao.User;
import com.example.showselfdemo.dao.request.AddUser;
import com.example.showselfdemo.dao.request.Register;
import com.example.showselfdemo.dao.request.UpdateUser;
import com.example.showselfdemo.service.LogService;
import com.example.showselfdemo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

@RestController
@RequestMapping("/user")
public class UserController {
    private static  final Logger logger=LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;
    @Autowired
    private LogService logService;
    @Autowired
    private RedisTemplate redisTemplate;
    //登录
    @GetMapping("/login")
    public R login(@RequestParam("email") String email,
                   @RequestParam("password") String password,
                   @RequestParam("verifyCode") String verifyCode,
                   HttpSession session){
        String captchaCode = (String) session.getAttribute("verifyCode");
        if (captchaCode.isEmpty()||!captchaCode.equals(verifyCode)){
            return R.builder().code(HttpStatus.FAILED_DEPENDENCY.value()).msg("验证码输入错误").build();
        }
        R admin = getUserByEmail(email, "admin");
        User data = (User) admin.getData();
        if (!StringUtils.isEmpty(data)&&data!=null){
            if (data.getPassword().equals(password)){
                Integer integer = logService.addLog(Log.builder().logtime(new Date()).logcontext(data.getUsername() + "登录了").loguser(data.getUsername()).build());
                if (integer.equals(0)){
                    logger.error(data.getUsername()+ "登录了，日志写入失败");
                }
                return R.builder().code(HttpStatus.OK.value()).msg("登录成功").Data(data).build();
            }else{
                return R.builder().code(HttpStatus.FAILED_DEPENDENCY.value()).msg("密码错误").build();
            }
        }
        else
        {return R.builder().code(HttpStatus.FAILED_DEPENDENCY.value()).msg("查无此人").build();}
    }
    //通过id查询用户信息
    @GetMapping("/getuserbyid")
    public R getUserByID(String id,String operator) {
        User userById = userService.getUserByID(id);
        if (userById!=null&& !StringUtils.isEmpty(userById)){
            Integer integer = logService.addLog(Log.builder().logtime(new Date()).logcontext(operator + "查询了" + userById.getUsername() + "的个人信息").loguser(operator).build());
            if (integer.equals(0)){
                logger.error(operator + "查询了" + userById.getUsername() + "的个人信息，日志写入失败");
            }
            return R.builder().code(HttpStatus.OK.value()).msg("请求成功").Data(userById).build();
        }else
        {return R.builder().code(HttpStatus.NOT_FOUND.value()).msg("数据库无该用户").build();}
    }
    //通过邮箱查询用户信息
    @GetMapping("/getuserbyemail")
    public R getUserByEmail(String email,String operator) {
        User userByUsername = userService.getUserByEmail(email);
        if (userByUsername!=null&& !StringUtils.isEmpty(userByUsername)){
            Integer integer = logService.addLog(Log.builder().logtime(new Date()).logcontext(operator + "查询了" + userByUsername.getUsername() + "的个人信息").loguser(operator).build());
            if (integer.equals(0)){
                logger.error(operator + "查询了" + userByUsername.getUsername() + "的个人信息，日志写入失败");
            }
            return R.builder().code(HttpStatus.OK.value()).msg("请求成功").Data(userByUsername).build();
        }else
        {return R.builder().code(HttpStatus.NOT_FOUND.value()).msg("数据库无该用户").build();}
    }

    //添加用户
    @GetMapping("/adduser")
    public R addUser(@RequestBody AddUser user){
        System.out.println(user);
        Integer addUser = userService.addUser(user.getUser());
        if (addUser.equals(1)){
            Integer integer = logService.addLog(Log.builder().loguser(user.getOperator()).logcontext("添加了用户" + user.toString()).logtime(new Date()).build());
            if (integer.equals(0)){
                logger.error(user.getOperator()+"添加了用户"+user+"日志写入失败");
            }
            return R.builder().code(HttpStatus.OK.value()).msg("添加成功").build();
        }else
        {
            return R.builder().code(HttpStatus.EXPECTATION_FAILED.value()).msg("添加失败").build();
        }
    }
    //根据Id更改用户信息
    @PutMapping("/updateuser")
    public R updateUser(@RequestBody UpdateUser user)
    {
        Integer updateUser = userService.updateUser(user.getUser());
        if (updateUser.equals(1)){
            Integer integer = logService.addLog(Log.builder().loguser(user.getOperator()).logtime(new Date()).logcontext("修改了" + user + "的数据").build());
            if (integer.equals(0)) {
                logger.error(user.getOperator()+"更改了用户"+user.toString()+"日志写入失败");
            }
            return R.builder().code(HttpStatus.OK.value()).msg("修改成功").build();
        }else {
            return R.builder().code(HttpStatus.EXPECTATION_FAILED.value()).msg("添加失败").build();
        }
    }
    //根据Id更改密码
    @PutMapping("/updatepassword")
    public R updatePassword(@RequestBody UpdateUser user)
    {
        Integer updatePassword  = userService.updatePassword(user.getUser());
        if (updatePassword==1){
            Integer integer = logService.addLog(Log.builder().loguser(user.getOperator()).logtime(new Date()).logcontext("修改了" + user + "的密码").build());
            if (integer.equals(0)) {
                logger.error(user.getOperator()+"更改了用户"+user.toString()+"日志写入失败");
            }
            return R.builder().code(HttpStatus.OK.value()).msg("修改成功").build();
        }else {
            return R.builder().code(HttpStatus.EXPECTATION_FAILED.value()).msg("修改失败，请等待管理员解决").build();
        }
    }
    @GetMapping("/verifycode")
    public void Verify(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //定义图形验证码的长、宽、验证码字符数、干扰线宽度
        ShearCaptcha captcha = CaptchaUtil.createShearCaptcha(150, 40, 5, 4);
        //图形验证码写出，可以写出到文件，也可以写出到流
        captcha.write(response.getOutputStream());
        //获取验证码中的文字内容
        String verifyCode = captcha.getCode();
        request.getSession().setAttribute("verifyCode",verifyCode);
    }
    //注册
    @PostMapping("/register")
    public  R register(@RequestBody Register register) {
        User user1 = register.getUser();
        user1.setGrade(1);
        user1.setSex(1);
        String s = (String) redisTemplate.opsForValue().get(register.getUsercode());
        if (!s.isEmpty()&&s.equals(register.getCode())){
            R admin = addUser(AddUser.builder().user(user1).operator("admin").build());
            return admin;
        }else{
            return R.builder().code(HttpStatus.NOT_FOUND.value()).msg("验证码有误").build();
        }

    }
//    //忘记密码
//    @GetMapping("/forgetpassword")
//    public R forgetpassword(String email){
//        R admin = getUserByEmail(email, "admin");
//        User data = (User) admin.getData();
//        if (!StringUtils.isEmpty(data))
//        {
//            return admin;
//        }
//        else {
//            return R.builder().code(HttpStatus.NOT_FOUND.value()).msg("邮箱输入错误，请查证").build();
//        }
//
//    }
}
