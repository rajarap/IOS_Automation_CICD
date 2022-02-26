package com.cs.arris.Pages;

import org.openqa.selenium.support.PageFactory;

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

public class NetworkLANDHCPLeaseNoChangesUpdatedDialog extends ParentClass implements Page {
	public TestUtils utils = new TestUtils();
	
	@AndroidFindBy(id = "com.arris.sbcBeta:id/cancel_dialog")
	public MobileElement closeButton;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/error_description")
	public MobileElement description;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/ok_dialog")
	public MobileElement okButton;

	
	public NetworkLANDHCPLeaseNoChangesUpdatedDialog() {
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}

	public boolean clickOKButton() {
		if (okButton.isDisplayed()) {
			click(okButton);
			utils.log().info("Clicked on OK Button");
			return true;
		} else {
			utils.log().info("OK Button is not displayed");
			return false;
		}
	}
	
	public boolean clickCloseButton() {
		if (closeButton.isDisplayed()) {
			click(closeButton);
			utils.log().info("Clicked on Close Button");
			return true;
		} else {
			utils.log().info("Close Button is not displayed");
			return false;
		}
	}

	@Override
	public boolean isAt() {
		if (description.isDisplayed()) {
			utils.log().info("On No Changes are updated Dialog");
			return true;
		} else {
			utils.log().info("Not on No Changes are updated Dialog");
			return false;
		}
	}
}
