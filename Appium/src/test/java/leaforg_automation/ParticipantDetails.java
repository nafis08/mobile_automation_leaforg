package leaforg_automation;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.util.Calendar;


import org.testng.Assert;
import org.testng.annotations.Test;

import leaforg_automation.pageObjects.android.TestUtils;
import leaforg_automation.pageObjects.android.LoginPage;
import leaforg_automation.pageObjects.android.ParticipantPage;
import leaforg_automation.pageObjects.android.TestDataStore;

public class ParticipantDetails extends ConfigurationAppium{
	@Test
	public void participantDetailsUpdate() throws MalformedURLException, URISyntaxException, ParseException {
		configureAppium();
		
		LoginPage appLogin = new LoginPage(driver);
		appLogin.inputLoginEmail("rajkumar@testleaf.com");
		appLogin.inputPassword("Leaf@123");
		appLogin.clickLoginButton();
		
		ParticipantPage participantDetail = new ParticipantPage(driver);
		participantDetail.clickSettingProfile();
		participantDetail.clickParticipantDetails();
		AssertJUnit.assertEquals(participantDetail.checkParticipantInfo(), "Edit Participant Info");
		
		String participantID = TestUtils.RandomNumericString(8);
		participantDetail.inputParticipantID(participantID);   //Needs to be auto generated
		TestUtils.selectDate(driver, TestUtils.GenerateRandomYear(2036, 2070), 14, Calendar.APRIL);
		
		String randomString = TestUtils.generateRandomAlphabetic();
		participantDetail.inputMentorName(randomString);
		
		String randomShortStringSec = TestUtils.generateRandomShortAlphabetic();
		participantDetail.inputGroupName(randomShortStringSec);
		
		String licenseNum = TestUtils.RandomAlphaNumericId();
		TestDataStore.licenseNum = licenseNum;
		participantDetail.inputdriverLicense(licenseNum);
		TestUtils.selectDate(driver, TestUtils.GenerateRandomYear(2015, 2025), 14, Calendar.JULY);
		participantDetail.clickSaveButton();
		participantDetail.clickBackButtonn();
		
		//Assertion will be added
		
		
	}

}

