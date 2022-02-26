package com.cs.arris.Pages;

import org.openqa.selenium.support.PageFactory;

import com.cs.arris.Base.ParentClass;
import com.cs.arris.Interface.Page;
import com.cs.arris.Utilities.Direction;
import com.cs.arris.Utilities.SwipeActions;
import com.cs.arris.Utilities.TestUtils;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class NetworkPage extends ParentClass implements Page {
	public TestUtils utils = new TestUtils();

	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Network_Settings_Screen_NavigationBar_TitleLabel\"]")
	public MobileElement networkTitle;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Network_Settings_Screen_NavigationBar_Button_Help\"]")
	public MobileElement helpIcon;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Network_Settings_Screen_Button_Expand\"]")
	public MobileElement expandButton;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Network_Settings_Screen_Label_MainWifi\"]")
	public MobileElement mainWifiLabel;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Network_Settings_Screen_Label_SSID\"]")
	public MobileElement networkNameSSIDLabel;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeTextField[@name=\"Network_Settings_Screen_TextField_SSID\"]")
	public MobileElement ssidName;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Network_Settings_Screen_Button_SSID\"]")
	public MobileElement editSSIDName;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Network_Settings_Screen_Label_Password\"]")
	public MobileElement passwordLabel;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Network_Settings_Screen_Button_EyeIcon\"]")
	public MobileElement showPasswordIcon;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeSecureTextField[@name=\"Network_Settings_Screen_TextField_Password\"]")
	public MobileElement showPassword;


	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Network_Settings_Screen_Label_GuestWifi\"]")
	public MobileElement guestWifiNetworkLabel;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Network_Settings_Screen_Label_GuestEnable\"]")
	public MobileElement enableDisableGuestNetwork;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeSwitch[@name=\"Network_Settings_Screen_Button_SwitchGuest\"]")
	public MobileElement guestNetworkToggleButton;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Network_Settings_Screen_Button_GuestExpand\"]")
	public MobileElement guestNetworkExpandIcon;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Network_Settings_Screen_Label_GuestSSID\"]")
	public MobileElement guestNetworkSIDLabel;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeTextField[@name=\"Network_Settings_Screen_TextField_GuestSSID\"]")
	public MobileElement guestNetworkSSIDName;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Network_Settings_Screen_Label_GuestPassword\"]")
	public MobileElement guestNetworkPasswordLabel;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeSecureTextField[@name=\"Network_Settings_Screen_TextField_GuestPassword\"]")
	public MobileElement guestNetworkPassword;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Network_Settings_Screen_Button_GuestEye\"]")
	public MobileElement guestNetworkShowPasswordIcon;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Network_Settings_Screen_Button_GuestEdit\"]")
	public MobileElement guestNetworkEditIcon;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Network_Settings_Screen_Button_GuestShare\"]")
	public MobileElement guestNetworkShareCredentialsButton;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Network_Settings_Screen_Label_Extended\"]")
	public MobileElement extendedWifiSettingsLabel;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Network_Settings_Screen_Button_ExtendedExpand\"]")
	public MobileElement extendedWifiExpandIcon;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Network_Settings_Screen_Label_Extended5g\"]")
	public MobileElement fiveGHzWidebandModeLabel;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Network_Settings_Screen_Button_ExtendedBand\"]")
	public MobileElement fiveGHzWidebandInfoIcon;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeSwitch[@name=\"Network_Settings_Screen_Button_SwitchExtended\"]")
	public MobileElement widebandModeToggleButton;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Network_Settings_Screen_Label_ExtendedEnableDFS\"]")
	public MobileElement enableDFSLabel;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Network_Settings_Screen_Label_BandTitle\"]")
	public MobileElement bandSteeringModeLabel;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Network_Settings_Screen_Button_Band\"]")
	public MobileElement bandSteeringModeInfoIcon;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Network_Settings_Screen_Label_Band\"]")
	public MobileElement periodicCheckLabel;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeSwitch[@name=\"Network_Settings_Screen_Button_SwitchBand\"]")
	public MobileElement bandSteeringModeToggleButton;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Network_Settings_Screen_Label_SettingsTitle\"]")
	public MobileElement networkSettingsLabel;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Network_Settings_Screen_Button_SettingsExpand\"]")
	public MobileElement networkSettingsExpandIcon;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Network_Settings_Screen_Label_SettingsLANIPTitle\"]")
	public MobileElement lanIPAddressLabel;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Network_Settings_Screen_Label_SettingsLANIP\"]")
	public MobileElement lanIPAddress;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Network_Settings_Screen_Label_SettingsGatewayIPTitle\"]")
	public MobileElement gatewayIPAddressLabel;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Network_Settings_Screen_Label_SettingsGatewayIP\"]")
	public MobileElement gatewayIPAddress;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Network_Settings_Screen_Label_General\"]")
	public MobileElement generalSettingsLabel;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Network_Settings_Screen_Label_Wan\"]")
	public MobileElement wanSettingsLabel;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Network_Settings_Screen_Label_Lan\"]")
	public MobileElement lanSettingsLabel;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Network_Settings_Screen_Label_Priority\"]")
	public MobileElement devicePrioritySettings;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Network_Settings_Screen_Label_TimeZoneTitle\"]")
	public MobileElement timeZone;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Network_Settings_Screen_Label_Timezone\"]")
	public MobileElement gmt530;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Network_Settings_Screen_Label_Test\"]")
	public MobileElement testMyConnectionSpeedButton;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Join\"]")
	public MobileElement joinButton;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Cancel\"]")
	public MobileElement cancelButton;
	
	public NetworkPage() {
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}

	public HomePage getHomePageObject() {
		HomePage homePage = new HomePage();
		return homePage;
	}

	public NetworkHelpPage getNetworkHelpPageObject() {
		NetworkHelpPage networkHelpPage = new NetworkHelpPage();
		return networkHelpPage;
	}

	public FooterIconsPage getFooterIconsPageObject() {
		FooterIconsPage footerIconsPage = new FooterIconsPage();
		return footerIconsPage;
	}

	public SpeedTestPage getSpeedTestPageObject() {
		SpeedTestPage speedTestPage = new SpeedTestPage();
		return speedTestPage;
	}

	public AppRatingDialog getAppRatingPageObject() {
		AppRatingDialog rating = new AppRatingDialog();
		return rating;
	}

	public NetworkWANSettingsPage getWANSettingsPageObject() {
		NetworkWANSettingsPage wanSettings = new NetworkWANSettingsPage();
		return wanSettings;
	}

	public NetworkLANSettingsPage getLANSettingsPageObject() {
		NetworkLANSettingsPage lanSettings = new NetworkLANSettingsPage();
		return lanSettings;
	}
	
	public Network5GHzWidebandModeInfoDialog get5GHzWidebandModeDialogObject() {
		Network5GHzWidebandModeInfoDialog widebandMode = new Network5GHzWidebandModeInfoDialog();
		return widebandMode;
	}

	public NetworkBandSteeringModeInfoDialog getBandSteeringModeDialogObject() {
		NetworkBandSteeringModeInfoDialog bandSteeringMode = new NetworkBandSteeringModeInfoDialog();
		return bandSteeringMode;
	}
	
	public Network5GHzWidebandModeAlertDialog get5GHzWidebandModeAlertDialogObject() {
		Network5GHzWidebandModeAlertDialog widebandModeAlert = new Network5GHzWidebandModeAlertDialog();
		return widebandModeAlert;
	}
	
	public NetworkBandSteeringModeAlertDialog getBandSteeringModeAlertDialogObject() {
		NetworkBandSteeringModeAlertDialog bandSteeringModeAlert = new NetworkBandSteeringModeAlertDialog();
		return bandSteeringModeAlert;
	}
	
	public NetworkEnableGuestNetworkDialog getEnableGuestNetworkDialogObject() {
		NetworkEnableGuestNetworkDialog guestNetwork = new NetworkEnableGuestNetworkDialog();
		return guestNetwork;
	}
	
	public NetworkEditGuestNetworkDialog getEditGuestNetworkDialogObject() {
		NetworkEditGuestNetworkDialog editGuestNetwork = new NetworkEditGuestNetworkDialog();
		return editGuestNetwork;
	}
		
	public NetworkEnableGuestNetworkAlertDialog getEnableGuestNetworkAlertDialogObject() {
		NetworkEnableGuestNetworkAlertDialog guestNetworkalert = new NetworkEnableGuestNetworkAlertDialog();
		return guestNetworkalert;
	}
	
	
	public NetworkDevicePrioritySettings getNetworkDevicePrioritySettingsPageObject() {
		NetworkDevicePrioritySettings widebandMode = new NetworkDevicePrioritySettings();
		return widebandMode;
	}
	
	public NetworkTimeZoneSettingsPage getTimeZoneSettingsPageObject() {
		NetworkTimeZoneSettingsPage timeZone = new NetworkTimeZoneSettingsPage();
		return timeZone;
	}
	
	public NetworkGeneralSettingsPage getGeneralSettingsPageObject() {
		NetworkGeneralSettingsPage generalSettings = new NetworkGeneralSettingsPage();
		return generalSettings;
	}
	
	public boolean clickJoinButton() {
		if (joinButton.isDisplayed()) {
			click(joinButton);
			utils.log().info("Clicked on Join displayed");
			return true;
		} else {
			utils.log().info("Join button is not displayed");
			return false;
		}
	}
	
	public boolean clickCancelButton() {
		if (cancelButton.isDisplayed()) {
			click(cancelButton);
			utils.log().info("Clicked on Cancel displayed");
			return true;
		} else {
			utils.log().info("Cancel button is not displayed");
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

	public boolean clickTestConnectionSpeedButton() {
		if (testMyConnectionSpeedButton.isDisplayed()) {
			click(testMyConnectionSpeedButton);
			utils.log().info("Clicked on Test Your Connection Speed button");
			return true;
		} else {
			utils.log().info("Test Your Connection Speed button is not displayed");
			return false;
		}
	}
	
	public boolean clickExtendedWifiSettingsExpandButton() {
		if (extendedWifiExpandIcon.isDisplayed()) {
			click(extendedWifiExpandIcon);
			return true;
		} else {
			utils.log().info("Extended Wifi Settings Expand Button is not displayed");
			return false;
		}
	}

	public boolean clickNetworkSettingsExpandButton() {
		if (networkSettingsExpandIcon.isDisplayed()) {
			utils.log().info("Network Settings Expand Button is displayed");
			click(networkSettingsExpandIcon);
			return true;
		}else {
			utils.log().info("Network Settings Expand Button is not displayed");
			return false;
		}
	}
	
	public boolean clickGuestNetworkExpandButton() {
		if (guestNetworkExpandIcon.isDisplayed()) {
			click(guestNetworkExpandIcon);
			utils.log().info("Clicked on Guest Network Expand Button");
			return true;
		}else {
			utils.log().info("Guest Network Expand Button is not displayed");
			return false;
		}
	}
	
	public boolean clickGuestNetworkShowPasswordButton() {
		if (guestNetworkShowPasswordIcon.isDisplayed()) {
			click(guestNetworkShowPasswordIcon);
			utils.log().info("Clicked on Show Password Icon");
			return true;
		}else {
			utils.log().info("Show Password Icon is not displayed");
			return false;
		}
	}
	
	public boolean clickGuestNetworkEditdButton() {
		if (guestNetworkEditIcon.isDisplayed()) {
			click(guestNetworkEditIcon);
			utils.log().info("Clicked on Guest Network Edit Icon");
			return true;
		}else {
			utils.log().info("Edit Icon is not displayed");
			return false;
		}
	}
	
	public boolean clickfiveGHzWidebandInfoIcon() {
		if (fiveGHzWidebandInfoIcon.isDisplayed()) {
			click(fiveGHzWidebandInfoIcon);
			utils.log().info("Clicked on 5GHz Wideband Info Icon");
			return true;
		} else {
			utils.log().info("5GHz Wideband Mode Info Icon is not displayed");
			return false;
		}
	}
	
	public boolean clickBandSteeringInfoIcon() {
		if (bandSteeringModeInfoIcon.isDisplayed()) {
			click(bandSteeringModeInfoIcon);
			utils.log().info("Clicked on Band Steering Mode Info Icon");
			return true;
		} else {
			utils.log().info("Band Steering Mode Info Icon is not displayed");
			return false;
		}
	}
	
	public boolean enable5GHzWidebandMode() {
		try {
			String str = super.getDriver().findElement(MobileBy.xpath("//XCUIElementTypeSwitch[@name=\"Network_Settings_Screen_Button_SwitchExtended\"]")).getAttribute("value");
			int value = Integer.parseInt(str);
			if(value == 0)  //disabled
			{
				super.getDriver().findElement(MobileBy.xpath("//XCUIElementTypeSwitch[@name=\"Network_Settings_Screen_Button_SwitchExtended\"]")).click();
				utils.log().info("5GHz Wide Band Mode is enabled");
			}else {
				utils.log().info("5GHz Wide Band Mode is already enabled");
			}
			return true;
		} catch(Exception e) {
			utils.log().info("Issue in enabling 5GHz Wide Band Mode");
			return true;
		}
	}

	public boolean disable5GHzWidebandMode() {
		try {
			String str = super.getDriver().findElement(MobileBy.xpath("//XCUIElementTypeSwitch[@name=\"Network_Settings_Screen_Button_SwitchExtended\"]")).getAttribute("value");
			int value = Integer.parseInt(str);
			if(value == 1)
			{
				super.getDriver().findElement(MobileBy.xpath("//XCUIElementTypeSwitch[@name=\"Network_Settings_Screen_Button_SwitchExtended\"]")).click();
				utils.log().info("5GHz Wide Band Mode is disabled");
			}else {
				utils.log().info("5GHz Wide Band Mode is already disabled");
			}
			return true;
		} catch(Exception e) {
			utils.log().info("Issue in disabling 5GHz Wide Band Mode");
			return true;
		}
	}
	
	public boolean enableBandSteeringMode() {
		try {
			String str = super.getDriver().findElement(MobileBy.xpath("//XCUIElementTypeSwitch[@name=\"Network_Settings_Screen_Button_SwitchBand\"]")).getAttribute("value");
			int value = Integer.parseInt(str);
			if(value == 0)  //disabled
			{
				super.getDriver().findElement(MobileBy.xpath("//XCUIElementTypeSwitch[@name=\"Network_Settings_Screen_Button_SwitchBand\"]")).click();
				utils.log().info("Band Steering Mode is enabled");
			}else {
				utils.log().info("Band Steering Mode is already enabled");
			}
			return true;
		} catch(Exception e) {
			utils.log().info("Issue in enabling Band Steering Mode");
			return true;
		}
	}

	public boolean disableBandSteeringMode() {
		try {
			String str = super.getDriver().findElement(MobileBy.xpath("//XCUIElementTypeSwitch[@name=\"Network_Settings_Screen_Button_SwitchBand\"]")).getAttribute("value");
			int value = Integer.parseInt(str);
			if(value == 1)
			{
				super.getDriver().findElement(MobileBy.xpath("//XCUIElementTypeSwitch[@name=\"Network_Settings_Screen_Button_SwitchBand\"]")).click();
				utils.log().info("Band Steering Mode is disabled");
			}else {
				utils.log().info("Band Steering Mode is already disabled");
			}
			return true;
		} catch(Exception e) {
			utils.log().info("Issue in disabling Band Steering Mode");
			return true;
		}
	}
	
	public boolean enableGuestWifiNetwork() {
		try {
			String str = super.getDriver().findElement(MobileBy.iOSClassChain("**/XCUIElementTypeSwitch[`label == \"Guest Wi-Fi Network, Enable/Disable Guest Network, Network Name (SSID), Password\"`]")).getAttribute("value");
			int value = Integer.parseInt(str);
			if(value == 0)  //disabled
			{
				super.getDriver().findElement(MobileBy.iOSClassChain("**/XCUIElementTypeSwitch[`label == \"Guest Wi-Fi Network, Enable/Disable Guest Network, Network Name (SSID), Password\"`]")).click();
				utils.log().info("Guest Wifi is enabled");
			}else {
				utils.log().info("Guest Wifi is already enabled");
			}
			return true;
		} catch(Exception e) {
			utils.log().info("Issue in enabling Guest Wifi");
			return true;
		}
	}

	public boolean disableGuestWifiNetwork() {
		try {
			String str = super.getDriver().findElement(MobileBy.iOSClassChain("**/XCUIElementTypeSwitch[`label == \"Guest Wi-Fi Network, Enable/Disable Guest Network, Network Name (SSID), Password\"`]")).getAttribute("value");
			int value = Integer.parseInt(str);
			if(value == 1)
			{
				super.getDriver().findElement(MobileBy.iOSClassChain("**/XCUIElementTypeSwitch[`label == \"Guest Wi-Fi Network, Enable/Disable Guest Network, Network Name (SSID), Password\"`]")).click();
				utils.log().info("Guest Wifi is disabled");
			}else {
				utils.log().info("Guest Wifi is already disabled");
			}
			return true;
		} catch(Exception e) {
			utils.log().info("Issue in disabling Guest Wifi");
			return true;
		}
	}
	
	public boolean isGuestWifiDisabled()
	{
		try {
			String str = super.getDriver().findElement(MobileBy.iOSClassChain("**/XCUIElementTypeSwitch[`label == \"Guest Wi-Fi Network, Enable/Disable Guest Network, Network Name (SSID), Password\"`]")).getAttribute("value");
			int value = Integer.parseInt(str);
			if(value == 0)  //disabled
				utils.log().info("Guest Wifi is disabled");
			return true;
		} catch(Exception e) {
			utils.log().info("Guest Wifi is enabled");
			return false;
		}
	}

	public boolean clickGeneralSettings() {
		if (generalSettingsLabel.isDisplayed()) {
			click(generalSettingsLabel);
			utils.log().info("Clicked on General Settings");
			return true;
		} else {
			utils.log().info("General Settings Link is not displayed");
			return false;
		}
	}

	public boolean clickWANSettings() {
		if (wanSettingsLabel.isDisplayed()) {
			click(wanSettingsLabel);
			utils.log().info("Clicked on WAN Settings");
			return true;
		} else {
			utils.log().info("WAN Settings Link is not displayed");
			return false;
		}
	}

	public boolean clickLANSettings() {
		if (lanSettingsLabel.isDisplayed()) {
			click(lanSettingsLabel);
			utils.log().info("Clicked on LAN Settings");
			return true;
		} else {
			utils.log().info("LAN Settings Link is not displayed");
			return false;
		}
	}

	public boolean clickDevicePrioritySettings() {
		if (devicePrioritySettings.isDisplayed()) {
			click(devicePrioritySettings);
			utils.log().info("Clicked on Device Priority Settings");
			return true;
		} else {
			utils.log().info("Device Priority Settings Link is not displayed");
			return false;
		}
	}

	public boolean clickTimeZone() {
		if (timeZone.isDisplayed()) {
			click(timeZone);
			utils.log().info("Clicked on Time Zone Settings");
			return true;
		} else {
			utils.log().info("Time Zone Priority Settings Link is not displayed");
			return false;
		}
	}

	public boolean verifyUIOnNetworkPage() {
		utils.log().info("                                     ");
		utils.log().info("**************************************");
		utils.log().info("Verifying UI Elements on Network Page ");
		utils.log().info("**************************************");
		try {
			try {
				if (networkTitle.isDisplayed())
					utils.log().info(networkTitle.getText() + " title text is displayed ");
			} catch (Exception e) {
				utils.log().info("Network title text is not displayed");
			}

			try {
				if (helpIcon.isDisplayed())
					utils.log().info("Help Icon is displayed");
			} catch (Exception e) {
				utils.log().info("Help Icon is not displayed");
			}

			try {
				if (expandButton.isDisplayed()) {
					utils.log().info("Main Wi-Fi expand button is displayed");
					click(expandButton);} 
			} catch (Exception e) {
				utils.log().info("Main Wi-Fi expand button is not displayed");
			}
			
			try {
				if (mainWifiLabel.isDisplayed())
					utils.log().info("Main Wi-Fi Network Label is displayed ");
			} catch (Exception e) {
				utils.log().info("Main Wi-Fi Network Label is not displayed");
			}

			try {
				if (networkNameSSIDLabel.isDisplayed() && ssidName.isDisplayed())
					utils.log().info(networkNameSSIDLabel.getText() + " : " + ssidName.getText());
			} catch (Exception e) {
				utils.log().info("Network SSID Name is not displayed");
			}

			try {
				if (passwordLabel.isDisplayed() && showPassword.isDisplayed())
					utils.log().info(passwordLabel.getText() + " : " + showPassword.getText());
			} catch (Exception e) {
				utils.log().info("SSID Password is not displayed");
			}

			try {
				if (showPasswordIcon.isDisplayed()) {
					utils.log().info("Show Password Icon is displayed ");
					click(expandButton);}
			} catch (Exception e) {
				utils.log().info("Show Password Icon is not displayed");
			}

			try {
				if (guestWifiNetworkLabel.isDisplayed())
					utils.log().info(guestWifiNetworkLabel.getText() + " label is displayed");
			} catch (Exception e) {
				utils.log().info("Guest Wi-Fi label is not displayed");
			}

			try {
				if (enableDisableGuestNetwork.isDisplayed())
					utils.log().info(enableDisableGuestNetwork.getText() + " label is displayed");
			} catch (Exception e) {
				utils.log().info("Enable/disable Guest Network label is not displayed");
			}
			
			try {
				if (guestNetworkToggleButton.isDisplayed())
					utils.log().info("Guest Wi-Fi Network Toggle button is displayed");
			} catch (Exception e) {
				utils.log().info("Guest Wi-Fi Network Toggle button is not displayed");
			}
			
			try {
				if (extendedWifiExpandIcon.isDisplayed()) {
					utils.log().info("Extended WiFi Settings expand button is displayed");
					click(extendedWifiExpandIcon);}  //1
			} catch (Exception e) {
				utils.log().info("Extended WiFi Settings expand button is not displayed");
			}

			try {
				if (extendedWifiSettingsLabel.isDisplayed())
					utils.log().info(extendedWifiSettingsLabel.getText() + " label is displayed");
			} catch (Exception e) {
				utils.log().info("Extended Wi-Fi Settings label is not displayed");
			}

			try {
				if (fiveGHzWidebandModeLabel.isDisplayed())
					utils.log().info(fiveGHzWidebandModeLabel.getText() + " label is displayed");
			} catch (Exception e) {
				utils.log().info("5GHz Widebank Mode label is not displayed");
			}

			try {
				if (enableDFSLabel.isDisplayed())
					utils.log().info(enableDFSLabel.getText() + " label is displayed");
			} catch (Exception e) {
				utils.log().info("Enables DFS (up to) 160MHz channels label is not displayed");
			}
			
			try {
				if (widebandModeToggleButton.isDisplayed())
					utils.log().info("Extended Wifi toggle button is displayed");
			} catch (Exception e) {
				utils.log().info("Extended Wifi toggle button is not displayed");
			}

			try {
				if (fiveGHzWidebandInfoIcon.isDisplayed())
					utils.log().info("5GHz Widebank Mode Info Icon is displayed");
			} catch (Exception e) {
				utils.log().info("5GHz Widebank Mode Info Icon is not displayed");
			}
			
			try {
				if (bandSteeringModeLabel.isDisplayed())
					utils.log().info(bandSteeringModeLabel.getText() + " label is displayed");
			} catch (Exception e) {
				utils.log().info("Band Steering Mode label is not displayed");
			}
			
			try {
				if (bandSteeringModeInfoIcon.isDisplayed())
					utils.log().info("Band Steering Mode Info Icon is displayed");
			} catch (Exception e) {
				utils.log().info("5Band Steering Mode Info Icon is not displayed");
			}
			
			try {
				if (bandSteeringModeToggleButton.isDisplayed())
					utils.log().info("Band Steering Mode toggle button is displayed");
			} catch (Exception e) {
				utils.log().info("Band Steering Mode toggle button is not displayed");
			}
			
			try {
				if (periodicCheckLabel.isDisplayed())
					utils.log().info(periodicCheckLabel.getText() + " label is displayed");
			} catch (Exception e) {
				utils.log().info("Periodically will check devices connected on 2.4GHz bands and steer them to faster available 5GHz bands label is not displayed");
			}
			
			click(extendedWifiExpandIcon); //2


			click(networkSettingsExpandIcon); //1
			super.swipeUp();

			try {
				if (networkSettingsLabel.isDisplayed())
					utils.log().info(networkSettingsLabel.getText() + " label is displayed");
			} catch (Exception e) {
				utils.log().info("Netowrk Settings label is not displayed");
			}

			try {
				if (lanIPAddressLabel.isDisplayed() && lanIPAddress.isDisplayed())
					utils.log().info(lanIPAddressLabel.getText() + " : " + lanIPAddress.getText());
			} catch (Exception e) {
				utils.log().info("LAN IP Address data is not displayed");
			}

			try {
				if (gatewayIPAddressLabel.isDisplayed() && gatewayIPAddress.isDisplayed())
					utils.log().info(gatewayIPAddressLabel.getText() + " : " + gatewayIPAddress.getText());
			} catch (Exception e) {
				utils.log().info("Gateway IP Address label is not displayed");
			}

			try {
				if (generalSettingsLabel.isDisplayed())
					utils.log().info(generalSettingsLabel.getText() + " label is displayed");
			} catch (Exception e) {
				utils.log().info("General Settings label is not displayed");
			}

			try {
				if (wanSettingsLabel.isDisplayed())
					utils.log().info(wanSettingsLabel.getText() + " label is displayed");
			} catch (Exception e) {
				utils.log().info("WAN Settings label is not displayed");
			}

			try {
				if (lanSettingsLabel.isDisplayed())
					utils.log().info(lanSettingsLabel.getText() + " label is displayed");
			} catch (Exception e) {
				utils.log().info("LAN Settings label is not displayed");
			}

			try {
				if (devicePrioritySettings.isDisplayed())
					utils.log().info(devicePrioritySettings.getText() + " label is displayed");
			} catch (Exception e) {
				utils.log().info("Device Priority Settings label is not displayed");
			}

			try {
				if (timeZone.isDisplayed())
					utils.log().info(timeZone.getText() + " label is displayed");
			} catch (Exception e) {
				utils.log().info("Time Zone label is not displayed");
			}

			try {
				if (gmt530.isDisplayed())
					utils.log().info(gmt530.getText() + " label is displayed");
			} catch (Exception e) {
				utils.log().info("Chennai, Kolkata, Mumbai, New Delhi (GMT+05:30) label is not displayed");
			}

			//click(networkSettingsExpandIcon); //2
			
			try {
				if (testMyConnectionSpeedButton.isDisplayed())
					utils.log().info(testMyConnectionSpeedButton.getText() + " button is displayed");
			} catch (Exception e) {
				utils.log().info("Test My Connection Speed button is not displayed");
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public void verifyGuestWifiNetwork() {

		try {
			if (guestNetworkExpandIcon.isDisplayed()) 
			{
				utils.log().info("Guest Newtork expand button is displayed");
				
				clickGuestNetworkExpandButton();
				
				try {
					if (guestNetworkSIDLabel.isDisplayed())
						utils.log().info(guestNetworkSIDLabel.getText() + " label is displayed");
				} catch (Exception e) {
					utils.log().info("Network Name (SSID) label is not displayed");
				}

				try {
					if (guestNetworkSSIDName.isDisplayed())
						utils.log().info("Guest Newtork SSID Name is : " + guestNetworkSSIDName.getText());
				} catch (Exception e) {
					utils.log().info("uest Newtork SSID Name is not displayed");
				}
			
				try {
					if (guestNetworkPasswordLabel.isDisplayed())
						utils.log().info(guestNetworkPasswordLabel.getText() + " label is displayed");
				} catch (Exception e) {
					utils.log().info("PAssword label is not displayed");
				}

				try {
					if (guestNetworkPassword.isDisplayed())
						utils.log().info("Guest Newtork SSID Password is : " + guestNetworkPassword.getText());
				} catch (Exception e) {
					utils.log().info("uest Newtork SSID Name is not displayed");
				}

				try {
					if (guestNetworkShowPasswordIcon.isDisplayed()) {
						utils.log().info("Show Password Icon is displayed");
						click(guestNetworkShowPasswordIcon);
						click(guestNetworkShowPasswordIcon);}  //1
				} catch (Exception e) {
					utils.log().info("Show Password Icon is not displayed");
				}
			
				try {
					if (guestNetworkEditIcon.isDisplayed())
						utils.log().info("Edit Icon is displayed");
				} catch (Exception e) {
					utils.log().info("Edit Icon is not displayed");
				}
			
				try {
					if (guestNetworkShareCredentialsButton.isDisplayed())
						utils.log().info("SHARE CREDENTIALS button is displayed");
				} catch (Exception e) {
					utils.log().info("SHARE CREDENTIALS button is not displayed");
				}		
			
				clickGuestNetworkExpandButton();
			}  
		}catch(Exception e) {utils.log().info("Guest Newtork Settings expand button is not displayed");}
	}

	@Override
	public boolean isAt() {
		if (networkTitle.isDisplayed()) {
			utils.log().info("On Network Page");
			return true;
		} else {
			utils.log().info("Not on Network Page");
			return false;
		}
	}
}
