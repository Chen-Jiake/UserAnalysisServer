package com.example.dao;

import com.example.utils.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class ImageDao {
    @Value("${image-filepath}")
    private String filePath;

    public void saveImage(MultipartFile file, String fileName) {
        try {
            //保存在本地
            FileUtils.uploadFile(file.getBytes(), filePath, fileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
