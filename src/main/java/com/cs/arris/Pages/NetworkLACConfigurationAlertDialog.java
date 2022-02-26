package com.cs.arris.Pages;

import org.openqa.selenium.support.PageFactory;

import com.cs.arris.Base.ParentClass;
import com.cs.arris.Interface.Page;
import com.cs.arris.Utilities.TestUtils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class NetworkLACConfigurationAlertDialog extends ParentClass implements Page
{
	public TestUtils utils = new TestUtils();
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Network_Wan_Settings_Screen_Label_Link\"]") 
	public MobileElement lacAlertTitle; 
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Network_Wan_Settings_Screen_Label_LinkSubTitle\"]")
	public MobileElement lacAlertMessage; 
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Network_Wan_Settings_Screen_Button_LacOk\"]")
	public MobileElement okButton;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Network_Wan_Settings_Screen_Button_Close\"]")
	public MobileElement cancelDialogIcon; 
		
	public NetworkLACConfigurationAlertDialog()
	{
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}
	
	public boolean clickOKButton() {
		if (okButton.isDisplayed()) {
			click(okButton);
			utils.log().info("LAC Alert Dialog - Clicked on OK Button");
			return true;
		} else {
			utils.log().info("LAC Alert Dialog - OK is not displayd");
			return false;
		}
	}

	public boolean clickCloseDialog() {
		if (cancelDialogIcon.isDisplayed()) {
			click(cancelDialogIcon);
			utils.log().info("LAC Alert Dialog - Clicked on Close Icon");
			return true;
		} else {
			utils.log().info("LAC Alert Dialog - Close Icon is not displayd");
			return false;
		}
	}

	@Override
	public boolean isAt() {
		if (lacAlertTitle.isDisplayed()) {
			utils.log().info("On LAC Alert Dialog Page");
			return true;
		} else {
			utils.log().info("Not on LAC Alert Dialog Page");
			return false;
		}
	}
}
