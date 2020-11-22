package com.example.service;

import com.example.entity.Message;
import org.springframework.web.multipart.MultipartFile;

public interface DataService {

    public void saveText(Message message);

    public void saveImage(MultipartFile file, String fileName);

}
