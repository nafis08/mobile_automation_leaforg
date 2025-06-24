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
		
		loginPage.inputLoginEmail("rajkumar@testleaf.com");
		loginPage.inputPassword("Leaf@123");
		loginPage.clickLoginButton();
		
		String profileName = loginPage.getProfileName();
		String licenseNumber = loginPage.getLicenseNumber();
		String participantID = loginPage.getParticipantID();
		
		//Validation
		AssertJUnit.assertEquals(loginPage.getProfileName(), "ArgamnArgamn Singh");
		AssertJUnit.assertTrue(licenseNumber.contains("M8976567"));
		AssertJUnit.assertTrue(participantID.contains("89767877"));
		
		CommonPageElement commonPageElement = new CommonPageElement(driver);
		commonPageElement.clickSettingProfile();
		
		loginPage.clickLogoutButton();
		AssertJUnit.assertEquals(loginPage.checkLogoutConfPopUp(), "Are you sure you want to logout?");
		loginPage.clickLogoutConfirm();
		
	}

}
