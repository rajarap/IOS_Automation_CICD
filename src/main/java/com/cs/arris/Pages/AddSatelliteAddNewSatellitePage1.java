package com.cs.arris.Pages;

import org.apache.commons.lang3.time.StopWatch;
import org.openqa.selenium.support.PageFactory;

import com.cs.arris.Base.ParentClass;
import com.cs.arris.Interface.Page;
import com.cs.arris.Utilities.TestUtils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class AddSatelliteAddNewSatellitePage1 extends ParentClass implements Page {
	public TestUtils utils = new TestUtils();

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"ADD SATELLITE\"]")
	public MobileElement addSatelliteTitle;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Add_New_BOBA_Satellite_Screen_TitleLabel\"]")
	public MobileElement addSatelliteTitle2;

	//Each satellite expands your network coverage. The following steps will add your satellite to your network.
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Add_New_BOBA_Satellite_Screen_SubTitleLabel\"]")
	public MobileElement description;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Add_New_BOBA_Satellite_Screen_Button\"]")
	public MobileElement nextButton;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Add_New_BOBA_Satellite_Screen_Button_Cancel\"]")
	public MobileElement cancelButton;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"BOBA Arrow\"]")
	public MobileElement backButton;

	public AddSatelliteAddNewSatellitePage1() {
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}

	public boolean clickNextButton() {
		if (nextButton.isDisplayed()) {
			click(nextButton);
			utils.log().info("Clicked on Next Button");
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
		if (addSatelliteTitle.isDisplayed()) {
			utils.log().info("On ADD SATELLITE Page");
			return true;
		} else {
			utils.log().info("Not on ADD SATELLITE Page");
			return false;
		}
	}
}
