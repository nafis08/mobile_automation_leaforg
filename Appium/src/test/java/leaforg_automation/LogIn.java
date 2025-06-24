package leaforg_automation;

import org.testng.annotations.Test;
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
import leaforg_automation.pageObjects.android.TestDataStore;


public class LogIn extends ConfigurationAppium{
	
	/**
	 * Appium test.
	 *
	 * @throws MalformedURLException the malformed URL exception
	 * @throws URISyntaxException the URI syntax exception
	 * @throws InterruptedException the interrupted exception
	 */
	@Test
	public void AppiumTest() throws MalformedURLException, URISyntaxException, InterruptedException {
		
		configureAppium();
		LoginPage loginPage = new LoginPage(driver);
		
		loginPage.inputLoginEmail(TestDataStore.Email_ID);
		loginPage.inputPassword("Leaf@123");
		loginPage.clickLoginButton();
		
		
		//Validation
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
		Assert.assertEquals(loginPage.checkLogoutConfPopUp(), "Are you sure you want to logout?");
		loginPage.clickLogoutConfirm();
		
	}

}
