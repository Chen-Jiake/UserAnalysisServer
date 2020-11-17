package com.example.dao;

import com.example.entity.Message;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MessageDao {

    public void saveText(Message message);
}
