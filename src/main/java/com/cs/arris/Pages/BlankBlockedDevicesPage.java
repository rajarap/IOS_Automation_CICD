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

//Accessed from HomePage
public class BlankBlockedDevicesPage extends ParentClass implements Page
{
	public TestUtils utils = new TestUtils();
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/imgCloseIcon") 
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"NavigationBar_Button\"]")
	public MobileElement closeIcon;
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/txtHeader") 
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Blocked_Devices_Screen_TitleLabel\"]")
	public MobileElement curentlyBlockedDevicesTitle;
	
	//is either "Parental Control is disabled" or count of devices blocked - 00
	@AndroidFindBy (xpath = "//android.widget.TextView[resource-id='com.arris.sbcBeta:id/txtTotalDevices']") 
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Blocked_Devices_Screen_Label_Count\"]")
	public MobileElement totalDevicesBlocked;
	
	public BlankBlockedDevicesPage()
	{
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}
		
	public boolean clickCloseIcon()
	{
		if(closeIcon.isDisplayed())	{
			click(closeIcon);
			utils.log().info("Clicked on Close Icon");
			return true;
		}else {
			return false;
		}
	}
	
	public void getDeviceBlockedCountText()
	{
		try {
			if (totalDevicesBlocked.isDisplayed() && totalDevicesBlocked.getText().equals("00"))
				utils.log().info("Parental Control is enabled and " + totalDevicesBlocked.getText() + " devices are blocked");
			else if(totalDevicesBlocked.isDisplayed() && !totalDevicesBlocked.getText().equals("00"))
				utils.log().info(totalDevicesBlocked.getText());
		} catch (Exception e) {
			utils.log().info("Count of devices blocked is not displayed");
		}
	}
	
	@Override
	public boolean isAt() {
		if(curentlyBlockedDevicesTitle.isDisplayed())
		{
			utils.log().info("On Blank Currently Blocked Devices Page");
			return true;
	}else {
			utils.log().info("Not on Blank Currently Blocked Devices Page");
		return false;}
	}
	
}

