package leaforg_automation;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class AppiumBasics {
	@Test
	public void AppiumTest() throws MalformedURLException, URISyntaxException {
		
		//Device connection setup through UiAutomator2
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("TestDevice API36");
		options.setApp("//Users//zarintasnim//Desktop//leafrog_mobile_automation//Appium//src//test//java//app_installer//leaforg.apk");
		
		//Android driver initiation and server connection setup
		AndroidDriver driver = new AndroidDriver(new URI("http://127.0.0.1:4723/").toURL(), options);
		driver.quit();
		
		
	}

}
