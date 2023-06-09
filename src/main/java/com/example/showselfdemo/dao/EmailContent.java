package com.example.showselfdemo.dao;

import com.example.showselfdemo.utils.VerificationCodeUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EmailContent {
     String code=VerificationCodeUtil.generateVerificationCode(4);
     private String  contentA = "<html>\n" +
            "<head>\n" +
            "<style>\n" +
            "    body {\n" +
            "        background-repeat: no-repeat;\n" +
            "        background-size: cover;\n" +
            "        font-family: Arial, sans-serif;\n" +
            "        font-size: 16px;\n" +
            "        color: #333;\n" +
            "    }\n" +
            "    .container {\n" +
            "        background-image: url('https://s1.ax1x.com/2023/06/09/pCAvlm6.jpg');\n" +
            "        max-width: 600px;\n" +
            "        margin: 0 auto;\n" +
            "        padding: 20px;\n" +
            "        background-color: #fff;\n" +
            "        opacity: 0.9;\n" +
            "        border-radius: 10px;\n" +
            "        box-shadow: 0 0 10px rgba(0,0,0,0.3);\n" +
            "    }\n" +
            "    h1 {\n" +
            "        font-size: 24px;\n" +
            "        margin-bottom: 20px;\n" +
            "        text-align: center;\n" +
            "        color: white\n" +
            "    }\n" +
            "    p {\n" +
            "        margin-bottom: 20px;\n" +
            "        line-height: 1.5;\n" +
            "        color: white\n" +
            "    }\n" +
            "    .code {\n" +
            "        font-size: 28px;\n" +
            "        font-weight: bold;\n" +
            "        color: #f00;\n" +
            "    }\n" +
            "    .join {\n" +
            "        font-size: 18px;\n" +
            "        font-weight: bold;\n" +
            "        color: #00f;\n" +
            "    }\n" +
            "</style>\n" +
            "</head>\n" +
            "<body>\n" +
            "    <div class=\"container\">\n" +
            "        <h1>验证码通知</h1>\n" +
            "        <p>尊敬的用户：</p>\n" +
            "        <p>您的验证码是：<span class=\"code\">"+code+"</span></p>\n" +
             "        <p>验证码5分钟内有效</p>\n" +
            "        <p>本系统目前属于用爱发电阶段，欢迎加入我们完善此系统，交流群为：<span class=\"join\">xxxxxxxx</span></p>\n" +
            "    </div>\n" +
            "</body>\n" +
            "</html>";
}
