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

public class MainRouterDetailsHelpPage extends ParentClass implements Page
{
	public TestUtils utils = new TestUtils();
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"cross\"]")
	public MobileElement closeButton; 
	
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"Router Details\"])[1]")
	public MobileElement routerDetails;
	
	
	public MainRouterDetailsHelpPage()
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

	public void verifyUIOnMainRouterHelpPage() {
		try {
			if (routerDetails.isDisplayed())
				utils.log().info(routerDetails.getText() + " title is displayed ");
		} catch (Exception e) {
			utils.log().info("Router Details Title is not displayed");
		}
		
//		try {
//			if (connectedDeviceGraphic.isDisplayed())
//				utils.log().info(connectedDeviceGraphic.getText() + " text is displayed ");
//		} catch (Exception e) {
//			utils.log().info("Connected Devices Graphic text is not displayed");
//		}
	}
	
	@Override
	public boolean isAt() {
		if(routerDetails.isDisplayed())
		{
			utils.log().info("On Router Details Help Page");
			utils.log().info("---------------------------");
			return true;}
		else {
			utils.log().info("Not on Router Details Help Page");
		return false;}
		
	}

}
