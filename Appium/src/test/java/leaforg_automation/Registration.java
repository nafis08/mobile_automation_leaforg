package leaforg_automation;

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
		registrationPage.inputFirstName("NS1");
		registrationPage.inputLastName("NS2");
		registrationPage.clickInputEmailField();
		registrationPage.inputEmail("nn@gmail.com");
		registrationPage.inputPhoneNumber("5678372909");
		registrationPage.clickStateSelection();
		registrationPage.clickSelectedState();
		registrationPage.clickDobField();
		registrationPage.clickdatePicker();
		
		//Date selection from date picker
		TestUtils.selectDate(driver, "2011", 14, Calendar.MAY);
		registrationPage.clickContButton();
		registrationPage.inputlicenseNumber("A7864908");
		TestUtils.selectDate(driver, "2025", 22, Calendar.JUNE);
		registrationPage.ClickSecContButton();
		registrationPage.inputParticipantID("8574839");
		TestUtils.selectDate(driver, "2025", 20, Calendar.JUNE);
		registrationPage.inputMentorName("Francis");
		registrationPage.inputGroupName("Xeviar");
		registrationPage.clickRegistrationButton();
		
		/*
		driver.findElement(AppiumBy.id("android:id/date_picker_header_year")).click();
		WebElement yearList = driver.findElement(AppiumBy.androidUIAutomator(
			    "new UiScrollable(new UiSelector().scrollable(true)).scrollBackward().scrollIntoView(new UiSelector().text(\"2011\"))"
			));
		yearList.click();
		
		///Parsing month from the existing date
		String date_found = driver.findElement(AppiumBy.id("android:id/date_picker_header_date")).getText();
		SimpleDateFormat inputFormat = new SimpleDateFormat("E, MMM dd", Locale.ENGLISH);
		Date date = inputFormat.parse(date_found);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int monthNumber = calendar.get(Calendar.MONTH)+1;
		for(int i=0; i<monthNumber-4; i++) {
			driver.findElement(AppiumBy.id("android:id/prev")).click();
		}
		*/
		
		



		
		
	}
}
