package leaforg_automation.pageObjects.android;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ChangePasswordPage {
	
	AndroidDriver driver;
	
	public ChangePasswordPage(AndroidDriver driver) {
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath="//android.view.View[@text=\"settings Settings\"]")   //Later will be imported from another file
	private WebElement settingProfile;     
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text=\"Change Password\"]")
	private WebElement changePassword;
	
	@AndroidFindBy(xpath="//android.widget.EditText[@hint=\"Current Password\"]")
	private WebElement currentPassword;
	
	@AndroidFindBy(xpath="//android.widget.EditText[@hint=\"New Password\"]")
	private WebElement newPassword;
	
	@AndroidFindBy(xpath="//android.widget.EditText[@hint=\"New Password Again\"]")
	private WebElement againNewPassword;
	
	@AndroidFindBy(xpath="//android.widget.Button[@text=\"CHANGE PASSWORD\"]")
	private WebElement changePwButton;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text=\"Password successfully updated\"]")
	private WebElement changePwConfirmation;
	
	@AndroidFindBy(xpath="//android.widget.Button[@text=\"OK\"]")
	private WebElement okButton;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id=\"alert-msg-0\"]")
	private WebElement errorPopUp;
	
	public void clickSettingProfile() {
		settingProfile.click();
	}
	
	public void clickChangePassword() {
		changePassword.click();
	}
	
	public void inputCurrentPassword(String cpw) {
		currentPassword.sendKeys(cpw);
	}
	
	public void inputNewPassword(String npw) {
		newPassword.sendKeys(npw);
	}
	
	public void inputAgainNewPassword(String apw) {
		againNewPassword.sendKeys(apw);
	}
	
	public void clickChangePwButton() {
		changePwButton.click();
	}
	
	public String checkChangePwConfirmation() {
		return changePwConfirmation.getText();
	}
	
	public void clickOkButton() {
		okButton.click();
	}
	
	public String textErrorPopUp() {
		return errorPopUp.getText();
	}

}
