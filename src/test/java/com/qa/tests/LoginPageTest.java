package com.qa.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.pages.LoginPage;
import com.qa.testbase.TestBasePOS;

public class LoginPageTest extends TestBasePOS {
	
	LoginPage loginpage;
	
	public LoginPageTest() throws IOException
	{
		super();
		
	}
	
	
	@BeforeMethod
	 public void setUp() throws InterruptedException, IOException
	 {
		intialization();
		
		loginpage= new LoginPage();
		
	 }
	
	@Test(priority=1, groups="LoginPage")
	 public void verifyLogo()
	 {
       boolean logo = loginpage.validatePosLogo();
       
         Assert.assertTrue(logo);
	 }
	
	@Test(priority=2, groups="LoginPage")
	 public void verifyLoginText()
	 {
		String text = loginpage.validatePosLoginText();
		
		 Assert.assertEquals(text, "POS LOGIN");
		
	 }

	
	 @Test(priority=3, groups="LoginPage", invocationCount= 2)
	 public void verifyLogin() throws InterruptedException, IOException
	 {
		 loginpage.validateLogin(prop.getProperty("email"), prop.getProperty("password"));
	 }
	 
	 
	 @AfterMethod
	  public void tearDown()
	  {
		 driver.quit();
		 
	  }
}
