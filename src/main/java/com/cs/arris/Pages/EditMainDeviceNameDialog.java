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

public class EditMainDeviceNameDialog extends ParentClass implements Page
{
	public TestUtils utils = new TestUtils();
	String deviceOrgName1;
	String deviceOrgName2;
	String editedName;

	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Edit_Device_Name_Screen_TitleLabel\"]") //EDIT DEVICE NAME
	public MobileElement editDeviceNameTitle; 
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Edit_Device_Name_Screen_SubTitleLabel\"]") //Please enter a name for this device
	public MobileElement editDeviceNameText; 
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Edit_Device_Name_Screen_Label_Device\"]") //Enter Device Name  Label
	public MobileElement enterDeviceNameLabel;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name=\"Edit_Device_Name_Screen_TextField_Device\"]") //Enter Device Name
	public MobileElement enterDeviceName;
	
//	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Edit_Device_Name_Screen_Button\"]") 
	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"SAVE CHANGES\"`]") 
	public MobileElement saveButton; 
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Edit_Device_Name_Screen_Button_Close\"]") 
	public MobileElement closeButton; 
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Done\"]")
	public MobileElement doneLink;
	
	//Edit MAIN Device name success
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"Error_Alert_Screen_Image_Close\"]")
	public MobileElement closeIcon;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Error_Alert_Screen_TitleLabel\"]")
	public MobileElement successTitle;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Error_Alert_Screen_SubTitleLabel\"]")
	public MobileElement successSubTitle;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Error_Alert_Screen_Button\"]")
	public MobileElement okButton;
	
	
	public EditMainDeviceNameDialog()
	{
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}
	
	public boolean verifyUIOnEditDeviceNameDialog() {
		utils.log().info("                             ");
		utils.log().info("*****************************");
		utils.log().info("Edit Main Device Name Dialog ");
		utils.log().info("*****************************");
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
				utils.log().info(enterDeviceNameLabel.getText() + " Label is displayed");
			else
				utils.log().info("Enter Device Name Label is not displayed");

			if (enterDeviceName.isDisplayed())
				utils.log().info("Enter Device Name text box is displayed");
			else
				utils.log().info("Enter Device Name text box is not displayed");

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
		click(doneLink);
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
	
		public boolean clickCloseIconn() {
			if (closeIcon.isDisplayed()) {
				click(closeIcon);
				utils.log().info("Clicked on Close Icon");
				return true;
			} else {
				utils.log().info("Close Icon is not displayed");
				return false;
			}
		}
		
		public boolean clickOkButton() {
			if (okButton.isDisplayed()) {
				click(okButton);
				utils.log().info("Clicked on OK Icon");
				return true;
			} else {
				utils.log().info("OK Button is not displayed");
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
	
	public boolean editMainDeviceName() {
		try {
			String device = enterDeviceName.getText();
			deviceOrgName1 = device; 
			editedName = device + "1";
			super.editedMainDeviceName = editedName;
			super.clear(enterDeviceName);
			super.sendKeys(enterDeviceName, editedName);
			utils.log().info("Changed Main Router name from " + deviceOrgName1 + " to " + editedName);
			return true;
		} catch (Exception e) {
			utils.log().info("Edit Router name text box is not displayed");
			return false;
		}
	}
	
	public boolean editMainDeviceName2() {
		try {
			super.clear(enterDeviceName);
			super.sendKeys(enterDeviceName, "MAIN");
			return true;
		} catch (Exception e) {
			utils.log().info("Edit Router name text box is not displayed");
			return false;
		}
	}
	
	@Override
	public boolean isAt() {
		if (editDeviceNameTitle.isDisplayed()) {
			utils.log().info("On Edit Main Device Name Dialog");
			return true;
		} else {
			utils.log().info("Not on Edit Main Device Name Dialog");
			return false;
		}
	}
}
