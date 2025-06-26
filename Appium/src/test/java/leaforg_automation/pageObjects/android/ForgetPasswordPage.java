package leaforg_automation.pageObjects.android;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ForgetPasswordPage {
	
	AndroidDriver driver;
	
	public ForgetPasswordPage(AndroidDriver driver) {
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text=\"Forgot password?\"]")
	private WebElement forgetPwButton;
	
	@AndroidFindBy(className="android.widget.EditText")
	private WebElement emailField;
	
	@AndroidFindBy(xpath="//android.widget.Button[@text=\"RESET\"]")
	private WebElement resetButton;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text=\"A link to reset your password has been sent\"]")
	private WebElement resetPopUp;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text=\"User does not exist\"]")
	private WebElement errorPopUp;
	
	public void clickForgetPwButton() {
		forgetPwButton.click();
	}
	
	public void clickEmailField() {
		emailField.click();
	}
	
	public void inputEmailField(String em) {
		emailField.sendKeys(em);
	}
	
	public void clickResetButton() {
		resetButton.click();
	}
	
	public String checkResetPopUp() {
		return resetPopUp.getText();
	}
	
	public String checkErrorPopUp() {
		return errorPopUp.getText();
	}
	
	public boolean checkResetButton() {
		return resetButton.isEnabled();
	}

}
