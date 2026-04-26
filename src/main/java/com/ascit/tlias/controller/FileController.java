package com.ascit.tlias.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController

public class FileController {
    @GetMapping("/upload")
    public String upload(MultipartFile file){

        return "上传成功";
    }
}
