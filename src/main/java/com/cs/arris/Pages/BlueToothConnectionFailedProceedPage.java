package com.cs.arris.Pages;

import org.openqa.selenium.support.PageFactory;
import com.cs.arris.Base.ParentClass;
import com.cs.arris.Interface.Page;
import com.cs.arris.Utilities.TestUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;


public class BlueToothConnectionFailedProceedPage extends ParentClass implements Page
{
	TestUtils utils = new TestUtils();
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Troubleshoot_Screen_TitleLabel\"]")
	public MobileElement bluetoothConnectionFailedTitle;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeWebView[@name=\"Troubleshoot_Screen_WebView_Steps\"]")
	public MobileElement bluetoothConnectionMessage;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Troubleshoot_Screen_Button_Proceed\"]")
	public MobileElement bluetoothConnectionFailedProceedButton;
	
	public BlueToothConnectionFailedProceedPage()
	{
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}

	public boolean clickProceedButton()
	{
		if(bluetoothConnectionFailedProceedButton.isDisplayed())	{
			click(bluetoothConnectionFailedProceedButton);
			utils.log().info("Clicked on Proceed Button");
			return true;
		}else {
			return false;
		}
	}
	
	@Override
	public boolean isAt() {
		 if(bluetoothConnectionFailedTitle.isDisplayed()){
	        	utils.log().info("On Bluetooth Connection failed - Proceed Page");
	        	return true;
	      }else{
	        //	utils.log().info("Not on Bluetooth Connection failed Page");
	        	return false;}
	}
	
}

