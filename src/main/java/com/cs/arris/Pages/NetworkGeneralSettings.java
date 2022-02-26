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

public class NetworkGeneralSettings extends ParentClass implements Page {
	
	public TestUtils utils = new TestUtils();

	@AndroidFindBy(id = "com.arris.sbcBeta:id/txtToolBarTitle")
	public MobileElement generalSettingsTitle;

	@AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc='Navigate up']")
	public MobileElement backIcon;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/helpIcon")
	public MobileElement helpIcon;
	

	@AndroidFindBy(id = "com.arris.sbcBeta:id/upnp_text")
	public MobileElement upnpLabel;
	
	@AndroidFindBy(xpath = "//android.widget.Switch[@resource-id='com.arris.sbcBeta:id/upnp_enable_disable' and @checked='false']")
	public MobileElement disableUPNPToggleButton;
	
	@AndroidFindBy(xpath = "//android.widget.Switch[@resource-id='com.arris.sbcBeta:id/upnp_enable_disable' and @checked='true']")
	public MobileElement enableUPNPToggleButton;
	
	@AndroidFindBy(id = "com.arris.sbcBeta:id/upnp_info_icon")
	public MobileElement upnpInfoIcon;
	
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Bridge Mode']")
	public MobileElement bridgeModeLabel;
	
	@AndroidFindBy(xpath = "//android.widget.Switch[@resource-id='com.arris.sbcBeta:id/bridge_mode_enable_disable' and @checked='false']")
	public MobileElement disableBridgeModeToggleButton;
	
	@AndroidFindBy(xpath = "//android.widget.Switch[@resource-id='com.arris.sbcBeta:id/bridge_mode_enable_disable' and @checked='true']")
	public MobileElement enableBridgeModeToggleButton;
	
	@AndroidFindBy(id = "com.arris.sbcBeta:id/bridge_mode_info_icon")
	public MobileElement bridgeModeInfoIcon;
		
	@AndroidFindBy(id = "com.arris.sbcBeta:id/port_frwd_text")
	public MobileElement portForwardingLabel;
		
	@AndroidFindBy(id = "com.arris.sbcBeta:id/ipv6_txt")
	public MobileElement ipv6EnableLabel;
	
	@AndroidFindBy(xpath = "//android.widget.Switch[@resource-id='com.arris.sbcBeta:id/ipv6_enable_enable_disable' and @checked='false']")
	public MobileElement disableIPv6ToggleButton;
	
	@AndroidFindBy(xpath = "//android.widget.Switch[@resource-id='com.arris.sbcBeta:id/ipv6_enable_enable_disable' and @checked='true']")
	public MobileElement enableIPv6ToggleButton;
	
	@AndroidFindBy(id = "com.arris.sbcBeta:id/ipv6_enable_info_icon")
	public MobileElement ipv6InfoIcon;
	

	public NetworkGeneralSettings() {
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
  	 
	public void clickBackButton() {
		try {
			if (backIcon.isDisplayed()) {
				click(backIcon);
				utils.log().info("Clicked on Back Button");
			}
		} catch (Exception e) {
			utils.log().info("Back Button is not displayed");
		}
	}

	public void clickHelpButton() {
		try {
			if (helpIcon.isDisplayed()) {
				click(helpIcon);
				utils.log().info("Clicked on Help Button");}
		} catch (Exception e) {
			utils.log().info("Help Button is not displayed");
		}
	}

	public void clickPortForwardingink()
	{
		try {
			if (portForwardingLabel.isDisplayed()) 
				click(portForwardingLabel);
		} catch (Exception e) {
			utils.log().info("WAN IP Configuration Link is not displayed");
		}
	}
	
	public void clickUPNPInfoIcon() {
		try {
			if (upnpInfoIcon.isDisplayed()) {
				click(upnpInfoIcon);
				utils.log().info("Clicked on UPnP Info Icon");
			}
		} catch (Exception e) {
			utils.log().info("LAC Link is not displayed");
		}
	}
	
	public void clickBridgeModeInfoIcon() {
		try {
			if (bridgeModeInfoIcon.isDisplayed()) {
				click(bridgeModeInfoIcon);
				utils.log().info("Clicked on Bridge Mode Info Icon");
			}
		} catch (Exception e) {
			utils.log().info("LAC Link is not displayed");
		}
	}
	
	public void clickIPv6InfoIcon() {
		try {
			if (ipv6InfoIcon.isDisplayed()) {
				click(ipv6InfoIcon);
				utils.log().info("Clicked on IPv6 Info Icon");
			}
		} catch (Exception e) {
			utils.log().info("LAC Link is not displayed");
		}
	}
	
	public void enableUPnP() {
		try {
			if (disableUPNPToggleButton.isDisplayed()) {
				click(disableUPNPToggleButton);		
				utils.log().info("UPnP is turned ON");}
			else 
				utils.log().info("UPnP is already enabled");
		} catch (Exception e) {
			utils.log().info("UPnP toggle switch button is not displayed");
		}
	}

	public void disableUPnP() {
		try {
			if (enableUPNPToggleButton.isDisplayed()) {
				click(enableUPNPToggleButton);			
				utils.log().info("UPnP is turned OFF");}
			else 
				utils.log().info("UPnP is already disabled");
		} catch (Exception e) {
			utils.log().info("UPnP toggle switch button is not displayed");
		}
	}
	
	public void enableBridgeMode() {
		try {
			if (disableBridgeModeToggleButton.isDisplayed()) {
				click(disableBridgeModeToggleButton);		
				utils.log().info("Bridge Mode is turned ON");}
			else 
				utils.log().info("Bridge Mode is already enabled");
		} catch (Exception e) {
			utils.log().info("Bridge Mode toggle switch button is not displayed");
		}
	}

	public void disableBridgeMode() {
		try {
			if (enableBridgeModeToggleButton.isDisplayed()) {
				click(enableBridgeModeToggleButton);			
				utils.log().info("Bridge Mode is turned OFF");}
			else 
				utils.log().info("Bridge Mode is already disabled");
		} catch (Exception e) {
			utils.log().info("Bridge Mode toggle switch button is not displayed");
		}
	}
	
	public void enableIPV6Enable() {
		try {
			if (disableIPv6ToggleButton.isDisplayed()) {
				click(disableIPv6ToggleButton);		
				utils.log().info("IPv6 Enable is turned ON");}
			else 
				utils.log().info("IPv6 Enableis already enabled");
		} catch (Exception e) {
			utils.log().info("IPv6 Enable toggle switch button is not displayed");
		}
	}

	public void disableIPv6Enable() {
		try {
			if (enableIPv6ToggleButton.isDisplayed()) {
				click(enableIPv6ToggleButton);			
				utils.log().info("IPv6 Enable is turned OFF");}
			else 
				utils.log().info("IPv6 Enable is already disabled");
		} catch (Exception e) {
			utils.log().info("IPv6 Enable toggle switch button is not displayed");
		}
	}
	
	
	public void verifyUIOnGeneralSettingsPage() {
		utils.log().info("                                                         ");
		utils.log().info("*********************************************************");
		utils.log().info("Verifying UI Elements on Network - General Settings Page ");
		utils.log().info("*********************************************************");
		try {
			if (generalSettingsTitle.isDisplayed())
				utils.log().info(generalSettingsTitle.getText() + " title text is displayed ");
		} catch (Exception e) {
			utils.log().info("General Settings title text is not displayed");
		}

		try {
			if (backIcon.isDisplayed())
				utils.log().info("Back Icon is displayed ");
		} catch (Exception e) {
			utils.log().info("Back Icon is not displayed");
		}

		try {
			if (helpIcon.isDisplayed())
				utils.log().info("Help Icon is displayed");
		} catch (Exception e) {
			utils.log().info("Help Icon is not displayed");
		}

		try {
			if(upnpLabel.isDisplayed())
				utils.log().info("UPnP Link is displayed");
		} catch (Exception e) {
			utils.log().info("UPnP Link is not displayed");
		}
		
		try {
			if (disableUPNPToggleButton.isDisplayed() && !(disableUPNPToggleButton.isEnabled()))
				utils.log().info("UPnp toggle button is displayed but is disabled(OFF)");
			else 
				utils.log().info("UPnp toggle button is displayed and is enabled(ON)");
		} catch (Exception e) {
			utils.log().info("UPnP toggle button is not displayed");
		}
		
		try {
			if (upnpInfoIcon.isDisplayed())
				utils.log().info("UPnP Info Icon is displayed");
		} catch (Exception e) {
			utils.log().info("UPnP Info Icon is not displayed");
		}

		try {
			if (bridgeModeLabel.isDisplayed())
				utils.log().info("Bridge Mode Link is displayed");
		} catch (Exception e) {
			utils.log().info("Bridge Mode Link is not displayed");
		}
		
		try {
			if (disableBridgeModeToggleButton.isDisplayed() && !(disableBridgeModeToggleButton.isEnabled()))
				utils.log().info("Bridge Mode toggle button is displayed but is disabled(OFF)");
			else 
				utils.log().info("Bridge Mode toggle button is displayed and is enabled(ON)");
		} catch (Exception e) {
			utils.log().info("Bridge Mode toggle button is not displayed");
		}
		
		try {
			if (bridgeModeInfoIcon.isDisplayed())
				utils.log().info("Bridge Mode Info Icon is displayed");
		} catch (Exception e) {
			utils.log().info("Bridge Mode Info Icon is not displayed");
		}

		try {
			if (portForwardingLabel.isDisplayed())
				utils.log().info("Port Forwarding Link is displayed ");
		} catch (Exception e) {
			utils.log().info("Port Forwarding Link is not displayed");
		}

		try {
			if (ipv6EnableLabel.isDisplayed())
				utils.log().info("IPv6 Enable is displayed");
		} catch (Exception e) {
			utils.log().info("WAN IP RENEW button is not displayed");
		}
		
		try {
			if (disableIPv6ToggleButton.isDisplayed() && !(disableIPv6ToggleButton.isEnabled()))
				utils.log().info("IPv6 Enable toggle button is displayed but is disabled(OFF)");
			else 
				utils.log().info("IPv6 Enable toggle button is displayed and is enabled(ON)");
		} catch (Exception e) {
			utils.log().info("IPv6 Enable toggle button is not displayed");
		}
		
		try {
			if (ipv6InfoIcon.isDisplayed())
				utils.log().info("IPv6 Enable Info Icon is displayed");
		} catch (Exception e) {
			utils.log().info("IPv6 Enable Info Icon is not displayed");
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
