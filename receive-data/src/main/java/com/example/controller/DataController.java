package com.example.controller;

import com.example.entity.Message;
import com.example.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class DataController {

    @Autowired
    DataService dataService;

    @PostMapping(value = "/data/message", produces = "application/json;charset=UTF-8")
    public void saveText(@RequestBody Message message){
        dataService.saveText(message);
    }

    //文件上传功能(任何格式文件)
    @PostMapping(value="/data/image")
    public void uploadImg(@RequestParam("file") MultipartFile file, @RequestParam("filename") String fileName) {
        dataService.saveImage(file, fileName);
        System.out.println("收到");
    }
}
