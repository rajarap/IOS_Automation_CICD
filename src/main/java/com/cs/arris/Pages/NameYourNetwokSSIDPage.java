package com.cs.arris.Pages;

import org.openqa.selenium.support.PageFactory;

import com.cs.arris.Base.ParentClass;
import com.cs.arris.Interface.Page;
import com.cs.arris.Utilities.TestUtils;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITBy;
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
			iosDriver = (IOSDriver<?>) super.getDriver();
			
			try {
				utils.log().info("Inside clickDoneLink1");
				String acc = "Done";
				iosDriver.findElement(MobileBy.AccessibilityId(acc)).click();
				utils.log().info("Name Your Network Page  - Clicked on Done Button identified by accessiblity id");
				super.pause(3);
			} catch (Exception e) {}

			try {
				utils.log().info("Inside clickDoneLink2");
				String pred = "label == \"Done\"";
				iosDriver.findElement(MobileBy.iOSNsPredicateString(pred)).click();
				utils.log().info("Name Your Network Page  - Clicked on Done Button identified by Predicate string");
				super.pause(3);
			} catch (Exception e) {}

			try {
				utils.log().info("Inside clickDoneLink3");
				String selector = "**/XCUIElementTypeButton[`label == \"Done\"`]";
				iosDriver.findElement(MobileBy.iOSClassChain(selector)).click();
				utils.log().info("Name Your Network Page  - Clicked on Done Button identified by iOS Chain Class");
				super.pause(3);
			} catch (Exception e) {}

			try {
				utils.log().info("Inside clickDoneLink4");
				click(doneLink);
				utils.log().info("Name Your Network Page  - Clicked on Done Button identified by xpath");
				super.pause(3);
				utils.log().info("Name Your Network Page  - Clicked on Done Button");
			} catch (Exception e) {}
		}

	public void clickNextButton()
	{
		
//		//String selector = "**/XCUIElementTypeButton[`label == \"NEXT\"`]";
//		iosDriver.hideKeyboard(iosDriver.findElementByXPath("//XCUIElementTypeButton[@name=\"Done\"]"));
//		iosDriver.hideKeyboard(HideKeyboardStrategy.PRESS_KEY, "Done");
//		super.getDriver().findElementByXPath("//XCUIElementTypeButton[@name=\"BOBA_Network_Connect_Screen_Button\"]").click();
		
		iosDriver = (IOSDriver<?>) super.getDriver();
		
		try {
			iosDriver.hideKeyboard("Done");
			utils.log().info("Name Your Network Page  - Clicked on Done Button iosDriver.hideKeyboard(\"Done\")");
		}catch(Exception e) {}
		
		try {
			iosDriver.findElementByXPath("//XCUIElementTypeButton[@name=\"Done\"]").click();
			utils.log().info("Name Your Network Page  - Clicked on Done Button iosDriver.findElementByXPath(\"//XCUIElementTypeButton[@name=\\\"Done\\\"]\").click()");
		}catch(Exception e) {}
		
		click(nextButton);
		
		utils.log().info("Name Your Network Page  - Clicked on Next Button");
		super.pause(3);
		
	}
	
	
	
	@Override
	public boolean isAt() {
		if(nameYourHomeNetworkText.isDisplayed())
		{
			utils.log().info("On LET’S NAME YOUR HOME NETWORK Page");
			return true;
		}
		else
		{
			utils.log().info("Not on LET’S NAME YOUR HOME NETWORK Page");
			return false;
		}
	}
	
}

