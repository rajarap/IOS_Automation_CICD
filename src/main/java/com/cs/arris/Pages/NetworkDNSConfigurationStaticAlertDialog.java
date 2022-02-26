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

public class NetworkDNSConfigurationStaticAlertDialog extends ParentClass implements Page
{
	public TestUtils utils = new TestUtils();
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Network_DNS_Configuration_Screen_Label_Alert\"]")
	public MobileElement alertTitle; 
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Network_DNS_Configuration_Screen_Label_Warning\"]")
	public MobileElement alertMessage; 
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Network_DNS_Configuration_Screen_Button_AlertOk\"]")
	public MobileElement okButton;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Network_DNS_Configuration_Screen_Button_AlertClose\"]") 
	public MobileElement cancelDialogIcon; 
		
	public NetworkDNSConfigurationStaticAlertDialog()
	{
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}
	
	public void clickOKButton() {
		try {
			click(okButton);
			utils.log().info("Alert Dialog - Clicked on OK Button");
		} catch (Exception e) {
			utils.log().info("Alert Dialog - OK is not displayd");
		}
	}

	public void clickCloseDialog() {
		try {
			click(cancelDialogIcon);
			utils.log().info("Alert Dialog - Clicked on Close Icon");
		} catch (Exception e) {
			utils.log().info("Alert Dialog - Close Icon is not displayd");
		}
	}

	@Override
	public boolean isAt() {
		if (alertTitle.isDisplayed()) {
			utils.log().info("On Alert Dialog Page");
			return true;
		} else {
			utils.log().info("Not on Alert Dialog Page");
			return false;
		}
	}
}
