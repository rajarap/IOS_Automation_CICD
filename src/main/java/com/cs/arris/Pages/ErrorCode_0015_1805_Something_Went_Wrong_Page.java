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

public class ErrorCode_0015_1805_Something_Went_Wrong_Page extends ParentClass implements Page
{
	public TestUtils utils = new TestUtils();
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"OB_Launch_Error_Screen_Label_TitleLabel\"]")
	public MobileElement somethingWentWrongLabel;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"OB_Launch_Error_Screen_Button_ContinueOnboarding\"]")
	public MobileElement continueOnBoardingButton;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"OB_Launch_Error_Screen_Button_TryAgain\"]")
	public MobileElement tryAgainButton;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"OB_Launch_Error_Screen_Label_Error\"]")
	public MobileElement mobileDeviceCannotConnectToRouter;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"OB_Launch_Error_Screen_Label\"]")
	public MobileElement connectMobileToLocalWifiText;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"OB_Launch_Error_Screen_Label_ErrorCode\"]")
	public MobileElement errorCode; 
	
	public ErrorCode_0015_1805_Something_Went_Wrong_Page()
	{
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}
	
	public void clickContinueOnboardingButton()
	{
		click(continueOnBoardingButton);
	}
	
	@Override
	public boolean isAt() {
		if(continueOnBoardingButton.isDisplayed())
		{
			utils.log().info("At Something Went Wrong Page displayed");
			return true;
		}
		else
		{
			utils.log().info("Something Went Wrong Page is not displayed");
			return false;
		}
			
	}
	

}
