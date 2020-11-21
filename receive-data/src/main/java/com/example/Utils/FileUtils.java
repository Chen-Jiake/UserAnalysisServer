package com.example.Utils;

import java.io.File;
import java.io.FileOutputStream;

public class FileUtils {
    public static void uploadFile(byte[] filebyte, String filePath, String fileName) throws Exception {
        //确定储存路径是否存在
        File targetFile = new File(filePath);
        if(!targetFile.exists()){
            targetFile.mkdirs();
        }
        //把二进制流写到文件
        FileOutputStream out = new FileOutputStream(filePath + fileName);
        out.write(filebyte);
        out.flush();
        out.close();
    }
}
