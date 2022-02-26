package com.cs.arris.Pages;

import org.openqa.selenium.support.PageFactory;

import com.cs.arris.Base.ParentClass;
import com.cs.arris.Interface.Page;
import com.cs.arris.Utilities.TestUtils;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class NameYourNetwokSSIDPage extends ParentClass implements Page
{
	public TestUtils utils = new TestUtils();
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"BOBAHelp\"]")
	public MobileElement helpIcon;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"BOBA_Network_Connect_Screen_Button\"]")
	public MobileElement nextButton;
	
	// text = LET’S NAME YOUR HOME NETWORK
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Network_Connect_Screen_TitleLabel\"]")
	public MobileElement nameYourHomeNetworkText;
	
	// text = Enter a name and password for your home network that you will use to connect your devices.
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Network_Connect_Screen_SubTitleLabel\"]")
	public MobileElement enterNameAndPasswordForHomeNetworkText;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeTextField[@name=\"Network_Connect_Screen_TextField_SSIDName\"]")
	public MobileElement ssIDName;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeSecureTextField[@name=\"Network_Connect_Screen_TextField_Password\"]")
	public MobileElement ssidPassword;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Done\"]")
	public MobileElement doneLink;
	
	
	public NameYourNetwokSSIDPage()
	{
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}
	
	public void enterSSIDName(String ssidName)
	{
		sendKeys(ssIDName, ssidName);
		utils.log().info("Name Your Network Page - Entered SSID Name");
	}
	
	public void enterSSIDPassword(String ssidpwd)
	{
		sendKeys(ssidPassword, ssidpwd);
		utils.log().info("Name Your Network Page - Entered SSID Password");
		
//		String selector = "**/XCUIElementTypeButton[`label == \"Done\"`]";
//		super.getDriver().findElement(MobileBy.iOSClassChain(selector)).click();
//		utils.log().info("Name Your Network Page  - Clicked on Done Button");
	}
	
	public void clickDoneLink()
	{
		try {
			String acc = "Done";
			super.getDriver().findElement(MobileBy.AccessibilityId(acc)).click();
		}catch(Exception e) {utils.log().info("Clicked on Done Button 1");}
		
		try {
			String pred = "label == \"Done\"";
			super.getDriver().findElement(MobileBy.iOSNsPredicateString(pred)).click();
		}catch(Exception e) {utils.log().info("Clicked on Done Button 2");}
		
		try {
			String selector = "**/XCUIElementTypeButton[`label == \"Done\"`]";
			super.getDriver().findElement(MobileBy.iOSClassChain(selector)).click();
		}catch(Exception e) {utils.log().info("Clicked on Done Button 3");}
		
		try {
		click(doneLink);
		utils.log().info("Name Your Network Page  - Clicked on Done Button");
		}catch(Exception e) {utils.log().info("Clicked on Done Button 4");}
	}

	public void clickNextButton()
	{
		String selector = "**/XCUIElementTypeButton[`label == \"NEXT\"`]";
		click(nextButton);
		utils.log().info("Name Your Network Page  - Clicked on Next Button");
	}
	
	
	@Override
	public boolean isAt() {
		super.pause();
		return true;
	}
	
}

