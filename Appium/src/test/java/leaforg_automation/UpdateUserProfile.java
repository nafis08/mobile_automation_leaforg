package leaforg_automation;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Test;

import leaforg_automation.pageObjects.android.LoginPage;
import leaforg_automation.pageObjects.android.TestUtils;
import leaforg_automation.pageObjects.android.UpdateProfilePage;


public class UpdateUserProfile extends ConfigurationAppium {

	@Test
	public void updateUserProfile() throws MalformedURLException, URISyntaxException, ParseException {
		configureAppium();

		LoginPage appLogin = new LoginPage(driver);
		appLogin.inputLoginEmail("rajkumar@testleaf.com");
		appLogin.inputPassword("Leaf@123");
		appLogin.clickLoginButton();
		
		UpdateProfilePage updateProfile = new UpdateProfilePage(driver);
		
		updateProfile.clickSettingProfile();
		updateProfile.clickUserProfile();
		
		String randomString = TestUtils.generateRandomAlphabetic();
		updateProfile.inputFirstName(randomString);
		
		String randomShortString = TestUtils.generateRandomShortAlphabetic();
		updateProfile.inputLastName(randomShortString);
		
		Assert.assertFalse(updateProfile.checkEmailField(), "Email field should be disabled");
		updateProfile.clearMobileNumberFiled();
		updateProfile.inputMobileNumber("888-999-4567"); //Number should be auto generated
		Assert.assertFalse(updateProfile.checkSelectedState(), "Selected state field should be disabled");
		TestUtils.selectDate(driver, "2011", 14, Calendar.MAY);
		updateProfile.clickSetButton();
		updateProfile.clickSaveChanges();
		AssertJUnit.assertEquals(updateProfile.textConfirmationPopUp(), "Your changes are submitted for review and approval.");
		updateProfile.clickOkButton();
		updateProfile.clickBackButtonn();
	}

}


