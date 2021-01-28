package com.example.controller;

import com.example.bean.ResultBean;
import com.example.entity.EmotionReason;
import com.example.entity.Message;
import com.example.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    }

    @GetMapping(value = "/data/emotion")
    public ResultBean<Map<String, List<String>>> emotion(@RequestParam("username") String username) {
        return new ResultBean<>(201, "", dataService.getEmotionAndReason(username));
    }
}
