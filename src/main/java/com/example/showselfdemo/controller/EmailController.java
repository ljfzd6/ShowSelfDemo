package com.example.showselfdemo.controller;

import com.example.showselfdemo.dao.EmailContent;
import com.example.showselfdemo.dao.R;
import com.example.showselfdemo.service.SendEmailService;
import com.example.showselfdemo.utils.MakeIdUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/email")
public class EmailController {
    @Autowired
    SendEmailService service;
    @Autowired
    private RedisTemplate redisTemplate;

    @GetMapping("/sendregisteremail")
    public R sendRegisterEmail (String email) throws MessagingException {
        String id = MakeIdUtil.getId(email, new Date().toString());
        try {
            EmailContent emailContent = new EmailContent();
            ValueOperations valueOperations = redisTemplate.opsForValue();
            //向redis中写入验证码，五分钟内有效
            valueOperations.set(id,emailContent.getCode(), 5, TimeUnit.MINUTES);
            String s = (String) valueOperations.get(id);
            System.out.println("id"+id+"value"+s);
            service.sendMail(email,"欢迎注册流星个人博客",emailContent.getContentA());
        } catch (MessagingException e) {
            e.printStackTrace();
            return R.builder().code(HttpStatus.INTERNAL_SERVER_ERROR.value()).msg("系统内部错误，请等待管理员维护").build();
        }
        //将ID返回前端
        return R.builder().code(HttpStatus.OK.value()).msg("邮件发送成功，请查看邮件中的验证码").Data(id).build();
    }
}
