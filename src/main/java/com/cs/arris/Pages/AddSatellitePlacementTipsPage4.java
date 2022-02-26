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

// Keep you mAx in the open

public class AddSatellitePlacementTipsPage4 extends ParentClass implements Page {
	public TestUtils utils = new TestUtils();
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"BOBA Arrow\"]")
	public MobileElement backIcon;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Placement Tips\"]")
	public MobileElement placementTipsTitle;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"BOBA_Satellite_Placement_Tips_Spread_Max_Network_Screen_TitleLabel\"]")
	public MobileElement placementTipsTitle2;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"BOBA_Satellite_Placement_Tips_Spread_Max_Network_Screen_SubTitleLabel\"]")
	public MobileElement description;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"BOBA_Satellite_Placement_Tips_Spread_Max_Network_Screen_Button\"]")
	public MobileElement nextButton;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"BOBA_Satellite_Placement_Tips_Spread_Max_Network_Screen_Button_Skip\"]")
	public MobileElement skipButton;

	public AddSatellitePlacementTipsPage4() {
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
	
	public boolean clickSkipButton() {
		if (skipButton.isDisplayed()) {
			click(skipButton);
			utils.log().info("Clicked on Skip Tips Button");
			return true;
		} else {
			utils.log().info("Skip Tips Button is not displayed");
			return false;
		}
	}
	
	public boolean clickBackButton() {
		if (backIcon.isDisplayed()) {
			click(backIcon);
			utils.log().info("Clicked on Back Button");
			return true;
		} else {
			utils.log().info("Back Button is not displayed");
			return false;
		}
	}

	@Override
	public boolean isAt() {
		if (placementTipsTitle.isDisplayed()) {
			utils.log().info("On Placement Tips Page");
			return true;
		} else {
			utils.log().info("Not on Placement Tips Page");
			return false;
		}
	}
}
