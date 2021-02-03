package com.example.service;

import com.example.entity.Binding;
import com.example.entity.User;

public interface UserService {

    public void addUser(User user);

    public User findUserByUsername(String username);

    public void bindUser(String username, String bindingUsername);

    public Binding findBinding(String username, String bindingUsername);
}
