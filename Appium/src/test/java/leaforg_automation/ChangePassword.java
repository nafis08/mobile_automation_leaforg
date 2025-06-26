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

import org.testng.Assert;
import org.testng.annotations.Test;

import leaforg_automation.pageObjects.android.ChangePasswordPage;
import leaforg_automation.pageObjects.android.LoginPage;

public class ChangePassword extends ConfigurationAppium{
	@Test
	public void changePassword() throws MalformedURLException, URISyntaxException, InterruptedException {
		configureAppium();
		
		LoginPage appLogin = new LoginPage(driver);
		appLogin.inputLoginEmail(TestDataStore.Email_ID);
		appLogin.inputPassword("Leaf@123");
		appLogin.clickLoginButton();
		
		
		ChangePasswordPage changePassword = new ChangePasswordPage(driver);
		changePassword.clickSettingProfile();
		
		
		changePassword.clickChangePassword();
		changePassword.inputCurrentPassword("Leaf@123");  //Later will be imported from another file
		changePassword.inputNewPassword("Leaf@321");
		changePassword.inputAgainNewPassword("Leaf@321");
		changePassword.clickChangePwButton();
		Assert.assertEquals(changePassword.checkChangePwConfirmation(), "Password successfully updated");
		changePassword.clickOkButton();
		
		Thread.sleep(100);
		//RollBack to original password
		changePassword.clickChangePassword();
		changePassword.inputCurrentPassword("Leaf@321");  //Later will be imported from another file
		changePassword.inputNewPassword("Leaf@123");
		changePassword.inputAgainNewPassword("Leaf@123");
		changePassword.clickChangePwButton();
		Assert.assertEquals(changePassword.checkChangePwConfirmation(), "Password successfully updated");
		changePassword.clickOkButton();
		
	}
	
	@Test
	public void changePasswordWrongCurrentPassword() throws MalformedURLException, URISyntaxException, InterruptedException {
		
		//Negative Test Case
		configureAppium();
		
		LoginPage appLogin = new LoginPage(driver);
		appLogin.inputLoginEmail(TestDataStore.Email_ID);
		appLogin.inputPassword("Leaf@123");
		appLogin.clickLoginButton();
		
		
		ChangePasswordPage changePassword = new ChangePasswordPage(driver);
		changePassword.clickSettingProfile();
		
		
		changePassword.clickChangePassword();
		changePassword.inputCurrentPassword("Leaf@1233");  //Later will be imported from another file
		changePassword.inputNewPassword("Leaf@321");
		changePassword.inputAgainNewPassword("Leaf@321");
		changePassword.clickChangePwButton();
		Assert.assertEquals(changePassword.textErrorPopUp(), "Current password is not valid; please re-enter");
		changePassword.clickOkButton();
		
	}
	
	@Test
	public void changePasswordWithoutChange() throws MalformedURLException, URISyntaxException, InterruptedException {
		
		//Negative Test Case
		configureAppium();
		
		LoginPage appLogin = new LoginPage(driver);
		appLogin.inputLoginEmail(TestDataStore.Email_ID);
		appLogin.inputPassword(TestDataStore.PASSWORD);
		appLogin.clickLoginButton();
		
		
		ChangePasswordPage changePassword = new ChangePasswordPage(driver);
		changePassword.clickSettingProfile();
		
		
		changePassword.clickChangePassword();
		changePassword.inputCurrentPassword(TestDataStore.PASSWORD);  //Later will be imported from another file
		changePassword.inputNewPassword(TestDataStore.PASSWORD);
		changePassword.inputAgainNewPassword(TestDataStore.PASSWORD);
		changePassword.clickChangePwButton();
		Assert.assertEquals(changePassword.textErrorPopUp(), "Current and New password are same"); //Expected error popup
		
	}

}


