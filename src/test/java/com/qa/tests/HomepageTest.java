package com.qa.tests;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.pages.Homepage;
import com.qa.pages.LoginPage;
import com.qa.pages.OpenRegisterPage;
import com.qa.testbase.TestBasePOS;
import com.qa.util.TestUtil;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class HomepageTest extends TestBasePOS {
	
	
	LoginPage loginpage;
	OpenRegisterPage openregisterpage;
	 Homepage homepage;
	 
	 static ExtentReports extent;
	 static ExtentTest extenttest;
	 
	 
	 
	 static Logger log = Logger.getLogger(HomepageTest.class);
	
	public HomepageTest() throws IOException
	{
		
		super();
	}
	
	@BeforeTest
	public void setExtent()
	{
		extent = new ExtentReports(System.getProperty("user.dir")+"/test-output/Extent.html", true);
		
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
		
		log.info("Opening the browser and entering the URL");
		intialization();
		
       loginpage = new LoginPage();
		
       
        log.info("Entering the login details");
        
		loginpage.validateLogin(prop.getProperty("email"), prop.getProperty("password"));
		 Thread.sleep(2000);
		
	
		//openregisterpage = new OpenRegisterPage();
		
		//openregisterpage.verifyOpenRegsiter();
		 Thread.sleep(3000);
		 
		 homepage= new Homepage();
		 
		
	 }
	
	@Test(priority=1, groups="HomePage")
	 public void verifyLogo()
	 {
		
		extenttest = extent.startTest("HomepageTest");
		
		log.info("Validating the kipos logo");
		boolean b =homepage.validateKiposLogo();
		 Assert.assertTrue(b);
	 }
	
	@Test(priority=2, groups="HomePage")
	 public void verifySearch() throws InterruptedException
	 {
		
		extenttest = extent.startTest("HomepageTest");
		
		log.info("Validating the search functionality");
		homepage.validateSearch();
		
	 }
	
	@Test(priority=3, groups="HomePage")
	 public void verifyProductName() throws InterruptedException
	 {
		
		extenttest = extent.startTest("HomepageTest");
		
		
		log.info("Validating the product name");
		homepage.validateSearch();
		
		String name = homepage.productName();
		
		 System.out.println(name);
		
		 Assert.assertEquals(name, "BUDDHA BOWL (MF)");
	 }
	
	@Test(priority=4, groups="HomePage")
	 public void verifyAddToCart() throws InterruptedException
	 {
		
		extenttest = extent.startTest("HomepageTest");
		
		log.info("Validating the add to cart for the products");
		homepage.addingToCart();
	 }
	
	
	@Test(priority=5, groups="HomePage")
	 public void verifyProductName1() throws InterruptedException
	 {
		
		extenttest = extent.startTest("HomepageTest");
		
		
		log.info("Verifying the product name");
		String productname1= homepage.productName1();
		
		 System.out.println(productname1);
	 }
	@Test(priority=6, groups="HomePage")
	 public void verifyAddToCart1() throws InterruptedException, IOException
	 {
		
		extenttest = extent.startTest("HomepageTest");
		
		log.info("Verifying the add to cart functionality");
		homepage.addingToCart1();
	 }
	
	
	@AfterMethod
	
	 public void tearDown(ITestResult result) throws IOException
	 {
		if(result.getStatus()==ITestResult.FAILURE)
		{
			extenttest.log(LogStatus.FAIL,"The test case failed are:"+result.getName());
			
			extenttest.log(LogStatus.FAIL,"The test case failed are:"+result.getThrowable());
			
			String screenshot = TestUtil.getScreenshot(driver, result.getName());
			
			 extenttest.log(LogStatus.FAIL,extenttest.addScreenCapture(screenshot));
		}
		
		else if(result.getStatus()==ITestResult.SKIP)
		{
			extenttest.log(LogStatus.SKIP,"The test cases skipped are:"+result.getName());
		}
		
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			extenttest.log(LogStatus.PASS,"The test cases sucessed are:"+result.getName());
		}
		
		extent.endTest(extenttest);

		driver.quit();
	 }
}
