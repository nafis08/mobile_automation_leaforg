package leaforg_automation.pageObjects.android;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CommonPageElement {
	
	AndroidDriver driver;
	
	public CommonPageElement(AndroidDriver driver) {
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath="//android.view.View[@text=\"settings Settings\"]") 
	private WebElement settingProfile;
	
	@AndroidFindBy(xpath="//android.widget.Button[@text=\"OK\"]")
	private WebElement okButton;
	
	public void clickSettingProfile() {
		settingProfile.click();
	}
	
	public void clickOkButton() {
		okButton.click();
	}

}
