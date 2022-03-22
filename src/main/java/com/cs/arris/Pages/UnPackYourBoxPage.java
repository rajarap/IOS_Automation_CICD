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

public class UnPackYourBoxPage extends ParentClass implements Page
{
	public TestUtils utils = new TestUtils();
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"BOBAHelp\"]")
	public MobileElement helpIcon;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"BOBA_Unpack_Box_Screen_Button\"]")
	public MobileElement nextButton;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"BOBA_Unpack_Box_Screen_TitleLabel\"]")
	public MobileElement letsUnpackYouBoxText;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"BOBA_Unpack_Box_Screen_SubTitleLabel\"]")
	public MobileElement routerAndPoweCableInsideBoxText;
	
	public UnPackYourBoxPage()
	{
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}
	
	
	public void clickNextButton()
	{
		String selector = "**/XCUIElementTypeButton[`label == \"NEXT\"`]";
		utils.log().info("UnPack your Box Page - Clicked on Next Button");
		click(nextButton);
	}
	
	@Override
	public boolean isAt() {
		if(letsUnpackYouBoxText.isDisplayed())
		{
			utils.log().info("On LET'S UNPACK YOUR BOX Page");
			return true;
		}
		else
		{
			utils.log().info("Not on LET'S UNPACK YOUR BOX Page");
			return false;
		}
	}
	
}
