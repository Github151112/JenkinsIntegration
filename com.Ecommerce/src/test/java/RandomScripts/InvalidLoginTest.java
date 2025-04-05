package RandomScripts;

import org.openqa.selenium.StaleElementReferenceException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Ecommerce.GenericUtility.BaseTest;
import com.Ecommerce.objectRepository.SignInPage;
import com.Ecommerce.objectRepository.WelcomePage;

public class InvalidLoginTest extends BaseTest {

	@DataProvider(name = "invalidData")
	public Object[][] testData() {
		Object[][] data = new Object[3][2];

		data[0][0] = "jsdbchj@gmail.com";
		data[0][1] = "sjdb";

		data[1][0] = "jsdbcjdnshj@gmail.com";
		data[1][1] = "sjdbdsjvn";

		data[2][0] = "jsdbcdnvhj@gmail.com";
		data[2][1] = "sjdbjwefb";

		return data;
	}

	@Test(dataProvider = "invalidData")
	public void invalidLogin(String username, String password) {
		// click on loginLink
		WelcomePage wp = new WelcomePage(driver);
		wp.getLoginLink().click();

		// invalid signin
		SignInPage sip = new SignInPage(driver);
		try {
		sip.toPerformInvalidLoginIntoDemo(username, password);
		}
		catch (Exception e) {
			// TODO: handle exception
		}

	}

}
