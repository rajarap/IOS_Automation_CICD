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

public class EnterInValidOTPPage   extends ParentClass implements Page
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
	
	public EnterInValidOTPPage()
	{
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}
	
	public String getEmailAddress()
	{
		return emailAddress.getText();
	}
	
	public void enterValidPassCode(String passcode)
	{
		utils.log().info("Entering new OTP..." + passcode);
		super.sendKeys(otpCode, passcode);
	}
	
	public void enterInValidPassCode(String passcode)
	{
		utils.log().info("Entering invalid OTP..." + passcode);
		super.sendKeys(otpCode, passcode);
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
