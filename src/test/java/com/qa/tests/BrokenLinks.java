package com.qa.tests;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.qa.util.TestUtil;

public class BrokenLinks {

	public static WebDriver driver;

	public static void main(String args[]) throws InterruptedException, MalformedURLException, IOException

	{
		// Setting the system property

		System.setProperty("webdriver.chrome.driver", "D:\\Subham Files\\chromedriver_win32\\chromedriver.exe");

		// Creating an instance of ChromeDriver class

		driver = new ChromeDriver();

		// Maximizing the browser
		driver.manage().window().maximize();

		// Deleting all the cookies
		driver.manage().deleteAllCookies();

		// Giving the page load timeout
		driver.manage().timeouts().pageLoadTimeout(TestUtil.Page_Load_Timeout, TimeUnit.SECONDS);

		// Giving the implicitly wait
		driver.manage().timeouts().implicitlyWait(TestUtil.Implicitly_Wait, TimeUnit.SECONDS);

		// Entering the url for kipos pos
		driver.get("https://www.facebook.com/");

		Thread.sleep(4000);
		
		// First we need to find the no of links
		List<WebElement> linkCount = driver.findElements(By.tagName("a"));
		
		// Then we have to add the images links to the linkCount variable 
		 linkCount.addAll(driver.findElements(By.tagName("img")));
		 
		   //Printing the total count of the links and images
		 
		     System.out.println(linkCount.size());
		 
		     // Now we are storing only the active links in new array list 
		 List<WebElement>activeLinks = new ArrayList<WebElement>();
		  
		 
		 for(int i=0;i<linkCount.size();i++)
		 {
			 System.out.println(linkCount.get(i).getAttribute("href"));
			 
			 if(linkCount.get(i).getAttribute("href")!= null && (!linkCount.get(i).getAttribute("href").contains("javascript")))
			 {
				 activeLinks.add(linkCount.get(i)); 
			 }
		 }
		
		 
		 // Now here we are displaying only the active links
           System.out.println(activeLinks.size());
         
           
           //Now here establishing the Url connection to get the response message
           for(int j=1;j<activeLinks.size();j++)
           {
        	   HttpURLConnection connection =  (HttpURLConnection) new URL(activeLinks.get(j).getAttribute("href")).openConnection();
        	   
        	    connection.connect();
        	    
        	      String responseMessage = connection.getResponseMessage();
        	      
        	        System.out.println(activeLinks.get(j).getAttribute("href")+"----->"+responseMessage);
        	        
        	         connection.disconnect();
           }
	}
}
