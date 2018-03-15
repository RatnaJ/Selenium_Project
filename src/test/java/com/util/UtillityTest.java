package com.util;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class UtillityTest {
    int totalRows;
    XSSFWorkbook wb;
    XSSFSheet sh1;
    String[] values = new String[6];

    public ArrayList<Object[]> getDataFromExcel(String fileLocation) {

        ArrayList<Object[]> dataSet = new ArrayList<>();
        try {
            File file = new File(fileLocation);

            FileInputStream fis = new FileInputStream(file);

            wb = new XSSFWorkbook(fis);
            sh1 = wb.getSheetAt(0);
            totalRows = sh1.getLastRowNum();
            System.out.println("Rows " + totalRows);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //System.out.println(num);


        int totalColumn = sh1.getRow(0).getLastCellNum();
        System.out.println("Total Column " + totalColumn);

        for (int rowCount = 1; rowCount <= totalRows; rowCount++) {
            String firstN = sh1.getRow(rowCount).getCell(0).getStringCellValue();
            String lastN = sh1.getRow(rowCount).getCell(1).getStringCellValue();
            String email = sh1.getRow(rowCount).getCell(2).getStringCellValue();
            String passW = sh1.getRow(rowCount).getCell(3).getStringCellValue();


            Object[] b1 = {firstN, lastN, email, passW};
            dataSet.add(b1);
            System.out.println(dataSet.size());
        }


        return dataSet;
    }
}
