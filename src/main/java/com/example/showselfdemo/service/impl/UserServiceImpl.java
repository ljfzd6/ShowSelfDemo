package com.example.showselfdemo.service.impl;

import com.example.showselfdemo.dao.User;
import com.example.showselfdemo.mapper.UserMapper;
import com.example.showselfdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public List<User> getAllUser() {
        return userMapper.selectAll();
    }
}
