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

public class AddSatelliteCongratulationsPage extends ParentClass implements Page {
	public TestUtils utils = new TestUtils();
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"BOBAHelp\"]")
	public MobileElement helpIcon;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Satellite_Congratulations_Screen_TitleLabel\"]")
	public MobileElement congratulationsTitle;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Satellite_Congratulations_Screen_SubTitleLabel\"]")
	public MobileElement congratulationsSubTitle;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Satellite_Congratulations_Screen_Image\"]")
	public MobileElement image;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Satellite_Congratulations_Screen_Button\"]")
	public MobileElement continueButton;
	

	public AddSatelliteCongratulationsPage() {
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}

	public boolean clickContinueButton() {
		if (continueButton.isDisplayed()) {
			click(continueButton);
			utils.log().info("Clicked on Continue Button");
			return true;
		} else {
			utils.log().info("Continue Button is not displayed");
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
		if (congratulationsTitle.isDisplayed()) {
			utils.log().info("On CONGRATULATIONS Page");
			return true;
		} else {
			utils.log().info("Not on CONGRATULATIONS Page");
			return false;
		}
	}
}
