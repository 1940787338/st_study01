package com.mobin.carbon.service.impl;

import com.mobin.carbon.mapper.UserMapper;
import com.mobin.carbon.pojo.User;
import com.mobin.carbon.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImp implements LoginService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(User user) {
        return userMapper.login(user.getUsername(), user.getPassword());
    }
}
