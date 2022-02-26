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

public class NetworkWANSettingsHelpPage extends ParentClass implements Page {
	public TestUtils utils = new TestUtils();

	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"cross\"]")
	public MobileElement closeButton;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"WAN Settings\"]") 
	public MobileElement wanSettingstitle;
	
//	@AndroidFindBy(xpath = "//android.widget.TextView[@bounds='[52,731][1029,968]']")
//	public MobileElement controlAndConfigure;
//	
//	@AndroidFindBy(xpath = "//android.widget.TextView[@bounds='[157,1012][1029,1640]']")
//	public MobileElement dhcp;
//	
//	@AndroidFindBy(xpath = "//android.widget.TextView[@bounds='[157,1637][1029,1952]']")
//	public MobileElement dns;
//	
//	@AndroidFindBy(xpath = "//android.widget.TextView[@bounds='[157,1640][1015,2042]']")
//	public MobileElement wanIPRenew;
	
	public NetworkWANSettingsHelpPage() {
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}

	public boolean clickCloseButton() {
		super.swipeUp();
		if (closeButton.isDisplayed()) {
			click(closeButton);
			utils.log().info("Clicked on Close Button");
			return true;
		} else {
			utils.log().info("Close button is not displayed");
			return false;
		}
	}

	@Override
	public boolean isAt() {
		if (wanSettingstitle.isDisplayed()) {
			utils.log().info("On WAN Settings Help Page");
			return true;
		} else {
			utils.log().info("Not on WAN Settings Help Page");
			return false;
		}
	}
}
