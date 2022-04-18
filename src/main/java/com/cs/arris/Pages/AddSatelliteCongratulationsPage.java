package com.cs.arris.Pages;

import org.openqa.selenium.support.PageFactory;

import com.cs.arris.Base.ParentClass;
import com.cs.arris.Interface.Page;
import com.cs.arris.Utilities.TestUtils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class AddSatelliteCongratulationsPage extends ParentClass implements Page {
	public TestUtils utils = new TestUtils();
	
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"BOBA_Satellite_Congratulations_Screen_TitleLabel\"]")
	public MobileElement congratulationsTitle;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"BOBA_Satellite_Congratulations_Screen_SubTitleLabel\"]")
	public MobileElement congratulationsSubTitle;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"BOBA_Satellite_Congratulations_Screen_Image\"]")
	public MobileElement image;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"BOBA_Satellite_Congratulations_Screen_Button\"]")
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
