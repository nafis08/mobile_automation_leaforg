package leaforg_automation.pageObjects.android;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class BatchPage {
	AndroidDriver driver;
	
	public BatchPage(AndroidDriver driver) {
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath="//android.view.View[@text=\"settings Settings\"]")
	private WebElement settingProfile;                                       //Later to be imported from other file
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text=\"Batches\"]")
	private WebElement batchButton;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text=\"Appium March 2017\"]")
	private WebElement addedBatch;
	
	@AndroidFindBy(xpath="//android.widget.Button[@text=\"ADD\"]")
	private WebElement addButton;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id=\"alert-hdr-0\"]")
	private WebElement errorPopUp;
	
	@AndroidFindBy(xpath="//android.widget.Button[@text=\"OK\"]")
	private WebElement okButton;
	
	public void clickSettingProfile() {
		settingProfile.click();
	}
	
	public void clickBatchButton() {
		batchButton.click();
	}
	
	public boolean checkAddedBatch() {
		return addedBatch.isDisplayed();
	}
	
	public void clickAddButton() {
		addButton.click();
	}
	
	public String checkErrorPopUp() {
		return errorPopUp.getText();
	}
	
	public void clickOkButton() {
		okButton.click();
	}
}
