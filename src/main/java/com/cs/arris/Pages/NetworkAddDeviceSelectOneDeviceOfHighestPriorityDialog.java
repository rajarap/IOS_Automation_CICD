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

public class NetworkAddDeviceSelectOneDeviceOfHighestPriorityDialog extends ParentClass implements Page {
	public TestUtils utils = new TestUtils();

	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Error_Alert_Screen_TitleLabel\"]")
	public MobileElement title;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Error_Alert_Screen_SubTitleLabel\"]")
	public MobileElement description;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeImage[@name=\"Error_Alert_Screen_Image_Close\"]")
	public MobileElement closeIcon;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Error_Alert_Screen_Button\"]")
	public MobileElement okButton;

	public NetworkAddDeviceSelectOneDeviceOfHighestPriorityDialog() {
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
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

	public boolean clickCloseButton() {
		if (closeIcon.isDisplayed()) {
			click(closeIcon);
			utils.log().info("Clicked on Close Button");
			return true;
		} else {
			utils.log().info("Close Button is not displayed");
			return false;
		}
	}

	@Override
	public boolean isAt() {
		if (description.isDisplayed()) {
			utils.log().info(description.getText() + " is displayed");
			return true;
		} else {
			utils.log().info("Not on Add Device - Only one device can be at Highest Priority Dialog");
			return false;
		}
	}
}
