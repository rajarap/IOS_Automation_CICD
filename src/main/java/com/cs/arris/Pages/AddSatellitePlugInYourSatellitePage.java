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

public class AddSatellitePlugInYourSatellitePage extends ParentClass implements Page {
	public TestUtils utils = new TestUtils();
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"BOBAHelp\"]")
	public MobileElement helpIcon;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"BOBA Arrow\"]")
	public MobileElement backIcon;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Plug_In_BOBA_Satellite_Screen_TitleLabel\"]")
	public MobileElement plugInYourSatelliteTitle;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Plug_In_BOBA_Satellite_Screen_SubTitleLabel\"]")
	public MobileElement plugInYourSatelliteSubTitle;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Plug_In_BOBA_Satellite_Screen_Button\"]")
	public MobileElement nextButton;
	

	public AddSatellitePlugInYourSatellitePage() {
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
		if (plugInYourSatelliteTitle.isDisplayed()) {
			utils.log().info("On PLUG IN YOUR SATELLITE Page");
			return true;
		} else {
			utils.log().info("Not on PLUG IN YOUR SATELLITE Page");
			return false;
		}
	}
}
