package com.cs.arris.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.cs.arris.Base.ParentClass;
import com.cs.arris.Interface.Page;
import com.cs.arris.Utilities.Direction;
import com.cs.arris.Utilities.SwipeActions;
import com.cs.arris.Utilities.TestUtils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.remote.HideKeyboardStrategy;

public class NetworkReserveLANIPDialog extends ParentClass implements Page {
	public TestUtils utils = new TestUtils();

	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Network_Lan_IP_Reservation_Screen_Button_AddLan\"]")
	public MobileElement closeIcon;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Network_Lan_IP_Reservation_Screen_Label_AddLan\"]")
	public MobileElement reservelanIPTitle;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Network_Lan_IP_Reservation_Screen_Label_AddLanSubTitle\"]")
	public MobileElement reservelanIPMessage1;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Network_Lan_IP_Reservation_Screen_Label_AddLanInfo\"]")
	public MobileElement reservelanIPMessage2;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Network_Lan_IP_Reservation_Screen_Label_EnterRule\"]")
	public MobileElement enterRuleNameLabel;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeTextField[@name=\"Network_Lan_IP_Reservation_Screen_TextField_Rule\"]")
	public MobileElement ruleNameTextBox;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Network_Lan_IP_Reservation_Screen_Label_EnterIP\"]")
	public MobileElement enterIPAddressLabel;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Network_Lan_IP_Reservation_Screen_Label_AddLan\"]")
	public MobileElement enterIPAddressTextBox;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeTextField[@name=\"Network_Lan_IP_Reservation_Screen_TextField_IPValue\"]")
	public MobileElement enterIPAddressPrefixTextBox;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeTextField[@name=\"Network_Lan_IP_Reservation_Screen_TextField_IP\"]")
	public MobileElement enterIPAddressSuffixTextBox;

//	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Network_Lan_IP_Reservation_Screen_Label_AddLan\"]")
//	public MobileElement selectDeviceLabel;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Network_Lan_IP_Reservation_Screen_Button_Show\"]")
	public MobileElement selectDeviceListBox;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Network_Lan_IP_Reservation_Screen_Button_Save\"]")
	public MobileElement saveButton;

	public NetworkReserveLANIPDialog() {
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}

	public HomePage getHomePageObject() {
		HomePage homePage = new HomePage();
		return homePage;
	}

	public FooterIconsPage getFooterIconsPageObject() {
		FooterIconsPage footerIconsPage = new FooterIconsPage();
		return footerIconsPage;
	}

	public boolean clickSaveButton() {
		((IOSDriver) super.getDriver()).hideKeyboard(HideKeyboardStrategy.PRESS_KEY, "Done");
		if (saveButton.isDisplayed()) {
			click(saveButton);
			utils.log().info("Clicked on Save Changes button");
			return true;
		} else {
			utils.log().info("Save Changes button is not displayed");
			return false;
		}
	}

	public boolean clickCloseIconn() {
		if (closeIcon.isDisplayed()) {
			click(closeIcon);
			utils.log().info("Clicked on Close button");
			return true;
		} else {
			utils.log().info("Close button is not displayed");
			return false;
		}
	}

	public boolean enterRuleName() 
	{
		if(ruleNameTextBox.isDisplayed()) {
		super.generateRuleName();
		super.sendKeys(ruleNameTextBox, super.ruleName);
		utils.log().info("Enter Rule Name : " + super.ruleName);
		return true;
		} else {
			utils.log().info("Rule Name is not entered");
			return false;
		}
	}

	public boolean enterIPAddress() {
		if (enterIPAddressSuffixTextBox.isDisplayed()) {
			super.generateRandomIPNumber();
			super.sendKeys(enterIPAddressSuffixTextBox, String.valueOf(super.ipNumber));
			utils.log().info("Entered IP Address : " + enterIPAddressSuffixTextBox.getText());
			return true;
		} else {
			utils.log().info("IP Address is not enterned");
			return false;
		}
	}

	public boolean selectADevice(int index) {
		if (selectDeviceListBox.isDisplayed()) {
			click(selectDeviceListBox);
//			click(super.getDriver().findElementByXPath("//XCUIElementTypeStaticText[@name=\"Network_Lan_IP_Reservation_Screen_Label_Mac["+index+"]\"]"));
			click(super.getDriver().findElementByXPath("//XCUIElementTypeStaticText[@name=\"Network_Lan_IP_Reservation_Screen_Label_Device["+index+"]\"]"));
			return true;
		} else {
			utils.log().info("No Option to select from list box");
			return false;
		}
	}

	public boolean verifyUIOnReserveLANIP() {
		utils.log().info("                                                 ");
		utils.log().info("*************************************************");
		utils.log().info("Verifying UI Elements on Reserve A LAN IP Dialog ");
		utils.log().info("*************************************************");
		try {
			if (reservelanIPTitle.isDisplayed())
				utils.log().info(reservelanIPTitle.getText() + " title text is displayed ");
			else
				utils.log().info("RESERVE A LAN IP title text is not displayed");

			if (closeIcon.isDisplayed())
				utils.log().info("Close Icon is displayed");
			else
				utils.log().info("Close Icon is not displayed");

			if (reservelanIPMessage1.isDisplayed())
				utils.log().info("Please enter a valid IP for a selected device is displayed");
			else
				utils.log().info("Please enter a valid IP for a selected device. is not displayed");

			if (reservelanIPMessage2.isDisplayed())
				utils.log().info("Please enter IP between 2 and 254 is displayed");
			else
				utils.log().info("PPlease enter IP between 2 and 254 is not displayed");

			if (enterRuleNameLabel.isDisplayed())
				utils.log().info(enterRuleNameLabel.getText() + " label is displayed");
			else
				utils.log().info("Please enter Rule Name Label is not displayed");

			if (ruleNameTextBox.isDisplayed())
				utils.log().info("Text box to enter Rule Name is displayed");
			else
				utils.log().info("Text box to enter Rule Name is not displayed");

			if (enterIPAddressLabel.isDisplayed())
				utils.log().info(enterIPAddressLabel.getText() + " label is displayed");
			else
				utils.log().info("Enter IP Address Label is not displayed");

			if (enterIPAddressTextBox.isDisplayed())
				utils.log().info("Text box to enter IP address is displayed");
			else
				utils.log().info("Text box to enter IP Address is not displayed");
			
			if (enterIPAddressPrefixTextBox.isDisplayed())
				utils.log().info("Prefix IP Address : " + enterIPAddressPrefixTextBox.getText());
			else
				utils.log().info("Prefix IP Address is not displayed");

//			if (selectDeviceLabel.isDisplayed())
//				utils.log().info(selectDeviceLabel.getText() + " label is displayed");
//			else
//				utils.log().info("Select your Device Label is not displayed");

			if (selectDeviceListBox.isDisplayed())
				utils.log().info("List box to select the device is displayed");
			else
				utils.log().info("List box to select the device is not displayed");

			if (saveButton.isDisplayed())
				utils.log().info(saveButton.getText() + " Save Button is displayed");
			else
				utils.log().info("Save Button is not displayed");

		return true;
	} catch (Exception e) {
		return false;
	}
}

	@Override
	public boolean isAt() {
		if (reservelanIPTitle.isDisplayed()) {
			utils.log().info("On Reserve LAN IP Reservation Page");
			return true;
		} else {
			utils.log().info("Not on Reserve LAN IP Reservation Page");
			return false;
		}
	}
}
