package com.learnautomation.utility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

public class Utility 
{
	
	/*
	 *   findElement
	 *   click
	 *   type
	 *   explicitwait
	 *   wait
	 *   dropdown
	 *   getText
	 *   JavaScript
	 *   highlight
	 *   getAttribute 
	 * 
	 */
	
	public static void sleep(int time)
	{
		try 
		{
			Thread.sleep(time*1000);
		} catch (InterruptedException e) 
		{
			
		}
	}
	
	public static void highLightElement(WebDriver driver, WebElement element)
	{
	JavascriptExecutor js=(JavascriptExecutor)driver; 
	 
	js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
	 
	try 
	{
	Thread.sleep(500);
	} 
	catch (InterruptedException e) {
	 
	System.out.println(e.getMessage());
	} 
	 
	js.executeScript("arguments[0].setAttribute('style','border: solid 2px white');", element); 
	 
	}
	

	public static WebElement getElement(WebDriver driver,By locator)
	{
		WebElement element=driver.findElement(locator);
		
		highLightElement(driver, element);
		
		return element;
	}
	
	public static void click(WebDriver driver,By locator)
	{
		getElement(driver, locator).click();
	}
	
	public static void type(WebDriver driver,By locator,String text)
	{
		getElement(driver, locator).sendKeys(text);
	}
	
	public static void selectValueFromDropDown(WebDriver driver,By locator,String text)
	{
		new Select(getElement(driver, locator)).selectByVisibleText(text);
	}

	public static String captureScreenshot(WebDriver driver)
	{
		String path=System.getProperty("user.dir")+"/Screenshots/LearnAutomation"+System.currentTimeMillis()+".png";
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		
		File src=ts.getScreenshotAs(OutputType.FILE);
		
		try 
		{
			FileHandler.copy(src, new File(path));
		} catch (IOException e) 
		{
			System.out.println("Could not capture screenshot "+e.getMessage());
		}
		
		
		return path;
	}
	
	public static String captureScreenshotBase64(WebDriver driver)
	{
			
		TakesScreenshot ts=(TakesScreenshot)driver;
		
		return ts.getScreenshotAs(OutputType.BASE64);
			
	}
	
	
}
