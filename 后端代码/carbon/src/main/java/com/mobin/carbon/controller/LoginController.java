package com.mobin.carbon.controller;


import com.mobin.carbon.pojo.Result;
import com.mobin.carbon.pojo.User;
import com.mobin.carbon.service.LoginService;
import com.mobin.carbon.utils.Logger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @RequestMapping("/login")
    public Result login(@RequestBody User user, HttpServletRequest request) {
        log.info("用户登录: {}", user);
        Logger.writeLog(request, "登录");
        User loginUser = loginService.login(user);
        if (loginUser == null) return Result.error("用户名或密码错误");
        return Result.success();
    }

}
