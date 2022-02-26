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

public class HomeNetowrkISPServicePerformanceAndConnectionHealthPage extends ParentClass implements Page
{
	public TestUtils utils = new TestUtils();
	
	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Network Health Optimization\"`]")
	public MobileElement backButton; 
	
	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"ISP Service Performance and Connection Health\"`]")
	public MobileElement ispServicePerformanceConnectionHealthTitle;
	
	
	public HomeNetowrkISPServicePerformanceAndConnectionHealthPage()
	{
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}
	
	public void clickBackButton() {
		try {
			new SwipeActions().swipeScreen(Direction.UP);
			click(backButton);
			utils.log().info("Clicked on Back Button");
		} catch (Exception e) {
			utils.log().info("Back button is not displayed");
		}
	}

	
	@Override
	public boolean isAt() {
		if(ispServicePerformanceConnectionHealthTitle.isDisplayed())
		{
			utils.log().info("On ISP Service Performance and Connection Health Page");
			return true;
		}else {
			utils.log().info("Not on ISP Service Performance and Connection Health Page");
		return false;}
		
	}

}
