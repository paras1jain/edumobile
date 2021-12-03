package com.Lead.qa.util;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.Lead.qa.base.TestBase;



public class WebEventListener extends TestBase implements WebDriverEventListener{

	public void beforeNavigateTo(String url, WebDriver driver) {
		System.out.println("Before navigation to: '"+url+"'");
	}
	
	public void afterNavigateTo(String url, WebDriver driver) {
		System.out.println("navigation to: '"+url+"'");
	}
	
	public void beforeChangeValueof(WebElement element, WebDriver driver) {
		System.out.println("value of the: "+element.toString()+"before any change mode");
	}
	
	public void afterChangeValueof(WebElement element, WebDriver driver) {
		System.out.println("Element value changed to "+element.toString());
	}
	
	public void beforeClickOn(WebElement element, WebDriver driver) {
		System.out.println("Trying to click on "+element.toString());
	}

	public void afterClickOn(WebElement element, WebDriver driver) {
		System.out.println("Trying to click on "+element.toString());
	}

	public void  beforeNavigateBack( WebDriver driver) {
		System.out.println("Navigating back to previous page ");
	}
	
	public void  afterNavigateBack( WebDriver driver) {
		System.out.println("Navigated back to previous page ");
	}
	
	public void  beforeNavigateForward( WebDriver driver) {
		System.out.println("Navigating forward to previous page ");
	}
	
	public void  aftereNavigateForward( WebDriver driver) {
		System.out.println("Navigated forward to previous page ");
	}
	
	
	public void  onException( Throwable error, WebDriver driver) {
		System.out.println("Exception occured : " + error);
		
//		try {
//			takeScreenshotAtEndOfTest();
//		}catch (IOException e) {
//			e.printStackTrace();
//		}
		}

	@Override
	public void beforeAlertAccept(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterAlertAccept(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterAlertDismiss(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeAlertDismiss(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterNavigateForward(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeSwitchToWindow(String windowName, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterSwitchToWindow(String windowName, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <X> void beforeGetScreenshotAs(OutputType<X> target) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeGetText(WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterGetText(WebElement element, WebDriver driver, String text) {
		// TODO Auto-generated method stub
		
	}
		
	}

