package com.Lead.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Lead.qa.base.TestBase;
import com.google.common.collect.ImmutableMap;

import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class Util extends TestBase {

	public static long Page_load_timeout = 50;
	public static long Implicitywait = 80;

	public static String TESTDATA_SHEET_PATH = "C:\\Users\\hp\\Desktop\\New folder\\Educollab2\\EducalabMobile\\src\\main\\java\\com\\Lead\\qa\\testdata\\Leaddata.xlsx";
	
	//"/Users/HP/eclipse-workspace/Dalmia/"
	//+ "src/main/java/com/Lead/qa/testdata/Leaddata.xlsx";
	static Workbook book;
	public static Sheet sheet;

	static Connection con = null;
// Statement object
	private static Statement stmt;
// Constant for Database URL
	public static String DB_URL = prop.getProperty("DB_URL");
// Constant for Database Username
	public static String DB_USER = prop.getProperty("DB_USER");
// Constant for Database Password
	public static String DB_PASSWORD = prop.getProperty("DB_PASSWORD");
	public static String mob = prop.getProperty("mobile");
	
	
	public static void scrollup() {
		Dimension dimension = driver.manage().window().getSize();
		// int Anchor = dimension.getWidth()/2;
		int scrollStart = (int) (dimension.getHeight() * 0.2);
		int scrollEnd = (int) (dimension.getHeight() * 0.8);

		new TouchAction((PerformsTouchActions) driver).press(PointOption.point(0, scrollStart))
				.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).moveTo(PointOption.point(0, scrollEnd))
				.release().perform();
	}

	public static void scrollDown() {
		Dimension dimension = driver.manage().window().getSize();
		// int Anchor = dimension.getWidth()/2;
		int scrollStart = (int) (dimension.getHeight() * 0.8);
		int scrollEnd = (int) (dimension.getHeight() * 0.2);

		new TouchAction((PerformsTouchActions) driver).press(PointOption.point(0, scrollStart))
				.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).moveTo(PointOption.point(0, scrollEnd))
				.release().perform();
	}

	public static void scrollNClick(By listItems, String Text) {
		boolean flag = false;

		while (true) {
			for (WebElement el : driver.findElements(listItems)) {
				if (el.getText().equals(Text)) {
					el.click();
					flag = true;
					break;
				}
			}
			if (flag)
				break;
			else
				scrollDown();
		}
	}

	public static void scrollNClick(WebElement el) {
		int retry = 0;
		while (retry <= 5) {
			try {
				el.click();
				break;
			} catch (org.openqa.selenium.NoSuchElementException e) {
				scrollDown();
				retry++;
			}

		}
	}

	public static void scrollIntoView(String Text) {

		driver.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().description(\""
						+ Text + "\").instance(0))")
				.click();
	}

	
	
	public static Boolean  scrollIntoget(String Text) {

		return driver.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().description(\""
						+ Text + "\").instance(0))").isDisplayed();
				
	}
	
	
	public void listelement(String name) {

		// driver.findElement(By.xpath(''"+name+"'));

	}

	public void Selectclass(String name) {
		Select select = new Select(driver.findElement(By.xpath("+name+")));
		select.selectByVisibleText(name);

		// driver.findElement(By.xpath(''"+name+"'));
	}

	public static void enterTextMethod(MobileElement element, String inputText) {
		element.click();
		List enterText = Arrays.asList("text", inputText);
		Map<String, Object> cmd = ImmutableMap.of("command", "input", "args", enterText);
		driver.executeScript("mobile: shell", cmd);
		((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
	}

	public static Object[][] getData(String sheetName) throws InvalidFormatException {
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			System.out.println("Could not find the Excel sheet");
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (IOException e) {
			System.out.println("Could not find the Excel sheet");
			e.printStackTrace();
		}

		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
			}
		}
		return data;
	}

	/*public static void takeScreenshotAtEndOfTest(String screenshot) throws IOException {
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");

		FileUtils.copyFile(srcFile, new File(currentDir + screenshot + System.currentTimeMillis() + ".png"));

	}*/

	
	/*public static String dbconnection(String query, String get) throws ClassNotFoundException, SQLException {
		String result = "";
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Driver loaded");
		Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
		Statement smt = con.createStatement();
		ResultSet rs = smt.executeQuery(query);
		while (rs.next()) {
			result = rs.getString(get);
		}
		return result;

	}*/
	

	public static Wait<AndroidDriver> mFluentWait(AndroidDriver<AndroidElement> driver) {
		Wait<AndroidDriver> gWait = new FluentWait<AndroidDriver>(driver).withTimeout(1000, TimeUnit.SECONDS)
				.pollingEvery(100, TimeUnit.MILLISECONDS).ignoring(NoSuchElementException.class);
		return gWait;
	}

	public static String getelementattibute(String loginTitle ) {
		String Element ="";
		List<AndroidElement> list1 = driver.findElements(By.className("android.view.View"));
		//String loginTitle = "Employee ID is 10 digit long and starts with EMP";
		for (int j = 0; j < list1.size(); j++) {
			
			String elements = list1.get(j).getAttribute("content-desc");
			
			if (elements != null) {
				//System.out.println(elements);
				if (elements.equalsIgnoreCase(loginTitle)) {
					
					Element = elements;
					
				} else {
					j++;
				}
			}
		}
		return Element;
		

	}
	
}
