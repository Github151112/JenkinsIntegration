package com.Ecommerce.TestScripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Ecommerce.GenericUtility.BaseTest;
import com.Ecommerce.objectRepository.RegisterPage;
import com.Ecommerce.objectRepository.WelcomePage;

public class RegisterTest extends BaseTest {

	@Test(groups = "ST")
	public void register() throws InterruptedException, EncryptedDocumentException, IOException {

		String firstName = e.readDataFromExcel(EXCELPATH, REGISTERSHEET, 1, 0);
		String lastName = e.readDataFromExcel(EXCELPATH, REGISTERSHEET, 1, 1);
		String password = e.readDataFromExcel(EXCELPATH, REGISTERSHEET, 1, 2);

		// Step 1: click on register link
		WelcomePage wp = new WelcomePage(driver);
		wp.getRegisterLink().click();

		/*
		 * use soft assert
		 */
		SoftAssert s = new SoftAssert();
		s.assertEquals(driver.getTitle(), "Demo Web Shop. Register");

		// Step 2: registration
		RegisterPage rp = new RegisterPage(driver);
		rp.toRegister(firstName, lastName, d.generateRandomEmail(), password);

		s.assertAll();

	}

}
