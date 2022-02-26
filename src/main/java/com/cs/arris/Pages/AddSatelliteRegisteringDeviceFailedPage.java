package com.cs.arris.Pages;

import org.apache.commons.lang3.time.StopWatch;
import org.openqa.selenium.support.PageFactory;

import com.cs.arris.Base.ParentClass;
import com.cs.arris.Interface.Page;
import com.cs.arris.Utilities.TestUtils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.touch.offset.PointOption;

public class AddSatelliteRegisteringDeviceFailedPage extends ParentClass implements Page {
	public TestUtils utils = new TestUtils();
	public TouchAction action = new TouchAction(getDriver());
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"BOBAHelp\"]")
	public MobileElement helpIcon;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"BOBA Arrow\"]")
	public MobileElement backIcon;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"OB_Error_Screen_Image\"]")
	public MobileElement image;
		
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"OB_Error_Screen_TitleLabel\"]")
	public MobileElement registeringDeviceFailedTitle;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"OB_Error_Screen_SubTitleLabel\"]")
	public MobileElement registeringDeviceFailedSubTitle;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"OB_Error_Screen_Button\"]")
	public MobileElement continueButton;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"OB_Error_Screen_Button\"]")
	public MobileElement errCode0000_2207;
	

	public AddSatelliteRegisteringDeviceFailedPage() {
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
	
	public void checkError() {
		int x = 187;
		int y = 458;
		PointOption p = new PointOption();
		p.withCoordinates(x, y);
		
		for(int i=0; i <= 7; i++) {
			action.tap(p);
			action.release().perform();
		}
	}

	@Override
	public boolean isAt() {
		if (registeringDeviceFailedTitle.isDisplayed()) {
			utils.log().info("On Registration of your device failed Page");
			return true;
		} else {
			utils.log().info("Not on Registration of your device failed Page");
			return false;
		}
	}
}
