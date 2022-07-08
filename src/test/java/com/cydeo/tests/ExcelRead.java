package com.cydeo.tests;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelRead {

    @Test
    public void read_from_excel() throws IOException {

        String path = "SampleData.xlsx";

        //File file = new File(path); // work with and without it
        FileInputStream fileInputStream = new FileInputStream(path);// to read from excel

        //workbook >sheet >row >sell
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);// create workbook

        XSSFSheet sheet = workbook.getSheet("Employee");// specific sheet from opened workbook

        System.out.println(sheet.getRow(1).getCell(0));//print Mary. index starts from 0

        System.out.println(sheet.getRow(3).getCell(2));// developer

        int usedRows = sheet.getPhysicalNumberOfRows();// return the count of cells only, counting starts from 1
        System.out.println(usedRows);

        int lastUsedRow = sheet.getLastRowNum(); // returns num from top to bottom cell, no natter if sell is empty or not, counting starts from 0
        System.out.println(lastUsedRow);

        // create a logic to print Vinod's name
        for(int rowNum=0; rowNum <usedRows; rowNum++){
            if(sheet.getRow(rowNum).getCell(0).toString().equals("Vinod")){
                System.out.println("Linda's job title "  + sheet.getRow(rowNum).getCell(2));
            }
        }
    }
}
