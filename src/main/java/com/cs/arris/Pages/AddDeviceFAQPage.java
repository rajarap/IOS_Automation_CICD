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

public class AddDeviceFAQPage extends ParentClass implements Page {
	public TestUtils utils = new TestUtils();

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"FAQ_Screen_NavigationBarTitle\"]")
	public MobileElement FAQTitle;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"FAQ_Screen_Button_NavigationBarHelp\"]")
	public MobileElement helpIcon;

	public AddDeviceFAQPage() {
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
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
		if (FAQTitle.isDisplayed()) {
			utils.log().info("On Add Device - FAQ Page");
			return true;
		} else {
			utils.log().info("Not on Add Device - FAQ Page");
			return false;
		}
	}
}