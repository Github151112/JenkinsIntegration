package com.Ecommerce.GenericUtility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	
	/*
	 * this method will read the data from excel file
	 * @ String excelPath
	 * @ String sheetName
	 * @ int rowNo
	 * @ int cellNo
	 */
	
	public String readDataFromExcel(String excelPath,String sheetName,int rowNo, int cellNo) throws EncryptedDocumentException, IOException
	{
		FileInputStream f = new FileInputStream(excelPath);
		Workbook book = WorkbookFactory.create(f);
		Sheet sheet = book.getSheet(sheetName);
		return sheet.getRow(rowNo).getCell(cellNo).getStringCellValue();
	}
	
	public static Object[][] readMultipleDataFromExcel(String excelPath,String sheetName) throws EncryptedDocumentException, IOException
	{
		FileInputStream f = new FileInputStream(excelPath);
		Workbook book = WorkbookFactory.create(f);
		Sheet sheet = book.getSheet(sheetName);
		int row = sheet.getPhysicalNumberOfRows();
		System.out.println(row);
		int cell = sheet.getRow(0).getPhysicalNumberOfCells();
		System.out.println(cell);
		Object[][] data = new Object[row-1][cell];
		for(int i=1;i<row;i++)
		{
			for(int j=0;j<cell;j++)
			{
				data[i-1][j] = sheet.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return data;
		
	}
	

}
