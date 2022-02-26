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

public class HomePageRATTroubleShootPage extends ParentClass implements Page {
	public TestUtils utils = new TestUtils();

	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Network Optimization\"]")
	public MobileElement troubleShootTitle;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Remote access to your Network is currently unavailable.\"]")
	public MobileElement remoteAccessNotAvailableSubTitle;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"BOBA Arrow\"]")
	public MobileElement backIcon;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"OK\"]")
	public MobileElement okButton;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"CONTINUE ONBOARDING\"]")
	public MobileElement continueOnBoarding;

	public HomePageRATTroubleShootPage() {
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
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
	
	public boolean clickOkButton() {
		if (okButton.isDisplayed()) {
			click(okButton);
			utils.log().info("Clicked on OK Button");
			return true;
		} else {
			utils.log().info("OK Button is not displayed");
			return false;
		}
	}
	
	public boolean clickContinueOnBoardingButton() {
		if (continueOnBoarding.isDisplayed()) {
			click(continueOnBoarding);
			utils.log().info("Clicked on Continue On-Boarding Button");
			return true;
		} else {
			utils.log().info("Continue On-Boarding Button is not displayed");
			return false;
		}
	}

	@Override
	public boolean isAt() {
		if (troubleShootTitle.isDisplayed()) {
			utils.log().info("On Add Device - User Guide Page");
			return true;
		} else {
			utils.log().info("Not on Add Device - User Guide Page");
			return false;
		}
	}
}