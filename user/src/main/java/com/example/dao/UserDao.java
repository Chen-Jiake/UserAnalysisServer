package com.example.dao;

import com.example.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {
    public void addUser(User user);
    public User findUserByUsername(String username);
}
