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

public class SetupHomeNetworkPage extends ParentClass implements Page
{
	public TestUtils utils = new TestUtils();
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"BOBAHelp\"]")
	public MobileElement helpIcon;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Setting_Up_Home_Network_Screen_Button\"]")
	public MobileElement nextButton;
	
	// text = LET'S SET UP YOUR HOME NETWORK
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"BOBA_Setting_Up_Home_Network_Screen_TitleLabel\"]")
	public MobileElement setupHomeNetworkText;
	
	// text = You are only a few steps away from setting up your home network.
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"BOBA_Setting_Up_Home_Network_Screen_SubTitleLabel\"]")
	public MobileElement fewStepsAwayText;
	
	public SetupHomeNetworkPage()
	{
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}
	
	public void clickNextButton()
	{
		String selector = "**/XCUIElementTypeButton[`label == \"NEXT\"`]";
		utils.log().info("Setup Home Network Page - Clicked on Next Button");
		click(nextButton);
	}
	
	@Override
	public boolean isAt() {
		super.pause();
		return true;
	}
	
}
