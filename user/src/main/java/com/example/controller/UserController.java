package com.example.controller;

import com.example.bean.ResultBean;
import com.example.entity.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/user/addUser")
    public ResultBean<Void> addUser(@RequestBody User user){
        User existUser = userService.findUserByUsername(user.getUsername());
        if (existUser != null) {
            return new ResultBean<>(600, "该用户名已被注册！", null);
        }
        userService.addUser(user);
        return new ResultBean<>(201, "注册成功！", null);
    }

    @PostMapping("/user/login")
    public ResultBean<Void> login(@RequestBody User user){
        User existUser = userService.findUserByUsername(user.getUsername());
        if (existUser == null) {
            return new ResultBean<>(600, "该用户不存在！", null);
        } else if(!existUser.getPassword().equals(user.getPassword())) {
            return new ResultBean<>(600, "密码错误！", null);
        }
        return new ResultBean<>(201, "登录成功！", null);
    }

}

