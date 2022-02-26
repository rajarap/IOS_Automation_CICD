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

public class AddDeviceNotificationsPage extends ParentClass implements Page {
	public TestUtils utils = new TestUtils();

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Notification\"]")
	public MobileElement NotificationsTitle;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"NavigationBar_Button_Back\"]")
	public MobileElement backIcon;

	public AddDeviceNotificationsPage() {
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

	@Override
	public boolean isAt() {
		if (NotificationsTitle.isDisplayed()) {
			utils.log().info("On Add Device - Notifications Page");
			return true;
		} else {
			utils.log().info("Not on Add Device - Notifications Page");
			return false;
		}
	}
}