package com.cs.arris.Pages;

import org.openqa.selenium.support.PageFactory;

import com.cs.arris.Base.ParentClass;
import com.cs.arris.Interface.Page;
import com.cs.arris.Utilities.TestUtils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ErrorCode_0002_1304_Internet_Connection_Not_Available_On_Router extends ParentClass implements Page
{
	public TestUtils utils = new TestUtils();
	
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.Button[@resource-id='com.arris.sbcBeta:id/btn_error_frag_retry']"),
		@AndroidBy (xpath = "//android.widget.Button[@bounds='[61,1983][1019,2042]']"),
		@AndroidBy (id = "com.arris.sbcBeta:id/btn_error_frag_retry") 
	})
	public MobileElement tryAgainButton;
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/btn_error_frag_retry']"),
		@AndroidBy (xpath = "//android.widget.TextView[@bounds='[61,1983][1019,2042]']"),
		@AndroidBy (id = "com.arris.sbcBeta:id/btn_error_frag_retry") 
	})
	public MobileElement troubleShootButton;
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/tv_error_frag_title") 
	//@AndroidFindBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/tv_error_frag_title']") // text = INTERNET CONNECTION NOT AVAILABLE
	public MobileElement internetConnectionNotAvailableText;
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/tv_error_frag_description") 
	//@AndroidFindBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/tv_error_frag_title']") // text = Internet connection is currently NOT available on your mobile device.
	public MobileElement internetConnectionNotAvailableMessage;
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/tv_error_frag_code") 
	//@AndroidFindBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/tv_error_frag_code']") // text = 0002-1002
	//0002-1304 - Internet Connection Not available on Router
	public MobileElement errorCode; 
	
	public ErrorCode_0002_1304_Internet_Connection_Not_Available_On_Router()
	{
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}
	
	public String getErrCode()
	{
		return errorCode.getText();
	}
	
	public String getTitleText()
	{
		return internetConnectionNotAvailableText.getText();
	}
	
	public String getDescriptionMessage()
	{
		return internetConnectionNotAvailableMessage.getText();
	}
	
	public String getTryAgainButtonText()
	{
		return tryAgainButton.getText();
	}
	
	public void clickTryAgainButton()
	{
		super.click(tryAgainButton);
	}
	
	public String getTroubleShootButtonText()
	{
		return troubleShootButton.getText();
	}
	
	public void clickTroubleShootButton()
	{
		super.click(troubleShootButton);
	}

	
	@Override
	public boolean isAt() {
		super.pause();
		return true;
	}
	

}
