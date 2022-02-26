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

public class NetworkGeneralSettingsBridgeModeInfoDialog extends ParentClass implements Page {
	public TestUtils utils = new TestUtils();

	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"General_Network_Settings_Screen_Button_InfoClose\"]")
	public MobileElement closeButton;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"General_Network_Settings_Screen_Label_InfoTitle\"]") 
	public MobileElement bridgeModetitle;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"General_Network_Settings_Screen_Label_InfoSubTitle\"]")
	public MobileElement bridgeModedescription;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"General_Network_Settings_Screen_Button_InfoOk\"]") 
	public MobileElement okButton;
	
	
	public NetworkGeneralSettingsBridgeModeInfoDialog() {
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


	@Override
	public boolean isAt() {
		if (bridgeModetitle.isDisplayed()) {
			utils.log().info("On Bridge Mode Info Dialog");
			return true;
		} else {
			utils.log().info("Not on Bridge Mode Info Dialog");
			return false;
		}
	}
}
