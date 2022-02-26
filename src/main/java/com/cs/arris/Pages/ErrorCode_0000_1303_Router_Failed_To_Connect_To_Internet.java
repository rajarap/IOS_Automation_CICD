package com.cs.arris.Pages;


import org.openqa.selenium.support.PageFactory;

import com.cs.arris.Base.ParentClass;
import com.cs.arris.Interface.Page;
import com.cs.arris.Utilities.RandomEmailAddress;
import com.cs.arris.Utilities.TestUtils;
import com.cs.arris.Utilities.GetOTPFromNada;
import com.cs.arris.Utilities.InValidOTP;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class ErrorCode_0000_1303_Router_Failed_To_Connect_To_Internet extends ParentClass implements Page
{
	public TestUtils utils = new TestUtils();
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"BOBAHelp\"]")
	public MobileElement helpIcon;
	
	//ROUTER FAILED TO CONNECT TO INTERNET
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"OB_Error_Screen_TitleLabel\"]")
	public MobileElement routerFailedToConnectToInternetTitle;

	//Your mAX failed to connect to the Internet. This can be due to improper Ethernet connection or lack of Internet connectivity from your modem.
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"OB_Error_Screen_SubTitleLabel\"]")
	public MobileElement routerFailedToConnectToInternetTitleMessage;
	
	//0000-1303
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"OB_Error_Screen_Label\"]")
	public MobileElement errorCode;
	
//	@AndroidFindBy (id = "com.arris.sbcBeta:id/btn_generic_troubleshoot")
//	public MobileElement troubleShootButton;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"OB_Error_Screen_Button\"]")
	public MobileElement tryAgainButton;
	

	public ErrorCode_0000_1303_Router_Failed_To_Connect_To_Internet()
	{
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);

	}
	
	public String getPageTitle()
	{
		return routerFailedToConnectToInternetTitle.getText();
	}
	
	public String getPageMessage()
	{
		return routerFailedToConnectToInternetTitleMessage.getText();
	}
	
	public String getErrCode()
	{
		return errorCode.getText();
	}
	
	public boolean getTryAgainButton()
	{
		if (tryAgainButton.isDisplayed())
			return true;
		else 
			return false;
	}
	
	public void clickTryAgainButton()
	{
		click(tryAgainButton);
	}
	
//	public void clickTroubleShootButton()
//	{
//		click(troubleShootButton);
//	}
	
	@Override
	public boolean isAt() {
		super.pause();
		return true;
	}
	
}
