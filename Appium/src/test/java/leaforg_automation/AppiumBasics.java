package leaforg_automation;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class AppiumBasics {
	@Test
	public void AppiumTest() throws MalformedURLException, URISyntaxException {
		
		//Start Appium Server automatically before the test
		AppiumDriverLocalService service = new AppiumServiceBuilder()
				.withAppiumJS(new File("//usr//local//lib//node_modules//appium//build//lib//main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();
		service.start();
		
		//Device connection setup through UiAutomator2
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("TestDevice API36");
		options.setApp("/Users/zarintasnim/git/repository/Appium/src/test/java/app_installer/leaforg.apk");
		
		//Android driver initiation and server connection
		AndroidDriver driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options);
		driver.quit();
		
		//Stop the server
		service.stop();
		
		
	}

}
