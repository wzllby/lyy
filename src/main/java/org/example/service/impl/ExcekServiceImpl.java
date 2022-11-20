package org.example.service.impl;

import org.apache.poi.ss.usermodel.*;
import org.example.comm.constant.CommConstant;
import org.example.exception.CommException;
import org.example.service.IExcelService;
import org.example.util.ReadExcelUtils;
import org.example.util.comm.StringUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wzllby
 * @date 2022年11月20日 22:41
 */
@Service
public class ExcekServiceImpl implements IExcelService {

    @Override
    public void saveInfo(String fileName) throws CommException {
        Workbook workbook = ReadExcelUtils.getWorkbook(fileName);
        Sheet sheet = ReadExcelUtils.getSheetById(workbook, CommConstant.NUM_ZERO);
        List<String> titleBar = saveTitleBar(sheet);
        saveContext(sheet, titleBar);
    }

    private List<String> saveTitleBar(Sheet sheet) {
        // 获取第一行数据为标题
        Row row = sheet.getRow(0);
        DataFormatter dft = new DataFormatter();
        List<String> titleBar = new ArrayList<>();
        for(Cell cell : row) {
            String text = dft.formatCellValue(cell);
            if (StringUtils.isEmpty(text)) {
                break;
            }
            titleBar.add(text);
        }
        return titleBar;
    }

    public void saveContext(Sheet sheet, List<String> titleBar) throws CommException {
        DataFormatter dft = new DataFormatter();
        int rowIndex = 1;
        List<Map<String, Object>> map = new ArrayList<>();
        boolean flag = true;
        while (flag) {
            Map<String, Object> rowDate = new HashMap<>();
            Row row = sheet.getRow(rowIndex);
            for (int i = 0; i < titleBar.size(); i++) {
                String value = dft.formatCellValue(row.getCell(i));
                if (StringUtils.isEmpty(value)) {
                    if (i == 0) {
                        flag = false;
                    }
                    break;
                }
                rowDate.put(titleBar.get(i), value);
            }
            map.add(rowDate);
            if (flag) {
                break;
            }
            rowIndex++;
        }
    }
}
