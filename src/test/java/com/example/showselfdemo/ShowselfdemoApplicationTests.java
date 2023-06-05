package com.example.showselfdemo;

import com.example.showselfdemo.utils.MakeIdUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ShowselfdemoApplicationTests {

    @Test
    void contextLoads() {
        String aaa = MakeIdUtil.getId("张三", "2023-06-05T02:18:51.000+00:00");
        System.out.println(aaa);
    }

}
