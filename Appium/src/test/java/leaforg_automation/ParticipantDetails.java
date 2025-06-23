package leaforg_automation;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.time.Duration;
import java.util.Calendar;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import leaforg_automation.pageObjects.android.TestUtils;
import leaforg_automation.pageObjects.android.LoginPage;

public class ParticipantDetails extends ConfigurationAppium{
	@Test
	public void participantDetailsUpdate() throws MalformedURLException, URISyntaxException, ParseException {
		configureAppium();
		
		LoginPage appLogin = new LoginPage(driver);
		appLogin.inputLoginEmail("rajkumar@testleaf.com");
		appLogin.inputPassword("Leaf@123");
		appLogin.clickLoginButton();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@text=\"settings Settings\"]"))).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text=\"Participant Details\"]")).click();
		String participantInfo = driver.findElement(By.xpath("//android.widget.TextView[@text=\"Edit Participant Info\"]")).getText();
		Assert.assertEquals(participantInfo, "Edit Participant Info");
		driver.findElement(By.xpath("//android.widget.EditText[@hint=\"Participant ID\"]")).sendKeys("37394728");
		//TestUtils.selectDate(driver, "2036", 14, Calendar.APRIL);
		
		String randomShortString = TestUtils.generateRandomShortAlphabetic();
		driver.findElement(By.xpath("//android.widget.EditText[@hint=\"Mentor's Name\"]")).sendKeys(randomShortString);
		
		String randomShortStringSec = TestUtils.generateRandomShortAlphabetic();
		driver.findElement(By.xpath("//android.widget.EditText[@hint=\"URL\"]")).sendKeys(randomShortStringSec);
		
		driver.findElement(By.xpath("//android.widget.EditText[@hint=\"Drivers License #\"]")).sendKeys("M94058334");
		TestUtils.selectDate(driver, "2025", 14, Calendar.JULY);
		
		//driver.findElement(By.xpath("//android.widget.Button[@text=\"SAVE CHANGES\"]")).click();
		driver.findElement(By.xpath("//android.widget.Button[@text=\"arrow back\"]")).click();
		
		
		//Assertion will be added
		
		
	}

}

