package com.srm.utils;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.*;

public class ExcelReader {

    public static Object[][] getData(String sheetName) {

        Object[][] data = null;

        try {

            FileInputStream fis =
                    new FileInputStream("src/main/resources/LoginData2.xlsx");

            XSSFWorkbook wb = new XSSFWorkbook(fis);
            XSSFSheet sheet = wb.getSheet(sheetName);

            int rows = sheet.getLastRowNum();
            int cols = sheet.getRow(0).getLastCellNum();

            data = new Object[rows][cols];

            for (int i = 1; i <= rows; i++) {
                for (int j = 0; j < cols; j++) {
                    data[i - 1][j] =
                            sheet.getRow(i).getCell(j).toString();
                }
            }

            wb.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }
}