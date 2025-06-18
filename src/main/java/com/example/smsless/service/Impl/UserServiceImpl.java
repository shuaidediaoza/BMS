package com.example.smsless.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.smsless.entity.User;
import com.example.smsless.mapper.UserMapper;
import com.example.smsless.service.UserService;

import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    //注册
    @Override
    public boolean register(User user) {
        // 检查用户名是否重复
          //::是类方法句柄
          // lambdaQuery()是MybatisPlus提供的方法
          // lambdaQuery() 创建了一个 LambdaQueryWrapper<User> 实例。
          //.eq(User::getUsername, user.getUsername()) 添加了一个查询条件，筛选出与当前注册用户名相同的记录。
          //.eq()方法的参数是：字段名、字段值
          //.one() 返回查询结果中的第一个记录。
        if (lambdaQuery().eq(User::getUsername, user.getUsername()).one() != null) {
            return false;
        }
        if (user.getPassword() == null || user.getPassword().isEmpty()) {
            throw new IllegalArgumentException("用户密码不能为空");
        }
        // 密码加密存储
        user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
        return save(user);
    }

    //登录
    @Override
    public User login(User user) {
        String encryptedPwd = DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
        return lambdaQuery()
                .eq(User::getUsername, user.getUsername())
                .eq(User::getPassword, encryptedPwd)
                .one();
    }
}
