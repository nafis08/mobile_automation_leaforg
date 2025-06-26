package leaforg_automation.pageObjects.android;

import org.openqa.selenium.By;
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
	
	/*
	 * Xpath is not proper to verify user profile
	@AndroidFindBy(xpath="//android.view.View[@text=\"ArgamnArgamn Singh\"]")
	private WebElement profileName;
	
	
	//@AndroidFindBy(xpath="//android.view.View[@elementId=\"00000000-0000-08a3-0000-008d0000000e\"]")
	String fullName = TestDataStore.firstName + " " + TestDataStore.lastName;
	String xpath = "//android.view.View[@text=\"" + fullName + "\"]";
	WebElement profileName=driver.findElement(By.xpath(xpath));
	*/
	
	@AndroidFindBy(xpath="//android.view.View[@text=\"M8976567\nTAMILNADU\"]")
	private WebElement licenseNumber;
	
	@AndroidFindBy(xpath="//android.view.View[@text=\"89767877\nEXP 02/28/2035\"]")
	private WebElement participantID;
	
	@AndroidFindBy(xpath="//android.widget.Button[@text=\"LOGOUT\"]")
	private WebElement logoutButton;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text=\"Are you sure you want to logout?\"]")
	private WebElement logoutConfPopUp;
	
	@AndroidFindBy(xpath="//android.widget.Button[@text=\"YES, LOGOUT\"]")
	private WebElement logoutConfirm;
	
	@AndroidFindBy(xpath="//android.widget.Button[@text=\"NO, CANCEL\"]")
	private WebElement logoutCancel;
	
	@AndroidFindBy(xpath="(//android.widget.TextView[@text=\"Field Required\"])[1]")
	private WebElement emailFiedlWarning;
	
	@AndroidFindBy(xpath="((//android.widget.TextView[@text=\"Field Required\"])[2]")
	private WebElement passwordFiedlWarning;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text=\"Given password doesn't match\"]")
	private WebElement wrongPasswordMsg;
	
	@AndroidFindBy(xpath="//android.widget.Button[@text=\"BACK\"]")
	private WebElement backButton;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text=\"User does not exist\"]")
	private WebElement wrongEmail;
	
	
	public void inputLoginEmail(String email) {
		loginEmailFIeld.sendKeys(email);
	}
	
	public void inputPassword(String password) {
		passwordField.sendKeys(password);
	}
	
	public void clickLoginButton() {
		loginButton.click();;
	}

	
	public String getLicenseNumber() {
		return licenseNumber.getText();
	}
	
	public String getParticipantID() {
		return participantID.getText();
	}
	
	public void clickLogoutButton() {
		logoutButton.click();;
	}
	
	public String checkLogoutConfPopUp() {
		return logoutConfPopUp.getText();
	}
	
	public void clickLogoutConfirm() {
		logoutConfirm.click();;
	}
	
	public void clickLogoutCancel() {
		logoutCancel.click();;
	}
	
	public WebElement getProfileNameElement(String firstName, String lastName) {
	    String fullName = firstName + " " + lastName;
	    String xpath = String.format("//android.view.View[@text='%s']", fullName);
	    return driver.findElement(By.xpath(xpath));
	}
	
	public WebElement getLicenseNumElement(String licenseNum) {
	    String licenseNumber = licenseNum;
	    String xpath = String.format("//android.view.View[@text='%s']", licenseNumber);
	    return driver.findElement(By.xpath(xpath));
	}
	
	public WebElement getParticipantIDElement(String participantID) {
	    String participantIDNum = participantID;
	    String xpath = String.format("//android.view.View[@text='%s']", participantIDNum);
	    return driver.findElement(By.xpath(xpath));
	}
	
	public String checkEmailWarning() {
		return emailFiedlWarning.getText();
	}
	
	public String checkPasswordWarning() {
		return passwordFiedlWarning.getText();
	}
	
	public String checkWrongPasswordMsg() {
		return wrongPasswordMsg.getText();
	}
	
	public void clickBackButton() {
		backButton.click();
	}
	
	public String checkWrongEmail() {
		return wrongEmail.getText();
	}

	

}
