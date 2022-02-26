package com.cs.arris.Pages;

import org.apache.commons.lang3.time.StopWatch;
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

public class AddSatelliteHomePage extends ParentClass implements Page {
	public TestUtils utils = new TestUtils();
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"BOBAHelp\"]")
	public MobileElement helpIcon;
	
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"Connecting_BOBA_Satellite_Screen_TitleLabel\"])[1]")
	public MobileElement homePageTitle;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Mesh_Home_Screen_Button_LeftExtender\"]")
	public MobileElement leftSatelliteImage;

	@iOSXCUITFindBy(xpath = " //XCUIElementTypeButton[@name=\"Mesh_Home_Screen_Label_LeftExtenderLoading\"]")
	public MobileElement leftSatelliteExtender;
	
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"Connecting_BOBA_Satellite_Screen_SubTitleLabel\"])[1]")
	public MobileElement rightSatelliteImage;

	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"Connecting_BOBA_Satellite_Screen_SubTitleLabel\"])[1]")
	public MobileElement rightSatelliteExtender;
	

	public AddSatelliteHomePage() {
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}

//	public boolean clickContinueButton() {
//		if (continueButton.isDisplayed()) {
//			click(continueButton);
//			utils.log().info("Clicked on Continue Button");
//			return true;
//		} else {
//			utils.log().info("Continue Button is not displayed");
//			return false;
//		}
//	}
	
	public boolean clickHelpButton() {
		if (helpIcon.isDisplayed()) {
			click(helpIcon);
			utils.log().info("Clicked on Help Button");
			return true;
		} else {
			utils.log().info("Help Button is not displayed");
			return false;
		}
	}

	@Override
	public boolean isAt() {
		if (homePageTitle.isDisplayed()) {
			utils.log().info("On HOME Page");
			return true;
		} else {
			utils.log().info("Not on HOME Page");
			return false;
		}
	}
}



//Left Satellite  Left Button(contains satellite image) - //XCUIElementTypeButton[@name="Mesh_Home_Screen_Button_LeftExtender"]
//
//Left Satellite Left Label Loading - //XCUIElementTypeButton[@name="Mesh_Home_Screen_Label_LeftExtenderLoading"]
//
//Left Satellite Left Label(Name)- //XCUIElementTypeButton[@name="Mesh_Home_Screen_Label_LeftExtender"]
//
//Left Satellite Left Connected devices - //XCUIElementTypeButton[@name="Mesh_Home_Screen_Label_LeftAPWithDevices"]
//
//Left Satellite Left speed  - //XCUIElementTypeButton[@name="Mesh_Home_Screen_Label_SpeedWithLeft"]
//
//
//
//Right Satellite Right Button(contains satellite image) - //XCUIElementTypeButton[@name="Mesh_Home_Screen_Button_RightExtender"]
//
//Right Satellite  Right Label Loading - //XCUIElementTypeButton[@name="Mesh_Home_Screen_Label_RightExtenderLoading"]
//
//Right Satellite Left Label(Name)- //XCUIElementTypeButton[@name="Mesh_Home_Screen_Label_RightExtender"]
//
//Right Satellite Left Connected devices - //XCUIElementTypeButton[@name="Mesh_Home_Screen_Label_RightAPWithDevices"]
//
//Right Satellite Left speed  - //XCUIElementTypeButton[@name="Mesh_Home_Screen_Label_SpeedWithRight"]