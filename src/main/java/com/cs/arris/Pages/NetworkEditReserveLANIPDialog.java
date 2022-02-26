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

public class NetworkEditReserveLANIPDialog extends ParentClass implements Page {
	public TestUtils utils = new TestUtils();

	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Network_Lan_IP_Reservation_Screen_Button_AddLan\"]")
	public MobileElement closeIcon;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Network_Lan_IP_Reservation_Screen_Label_AddLan\"]")
	public MobileElement editlanIPTitle;

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

//	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Network_Lan_IP_Reservation_Screen_Button_AddLan\"]")
//	public MobileElement enterIPAddressTextBox;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeTextField[@name=\"Network_Lan_IP_Reservation_Screen_TextField_IPValue\"]")
	public MobileElement enterIPAddressPrefixTextBox;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeTextField[@name=\"Network_Lan_IP_Reservation_Screen_TextField_IP\"]")
	public MobileElement enterIPAddressSuffixTextBox;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Network_Lan_IP_Reservation_Screen_Button_Save\"]")
	public MobileElement saveButton;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Done\"]")
	public MobileElement doneLink;
	

	public NetworkEditReserveLANIPDialog() {
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
	//	((IOSDriver) super.getDriver()).hideKeyboard(HideKeyboardStrategy.PRESS_KEY, "Done");
	//	click(doneLink);

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

	public boolean editRuleName() {
		if (ruleNameTextBox.isDisplayed()) {
			super.clear(ruleNameTextBox);
			super.generateRuleName();
			super.sendKeys(ruleNameTextBox, super.ruleName);
			utils.log().info("Enter Rule Name : " + super.ruleName);
			return true;
		} else {
			utils.log().info("Rule Name is not entered");
			return false;
		}
	}

	public boolean editIPAddress() {
		if (enterIPAddressSuffixTextBox.isDisplayed()) {
			super.clear(enterIPAddressSuffixTextBox);
			super.generateRandomIPNumber();
			super.sendKeys(enterIPAddressSuffixTextBox, String.valueOf(super.ipNumber));
			utils.log().info("Entered IP Address : " + enterIPAddressSuffixTextBox.getText());
			return true;
		} else {
			utils.log().info("IP Address is not enterned");
			return false;
		}
	}

	public boolean verifyUIOnEditReserveLANIP() {
		utils.log().info("                                                   ");
		utils.log().info("***************************************************");
		utils.log().info("Verifying Edit Elements on Reserve A LAN IP Dialog ");
		utils.log().info("***************************************************");

		try {
			if (editlanIPTitle.isDisplayed())
				utils.log().info(editlanIPTitle.getText() + " title text is displayed ");
			else
				utils.log().info("EDIT LAN IP title text is not displayed");

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
			
			if (enterIPAddressPrefixTextBox.isDisplayed())
				utils.log().info("Prefix IP Address : " + enterIPAddressPrefixTextBox.getText());
			else
				utils.log().info("Prefix IP Address is not displayed");
			
			if (enterIPAddressSuffixTextBox.isDisplayed())
				utils.log().info("Suffix IP Address : " + enterIPAddressSuffixTextBox.getText());
			else
				utils.log().info("Suffix IP Address is not displayed");

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
		if (editlanIPTitle.isDisplayed()) {
			utils.log().info("On EDIT LAN IP Reservation Page");
			return true;
		} else {
			utils.log().info("Not on EDIT LAN IP Reservation Page");
			return false;
		}
	}
}
