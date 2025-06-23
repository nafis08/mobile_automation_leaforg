package leaforg_automation;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import leaforg_automation.pageObjects.android.LoginPage;

public class ContactSupport extends ConfigurationAppium{
	@Test
	public void contactSupport() throws MalformedURLException, URISyntaxException {
		configureAppium();
		
		LoginPage appLogin = new LoginPage(driver);
		appLogin.inputLoginEmail("rajkumar@testleaf.com");
		appLogin.inputPassword("Leaf@123");
		appLogin.clickLoginButton();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@text=\"settings Settings\"]"))).click();
		
		driver.findElement(By.xpath("//android.widget.TextView[@text=\"Contact Support\"]")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text=\"To: help@testleaf.com\"]")).isDisplayed();
		driver.findElement(By.xpath("//android.widget.TextView[@text=\"Cc: rajkumar@testleaf.com\"]")).isDisplayed();
		driver.findElement(By.xpath("//android.widget.EditText[@hint=\"Subject\"]")).sendKeys("Regarding Issue");
		driver.findElement(By.xpath("//android.widget.EditText[@hint=\"Content\"]")).sendKeys("Alles Kaput");
		driver.findElement(By.xpath("//android.widget.Button[@text=\"SEND\"]")).click();
		
		String popUp_success = driver.findElement(By.xpath("//android.widget.TextView[@text=\"Thanks for contacting us. We will be in touch shortly.\"]")).getText();
		Assert.assertEquals(popUp_success, "Thanks for contacting us. We will be in touch shortly.");
		driver.findElement(By.xpath("//android.widget.Button[@text=\"OK\"]")).click();
	}

}






