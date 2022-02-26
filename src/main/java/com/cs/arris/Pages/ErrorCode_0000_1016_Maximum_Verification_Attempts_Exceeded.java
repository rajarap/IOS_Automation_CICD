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

public class ErrorCode_0000_1016_Maximum_Verification_Attempts_Exceeded extends ParentClass implements Page
{
	public TestUtils utils = new TestUtils();
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/btn_error_frag_retry']"),//TRY AGAIN
		@AndroidBy (xpath = "//android.widget.TextView[@bounds='[61,1983][1019,2042]']"),
		@AndroidBy (id = "com.arris.sbcBeta:id/btn_error_frag_retry") 
	})
	public MobileElement tryAgainButton;
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/tv_error_frag_title") 
	//@AndroidFindBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/tv_error_frag_title']") // text = SOMETHING WENT WRONG
	public MobileElement maximumAttemptsReachedText;
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/tv_error_frag_description") 
	//@AndroidFindBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/tv_error_frag_description']") // text = 	
	//Sorry, your warranty and support registration has failed as we are unable to reach the server. Please check your internet connection or call 1-877-466-8646 to register your device.
	public MobileElement connectAfter30MinutesMessage;
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/tv_error_frag_code") 
	//@AndroidFindBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/tv_error_frag_code']") // text = 0000-1016
	public MobileElement errorCode;  
	
	public ErrorCode_0000_1016_Maximum_Verification_Attempts_Exceeded()
	{
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}
	
	@Override
	public boolean isAt() {
		super.pause();
		return true;
	}
	

}
