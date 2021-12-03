package DBATestcases;

import java.sql.SQLException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.log4testng.Logger;

import com.Lead.qa.base.TestBase;

import com.Lead.qa.pages.HomePage;
import com.Lead.qa.pages.LandingPage;
import com.Lead.qa.pages.LoginPage;

import com.Lead.qa.util.Util;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

@Listeners(com.qa.ExtentReportListener.ExtentReportGenerater.class)
public class LoginTestcase extends TestBase {
	LoginPage loginpage;
	HomePage homepage;
	LandingPage landingPage;
	SoftAssert softAssertion;
	String sheetName = "LoginPositive";
	String sheetName2 = "LoginInvalid";
	String otppageatibute = " ";
	String Alertmsg ="";
	String user =config.getProperty("email");
	String pass =config.getProperty("pass");
	
	public LoginTestcase() {
		super();
	}
	
	@DataProvider
	public Object[][] getTestData() throws InvalidFormatException {
		Object data[][] = Util.getData(sheetName);
		return data;

	}
	@DataProvider
	public Object[][] getTestData2() throws InvalidFormatException {
		Object data[][] = Util.getData(sheetName2);
		return data;

	}

	Logger log = Logger.getLogger(LoginTestcase.class);

	@BeforeMethod
	public void setup() throws InterruptedException {
		//startServer();
		initialization();
		Util.mFluentWait(driver);
		loginpage = new LoginPage(driver);
		landingPage= new LandingPage(driver);
		homepage = new HomePage();
		
		
	}

	@Test(priority = 2,dataProvider = "getTestData")
	public void LoginValid(String Em,String Mo)  throws InterruptedException, ClassNotFoundException, SQLException {
		//String logintitle = Util.getelementattibute(loginpageatibute);
		//softAssertion= new SoftAssert();
		//softAssertion.assertEquals(logintitle, loginpageatibute);
		loginpage=	landingPage.Landingskip();
		 loginpage.Entercredentials(user,pass);
	//	homepage.isDisplayed();
		log.info("Successfully Login");

		/*System.out.println("Welcom to Home screen");
		String homepageatibute = "Swipe to start your day ";
		String hometitle = Util.getelementattibute(homepageatibute);
		softAssertion= new SoftAssert();
		softAssertion.assertEquals(hometitle, homepageatibute);
*/
	}
	
	//@Test(priority = 1,dataProvider = "getTestData2")
	public void InvalidLogin (String Empid,String Mobile)  throws InterruptedException, ClassNotFoundException, SQLException {
		/*
		 loginpage=	landingPage.Landingskip();
		loginpage.Entercredentials(Empid,Mobile);
		String  er= loginpage.getTextInvaliodcredentilsError();
		String alertmsg = Util.getelementattibute(Alertmsg);
		softAssertion.assertEquals(alertmsg, Alertmsg);
		softAssertion.assertEquals(er, Alertmsg);
		loginpage.clickOk();
*/
	}

	@AfterMethod
	public void tearDown() {
	//driver.quit();

	}

}
