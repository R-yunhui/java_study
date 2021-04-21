/*
 * @projectName raladmin
 * @package com.ral.admin
 * @className com.ral.admin.Demo
 * @copyright Copyright 2020 Thunisoft, Inc All rights reserved.
 */
package com.ral.admin;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import cn.hutool.json.JSONUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import io.swagger.models.auth.In;

/**
 * Demo
 * @Description
 * @author renyunhui
 * @date 2021/3/30 18:03
 * @version 1.0
 */
public class Demo {

    public static void main(String[] args) throws Exception {
        File file = new File("C:\\Users\\13653\\Documents\\CoCall\\29006@cocall.thunisoft.com_8888\\FileRecv\\张飞\\表七：查处干部违纪违法情况统计表模板.xls");
        FileInputStream fileInputStream = new FileInputStream(file);
        List<Object> list = new LinkedList<>();
        HSSFWorkbook xssfWorkbook = new HSSFWorkbook(fileInputStream);
        Sheet sheet = xssfWorkbook.getSheet("各市州统计表");
        for (int i = 4; i < 7; i++) {
            Row row = sheet.getRow(i);
            for (int j = 0; j < row.getLastCellNum(); j++) {
                Cell cell = row.getCell(j);
                if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
                    list.add(cell.getStringCellValue());
                } else {
                    list.add(cell.getNumericCellValue());
                }
            }
        }
        System.err.println(list);

        List<Integer> list1 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list1.add(i);
        }
        System.err.println(list1);
    }
}
