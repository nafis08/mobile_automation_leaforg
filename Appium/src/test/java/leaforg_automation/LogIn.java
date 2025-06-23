package leaforg_automation;

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
		Assert.assertEquals(loginPage.getProfileName(), "ArgamnArgamn Singh");
		Assert.assertTrue(licenseNumber.contains("M8976567"));
		Assert.assertTrue(participantID.contains("89767877"));
		
		
	}

}
