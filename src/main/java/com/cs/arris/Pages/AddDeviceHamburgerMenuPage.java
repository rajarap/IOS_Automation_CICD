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

public class AddDeviceHamburgerMenuPage extends ParentClass implements Page
{
	public TestUtils utils = new TestUtils();
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Menu_Screen_Label_Option[1]\"]")
	public MobileElement addDevice;  //must be disabled. Onclick of add device, Add device dialog box should be displayed

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Menu_Screen_Label_Option[2]\"]")
	public MobileElement removeDevice;
	
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Error_Alert_Screen_TitleLabel\"]")
	public MobileElement disabledAddDeviceButton;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Error_Alert_Screen_SubTitleLabel\"]")
	public MobileElement subTitle; //You have added maximum two devices.
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Error_Alert_Screen_Button\"]")
	public MobileElement okButton;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"Error_Alert_Screen_Image_Close\"]")
	public MobileElement closeButton;
	
	//XCUIElementTypeStaticText[@name="Error_Alert_Screen_TitleLabel"]

	public AddDeviceHamburgerMenuPage()
	{
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}
	
	 public HomePage getHomePageObject() {
		 HomePage homePage = new HomePage();
	     return homePage;
	  }
	 
	 public boolean clickAddDeviceButton() {
			if (addDevice.isDisplayed()) {
				click(addDevice);
				utils.log().info("Clicked on Add Device Button");
				return true;
			} else {
				utils.log().info("Add Device button is not displayed");
				return false;
			}
		}

		public boolean clickRemoveDeviceButton() {
			if (removeDevice.isDisplayed()) {
				click(removeDevice);
				utils.log().info("Clicked on Remove Device Button");
				return true;
			} else {
				utils.log().info("Remove Device Button is not displayed");
				return false;
			}
		}
		
		 public boolean clickOkButton() {
			if (okButton.isDisplayed()) {
				utils.log().info(subTitle.getText());
				click(okButton);
				utils.log().info("Clicked on OK Button");
				return true;
			} else {
				utils.log().info("OK button is not displayed");
				return false;
			}
		}

	@Override
	public boolean isAt() {
		if (addDevice.isDisplayed()) {
			utils.log().info("On Add Device - Hamburger Menu Page");
			return true;
		} else {
			utils.log().info("Not on Add Device - Hamburger Menu Page");
			return false;
		}
	}
}
