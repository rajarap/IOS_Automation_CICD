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

public class AddDeviceAccessCameraDialog extends ParentClass implements Page {
	public TestUtils utils = new TestUtils();

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Allow_Camera_Screen_TitleLabel\"]")
	public MobileElement accessCameraTitle;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Allow_Camera_Screen_SubTitleLabel\"]")
	public MobileElement description;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"Allow_Camera_Screen_Image_Close\"]")
	public MobileElement closeIcon;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Allow_Camera_Screen_Button\"]")
	public MobileElement okButton;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"ENTER MANUALLY\"]")
	public MobileElement enterManuallyButton;

	public AddDeviceAccessCameraDialog() {
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

	public boolean clickEnterManuallyButton() {
		if (enterManuallyButton.isDisplayed()) {
			click(enterManuallyButton);
			utils.log().info("Clicked on Enter Manully Button");
			return true;
		} else {
			utils.log().info("Enter Manully Button is not displayed");
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

	public boolean verifyAccessCameraDialogUI() {
		try {
			if (accessCameraTitle.isDisplayed())
				utils.log().info(accessCameraTitle.getText() + " text is displayed");
			else
				utils.log().info("THE APPLICATION WOULD LIKE TO ACCESS THE CAMERA Text is not displayed");

			if (description.isDisplayed())
				utils.log().info(description.getText() + " text is displayed");
			else
				utils.log().info("Application requries access Text is not displayed");

			if (closeIcon.isDisplayed())
				utils.log().info("Close icon is displayed");
			else
				utils.log().info("Close icon is not displayed");

			if (okButton.isDisplayed())
				utils.log().info("OK button is displayed");
			else
				utils.log().info("OK button is not displayed");

			if (enterManuallyButton.isDisplayed())
				utils.log().info("Enter Manually button is displayed");
			else
				utils.log().info("Enter Manually button is not displayed");

			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean isAt() {
		if (accessCameraTitle.isDisplayed()) {
			utils.log().info("On Add Device - THE APPLICATION WOULD LIKE TO ACCESS THE CAMERA Dialog");
			return true;
		} else {
			utils.log().info("Not on Add Device - THE APPLICATION WOULD LIKE TO ACCESS THE CAMERA Dialog");
			return false;
		}
	}
}
