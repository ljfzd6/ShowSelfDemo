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
public class AddUser {
    private User user;
    private  String operator;

    @Override
    public String toString() {
        return "AddUser{" +
                "user=" + user +
                ", operator='" + operator + '\'' +
                '}';
    }
}
