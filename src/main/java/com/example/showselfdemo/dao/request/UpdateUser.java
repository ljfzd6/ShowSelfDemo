package com.example.showselfdemo.dao.request;

import com.example.showselfdemo.dao.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateUser {
    private  User user;
    private String operator;

    @Override
    public String toString() {
        return "UpdateUser{" +
                "user=" + user +
                ", operator='" + operator + '\'' +
                '}';
    }
}
