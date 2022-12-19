package com.learnautomation.dataproviders;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	
	static XSSFWorkbook wb;
	
	public static Object [][] getDataFromExcel(String sheetName)
	{
		System.out.println("Creating Test Data");
		
		try 
		{
			wb = new XSSFWorkbook(new FileInputStream(new File(System.getProperty("user.dir")+"/TestData/Data.xlsx")));
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println("File not found "+e.getMessage());
		} catch (IOException e) 
		{
			System.out.println("Unable to read the file "+e.getMessage());
		}
		
		int rowcount=wb.getSheet(sheetName).getPhysicalNumberOfRows();
		
		int columnCount=wb.getSheet(sheetName).getRow(0).getPhysicalNumberOfCells();
			
		Object [][]arr=new Object[rowcount][columnCount];
		
		for(int i=0;i<rowcount;i++)
		{
			for(int j=0;j<columnCount;j++)
			{
				
				arr[i][j]=getCellData(sheetName, i, j);
			}
			
		}
		
		System.out.println("Test Data Generated");
		
		return arr;
	}
	
	public static String getCellData(String sheetName,int row,int column)
	{
		XSSFCell cell=wb.getSheet(sheetName).getRow(row).getCell(column);
		
		String data=null;
		
		if(cell.getCellType()==CellType.STRING)
		{
			data=cell.getStringCellValue();
		}
		else if(cell.getCellType()==CellType.NUMERIC)
		{
			data=String.valueOf(cell.getNumericCellValue());
		}
		else if(cell.getCellType()==CellType.BLANK)
		{
			data="";
		}
		
		return data;
	}
	
}
