package com.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.testbase.TestBasePOS;
import com.qa.util.TestUtil;

public class OpenRegisterPage extends TestBasePOS {
	

	
	@FindBy(xpath="//h6[contains(text(),'SHUBAM ORP')]")
	WebElement userName;
	
	@FindBy(xpath="//h6[contains(@class,'p-2')]")
	WebElement registerOpeningAmount;
	
	@FindBy(xpath="//div[@class='bills']//tr[1]//td[3]//input[1]")
	WebElement billsAmount1;
	
	@FindBy(xpath="//div[@class='bills']//tr[3]//td[3]//input[1]")
	WebElement billsAmount2;
	
	@FindBy(xpath="//textarea[@id='registerComments']")
	WebElement registerComments;
	
	@FindBy(xpath="//button[@class='btn kipos-inverse-btn w-50 m-3']")
	WebElement openRegisterButton;
	
	
	
	
	public OpenRegisterPage() throws IOException
	{
		PageFactory.initElements(driver,this);
	}

	
	  public String validateRegisterUserName()
	  {
		 return userName.getText();
		  
	  }
	  
	  public String validateOpeningAmount()
		 {
		   return registerOpeningAmount.getText();
		  
		 }
	  
	 public Homepage verifyOpenRegsiter() throws InterruptedException, IOException
	 {
		 billsAmount1.sendKeys("2");
		  Thread.sleep(3000);
		  
		  billsAmount2.sendKeys("3");
		   Thread.sleep(3000);
		   
		   registerOpeningAmount.getText();
		   Thread.sleep(3000);
		   
		   TestUtil.ScrollIntoView(driver, registerComments);
			 
			 registerComments.sendKeys("Okay");
			  Thread.sleep(3000);
			  
			  openRegisterButton.click();
			   
			   return new Homepage();
	  
	 }

}
