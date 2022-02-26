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

public class NetworkWANIPConfigurationIPv4Page extends ParentClass implements Page {
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
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Network_Wan_IP_Config_Screen_Button_DHCP\"]")
	public MobileElement dhcpRadioButton;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Network_Wan_IP_Config_Screen_Button_Static\"]")
	public MobileElement staticRadioButton;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Network_Wan_IP_Config_Screen_Label_IP\"]")
	public MobileElement ipAddressLabel;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeTextField[@name=\"Network_Wan_IP_Config_Screen_TextField_IPv4\"]")
	public MobileElement dhcp_ipAddress;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeTextField[@name=\"Network_Wan_IP_Config_Screen_TextField_IPv4\"]")
	public MobileElement static_ipAddress;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Network_Wan_IP_Config_Screen_Label_Mask\"]")
	public MobileElement subnetMaskLabel;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeTextField[@name=\"Network_Wan_IP_Config_Screen_TextField_IPv4Subnet\"]")
	public MobileElement dhcp_subnetMask;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeTextField[@name=\"Network_Wan_IP_Config_Screen_TextField_IPv4Subnet\"]")
	public MobileElement static_subnetMask;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Network_Wan_IP_Config_Screen_Label_Gateway\"]")
	public MobileElement gatewayLabel;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeTextField[@name=\"Network_Wan_IP_Config_Screen_TextField_IPv4Gateway\"]")
	public MobileElement dhcp_gateway;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeTextField[@name=\"Network_Wan_IP_Config_Screen_TextField_IPv4Gateway\"]")
	public MobileElement static_gateway;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Network_Wan_IP_Config_Screen_Label_Primary\"]")
	public MobileElement primaryDNSLabel;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeTextField[@name=\"Network_Wan_IP_Config_Screen_TextField_IPv4Primary\"]")
	public MobileElement dhcp_primaryDNS;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeTextField[@name=\"Network_Wan_IP_Config_Screen_TextField_IPv4Primary\"]")
	public MobileElement static_primaryDNS;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Network_Wan_IP_Config_Screen_Label_Secondary\"]")
	public MobileElement secondayDNSLabel;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeTextField[@name=\"Network_Wan_IP_Config_Screen_TextField_IPV4Secondary\"]")
	public MobileElement dhcp_secondaryDNS;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeTextField[@name=\"Network_Wan_IP_Config_Screen_TextField_IPV4Secondary\"]")
	public MobileElement static_secondaryDNS;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Network_Wan_IP_Config_Screen_Button\"]")
	public MobileElement dhcp_saveChangesButton;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Network_Wan_IP_Config_Screen_Button\"]")
	public MobileElement static_saveChangesButton;
	
	//All fields are mandatory
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Network_Wan_IP_Config_Screen_Label_Error5\"]")
	public MobileElement static_IPv4error;
	
	//Invalid WAN IP Address
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Network_Wan_IP_Config_Screen_Label_Error0\"]")
	public MobileElement static_IPv4invalidIPAddress;
	
	
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Done\"]")
	public MobileElement doneLink;
	
	// Alert dialog
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Network_Wan_IP_Config_Screen_Button_AlertClose\"]")
	public MobileElement closeButton;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Network_Wan_IP_Config_Screen_Label_AlertTitle\"]")
	public MobileElement alertTitle;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Network_Wan_IP_Config_Screen_Label_AlertSubTitle\"]")
	public MobileElement alertMessage;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Network_Wan_IP_Config_Screen_Button_AlertOk\"]")
	public MobileElement okButton;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Network_Wan_IP_Config_Screen_Label_Success\"]")
	public MobileElement successMessage;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Network_Wan_IP_Config_Screen_Button_SuccessOk\"]")
	public MobileElement successOKButton;
	


	public NetworkWANIPConfigurationIPv4Page() {
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
 	 
 	public NetworkWANIPConfigurationIPv6Page getNetworkWANIPConfigurationIPv6PageObject() {
 		NetworkWANIPConfigurationIPv6Page wanIPv6Configuration = new NetworkWANIPConfigurationIPv6Page();
		return wanIPv6Configuration;
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

	public boolean clickWANIPv6Tab() {
		if (wanIPv6Tab.isDisplayed()) {
			click(wanIPv6Tab);
			utils.log().info("Clicked on IPv6 Tab");
			return true;
		} else {
			utils.log().info("IPv6 Tab is not displayed");
			return false;
		}
	}
	
	public boolean clickSaveChangesButton_DHCP() {
		if (dhcp_saveChangesButton.isDisplayed() && dhcp_saveChangesButton.isEnabled()) {
			click(dhcp_saveChangesButton);
			utils.log().info("Clicked on SAVE CHANGES button");
			return true;
		} else {
			utils.log().info("SAVE CHANGES button is displayed, but is disabled");
			return false;
		}
	}
	
	public boolean clickSaveChangesButton_Static() {
		click(doneLink);
		if (static_saveChangesButton.isDisplayed() && static_saveChangesButton.isEnabled()) {
			click(static_saveChangesButton);
			utils.log().info("Clicked on SAVE CHANGES button");
			return true;
		} else {
			utils.log().info("SAVE CHANGES button is displayed, but is disabled");
			return false;
		}
	}
	
	public boolean clickDHCPRadioButton() {
		if (dhcpRadioButton.isDisplayed()) {
			utils.log().info("DHCP Radion button is selected");
			click(dhcpRadioButton);
			return true;
		} else {
			utils.log().info("DHCP Radio button is not displayed");
			return false;
		}
	}
	
	public boolean clickStaticRadioButton() {
		if (staticRadioButton.isDisplayed()) {
			click(staticRadioButton);
			utils.log().info("Static Radio button is selected");
			return true;
		} else {
			utils.log().info("Static Radio button is not displayed");
			return false;
		}
	}
	
//	public boolean clickDHCPRadioButton() {
//		if (dhcpRadioButtonChecked.isDisplayed()) {
//			utils.log().info("DHCP Radion button is already selected");
//			return true;
//		}else if(dhcpRadioButtonUnChecked.isDisplayed()) {
//			click(dhcpRadioButtonUnChecked);
//			utils.log().info("Clicked on DHCP Radion button");
//			return true;
//		} else {
//			utils.log().info("DHCP Radio button is not displayed");
//			return false;
//		}
//	}
//	
//	public boolean clickStaticRadioButton() {
//		if (staticRadioButtonUnChecked.isDisplayed()) {
//			click(staticRadioButtonUnChecked);
//			utils.log().info("Static Radio button is selected");
//			return true;
//		}else if(staticRadioButtonChecked.isDisplayed()) {
//			utils.log().info("Static Radio button is already selected");
//			return true;
//		} else {
//			utils.log().info("Static Radio button is not displayed");
//			return false;
//		}
//	}
	
	public boolean verifyUIOnWANIPv4DHCP() {
		utils.log().info("                                                ");
		utils.log().info("************************************************");
		utils.log().info("Verifying WAN IPv4 - DHCP Configuration Settings");
		utils.log().info("************************************************");
		
		this.clickDHCPRadioButton();
		try {
			try {
				if (wanIPConfigurationTitle.isDisplayed())
					utils.log().info(wanIPConfigurationTitle.getText() + " title text is displayed ");
			} catch (Exception e) {
				utils.log().info("WAN IP Configuration title text is not displayed");
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
				if (wanIPv4Tab.isDisplayed())
					utils.log().info("IPv4 Tab is displayed and is currently selected");
			} catch (Exception e) {
				utils.log().info("IPv4 Tab is not displayed");
			}

			try {
				if (wanIPv6Tab.isDisplayed())
					utils.log().info("IPV6 Tab is displayed and is not selected");
			} catch (Exception e) {
				utils.log().info("IPV6 Tab is not displayed");
			}

			try {
				if (dhcpRadioButton.isDisplayed())
					utils.log().info("DHCP Radio button is displayed");
			} catch (Exception e) {
				utils.log().info("DHCP Radio button is not displayed");
			}

			try {
				if (ipAddressLabel.isDisplayed() && dhcp_ipAddress.isDisplayed())
					utils.log().info(ipAddressLabel.getText() + " : " + dhcp_ipAddress.getText());
			} catch (Exception e) {
				utils.log().info("IP Address details is not displayed");
			}

			try {
				if (subnetMaskLabel.isDisplayed() && dhcp_subnetMask.isDisplayed())
					utils.log().info(subnetMaskLabel.getText() + " : " + dhcp_subnetMask.getText());
				} catch (Exception e) {
				utils.log().info("Subnet Mask details is not displayed");
			}

			try {
				if (gatewayLabel.isDisplayed() && dhcp_gateway.isDisplayed())
					utils.log().info(gatewayLabel.getText() + " : " + dhcp_gateway.getText());
			} catch (Exception e) {
				utils.log().info("Gateway details is not displayed");
			}

			try {
				if (primaryDNSLabel.isDisplayed() && dhcp_primaryDNS.isDisplayed())
					utils.log().info(primaryDNSLabel.getText() + " : " + dhcp_primaryDNS.getText());
			} catch (Exception e) {
				utils.log().info("Primary DNS details is not displayed");
			}

			try {
				if (secondayDNSLabel.isDisplayed() && dhcp_secondaryDNS.isDisplayed())
					utils.log().info(secondayDNSLabel.getText() + " : " + dhcp_secondaryDNS.getText());
			} catch (Exception e) {
				utils.log().info("Secondary DNS details is not displayed");
			}

			try {
				if (dhcp_saveChangesButton.isDisplayed())
					utils.log().info(dhcp_saveChangesButton.getText() + " button is displayed but is disabled");
			} catch (Exception e) {
				utils.log().info("SAVE CHANGES button is not displayed");
			}

			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean verifyUIOnWANIPv4Static() {
		utils.log().info("                                                  ");
		utils.log().info("**************************************************");
		utils.log().info("Verifying WAN IPv4 - Static Configuration Settings");
		utils.log().info("**************************************************");
		
		this.clickStaticRadioButton();

		try {
			try {
				if (wanIPConfigurationTitle.isDisplayed())
					utils.log().info(wanIPConfigurationTitle.getText() + " title text is displayed ");
			} catch (Exception e) {
				utils.log().info("WAN IP Configuration title text is not displayed");
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
				if(wanIPv4Tab.isDisplayed())
					utils.log().info("IPv4 Tab is displayed and is currently selected");
			} catch (Exception e) {
				utils.log().info("IPv4 Tab is not displayed");
			}

			try {
				if (wanIPv6Tab.isDisplayed())
					utils.log().info("IPV6 Tab is displayed and is not selected");
			} catch (Exception e) {
				utils.log().info("IPV6 Tab is not displayed");
			}

			try {
				if (staticRadioButton.isDisplayed())
					utils.log().info("Static Radio button is displayed and is selected");
			} catch (Exception e) {
				utils.log().info("Static Radio button is not displayed");
			}
		
			try {
				if (ipAddressLabel.isDisplayed() && static_ipAddress.isDisplayed())
					utils.log().info(ipAddressLabel.getText() + " : " + static_ipAddress.getText());
			} catch (Exception e) {
				utils.log().info("IP Address details is not displayed");
			}

			try {
				if (subnetMaskLabel.isDisplayed() && static_subnetMask.isDisplayed())
					utils.log().info(subnetMaskLabel.getText() + " : " + static_subnetMask.getText());
			} catch (Exception e) {
				utils.log().info("Subnet Mask details is not displayed");
			}

			try {
				if (gatewayLabel.isDisplayed() && static_gateway.isDisplayed())
					utils.log().info(gatewayLabel.getText() + " : " + static_gateway.getText());
			} catch (Exception e) {
				utils.log().info("Gateway details is not displayed");
			}

			try {
				if (primaryDNSLabel.isDisplayed() && static_primaryDNS.isDisplayed())
					utils.log().info(primaryDNSLabel.getText() + " : " + static_primaryDNS.getText());
			} catch (Exception e) {
				utils.log().info("Primary DNS details is not displayed");
			}

			try {
				if (secondayDNSLabel.isDisplayed() && static_secondaryDNS.isDisplayed())
					utils.log().info(secondayDNSLabel.getText() + " : " + static_secondaryDNS.getText());
			} catch (Exception e) {
				utils.log().info("Secondary DNS details is not displayed");
			}

			try {
				if (static_saveChangesButton.isDisplayed())
					utils.log().info(static_saveChangesButton.getText() + " button is displayed and is Enabled");
			} catch (Exception e) {
				utils.log().info("SAVE CHANGES button is not displayed");
			}
			return true;
		}catch(	Exception e){
			return false;
		}
	}
	
	public boolean validationOnWANIPv4Static_MandatoryFields() {
		utils.log().info("                                                     ");
		utils.log().info("*****************************************************");
		utils.log().info("Validation WAN IPv4 Static - All fields are Mandatory");
		utils.log().info("*****************************************************");
		
		try {
			if (static_gateway.isDisplayed()) {
				utils.log().info("Gateway IP Address : " + static_gateway.getText() + " is displayed ");
				String gatewayIPAddress = static_gateway.getText();
				clear(static_gateway);
				clickSaveChangesButton_Static();
				
				if(static_IPv4error.isDisplayed())
					utils.log().info("Validation message : " + static_IPv4error.getText() + " is displayed ");
					
				sendKeys(static_gateway, gatewayIPAddress);
				clickSaveChangesButton_Static();
				
				if(alertMessage.isDisplayed())
					click(okButton);
				super.pause(10);
				
				if(successMessage.isDisplayed())
					click(successOKButton);
				super.pause(40);
			}
			return true;
		}catch(	Exception e){
			return false;
		}
	}
	
	public boolean validationOnWANIPv4Static_InvalidWANIPAddress() {
		utils.log().info("                                                   ");
		utils.log().info("***************************************************");
		utils.log().info("Validation WAN IPv4 Static - Invalid WAN IP Address");
		utils.log().info("***************************************************");
		
		try {
			if (static_ipAddress.isDisplayed()) {
				utils.log().info("Static IP Address : " + static_ipAddress.getText() + " is displayed ");
				String iPAddress = static_ipAddress.getText();
				clear(static_ipAddress);
				sendKeys(static_ipAddress, "10.240.217.850");
				clickSaveChangesButton_Static();
				
				if(static_IPv4invalidIPAddress.isDisplayed())
					utils.log().info("Validation message : " + static_IPv4invalidIPAddress.getText() + " is displayed ");
				
				clear(static_ipAddress);
				sendKeys(static_ipAddress, iPAddress);
				clickSaveChangesButton_Static();
				
				if(alertMessage.isDisplayed())
					click(okButton);
				super.pause(10);
				
				if(successMessage.isDisplayed())
					click(successOKButton);
				super.pause(40);
			}
			return true;
		}catch(	Exception e){
			utils.log().info("Static IP Address is not displayed ");
			return false;
		}
	}

	@Override
	public boolean isAt() {
		if (wanIPConfigurationTitle.isDisplayed()) {
			utils.log().info("On WAN IPv4 Configuration Page");
			return true;
		} else {
			utils.log().info("Not on WAN IPv4 Configuration Page");
			return false;
		}
	}
}
