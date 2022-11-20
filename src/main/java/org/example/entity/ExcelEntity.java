package org.example.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * 读文件的实体
 */
@Getter
@Setter
@EqualsAndHashCode
public class ExcelEntity {
    private String string;
    private Date date;
    private Double doubleData;
}
