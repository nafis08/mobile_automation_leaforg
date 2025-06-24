package leaforg_automation.pageObjects.android;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ParticipantPage {
	
	AndroidDriver driver;
	
	public ParticipantPage(AndroidDriver driver) {
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath="//android.view.View[@text=\"settings Settings\"]")
	private WebElement settingProfile;    										//Later to be imported from other file
	
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text=\"Participant Details\"]")
	private WebElement participantDetails;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text=\"Edit Participant Info\"]")
	private WebElement participantInfo;
	
	@AndroidFindBy(xpath="//android.widget.EditText[@hint=\"Participant ID\"]")
	private WebElement participantID;
	
	@AndroidFindBy(xpath="//android.widget.EditText[@hint=\"Mentor's Name\"]")
	private WebElement mentorName;
	
	@AndroidFindBy(xpath="//android.widget.EditText[@hint=\"URL\"]")
	private WebElement groupName;
	
	@AndroidFindBy(xpath="//android.widget.EditText[@hint=\"Drivers License #\"]")
	private WebElement driverLicense;
	
	@AndroidFindBy(xpath="//android.widget.Button[@text=\"SAVE CHANGES\"]")
	private WebElement saveButton;
	
	@AndroidFindBy(xpath="//android.widget.Button[@text=\"arrow back\"]")
	private WebElement backButton;
	
	public void clickSettingProfile() {
		settingProfile.click();
	}
	
	public void clickParticipantDetails() {
		participantDetails.click();
	}
	
	public String checkParticipantInfo() {
		return participantInfo.getText();
	}
	
	public void inputParticipantID(String id) {
		participantID.sendKeys(id);
	}
	
	public void inputMentorName(String mn) {
		mentorName.sendKeys(mn);
	}
	
	public void inputGroupName(String gn) {
		groupName.sendKeys(gn);
	}
	
	public void inputdriverLicense(String dl) {
		driverLicense.sendKeys(dl);
	}
	
	public void clickSaveButton() {
		saveButton.click();
	}
	
	public void clickBackButtonn() {
		backButton.click();
	}
	

}
