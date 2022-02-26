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

public class AddDeviceCongratulationsPage extends ParentClass implements Page {
	public TestUtils utils = new TestUtils();

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Congratulation_CMInstall_Screen_TitleLabel\"]")
	public MobileElement congratulationsTitle;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"NavigationBar_Button_Help\"]")
	public MobileElement helpIcon;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Congratulation_CMInstall_Screen_SubTitleLabel\"]")
	public MobileElement description;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Congratulation_CMInstall_Screen_Button\"]")
	public MobileElement continueButton;

	public AddDeviceCongratulationsPage() {
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}

	public boolean clickHelpButton() {
		if (helpIcon.isDisplayed()) {
			click(helpIcon);
			return true;
		} else {
			utils.log().info("Help button is not displayed");
			return false;
		}
	}

	public boolean clickContinueButton() {
		if (continueButton.isDisplayed()) {
			click(continueButton);
			super.pause(5);
			utils.log().info("Clicked on Continue Button on Congratulations Page");
			return true;
		} else {
			utils.log().info("Continue Button is not displayed");
			return false;
		}
	}

	public boolean verifyCongratulationsPageUI() {
		try {
			if (congratulationsTitle.isDisplayed())
				utils.log().info(congratulationsTitle.getText() + " text is displayed");
			else
				utils.log().info("CONGRATULATIONS Text is not displayed");

			if (helpIcon.isDisplayed())
				utils.log().info("Help icon is displayed");
			else
				utils.log().info("Help icon is not displayed");

			if (description.isDisplayed())
				utils.log().info(description.getText() + " text is displayed");
			else
				utils.log().info("You can now connect your Wi-Fi router text is not displayed");

			if (continueButton.isDisplayed())
				utils.log().info(continueButton.getText() + " button is displayed");
			else
				utils.log().info("CONTINUE button is not displayed");

			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean isAt() {
		if (congratulationsTitle.isDisplayed()) {
			utils.log().info("On Add Device -  CONGRATULATIONS Page");
			return true;
		} else {
			utils.log().info("Not on Add Device - CONGRATULATIONS Page");
			return false;
		}
	}
}