package com.cs.arris.Pages;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import javax.naming.Context;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.support.PageFactory;

import com.cs.arris.Base.ParentClass;
import com.cs.arris.Interface.Page;
import com.cs.arris.Utilities.TestUtils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.remote.MobileCapabilityType;

public class ConnectionToWifiNeededPage extends ParentClass implements Page
{
	public TestUtils utils = new TestUtils();
	public String ssid;
	public String pwd;
	public String udid;
	

	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Join\"]")
	public MobileElement joinButton; 
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Cancel\"]")
	public MobileElement cancelButton;
	
	public ConnectionToWifiNeededPage()
	{
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}
	
	public void clickJoinButton()
	{
		click(joinButton);
		utils.log().info("Clicked on Join Button");
	}
	
	public void clickCancelButton()
	{
		click(cancelButton);
		utils.log().info("Clicked on Cancel Button");
	}
	
	
	@Override
	public boolean isAt() {
		super.pause();
		return true;
	}

}
