package com.cs.arris.Pages;

import org.openqa.selenium.support.PageFactory;

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

public class NetworkWANIPConfigurationIPv6Page extends ParentClass implements Page {
	public TestUtils utils = new TestUtils();

	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"WAN IP Configuration\"]")
	public MobileElement wanIPConfigurationTitle;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeOther[@name=\"NavigationBar_Button_Back\"]")
	public MobileElement backIcon;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeOther[@name=\"NavigationBar_Button_Help\"]")
	public MobileElement helpIcon;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"IPv4\"]")
	public MobileElement wanIPv4Tab;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"IPv6\"]")
	public MobileElement wanIPv6Tab;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Network_Wan_IP_Config_Screen_Button_Stateful\"]")
	public MobileElement statefulRadioButton;

//	@iOSXCUITFindBy(xpath="//XCUIElementTypeOther[@name=\"NavigationBar_Button_Back\"]")
//	public MobileElement statefulRadioButtonUnChecked;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Network_Wan_IP_Config_Screen_Button_Stateless\"]")
	public MobileElement statelessRadioButton;

//	@AndroidFindBy(xpath = "//android.widget.RadioButton[@resource-id='com.arris.sbcBeta:id/radia_stateless' and @checked='false']")
//	public MobileElement statelessRadioButtonUnChecked;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Network_Wan_IP_Config_Screen_Label_IPv6\"]")
	public MobileElement ipv6AddressLabel;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeTextField[@name=\"Network_Wan_IP_Config_Screen_TextField_IPv6\"]")
	public MobileElement ipv6Address;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Network_Wan_IP_Config_Screen_Label_IPv6Prefix\"]")
	public MobileElement ipv6PrefixLengthLabel;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeTextField[@name=\"Network_Wan_IP_Config_Screen_TextField_IPv6Prefix\"]")
	public MobileElement ipv6PrefixLength;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Network_Wan_IP_Config_Screen_Label_IPv6Gateway\"]")
	public MobileElement ipv6GatewayLabel;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeTextField[@name=\"Network_Wan_IP_Config_Screen_TextField_IPv6Gateway\"]")
	public MobileElement ipv6Gateway;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Network_Wan_IP_Config_Screen_Label_IPv6Primary\"]")
	public MobileElement ipv6PrimaryDNSLabel;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeTextField[@name=\"Network_Wan_IP_Config_Screen_TextField_IPv6Primary\"]")
	public MobileElement ipv6PrimaryDNS;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Network_Wan_IP_Config_Screen_Label_IPv6Secondary\"]")
	public MobileElement ipv6SecondayDNSLabel;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeTextField[@name=\"Network_Wan_IP_Config_Screen_TextField_IPv6Secondary\"]")
	public MobileElement ipv6SecondaryDNS;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Network_Wan_IP_Config_Screen_Label_Delegation\"]")
	public MobileElement ipv6PrefixDelegationLabel;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Network_Wan_IP_Config_Screen_Button_IPv6Delegation\"]")
	public MobileElement ipv6PrefixDelegationCheckbox;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Network_Wan_IP_Config_Screen_Button_IPv6\"]")
	public MobileElement stateful_SaveChangesButton_Disabled;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeTextField[@name=\"Network_Wan_IP_Config_Screen_TextField_IPv6Gateway\"]")
	public MobileElement stateful_SaveChangesButton_Enabled;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Network_Wan_IP_Config_Screen_Button_IPv6\"]")
	public MobileElement stateless_SaveChangesButton;

	public NetworkWANIPConfigurationIPv6Page() {
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}

	public NetworkWANIPConfigurationHelpPage getNetworkWANIPConfigurationHelpPageObject() {
		NetworkWANIPConfigurationHelpPage wanIPConfiguration = new NetworkWANIPConfigurationHelpPage();
		return wanIPConfiguration;
	}

	public FooterIconsPage getFooterIconsPageObject() {
		FooterIconsPage footerIconsPage = new FooterIconsPage();
		return footerIconsPage;
	}

	public AppRatingDialog getAppRatingPageObject() {
		AppRatingDialog rating = new AppRatingDialog();
		return rating;
	}

	public NetworkWANIPConfigurationIPv4Page getNetworkWANIPConfigurationIPv4PageObject() {
		NetworkWANIPConfigurationIPv4Page wanIPv4Configuration = new NetworkWANIPConfigurationIPv4Page();
		return wanIPv4Configuration;
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
			return true;
		} else {
			utils.log().info("Help button is not displayed");
			return false;
		}
	}

	public boolean clickWANIPv4Tab() {
		if (wanIPv4Tab.isDisplayed()) {
				click(wanIPv4Tab);
				utils.log().info("Clicked on IPv4 Tab");
			return true;
		} else {
			utils.log().info("IPv4 Tab is not displayed");
			return false;
		}
	}

	public boolean clickStatefulSaveChangesButton() {
		if (stateful_SaveChangesButton_Enabled.isDisplayed()) {
				click(stateful_SaveChangesButton_Enabled);
				utils.log().info("Clicked on Stateful SAVE CHANGES button");
				return true;
		} else {
			utils.log().info("Stateful SAVE CHANGES button is displayed, but is disabled");
			return true;
		}
	}

	public boolean clickStatelessSaveChangesButton() {
		if (stateless_SaveChangesButton.isDisplayed() && stateless_SaveChangesButton.isEnabled()) {
				click(stateless_SaveChangesButton);
				utils.log().info("Clicked on Stateless SAVE CHANGES button");
				return true;
		} else {
			utils.log().info("Stateless SAVE CHANGES button is displayed, but is disabled");
			return true;
		}
	}

	public boolean clickStatefulRadioButton() {
		if (statefulRadioButton.isDisplayed()) {
				utils.log().info("Stateful Radio button is already selected");
				return true;
//		}
//		else if(statefulRadioButtonUnChecked.isDisplayed()) {
//			click(statefulRadioButtonUnChecked);
//			utils.log().info("Clicked on Stateful Radio button");
//			return true;
		} else {
			utils.log().info("Stateful Radio button is not displayed");
			return false;
		}
	}
	
	public boolean clickStatelessRadioButton() {
		if (statelessRadioButton.isDisplayed()) {
			click(statelessRadioButton);
			utils.log().info("Clicked on Stateless Radio button");
			return true;
//		} 
//		else if(statelessRadioButtonChecked.isDisplayed()){
//			utils.log().info("Stateless Radio button is already selected");
//			return true;
		}else {
			utils.log().info("Stateless Radio button is not displayed");
			return false;
		}
	}
	

	public boolean clickPrefixDelegationCheckbox() {
		if (ipv6PrefixDelegationCheckbox.isDisplayed()) {
			click(ipv6PrefixDelegationCheckbox);
			if (stateful_SaveChangesButton_Enabled.isDisplayed()) {
				utils.log().info("SAVE CHANGES button is enabled on click of Prefix Delegation Checkbox");
			}
			utils.log().info("Selected Prefix Delegation Checkbox");
			return true;
		} else {
			utils.log().info("Prefix Delegation Checkbox is not displayed");
			return false;
		}
	}

	public boolean verifyUIOnWANIPv6Stateful() {
		utils.log().info("                                                    ");
		utils.log().info("****************************************************");
		utils.log().info("Verifying WAN IPv6 - Stateful Configuration Settings");
		utils.log().info("****************************************************");

		this.clickStatefulRadioButton();
		try {
			if (wanIPConfigurationTitle.isDisplayed())
				utils.log().info(wanIPConfigurationTitle.getText() + " title text is displayed ");
			else
				utils.log().info("WAN IP Configuration title text is not displayed ");

			if (backIcon.isDisplayed())
				utils.log().info("Back Icon is displayed ");
			else
				utils.log().info("Back Icon is not displayed ");

			if (helpIcon.isDisplayed())
				utils.log().info("Help Icon is displayed");
			else
				utils.log().info("Help icon is not displayed ");

			if (wanIPv6Tab.isDisplayed() && wanIPv6Tab.isSelected())
				utils.log().info("IPv6 Tab is displayed and is currently selected");
			else
				utils.log().info("IPv6 Tab is not displayed ");

			if (wanIPv4Tab.isDisplayed())
				utils.log().info("IPv4 Tab is displayed and is not selected");
			else
				utils.log().info("IPv46 Tab is not displayed ");

			if (statefulRadioButton.isDisplayed())
				utils.log().info("Stateful Radio button is displayed and is selected");
			else
				utils.log().info("Stateful Radio button is not displayed ");

			if (ipv6AddressLabel.isDisplayed() && ipv6Address.isDisplayed())
				utils.log().info(ipv6AddressLabel.getText() + " : " + ipv6Address.getText());
			else
				utils.log().info("IPv6 Address is not displayed ");

			if (ipv6PrefixLengthLabel.isDisplayed() && ipv6PrefixLength.isDisplayed())
				utils.log().info(ipv6PrefixLengthLabel.getText() + " : " + ipv6PrefixLength.getText());
			else
				utils.log().info("IPv6 Prefix Length Label is not displayed ");

			if (ipv6GatewayLabel.isDisplayed() && ipv6Gateway.isDisplayed())
				utils.log().info(ipv6GatewayLabel.getText() + " : " + ipv6Gateway.getText());
			else
				utils.log().info("IPv6 Gateway is not displayed ");

			if (ipv6PrefixDelegationLabel.isDisplayed())
				utils.log().info(ipv6PrefixDelegationLabel.getText() + " label is displayed");
			else
				utils.log().info("IPv6 Prefix Delegation Label is not displayed ");

			if (ipv6PrefixDelegationCheckbox.isDisplayed())
				utils.log().info("IPv6 Prefix Delegation checkbox is displayed but is not selected");
			else
				utils.log().info("IPv6 Prefix Delegation checkbox is not displayed ");

			if (ipv6PrimaryDNSLabel.isDisplayed() && ipv6PrimaryDNS.isDisplayed())
				utils.log().info(ipv6PrimaryDNSLabel.getText() + " : " + ipv6PrimaryDNS.getText());
			else
				utils.log().info("IPv6 Primary DNS is not displayed ");

			if (ipv6SecondayDNSLabel.isDisplayed() && ipv6SecondaryDNS.isDisplayed())
				utils.log().info(ipv6SecondayDNSLabel.getText() + " : " + ipv6SecondaryDNS.getText());
			else
				utils.log().info("IPv6 Secondary DNS is not displayed ");

			new SwipeActions().swipeScreen(Direction.UP);

			if (stateful_SaveChangesButton_Disabled.isDisplayed())
				utils.log().info(stateful_SaveChangesButton_Disabled.getText() + " button is displayed but is disabled");
			else
				utils.log().info("Save Changes button is not displayed ");
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifyUIOnWANIPv6Stateless() {
		utils.log().info("                                                     ");
		utils.log().info("*****************************************************");
		utils.log().info("Verifying WAN IPv6 - Stateless Configuration Settings");
		utils.log().info("*****************************************************");
		
		new SwipeActions().swipeScreen(Direction.DOWN);
		
		this.clickStatelessRadioButton();
		
		try {
			if (wanIPConfigurationTitle.isDisplayed())
				utils.log().info(wanIPConfigurationTitle.getText() + " title text is displayed ");
			else
				utils.log().info("WAN IP Configuration title text is not displayed ");

			if (backIcon.isDisplayed())
				utils.log().info("Back Icon is displayed ");
			else
				utils.log().info("Back Icon is not displayed ");

			if (helpIcon.isDisplayed())
				utils.log().info("Help Icon is displayed");
			else
				utils.log().info("Help icon is not displayed ");

			if (wanIPv6Tab.isDisplayed() && wanIPv6Tab.isSelected())
				utils.log().info("IPv6 Tab is displayed and is currently selected");
			else
				utils.log().info("IPv6 Tab is not displayed ");

			if (wanIPv4Tab.isDisplayed())
				utils.log().info("IPv4 Tab is displayed but is not selected");
			else
				utils.log().info("IPv6 Tab is not displayed ");

			if (statelessRadioButton.isDisplayed())
				utils.log().info("Stateless Radio button is displayed and is selected");
			else
				utils.log().info("Stateless Radio button is not displayed ");

			new SwipeActions().swipeScreen(Direction.UP);

			if (ipv6AddressLabel.isDisplayed() && ipv6Address.isDisplayed())
				utils.log().info(ipv6AddressLabel.getText() + " : " + ipv6Address.getText());
			else
				utils.log().info("IPv6 Address Label is not displayed ");

			if (ipv6PrefixLengthLabel.isDisplayed() && ipv6PrefixLength.isDisplayed()
					&& !(ipv6PrefixLength.isEnabled()))
				utils.log().info(ipv6PrefixLengthLabel.getText() + " : " + ipv6PrefixLength.getText());
			else
				utils.log().info("IPv6 Prefix Length Label is not displayed ");

			if (ipv6GatewayLabel.isDisplayed() && ipv6Gateway.isDisplayed())
				utils.log().info(ipv6GatewayLabel.getText() + " : " + ipv6Gateway.getText());
			else
				utils.log().info("IPv6 Gateway Label is not displayed ");

			if (ipv6PrefixDelegationLabel.isDisplayed())
				utils.log().info(ipv6PrefixDelegationLabel.getText() + " label is displayed");
			else
				utils.log().info("IPv6 Prefix Delegation Label is not displayed ");

			if (ipv6PrefixDelegationCheckbox.isDisplayed())
				utils.log().info("IPv6 Prefix Delegation checkbox is displayed but is not selected");
			else
				utils.log().info("IPv6 Prefix Delegation checkbox is not displayed ");

			if (ipv6PrimaryDNSLabel.isDisplayed() && ipv6PrimaryDNS.isDisplayed())
				utils.log().info(ipv6PrimaryDNSLabel.getText() + " : " + ipv6PrimaryDNS.getText());
			else
				utils.log().info("IPv6 Primary DNS Label is not displayed ");

			if (ipv6SecondayDNSLabel.isDisplayed() && ipv6SecondaryDNS.isDisplayed())
				utils.log().info(ipv6SecondayDNSLabel.getText() + " : " + ipv6SecondaryDNS.getText());
			else
				utils.log().info("IPv6 Secondary DNS Label is not displayed ");

			if (stateless_SaveChangesButton.isDisplayed())
				utils.log().info(stateless_SaveChangesButton.getText() + " button is displayed and is enabled");
			else
				utils.log().info("Save Changes button is not displayed ");

			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean isAt() {
		if (wanIPConfigurationTitle.isDisplayed()) {
			utils.log().info("On WAN IPv6 Configuration Page");
			return true;
		} else {
			utils.log().info("Not on WAN IPv6 Configuration Page");
			return false;
		}
	}
}
