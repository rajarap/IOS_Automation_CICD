package com.cs.arris.Pages;

import org.apache.commons.lang3.time.StopWatch;
import org.openqa.selenium.support.PageFactory;

import com.cs.arris.Base.ParentClass;
import com.cs.arris.Interface.Page;
import com.cs.arris.Utilities.TestUtils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.touch.offset.PointOption;

public class AddDeviceRegistrationFailedPage extends ParentClass implements Page {
	public TestUtils utils = new TestUtils();
	public TouchAction action = new TouchAction(getDriver());

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"OB_Error_Screen_TitleLabel\"]")
	public MobileElement registrationFailedTitle;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"NavigationBar_Button_Back\"]")
	public MobileElement backIcon;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"NavigationBar_Button_Help\"]")
	public MobileElement helpIcon;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"OB_Error_Screen_SubTitleLabel\"]")
	public MobileElement description;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"OB_Error_Screen_Label\"]")
	public MobileElement errorCode; // 0000-1506

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"OB_Error_Screen_Button\"]")
	public MobileElement continueButton;

	public AddDeviceRegistrationFailedPage() {
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

	public boolean clickHelpButton() {
		if (helpIcon.isDisplayed()) {
			click(helpIcon);
			return true;
		} else {
			utils.log().info("Help button is not displayed");
			return false;
		}
	}

	public boolean clickContinueButton() {
		if (continueButton.isDisplayed()) {
			click(continueButton);
			super.pause(10);
			utils.log().info("Clicked Continue Button on Device Registration Failed Page");
			return true;
		} else {
			utils.log().info("Continue Button is not displayed");
			return false;
		}
	}
	
	public void checkError() {
		int x = 180;
		int y = 455;
		PointOption p = new PointOption();
		p.point(x, y);
		
		for(int i=0; i <=7; i++) {
			action.tap(p);
			action.release().perform();
		}
	}
	
	public boolean verifyDeviceRegistrationFailedPageUI() {
		try {
			if (registrationFailedTitle.isDisplayed())
				utils.log().info(registrationFailedTitle.getText() + " text is displayed");
			else
				utils.log().info("Registration of your device failed Text is not displayed");

//			if (backIcon.isDisplayed())
//				utils.log().info("Back button is displayed");
//			else
//				utils.log().info("Back button is not displayed");

			if (helpIcon.isDisplayed())
				utils.log().info("Help icon is displayed");
			else
				utils.log().info("Help icon is not displayed");

			if (description.isDisplayed())
				utils.log().info(description.getText() + " text is displayed");
			else
				utils.log().info("We are experiencing an issue connecting with our back office text is not displayed");

			if (errorCode.isDisplayed())
				utils.log().info(errorCode.getText() + " text is displayed");
			else
				utils.log().info("No Error code is displayed");

			if (continueButton.isDisplayed())
				utils.log().info(continueButton.getText() + " button is displayed");
			else
				utils.log().info("CONTINUE button is not displayed");

			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean isAt() {
		if (registrationFailedTitle.isDisplayed()) {
			utils.log().info("On Add Device - Registration of your device failed Page");
			return true;
		} else {
			utils.log().info("Not on Add Device - Registration of your device failed Page");
			return false;
		}
	}
}