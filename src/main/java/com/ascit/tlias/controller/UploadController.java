package com.ascit.tlias.controller;

import com.ascit.tlias.result.Result;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
public class UploadController {

    @Value("${file.upload.path}")
    private String uploadPath;

    @PostMapping("/upload")
    public Result upload(MultipartFile file) throws IOException {
        // 1. 生成唯一文件名
        String originalFilename = file.getOriginalFilename();
        String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
        String newFilename = UUID.randomUUID().toString() + suffix;

        // 2. 创建目录（如果不存在）
        File dir = new File(uploadPath);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        // 3. 保存文件
        file.transferTo(new File(dir, newFilename));

        // 4. 构建返回的URL
        String url = "http://localhost:8080/" + newFilename;

        return Result.success(url);
    }
}
