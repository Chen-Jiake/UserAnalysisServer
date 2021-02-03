package com.example.service.impl;

import com.example.dao.UserDao;
import com.example.entity.Binding;
import com.example.entity.User;
import com.example.entity.UserBinding;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    public User findUserByUsername(String username) {
        return userDao.findUserByUsername(username);
    }

    @Override
    public void bindUser(String username, String bindingUsername) {
        userDao.addBindingUser(username, bindingUsername);
    }

    @Override
    public Binding findBinding(String username, String bindingUsername) {
        return userDao.findBinding(username, bindingUsername);
    }
}
