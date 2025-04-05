package com.Ecommerce.TestScripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Ecommerce.GenericUtility.BaseTest;
import com.Ecommerce.GenericUtility.CustomListener;
import com.Ecommerce.objectRepository.SignInPage;
import com.Ecommerce.objectRepository.WelcomePage;


@Listeners(CustomListener.class)
public class LoginTest extends BaseTest {

	@Test(groups = "RT")
	public void login() throws InterruptedException, EncryptedDocumentException, IOException {

		String email = e.readDataFromExcel(EXCELPATH, LOGINSHEET, 1, 0);
		String password = e.readDataFromExcel(EXCELPATH, LOGINSHEET, 1, 1);

		// click on login link
		WelcomePage wp = new WelcomePage(driver);
		wp.getLoginLink().click();

		/*
		 * use hard assert
		 */
		Assert.assertEquals(driver.getTitle(), "Demo Web Shop. Login", "login page is displayed");

		// perform login operation
		SignInPage sip = new SignInPage(driver);
		sip.toLoginIntoDemo(email, password);

		// verify the user is successfully logged in or not
		Assert.assertEquals(sip.getLogoutLink().isDisplayed(), true, "login is successfull");

	}
}
