package com.cs.arris.Pages;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.cs.arris.Base.ParentClass;
import com.cs.arris.Interface.Page;
import com.cs.arris.Utilities.TestUtils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class FAQHelpPage extends ParentClass implements Page
{
	public TestUtils utils = new TestUtils();
	
	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Help\"`][2]")
	public MobileElement helpTitle; 
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"NavigationBar_Button_Back\"]")
	public MobileElement backButton;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"FAQ_Help_Screen_SubTitleLabel\"]")
	//Search product FAQs here and get answers to you most pressing issues.
	public MobileElement titleText;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name=\"FAQ_Help_Screen_TextField\"]") //Search FAQs by keywords...
	public MobileElement searchText;
	
	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"SEARCH\"`]")  //SEARCH
	public MobileElement searchButton;
	
		public FAQHelpPage()
	{
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}
	
	public boolean clickBackButton() {
		if (backButton.isDisplayed()) {
			click(backButton);
			utils.log().info("Clicked on Back Button");
			return true;
		} else {
			return false;
		}
	}
	
	public boolean verifyUIOnFAQHelpPage() {
		try {
			if (helpTitle.isDisplayed())
				utils.log().info("Title : " + helpTitle.getText() + " is displayed");
			else
				utils.log().info("Help Title is not displayed");

			if (titleText.isDisplayed())
				utils.log().info(titleText.getText() + " text is displayed");
			else
				utils.log().info("FAQ Help Message is not displayed");

			if (searchText.isDisplayed())
				utils.log().info("Search Text : " + searchText.getText() + " is displayed");
			else
				utils.log().info("Search Text is not displayed");

			if (searchButton.isDisplayed())
				utils.log().info("Search Button is displayed");
			else
				utils.log().info("Search Button is not displayed");

			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	@Override
	public boolean isAt() {
		if(searchButton.isDisplayed())	{
			utils.log().info("On FAQ Help Page");
			return true;
		}else {
			utils.log().info("Not on FAQ Help Page");
		return false;}
	}
}
