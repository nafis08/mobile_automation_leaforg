package leaforg_automation;

import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.util.Calendar;

import org.testng.annotations.Test;

import leaforg_automation.pageObjects.android.RegistrationPage;
import leaforg_automation.pageObjects.android.TestUtils;

public class Registration extends ConfigurationAppium{
	@Test
	public void registration() throws MalformedURLException, URISyntaxException, ParseException {
		configureAppium();
		RegistrationPage registrationPage = new RegistrationPage(driver);
		registrationPage.clickCreateAccount();
		
		String firstName = TestUtils.generateRandomAlphabetic();
		registrationPage.inputFirstName(firstName);
		
		String lastName = TestUtils.generateRandomAlphabetic();
		registrationPage.inputLastName(lastName);
		registrationPage.clickInputEmailField();
		
		String email_id = TestUtils.RandomEmailGenerator();
		registrationPage.inputEmail(email_id);
		
		String phoneNumber = TestUtils.RandomPhoneNumberGenerator();
		registrationPage.inputPhoneNumber(phoneNumber);
		registrationPage.clickStateSelection();
		registrationPage.clickSelectedState();
		//registrationPage.clickDobField();
		registrationPage.clickdatePicker();
		
		//Date selection from date picker
		TestUtils.selectDate(driver, "2011", 14, Calendar.MAY);
		registrationPage.clickContButton();
		registrationPage.inputlicenseNumber("A7864908");
		registrationPage.clickSecDatePicker();
		TestUtils.selectDateForLicense(driver, "2027", 22, Calendar.JUNE);
		registrationPage.ClickSecContButton();
		registrationPage.inputParticipantID("8574839");
		registrationPage.clickdatePicker();
		TestUtils.selectDateForLicense(driver, "2028", 20, Calendar.JUNE);
		
		String mentorName = TestUtils.generateRandomAlphabetic();
		registrationPage.inputMentorName(mentorName);
		
		String groupName = TestUtils.generateRandomShortAlphabetic();
		registrationPage.inputGroupName(groupName);
		registrationPage.clickRegistrationButton();
			
	}
}
