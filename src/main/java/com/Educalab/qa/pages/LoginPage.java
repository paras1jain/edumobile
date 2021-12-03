package com.Educalab.qa.pages;

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

public class LoginPage extends TestBase {

	private AndroidDriver<AndroidElement> driver;

	public LoginPage(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(xpath = "//android.view.View[@content-desc='Welcome, please login']")
	private AndroidElement loginscreentitle;

	@AndroidFindBy(xpath = "(//*[@class='android.widget.Button'])[1]")
	private AndroidElement landingscreenskipbutton;
	
	@AndroidFindBy(xpath = "(//*[@class='android.widget.EditText'])[1]")
	private AndroidElement loginid;

	@AndroidFindBy(xpath = "(//*[@class='android.widget.EditText'])[2]")
	private AndroidElement password;

	@AndroidFindBy(xpath = "//*[@content-desc='Forgot Password?']")
	private AndroidElement ForgotPassword;
	
	@AndroidFindBy(xpath = "//*[@content-desc='LOGIN']")
	private AndroidElement LOGIN;
	
	@AndroidFindBy(xpath = "(//*[@class='android.view.View'])[6]")
	private AndroidElement InvaliodcredentilsError;

	public String Loginscreentitle() {
		String Logintitle = loginscreentitle.getAttribute("content-desc");
		return Logintitle;
	}

	public String getTextInvaliodcredentilsError() {
		InvaliodcredentilsError.click();
		String AlertMsg= InvaliodcredentilsError.getText();
		return AlertMsg;
		
	}
	
	public void Entercredentials(String email, String pass) throws InterruptedException {
		log.info("Welcome to Login Screen");
		  //Thread.sleep(2000);
		//landingscreenskipbutton.click();
		log.debug("Clicked on " + loginid + " user emp id element");
		Util.enterTextMethod(loginid, email);
		log.debug("Entered value: " + email + " in  element " + loginid);
		password.click();
		log.debug("Clicked on " + password + " user Mob element");
		Util.enterTextMethod(password, pass);
		log.debug("Entered value: " + pass + " in  element " + password);
		Util.mFluentWait(driver);
		log.debug("Clicked on " + LOGIN + " continue element");
		LOGIN.click();
	

	}

}
