package com.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.testbase.TestBasePOS;
import com.qa.util.TestUtil;

public class CartPage extends TestBasePOS {

	@FindBy(xpath="//h5[@class='m-0']")
	WebElement cartDetails;
	
	@FindBy(xpath="//div[contains(@class,'card')]//div[1]//div[2]//div[1]//div[1]//span[2]//button[1]//span[1]")
	WebElement increaseValue;
	
	@FindBy(xpath="//div[contains(@class,'card')]//div[1]//div[2]//div[1]//div[1]//input[1]")
	WebElement productQuantity;
	
	@FindBy(xpath="//b[contains(text(),'SG$')]")
	WebElement productValue;
	
	@FindBy(xpath="//span[contains(text(),'BUILD YOUR OWN BOWL (Regular)')]")
	WebElement secondProduct;
	
	@FindBy(xpath="//div[contains(@class,'all-cart-detail ng-star-inserted')]//div[2]//div[1]//div[1]//div[1]//p[1]")
	WebElement removeItem;
	
	
	 public CartPage() throws IOException
	 {
		 PageFactory.initElements(driver, this);
	 }
	 
	 public String validateCartDetails()
	 {
		  return cartDetails.getText();
		 
	 }
	   
	  public void validateIncreaseButton()
	  {
		  increaseValue.click();
	  }
	  
	  public String validateProductQuantity()
	  {
		   return productQuantity.getText();
	  }
	 
	  public String validateProductValue()
	  {
		   return productValue.getText();
	  }
	  
	  public String validateSecondProductName() throws InterruptedException
	  {
		  TestUtil.ScrollIntoView(driver,secondProduct );
		  
		 String name=  secondProduct.getText();
		  Thread.sleep(3000);
		  
		   System.out.println(name);
		  
		   removeItem.click();
		   
		   
		    return cartDetails.getText();
		  
	  }
}

