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

public class PlugInMaxRouterPage extends ParentClass implements Page
{
	public TestUtils utils = new TestUtils();
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"BOBAHelp\"]")
	public MobileElement helpIcon;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"BOBA Arrow\"]")
	public MobileElement backButton;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"BOBA_Plug_In_Max_Router_Screen_Button\"]")
	public MobileElement nextButton;
	
	// text = LET'S SET UP YOUR HOME NETWORK
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"BOBA_Plug_In_Max_Router_Screen_TitleLabel\"]")
	public MobileElement plugInYourMaxRouterText;
	
	// text = You are only a few steps away from setting up your home network.
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"BOBA_Plug_In_Max_Router_Screen_SubTitleLabel\"]")
	public MobileElement routerSetupStepsText;
	
	public PlugInMaxRouterPage()
	{
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}
	
	public void clickNextButton()
	{
		String selector = "**/XCUIElementTypeButton[`label == \"NEXT\"`]";
		utils.log().info("Plugin Max Router Page - Clicked on Next Button");
		click(nextButton);
	}
	
	@Override
	public boolean isAt() {
		super.pause();
		return true;
	}
	
}
