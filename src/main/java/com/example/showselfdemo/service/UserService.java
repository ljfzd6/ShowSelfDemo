package com.example.showselfdemo.service;

import com.example.showselfdemo.dao.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    List<User> getAllUser();
    User getUserByEmail(String email);
    Integer addUser(User user);
    Integer updateUser(User user);
}
