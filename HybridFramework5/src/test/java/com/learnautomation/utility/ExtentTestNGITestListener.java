	package com.learnautomation.utility;



import java.io.IOException;
import java.lang.reflect.Field;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;


public class ExtentTestNGITestListener implements ITestListener{

	private static ExtentReports extent = ExtentManager.getInstance();
	
	ExtentTest child;
	
	ThreadLocal<ExtentTest> parentTest=new ThreadLocal<ExtentTest>();
	
	
  
	public synchronized void onFinish(ITestContext context) 
	{	
		System.out.println("**** Test Finished ****");
		
		extent.flush();
		
		System.out.println("**** Adding Result to report ****");
	}
	
	
	public synchronized void onTestStart(ITestResult result) 
	{
		System.out.println("**** Starting Test ***");
		
		ExtentTest parent = extent.createTest(result.getMethod().getMethodName());
		
		parentTest.set(parent);
		
		System.out.println("**** Test Started ***");
	}

	
	public synchronized void onTestSuccess(ITestResult result) 
	{
		System.out.println("**** Test Passed ****");
		parentTest.get().pass("Test passed");
	}

	
	public synchronized void onTestFailure(ITestResult result) 
	{
		System.out.println("**** Test Failed ****");
		
		WebDriver driver=null;
		
		//WebDriver driver1=null;
		
		
		
		try 
		{
			Field f=result.getTestClass().getRealClass().getDeclaredField("driver");
			
			Object obj=f.get(result.getInstance());
			
			driver=(WebDriver)obj;
			
			System.out.println("Driver value from listener is "+driver);
			
			//driver1=(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
			
			
		} catch (Exception e) 
		{
			
		}
		
		try 
		{
			/*parentTest.get().fail(result.getThrowable().getMessage(),
			MediaEntityBuilder.createScreenCaptureFromPath(Utility.captureScreenshot(driver)).build());*/
	
			parentTest.get().fail(result.getThrowable().getMessage(),
					MediaEntityBuilder.createScreenCaptureFromBase64String(Utility.captureScreenshotBase64(driver)).build());
		} 
		catch (IOException e) 
		{
			
		}
		
	}


	public synchronized void onTestSkipped(ITestResult result) 
	{
		System.out.println("**** Test Skipped ****");
		parentTest.get().skip(result.getThrowable().getMessage());
	}

	
	public synchronized void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}
}
	

