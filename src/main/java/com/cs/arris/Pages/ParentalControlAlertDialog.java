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

public class ParentalControlAlertDialog extends ParentClass implements Page {
	public TestUtils utils = new TestUtils();

	@AndroidFindBy(id = "com.arris.sbcBeta:id/cancel_dialog") // click the X icon
	public MobileElement closeDialog;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/error_header_dialog") // Alert
	public MobileElement alertTitle;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/error_description") // Enable Parental control to see Blocked Profiles
	public MobileElement alertText;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/ok_dialog") // OK
	public MobileElement okButton;

	public ParentalControlAlertDialog() {
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}

	public void clickCloseButton() {
		try {
			click(closeDialog);
			utils.log().info("Parental Control Alert Dialog - Clicked on Close Button");
		} catch (Exception e) {
			utils.log().info("Parental Control Alert Dialog - Close Button is not displayed");
		}

	}

	public void clickOkButton() {
		try {
			click(okButton);
			utils.log().info("Parental Control Alert Dialog - Clicked on OK Button");
		} catch (Exception e) {
			utils.log().info("Parental Control Alert Dialog - OK Button is not displayed");
		}
	}

	public void verifyUIOnAboutHelpPage() {
		try {
			if (alertTitle.isDisplayed())
				utils.log().info(alertTitle.getText() + " text is displayed ");
		} catch (Exception e) {
			utils.log().info("Alert title text is not displayed");
		}

		try {
			if (alertText.isDisplayed())
				utils.log().info(alertText.getText() + " text is displayed ");
		} catch (Exception e) {
			utils.log().info("Enable Parental control to see Blocked Profiles text is not displayed");
		}

		try {
			if (closeDialog.isDisplayed())
				utils.log().info("Close Icon is displayed on Parental Control Alert Page");
		} catch (Exception e) {
			utils.log().info("Close Icon is not displayed on Parental Control Alert Page");
		}

		try {
			if (okButton.isDisplayed())
				utils.log().info("OK button is displayed on Parental Control Alert Page");
		} catch (Exception e) {
			utils.log().info("OK button is not displayed on Parental Control Alert Page");
		}
	}

	@Override
	public boolean isAt() {
		if (alertTitle.isDisplayed()) {
			utils.log().info("On Parental Control Alert Dialog");
			return true;
		} else {
			utils.log().info("Not on Parental Control Alert Dialog");
			return false;
		}
	}
}
