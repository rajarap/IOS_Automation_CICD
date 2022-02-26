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

public class OptimizeYourNetworkPage  extends ParentClass implements Page
{
	public TestUtils utils = new TestUtils();
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"OB_Launch_Error_Screen_Label\"]")
	public MobileElement placementTips;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Placement_Tips_Network_Screen_TitleLabel\"]")
	public MobileElement helpYouOptimizeYourNetwork;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Placement_Tips_Network_Screen_SubTitleLabel\"]")
	public MobileElement stepsToOptimizeYourNetwork;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"BOBAHelp\"]")
	public MobileElement helpIcon;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Placement_Tips_Network_Screen_Label_Help\"]")
	public MobileElement helpMeOptimizeButton;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Placement_Tips_Network_Screen_Button\"]")
	public MobileElement skipOptimizeButton;
	
	
	public OptimizeYourNetworkPage()
	{
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}
	
	public void clickSkipOptimizeButton()
	{
		String selector = "**/XCUIElementTypeButton[`name == \"Placement_Tips_Network_Screen_Button\"`]";
		click(skipOptimizeButton);
	}
	
	
	@Override
	public boolean isAt() {
		super.pause();
		return true;
	}
	
}
