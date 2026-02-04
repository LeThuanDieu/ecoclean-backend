package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.reponsitory.UserReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserReponsitory userReponsitory;

    public User registerUser(User user) {
        return userReponsitory.save(user);
    }
}
