package com.qa.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.pages.LoginPage;
import com.qa.pages.OpenRegisterPage;
import com.qa.testbase.TestBasePOS;

public class OpenRegisterPageTest extends TestBasePOS {
	
	LoginPage loginpage;
	OpenRegisterPage openregisterpage;
	
	
	public OpenRegisterPageTest() throws IOException
	{
		super();
		
	}

	@BeforeMethod
	 public void setUp() throws InterruptedException, IOException
	 {
		intialization();
		
		loginpage = new LoginPage();
		
		loginpage.validateLogin(prop.getProperty("email"), prop.getProperty("password"));
		
		openregisterpage = new OpenRegisterPage();
		
	 }
	
	
	 @Test(priority=1, groups="OpenRegister")
	  public void verifyOpenUserName()
	  {
		String name= openregisterpage.validateRegisterUserName();
		 
           System.out.println(name);
		  
		  Assert.assertEquals(name, "SHUBAM ORP");
		
	  }
	 
	 @Test(priority=2, groups="OpenRegister")
	 public void verifyOpeningAmount()
	 {
		String amount=  openregisterpage.validateOpeningAmount();
		
		 System.out.println(amount);
		 
	 }
	 
	 @Test(priority=3, groups="OpenRegister")
	 public void verifyOpenRegister() throws InterruptedException, IOException
	 {
	       openregisterpage.verifyOpenRegsiter();
		 
	 }
	 
	
	 @AfterMethod
	  public void tearDown()
	  {
		 driver.quit();
	  }
}
