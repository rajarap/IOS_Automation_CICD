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

public class AddSatelliteHelpPlaceYourSatellitePage extends ParentClass implements Page {
	public TestUtils utils = new TestUtils();
	
//	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"BOBAHelp\"]")
//	public MobileElement helpIcon;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Place_BOBA_Satellite_Screen_TitleLabel\"]")
	public MobileElement placeYourSatelliteTitle;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Place_BOBA_Satellite_Screen_SubTitleLabel\"]")
	public MobileElement placeYourSatelliteSubTitle;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Place_BOBA_Satellite_Screen_Button_Skip\"]")
	public MobileElement skipButton;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Place_BOBA_Satellite_Screen_Button\"]")
	public MobileElement contiueButton;

	public AddSatelliteHelpPlaceYourSatellitePage() {
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}

	public boolean clickSkipButton() {
		if (skipButton.isDisplayed()) {
			click(skipButton);
			utils.log().info("Clicked on Skip Button");
			return true;
		} else {
			utils.log().info("Skip Button is not displayed");
			return false;
		}
	}
	
	public boolean clickNContinueButton() {
		if (contiueButton.isDisplayed()) {
			click(contiueButton);
			utils.log().info("Clicked on Continue Button");
			return true;
		} else {
			utils.log().info("Continue Button is not displayed");
			return false;
		}
	}

	@Override
	public boolean isAt() {
		if (placeYourSatelliteTitle.isDisplayed()) {
			utils.log().info("On WE'D LIKE TO HELP YOU PLACE YOUR SATELLITE Page");
			return true;
		} else {
			utils.log().info("Not on WE'D LIKE TO HELP YOU PLACE YOUR SATELLITE Page");
			return false;
		}
	}
}
