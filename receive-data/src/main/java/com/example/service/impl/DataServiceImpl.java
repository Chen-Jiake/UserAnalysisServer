package com.example.service.impl;

import com.example.dao.ImageDao;
import com.example.dao.MessageDao;
import com.example.entity.Message;
import com.example.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class DataServiceImpl implements DataService {

    @Autowired
    MessageDao messageDao;

    @Autowired
    ImageDao imageDao;


    @Override
    public void saveText(Message message) {
        messageDao.saveText(message);
    }

    @Override
    public void saveImage(MultipartFile file, String fileName) {
        imageDao.saveImage(file, fileName);
    }
}
