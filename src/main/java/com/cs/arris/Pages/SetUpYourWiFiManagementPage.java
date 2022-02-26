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

public class SetUpYourWiFiManagementPage extends ParentClass implements Page
{
	public TestUtils utils = new TestUtils();
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Home_Welcome_Screen_Button_GetStarted\"]")
	public MobileElement getStartedButton; 
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Home_Welcome_Screen_Button_SkipTutorial\"]")
	public MobileElement skipTutorialButton; 
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Home_Welcome_Screen_TitleLabel\"]")
	public MobileElement setupWifiManagementText;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Home_Welcome_Screen_SubTitleLabel\"]")
	public MobileElement setupWifiManagementMessage;
	
	public SetUpYourWiFiManagementPage()
	{
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}
	
	public void clickskipTutorialButton()
	{
		String selector = "**/XCUIElementTypeButton[`label == \"SKIP TUTORIAL\"`]";
		click(skipTutorialButton);
		utils.log().info("Setup Wifi Management Page - Clicked on Skip Tutorial Button");
	}
	
	@Override
	public boolean isAt() {
		super.pause();
		return true;
	}

}
