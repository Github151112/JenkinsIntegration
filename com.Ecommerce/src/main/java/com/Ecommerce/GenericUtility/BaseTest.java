package com.Ecommerce.GenericUtility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

/**
 * @author aman
 */
public class BaseTest implements IAutoConstant {

	public FileUtility f = new FileUtility();
	public DataUtility d = new DataUtility();
	public ExcelUtility e = new ExcelUtility();
	public static WebDriver driver;

	@BeforeSuite(alwaysRun = true)
	public void toConnectServer() {
		Reporter.log("==server connected successfully==", true);
	}

	@BeforeTest(alwaysRun = true)
	public void toConnectDatabase() {
		Reporter.log("==database connected successfully", true);
	}

	/*
	 * this method will take care of launching the browser and application
	 */
	@Parameters("browser")
	@BeforeClass(alwaysRun = true)
	public void setUp(@Optional("chrome") String browser) throws IOException {
		// String browser = f.getDataFromProperty(PROPERTYPATH, "browser");
		String url = f.getDataFromProperty(PROPERTYPATH, "url");
		Reporter.log("==launching " + browser + " browser==", true);
		if (browser.equalsIgnoreCase("chrome"))
			driver = new ChromeDriver();
		else if (browser.equalsIgnoreCase("firefox"))
			driver = new FirefoxDriver();
		else if (browser.equalsIgnoreCase("edge"))
			driver = new EdgeDriver();
		else
			Reporter.log("==invalid browser==", true);
		d.maximizeWindow(driver);
		d.implicitWait(driver, 20);
		d.launchApplication(driver, url);

	}

	@AfterClass(alwaysRun = true)
	public void tearDown() {
		driver.quit();
		Reporter.log("==browser closed successfully==", true);
	}

	@AfterTest(alwaysRun = true)
	public void toCloseDatabase() {
		Reporter.log("==database closed successfully", true);
	}

	@AfterSuite(alwaysRun = true)
	public void toCloseServer() {
		Reporter.log("==server close successfully==", true);
	}

}
