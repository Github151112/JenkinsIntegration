package com.Ecommerce.GenericUtility;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.WebDriver;

public class DataUtility {
	
	/*
	 * this method will maximize the browser
	 */
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	/*
	 * implicit wait
	 */
	public void implicitWait(WebDriver driver,int seconds)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
	}
	
	/*
	 * launch the url
	 */
	public void launchApplication(WebDriver driver,String url)
	{
		driver.get(url);
	}
	
	/*
	 * random email
	 */
	
	public String generateRandomEmail()
	{
		Random r = new Random();
		int no = r.nextInt(10000);
		String email = "deepak" +no +"@gmail.com";
		return email;
	}
	
	

}
