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

public class ErrorCode_0003_1003_Service_Is_Currently_Not_Available extends ParentClass implements Page
{
	public TestUtils utils = new TestUtils();
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.Button[@resource-id='com.arris.sbcBeta:id/btn_error_frag_retry']"), //TRY AGAIN
		@AndroidBy (xpath = "//android.widget.Button[@bounds='[61,1983][1019,2042]']"),
		@AndroidBy (id = "com.arris.sbcBeta:id/btn_error_frag_retry") 
	})
	public MobileElement tryAgainButton;
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/tv_error_frag_title") 
	//@AndroidFindBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/tv_error_frag_title']") // text = SERVICE IS CURRENTLY NOT AVAILABLE
	public MobileElement serviceIsCurrentlyNotAvailable;
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/tv_error_frag_description") 
	//@AndroidFindBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/tv_error_frag_description']") // text = 	
	//We are experiencing an issue connecting with our back office.
	public MobileElement issueConnectingToBackOffice;
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/tv_error_frag_code") 
	//@AndroidFindBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/tv_error_frag_code']") // text = 0003-1003
	public MobileElement errorCode;  
	//Include error-code 0003-1009
	
	public ErrorCode_0003_1003_Service_Is_Currently_Not_Available()
	{
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}
	
	@Override
	public boolean isAt() {
		super.pause();
		return true;
	}
	

}
