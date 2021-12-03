package com.Lead.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import com.Lead.qa.base.TestBase;
import com.Lead.qa.util.Util;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LandingPage extends TestBase {

	private AndroidDriver<AndroidElement> driver;

	public LandingPage(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}


	@AndroidFindBy(xpath = "(//*[@class='android.widget.Button'])[1]")
	private AndroidElement landingscreenskipbutton;
	

	
	
	public LoginPage Landingskip() throws InterruptedException {
		log.info("Welcome to Login Screen");
		
		  Thread.sleep(2000);
		  driver.switchTo().frame(0);
		landingscreenskipbutton.click();
		return new LoginPage(driver);
		

	}

}
