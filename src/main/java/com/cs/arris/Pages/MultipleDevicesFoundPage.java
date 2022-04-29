package com.cs.arris.Pages;

import org.openqa.selenium.support.PageFactory;

import com.cs.arris.Base.ParentClass;
import com.cs.arris.Interface.Page;
import com.cs.arris.Utilities.TestUtils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class MultipleDevicesFoundPage extends ParentClass implements Page
{
	public TestUtils utils = new TestUtils();
	

	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/title_text")
	public MobileElement multipleDevicesFoundTitle;
	
	//It appears that 2 or more routers are turned on at the same time. Unplug one of your mAX devices to prevent confusion during setup.
	@AndroidFindBy (id = "com.arris.sbcBeta:id/tv_description_text")
	public MobileElement multipleDevicesFoundSubTitle;

	//0013-1203
	@AndroidFindBy (id = "com.arris.sbcBeta:id/tv_error_code_text")
	public MobileElement errorCode;

	@AndroidFindBy (id = "com.arris.sbcBeta:id/btn_generic_error_retry")
	public MobileElement tryAgain;
	
	public MultipleDevicesFoundPage()
	{
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}
	
	public void clickTryAgaineButton()
	{
		utils.log().info("Multiple Devices Found Page - Clicked on Try Again Button");
		click(tryAgain);
	}
	
	
	
	@Override
	public boolean isAt() {
		if(multipleDevicesFoundSubTitle.isDisplayed()) {
			utils.log().info("MULTIPLE DEVICES FOUND - It appears that 2 or more routers are turned on at the same time.");
			return true;
		}else {
			utils.log().info("No MULTIPLE DEVICES FOUND");
			return false;
		}
	}
}
