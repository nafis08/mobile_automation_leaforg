package leaforg_automation.pageObjects.android;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ContactSupportPage {
	AndroidDriver driver;
	
	public ContactSupportPage(AndroidDriver driver) {
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath="//android.view.View[@text=\"settings Settings\"]")
	private WebElement settingProfile;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text=\"Contact Support\"]")
	private WebElement contactSupportButton;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text=\"To: help@testleaf.com\"]")
	private WebElement supportEmailField;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text=\"Cc: rajkumar@testleaf.com\"]")
	private WebElement emailField;
	
	@AndroidFindBy(xpath="//android.widget.EditText[@hint=\"Subject\"]")
	private WebElement subjectField;
	
	@AndroidFindBy(xpath="//android.widget.EditText[@hint=\"Content\"]")
	private WebElement emailBody;
	
	@AndroidFindBy(xpath="//android.widget.Button[@text=\"SEND\"]")
	private WebElement sendButton;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text=\"Thanks for contacting us. We will be in touch shortly.\"]")
	private WebElement confirmationPopUp;
	
	@AndroidFindBy(xpath="//android.widget.Button[@text=\"OK\"]")
	private WebElement okButton;
	
	public void clickSettingProfile() {
		settingProfile.click();
	}
	
	public void clickContactSupportButton() {
		contactSupportButton.click();
	}
	
	public boolean checkSupportEmailField() {
		return supportEmailField.isDisplayed();
	}
	
	public boolean checkEmailField() {
		return emailField.isDisplayed();
	}
	
	public void inputSubjectField(String sb) {
		subjectField.sendKeys(sb);;
	}
	
	public void inputEmailBody(String eb) {
		emailBody.sendKeys(eb);;
	}
	
	public void clickSendButton() {
		sendButton.click();
	}
	
	public String checkConfirmationPopUp() {
		return confirmationPopUp.getText();
	}
	
	public void clickOkButton() {
		okButton.click();
	}
	
	public boolean checkSendButton() {
		return sendButton.isEnabled();
	}

}
