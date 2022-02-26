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

public class NetworkLANSubnetDHCPChangeIPRangeConfigurationAlertDialog extends ParentClass implements Page {
	public TestUtils utils = new TestUtils();

	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Network_Settings_Lan_Subnet_Config_Screen_Button_AlertClose\"]")
	public MobileElement closeButton;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Network_Settings_Lan_Subnet_Config_Screen_Label_Alert\"]") 
	public MobileElement alertTitle;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Network_Settings_Lan_Subnet_Config_Screen_Label_Port\"]") 
	public MobileElement alertDescription;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Network_Settings_Lan_Subnet_Config_Screen_Button_AlertOk\"]") 
	public MobileElement okButton;
	
	public NetworkLANSubnetDHCPChangeIPRangeConfigurationAlertDialog() {
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}

	public boolean clickCloseButton() {
		if (closeButton.isDisplayed()) {
			click(closeButton);
			utils.log().info("Clicked on Close Button");
			return true;
		} else {
			utils.log().info("Close button is not displayed");
			return false;
		}
	}
	
	public boolean clickOKButton() {
		if (okButton.isDisplayed()) {
			click(okButton);
			utils.log().info("Clicked on OK Button");
			return true;
		} else {
			utils.log().info("OK button is not displayed");
			return false;
		}
	}

	@Override
	public boolean isAt() {
		if (alertDescription.isDisplayed()) {
			utils.log().info("On Changing LAN DHCP Subnet IP Configuration Alert Dialog");
			return true;
		} else {
			utils.log().info("Not on Changing LAN DHCP Subnet IP Configuration Alert Dialog");
			return false;
		}
	}
}
