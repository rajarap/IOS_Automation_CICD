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
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class NetworkLANDHCPLeaseTimeAppliedChangesDialog extends ParentClass implements Page {
	public TestUtils utils = new TestUtils();

	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Network_LAN_DHCP_LeaseTime_Screen_Label_LeaseTime\"]")
	public MobileElement description;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Network_LAN_DHCP_LeaseTime_Screen_Button_SuccessOk\"]")
	public MobileElement okButton;

	
	public NetworkLANDHCPLeaseTimeAppliedChangesDialog() {
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

	@Override
	public boolean isAt() {
		if (description.isDisplayed()) {
			utils.log().info("On Changes Applied Successfully Dialog");
			return true;
		} else {
			utils.log().info("Not on Changes Applied Successfully Dialog");
			return false;
		}
	}
}
