package com.example.smsless.controller;

import com.example.smsless.entity.User;
import com.example.smsless.exception.Result;
import com.example.smsless.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService  userService;

    //注册

    @PostMapping("/register")
    public Result<String> register(@RequestBody User user){
        if (userService.register(user)) {
            return Result.success("注册成功");
        }
        return Result.fail("用户名已存在");
    }

    //登录
    @PostMapping("/login")
    public Result<String> login(@RequestBody User  user){
        userService.login(user);
        // 判断密码是否为空
        if (user.getPassword() == null || user.getPassword().isEmpty()) {
            throw new IllegalArgumentException("密码不能为空");
        }

        //生成Token并返回
        //String token = CustomTokenUtils.generateToken(user.getUsername());
        return Result.success(user.getUsername());
    }
}
