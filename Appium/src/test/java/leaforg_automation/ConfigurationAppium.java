package leaforg_automation;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

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
				
				service = new AppiumServiceBuilder()
						.withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
						.withIPAddress("127.0.0.1").usingPort(4723).build();
				service.start();
				
				//Device connection setup through UiAutomator2
				options = new UiAutomator2Options();
				options.setDeviceName("TestDevice");
				options.setApp("/Users/zarintasnim/git/repository/Appium/src/test/java/app_installer/leaforg.apk");
				options.setCapability("disableWindowAnimation", true);
				
				//Android driver initiation and server connection
				driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options);
				
				driver.findElement(AppiumBy.id("android:id/button1")).click();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@AfterClass
	public void endTest() {	
		//App close
		driver.quit();		
		//Stop the server
		service.stop();
		
	}
}
