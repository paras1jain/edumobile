package com.Lead.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import com.Lead.qa.util.Util;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.apache.log4j.Logger;


public class TestBase {
	public static AndroidDriver<AndroidElement> driver;
	public static Properties prop;

	//declare variable for config.properties 
    public static Properties config = new Properties();
    //declare variable for or.properties 
    public static Properties or = new Properties();
  //File input stream to read from properties file
    public static FileInputStream ip;

public static Logger log = Logger.getLogger("devpinoyLogger");

	
	public TestBase()  {
		
		try {
			prop = new Properties();
			ip = new FileInputStream("C:\\Users\\hp\\Desktop\\New folder\\Educollab2\\EducalabMobile\\src\\main\\java\\com\\Lead\\qa\\config\\confiq.properties");
			prop.load(ip);
		}
		 
		
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		try {
            
            //load the config.properties file
            config.load(ip);
            
            //application log
            log.debug("config.properties file loaded");}
		
		catch (IOException ef) {
			ef.printStackTrace();
		}
	
		//load the or.properties file
        try {
            or.load(ip);
            
            log.debug("or.properties file loaded");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	
	}
	

	public static void initialization() throws InterruptedException 
	
	{
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("AndroidDriver")) {
		
		File app= new File("./Apk/app-release.apk");
		DesiredCapabilities cap= new DesiredCapabilities();
		cap.setCapability("deviceName", prop.getProperty("deviceName"));
		cap.setCapability("platformVersion", prop.getProperty("platformVersion"));
		cap.setCapability("platformName", prop.getProperty("platformName"));
		//cap.setCapability("app", app.getAbsolutePath());
		cap.setCapability("appPackage", "tatras.educollab.qa");
		cap.setCapability("appActivity", "tatras.educollab.MainActivity");
		cap.setCapability("autoAcceptAlerts", true);
		cap.setCapability("locationServicesAuthorized", true);
		cap.setCapability("newCommandTimeout", 60);
		//cap.setCapability("automationName", "UiAutomator2");
		cap.setCapability("appWaitForLaunch", false);
		cap.setCapability("noReset", false);
		try {
		driver = new AndroidDriver(new URL(prop.getProperty("Appiumport")),cap);
		}catch(Exception e){}
		
		
		}
		log.debug(config.getProperty("browser")+ " browser invoked");
		//log.debug("Launching app "+config.getProperty("app"));
		
		
		driver.manage().timeouts().implicitlyWait(Util.Implicitywait, TimeUnit.SECONDS);
			
	}
	
	public void startServer() {
	    Runtime runtime = Runtime.getRuntime();
	    try {
	        runtime.exec("cmd.exe /c start cmd.exe /k \"appium -a 127.0.0.1 -p 4724 --session-override -dc \"{\"\"noReset\"\": \"\"false\"\"}\"\"");
	        Thread.sleep(10000);
	    } catch (IOException | InterruptedException e) {
	        e.printStackTrace();
	    }
	}

	public void stopServer() {
	    Runtime runtime = Runtime.getRuntime();
	    try {
	        runtime.exec("taskkill /F /IM node.exe");
	        runtime.exec("taskkill /F /IM cmd.exe");
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	
	
}
	
	


