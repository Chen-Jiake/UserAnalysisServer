package com.example.service;

import com.example.entity.EmotionReason;
import com.example.entity.Message;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

public interface DataService {

    public void saveText(Message message);

    public void saveImage(MultipartFile file, String fileName);

    public Map<String, List<String>> getEmotionAndReason(String username);
}
