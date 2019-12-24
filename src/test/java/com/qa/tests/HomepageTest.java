package com.qa.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.pages.Homepage;
import com.qa.pages.LoginPage;
import com.qa.pages.OpenRegisterPage;
import com.qa.testbase.TestBasePOS;

public class HomepageTest extends TestBasePOS {
	
	
	LoginPage loginpage;
	OpenRegisterPage openregisterpage;
	 Homepage homepage;
	 
	
	public HomepageTest() throws IOException
	{
		super();
	}

	
	@BeforeMethod
	 public void setUp() throws InterruptedException, IOException
	 {
		intialization();
		
       loginpage = new LoginPage();
		
		loginpage.validateLogin(prop.getProperty("email"), prop.getProperty("password"));
		 Thread.sleep(2000);
		
		//openregisterpage = new OpenRegisterPage();
		
		//openregisterpage.verifyOpenRegsiter();
		 //Thread.sleep(3000);
		 
		 homepage= new Homepage();
		 
		
	 }
	
	@Test(priority=1, groups="HomePage")
	 public void verifyLogo()
	 {
		boolean b =homepage.validateKiposLogo();
		 Assert.assertTrue(b);
	 }
	
	@Test(priority=2, groups="HomePage")
	 public void verifySearch() throws InterruptedException
	 {
		homepage.validateSearch();
		
	 }
	
	@Test(priority=3, groups="HomePage")
	 public void verifyProductName() throws InterruptedException
	 {
		
		homepage.validateSearch();
		
		String name = homepage.productName();
		
		 Assert.assertEquals(name, "BUDDHA BOWL (MF)");
	 }
	
	@Test(priority=4, groups="HomePage")
	 public void verifyAddToCart() throws InterruptedException
	 {
		homepage.addingToCart();
	 }
	
	@AfterMethod
	
	 public void tearDown()
	 {
		driver.quit();
	 }
}
