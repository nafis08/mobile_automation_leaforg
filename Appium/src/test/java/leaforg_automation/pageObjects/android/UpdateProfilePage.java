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
	
	@AndroidFindBy(xpath="//android.widget.EditText[@hint=\"Phone Number\"]")
	private WebElement mobileNumber;
	
	@AndroidFindBy(xpath="//android.view.View[@text=\"TamilNadu\"]")
	private WebElement selectedState;
	
	@AndroidFindBy(xpath="//android.widget.Button[@resource-id=\"android:id/button1\"]")
	private WebElement setButton;
	
	@AndroidFindBy(xpath="//android.widget.Button[@text=\"SAVE CHANGES\"]")
	private WebElement saveChanges;

	
	@AndroidFindBy(xpath="//android.widget.TextView[@text=\"Your changes are submitted for review and approval.\"]")
	private WebElement confirmationPopUp;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text=\"Changes saved successfully\"]")
	private WebElement altConfirmationPopUp;
	
	@AndroidFindBy(xpath="//android.widget.Button[@text=\"OK\"]")
	private WebElement okButton;
	
	@AndroidFindBy(xpath="//android.widget.Button[@text=\"arrow back\"]")
	private WebElement backButton;
	
	public void clickSettingProfile() {
		settingProfile.click();
	}
	
	public void clickUserProfile() {
		userProfile.click();
	}
	
	public void inputFirstName(String fname) {
		firstName.sendKeys(fname);
	}
	
	public void inputLastName(String lname) {
		lastName.sendKeys(lname);
	}
	
	public boolean checkEmailField() {
		return emailField.isEnabled();
	}
	
	public void clearMobileNumberFiled() {
		mobileNumber.clear();;
	}
	
	public void inputMobileNumber(String mn) {
		mobileNumber.sendKeys(mn);
	}
	
	public boolean checkSelectedState() {
		return selectedState.isSelected();
	}
	
	public void clickSetButton() {
		setButton.click();
	}
	
	public void clickSaveChanges() {
		saveChanges.click();
	}
	
	public String textConfirmationPopUp() {
		return confirmationPopUp.getText();
	}
	
	public String textAltConfirmationPopUp() {
		return altConfirmationPopUp.getText();
	}
	
	public void clickOkButton() {
		okButton.click();
	}
	
	public void clickBackButtonn() {
		backButton.click();
	}
	
	public void clearFirstName() {
		firstName.clear();
	}
	
	public boolean saveChangesButtonEnabled() {
		return saveChanges.isEnabled();
	}

}
