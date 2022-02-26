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

public class ErrorCode_0000_1506_Warranty_Support_Page extends ParentClass implements Page
{
	public TestUtils utils = new TestUtils();
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"BOBAHelp\"]")
	public MobileElement helpIcon;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"OB_Error_Screen_Button\"]")
	public MobileElement continueButton;
	
	// text = SOMETHING WENT WRONG
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"OB_Error_Screen_TitleLabel\"]")
	public MobileElement somethingWentWrong;
	
	//Sorry, your warranty and support registration has failed as we are unable to reach the server. Please check your internet connection or call 1-877-466-8646 to register your device.
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"OB_Error_Screen_SubTitleLabel\"]")
	public MobileElement warrantyAndSupportMessage;
	
	// text = 0000-1506
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"OB_Error_Screen_Label\"]")
	public MobileElement errorCode;  
	
	public ErrorCode_0000_1506_Warranty_Support_Page()
	{
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}
	
	public void clickContinueButton()
	{
		utils.log().info("Warranty and Support Page - Clicked on Continue Button");
		click(continueButton);
	}
	
	@Override
	public boolean isAt() {
		super.pause();
		return true;
	}
	

}
