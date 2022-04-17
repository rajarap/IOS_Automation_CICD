package com.cs.arris.Pages;

import org.openqa.selenium.support.PageFactory;

import com.cs.arris.Base.ParentClass;
import com.cs.arris.Interface.Page;
import com.cs.arris.Utilities.TestUtils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class AddSatelliteConnectedToNonMaxNetworkPage extends ParentClass implements Page {
	public TestUtils utils = new TestUtils();
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"BOBAHelp\"]")
	public MobileElement helpIcon;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"OB_Error_Screen_TitleLabel\"]")
	public MobileElement connectedToNonMaxNetworkTitle;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"OB_Error_Screen_SubTitleLabel\"]")
	public MobileElement description;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"OB_Error_Screen_Label\"]")
	public MobileElement errorCode1;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"OB_Error_Screen_Button\"]")
	public MobileElement tryAgainButton;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"TRY AGAIN\"]")
	public MobileElement tryAgainStaticText;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"OB_Error_Screen_Label\"]")
	public MobileElement errorCode2;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"OB_Error_Screen_Button\"]")
	public MobileElement troubleShootButton;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"TROUBLESHOOT\"]")
	public MobileElement troubleShootStaticText;

	public AddSatelliteConnectedToNonMaxNetworkPage() {
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}

	public boolean clickTryAgainButton() {
		if (tryAgainButton.isDisplayed()) {
			click(tryAgainButton);
			utils.log().info("Clicked on Try Again Button");
			return true;
		} else {
			utils.log().info("Try Again Button is not displayed");
			return false;
		}
	}
	
	public boolean clickTroubleShootButton() {
		if (troubleShootButton.isDisplayed()) {
			click(troubleShootButton);
			utils.log().info("Clicked on TroubleShoot Button");
			return true;
		} else {
			utils.log().info("TroubleShoot Button is not displayed");
			return false;
		}
	}

	@Override
	public boolean isAt() {
		if (connectedToNonMaxNetworkTitle.isDisplayed()) {
			//utils.log().info("On ADD NEW SATELLITE Page");
			return true;
		} else {
		//	utils.log().info("Not on ADD NEW SATELLITE Page");
			return false;
		}
	}
}
