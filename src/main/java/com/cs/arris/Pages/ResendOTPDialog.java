package com.cs.arris.Pages;


import org.openqa.selenium.support.PageFactory;

import com.cs.arris.Base.ParentClass;
import com.cs.arris.Interface.Page;
import com.cs.arris.Utilities.RandomEmailAddress;
import com.cs.arris.Utilities.TestUtils;
import com.cs.arris.Utilities.GetOTPFromNada;
import com.cs.arris.Utilities.ValidOTP;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ResendOTPDialog  extends ParentClass implements Page
{
	public TestUtils utils = new TestUtils();
	
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/dialog_title") //New Code Sent!
	public MobileElement newCodeSentText;
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/dialog_description") 
	public MobileElement newCodeSentMessage;

	//@AndroidFindBy (id = "com.arris.sbcBeta:id/btn_dialog_otp_send") 
	@AndroidFindBy (xpath = "//android.widget.Button[@resource-id='com.arris.sbcBeta:id/btn_dialog_otp_send']") //OK
	public MobileElement okButton;
	
	@AndroidFindBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/needHelpOTP']") //"I did not receive"
	public MobileElement iDidNotRecieveLink;
	
	
	public ResendOTPDialog()
	{
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}
	
	public String getNewCodeSentText()
	{
		return newCodeSentText.getText();
	}
	
	public String getNewCodeSentMessaget()
	{
		return newCodeSentMessage.getText();
	}
	
	public void clickOKButton()
	{
//        utils.log().info("OTP is : " + passcode);
		super.click(okButton); //goes back to enter OTP page to enter the new OTP on clicking resend link
	}
	
	public void clickIDidNotRecieveLink()
	{
//        utils.log().info("OTP is : " + passcode);
		super.click(iDidNotRecieveLink);  //opens ValidationCodePage
	}
	
	@Override
	public boolean isAt() {
		if(okButton.isDisplayed())
		{
			utils.log().info("At Resend OTP Dialog");
			return true;
		}
		else
		{
			utils.log().info("Resend OTP Dialog is not displayed");
			return false;
		}
	}
	
}
