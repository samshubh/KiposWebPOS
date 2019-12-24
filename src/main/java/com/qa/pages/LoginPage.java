package com.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.testbase.TestBasePOS;

public class LoginPage extends TestBasePOS {
	
	
	 @FindBy(xpath="//img[@class='text-center']")
	 WebElement posLogo;
	
	 @FindBy(xpath="//h3[@class='text-center pt-3']")
	 WebElement posLoginText;
	 
	 @FindBy(id="emailId")
	 WebElement emailId;
	 
	 @FindBy(id="password")
	 WebElement loginPassword;
	 
	 @FindBy(xpath="//span[contains(text(),'Login')]")
	 WebElement loginButton;
	 
	 
	 public LoginPage() throws IOException
	 {
		 PageFactory.initElements(driver, this);
	 }
	 
	 
	 public boolean validatePosLogo()
	 {
		  return posLogo.isDisplayed();
	 }

	 public String validatePosLoginText()
	 {
		  return posLoginText.getText();
	 }
	 
	 public OpenRegisterPage validateLogin(String email, String password) throws InterruptedException, IOException
	 {
		 
		 emailId.sendKeys(email);
		  Thread.sleep(3000);
		  
		  loginPassword.sendKeys(password);
		  Thread.sleep(3000);
		  
		  loginButton.click();
		  Thread.sleep(4000);
		 
		  return new OpenRegisterPage();
	 }
}
