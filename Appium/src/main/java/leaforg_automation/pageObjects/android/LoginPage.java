package leaforg_automation.pageObjects.android;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginPage {
	
	AndroidDriver driver;
	
	public LoginPage(AndroidDriver driver) {
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath="//android.widget.EditText[@hint=\"Email\"]")
	private WebElement loginEmailFIeld;
	
	@AndroidFindBy(xpath="//android.widget.EditText[@hint=\"Password\"]")
	private WebElement passwordField;
	
	@AndroidFindBy(className="android.widget.Button")
	private WebElement loginButton;
	
	@AndroidFindBy(xpath="//android.view.View[@text=\"ArgamnArgamn Singh\"]")
	private WebElement profileName;
	
	@AndroidFindBy(xpath="//android.view.View[@text=\"M8976567\nTAMILNADU\"]")
	private WebElement licenseNumber;
	
	@AndroidFindBy(xpath="//android.view.View[@text=\"89767877\nEXP 02/28/2035\"]")
	private WebElement participantID;
	
	
	public void inputLoginEmail(String email) {
		loginEmailFIeld.sendKeys(email);
	}
	
	public void inputPassword(String password) {
		passwordField.sendKeys(password);
	}
	
	public void clickLoginButton() {
		loginButton.click();;
	}
	
	public String getProfileName() {
		return profileName.getText();
	}
	
	public String getLicenseNumber() {
		return licenseNumber.getText();
	}
	
	public String getParticipantID() {
		return participantID.getText();
	}
	
	

}
