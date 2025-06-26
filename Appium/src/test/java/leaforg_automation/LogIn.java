package leaforg_automation;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import TestUtils.TestDataStore;

import org.testng.AssertJUnit;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import leaforg_automation.pageObjects.android.CommonPageElement;
import leaforg_automation.pageObjects.android.LoginPage;


public class LogIn extends ConfigurationAppium{
	
	/**
	 * Appium test.
	 *
	 * @throws MalformedURLException the malformed URL exception
	 * @throws URISyntaxException the URI syntax exception
	 * @throws InterruptedException the interrupted exception
	 */
	@Test
	public void loginTest() throws MalformedURLException, URISyntaxException, InterruptedException {
		
		configureAppium();
		LoginPage loginPage = new LoginPage(driver);
		
		loginPage.inputLoginEmail(TestDataStore.Email_ID);
		loginPage.inputPassword(TestDataStore.PASSWORD);
		loginPage.clickLoginButton();
		
		
		//Validation
		//To be enabled after xpath issue is fixed
		/*
		String firstName = TestDataStore.firstName;
		String lastName = TestDataStore.lastName;
		WebElement profileNameElement = loginPage.getProfileNameElement(firstName, lastName);
		String actualName = profileNameElement.getText();
		Assert.assertEquals(actualName, TestDataStore.firstName+ " " +TestDataStore.lastName);
		
		String licenseNum = TestDataStore.licenseNum;
		WebElement licenseNumElement = loginPage.getLicenseNumElement(licenseNum);
		String actualLicenseNum = licenseNumElement.getText();
		Assert.assertEquals(actualLicenseNum, TestDataStore.licenseNum);;
		
		String participantID = TestDataStore.participantID;
		WebElement partIdElement = loginPage.getParticipantIDElement(participantID);
		String actualParticipantID = partIdElement.getText();
		AssertJUnit.assertEquals(actualParticipantID, TestDataStore.participantID);
		*/
		CommonPageElement commonPageElement = new CommonPageElement(driver);
		commonPageElement.clickSettingProfile();
		
		loginPage.clickLogoutButton();
		AssertJUnit.assertEquals(loginPage.checkLogoutConfPopUp(), "Are you sure you want to logout?");
		loginPage.clickLogoutConfirm();
		
	}
	
	@Test
	public void loginWithoudEmailPassword() throws MalformedURLException, URISyntaxException, InterruptedException {
		
		configureAppium();
		LoginPage loginPage = new LoginPage(driver);
		
		loginPage.clickLoginButton();
		
		Assert.assertEquals(loginPage.checkEmailWarning(), "Field Required");
		Assert.assertEquals(loginPage.checkPasswordWarning(), "Field Required");
		
	}
	
	@Test
	public void loginWithWrongEmailPassword() throws MalformedURLException, URISyntaxException, InterruptedException {
		
		configureAppium();
		LoginPage loginPage = new LoginPage(driver);
		
		loginPage.inputLoginEmail(TestDataStore.Email_ID);
		loginPage.inputPassword("Leaf@1233");
		loginPage.clickLoginButton();
		
		Assert.assertEquals(loginPage.checkWrongPasswordMsg(), "Given password doesn't match");
		loginPage.clickBackButton();
		
		loginPage.inputLoginEmail("Kaput@gmail.com");
		loginPage.inputPassword("Kaput@123");
		loginPage.clickLoginButton();
		
		Assert.assertEquals(loginPage.checkWrongEmail(), "User does not exist");
		loginPage.clickBackButton();
	}
	

}
