package com.cs.arris.Pages;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.cs.arris.Base.ParentClass;
import com.cs.arris.Interface.Page;
import com.cs.arris.Utilities.Direction;
import com.cs.arris.Utilities.SwipeActions;
import com.cs.arris.Utilities.TestUtils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class NetworkEnableGuestNetworkDialog extends ParentClass implements Page {
	public TestUtils utils = new TestUtils();

	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Network_Settings_Screen_Button_EditClose\"]")
	public MobileElement closeButton;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Network_Settings_Screen_Label_EditHeader\"]")
	public MobileElement enableGuestNetworkTitle;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Network_Settings_Screen_Label_EditSubHeader\"]")
	public MobileElement enableGuestNetworkDescription;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Network_Settings_Screen_Label_EditDesc\"]")
	public MobileElement enableGuestNetworkDescription2;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Network_Settings_Screen_Label_EditNetwork\"]")
	public MobileElement networkSSIDNameLabel;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeTextField[@name=\"Network_Settings_Screen_TextField_EditSSID\"]")
	public MobileElement enterNetworkSSIDNameTextBox;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Network_Settings_Screen_Label_EditPassword\"]")
	public MobileElement passwordLabel;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeSecureTextField[@name=\"Network_Settings_Screen_TextField_EditPassword\"]")
	public MobileElement enterPasswordTextBox;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Network_Settings_Screen_Button_EditEyeIcon\"]")
	public MobileElement showHidePasswordIcon;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Network_Settings_Screen_Label_EditSecurity\"]")
	public MobileElement securityTypeLabel;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeTextField[@name=\"Network_Settings_Screen_TextField_EditMode\"]")
	public MobileElement securityTypeText; // WPA2-PSK (AES)

	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Network_Settings_Screen_Button_EditSave\"]")
	public MobileElement saveChangesButton;
	
//	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Network_Settings_Screen_Button_BandClose\"]")
//	public MobileElement ssidErrorMessage;
//	
//	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Network_Settings_Screen_Button_BandClose\"]")
//	public MobileElement passwordErrorMessage;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Done\"]")
	public MobileElement doneLink;

	public NetworkEnableGuestNetworkDialog() {
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}

	public boolean clickCloseButton() {
		if (closeButton.isDisplayed()) {
			click(closeButton);
			utils.log().info("Clicked on Close Button");
			return true;
		} else {
			utils.log().info("Close button is not displayed");
			return false;
		}
	}

	public boolean clickSaveChangesButton() {
		click(doneLink);
		if (saveChangesButton.isDisplayed()) {
			click(saveChangesButton);
			utils.log().info("Clicked on Save Changes Button");
			return true;
		} else {
			utils.log().info("Save Changes button is not displayed");
			return false;
		}
	}

	public boolean clickShowPasswordButton() {
		if (showHidePasswordIcon.isDisplayed()) {
			click(showHidePasswordIcon);
			utils.log().info("Clicked on Show Password Icon");
			return true;
		} else {
			utils.log().info("Show Password Icon is not displayed");
			return false;
		}
	}
	
	public boolean enterGuestNetworkName() {
		if (enterNetworkSSIDNameTextBox.isDisplayed()) {
			clear(enterNetworkSSIDNameTextBox);
			sendKeys(enterNetworkSSIDNameTextBox, super.generateGuestNetworkeName());
			utils.log().info("Entered Guest Network Name");
			return true;
		} else {
			utils.log().info("Guest Network Name Text Box is not displayed");
			return false;
		}
	}
	
	public boolean enterGuestNetworkPassword() {
		if (enterPasswordTextBox.isDisplayed()) {
			clear(enterPasswordTextBox);
			sendKeys(enterPasswordTextBox, "1234567890");
			utils.log().info("Entered Guest Network Password");
			return true;
		} else {
			utils.log().info("Guest Network Password Text Box is not displayed");
			return false;
		}
	}
	
	
	public boolean verifyUIOnGuestNetworkPage() {
		utils.log().info("                                                     ");
		utils.log().info("*****************************************************");
		utils.log().info("Verifying UI Elements on Enable Guest Network Dialog ");
		utils.log().info("*****************************************************");
		try {
			if (enableGuestNetworkTitle.isDisplayed())
				utils.log().info(enableGuestNetworkTitle.getText() + " title text is displayed ");

			if (closeButton.isDisplayed())
				utils.log().info("Close Icon is displayed ");

			if (enableGuestNetworkDescription.isDisplayed())
				utils.log().info("Please create an SSID and a password for your guests to access the guest network is displayed");
			
			if (enableGuestNetworkDescription2.isDisplayed())
				utils.log().info("ENote: After Guest Network is enabled and changes are saved, it may take a few minutes for the guest network to be enabled and visible. Your device may become disconnected temporarily from the current network is displayed");

			if (networkSSIDNameLabel.isDisplayed())
				utils.log().info("Network SSID label is displayed");

			if (enterNetworkSSIDNameTextBox.isDisplayed())
				utils.log().info("Text Box to enter Network SSID is displayed");

			if (passwordLabel.isDisplayed())
				utils.log().info("Password label is displayed");

			if (enterPasswordTextBox.isDisplayed())
				utils.log().info("Text Box to enter Password is displayed");

			if (showHidePasswordIcon.isDisplayed())
				utils.log().info("Show Password Icon is displayed ");

			if (securityTypeLabel.isDisplayed())
				utils.log().info("Security Type label is displayed");

			if (securityTypeText.isDisplayed())
				utils.log().info("Security Type - WPA2-PSK (AES) - is displayed");

			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
//	public boolean validateGuestNetworkPage() {
//		utils.log().info("                                          ");
//		utils.log().info("******************************************");
//		utils.log().info("Enable Guest Network Dialog Validations   ");
//		utils.log().info("******************************************");
//		try {
//			this.clickSaveChangesButton();
//			utils.log().info("Clicked on Save Changes Button without entering SSID Name ");
//			
//			if(ssidErrorMessage.isDisplayed())
//				utils.log().info("Validation Message : " + ssidErrorMessage.getText() + " is displayed ");
//			
//			super.getDriver().hideKeyboard();
//			sendKeys(enterNetworkSSIDNameTextBox, "guestnet");
//			this.clickSaveChangesButton();
//			utils.log().info("Clicked on Save Changes Button without entering Password");
//			
//			if(passwordErrorMessage.isDisplayed())
//				utils.log().info("Validation Message : " + passwordErrorMessage.getText() + " is displayed ");
//			
//			clear(enterNetworkSSIDNameTextBox);
//			clear(enterPasswordTextBox);
//			return true;
//		} catch (Exception e) {
//			return false;
//		}
//	}
	
	@Override
	public boolean isAt() {
		if (enableGuestNetworkTitle.isDisplayed()) {
			utils.log().info("On Enable Guest Network Dialog");
			return true;
		} else {
			utils.log().info("Not on Enable Guest Network Dialog");
			return false;
		}
	}
}
