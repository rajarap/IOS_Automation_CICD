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

public class InstallAdditionalSatellitePage extends ParentClass implements Page
{
	public TestUtils utils = new TestUtils();
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Install_Additional_Satellite_Screen_TitleLabel\"]")
	public MobileElement installAdditionalSatelliteTitleText; 
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Install_Additional_Satellite_Screen_SubTitleLabel\"]")
	public MobileElement installAdditionalSatelliteDescription; 

	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Install_Additional_Satellite_Screen_Button_Now\"]")
	public MobileElement installNowButton; 

	@iOSXCUITFindBy(xpath="//XCUIElementTypeImage[@name=\"Install_Additional_Satellite_Screen_Image\"]")
	public MobileElement closeButton; 
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Install_Additional_Satellite_Screen_Button_Later\"]")
	public MobileElement installLaterButton; 

	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"I do not have a satellite\"]")
	public MobileElement dontHaveSatelliteLink;
	
	
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"“SBC Test” Would Like to Send You Notifications\"]")
	public MobileElement SBCNotificationTitle; 
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Notifications may include alerts, sounds, and icon badges. These can be configured in Settings.\"]")
	public MobileElement SBCNotificationSubTitle; 
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Allow\"]")
	public MobileElement allowButton; 
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Don’t Allow\"]")
	public MobileElement dontAllowButton; 
	
	public InstallAdditionalSatellitePage()
	{
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}
	
	public void clickAllowButton()
	{
		String selector = "**/XCUIElementTypeButton[`label == \"Allow\"`]";
		click(allowButton);
		utils.log().info("Clicked on Allow Button to send Notifiations");
	}
	
	public void clickInstallLaterButton()
	{
		String selector = "**/XCUIElementTypeButton[`label == \"Allow\"`]";
		click(installLaterButton);
		utils.log().info("Install Additonal Satellite Dialog - Clicked on Install Later Button");
	}
	
//	public void clickInstallNowButton()
//	{
//		click(installNowButton);
//		utils.log().info("Clicked on Install Now Button");
//	}
//	
//	public void clickCancelButton()
//	{
//		click(cancelButton);
//		utils.log().info("Clicked on Cancel Button");
//	}
	
	
	@Override
	public boolean isAt() {
		super.pause();
		return true;
	}

}
