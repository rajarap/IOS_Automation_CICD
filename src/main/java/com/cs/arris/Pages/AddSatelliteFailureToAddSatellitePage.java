package com.cs.arris.Pages;

import org.apache.commons.lang3.time.StopWatch;
import org.openqa.selenium.support.PageFactory;

import com.cs.arris.Base.ParentClass;
import com.cs.arris.Interface.Page;
import com.cs.arris.Utilities.TestUtils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.touch.offset.PointOption;

public class AddSatelliteFailureToAddSatellitePage extends ParentClass implements Page {
	public TestUtils utils = new TestUtils();
	public TouchAction action = new TouchAction(getDriver());
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"BOBAHelp\"]")
	public MobileElement helpIcon;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"BOBA Arrow\"]")
	public MobileElement backIcon;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"OB_Error_Screen_TitleLabel\"]")
	public MobileElement failuertoAddSatelliteTitle;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Failure_To_Add_Satellite_Screen_SubTitleLabel\"]")
	public MobileElement failuertoAddSatelliteSubTitle;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Failure_To_Add_Satellite_Screen_Button\"]")
	public MobileElement willDoLaterButton;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Failure_To_Add_Satellite_Screen_Button_Retry\"]")
	public MobileElement retryButton;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Failure_To_Add_Satellite_Screen_Label_Error\"]")
	public MobileElement errCode0000_2212;
	

	public AddSatelliteFailureToAddSatellitePage() {
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}

	public boolean clickWillDoLaterButton() {
		if (willDoLaterButton.isDisplayed()) {
			click(willDoLaterButton);
			utils.log().info("Clicked on I'll do it later Button");
			return true;
		} else {
			utils.log().info("I'll do it later Button is not displayed");
			return false;
		}
	}
	
	public boolean clickRetryButton() {
		if (retryButton.isDisplayed()) {
			click(retryButton);
			utils.log().info("Clicked on Retry Button");
			return true;
		} else {
			utils.log().info("Retry Button is not displayed");
			return false;
		}
	}
	
	public void checkError() {
		int x = 187;
		int y = 458;
		PointOption p = new PointOption();
		p.point(x, y);
		
		for(int i=0; i <=7; i++) {
			action.tap(p);
			action.release().perform();
		}
	}
	
	@Override
	public boolean isAt() {
		if (failuertoAddSatelliteTitle.isDisplayed()) {
			utils.log().info("On Failure to add satellite failed Page");
			return true;
		} else {
			utils.log().info("Not on Failure to add satellite failed Page");
			return false;
		}
	}
}
