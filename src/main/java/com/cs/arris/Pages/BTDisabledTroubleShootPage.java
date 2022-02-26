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

public class BTDisabledTroubleShootPage extends ParentClass implements Page
{
	public TestUtils utils = new TestUtils();
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.Button[@resource-id='com.arris.sbcBeta:id/btn_generic_error_retry_ts']"),
		@AndroidBy (xpath = "//android.widget.Button[@bounds='[61,1822][1019,1959]']"),
		@AndroidBy (id = "com.arris.sbcBeta:id/btn_generic_error_retry_ts") 
	})
	public MobileElement proceedButton;
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.Button[@resource-id='com.arris.sbcBeta:id/troubleShootButton']"),
		@AndroidBy (xpath = "//android.widget.Button[@bounds='[61,1983][1019,2042]']"),
		@AndroidBy (id = "com.arris.sbcBeta:id/troubleShootButtons") 
	})
	public MobileElement customerSupportButton;
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/head") 
	//@AndroidFindBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/head']") // text = Troubleshoot
	public MobileElement troubleShootTitleText;
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/title_text_troubleshoot") 
	//@AndroidFindBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/title_text_troubleshoot']") // text = Bluetooth Connection Failed
	public MobileElement blueToothConnectionFailedText;
	
	@AndroidFindBy (xpath = "//android.widget.TextView[@bounds='[136,369][926,503]']") // text = Make sure location permission is enabled.
	public MobileElement locationPermissionEnabledText;
	
	@AndroidFindBy (xpath = "//android.widget.TextView[@bounds='[136,508][1041,855]']") 
	// text = Please press Settings below to navigate to Bluetooth settings. Please Enable Bluetooth and press back button to return to this Application to continue.
	public MobileElement EnableBlueToothText;
	
	public BTDisabledTroubleShootPage()
	{
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}
	
	//Enable Bluetooth and click proceed button
	public void clickProceedButton()
	{
		utils.log().info("UnPack your Box Page - Clicked on Next Button");
		click(proceedButton);
	}
	
	@Override
	public boolean isAt() {
		if(proceedButton.isDisplayed())
			return true;
		else
			return false;
	}
	
}
