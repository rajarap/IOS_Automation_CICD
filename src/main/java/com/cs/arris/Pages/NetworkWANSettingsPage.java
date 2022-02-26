package com.cs.arris.Pages;

import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

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

public class NetworkWANSettingsPage extends ParentClass implements Page {

	public TestUtils utils = new TestUtils();

	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Network_Wan_Settings_Screen_NavigationBar_TitleLabel\"]")
	public MobileElement wanSettingsTitle;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Network_Wan_Settings_Screen_NavigationBar_Button_Back\"]")
	public MobileElement backIcon;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Network_Wan_Settings_Screen_NavigationBar_Button_Help\"]")
	public MobileElement helpIcon;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Network_Wan_Settings_Screen_Label_Option[1]\"]")
	public MobileElement wanIPConfigurationLabel;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Network_Wan_Settings_Screen_Label_Option[2]\"]")
	public MobileElement lacLabel; // Link Aggregation Control

	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Network_Wan_Settings_Screen_Button_Info[2]\"]")
	public MobileElement lacInfoIcon;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeSwitch[@name=\"Network_Wan_Settings_Screen_Button_Switch[2]\"]")
	public MobileElement LACToggleButton;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Network_Wan_Settings_Screen_Label_Option[3]\"]")
	public MobileElement dnsConfigurationLabel;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Network_Wan_Settings_Screen_Button_Renewal\"]")
	public MobileElement wanIPRenewButton;

	public NetworkWANSettingsPage() {
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}

	public HomePage getHomePageObject() {
		HomePage homePage = new HomePage();
		return homePage;
	}

	public NetworkWANSettingsHelpPage getNetworkWanSettingsHelpPageObject() {
		NetworkWANSettingsHelpPage networkWANHelpPage = new NetworkWANSettingsHelpPage();
		return networkWANHelpPage;
	}

	public FooterIconsPage getFooterIconsPageObject() {
		FooterIconsPage footerIconsPage = new FooterIconsPage();
		return footerIconsPage;
	}

	public AppRatingDialog getAppRatingPageObject() {
		AppRatingDialog rating = new AppRatingDialog();
		return rating;
	}

	public NetworkWANIPConfigurationIPv4Page getWANIPv4ConfigurationPageObject() {
		NetworkWANIPConfigurationIPv4Page wanIPv4Config = new NetworkWANIPConfigurationIPv4Page();
		return wanIPv4Config;
	}

	public NetworkWANIPConfigurationIPv6Page getWANIPv6ConfigurationPageObject() {
		NetworkWANIPConfigurationIPv6Page wanIPv6Config = new NetworkWANIPConfigurationIPv6Page();
		return wanIPv6Config;
	}

	public NetworkWANDNSConfigurationIPv4Page getWANDNSIPv4ConfigurationPageObject() {
		NetworkWANDNSConfigurationIPv4Page wanDNSIPv4Config = new NetworkWANDNSConfigurationIPv4Page();
		return wanDNSIPv4Config;
	}

	public NetworkWANDNSConfigurationIPv6Page getWANDNSIPv6ConfigurationPageObject() {
		NetworkWANDNSConfigurationIPv6Page wanDNSIPv6Config = new NetworkWANDNSConfigurationIPv6Page();
		return wanDNSIPv6Config;
	}

	public NetworkLACConfigurationAlertDialog getLACAlertDialogObject() {
		NetworkLACConfigurationAlertDialog lacAlert = new NetworkLACConfigurationAlertDialog();
		return lacAlert;
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
			utils.log().info("Clicked on Help Button");
			return true;
		} else {
			utils.log().info("Help Button is not displayed");
			return false;
		}
	}

	public boolean clickWANIPRenewButton() {
		if (wanIPRenewButton.isDisplayed()) {
			click(wanIPRenewButton);
			utils.log().info("Clicked on WAN IP Renew button");
			return true;
		} else {
			utils.log().info("WAN IP Renew button is not displayed");
			return false;
		}
	}

	public boolean clickWANIPConfigurationLink() {
		if (wanIPConfigurationLabel.isDisplayed()) {
			click(wanIPConfigurationLabel);
			utils.log().info("Clicked on WAN IP Configuration Link");
			return true;
		} else {
			utils.log().info("WAN IP Configuration Link is not displayed");
			return false;
		}
	}

	public boolean clickLACLink() {
		if (lacLabel.isDisplayed()) {
			click(lacLabel);
			utils.log().info("Clicked on LAC Link");
			return true;
		} else {
			utils.log().info("LAC Link is not displayed");
			return false;
		}
	}

	public boolean clickLacInfoIcon() {
		if (lacInfoIcon.isDisplayed()) {
			click(lacInfoIcon);
			utils.log().info("Clicked on LAC Info Icon");
			return true;
		} else {
			utils.log().info("LAC Info Icon is not displayed");
			return false;
		}
	}

	public boolean clickDNSConfigurationLink() {
		if (dnsConfigurationLabel.isDisplayed()) {
			click(dnsConfigurationLabel);
			utils.log().info("Clicked on DNS Configuration Link");
			return true;
		} else
			utils.log().info("DNS Configuration Link is not displayed");
		return false;
	}

	public boolean verifyUIOnWANSettingsPage() {
		utils.log().info("                                                     ");
		utils.log().info("*****************************************************");
		utils.log().info("Verifying UI Elements on Network - WAN Settings Page ");
		utils.log().info("*****************************************************");
		try {
			if (wanSettingsTitle.isDisplayed())
				utils.log().info(wanSettingsTitle.getText() + " title text is displayed ");
			else
				utils.log().info("WAN Settings title text is not displayed ");

			if (backIcon.isDisplayed())
				utils.log().info("Back Icon is displayed ");
			else
				utils.log().info("Back Icon is not displayed ");

			if (helpIcon.isDisplayed())
				utils.log().info("Help Icon is displayed");
			else
				utils.log().info("Help Icon text is not displayed ");

			if (wanIPConfigurationLabel.isDisplayed())
				utils.log().info("WAN IP Configuration Link is displayed");
			else
				utils.log().info("WAN IP Configuration Link is not displayed ");

			if (lacLabel.isDisplayed())
				utils.log().info("LAC Link is displayed");
			else
				utils.log().info("LAC Link text is not displayed ");
			
			if (lacInfoIcon.isDisplayed())
				utils.log().info("LAC Info Link is displayed");
			else
				utils.log().info("LAC Info Link is not displayed ");

			if (LACToggleButton.isDisplayed())
				utils.log().info("LAC toggle button is displayed but is disabled");
			else
				utils.log().info("LAC toggle button is displayed and is enabled");
			
			if (dnsConfigurationLabel.isDisplayed())
				utils.log().info("DNS Configuration Link is displayed ");
			else
				utils.log().info("DNS Configuration Link is not displayed ");

			if (wanIPRenewButton.isDisplayed())
				utils.log().info(wanIPRenewButton.getText() + " button is displayed");
			else
				utils.log().info("WAN IP RENEW text is not displayed ");

			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean isAt() {
		if (wanSettingsTitle.isDisplayed()) {
			utils.log().info("On WAN Settings Page");
			return true;
		} else {
			utils.log().info("Not on WAN Settings Page");
			return false;
		}
	}
}
