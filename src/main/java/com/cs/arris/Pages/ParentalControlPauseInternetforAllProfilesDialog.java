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

public class ParentalControlPauseInternetforAllProfilesDialog extends ParentClass implements Page {
	public TestUtils utils = new TestUtils();

	@AndroidFindBy(id = "com.arris.sbcBeta:id/cancel_dialog")
	public MobileElement closeButton;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/error_header_dialog")
	public MobileElement pauseInternetForAllTitle;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/error_description")
	public MobileElement pauseInternetForAllMessage;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/ok_dialog")
	public MobileElement yesPauseButton;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/error_cancel_dialog")
	public MobileElement cancelButton;

	public ParentalControlPauseInternetforAllProfilesDialog() {
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}

	public void clickCloseButton() {
		try {
			click(closeButton);
			utils.log().info("Clicked on Close Button");
		} catch (Exception e) {
			utils.log().info("Close Button is not displayed");
		}
	}

	public void clickYesPauseButton() {
		try {
			click(yesPauseButton);
			utils.log().info("Clicked on Yes Pause Internet Button");
		} catch (Exception e) {
			utils.log().info("Yes Pause Internet Button is not displayed");
		}
	}

	public void clickCancelButton() {
		try {
			click(cancelButton);
			utils.log().info("Clicked on Cancel Button");
		} catch (Exception e) {
			utils.log().info("Cancel is not displayed");
		}
	}

	public void verifyUIOnPauseInternetForAllDialog() {
		try {
			if (pauseInternetForAllTitle.isDisplayed())
				utils.log().info(pauseInternetForAllTitle.getText() + " text is displayed ");
		} catch (Exception e) {
			utils.log().info("Pause Internet For all Profiles text is not displayed");
		}

		try {
			if (pauseInternetForAllMessage.isDisplayed())
				utils.log().info(pauseInternetForAllMessage.getText() + " text is displayed ");
		} catch (Exception e) {
			utils.log().info("Are you sure to block internet for all profiles text is not displayed");
		}

		try {
			if (closeButton.isDisplayed())
				utils.log().info("Close Icon is displayed");
		} catch (Exception e) {
			utils.log().info("Close Icon is not displayed");
		}

		try {
			if (yesPauseButton.isDisplayed())
				utils.log().info("YES, PAUSE INTERNET button is displayed");
		} catch (Exception e) {
			utils.log().info("YES, PAUSE INTERNET button is not displayed");
		}

		try {
			if (cancelButton.isDisplayed())
				utils.log().info("CANCEL button is displayed");
		} catch (Exception e) {
			utils.log().info("CANCEL button is not displayed");
		}
	}

	@Override
	public boolean isAt() {
		if (pauseInternetForAllTitle.isDisplayed()) {
			utils.log().info("On Pause Internet for all Profiles Dialog");
			return true;
		} else {
			utils.log().info("Not On Pause Internet for all Profiles Dialog");
			return false;
		}

	}

}
