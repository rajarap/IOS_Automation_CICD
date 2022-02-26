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

public class NetworkBandSteeringModeInfoDialog extends ParentClass implements Page {
	public TestUtils utils = new TestUtils();

	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Network_Settings_Screen_Button_BandClose\"]")
	public MobileElement closeButton;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Network_Settings_Screen_Label_BandHeader\"]") 
	public MobileElement bandSteeringModeTitle;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Network_Settings_Screen_Label_BandInfo\"]") 
	public MobileElement bandSteeringDescription;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Network_Settings_Screen_Button_BandOk\"]") 
	public MobileElement okButton;
	
	
	public NetworkBandSteeringModeInfoDialog() {
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
		if (bandSteeringModeTitle.isDisplayed()) {
			utils.log().info("On Band Steering Mode Info Dialog");
			return true;
		} else {
			utils.log().info("Not on Band Steering Mode Info Dialog");
			return false;
		}
	}
}
