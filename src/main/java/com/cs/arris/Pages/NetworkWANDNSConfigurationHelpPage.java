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

public class NetworkWANDNSConfigurationHelpPage extends ParentClass implements Page {
	public TestUtils utils = new TestUtils();

	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"cross\"]")
	public MobileElement closeButton;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"DNS Configuration\"]")
	public MobileElement wanIDNSConfigurationTitle;
	
	public NetworkWANDNSConfigurationHelpPage() {
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}

	public boolean clickCloseButton() {
		try {
			if (closeButton.isDisplayed()) {
				click(closeButton);
				utils.log().info("Clicked on Close Button");}
			return true;
		} catch (Exception e) {
			utils.log().info("Close button is not displayed");
			return false;
		}
	}

	@Override
	public boolean isAt() {
		if (wanIDNSConfigurationTitle.isDisplayed()) {
			utils.log().info("On WAN DNS Configuration Help Page");
			return true;
		} else {
			utils.log().info("Not on WAN DNS Configuration Help Page");
			return false;
		}
	}
}
