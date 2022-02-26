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

public class AddSatelliteInstallAdditionalSatelliteDialog extends ParentClass implements Page {
	public TestUtils utils = new TestUtils();

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Install_Additional_Satellite_Screen_TitleLabel\"]")
	public MobileElement installAdditionalSatelliteTitle;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Install_Additional_Satellite_Screen_SubTitleLabel\"]")
	public MobileElement description;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"Install_Additional_Satellite_Screen_Image\"]")
	public MobileElement closeIcon;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Install_Additional_Satellite_Screen_Button_Now\"]")
	public MobileElement installNowButton;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Install_Additional_Satellite_Screen_Button_Later\"]")
	public MobileElement cancelButton;

	public AddSatelliteInstallAdditionalSatelliteDialog() {
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}

	public boolean clickInstallSatelliteButton() {
		if (installNowButton.isDisplayed()) {
			click(installNowButton);
			utils.log().info("Clicked on Install Now Button");
			return true;
		} else {
			utils.log().info("Install Now Button is not displayed");
			return false;
		}
	}

	public boolean clickCancelButton() {
		if (cancelButton.isDisplayed()) {
			click(cancelButton);
			utils.log().info("Clicked on Cancel Button");
			return true;
		} else {
			utils.log().info("Cancel Button is not displayed");
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

	@Override
	public boolean isAt() {
		if (installAdditionalSatelliteTitle.isDisplayed()) {
			utils.log().info("On INSTALL ADDITIONAL SATELLITE Dialog");
			return true;
		} else {
			utils.log().info("Not on INSTALL ADDITIONAL SATELLITE Dialog");
			return false;
		}
	}
}
