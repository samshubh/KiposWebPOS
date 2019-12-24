package com.qa.util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestUtil {
	
	
	public static long Page_Load_Timeout = 40;
	
	public static long Implicitly_Wait = 30;
	
	
	
	public static void ScrollIntoView(WebDriver driver,WebElement element)
	{
		JavascriptExecutor js= ((JavascriptExecutor)driver);
		
		 js.executeScript("arguments[0].scrollIntoView(true)", element);
		
	}
	
	
}
