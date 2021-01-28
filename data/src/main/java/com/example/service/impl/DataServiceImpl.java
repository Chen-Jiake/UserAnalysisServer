package com.example.service.impl;

import com.example.dao.EmotionReasonDao;
import com.example.dao.ImageDao;
import com.example.dao.MessageDao;
import com.example.entity.EmotionReason;
import com.example.entity.Message;
import com.example.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DataServiceImpl implements DataService {

    @Autowired
    MessageDao messageDao;

    @Autowired
    ImageDao imageDao;

    @Autowired
    EmotionReasonDao emotionReasonDao;

    private String pythonCmd = "python /mnt/sda/chenjiake/Rank-Emotion-Cause-master/main.py";

    @Override
    public void saveText(Message message) {
        if(message.getApp().equals("微博") || message.getApp().equals("微信朋友圈")) {
            try {
                Runtime.getRuntime().exec(pythonCmd + message.getContent());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        messageDao.saveText(message);
    }

    @Override
    public void saveImage(MultipartFile file, String fileName) {
        imageDao.saveImage(file, fileName);
    }

    @Override
    public Map<String, List<String>> getEmotionAndReason(String username) {
        Map<String, List<String>> map = new HashMap<>();
        List<EmotionReason> list = emotionReasonDao.getEmotionReasonByUsername(username);
        for(EmotionReason emotionReason : list) {
            if(!map.containsKey(emotionReason.getEmotion())) {
                map.put(emotionReason.getEmotion(), new ArrayList<>());
            }
            map.get(emotionReason.getEmotion()).add(emotionReason.getReason());
        }
        return map;
    }

}
