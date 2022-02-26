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

public class AddSatelliteSuccessfullyConnectedToInternetPage extends ParentClass implements Page {
	public TestUtils utils = new TestUtils();
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"BOBAHelp\"]")
	public MobileElement helpIcon;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Connected_To_Internet_BOBA_Satellite_Screen_TitleLabel\"]")
	public MobileElement successfullyConnectedToInternetTitle;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Connected_To_Internet_BOBA_Satellite_Screen_SubTitleLabel\"]")
	public MobileElement successfullyConnectedToInternetSubTitle;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Connected_To_Internet_BOBA_Satellite_Screen_Button\"]")
	public MobileElement nextButton;
	

	public AddSatelliteSuccessfullyConnectedToInternetPage() {
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
	
	public boolean clickHelpButton() {
		if (helpIcon.isDisplayed()) {
			click(helpIcon);
			utils.log().info("Clicked on Help Button");
			return true;
		} else {
			utils.log().info("Help Button is not displayed");
			return false;
		}
	}

	@Override
	public boolean isAt() {
		if (successfullyConnectedToInternetTitle.isDisplayed()) {
			utils.log().info("On SUCESSFULLY CONNECTED TO THE INTERNET Page");
			return true;
		} else {
			utils.log().info("Not on SUCESSFULLY CONNECTED TO THE INTERNET Page");
			return false;
		}
	}
}
