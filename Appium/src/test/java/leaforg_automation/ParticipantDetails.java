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
		participantDetail.inputParticipantID("37394728");   //Needs to be auto generated
		TestUtils.selectDate(driver, "2036", 14, Calendar.APRIL);
		
		String randomString = TestUtils.generateRandomAlphabetic();
		participantDetail.inputMentorName(randomString);
		
		String randomShortStringSec = TestUtils.generateRandomShortAlphabetic();
		participantDetail.inputGroupName(randomShortStringSec);
		
		participantDetail.inputdriverLicense("M94058334");
		TestUtils.selectDate(driver, "2025", 14, Calendar.JULY);
		participantDetail.clickSaveButton();
		participantDetail.clickBackButtonn();
		
		//Assertion will be added
		
		
	}

}

