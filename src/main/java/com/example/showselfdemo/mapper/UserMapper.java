package com.example.showselfdemo.mapper;

import com.example.showselfdemo.dao.User;

import java.util.List;

public interface UserMapper {
    List<User> selectAll();
    User selectUserByEmail(String email);
    User selectUserByID(String id);
    Integer insertUser(User user);
    Integer updateUserById(User user);
    Integer updatePasswordById(User user);
}
