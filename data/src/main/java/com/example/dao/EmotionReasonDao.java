package com.example.dao;

import com.example.entity.EmotionReason;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmotionReasonDao {
    public List<EmotionReason> getEmotionReasonByUsername(String username);
}
