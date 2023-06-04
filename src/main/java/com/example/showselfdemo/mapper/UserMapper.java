package com.example.showselfdemo.mapper;

import com.example.showselfdemo.dao.User;

import java.util.List;

public interface UserMapper {
    List<User> selectAll();
}
