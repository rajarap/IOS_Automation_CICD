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
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class AccessResourcesOnDevicePage extends ParentClass implements Page
{
	TestUtils utils = new TestUtils();

	
	//***********  IOS   *********************
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"“SBC Test” would like to find and connect to devices on your local network.\"]")
	public MobileElement connectToLocalNetworkMessage;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Permission needed to connect the App to your router to complete the install.\"]")
	public MobileElement permissionToConnectMessage;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"OK\"]")
	public MobileElement okButton;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Don’t Allow\"]")
	public MobileElement dontAllow;
	
	//***********  IOS   *********************
	
	public AccessResourcesOnDevicePage()
	{
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}

	public void clickOkButton() 
	{
		try {
			click(okButton);
			utils.log().info("Connect Device To Local Network - Clicked " + okButton.getText());
		} catch (Exception e) {
			//utils.log().info("Connect Device To Local Network - OK button is not displayed");
		}
	}
	
	public void clickDontAllowButton() 
	{
		try {
			click(dontAllow);
			utils.log().info("Connect Device To Local Network - Clicked " + dontAllow.getText());
		} catch (Exception e) {
			utils.log().info("Connect Device To Local Network - Dont Allow button is not displayed");
		}
	}
	
	
	@Override
	public boolean isAt() {
		if(connectToLocalNetworkMessage.isDisplayed())
		{
			utils.log().info("At Access Resource On Device Page");
			return true;
		}
		else
		{
			utils.log().info("Access Resource On Device Page is not displayed");
			return false;
		}
	}

}
