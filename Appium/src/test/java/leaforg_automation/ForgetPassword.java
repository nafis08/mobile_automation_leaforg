package leaforg_automation;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.net.MalformedURLException;
import java.net.URISyntaxException;

import org.testng.Assert;
import org.testng.annotations.Test;

import leaforg_automation.pageObjects.android.ForgetPasswordPage;
import leaforg_automation.pageObjects.android.TestDataStore;

public class ForgetPassword extends ConfigurationAppium{
	
	@Test
	public void forgetPassword() throws MalformedURLException, URISyntaxException {
		configureAppium();
		
		ForgetPasswordPage forgetPassPage = new ForgetPasswordPage(driver);
		
		forgetPassPage.clickForgetPwButton();
		forgetPassPage.clickEmailField();
		forgetPassPage.inputEmailField(TestDataStore.Email_ID);
		forgetPassPage.clickResetButton();
		AssertJUnit.assertEquals(forgetPassPage.checkResetPopUp(), "A link to reset your password has been sent");
		
	}

}
