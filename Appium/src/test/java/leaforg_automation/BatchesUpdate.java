package leaforg_automation;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.net.MalformedURLException;
import java.net.URISyntaxException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import leaforg_automation.pageObjects.android.BatchPage;
import leaforg_automation.pageObjects.android.LoginPage;
import leaforg_automation.pageObjects.android.TestDataStore;

public class BatchesUpdate extends ConfigurationAppium{
	@Test
	public void batchesUpdate() throws MalformedURLException, URISyntaxException {
		configureAppium();
		
		LoginPage appLogin = new LoginPage(driver);
		appLogin.inputLoginEmail(TestDataStore.Email_ID);
		appLogin.inputPassword("Leaf@123");
		appLogin.clickLoginButton();
		
		BatchPage batchPage = new BatchPage(driver);
		batchPage.clickSettingProfile();
		batchPage.clickBatchButton();
		AssertJUnit.assertTrue(batchPage.checkAddedBatch());
		batchPage.clickAddButton();
		
		//For future Implementation
		AssertJUnit.assertEquals(batchPage.checkErrorPopUp(), "Not Error");
		batchPage.clickOkButton();
	}
}
