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

public class NetworkBandSteeringModeAlertDialog extends ParentClass implements Page {
	public TestUtils utils = new TestUtils();

//	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"cross\"]")
//	public MobileElement closeButton;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Network_Settings_Screen_Label_Alert\"]") 
	public MobileElement alertTitle;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Network_Settings_Screen_Label_DFS\"]") 
	public MobileElement alertDescription;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Network_Settings_Screen_Button_DFSOk\"]")
	public MobileElement okButton;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Network_Settings_Screen_Button_DFSCancel\"]") 
	public MobileElement cancelButton;
	
	
	public NetworkBandSteeringModeAlertDialog() {
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}

//	public boolean clickCloseButton() {
//		if (closeButton.isDisplayed()) {
//			click(closeButton);
//			utils.log().info("Clicked on Close Button");
//			return true;
//		} else {
//			utils.log().info("Close button is not displayed");
//			return false;
//		}
//	}
	
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
	
	public boolean clickCancelButton() {
		if (cancelButton.isDisplayed()) {
			click(cancelButton);
			utils.log().info("Clicked on Cancel Button");
			return true;
		} else {
			utils.log().info("OK button is Cancel displayed");
			return false;
		}
	}

	@Override
	public boolean isAt() {
		if (alertTitle.isDisplayed()) {
			utils.log().info("On Band Steering Mode Alert Dialog");
			return true;
		} else {
			utils.log().info("Not on Band Steering Mode Alert Dialog");
			return false;
		}
	}
}
