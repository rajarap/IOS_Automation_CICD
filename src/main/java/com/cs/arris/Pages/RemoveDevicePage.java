package com.cs.arris.Pages;

import java.util.List;

import org.apache.commons.lang3.time.StopWatch;
import org.openqa.selenium.By;
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

public class RemoveDevicePage extends ParentClass implements Page
{
	public TestUtils utils = new TestUtils();
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Remove_Device_Screen_TitleLabel\"]")
	public MobileElement selectDeviceTitle;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"NavigationBar_Button_Help\"]")
	public MobileElement helpIcon;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"NavigationBar_Button_Back\"]")
	public MobileElement backIcon;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Remove_Device_Screen_Button_Next\"]")
	public MobileElement nextButton;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Remove_Device_Screen_Label_Description[1]\"]")
	public MobileElement deviceName1;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"Remove_Device_Screen_Image_Box[1]\"]")
	public MobileElement radioButton1;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Remove_Device_Screen_Label_Description[2]\"]")
	public MobileElement deviceName2;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"Remove_Device_Screen_Image_Box[2]\"]")
	public MobileElement radioButton2;

	public RemoveDevicePage() {
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}

	public boolean clickBackButton() {
		if (backIcon.isDisplayed()) {
			click(backIcon);
			utils.log().info("Clicked on Back Button");
			return true;
		} else {
			utils.log().info("Back Button is not displayed");
			return false;
		}
	}

	public boolean clickHelpButton() {
		if (helpIcon.isDisplayed()) {
			click(helpIcon);
			utils.log().info("Clicked on help Button");
			return true;
		} else {
			utils.log().info("Help button is not displayed");
			return false;
		}
	}

	public boolean clickNextButton() {
		if (nextButton.isDisplayed()) {
			click(nextButton);
			super.pause(3);
			utils.log().info("Clicked on Next Button");
			return true;
		} else {
			utils.log().info("Next Button is not displayed");
			return false;
		}
	}
	
	public boolean selectDeviceToRemove()
	{
		if(deviceName2.isDisplayed()){
			utils.log().info("Selected Device Name : " + deviceName2.getText());
			click(radioButton2);
			return true;
		}else {
				return false;
		}
	}
	

	@Override
	public boolean isAt() {
		if (selectDeviceTitle.isDisplayed()) {
			utils.log().info("On Remove Device - Select Your Device Page");
			return true;
		} else {
			utils.log().info("Not on Remove Device - Select Your Device Page");
			return false;
		}
	}
}