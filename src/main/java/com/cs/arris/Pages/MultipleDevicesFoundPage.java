package com.cs.arris.Pages;

import org.openqa.selenium.support.PageFactory;

import com.cs.arris.Base.ParentClass;
import com.cs.arris.Interface.Page;
import com.cs.arris.Utilities.TestUtils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class MultipleDevicesFoundPage extends ParentClass implements Page
{
	public TestUtils utils = new TestUtils();
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"OB_Error_Screen_TitleLabel\"]")
	public MobileElement multipleDevicesFoundTitle;
	
	//It appears that 2 or more routers are turned on at the same time. Unplug one of your mAX devices to prevent confusion during setup.
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"OB_Error_Screen_SubTitleLabel\"]")
	public MobileElement multipleDevicesFoundSubTitle;

	//0013-1203
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"OB_Error_Screen_Label\"]")
	public MobileElement errorCode;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"TRY AGAIN\"]")
	public MobileElement tryAgain;
	
	public MultipleDevicesFoundPage()
	{
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}
	
	public void clickTryAgaineButton()
	{
		utils.log().info("Multiple Devices Found Page - Clicked on Try Again Button");
		click(tryAgain);
	}
	
	
	
	@Override
	public boolean isAt() {
		if(multipleDevicesFoundTitle.isDisplayed()) {
			utils.log().info("MULTIPLE DEVICES FOUND - It appears that 2 or more routers are turned on at the same time.");
			return true;
		}else {
//			utils.log().info("No MULTIPLE DEVICES FOUND");
			return false;
		}
	}
}
