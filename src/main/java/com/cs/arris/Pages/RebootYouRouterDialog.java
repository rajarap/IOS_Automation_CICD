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

public class RebootYouRouterDialog extends ParentClass implements Page
{
	public TestUtils utils = new TestUtils();
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/tvReboot") 
	public MobileElement rebootYourRouterTitle;
	
	@AndroidFindBy (xpath = "//android.widget.TextView[@bounds='[164,1114][916,1277]']")
	// text = Your devices will no longer be able to access this network, the Internet, or each other until Internet is restored.
	public MobileElement rebootYourRouterText1;
	
	@AndroidFindBy (xpath = "//android.widget.TextView[@bounds='[212,1297][868,1356]']")
	// text = Are you sure you want to do this?
	public MobileElement rebootYourRouterText2;
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.Button[@resource-id='com.arris.sbcBeta:id/restartDevice']"),  //Restart Router Button
		@AndroidBy (xpath = "//android.widget.Button[@bounds='[195,1407][885,1544]']"),
		@AndroidBy (id = "com.arris.sbcBeta:id/restartDevice") 
	})
	public MobileElement restartRouterButton;
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/ivClose") // X
	public MobileElement closeDialog;
	
	public RebootYouRouterDialog()
	{
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}
	
	public void closeDialog()
	{
		click(closeDialog);
	}


	@Override
	public boolean isAt() {
		super.pause();
		return true;
	}
	
}
