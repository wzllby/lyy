package org.example.util;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.example.exception.CommException;
import org.example.util.comm.StringUtils;

import java.io.File;
import java.io.IOException;

/**
 * 读取Excel文件的工具类
 *
 * @author wzllby
 * @date 2022/11/20 19:37
 */
public class ReadExcelUtils {

    /**
     * 获取Workbook对象
     *
     * @author wzllby
     * @date 2022/11/20 19:45
     * @param fileName 文件名称
     * @return org.apache.poi.ss.usermodel.Workbook
     */
    public static Workbook getWorkbook(String fileName) throws CommException {
        if (StringUtils.isEmpty(fileName)) {
            throw new CommException("xlsx file is empty.");
        }
        File file = new File(fileName);
        if (!file.exists()) {
            throw new CommException(fileName + "is not exist.");
        }
        Workbook workbook = null;
        try {
            workbook = WorkbookFactory.create(new File(fileName));
        } catch (IOException e) {
            throw new CommException("getWorkbook is null.", e);
        }
        return workbook;
    }

    /**
     * 获取第index个sheet页
     *
     * @author wzllby
     * @date 2022/11/20 21:27
     * @param workbook
     * @param index index页
     * @return org.apache.poi.ss.usermodel.Sheet
     */
    public static Sheet getSheetById(Workbook workbook, int index) throws CommException {
        if (index < 0) {
            throw new CommException("sheet index value is invalid.");
        }
        return workbook.getSheetAt(index);
    }
}
