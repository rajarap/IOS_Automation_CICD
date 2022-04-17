package com.cs.arris.Pages;

import org.openqa.selenium.support.PageFactory;
import com.cs.arris.Base.ParentClass;
import com.cs.arris.Interface.Page;
import com.cs.arris.Utilities.TestUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;


public class BlueToothConnectionFailedTroubleShootPage extends ParentClass implements Page
{
	TestUtils utils = new TestUtils();
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"OB_Error_Screen_TitleLabel\"]")
	public MobileElement bluetoothConnectionFailedTitle;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"OB_Error_Screen_SubTitleLabel\"]")
	public MobileElement bluetoothConnectionMessage;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"OB_Error_Screen_Label\"]")
	public MobileElement bluetoothConnectionErrorCode;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"OB_Error_Screen_Button\"]")
	public MobileElement bluetoothConnectionFailedTroubleShootButton;
	
	public BlueToothConnectionFailedTroubleShootPage()
	{
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}

	public boolean clickTroubleShootButton()
	{
		if(bluetoothConnectionFailedTroubleShootButton.isDisplayed())	{
			click(bluetoothConnectionFailedTroubleShootButton);
			utils.log().info("Clicked on TroubleShoot Button");
			return true;
		}else {
			return false;
		}
	}
	
	@Override
	public boolean isAt() {
		 if(bluetoothConnectionFailedTitle.isDisplayed()){
	        	utils.log().info("On Bluetooth Connection failed Page");
	        	return true;
	      }else{
	        //	utils.log().info("Not on Bluetooth Connection failed Page");
	        	return false;}
	}
	
}

