package org.example.controller;

import org.example.comm.RestCommon;
import org.example.exception.CommException;
import org.example.service.IExcelService;
import org.example.util.comm.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/**
 * @author wzllby
 * @date 2022年11月20日 22:23
 */
@Controller
@RequestMapping("excel")
public class ExcelController {

    @Autowired
    private IExcelService iExcelService;

    @RequestMapping("resolverExcel")
    public RestCommon resolverExcel(@RequestParam MultipartFile multipartFile) {
        String originalFilename = multipartFile.getOriginalFilename();
        String uuidRomDom = NumberUtils.uuidRomDom();
        String fileName = "";
        try {
            iExcelService.saveInfo(fileName);
        } catch (CommException e) {
            throw new RuntimeException(e);
        }
        if (originalFilename.endsWith(".xlsx")) {
            new RestCommon(503, "上传的文件格式错误", null);
        }
        return new RestCommon(200, "上传文件成功", null);
    }
}
