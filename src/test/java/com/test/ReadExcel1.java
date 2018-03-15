package com.test;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

public class ReadExcel1 {
    @Test
    public void readExcel() throws Exception{
        File file = new File("/Users/ratnajalla/testNgProject/src/test/java/com/testdata/TestData.xlsx");

        FileInputStream fis = new FileInputStream(file);

        XSSFWorkbook wb = new XSSFWorkbook(fis);
       XSSFSheet sh1 =  wb.getSheetAt(0);
       int num = sh1.getLastRowNum();
        System.out.println(num);
        //wb.close();
    }

    @Test
    public void testArray(){
        //String[] b;
        List<Object[]> arrStr = new ArrayList<>();
        String[] arr1 = {"apple", "banana", "grapes"};
        String[] arr2 = {"Red", "Blue", "Green"};
        arrStr.add(arr1);
        arrStr.add(arr2);

        System.out.println(arrStr.iterator());

//        for (Object[] b: arrStr
//             ) {
//
//            for (int i = 0; i < b.length; i++) {
//                System.out.println(b[i]);
//            }
//            //System.out.println(b);
//        }




    }
}
