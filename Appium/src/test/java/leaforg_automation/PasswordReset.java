package leaforg_automation;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class PasswordReset extends ConfigurationAppium{
	@Test
	public void passwordResetTest() throws MalformedURLException, URISyntaxException {
		configureAppium();
		
		driver.findElement(By.xpath("//android.widget.TextView[@text=\"Forgot password?\"]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String emailInfputField = "//android.webkit.WebView[@text=\"Reset Password\"]/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.widget.EditText";
		driver.findElement(By.xpath(emailInfputField)).sendKeys("rajkumar@testleaf.com");
		driver.findElement(By.xpath("//android.widget.Button[@text=\"RESET\"]")).click();
		String confirmation = driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"alert-hdr-0\"]")).getText();
		Assert.assertEquals(confirmation, "Info");
	}

}
