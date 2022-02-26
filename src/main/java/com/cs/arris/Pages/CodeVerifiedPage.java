package com.cs.arris.Pages;

import org.openqa.selenium.support.PageFactory;

import com.cs.arris.Base.ParentClass;
import com.cs.arris.Interface.Page;
import com.cs.arris.Utilities.TestUtils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.touch.offset.PointOption;

public class CodeVerifiedPage  extends ParentClass implements Page
{
	public TestUtils utils = new TestUtils();
	public TouchAction action = new TouchAction(getDriver());
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Code_Verified_Screen_TitleLabel_EnterVerificationCode\"]")
	public MobileElement codeVerifiedText;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeImage[@name=\"Code_Verified_Screen_Image_OtpSuccess\"]")
	public MobileElement successIcon;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Code_Verified_Screen_Label_Email\"]")
	public MobileElement emailAddress;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Code_Verified_Screen_Button_NextOnboard\"]")
	public MobileElement nextButton;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"OB_Launch_Error_Screen_Button_ContinueOnboarding\"]")
	public MobileElement continueOnBoardingButton;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"OB_Launch_Error_Screen_Button_TryAgain\"]")
	public MobileElement tryAgainButton;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"OB_Launch_Error_Screen_Label_Error\"]")
	//The mobile device cannot connect to your Router.
	public MobileElement mobileDeviceCannotConnectToRouter;
	
	//If you have previously installed the device, please connect your mobile device to the local Wi-Fi network. Click on "Try Again" to retry the connection to the device.
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"OB_Launch_Error_Screen_Label\"]")
	public MobileElement connectMobileToLocalWifiText;
	
//	//If you have completed performing a factory reset on the device, then Click on "Continue Onboarding" to reinstall the device.
//	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"OB_Launch_Error_Screen_Label\"]")
//	public MobileElement factoryResetOnDeviceText;
	
	//@AndroidFindBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/tv_error_frag_code']") // text = 0015-1805
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"OB_Launch_Error_Screen_Label_ErrorCode\"]")
	public MobileElement errorCode;  
	
	public CodeVerifiedPage()
	{
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}
	
	public void clickNextButton()
	{
		if(nextButton.isDisplayed())
			utils.log().info("OTP Code Verified Page - Clicked on Next Button");
			click(nextButton);
	}
	
	public void getCodeVerifiedText()
	{
		System.out.println(codeVerifiedText.getText());
	}
	
	public void clickContinueOnboardingButton()
	{
		click(continueOnBoardingButton);
	}
	
	public void checkError() {
		int x = 187;
		int y = 458;
		PointOption p = new PointOption();
		p.withCoordinates(x, y);
		
		for(int i=0; i <= 7; i++) {
			action.tap(p);
			action.release().perform();
		}
	}

	@Override
	public boolean isAt() {
		super.pause();
		return true;
	}
	
}
