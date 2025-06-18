package com.example.smsless.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.smsless.entity.User;

public interface UserService extends IService<User> {
    //注册
    boolean  register(User user);
    //登录
    User login(User user);
}
