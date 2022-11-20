package org.example;


import org.apache.poi.ss.usermodel.*;
import org.example.exception.CommException;
import org.example.util.ReadExcelUtils;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class App {
    public static void main(String[] args) throws IOException, CommException {

//        SpringApplication.run(App.class);
//        // 调用word文档帮助类
//        WordUtil wordUtil = new WordUtil();
//
//        // 模板文件存放的目录
//        wordUtil.setBaseDir("C:\\Users\\86178\\Desktop");
//
//        // 模板文件名称
//        wordUtil.setTemplateFile("工作证明.ftl");
//
//        // word生成的输出目录
//        wordUtil.setOutputDir("C:\\Users\\86178\\Desktop\\file\\");
//
//        // 初始化数据map
//        Map<String,String> dataMap = new HashMap<>();
//        List<String> lines = Files.readAllLines(new File("C:\\Users\\86178\\Desktop\\1.txt").toPath());
//        // 录入采购基本数据
//        for (String line : lines) {
//            String[] split = line.split(",");
//            dataMap.put("name", split[0]);
//            dataMap.put("phone", split[1]);
//            String oldPath = wordUtil.createWord(dataMap, dataMap.get("name"));
//            if (oldPath.equals("操作失败")){
//                System.out.println("操作失败");
//            }
//
//            //输出生成后的文件路径
//            System.out.println(oldPath);
//        }
//        wordUtil.wordToPdf();

        String fileName = "C:\\Users\\86178\\Desktop\\媛媛工作\\核酸检测登记台账模板11.8.xlsx";
        Sheet sheet = ReadExcelUtils.getSheetById(ReadExcelUtils.getWorkbook(fileName), 0);
        DataFormatter dft = new DataFormatter();
        Row row = sheet.getRow(0);
        for (Cell cell : row) {
            System.out.println(dft.formatCellValue(cell));
        }
    }
}
