package org.example.controller;

import org.example.comm.RestCommon;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

@Controller
public class RestController {

    @RequestMapping("fileUpload")
    public RestCommon processFile(HttpServletRequest req, @RequestParam MultipartFile file) {
        String originalFilename = file.getOriginalFilename();
        if (originalFilename.endsWith(".xlsx")) {
            new RestCommon(503, "上传的文件格式错误", null);
        }
        return new RestCommon(200, "上传文件成功", null);
    }

    @RequestMapping("index")
    public String index() {
        return "1.html";
    }
}
