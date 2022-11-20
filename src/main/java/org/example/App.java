package org.example;


import org.example.util.WordUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class App {
    public static void main(String[] args) throws IOException {

//        SpringApplication.run(App.class);
        // 调用word文档帮助类
        WordUtil wordUtil = new WordUtil();

        // 模板文件存放的目录
        wordUtil.setBaseDir("C:\\Users\\86178\\Desktop");

        // 模板文件名称
        wordUtil.setTemplateFile("工作证明.ftl");

        // word生成的输出目录
        wordUtil.setOutputDir("C:\\Users\\86178\\Desktop\\file\\");

        // 初始化数据map
        Map<String,String> dataMap = new HashMap<>();
        List<String> lines = Files.readAllLines(new File("C:\\Users\\86178\\Desktop\\1.txt").toPath());
        // 录入采购基本数据
        for (String line : lines) {
            String[] split = line.split(",");
            dataMap.put("name", split[0]);
            dataMap.put("phone", split[1]);
            String oldPath = wordUtil.createWord(dataMap, dataMap.get("name"));
            if (oldPath.equals("操作失败")){
                System.out.println("操作失败");
            }

            //输出生成后的文件路径
            System.out.println(oldPath);
        }
        wordUtil.wordToPdf();
    }
}
