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

public class AddSatelliteBluetoothConnectionFailedPage extends ParentClass implements Page {
	public TestUtils utils = new TestUtils();
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"BOBAHelp\"]")
	public MobileElement helpIcon;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"OB_Error_Screen_TitleLabel\"]")
	public MobileElement bluetoothConnectionFailedTitle;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"OB_Error_Screen_SubTitleLabel\"]")
	public MobileElement bluetoothConnectionFailedSubTitle;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"OB_Error_Screen_Button\"]")
	public MobileElement tryAgainButton;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"OB_Error_Screen_Label\"]")
	public MobileElement errCode0001_2001;
	

	public AddSatelliteBluetoothConnectionFailedPage() {
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}

	public boolean clickTryAgainButton() {
		if (tryAgainButton.isDisplayed()) {
			click(tryAgainButton);
			utils.log().info("Clicked on Try Again Button");
			return true;
		} else {
			utils.log().info("Try Again  Button is not displayed");
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
		if (bluetoothConnectionFailedTitle.isDisplayed()) {
			utils.log().info("On Bluetooth Connection Failed Page");
			return true;
		} else {
			utils.log().info("Not on Bluetooth Connection Failed Page");
			return false;
		}
	}
}
