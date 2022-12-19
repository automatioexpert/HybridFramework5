package com.learnautomation.dataproviders;

import org.testng.annotations.DataProvider;


public class CustomDataProviders 
{
	 
	@DataProvider(name="adminUser")
	public static Object [][] testData()
	{
		return ExcelUtility.getDataFromExcel("Admin");
	}
	

}
