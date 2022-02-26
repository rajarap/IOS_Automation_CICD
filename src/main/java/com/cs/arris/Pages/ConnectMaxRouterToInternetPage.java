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

public class ConnectMaxRouterToInternetPage extends ParentClass implements Page
{
	public TestUtils utils = new TestUtils();
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"BOBAHelp\"]")
	public MobileElement helpIcon;
	
	// text = SUCCESSFULLY CONNECTED TO THE INTERNET
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"BOBA_Connected_To_Internet_Screen_TitleLabel\"]")
	public MobileElement successfullyConnectedToInternetText;
	
	// text = Let's check for available software updates for your system.
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"BOBA_Connected_To_Internet_Screen_SubTitleLabel\"]")
	public MobileElement maxRouterSoftwareUpdatesText;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"BOBA_Connected_To_Internet_Screen_Button\"]")
	public MobileElement nextButton;
	
	public ConnectMaxRouterToInternetPage()
	{
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}
	
	public void clickNextButton()
	{
		String selector = "**/XCUIElementTypeButton[`label == \"NEXT\"`]";
		utils.log().info("Successfully Connected to Internet Page - Clicked on Next Button");
		click(nextButton);
	}

	@Override
	public boolean isAt() {
		super.pause();
		return true;
	}
	
}
