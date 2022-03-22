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

public class NetworkOptimizationDialog extends ParentClass implements Page
{
	public TestUtils utils = new TestUtils();
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Error_Alert_Screen_TitleLabel\"]")
	public MobileElement networkOptimizationText;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Error_Alert_Screen_SubTitleLabel\"]")
	public MobileElement networkOptimizationMessage;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Error_Alert_Screen_Button\"]")
	public MobileElement okButton;
	
	public NetworkOptimizationDialog()
	{
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}
	
	public void clickOkButton()
	{
		String selector = "**/XCUIElementTypeButton[`label == \"OK\"`]";
		click(okButton);
		utils.log().info("Network Optimization Dialog - Clicked on OK Button");
	}

	@Override
	public boolean isAt() {
		if(networkOptimizationText.isDisplayed())
		{
			utils.log().info("On Network Optimization Page");
			return true;
		}
		else
		{
			utils.log().info("Not on Network Optimization Page");
			return false;
		}
	}
	
}
