package com.Lead.qa.pages;

import java.time.Duration;

import org.openqa.selenium.support.PageFactory;

import com.Lead.qa.base.TestBase;
import com.Lead.qa.util.Util;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomePage extends TestBase {

	 private AndroidDriver<AndroidElement> driver;
	    public HomePage(AndroidDriver<AndroidElement> driver) {
	        this.driver = driver;
	        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(9)), this);
	    }

	    public HomePage() {
			
		}

		@AndroidFindBy(xpath = "//*[@content-desc='Leads']")
	    private AndroidElement LeadsIcon;

	  

	   
	    public boolean isDisplayed() throws InterruptedException {
	    	Util.mFluentWait(driver);
	        return LeadsIcon.isDisplayed();
	    }

	    public void clickLeadsIcon() throws InterruptedException
	    {
	    	log.info("Welcome to Home Screen");
	    	Util.mFluentWait(driver);
	    	LeadsIcon.click();
	    	log.debug("Clicked on " + LeadsIcon + " LeadsIcon element");
	    	//return new LeadsPage(driver);
	    	
	    }

	  

	   
}
