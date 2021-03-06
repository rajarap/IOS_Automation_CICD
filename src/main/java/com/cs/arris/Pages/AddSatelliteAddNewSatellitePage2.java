package com.cs.arris.Pages;

import org.openqa.selenium.support.PageFactory;

import com.cs.arris.Base.ParentClass;
import com.cs.arris.Interface.Page;
import com.cs.arris.Utilities.TestUtils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class AddSatelliteAddNewSatellitePage2 extends ParentClass implements Page {
	public TestUtils utils = new TestUtils();
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"ADD SATELLITE\"]")
	public MobileElement addSatelliteTitle;
		
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Add_New_BOBA_Satellite_Screen_TitleLabel\"]")
	public MobileElement addSatelliteTitle2;

	//Your network is being configured for satellite install. You may be disconnected from your Wi-Fi network. If you are not reconnected please connect to your network through settings.
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Add_New_BOBA_Satellite_Screen_SubTitleLabel\"]")
	public MobileElement description;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Add_New_BOBA_Satellite_Screen_Button\"]")
	public MobileElement nextButton;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"CANCEL\"]")
	public MobileElement cancelButton;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"BOBA Arrow\"]")
	public MobileElement backButton;

	public AddSatelliteAddNewSatellitePage2() {
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}

	public boolean clickNextButton() {
		if (nextButton.isDisplayed()) {
			click(nextButton);
			utils.log().info("Add Satellite 2 - Clicked on Next Button");
			return true;
		} else {
			utils.log().info("Next Button is not displayed");
			return false;
		}
	}

	public boolean clickCancelButton() {
		if (cancelButton.isDisplayed()) {
			click(cancelButton);
			utils.log().info("Clicked on Cancel Button");
			return true;
		} else {
			utils.log().info("Cancel Button is not displayed");
			return false;
		}
	}

	@Override
	public boolean isAt() {
		if (addSatelliteTitle2.isDisplayed()) {
			utils.log().info("On ADD NEW SATELLITE Page 2 - Your network is being configured for satellite install. You may be disconnected from the Wifi Network. If you are not reconnected, please connect to your network through settings.");
			return true;
		} else {
			utils.log().info("Not on ADD NEW SATELLITE Page 2");
			return false;
		}
	}
}
