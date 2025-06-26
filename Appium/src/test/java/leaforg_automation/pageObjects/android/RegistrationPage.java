package leaforg_automation.pageObjects.android;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class RegistrationPage {
	AndroidDriver driver;
	
	public RegistrationPage(AndroidDriver driver) {
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text=\"Create an Account\"]")
	private WebElement createAccount;
	
	@AndroidFindBy(xpath=("//android.widget.EditText[@hint=\"First Name\"]"))
	private WebElement firstName;
	
	@AndroidFindBy(xpath=("//android.widget.EditText[@hint=\"Last Name\"]"))
	private WebElement lastName;
	
	@AndroidFindBy(xpath=("//android.webkit.WebView[@text=\"Personal Info\"]/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View/android.view.View/android.view.View[3]/android.view.View/android.view.View/android.view.View/android.widget.EditText"))
	private WebElement emailField;
	
	@AndroidFindBy(xpath=("//android.widget.EditText[@hint=\"Phone Number\"]"))
	private WebElement phoneNumber;
	
	@AndroidFindBy(xpath=("//android.widget.TextView[@text=\"State\"]"))
	private WebElement stateSelection;
	
	@AndroidFindBy(xpath=("//android.widget.TextView[@text=\"TamilNadu\"]"))
	private WebElement selectedState;
	
	@AndroidFindBy(xpath = "//android.view.View[@text='Date of Birth']/following-sibling::android.widget.Spinner")
	private WebElement dobField;
	
	@AndroidFindBy(xpath = "//android.widget.Spinner")
	private WebElement datePicker;
	
	@AndroidFindBy(xpath = "//android.widget.Button[@text=\"CONTINUE\"]")
	private WebElement contButton;
	
	@AndroidFindBy(xpath = "//android.widget.EditText[@hint=\"Drivers License #\"]")
	private WebElement licenseNumber;
	
	@AndroidFindBy(xpath = "(//android.widget.Button[@text=\"CONTINUE\"])[2]")
	private WebElement secContButton;
	
	@AndroidFindBy(xpath = "//android.widget.EditText[@hint=\"Participant ID#\"]")
	private WebElement participantID;
	
	@AndroidFindBy(xpath = "//android.widget.EditText[@hint=\"Mentor's Name\"]")
	private WebElement mentorName;
	
	@AndroidFindBy(xpath = "//android.widget.EditText[@hint=\"Group Name\"]")
	private WebElement groupName;
	
	@AndroidFindBy(xpath = "//android.widget.Button[@text=\"SUBMIT REGISTRATION\"]")
	private WebElement registrationButton;
	
	
	@AndroidFindBy(xpath = "//android.webkit.WebView[@text=\"Add Licenses\"]/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View/android.view.View/android.view.View[3]/android.view.View/android.view.View/android.view.View/android.widget.Spinner")
	private WebElement secDatePicker;
	
	@AndroidFindBy(id = "android:id/date_picker_header_year")
	private WebElement yearPicker;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text=\"Email must be in xxx@xxx.xxx format\"]")
	private WebElement emailWarning;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text=\"Hi! Phone number must be 999-999-9999\"]")
	private WebElement phoneWarning;
	
	
	public boolean yearPicker() {
		return yearPicker.isDisplayed();
	}
	
	public void clickCreateAccount() {
		createAccount.click();
	}
	
	public void inputFirstName(String fname) {
		firstName.sendKeys(fname);;
	}
	
	public void inputLastName(String lname) {
		lastName.sendKeys(lname);;
	}
	
	public void clickInputEmailField() {
		emailField.click();
	}
	
	public void inputEmail(String email) {
		emailField.sendKeys(email);;
	}
	
	public void inputPhoneNumber(String phn) {
		phoneNumber.sendKeys(phn);;
	}
	
	public void clickStateSelection() {
		stateSelection.click();
	}
	
	public void clickSelectedState() {
		selectedState.click();
	}
	
	public void clickDobField() {
		dobField.click();
	}
	
	public void clickdatePicker() {
		datePicker.click();
	}
	
	public void clickContButton() {
		contButton.click();
	}
	
	public void inputlicenseNumber(String dl) {
		licenseNumber.sendKeys(dl);
	}
	
	public void ClickSecContButton() {
		secContButton.click();
	}
	
	public void inputParticipantID(String pid) {
		participantID.sendKeys(pid);
	}
	
	public void inputMentorName(String mn) {
		mentorName.sendKeys(mn);
	}
	
	public void inputGroupName(String gn) {
		groupName.sendKeys(gn);
	}
	
	public void clickRegistrationButton() {
		registrationButton.click();
	}
	
	public void clickSecDatePicker() {
		secDatePicker.click();
	}
	
	public String checkEmailWarning() {
		return emailWarning.getText();
	}
	
	public String checkPhoneWarning() {
		return phoneWarning.getText();
	}
	
}
