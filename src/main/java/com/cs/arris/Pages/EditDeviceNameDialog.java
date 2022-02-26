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

public class EditDeviceNameDialog extends ParentClass implements Page
{
	public TestUtils utils = new TestUtils();
	String deviceOrgName;
	String deviceOrgName1;
	String editedName;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Edit_Device_Name_Screen_TitleLabel\"]")
	public MobileElement editDeviceNameTitle; 
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Edit_Device_Name_Screen_SubTitleLabel\"]")//Please enter a name for this device
	public MobileElement editDeviceNameText; 
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Edit_Device_Name_Screen_Label_Device\"]") //Enter Device Name  Label
	public MobileElement enterDeviceNameLabel;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name=\"Edit_Device_Name_Screen_TextField_Device\"]")//Enter Device Name
	public MobileElement enterDeviceName;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Edit_Device_Name_Screen_Label_Select\"]") //Select Your Device Type Label
	public MobileElement selectYourDeviceTypeLabel;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Edit_Device_Name_Screen_Label_DeviceName\"]")
	public MobileElement selectYourDeviceTypeListBox;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Edit_Device_Name_Screen_Button\"]") 
	public MobileElement saveButton; 
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Edit_Device_Name_Screen_Button_Close\"]") 
	public MobileElement closeButton; 
	
	
	public EditDeviceNameDialog()
	{
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}
	
	public boolean verifyUIOnEditDeviceNameDialog() {
		utils.log().info("                        ");
		utils.log().info("************************");
		utils.log().info("Edit Device Name Dialog ");
		utils.log().info("************************");
		try {
			if (editDeviceNameTitle.isDisplayed())
				utils.log().info(editDeviceNameTitle.getText() + " title is displayed");
			else
				utils.log().info("EDIT DEVICE NAME title is not displayed");

			if (editDeviceNameText.isDisplayed())
				utils.log().info(editDeviceNameText.getText() + " text is displayed");
			else
				utils.log().info("Enter Device Name text is not displayed");

			if (enterDeviceNameLabel.isDisplayed())
				utils.log().info(enterDeviceNameLabel.getText() + " text is displayed");
			else
				utils.log().info("Enter Device Name Label is not displayed");

			if (enterDeviceName.isDisplayed())
				utils.log().info("Enter Device Name text box is displayed");
			else
				utils.log().info("Enter Device Name text box is not displayed");

			if (selectYourDeviceTypeLabel.isDisplayed())
				utils.log().info(selectYourDeviceTypeLabel.getText() + " label is displayed");
			else
				utils.log().info("Select your device type label is not displayed");

			if (selectYourDeviceTypeListBox.isDisplayed())
				utils.log().info("Select your device list box is displayed");
			else
				utils.log().info("Select your device list box is not displayed");

			if (saveButton.isDisplayed())
				utils.log().info(saveButton.getText() + " button is displayed");
			else
				utils.log().info("SAVE CHANGES button is not displayed");

			if (closeButton.isDisplayed())
				utils.log().info("Close Icon is displayed");
			else
				utils.log().info("Close Icon is not displayed");

			return true;
		} catch (Exception e) {
			return false;
		}
	}
		
	public boolean clickSaveButton() {
		if (saveButton.isDisplayed()) {
			click(saveButton);
			utils.log().info("Clicked on Save Changes Button");
			super.pause(3);
			return true;
		} else {
			utils.log().info("Save Changes button is not displayed");
			return false;
		}
	}
	
		public boolean clickCloseButton() {
			if (closeButton.isDisplayed()) {
				click(closeButton);
				utils.log().info("Clicked on Close Icon");
				return true;
			} else {
				utils.log().info("Close Icon is not displayed");
				return false;
			}
		}
	
		public boolean editDeviceName() {
			try {
				String device = enterDeviceName.getText();
				deviceOrgName = device;
				deviceOrgName1 = deviceOrgName;
				editedName = device + "-1";
				super.editedDeviceName = editedName;
				super.clear(enterDeviceName);
				super.sendKeys(enterDeviceName, editedName);
				utils.log().info("Changed device name from " + deviceOrgName + " to " + editedName);
				return true;
			} catch (Exception e) {
				utils.log().info("Edit Device name text box is not displayed");
				return false;
			}
		}
		public boolean editDeviceName2() {
			try {
				super.clear(enterDeviceName);
				super.sendKeys(enterDeviceName, deviceOrgName);
				utils.log().info("Changed device name from " + editedName + " to " + deviceOrgName1);
				return true;
			} catch (Exception e) {
				utils.log().info("Edit Device name text box is not displayed");
				return false;
			}
		}
	
	
		@Override
		public boolean isAt() {
			if (editDeviceNameTitle.isDisplayed()) {
				utils.log().info("On Edit Device Name Dialog");
				return true;
			} else {
				utils.log().info("Not on Edit Device Name Dialog");
				return false;
			}
		}
}
