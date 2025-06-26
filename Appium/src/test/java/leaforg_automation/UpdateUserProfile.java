package leaforg_automation;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import TestUtils.TestDataStore;
import TestUtils.TestUtils;

import org.testng.AssertJUnit;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Test;

import leaforg_automation.pageObjects.android.LoginPage;
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
		
		String fristName = TestUtils.generateRandomAlphabetic();
		TestDataStore.firstName = fristName;
		updateProfile.inputFirstName(fristName);
		
		String lastName = TestUtils.generateRandomShortAlphabetic();
		TestDataStore.lastName = lastName;
		updateProfile.inputLastName(lastName);
		
		Assert.assertFalse(updateProfile.checkEmailField(), "Email field should be disabled");
		updateProfile.clearMobileNumberFiled();
		
		String phoneNum = TestUtils.RandomUSPhoneNumber();
		updateProfile.inputMobileNumber(phoneNum); //Number should be auto generated
		Assert.assertFalse(updateProfile.checkSelectedState(), "Selected state field should be disabled");
		TestUtils.selectDate(driver, TestUtils.GenerateRandomYear(2010, 2020), 14, Calendar.MAY);
		//updateProfile.clickSetButton();
		updateProfile.clickSaveChanges();
		Assert.assertEquals(updateProfile.textConfirmationPopUp(), "Your changes are submitted for review and approval.");
		updateProfile.clickOkButton();
		updateProfile.clickBackButtonn();
	}
	
	@Test
	public void updateUserProfileWithPhoneNumberOnly() throws MalformedURLException, URISyntaxException, ParseException {
		configureAppium();

		LoginPage appLogin = new LoginPage(driver);
		appLogin.inputLoginEmail("rajkumar@testleaf.com");
		appLogin.inputPassword("Leaf@123");
		appLogin.clickLoginButton();
		
		UpdateProfilePage updateProfile = new UpdateProfilePage(driver);
		
		updateProfile.clickSettingProfile();
		updateProfile.clickUserProfile();
		
		updateProfile.clearMobileNumberFiled();
		
		String phoneNum = TestUtils.RandomUSPhoneNumber();
		updateProfile.inputMobileNumber(phoneNum); //Number should be auto generated
		
		updateProfile.clickSaveChanges();
		Assert.assertEquals(updateProfile.textAltConfirmationPopUp(), "Changes saved successfully");
		updateProfile.clickOkButton();
		updateProfile.clickBackButtonn();
	}
	
	@Test
	public void updateUserProfileWithoutName() throws MalformedURLException, URISyntaxException, ParseException {
		configureAppium();

		LoginPage appLogin = new LoginPage(driver);
		appLogin.inputLoginEmail("rajkumar@testleaf.com");
		appLogin.inputPassword("Leaf@123");
		appLogin.clickLoginButton();
		
		UpdateProfilePage updateProfile = new UpdateProfilePage(driver);
		
		updateProfile.clickSettingProfile();
		updateProfile.clickUserProfile();
		
		updateProfile.clearFirstName();
		
		updateProfile.saveChangesButtonEnabled();
		Assert.assertFalse(updateProfile.saveChangesButtonEnabled());
		updateProfile.clickBackButtonn();
	}

}


