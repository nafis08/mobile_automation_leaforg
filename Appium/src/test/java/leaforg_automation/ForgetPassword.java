package leaforg_automation;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import TestUtils.TestDataStore;

import org.testng.AssertJUnit;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.Test;

import leaforg_automation.pageObjects.android.ForgetPasswordPage;

public class ForgetPassword extends ConfigurationAppium{
	
	@Test
	public void forgetPassword() throws MalformedURLException, URISyntaxException {
		configureAppium();
		
		ForgetPasswordPage forgetPassPage = new ForgetPasswordPage(driver);
		
		forgetPassPage.clickForgetPwButton();
		forgetPassPage.clickEmailField();
		forgetPassPage.inputEmailField(TestDataStore.Email_ID);
		forgetPassPage.clickResetButton();
		Assert.assertEquals(forgetPassPage.checkResetPopUp(), "A link to reset your password has been sent");
		
	}
	
	@Test
	public void forgetPasswordWithWrongEmail() throws MalformedURLException, URISyntaxException {
		
		//Negative Test
		configureAppium();
		
		ForgetPasswordPage forgetPassPage = new ForgetPasswordPage(driver);
		
		forgetPassPage.clickForgetPwButton();
		forgetPassPage.clickEmailField();
		forgetPassPage.inputEmailField("kaputttt@gmail.com");
		forgetPassPage.clickResetButton();
		Assert.assertEquals(forgetPassPage.checkErrorPopUp(), "User does not exist");
		
	}
	
	@Test
	public void forgetPasswordWithoutEmail() throws MalformedURLException, URISyntaxException {
		
		//Negative Test
		configureAppium();
		
		ForgetPasswordPage forgetPassPage = new ForgetPasswordPage(driver);
		
		forgetPassPage.clickForgetPwButton();
		forgetPassPage.clickEmailField();
		forgetPassPage.inputEmailField("kaputttt");
		forgetPassPage.clickResetButton();
		Assert.assertFalse(forgetPassPage.checkResetButton());
		
	}

}
