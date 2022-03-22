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

public class SomethingWentWrongPage extends ParentClass implements Page
{
	public TestUtils utils = new TestUtils();
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"BOBAHelp\"]")
	public MobileElement helpIcon;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"BOBA_Your_System_Uptodate_Screen_Button\"]")
	public MobileElement nextButton;
	
	// text = YOUR SYSTEM IS UP TO DATE
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"OB_Error_Screen_TitleLabel\"]")
	public MobileElement somethingWentWrongTitle;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"OB_Error_Screen_SubTitleLabel\"]")
	public MobileElement somethingWentWrongSubTitle;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"OB_Error_Screen_Label\"]")
	public MobileElement errorCode;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"OB_Error_Screen_Button\"]")
	public MobileElement continueButton;
	
	public SomethingWentWrongPage()
	{
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}
	

	public void clickContinueButton()
	{
		click(continueButton);
		utils.log().info("Warranty and Support Page - Clicked on Continue Button");
	}
	
	@Override
	public boolean isAt() {
		if(somethingWentWrongTitle.isDisplayed())
		{
			utils.log().info("On SOMETHING WENT WRONG Page");
			return true;
		}
		else
		{
			utils.log().info("Not on SOMETHING WENT WRONG Page");
			return false;
		}
	}
	
}

