package com.example.service;

import com.example.entity.User;

public interface UserService {

    public void addUser(User user);

    public User findUserByUsername(String username);
}
