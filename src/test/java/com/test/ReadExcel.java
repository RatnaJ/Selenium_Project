package com.test;

import com.util.UtillityTest;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class ReadExcel {
    ArrayList<Object[]> outPut;

    @Test
    public void readExcel() throws Exception{
        File file = new File("/Users/ratnajalla/testNgProject/src/test/java/com/testdata/TestData.xlsx");

        FileInputStream fis = new FileInputStream(file);
//        try (FileInputStream fis = new FileInputStream(file)) {
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        XSSFWorkbook wb = new XSSFWorkbook(fis);
       XSSFSheet sh1 =  wb.getSheetAt(0);
       String data0 = sh1.getRow(0).getCell(0).getStringCellValue();
        System.out.println(data0);

        //wb.close();

        UtillityTest util = new UtillityTest();
        outPut = util.getDataFromExcel("/Users/ratnajalla/testNgProject/src/test/java/com/testdata/TestData.xlsx");
//        System.out.println(outPut);
//        Object[] o = new Object[outPut.size()];
//        for (int i = 0; i < outPut.size() ; i++) {
//             o[i] = outPut.get(i);
//            System.out.println(Arrays.toString(o));
//
//        }

        for (Object[] a:outPut
             ) {
            for (int i = 0; i < a.length ; i++) {
                System.out.println(a[i]);

            }
        }

        //System.out.println(o.length);



    }
}
