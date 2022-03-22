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
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class ResendOTPDialog  extends ParentClass implements Page
{
	public TestUtils utils = new TestUtils();
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Error_Alert_Screen_TitleLabel\"]")
	public MobileElement newCodeSentText;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Error_Alert_Screen_SubTitleLabel\"]")
	public MobileElement newCodeSentMessage;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Error_Alert_Screen_Button\"]")
	public MobileElement okButton;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Error_Alert_Screen_Button_Link\"]")
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
		super.click(okButton); 
	}
	
	public void clickIDidNotRecieveLink()
	{
		super.click(iDidNotRecieveLink); 
	}
	
	@Override
	public boolean isAt() {
		if(newCodeSentText.isDisplayed())
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
