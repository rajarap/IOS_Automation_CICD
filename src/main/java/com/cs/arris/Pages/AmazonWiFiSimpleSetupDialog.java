package com.cs.arris.Pages;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.cs.arris.Base.ParentClass;
import com.cs.arris.Interface.Page;
import com.cs.arris.Utilities.Direction;
import com.cs.arris.Utilities.SwipeActions;
import com.cs.arris.Utilities.TestUtils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class AmazonWiFiSimpleSetupDialog extends ParentClass implements Page {
	public TestUtils utils = new TestUtils();


	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Error_Alert_Screen_Button_Close\"]")
	public MobileElement closeButton;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Error_Alert_Screen_TitleLabel\"]")
	public MobileElement wifisetup;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Error_Alert_Screen_Button\"]")
	public MobileElement okButton;
	
	
	//Amazon Features Updated
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"Error_Alert_Screen_Image_Close\"]")
	public MobileElement closeIcon;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Error_Alert_Screen_TitleLabel\"]")
	public MobileElement amazonFeatureUpdateText;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Error_Alert_Screen_SubTitleLabel\"]")
	public MobileElement successText;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Error_Alert_Screen_Button\"]")
	public MobileElement okbutton;
	
	
	public AmazonWiFiSimpleSetupDialog() {
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}

	public boolean clickCloseButton() {
		if (closeButton.isDisplayed()) {
			click(closeButton);
			utils.log().info("Clicked on Close Button");
			return true;
		} else {
			utils.log().info("Close button is not displayed");
			return false;
		}
	}
	
	public boolean clickCloseIcon() {
		if (closeIcon.isDisplayed()) {
			click(closeIcon);
			utils.log().info("Clicked on Close Icon");
			return true;
		} else {
			utils.log().info("Close Icon is not displayed");
			return false;
		}
	}
	
	public boolean clickOKButton() {
		if (okButton.isDisplayed()) {
			click(okButton);
			utils.log().info("Clicked on OK Button");
			return true;
		} else {
			utils.log().info("OK button is not displayed");
			return false;
		}
	}
	public boolean clickOKbutton() {
		if (okbutton.isDisplayed()) {
			click(okbutton);
			utils.log().info("Clicked on OK Button");
			return true;
		} else {
			utils.log().info("OK button is not displayed");
			return false;
		}
	}

	@Override
	public boolean isAt() {
		if (wifisetup.isDisplayed()) {
			utils.log().info("On Amazon Wi-Fi Simple Setup dialog");
			return true;
		} else {
			utils.log().info("Not on Amazon Wi-Fi Simple Setup Dialog");
			return false;
		}
	}
}
