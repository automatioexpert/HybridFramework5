package com.learnautomation.unittests;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.learnautomation.factory.BrowserFactory;

public class UnitTest001_BrowserCheck 
{
	
	@Test
	public void checkBrowser()
	{
		WebDriver driver=BrowserFactory.startBrowser("Chrome", "https://google.com");
		//Assert.assertNotNull(driver);
		Assert.assertTrue(driver!=null);
		driver.quit();
	}

}
