package leaforg_automation.pageObjects.android;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class UpdateProfilePage {
	AndroidDriver driver;
	
	public UpdateProfilePage(AndroidDriver driver) {
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath="//android.view.View[@text=\"settings Settings\"]")
	private WebElement settingProfile;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text=\"My Profile\"]")
	private WebElement userProfile;
	
	@AndroidFindBy(xpath="//android.widget.EditText[@hint=\"First Name\"]")
	private WebElement firstName;
	
	@AndroidFindBy(xpath="//android.widget.EditText[@hint=\"Last Name\"]")
	private WebElement lastName;
	
	@AndroidFindBy(xpath="(//android.widget.EditText[@hint=\"Email\"])[2]")
	private WebElement emailField;
	
	public void clickSettingProfile() {
		settingProfile.click();
	}
	
	public void clickUserProfile() {
		userProfile.click();
	}
	
	public void inputFirstName(String fname) {
		firstName.sendKeys(fname);;
	}
	
	public void inputLastName(String lname) {
		lastName.sendKeys(lname);;
	}
	
	public boolean checkEmailField() {
		return emailField.isEnabled();
	}

}
