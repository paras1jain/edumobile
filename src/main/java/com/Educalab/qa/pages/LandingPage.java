package com.Educalab.qa.pages;

import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LandingPage extends com.Educalab.qa.base.TestBase {

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
