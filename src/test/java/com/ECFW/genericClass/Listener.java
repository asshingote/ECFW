package com.ECFW.genericClass;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.ECFW.testClass.BaseTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class Listener extends BaseTest implements ITestListener
{
	
	public void onFinish(ITestContext context) 
	{
		String str = context.getName();
		Reporter.log("Test Execution Finished : "+ str,true);
		//extent.flush();
	}

	
	public void onStart(ITestContext context) 
	{
		String str = context.getName();
		Reporter.log("Test Execution Start : "+ str,true);
		//logger = extent.createTest(str);
	}

	
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) 
	{
		String str = result.getName();
		Reporter.log("Test Method Almost Passed :"+ str,true);				
	}

	
	public void onTestFailure(ITestResult result)
	{
		String str = result.getName();
		if (result.getStatus() == ITestResult.FAILURE) 
		{
			String temp = ScreenShotHandling.getScreenShot(driver, str);
			// MarkupHelper is used to display the output in different colors
			logger.log(Status.FAIL,MarkupHelper.createLabel("Test Case Failed is :"+str, ExtentColor.RED));
			logger.log(Status.FAIL,MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));
			try {
				logger.fail(result.getThrowable().getMessage(),MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		Reporter.log("Test Method Failed : "+ str,true);
	}

	public void onTestSkipped(ITestResult result) 
	{
		String str = result.getName();
		if (result.getStatus() == ITestResult.SKIP) 
		{
			// logger.log(Status.SKIP, "Test Case Skipped is :"+result.getName());
			logger.log(Status.SKIP, MarkupHelper.createLabel("Test Case Skipped is :"+str, ExtentColor.ORANGE));
		}
		Reporter.log("Test Method Skipped :"+ str,true);
	}
	
	public void onTestStart(ITestResult result)
	{
		String str = result.getName();
		Reporter.log("Test Method Start :"+ str,true);
	}

	public void onTestSuccess(ITestResult result) 
	{
		String str = result.getName();
		Reporter.log("Test Method Success :"+ str,true);
		logger.log(Status.PASS, MarkupHelper.createLabel("Test Case Passed is :"+str, ExtentColor.GREEN));
	}
}
//https://www.swtestacademy.com/extentreports-testng/
//link for creating extent reports