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

public class ErrorCode_0000_1603_Failure_To_Configure_Your_Router_Page extends ParentClass implements Page
{
	public TestUtils utils = new TestUtils();
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.Button[@resource-id='com.arris.sbcBeta:id/btn_generic_error_retry']"),
		@AndroidBy (xpath = "//android.widget.Button[@bounds='[119,2004][961,2042]']"),
		@AndroidBy (id = "com.arris.sbcBeta:id/btn_generic_error_retry") 
	})
	public MobileElement continueButton;
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/title_text") 
	//@AndroidFindBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/title_text']") // text = FAILURE TO CONFIGURE YOUR ROUTER.
	public MobileElement failureToConfigureYourRouter;
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/tv_description_text") 
	//@AndroidFindBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/tv_description_text']") 
	// text = Configuration failed for your router. Please press continue below to restart the installation process. If this issue persists, please contact support.
	public MobileElement configurationFailedMessage;
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/tv_error_code_text") 
	//@AndroidFindBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/tv_error_code_text']") // text = 0000-1603
	public MobileElement errorCode;  
	
	public ErrorCode_0000_1603_Failure_To_Configure_Your_Router_Page()
	{
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}
	
	@Override
	public boolean isAt() {
		super.pause();
		return true;
	}
	

}
