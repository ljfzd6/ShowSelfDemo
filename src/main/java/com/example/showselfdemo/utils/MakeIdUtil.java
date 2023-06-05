package com.example.showselfdemo.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.UUID;

public class MakeIdUtil {
public static String getId(String username,String createtime){
    // 将username和createtime加入到UUID的生成中
    UUID uuid = UUID.nameUUIDFromBytes((username + createtime).getBytes());

    // 将UUID转换为全部为英文字符的20位ID
    String id = uuid.toString().replace("-", "").substring(0, 20);
    return id;
}
}
