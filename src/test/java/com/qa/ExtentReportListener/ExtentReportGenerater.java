package com.qa.ExtentReportListener;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class ExtentReportGenerater implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Test started");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		/*System.out.println("Test Success");
		try {
			com.Lead.qa.util.Util.takeScreenshotAtEndOfTest("/screenshotOfSuccess/");
		}catch (IOException e) {
			e.printStackTrace();
		}
		*/
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		/*System.out.println("Test Fail");
		
		try {
			com.Lead.qa.util.Util.takeScreenshotAtEndOfTest("/screenshotOfFail/");
		}catch (IOException e) {
			e.printStackTrace();
		}
		*/
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		/*System.out.println("Test skipped");
		try {
			com.Lead.qa.util.Util.takeScreenshotAtEndOfTest("/screenshotOfSkipped/");
		}catch (IOException e) {
			e.printStackTrace();
		}
		*/
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("Test Failed But With  Success Percentage");
		
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("Method Started");
		
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Method Finished");
		
	}

}
