package com.example.showselfdemo.utils;

import java.util.Random;

public class VerificationCodeUtil {
    //输入验证码长度
    public static String generateVerificationCode(int length) {
        String code = "";
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            code += random.nextInt(10);
        }
        return code;
    }
}
