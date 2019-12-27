package com.qa.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;




public class TestUtil {
	
	public static long Page_Load_Timeout = 40;
	
	public static long Implicitly_Wait = 30;
	
	 static Xls_Reader reader;
	
	
	
	
	public static void ScrollIntoView(WebDriver driver,WebElement element)
	{
		JavascriptExecutor js= ((JavascriptExecutor)driver);
		
		 js.executeScript("arguments[0].scrollIntoView(true)", element);
		
	}
	
	
	public static ArrayList<Object[]> readExcelFile()
	{
		
		ArrayList<Object[]> myData= new ArrayList<Object[]>();
		
		
		try {
			
			reader = new Xls_Reader("C:\\Users\\subham\\eclipse-workspace\\KiposPOS\\src\\main\\java\\com\\qa\\testdata\\testdata.xlsx");
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		int rowCount = reader.getRowCount("LoginData");
		
		  System.out.println(rowCount);
		  
		   for(int rowNum=2; rowNum<=rowCount; rowNum++)
		   {
			  String email=  reader.getCellData("LoginData", "Email", rowNum);
			   System.out.println(email);
			   
			   String password=  reader.getCellData("LoginData", "Password", rowNum);
			   System.out.println(password);
		  
		 
		   Object ob[]= {email, password};
		   
		   myData.add(ob);
		   }
		   
		   return myData;
	}
	
	
	public static String getScreenshot(WebDriver driver, String screenshotName) throws IOException
	{
		
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		TakesScreenshot ts = ((TakesScreenshot)driver);
		
		File src= ts.getScreenshotAs(OutputType.FILE);
		
		 String destination = System.getProperty("user.dir") +"/FailedScreenshots"+ screenshotName + dateName + ".png";
		 
		  File finalDestination = new File(destination);
		  
		  FileUtils.copyFile(src, finalDestination);
		  
		  return destination;
		
	}
	
}
