package com.cs.arris.Pages;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.cs.arris.Base.ParentClass;
import com.cs.arris.Interface.Page;
import com.cs.arris.Utilities.Direction;
import com.cs.arris.Utilities.SwipeActions;
import com.cs.arris.Utilities.TestUtils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class WhosHomeNotifyMeWhenHelpPage extends ParentClass implements Page
{
	public TestUtils utils = new TestUtils();
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"cross\"]")
	public MobileElement closeButton; 
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Who's Home Notification\"]")
	public MobileElement helpTitle;
	
	
	public WhosHomeNotifyMeWhenHelpPage()
	{
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}
	
	public void clickCloseButton() {
		try {
			new SwipeActions().swipeScreen(Direction.UP);
			click(closeButton);
			utils.log().info("Clicked on Close Button");
		} catch (Exception e) {
			utils.log().info("Close button is not displayed");
		}
	}

	
	@Override
	public boolean isAt() {
		if(helpTitle.isDisplayed())
		{
			utils.log().info("On Who's Home Notification Help Page");
			return true;}
		else {
			utils.log().info("Not on Who's Home Notification Help Page");
		return false;}
		
	}

}
