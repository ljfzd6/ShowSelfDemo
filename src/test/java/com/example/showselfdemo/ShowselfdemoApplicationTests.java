package com.example.showselfdemo;

import com.example.showselfdemo.utils.MakeIdUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class ShowselfdemoApplicationTests {
@Autowired
    RedisTemplate redisTemplate;
    @Test
    void contextLoads() {
        Object e39672d1958d325fae38 = redisTemplate.opsForValue().get("2c28e7d1db5534749024\"");
        System.out.println(e39672d1958d325fae38.toString());
    }

}
