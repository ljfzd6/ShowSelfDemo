package com.example.showselfdemo.service.impl;

import com.example.showselfdemo.dao.User;
import com.example.showselfdemo.mapper.UserMapper;
import com.example.showselfdemo.service.UserService;
import com.example.showselfdemo.utils.MakeIdUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public List<User> getAllUser() {
        return userMapper.selectAll();
    }

    @Override
    public User getUserByEmail(String email) {
        return userMapper.selectUserByEmail(email);
    }

    @Override
    public User getUserByID(String id) {
        return userMapper.selectUserByID(id);
    }

    @Override
    public Integer addUser(User user) {
        Date date = new Date();
        user.setCreatetime(date);
        user.setId(MakeIdUtil.getId(user.getUsername(),user.getCreatetime().toString()));
        return userMapper.insertUser(user);
    }

    @Override
    public Integer updateUser(User user) {
        return userMapper.updateUserById(user);
    }

}
