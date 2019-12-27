package com.qa.testbase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.qa.util.TestUtil;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class TestBasePOS {
	
	 public static WebDriver driver;
	 
	 public static Properties prop;
	 
	
	 
	
	public TestBasePOS() throws IOException
	{
	
		try
		{
			
			prop = new Properties();
			
			FileInputStream ip = new FileInputStream("C:\\Users\\subham\\eclipse-workspace\\KiposPOS\\src\\main\\java\\com\\qa\\config\\config.properties");
			
			 prop.load(ip);
			 
		} catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
	   }
		
		public static void intialization() throws InterruptedException
		{
	
		  String browserName =  prop.getProperty("browser");
		  
		   if(browserName.equals("chrome"))
		   {
			   System.setProperty("webdriver.chrome.driver", "D:\\Subham Files\\chromedriver_win32\\chromedriver.exe");
			   
			    driver = new ChromeDriver();
			    
		   }
		   
		   else
		   {
			   System.setProperty("webdriver.gecko.driver", "D:\\Subham Files\\chromedriver_win32\\chromedriver.exe");
			   
			    driver = new FirefoxDriver();
		   }
		
		     driver.manage().window().maximize();
		       
		     driver.manage().deleteAllCookies();
		         
		      driver.manage().timeouts().pageLoadTimeout(TestUtil.Page_Load_Timeout,TimeUnit.SECONDS);
		      
		      driver.manage().timeouts().pageLoadTimeout(TestUtil.Implicitly_Wait,TimeUnit.SECONDS);
		      
		       driver.get(prop.getProperty("url"));
		       
		        Thread.sleep(4000);
		
		}

}
