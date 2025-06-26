package leaforg_automation;

import org.testng.annotations.Test;

import TestUtils.TestDataStore;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.net.MalformedURLException;
import java.net.URISyntaxException;

import org.testng.Assert;
import org.testng.annotations.Test;

import leaforg_automation.pageObjects.android.ContactSupportPage;
import leaforg_automation.pageObjects.android.LoginPage;

public class ContactSupport extends ConfigurationAppium{
	@Test
	public void contactSupport() throws MalformedURLException, URISyntaxException {
		configureAppium();
		
		LoginPage appLogin = new LoginPage(driver);
		appLogin.inputLoginEmail(TestDataStore.Email_ID);
		appLogin.inputPassword(TestDataStore.PASSWORD);
		appLogin.clickLoginButton();
		
		ContactSupportPage contactSupport = new ContactSupportPage(driver);
		contactSupport.clickSettingProfile();
		contactSupport.clickContactSupportButton();
		AssertJUnit.assertTrue(contactSupport.checkSupportEmailField());
		AssertJUnit.assertTrue(contactSupport.checkEmailField());
		contactSupport.inputSubjectField("Regarding Issue");
		contactSupport.inputEmailBody("Alles Kaput");
		contactSupport.clickSendButton();
		AssertJUnit.assertEquals(contactSupport.checkConfirmationPopUp(), "Thanks for contacting us. We will be in touch shortly.");
		contactSupport.clickOkButton();
		
	}
	
	@Test
	public void contactSupportWithoutContent() throws MalformedURLException, URISyntaxException {
		configureAppium();
		
		LoginPage appLogin = new LoginPage(driver);
		appLogin.inputLoginEmail(TestDataStore.Email_ID);
		appLogin.inputPassword(TestDataStore.PASSWORD);
		appLogin.clickLoginButton();
		
		ContactSupportPage contactSupport = new ContactSupportPage(driver);
		contactSupport.clickSettingProfile();
		contactSupport.clickContactSupportButton();
		AssertJUnit.assertTrue(contactSupport.checkSupportEmailField());
		AssertJUnit.assertTrue(contactSupport.checkEmailField());
		contactSupport.inputSubjectField("Regarding Issue");
		Assert.assertFalse(contactSupport.checkSendButton());
		
	}

}






