package com.Ecommerce.TestScripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Ecommerce.GenericUtility.BaseTest;
import com.Ecommerce.GenericUtility.CustomListener;
import com.Ecommerce.GenericUtility.ExcelUtility;
import com.Ecommerce.objectRepository.SignInPage;
import com.Ecommerce.objectRepository.WelcomePage;

@Listeners(CustomListener.class)
public class InvalidLoginTest extends BaseTest {

	@DataProvider(name = "invalidData1")
	public Object[][] testData() throws EncryptedDocumentException, IOException {

		return ExcelUtility.readMultipleDataFromExcel(EXCELPATH, INVALIDATA);
	}

	@Test(dataProvider = "invalidData1", groups = { "FT", "RT" })
	public void invalidLogin(String username, String password) {
		// click on loginLink
		WelcomePage wp = new WelcomePage(driver);
		wp.getLoginLink().click();

		// invalid signin
		SignInPage sip = new SignInPage(driver);
		try {
			sip.toPerformInvalidLoginIntoDemo(username, password);
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
