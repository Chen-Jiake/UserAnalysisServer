package com.example.controller;

import com.example.bean.ResultBean;
import com.example.entity.Binding;
import com.example.entity.User;
import com.example.entity.UserBinding;
import com.example.service.UserService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;

@RestController
public class UserController {

    private Logger log = LoggerFactory.getLogger(UserController.class);
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

    @PostMapping("/user/bind")
    public ResultBean<Void> bind(@RequestBody UserBinding userBinding){
        User user = userBinding.getUser();
        User bindingUser = userBinding.getBindingUser();
        log.info(user.toString());
        log.info(bindingUser.toString());
        User existBindingUser = userService.findUserByUsername(bindingUser.getUsername());
        if (existBindingUser == null) {
            return new ResultBean<>(600, "绑定用户不存在！", null);
        } else if(!existBindingUser.getPassword().equals(bindingUser.getPassword())) {
            return new ResultBean<>(600, "绑定用户密码错误！", null);
        }
        Binding binding = userService.findBinding(user.getUsername(), bindingUser.getUsername());
        if(binding != null) {
            return new ResultBean<>(600, "该用户已绑定！", null);
        }
        userService.bindUser(user.getUsername(), bindingUser.getUsername());
        return new ResultBean<>(201, "绑定成功！", null);
    }

}

