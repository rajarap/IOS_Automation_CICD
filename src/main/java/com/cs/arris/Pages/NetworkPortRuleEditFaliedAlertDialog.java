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

public class NetworkPortRuleEditFaliedAlertDialog extends ParentClass implements Page {
	public TestUtils utils = new TestUtils();

	@iOSXCUITFindBy(xpath="//XCUIElementTypeImage[@name=\"closeIcon\"]")
	public MobileElement closeButton;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Failed to configure Port Forwarding Rule.\"]")
	public MobileElement errorDescription;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"OK\"]")
	public MobileElement okButton;

	public NetworkPortRuleEditFaliedAlertDialog() {
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

	public boolean clickOKButton() {
		if (okButton.isDisplayed()) {
			click(okButton);
			utils.log().info("Clicked on OK Changes Button");
			return true;
		} else {
			utils.log().info("OK button is not displayed");
			return false;
		}
	}

	@Override
	public boolean isAt() {
		if (errorDescription.isDisplayed()) {
			utils.log().info("On Failed To Update Port Forwarding Details Dialog");
			return true;
		} else {
			utils.log().info("Not on Failed To Update Port Forwarding Details Dialog");
			return false;
		}
	}
}
