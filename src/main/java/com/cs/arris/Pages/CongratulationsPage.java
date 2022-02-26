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

public class CongratulationsPage extends ParentClass implements Page
{
	public TestUtils utils = new TestUtils();
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"BOBA_Congratulations_Screen_Button\"]")
	public MobileElement continueButton; 
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"BOBA_Congratulations_Screen_TitleLabel\"]")
	public MobileElement congratulationsText;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"BOBA_Congratulations_Screen_SubTitleLabel\"]")
	public MobileElement connectRouterToWifiText;
	
	public CongratulationsPage()
	{
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}
	
	public void clickContinueButton()
	{
		String selector = "**/XCUIElementTypeButton[`label == \"CONTINUE\"`]";
		click(continueButton);
		utils.log().info("Congratulations Page - Clicked on Continue Button");
	}
	
	@Override
	public boolean isAt() {
		super.pause();
		return true;
	}

}
