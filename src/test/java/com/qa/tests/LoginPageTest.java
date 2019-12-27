package com.qa.tests;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.pages.LoginPage;
import com.qa.testbase.TestBasePOS;
import com.qa.util.TestUtil;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class LoginPageTest extends TestBasePOS {
	
	LoginPage loginpage;
	
	 public static ExtentReports extent;
	 
	  public static ExtentTest extenttest;
	
	
	static Logger log = Logger.getLogger(LoginPageTest.class);
	
	public LoginPageTest() throws IOException
	{
		super();
		
	}
	
	
	@BeforeTest
	 public void setExtent()
	 
	 {
		extent = new ExtentReports(System.getProperty("user.dir")+"/test-output/Extent.html",true);
		
		extent.addSystemInfo("Username","subham");
		 
		extent.addSystemInfo("OS","Windows7");
		 
		extent.addSystemInfo("Java Version","1.8.0_181");
		 
		extent.addSystemInfo("Username","subham");
		 
		 
	 }
	
	@AfterTest
	 public void closeExtent()
	 {
		extent.flush();
		
		  extent.close();
	 }
	
	@BeforeMethod
	 public void setUp() throws InterruptedException, IOException
	 {
		
		log.info("Opening the browser");
		intialization();
		
		
		log.info("Creating an instance of login page");
		loginpage= new LoginPage();
		
	 }
	
	@Test(priority=1, groups="LoginPage")
	 public void verifyLogo()
	 {
		
		extenttest= extent.startTest("LoginPageTest");
		
		log.info("Validating kipos logo");
       boolean logo = loginpage.validatePosLogo();
       
         Assert.assertTrue(logo);
	 }
	
	@Test(priority=2, groups="LoginPage")
	 public void verifyLoginText()
	 {
		
		extenttest= extent.startTest("LoginPageTest");
		
		log.info("Validating kipos login text");
		
		String text = loginpage.validatePosLoginText();
		
		 Assert.assertEquals(text, "POS LOGIN");
		
	 }

	
	  @DataProvider 
	   public static Iterator<Object[]> getData()
	   {
		   
		   log.info("Reading the value from the excel sheet");
		 ArrayList<Object[]> data= TestUtil.readExcelFile();
		 
		     return data.iterator();
	   }
	
	 @Test(priority=3, groups="LoginPage", invocationCount= 2, dataProvider= "getData")
	 public void verifyLogin(String email, String password) throws InterruptedException, IOException
	 {
		 
		 extenttest= extent.startTest("LoginPageTest");
		 
		 //loginpage.validateLogin(prop.getProperty("email"), prop.getProperty("password"));
		 log.info("Logging into the application");
		 
		 loginpage.validateLogin(email, password);
	 }
	 
	 
	 @Test(priority=4, groups="LoginPage", dependsOnMethods="verifyLogin")
	 public void VerifyHomePage() throws InterruptedException, IOException
	 {
		 
		 extenttest= extent.startTest("LoginPageTest");
		 
	   String name = loginpage.verifyUserName();
	   
	    System.out.println(name);
	 } 
	 
	 
	 @AfterMethod
	  public void tearDown(ITestResult result) throws IOException
	  {
		 
		 if(result.getStatus()==ITestResult.FAILURE)
		 {
			 extenttest.log(LogStatus.FAIL, "Test case Failed is :"+result.getName());
			 
			 extenttest.log(LogStatus.FAIL, "Test case Failed is :"+result.getThrowable());
			 
			 String screenshotPath = TestUtil.getScreenshot(driver,result.getName());
			 
			  extenttest.log(LogStatus.FAIL, extenttest.addScreenCapture(screenshotPath));
			 
		 }
		 
		 else if(result.getStatus()==ITestResult.SKIP)
		 {
			 extenttest.log(LogStatus.SKIP, "Test case which are skipped are:"+result.getName());
		 }
		 
		 else if(result.getStatus()==ITestResult.SUCCESS)
		 {
			 extenttest.log(LogStatus.PASS, "Test case which are passed are:"+result.getName());
		 }
		 
		 extent.endTest(extenttest);
		 
		 log.info("Closing the browser");
		 
		 driver.quit();
		 
	  }
}
