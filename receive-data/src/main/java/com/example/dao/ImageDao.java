package com.example.dao;

import com.example.utils.FileUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class ImageDao {
    public void saveImage(MultipartFile file, String fileName) {
        //设置文件存储的路径
        String filePath = "/home/fc/IdeaProjects/UserAnalysisServer/data";
        try {
            //保存在本地
            FileUtils.uploadFile(file.getBytes(), filePath, fileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
