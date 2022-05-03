package com.cs.arris.Pages;

import org.openqa.selenium.support.PageFactory;

import com.cs.arris.Base.ParentClass;
import com.cs.arris.Interface.Page;
import com.cs.arris.Utilities.TestUtils;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class InternetConnectionNotAvailablePage extends ParentClass implements Page
{
	public TestUtils utils = new TestUtils();
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"OB_Error_Screen_TitleLabel\"]")
	public MobileElement internetConnectionNotAvailableTitle;
	
	//Internet connection is currently NOT available on your mobile device.
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"OB_Error_Screen_SubTitleLabel\"]")
	public MobileElement internetConnectionNotAvailableSubTitle;

	//0013-1203
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"OB_Error_Screen_Label\"]")
	public MobileElement errorCode;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"TRY AGAIN\"]")
	public MobileElement tryAgain;
	
	@iOSXCUITFindBy (iOSClassChain = "**/XCUIElementTypeButton[`label == \"Settings\"`]")
	public MobileElement settings1;
	
	public InternetConnectionNotAvailablePage()
	{
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}
	
	public void clickTryAgaineButton()
	{
		utils.log().info("Clicked on Try Again Button");
		click(tryAgain);
	}
	
//	public boolean enableWifi() {
//		try {
//			String str = super.getDriver().findElement(MobileBy.iOSClassChain("**/XCUIElementTypeSwitch[`label == \"Wi-Fi\"`]")).getAttribute("value");
//			int value = Integer.parseInt(str);
//			if(value == 0)  //disabled
//			{
//				//click(parentalControlToggleButton);  click to enable parental control switch button
//				super.getDriver().findElement(MobileBy.iOSClassChain("**/XCUIElementTypeSwitch[`label == \"Wi-Fi\"`]")).click();
//				utils.log().info("WiFi is enabled.");
//			}else {
//				utils.log().info("WiFi is already enabled.");
//			}
//			return true;
//		} catch(Exception e) {
//			utils.log().info("Issue in enabling WiFi");
//			return true;
//		}
//	}
	
	public void enableWifi()
	{
		try
		{
			utils.log().info("Opening System Preferences on iPhone");
			super.getDriver().activateApp("com.apple.Preferences");
			super.swipeDown();
				
			String wifiLink = "**/XCUIElementTypeStaticText[`label == \"Wi-Fi\"`]";
			if(super.getDriver().findElement(MobileBy.iOSClassChain(wifiLink)).isDisplayed())
				super.getDriver().findElement(MobileBy.iOSClassChain(wifiLink)).click();
			super.pause(5);

			String str = super.getDriver().findElement(MobileBy.iOSClassChain("**/XCUIElementTypeSwitch[`label == \"Wi-Fi\"`]")).getAttribute("value");
			int value = Integer.parseInt(str);
			if(value == 0)  //disabled
			{
				//click(parentalControlToggleButton);  click to enable parental control switch button
				super.getDriver().findElement(MobileBy.iOSClassChain("**/XCUIElementTypeSwitch[`label == \"Wi-Fi\"`]")).click();
				utils.log().info("WiFi is enabled.");
			}else {
				utils.log().info("WiFi is already enabled.");
			}
			super.pause(5);
			click(settings1);
			utils.log().info("Clicked on Settings link");
			super.getDriver().activateApp("com.arris.sbcBeta");
		}catch(Exception e) {}
	}
	
	
	
	@Override
	public boolean isAt() {
		if(internetConnectionNotAvailableTitle.isDisplayed()) {
			utils.log().info("on Internet connection is currently not available on your mobile device page");
			return true;
		}else {
			return false;
		}
	}
}
