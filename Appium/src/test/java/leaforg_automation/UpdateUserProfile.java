package leaforg_automation;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
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
		
		WebElement mobileNumber = driver.findElement(By.xpath("//android.widget.EditText[@hint=\"Phone Number\"]"));
		mobileNumber.clear();
		mobileNumber.sendKeys("888-999-4567");
		driver.findElement(By.xpath("//android.view.View[@text=\"TamilNadu\"]")); // Assertion needed

		driver.findElement(By.xpath("//android.widget.Spinner")).click();

		// Date selection from date picker
		driver.findElement(AppiumBy.id("android:id/date_picker_header_year")).click();
		WebElement yearList = driver.findElement(AppiumBy.androidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true)).scrollBackward().scrollIntoView(new UiSelector().text(\"2011\"))"));
		yearList.click();

		/// Parsing month from the existing date
		String date_found = driver.findElement(AppiumBy.id("android:id/date_picker_header_date")).getText();
		SimpleDateFormat inputFormat = new SimpleDateFormat("E, MMM dd", Locale.ENGLISH);
		Date date = inputFormat.parse(date_found);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int monthNumber = calendar.get(Calendar.MONTH) + 1;
		for (int i = 0; i < monthNumber - 4; i++) {
			driver.findElement(AppiumBy.id("android:id/prev")).click();
		}
		driver.findElement(By.xpath("//android.view.View[@text=\"14\"]")).click();
		driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"android:id/button1\"]")).click();

		driver.findElement(By.xpath("//android.widget.Button[@text=\"SAVE CHANGES\"]")).click();
		String success_prompt = driver.findElement(By.xpath("//android.widget.TextView[@text=\"Your changes are submitted for review and approval.\"]")).getText();
		Assert.assertEquals(success_prompt, "Your changes are submitted for review and approval.");
		driver.findElement(By.xpath("//android.widget.Button[@text=\"OK\"]")).click();
		driver.findElement(By.xpath("//android.widget.Button[@text=\"arrow back\"]")).click();
	}

}


