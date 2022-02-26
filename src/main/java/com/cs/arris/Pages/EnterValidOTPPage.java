package com.cs.arris.Pages;


import org.openqa.selenium.support.PageFactory;

import com.cs.arris.Base.ParentClass;
import com.cs.arris.Interface.Page;
import com.cs.arris.Utilities.RandomEmailAddress;
import com.cs.arris.Utilities.TestUtils;
import com.cs.arris.Utilities.GetOTPFromNada;
import com.cs.arris.Utilities.ValidOTP;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class EnterValidOTPPage   extends ParentClass implements Page
{
	public TestUtils utils = new TestUtils();
	public RandomEmailAddress random;
//	public OTP otp;


	@iOSXCUITFindBy(xpath="//XCUIElementTypeOther[@name=\"NavigationBar_Button_Help\"]")
	public MobileElement helpIcon;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Code_Verified_Screen_TitleLabel_EnterVerificationCode\"]")
	public MobileElement enterVerificationCodeMessage;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Code_Verified_Screen_SubTitleLabel_CheckYourEmailAccount\"]")
	public MobileElement checkEmailAccounteMessage;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Code_Verified_Screen_Label_Email\"]")
	public MobileElement emailAddress;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeOther[@name=\"Code_Verified_Screen_View_OTP\"]")
	public MobileElement otpCode;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Didn't receive any code? RESEND\"]")
	public MobileElement resendPassCode;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeOther[@name=\"NavigationBar_Button_Back\"]")
	public MobileElement otpVerificationBackButton;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Code_Verified_Screen_Label_Validation\"]")
	public MobileElement invalidPassCodeMessage;
	
	public EnterValidOTPPage()
	{
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}
	
	public String getEmailAddress()
	{
		return emailAddress.getText();
	}
	
	public void enterValidPassCode(String passcode)
	{
		utils.log().info("Entering Valid OTP..." + passcode);
		for (int i = 0; i < passcode.length() ; i++) {
			sendKeys(otpCode, Character.toString(passcode.charAt(i)));
		}
	}
	
	public void enterInValidPassCode(String passcode)
	{
		String selector = "**/XCUIElementTypeOther[`name == \"Code_Verified_Screen_View_OTP\"`]";
		utils.log().info("Entering invalid OTP..." + passcode);
		super.getDriver().findElement(MobileBy.iOSClassChain(selector)).sendKeys(passcode);
	}
	
	public boolean verifyInvalidPassCodeMessage()
	{
		if(invalidPassCodeMessage.isDisplayed())
		{
			utils.log().info("Invalid passcode message is displayed");
			return true;
		}
		else
		{
			utils.log().info("Invalid passcode message is not displayed");
			return false;
		}
	}
	
	public void clickResendLink()
	{
		super.click(resendPassCode);
		utils.log().info("Clicked Resend OTP Link");
	}
	
	public void clearPassCodeText()
	{
		otpCode.clear();
	}
	
	@Override
	public boolean isAt() {
		if(otpCode.isDisplayed())
		{
			utils.log().info("At Enter OTP Page");
			return true;
		}
		else
		{
			utils.log().info("Enter OTP Page is not displayed");
			return false;
		}
	}
}
