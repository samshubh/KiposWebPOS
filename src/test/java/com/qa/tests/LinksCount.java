package com.qa.tests;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.qa.util.TestUtil;

public class LinksCount {
	
	public  static WebDriver driver;
	
	public static void main(String args[]) throws InterruptedException
	
	{
		// Setting the system property
		
		  System.setProperty("webdriver.chrome.driver","D:\\Subham Files\\chromedriver_win32\\chromedriver.exe");
		  
		    // Creating an instance of ChromeDriver class
		     
		     driver =  new ChromeDriver();
		     
		     // Maximizing the browser
		      driver.manage().window().maximize();
		      
		      //Deleting all the cookies
		      driver.manage().deleteAllCookies();
		      
		      
		      //Giving the page load timeout 
		      driver.manage().timeouts().pageLoadTimeout(TestUtil.Page_Load_Timeout, TimeUnit.SECONDS);
		      
		      
		      // Giving the implicitly wait 
		      driver.manage().timeouts().implicitlyWait(TestUtil.Implicitly_Wait,TimeUnit.SECONDS);
		   
		      //Entering the url for kipos pos
		      driver.get("https://www.facebook.com/");
		      
		       Thread.sleep(4000);
		   
		       
		       // Now get the total links count
		       
		       List<WebElement>  linksCount = driver.findElements(By.tagName("a"));
		       
		         System.out.println(linksCount.size());
		         
		        //Now to the print links text in console
		         
		         for(int i=0; i<linksCount.size();i++)
		         {
		        	 String linksName = linksCount.get(i).getText();
                       System.out.println(linksName);		        	 
		         }
		       
		
	}
}
