package com.example.controller;

import com.example.Utils.FileUtils;
import com.example.entity.Message;
import com.example.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

@RestController
public class DataController {

    @Autowired
    DataService dataService;
    HttpServletRequest request;

    @PostMapping("/data/text")
    public void saveText(Message message){
        dataService.saveText(message);
    }

    //文件上传功能(任何格式文件)
    @PostMapping(value="/upload/uploadFile")
    public @ResponseBody
    String uploadImg(@RequestParam("file") MultipartFile file, @RequestParam("filename") String fileName) {
        //获取文件名
        //String fileName = file.getOriginalFilename();
        //这是保存在Temp临时文件里
        //String filePath = request.getSession().getServletContext().getRealPath("uploadedImg/");
        //设置文件存储的路径
        String filePath = "E:/AndroidApp/";
        try {
            //保存在本地
            FileUtils.uploadFile(file.getBytes(), filePath, fileName);
            return "上传成功";
        } catch (Exception e) {
            return "上传失败";
        }
    }
    //hello 测试
    @RequestMapping("/hello")
    public String hello() {
        return "Hello Spring Boot!";
    }
}
