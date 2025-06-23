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

public class BatchesUpdate extends ConfigurationAppium{
	@Test
	public void batchesUpdate() throws MalformedURLException, URISyntaxException {
		configureAppium();
		
		LoginPage appLogin = new LoginPage(driver);
		appLogin.inputLoginEmail("rajkumar@testleaf.com");
		appLogin.inputPassword("Leaf@123");
		appLogin.clickLoginButton();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@text=\"settings Settings\"]"))).click();
		
		driver.findElement(By.xpath("//android.widget.TextView[@text=\"Batches\"]")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text=\"Appium March 2017\"]")).isDisplayed();
		driver.findElement(By.xpath("//android.widget.Button[@text=\"ADD\"]")).click();
		String popUp = driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"alert-hdr-0\"]")).getText(); 
		
		//For future Implementation
		Assert.assertEquals(popUp, "Not Error");
		driver.findElement(By.xpath(" //android.widget.Button[@text=\"OK\"]")).click();
	}
}



/*
* 
* 
* 
* 
*
*/