package com.xinxin.zzlz.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Description:
 * @Date: 2020/7/10
 * @Version: 1.0
 */
@RestController
public class FileController {
    /**
     * 接收银行推送文件接口 - 建设银行
     * @param file
     * @return
     */
    @PostMapping("/upload")
    public String receiveBankFiles(@RequestParam("data_file") MultipartFile file){
        String fileName = file.getOriginalFilename();
        return fileName;
    }
}
