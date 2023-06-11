package com.example.showselfdemo.dao.request;

import com.example.showselfdemo.dao.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Register {
    private  User user;
    private String code;
    private  String usercode;

    @Override
    public String toString() {
        return "Register{" +
                "user=" + user +
                ", code='" + code + '\'' +
                ", userecode='" + usercode + '\'' +
                '}';
    }
}
