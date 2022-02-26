package com.cs.arris.Pages;

import org.openqa.selenium.support.PageFactory;

import com.cs.arris.Base.ParentClass;
import com.cs.arris.Interface.Page;
import com.cs.arris.Utilities.TestUtils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AccessResourcesPage extends ParentClass implements Page
{
	TestUtils utils = new TestUtils();

	@AndroidFindBy (xpath = "//android.widget.TextView[@resource-id='com.android.permissioncontroller:id/permission_message']")
	public MobileElement accessDeviceLocationMessage;	
	
	@AndroidFindBy (xpath = "//android.widget.Button[@bounds='[64,1689][1016,1784]']")
	public MobileElement whileUsingTheAppLink;
	
	@AndroidFindBy (xpath = "//android.widget.Button[@bounds='[64,1826][1016,1921]']")
	public MobileElement onlyThisTimeLink;
	
	@AndroidFindBy (xpath = "//android.widget.Button[@bounds='[64,1963][1016,2042]']")
	public MobileElement denyLink;
	
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

	public AccessResourcesPage()
	{
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}

	public void clickwhileUsingTheApp() 
	{
		utils.log().info("Access Resources - Clicked on While Using This App Link");
		click(whileUsingTheAppLink);
	}
	
	public void clickOnlyThisTimeLink()
	{
		utils.log().info("Access Resources - Clicked on Only This Time Link");
		click(onlyThisTimeLink);
	}

	public void clickOnDenyLink() 
	{
		utils.log().info("Access Resources - Clicked on Deny Link");
		click(denyLink);
	}
	
	@Override
	public boolean isAt() {
		super.pause();
		return true;
	}
	

}
