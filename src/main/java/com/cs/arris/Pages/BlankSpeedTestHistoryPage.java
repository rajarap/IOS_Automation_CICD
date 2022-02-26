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

public class BlankSpeedTestHistoryPage extends ParentClass implements Page
{
	public TestUtils utils = new TestUtils();
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/imgCloseIcon") 
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"NavigationBar_Button\"]")
	public MobileElement closeIcon;
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/txtHeader") 
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Speed_History_Screen_TitleLabel\"]")
	public MobileElement speedTestHistoryTitle;
	
	public BlankSpeedTestHistoryPage()
	{
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}
	
	public boolean clickCloseIcon()
	{
		if(closeIcon.isDisplayed())	{
			click(closeIcon);
			utils.log().info("Clicked on Close Icon");
			return true;
		}else {
			return false;
		}
	}
	
	@Override
	public boolean isAt() {
		if(speedTestHistoryTitle.isDisplayed())
		{
			utils.log().info("On Speed Test History Page");
			return true;}
		else {
			utils.log().info("Not on Speed Test History Page");
		return false;}
	}
	
}

