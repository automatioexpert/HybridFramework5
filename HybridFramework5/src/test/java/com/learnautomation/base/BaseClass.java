package com.learnautomation.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.learnautomation.factory.BrowserFactory;

public class BaseClass {

	public WebDriver driver;
	
	public WebDriver getDriver()
	{
		return driver;
	}
		

	/*	@BeforeClass
	public void setupBrowser()
	{
		System.out.println("**** Running TC ****");
		
		driver=BrowserFactory.startBrowser(ConfigUtility.getProperty("Browser"),ConfigUtility.getProperty("stagingURL"));
	}*/
	
	
	@Parameters({"Browser","URL"})
	@BeforeClass
	public void setupBrowser(String browser,String url)
	{
		System.out.println("**** Running TC ****");
		
		driver=BrowserFactory.startBrowser(browser,url);
	}
	
	
}
