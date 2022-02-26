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

public class RemoveDeviceFromHomePage extends ParentClass implements Page
{
	TestUtils utils = new TestUtils();

	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.ImageButton[@content-desc=\"Navigate up\"]"),  
		@AndroidBy (xpath = "//android.widget.ImageButton[@bounds='[0,112][147,259]']")
	})
	public MobileElement topLeftIcon;	

	//====================================================== ALERT DIALOG ==========================================================
	//@AndroidFindBy (id = "android:id/button1")
	//public WebElement OK;
	//
	//@AndroidFindBy (id = "android:id/button2")
	//public WebElement CANCEL;
	//
	//@AndroidFindBy (id = "android:id/message")
	//public WebElement message;
	//
	//====================================================== ALERT DIALOG ==========================================================

	public RemoveDeviceFromHomePage()
	{
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}

	public void clickwhileUsingTheApp() 
	{
		utils.log().info("Access Resources - Clicked on While Using This App Link");

	}
	
	public void clickOnlyThisTimeLink()
	{
		utils.log().info("Access Resources - Clicked on Only This Time Link");

	}

	public void clickOnDenyLink() 
	{
		utils.log().info("Access Resources - Clicked on Deny Link");
	}
	
	@Override
	public boolean isAt() {
		super.pause();
		return true;
	}
	

}
