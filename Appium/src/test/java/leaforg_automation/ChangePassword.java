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

public class ChangePassword extends ConfigurationAppium{
	@Test
	public void changePassword() throws MalformedURLException, URISyntaxException {
		configureAppium();
		
		LoginPage appLogin = new LoginPage(driver);
		appLogin.inputLoginEmail("rajkumar@testleaf.com");
		appLogin.inputPassword("Leaf@123");
		appLogin.clickLoginButton();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@text=\"settings Settings\"]"))).click();
		
		driver.findElement(By.xpath("//android.widget.TextView[@text=\"Change Password\"]")).click();
		driver.findElement(By.xpath("//android.widget.EditText[@hint=\"Current Password\"]")).sendKeys("Leaf@123");
		driver.findElement(By.xpath("//android.widget.EditText[@hint=\"New Password\"]")).sendKeys("Leaf@321");
		driver.findElement(By.xpath("//android.widget.EditText[@hint=\"New Password Again\"]")).sendKeys("Leaf@321");
		driver.findElement(By.xpath("//android.widget.Button[@text=\"CHANGE PASSWORD\"]")).click();
		String popUp_success = driver.findElement(By.xpath("//android.widget.TextView[@text=\"Password successfully updated\"]")).getText();
		Assert.assertEquals(popUp_success, "Password successfully updated");
		driver.findElement(By.xpath("//android.widget.Button[@text=\"OK\"]")).click();
	}

}


