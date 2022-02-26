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

public class SettingsHelpPage extends ParentClass implements Page {
	public TestUtils utils = new TestUtils();

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"cross\"]")
	public MobileElement closeButton;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"This page provides information about your Account.\"]")
	public MobileElement settingsText;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Settings\"]")
	public MobileElement settingsTitle;

	public SettingsHelpPage() {
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}

	public boolean clickCloseButton() {
		if (closeButton.isDisplayed()) {
			super.swipeUp();
			click(closeButton); 
			utils.log().info("Clicked Close Button");
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean isAt() {
		if (settingsTitle.isDisplayed()) {
			utils.log().info("On Settings Help Page");
			return true;
		} else {
			utils.log().info("Not on Settings Help Page");
			return false;
		}
	}

}
