package com.cs.arris.Pages;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.cs.arris.Base.ParentClass;
import com.cs.arris.Interface.Page;
import com.cs.arris.Utilities.Direction;
import com.cs.arris.Utilities.SwipeActions;
import com.cs.arris.Utilities.TestUtils;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class ParentalControlUserProfileHelpPage extends ParentClass implements Page {
	public TestUtils utils = new TestUtils();

	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"cross\"]")
	public MobileElement closeButton;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Parental Control Profile\"]")
	public MobileElement parentalCaontrolProfiletitle;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Remind me later\"]")
	public MobileElement profileView;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Remind me later\"]")
	public MobileElement profileText;

	public ParentalControlUserProfileHelpPage() {
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}

	public boolean clickCloseButton() {
		String selector = "**/XCUIElementTypeButton[`label == \"cross\"`]";
		if (super.getDriver().findElement(MobileBy.iOSClassChain(selector)).isDisplayed()) {
			super.swipeUp();
			super.getDriver().findElement(MobileBy.iOSClassChain(selector)).click();;
			utils.log().info("Clicked on Close Button");
			return true;
		} else {
			utils.log().info("Close button is not displayed");
			return false;
		}
	}

	public boolean verifyUIOnUserProfilePage() {
		try {
			if (parentalCaontrolProfiletitle.isDisplayed())
				utils.log().info(parentalCaontrolProfiletitle.getText() + " title is displayed ");
			else
				utils.log().info("Parental Control Profile title is not displayed");

			if (profileView.isDisplayed())
				utils.log().info(profileView.getText() + " text is displayed ");
			else
				utils.log().info("Profile View Text is not displayed");

			if (profileText.isDisplayed())
				utils.log().info("Profile Help Text is displayed ");
			else
				utils.log().info("Profile Help Text is not displayed");
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean isAt() {
		if (parentalCaontrolProfiletitle.isDisplayed()) {
			utils.log().info("On Parental Control Profile Help Page");
			return true;
		} else {
			utils.log().info("Not on Parental Control Profile Help Page");
			return false;
		}
	}
}
