package com.cs.arris.Pages;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.cs.arris.Base.ParentClass;
import com.cs.arris.Interface.Page;
import com.cs.arris.Utilities.TestUtils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class AboutHelpPage extends ParentClass implements Page {
	public TestUtils utils = new TestUtils();

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"cross\"]")
	public MobileElement closeButton;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"About\"]")
	public MobileElement aboutText;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"This page provides information about your Application and Firmware version.\"]")
	public MobileElement aboutHelpText;
	
	public AboutHelpPage() {
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}

	public boolean clickCloseButton() {
		super.swipeUp();
		if (closeButton.isDisplayed()) {
			click(closeButton); 
			utils.log().info("Clicked Close Button");
			return true;
		} else {
			return false;
		}
	}

	public void verifyUIOnAboutHelpPage() {
		try {
			if (aboutHelpText.isDisplayed())
				utils.log().info(aboutHelpText.getText() + " Text is displayed ");
		} catch (Exception e) {
			utils.log().info("Information about Application and Firwnware Version is not displayed");
		}
	}

	@Override
	public boolean isAt() {
		if (aboutText.isDisplayed()) {
			utils.log().info("On About Help Page");
			return true;
		} else {
			utils.log().info("Not on About Help Page");
			return false;
		}

	}

}
