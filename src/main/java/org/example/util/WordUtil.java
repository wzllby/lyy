package org.example.util;

import com.spire.doc.Document;
import com.spire.pdf.FileFormat;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.*;

import java.util.Map;

public class WordUtil {
    private Configuration configuration = null;

    /*
     * 模板文件存放的目录
     */
    private String baseDir;

    /*
     * 模板文件名称
     */
    private String templateFile;

    /*
     * word生成的输出目录
     */
    private String outputDir;

    public WordUtil(){
        configuration = new Configuration();
        configuration.setDefaultEncoding("UTF-8");
    }

    public Configuration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(Configuration configuration) {
        this.configuration = configuration;
    }

    public String getBaseDir() {
        return baseDir;
    }

    public void setBaseDir(String baseDir) {
        this.baseDir = baseDir;
    }

    public String getTemplateFile() {
        return templateFile;
    }

    public void setTemplateFile(String templateFile) {
        this.templateFile = templateFile;
    }

    public String getOutputDir() {
        return outputDir;
    }

    public void setOutputDir(String outputDir) {
        this.outputDir = outputDir;
    }

    /*
     * <p>转换成word<br>
     */
    public String createWord(Map<String,String> dataMap, String name){

        configuration.setClassForTemplateLoading(this.getClass(), "");//模板文件所在路径

        Template t = null;

        try {
            //得到模板文件
            configuration.setDirectoryForTemplateLoading(new File(baseDir));
            t = configuration.getTemplate(templateFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // GwUtil.getFileNo(""); 调用生成随机数的方法
        File outFile = new File(outputDir + name  + ".docx"); //导出文件

        Writer out = null;
        try {
            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile)));
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }
        try {
            t.process(dataMap, out); //将填充数据填入模板文件并输出到目标文件
            return outFile.getPath();
        } catch (TemplateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "文档生成失败";
    }

    public void wordToPdf() {
        //实例化Document类的对象
        Document doc = new Document();
        File file = new File(outputDir);
        File[] files = file.listFiles();
        for (File file1 : files) {
            String absolutePath = file1.getAbsolutePath();
            doc.loadFromFile(absolutePath);
            doc.saveToFile(absolutePath.substring(0, absolutePath.lastIndexOf(".")) + ".pdf");
        }
    }
}
