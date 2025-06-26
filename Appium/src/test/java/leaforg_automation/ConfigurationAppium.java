package leaforg_automation;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class ConfigurationAppium {
	//Global declaration of AppiumDriverLocalService object
	AppiumDriverLocalService service;
	
	//Global declaration of UiAutomator2Options object
	UiAutomator2Options options;
	
	//Global declaration of AndroidDriver object
	AndroidDriver driver;
	
	@BeforeClass
	public void configureAppium() throws MalformedURLException, URISyntaxException {
		//Start Appium Server automatically before the test
				/*
				service = new AppiumServiceBuilder()
						.withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
						.withIPAddress("127.0.0.1").usingPort(4723).build();
				service.start();
				*/
				//Device connection setup through UiAutomator2
				options = new UiAutomator2Options();
				options.setDeviceName("TestDevice API 36");
				options.setApp("/Users/zarintasnim/git/repository/Appium/src/test/java/app_installer/leaforg.apk");
				options.setCapability("disableWindowAnimation", true);
				options.autoGrantPermissions();
			    
				
				//Android driver initiation and server connection
				driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options);
				
				DesiredCapabilities capabilities = new DesiredCapabilities();
			    capabilities.setCapability("autoGrantPermissions", "true");
				
				driver.findElement(AppiumBy.id("android:id/button1")).click();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@AfterClass
	public void endTest() {	
		//App close
		driver.quit();		
		//Stop the server
		// service.stop();

	}
}
