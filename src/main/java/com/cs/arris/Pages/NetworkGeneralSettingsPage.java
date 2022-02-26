package com.cs.arris.Pages;

import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

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

public class NetworkGeneralSettingsPage extends ParentClass implements Page {

	public TestUtils utils = new TestUtils();

	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"General Settings\"]")
	public MobileElement generalSettingsTitle;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeOther[@name=\"NavigationBar_Button_Back\"]")
	public MobileElement backIcon;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeOther[@name=\"NavigationBar_Button_Help\"]")
	public MobileElement helpIcon;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"General_Network_Settings_Screen_Label_Option[1]\"]")
	public MobileElement upnpLabel;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeSwitch[@name=\"General_Network_Settings_Screen_Button_Switch[1]\"]")
	public MobileElement UPNPToggleButton;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"General_Network_Settings_Screen_Button_Info[1]\"]")
	public MobileElement upnpInfoIcon;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"General_Network_Settings_Screen_Label_Option[2]\"]")
	public MobileElement bridgeModeLabel;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeSwitch[@name=\"General_Network_Settings_Screen_Button_Switch[2]\"]")
	public MobileElement bridgeModeToggleButton;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"General_Network_Settings_Screen_Button_Info[2]\"]")
	public MobileElement bridgeModeInfoIcon;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"General_Network_Settings_Screen_Label_Option[3]\"]")
	public MobileElement portForwardingLabel;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"General_Network_Settings_Screen_Label_Option[4]\"]")
	public MobileElement ipv6EnableLabel;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeSwitch[@name=\"General_Network_Settings_Screen_Button_Switch[4]\"]")
	public MobileElement IPv6ToggleButton;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"General_Network_Settings_Screen_Button_Info[4]\"]")
	public MobileElement ipv6InfoIcon;

	public NetworkGeneralSettingsPage() {
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}

	public NetworkGeneralSettingsHelpPage getNetworkGeneralSettingsHelpPageObject() {
		NetworkGeneralSettingsHelpPage networkGeneralHelpPage = new NetworkGeneralSettingsHelpPage();
		return networkGeneralHelpPage;
	}

	public FooterIconsPage getFooterIconsPageObject() {
		FooterIconsPage footerIconsPage = new FooterIconsPage();
		return footerIconsPage;
	}

	public NetworkGeneralSettingsUPnPInfoDialog getNetworkGeneralSettingsUPnPInfoDialogObject() {
		NetworkGeneralSettingsUPnPInfoDialog networkGeneralUPnpInfo = new NetworkGeneralSettingsUPnPInfoDialog();
		return networkGeneralUPnpInfo;
	}

	public NetworkGeneralSettingsBridgeModeInfoDialog getNetworkGeneralSettingsBridgeModeInfoDialogObject() {
		NetworkGeneralSettingsBridgeModeInfoDialog networkGeneralBridgeModeInfo = new NetworkGeneralSettingsBridgeModeInfoDialog();
		return networkGeneralBridgeModeInfo;
	}

	public NetworkGeneralSettingsIPv6EnableInfoDialog getNetworkGeneralSettingsIPv6EnableInfoDialogObject() {
		NetworkGeneralSettingsIPv6EnableInfoDialog networkGeneralIPv6Info = new NetworkGeneralSettingsIPv6EnableInfoDialog();
		return networkGeneralIPv6Info;
	}

	public NetworkGeneralSettingsPortForwardingPage getNetworkGeneralSettingsPortForwardingPageObject() {
		NetworkGeneralSettingsPortForwardingPage portForwarding = new NetworkGeneralSettingsPortForwardingPage();
		return portForwarding;
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

	public boolean clickPortForwardingink() {
		if (portForwardingLabel.isDisplayed()) {
			click(portForwardingLabel);
			return true;
		} else {
			utils.log().info("Port Forwarding Link is not displayed");
			return false;
		}
	}

	public boolean clickUPNPInfoIcon() {
		if (upnpInfoIcon.isDisplayed()) {
			click(upnpInfoIcon);
			utils.log().info("Clicked on UPnP Info Icon");
			return true;
		} else {
			utils.log().info("UPnP Info Icon is not displayed");
			return false;
		}
	}

	public boolean clickBridgeModeInfoIcon() {
		if (bridgeModeInfoIcon.isDisplayed()) {
			click(bridgeModeInfoIcon);
			utils.log().info("Clicked on Bridge Mode Info Icon");
			return true;
		} else {
			utils.log().info("Bridge Mode Info Icon is not displayed");
			return false;
		}
	}

	public boolean clickIPv6InfoIcon() {
		if (ipv6InfoIcon.isDisplayed()) {
			click(ipv6InfoIcon);
			utils.log().info("Clicked on IPv6 Info Icon");
			return true;
		} else {
			utils.log().info("IPv6 Info Icon is not displayed");
			return false;
		}
	}

	public boolean enableUPnP() {
		try {
			String str = super.getDriver().findElement(MobileBy.iOSClassChain("**/XCUIElementTypeSwitch[`name == \"General_Network_Settings_Screen_Button_Switch[1]\"`]")).getAttribute("value");
			int value = Integer.parseInt(str);
			if(value == 0)  //disabled
			{
				super.getDriver().findElement(MobileBy.iOSClassChain("**/XCUIElementTypeSwitch[`name == \"General_Network_Settings_Screen_Button_Switch[1]\"`]")).click();
				utils.log().info("UPnP is enabled");
			}else {
				utils.log().info("UPnP is already enabled");
			}
			return true;
		} catch(Exception e) {
			utils.log().info("Issue in enabling UPnP");
			return true;
		}
	}

	public boolean disableUPnP() {
		try {
			String str = super.getDriver().findElement(MobileBy.iOSClassChain("**/XCUIElementTypeSwitch[`name == \"General_Network_Settings_Screen_Button_Switch[1]\"`]")).getAttribute("value");
			int value = Integer.parseInt(str);
			if(value == 1)
			{
				//click(parentalControlToggleButton);
				super.getDriver().findElement(MobileBy.iOSClassChain("**/XCUIElementTypeSwitch[`name == \"General_Network_Settings_Screen_Button_Switch[1]\"`]")).click();
				utils.log().info("UPnP is disabled");
			}else {
				utils.log().info("UPnP is already disabled");
			}
			return true;
		} catch(Exception e) {
			utils.log().info("Issue in disabling UPnP");
			return true;
		}
	}
	
	public boolean enableBridgeMode() {
		try {
			String str = super.getDriver().findElement(MobileBy.iOSClassChain("**/XCUIElementTypeSwitch[`name == \"General_Network_Settings_Screen_Button_Switch[2]\"`]")).getAttribute("value");
			int value = Integer.parseInt(str);
			if(value == 0)  //disabled
			{
				super.getDriver().findElement(MobileBy.iOSClassChain("**/XCUIElementTypeSwitch[`name == \"General_Network_Settings_Screen_Button_Switch[2]\"`]")).click();
				utils.log().info("Bridge Mode is enabled");
			}else {
				utils.log().info("Bridge Mode is already enabled");
			}
			return true;
		} catch(Exception e) {
			utils.log().info("Issue in enabling Bridge Mode");
			return true;
		}
	}

	public boolean disableBridgeMode() {
		try {
			String str = super.getDriver().findElement(MobileBy.iOSClassChain("**/XCUIElementTypeSwitch[`name == \"General_Network_Settings_Screen_Button_Switch[2]\"`]")).getAttribute("value");
			int value = Integer.parseInt(str);
			if(value == 1)
			{
				//click(parentalControlToggleButton);
				super.getDriver().findElement(MobileBy.iOSClassChain("**/XCUIElementTypeSwitch[`name == \"General_Network_Settings_Screen_Button_Switch[2]\"`]")).click();
				utils.log().info("Bridge Mode is disabled");
			}else {
				utils.log().info("Bridge Mode is already disabled");
			}
			return true;
		} catch(Exception e) {
			utils.log().info("Issue in disabling Bridge Mode");
			return true;
		}
	}

	public boolean enableIPV6Enable() {
		try {
			String str = super.getDriver().findElement(MobileBy.iOSClassChain("**/XCUIElementTypeSwitch[`name == \"General_Network_Settings_Screen_Button_Switch[4]\"`]")).getAttribute("value");
			int value = Integer.parseInt(str);
			if(value == 0)  //disabled
			{
				super.getDriver().findElement(MobileBy.iOSClassChain("**/XCUIElementTypeSwitch[`name == \"General_Network_Settings_Screen_Button_Switch[4]\"`]")).click();
				utils.log().info("IPv6 Enable is enabled");
			}else {
				utils.log().info("IPv6 Enable is already enabled");
			}
			return true;
		} catch(Exception e) {
			utils.log().info("Issue in enabling IPv6 Enable");
			return true;
		}
	}

	public boolean disableIPv6Enable() {
		try {
			String str = super.getDriver().findElement(MobileBy.iOSClassChain("**/XCUIElementTypeSwitch[`name == \"General_Network_Settings_Screen_Button_Switch[4]\"`]")).getAttribute("value");
			int value = Integer.parseInt(str);
			if(value == 1)
			{
				//click(parentalControlToggleButton);
				super.getDriver().findElement(MobileBy.iOSClassChain("**/XCUIElementTypeSwitch[`name == \"General_Network_Settings_Screen_Button_Switch[4]\"`]")).click();
				utils.log().info("IPv6 Enable is disabled");
			}else {
				utils.log().info("IPv6 Enable is already disabled");
			}
			return true;
		} catch(Exception e) {
			utils.log().info("Issue in disabling IPv6 Enable");
			return true;
		}
	}
	
	public boolean verifyUIOnGeneralSettingsPage() {
		utils.log().info("                                               ");
		utils.log().info("***********************************************");
		utils.log().info("Verifying UI Elements on General Settings Page ");
		utils.log().info("***********************************************");

		try {
			if (generalSettingsTitle.isDisplayed())
				utils.log().info(generalSettingsTitle.getText() + " title text is displayed ");

			if (backIcon.isDisplayed())
				utils.log().info("Back Icon is displayed ");

			if (helpIcon.isDisplayed())
				utils.log().info("Help Icon is displayed");

			if (upnpLabel.isDisplayed())
				utils.log().info("UPnP Link is displayed");
			
			try {
				if (UPNPToggleButton.isDisplayed())
					utils.log().info("UPnp toggle button is displayed");
				else
					utils.log().info("UPnp toggle button is not displayed");
			}catch(Exception e) {}

			if (upnpInfoIcon.isDisplayed())
				utils.log().info("UPnP Info Icon is displayed");

			if (bridgeModeLabel.isDisplayed())
				utils.log().info("Bridge Mode Link is displayed");
			
			try {
				if (bridgeModeToggleButton.isDisplayed())
					utils.log().info("Bridge Mode toggle button is displayed");
				else
					utils.log().info("Bridge Mode toggle button is not displayed");
			}catch(Exception e) {}

			if (bridgeModeInfoIcon.isDisplayed())
				utils.log().info("Bridge Mode Info Icon is displayed");

			if (portForwardingLabel.isDisplayed())
				utils.log().info("Port Forwarding Link is displayed ");

			if (ipv6EnableLabel.isDisplayed())
				utils.log().info("IPv6 Enable is displayed");
			
			try {
				if (IPv6ToggleButton.isDisplayed())
					utils.log().info("IPv6 Enable toggle button is displayed");
				else
					utils.log().info("IPv6 Enable toggle button is not displayed");
			}catch(Exception e) {}

			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean isAt() {
		if (generalSettingsTitle.isDisplayed()) {
			utils.log().info("On General Settings Page");
			return true;
		} else {
			utils.log().info("Not on General Settings Page");
			return false;
		}
	}
}
