package com.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.testbase.TestBasePOS;

public class Homepage extends TestBasePOS {
	
	@FindBy(xpath="//h5[@class='my-0 mr-md-auto font-weight-normal']//img")
	WebElement logo;
	
	@FindBy(id="searchProductName")
	WebElement searchField;
	
	@FindBy(xpath="//h6[contains(text(),'BUDDHA BOWL (MF)')]")
	WebElement productName;
	
	@FindBy(id="posProductsImg")
	WebElement productImageLink;
	
	@FindBy(xpath="//mat-dialog-container[contains(@id,'mat-dialog-')]")
	WebElement containerId;
	
	
	@FindBy(xpath="//label[contains(text(),'Spinach')]")
	WebElement spinachOption;
    
	@FindBy(xpath="//span[contains(text(),'Add to Cart')]")
	WebElement addtoCartButton;
	
	
	@FindBy(xpath="//h6[contains(text(),'BUILD YOUR OWN BOWL (Regular)')]")
	WebElement productName1;
	
	@FindBy(xpath="//div[@class='product-list']//div[2]//div[1]//div[1]//img[1]")
	WebElement productImageLink1;
	
	@FindBy(xpath="//mat-dialog-container[contains(@id,'mat-dialog-')]")
	WebElement containerId1;
	
	
	@FindBy(xpath="//input[@id='787']")
	WebElement cauliflowerRice ;
    
	@FindBy(xpath="//span[contains(text(),'Add to Cart')]")
	WebElement addtoCartButton1;
	
	public Homepage() throws IOException
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean validateKiposLogo()
	{
		 return logo.isDisplayed();
		
	}
	
	public void validateSearch() throws InterruptedException
	{
		searchField.sendKeys("buddha");
		 Thread.sleep(4000);
	}
	
	public String productName()
	{
		 return productName.getText();
		 
	}
	
	public void addingToCart() throws InterruptedException
	{
		productImageLink.click();
		 Thread.sleep(4000);
		 
		 Actions action = new Actions(driver);
		 
		  action.moveToElement(containerId).build().perform();
		   Thread.sleep(3000);
		  
		   spinachOption.click();
		   Thread.sleep(2000);
		   
		   addtoCartButton.click();
		   Thread.sleep(3000);
		   
		  
	}
	
	
	public String productName1()
	{
		 return productName1.getText();
		 
	}
	
	public CartPage addingToCart1() throws InterruptedException, IOException
	{
		productImageLink1.click();
		 Thread.sleep(4000);
		 
		 Actions action = new Actions(driver);
		 
		  action.moveToElement(containerId1).build().perform();
		   Thread.sleep(3000);
		  
		   cauliflowerRice.click();
		   Thread.sleep(2000);
		   
		   addtoCartButton1.click();
		   Thread.sleep(3000);
		   
		   return new CartPage();
		   
	}
	
	
	
}
