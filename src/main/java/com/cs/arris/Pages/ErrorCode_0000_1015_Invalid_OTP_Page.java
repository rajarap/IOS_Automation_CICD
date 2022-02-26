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

public class ErrorCode_0000_1015_Invalid_OTP_Page   extends ParentClass implements Page
{
	public TestUtils utils = new TestUtils();
	public RandomEmailAddress random;
//	public OTP otp;
	public GetOTPFromNada nadaOTP;
	
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/need_help") 
	public MobileElement helpIcon;
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/title_text") 
	public MobileElement enterVerificationCodeMessage;

	@AndroidFindBy (id = "com.arris.sbcBeta:id/description_text") 
	public MobileElement checkEmailAccounteMessage;
	
	@AndroidFindBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/user_email_id']") 
	public MobileElement emailAddress;
	
	@AndroidFindBy (xpath = "//android.widget.EditText[@resource-id='com.arris.sbcBeta:id/etConfirmPasscode']")
	public MobileElement otpCode;
	
	@AndroidFindBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/tvResendPasscode']")
	public MobileElement resendPassCode;
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/ic_back_icon") 
	public MobileElement otpVerificationBackButton;
	
	@AndroidFindBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/confirm_password_error']")
	public MobileElement invalidPassCodeMessage;
	
	public ErrorCode_0000_1015_Invalid_OTP_Page()
	{
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);

	}
	
	public String getEmailAddress()
	{
		return emailAddress.getText();
	}
	
	public void enterPassCode(String passcode)
	{
//        utils.log().info("OTP is : " + passcode);
		utils.log().info("Entering OTP..." + passcode);
		super.sendKeys(otpCode, passcode, "Entered OTP passcode");
	}
	
	
	@Override
	public boolean isAt() {
		super.pause();
		return true;
	}
	
}
