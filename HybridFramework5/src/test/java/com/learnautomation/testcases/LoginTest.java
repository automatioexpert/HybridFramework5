package com.learnautomation.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.learnautomation.base.BaseClass;
import com.learnautomation.dataproviders.CustomDataProviders;
import com.learnautomation.pages.LoginPage;

public class LoginTest extends BaseClass
{
	
	public WebDriver driver;
	
	@BeforeMethod
	public void setup()
	{
		driver=getDriver();
	}
	

	@Test(dataProvider="adminUser",dataProviderClass=CustomDataProviders.class)
	public void loginApplication(String username,String password)
	{
		LoginPage login=new LoginPage(driver);
		
		login.loginToApplication(username,password);
		
		Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"));

	}
	
	
	
}
