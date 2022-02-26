package com.cs.arris.Pages;

import org.openqa.selenium.support.PageFactory;

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

public class NetworkLANSubnetDHCPRangeConfigurationPage extends ParentClass implements Page {
	public TestUtils utils = new TestUtils();

	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Network_Settings_Lan_Subnet_Config_Screen_NavigationBar_TitleLabel\"]")
	public MobileElement lanSubnetConfigurationTitle;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Network_Settings_Lan_Subnet_Config_Screen_NavigationBar_Button_Back\"]")
	public MobileElement backIcon;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Network_Settings_Lan_Subnet_Config_Screen_NavigationBar_Button_Help\"]")
	public MobileElement helpIcon;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Network_Settings_Lan_Subnet_Config_Screen_Label_Configure\"]")
	public MobileElement configureSubnetLabel;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Network_Settings_Lan_Subnet_Config_Screen_Button_Config\"]")
	public MobileElement firstRadioButton;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Network_Settings_Lan_Subnet_Config_Screen_Label\"]")
	public MobileElement firstRadiodButtonFirstDigit;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeTextField[@name=\"Network_Settings_Lan_Subnet_Config_Screen_TextField_IP1\"]")
	public MobileElement firstRadioButtonSecondDigit;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeTextField[@name=\"Network_Settings_Lan_Subnet_Config_Screen_TextField_IP2\"]")
	public MobileElement firstRadioButtonThridDigit;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Network_Settings_Lan_Subnet_Config_Screen_Label_IP4\"]")
	public MobileElement firstRadioButtonFourthDigit;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Network_Settings_Lan_Subnet_Config_Screen_Button_Configure\"]")
	public MobileElement secondRadioButton;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Network_Settings_Lan_Subnet_Config_Screen_Label.Ten\"]")
	public MobileElement secondRadioFirstDigit;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeTextField[@name=\"Network_Settings_Lan_Subnet_Config_Screen_TextField_2IP1\"]")
	public MobileElement secondRadioButtonSecondDigit;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeTextField[@name=\"Network_Settings_Lan_Subnet_Config_Screen_TextField_2IP2\"]")
	public MobileElement secondRadioButtonThridDigit;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Network_Settings_Lan_Subnet_Config_Screen_Label_2IP4\"]")
	public MobileElement secondRadioButtonFourthDigit;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Network_Settings_Lan_Subnet_Config_Screen_Button_Config3\"]")
	public MobileElement thirdRadioButton;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Network_Settings_Lan_Subnet_Config_Screen_Label_3IP\"]")
	public MobileElement thirdRadioFirstDigit;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeTextField[@name=\"Network_Settings_Lan_Subnet_Config_Screen_TextField_3IP1\"]")
	public MobileElement thirdRadioButtonSecondDigit;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeTextField[@name=\"Network_Settings_Lan_Subnet_Config_Screen_TextField_3IP2\"]")
	public MobileElement thirdRadioButtonThridDigit;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Network_Settings_Lan_Subnet_Config_Screen_Label_3IP4\"]")
	public MobileElement thirdRadioButtonFourthDigit;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Network_Settings_Lan_Subnet_Config_Screen_Label_Range\"]")
	public MobileElement dncpRangeLabel;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Network_Settings_Lan_Subnet_Config_Screen_Label_Starting\"]")
	public MobileElement startingIPLabel;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Network_Settings_Lan_Subnet_Config_Screen_Label_StartingIP1\"]")
	public MobileElement startingIPPrefix1;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Network_Settings_Lan_Subnet_Config_Screen_Label_StartingIP2\"]")
	public MobileElement startingIPPrefix2;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Network_Settings_Lan_Subnet_Config_Screen_Label_StartingIP3\"]")
	public MobileElement startingIPPrefix3;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeTextField[@name=\"Network_Settings_Lan_Subnet_Config_Screen_TextField_StartingIP\"]")
	public MobileElement startingIPSuffix;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Network_Settings_Lan_Subnet_Config_Screen_Label_Ending\"]")
	public MobileElement endingIPLabel;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Network_Settings_Lan_Subnet_Config_Screen_Label_EndingIP1\"]")
	public MobileElement endingIPPrefix1;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Network_Settings_Lan_Subnet_Config_Screen_Label_EndingIP2\"]")
	public MobileElement endingIPPrefix2;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Network_Settings_Lan_Subnet_Config_Screen_Label_EndingIP3\"]")
	public MobileElement endingIPPrefix3;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeTextField[@name=\"Network_Settings_Lan_Subnet_Config_Screen_TextField_EndingIP1\"]")
	public MobileElement endingIPSuffix;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Network_Settings_Lan_Subnet_Config_Screen_Label_Mask\"]")
	public MobileElement subnetMaskIPLabel;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeTextField[@name=\"Network_Settings_Lan_Subnet_Config_Screen_TextField\"]")
	public MobileElement subnetMask;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Network_Settings_Lan_Subnet_Config_Screen_Button\"]")
	public MobileElement saveButton;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Network_Settings_Lan_Subnet_Config_Screen_Button_Reset\"]")
	public MobileElement resetSubnetButton;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Network_Settings_Lan_Subnet_Config_Screen_Label_Error0\"]")
	public MobileElement enterDHCPRangeBtw1And255;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Network_Settings_Lan_Subnet_Config_Screen_Label_Error0\"]")
	public MobileElement enterValidDHCPRangeBtw1And255;
	
		@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Network_Settings_Lan_Subnet_Config_Screen_Label_Error3\"]")
	public MobileElement enterValidIPAddressText1;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Network_Settings_Lan_Subnet_Config_Screen_Label_Error4\"]")
	public MobileElement enterValidIPAddressText2;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Network_Settings_Lan_Subnet_Config_Screen_TextField_Error5\"]")
	public MobileElement enterValidIPAddressText3;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Network_Settings_Lan_Subnet_Config_Screen_TextField_Error5\"]")
	public MobileElement enterValidIPAddressTex16_31;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Done\"]")
	public MobileElement doneLink;

	
	public NetworkLANSubnetDHCPRangeConfigurationPage() {
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}

	public FooterIconsPage getFooterIconsPageObject() {
		FooterIconsPage footerIconsPage = new FooterIconsPage();
		return footerIconsPage;
	}

	public NetworkLANSettingsPage getLANSettingsPageObject() {
		NetworkLANSettingsPage lanSettings = new NetworkLANSettingsPage();
		return lanSettings;
	}

	public NetworkLANSubnetDHCPConfigurationHelpPage getLANSubnetRangeHelpPageObject() {
		NetworkLANSubnetDHCPConfigurationHelpPage lanSubnetRangeHelp = new NetworkLANSubnetDHCPConfigurationHelpPage();
		return lanSubnetRangeHelp;
	}
	
	public NetworkLANDHCPIPRangeBetween1And255AlertDialog getLANDHCPBetween1And255DialogObject() {
		NetworkLANDHCPIPRangeBetween1And255AlertDialog landhcpRange1To255 = new NetworkLANDHCPIPRangeBetween1And255AlertDialog();
		return landhcpRange1To255;
	}
	
	public NetworkLANSubnetDHCPChangeIPRangeConfigurationAlertDialog getLANDHCPChangeRangeIPDialogObject() {
		NetworkLANSubnetDHCPChangeIPRangeConfigurationAlertDialog lanChangedhcpRange = new NetworkLANSubnetDHCPChangeIPRangeConfigurationAlertDialog();
		return lanChangedhcpRange;
	}
	
	public NetworkLANDHCPIPRangeEmptyOctetAlertDialog getLANDHCPEmptyOCtetDialogObject() {
		NetworkLANDHCPIPRangeEmptyOctetAlertDialog landhcpEmptyOctet = new NetworkLANDHCPIPRangeEmptyOctetAlertDialog();
		return landhcpEmptyOctet;
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

	public boolean clickResetToDefaultButton() {
		if (resetSubnetButton.isDisplayed()) {
			click(resetSubnetButton);
			utils.log().info("Clicked on Reset To Default button");
			return true;
		} else {
			utils.log().info("Reset To Default button is not displayed");
			return false;
		}
	}

	public boolean verifyUIOnLANSubnetConfigurationPage() {
		utils.log().info("                                                       ");
		utils.log().info("*******************************************************");
		utils.log().info("Verifying UI Elements on LAN Subnet Configuration Page ");
		utils.log().info("*******************************************************");

		try
		{
			if (lanSubnetConfigurationTitle.isDisplayed())
				utils.log().info(lanSubnetConfigurationTitle.getText() + " title text is displayed ");
			else
				utils.log().info("LAN DHCP Lease Time text is not displayed");

			if (backIcon.isDisplayed())
				utils.log().info("Back Icon is displayed ");
			else
				utils.log().info("Back Icon is not displayed");
			
			if (helpIcon.isDisplayed())
				utils.log().info("Help Icon is displayed ");
			else
				utils.log().info("Back Icon is not displayed");

			if (configureSubnetLabel.isDisplayed())
				utils.log().info(configureSubnetLabel.getText() + " label is displayed");
			else
				utils.log().info("Help Icon is not displayed");
			
			if (firstRadioButton.isDisplayed())
				utils.log().info("First Subnet IP address Radio button option is displayed");
			else
				utils.log().info("First Subnet IP address Radio button option is not displayed");
		
			if (firstRadiodButtonFirstDigit.isDisplayed() && firstRadioButtonSecondDigit.isDisplayed() && 
					firstRadioButtonThridDigit.isDisplayed() && firstRadioButtonFourthDigit.isDisplayed())
				utils.log().info("First Subnet IP address : " + firstRadiodButtonFirstDigit.getText() + firstRadioButtonSecondDigit.getText() + "." + firstRadioButtonThridDigit.getText() + firstRadioButtonFourthDigit.getText());
			else
				utils.log().info("First Subnet IP address is not displayed");
			
			if (secondRadioButton.isDisplayed())
				utils.log().info("Second Subnet IP address Radio button option is displayed");
			else
				utils.log().info("Second Subnet IP address Radio button option is not displayed");
			
			if (secondRadioFirstDigit.isDisplayed() && secondRadioButtonSecondDigit.isDisplayed() && 
					secondRadioButtonThridDigit.isDisplayed() && secondRadioButtonFourthDigit.isDisplayed())
				utils.log().info("Second Subnet IP address : " + secondRadioFirstDigit.getText() + secondRadioButtonSecondDigit.getText() + "." + secondRadioButtonThridDigit.getText() + secondRadioButtonFourthDigit.getText());
			else
				utils.log().info("Second Subnet IP address is not displayed");
			
			if (thirdRadioButton.isDisplayed())
				utils.log().info("Third Subnet IP address Radio button option is displayed");
			else
				utils.log().info("Third Subnet IP address Radio button option is not displayed");
			
			if (thirdRadioFirstDigit.isDisplayed() && thirdRadioButtonSecondDigit.isDisplayed() && 
					thirdRadioButtonThridDigit.isDisplayed() && thirdRadioButtonFourthDigit.isDisplayed())
				utils.log().info("Third Subnet IP address : " + thirdRadioFirstDigit.getText() + thirdRadioButtonSecondDigit.getText() + "." + thirdRadioButtonThridDigit.getText() + thirdRadioButtonFourthDigit.getText());
			else
				utils.log().info("Third Subnet IP address is not displayed");
			
			if (dncpRangeLabel.isDisplayed())
				utils.log().info("DHCP Range Label is displayed");
			else
				utils.log().info("BDHCP Range Label is not displayed");
			
			if (startingIPLabel.isDisplayed())
				utils.log().info("Starting IP Label is displayed");
			else
				utils.log().info("Starting IP Label is not displayed");
			
			if (startingIPPrefix1.isDisplayed() && startingIPPrefix2.isDisplayed() && startingIPPrefix3.isDisplayed() && startingIPSuffix.isDisplayed())
				utils.log().info("DHCP Range Starting IP is : " + startingIPPrefix1.getText() + startingIPPrefix2.getText() + "." + startingIPPrefix3.getText() + "." + startingIPSuffix.getText() + " is displayed");
			else
				utils.log().info("DHCP Range Starting IP is not displayed");
			
			if (endingIPLabel.isDisplayed())
				utils.log().info("Ending IP Label is displayed");
			else
				utils.log().info("Button to select the time unit is not displayed");
			
			if (endingIPPrefix1.isDisplayed() && endingIPPrefix2.isDisplayed() && endingIPPrefix3.isDisplayed() && endingIPSuffix.isDisplayed())
				utils.log().info("DHCP Range Ending IP is : " + endingIPPrefix1.getText() + endingIPPrefix2.getText() + "." + endingIPPrefix3.getText() + "." + endingIPSuffix.getText() + " is displayed");
			else
				utils.log().info("DHCP Range Ending IP is not displayed");
			
			if (subnetMaskIPLabel.isDisplayed())
				utils.log().info("Subnet Mask Label is displayed");
			else
				utils.log().info("Subnet Mask Label is not displayed");
			
			if (subnetMask.isDisplayed())
				utils.log().info("Subnet Mask : " + subnetMask.getText() + " is displayed and is disabled. Subnet Mask cannot be changed");
			else
				utils.log().info("Subnet Mask is not displayed");
			
			if (saveButton.isDisplayed())
				utils.log().info(saveButton.getText() + " button is displayed");
			else
				utils.log().info("Save Subnet Mask Button is not displayed");
			
			if (resetSubnetButton.isDisplayed())
				utils.log().info(resetSubnetButton.getText() + " button is displayed");
			else
				utils.log().info("Reset Subnet Mask Button is not displayed");
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean verifyDHCPIPAddressRangeForSelectedSubnet() {
		utils.log().info("                                                    ");
		utils.log().info("****************************************************");
		utils.log().info("Verifying DHCP IP Address Range For Selected Subnet ");
		utils.log().info("****************************************************");
		
		//192.168.0.1 (192.168.0.100/192.168.0.254)
		click(firstRadioButton);
		utils.log().info("First Subnet - Starting DHCP IP Address Range is: " + startingIPPrefix1.getText() + startingIPPrefix2.getText() + "." + startingIPPrefix3.getText() + "." + startingIPSuffix.getText());
		utils.log().info("First Subnet - Ending DHCP IP Address Range is: " + endingIPPrefix1.getText() + endingIPPrefix2.getText() + "." + endingIPPrefix3.getText() + "." + endingIPSuffix.getText());
		
		//10.0.0.1 (10.0.0.100/10.0.0.254)
		click(secondRadioButton);
		utils.log().info("Second Subnet - Starting DHCP IP Address Range is: " + startingIPPrefix1.getText() + startingIPPrefix2.getText() + "." + startingIPPrefix3.getText() + "." + startingIPSuffix.getText());
		utils.log().info("Second Subnet - Ending DHCP IP Address Range is: " + endingIPPrefix1.getText() + endingIPPrefix2.getText() + "." + endingIPPrefix3.getText() + "." + endingIPSuffix.getText());
		
		//172.16.0.1 (172.16.0.100/172.16.0.254)
		click(thirdRadioButton);
		utils.log().info("Third Subnet - Starting DHCP IP Address Range is: " + startingIPPrefix1.getText() + startingIPPrefix2.getText() + "." + startingIPPrefix3.getText() + "." + startingIPSuffix.getText());
		utils.log().info("Third Subnet - Ending DHCP IP Address Range is: " + endingIPPrefix1.getText() + endingIPPrefix2.getText() + "." + endingIPPrefix3.getText() + "." + endingIPSuffix.getText());
		
		return true;
		
	}
	
	public boolean EditDHCPIPAddressRangeForFirstSubnet() {
		utils.log().info("                                               ");
		utils.log().info("************************************************");
		utils.log().info("Changing DHCP IP Address Range For First Subnet ");
		utils.log().info("************************************************");
		
		click(firstRadioButton);
		utils.log().info("First Subnet - Starting DHCP IP Address Range is: " + startingIPPrefix1.getText() + startingIPPrefix2.getText() + "." + startingIPPrefix3.getText() + "." + startingIPSuffix.getText());
		utils.log().info("First Subnet - Ending DHCP IP Address Range is: " + endingIPPrefix1.getText() + endingIPPrefix2.getText() + "." + endingIPPrefix3.getText() + "." + endingIPSuffix.getText());
		super.clear(startingIPSuffix);
		super.sendKeys(startingIPSuffix, "10");
		click(doneLink);
		super.clear(endingIPSuffix);
		super.sendKeys(endingIPSuffix, "150");
		click(doneLink);

		return true;
		
		// click save. Alert dialog "NetworkLANSubnetDHCPChangeIPRangeConfigurationAlertDialog" should appear.  Click close/cancel button
		
	}
	
	public boolean EditDHCPIPAddressRangeForSecondSubnet() {
		utils.log().info("                                                ");
		utils.log().info("*************************************************");
		utils.log().info("Changing DHCP IP Address Range For Second Subnet ");
		utils.log().info("*************************************************");
		
		click(secondRadioButton);
		utils.log().info("Second Subnet - Starting DHCP IP Address Range is: " + startingIPPrefix1.getText() + startingIPPrefix2.getText() + "." + startingIPPrefix3.getText() + "." + startingIPSuffix.getText());
		utils.log().info("Second Subnet - Ending DHCP IP Address Range is: " + endingIPPrefix1.getText() + endingIPPrefix2.getText() + "." + endingIPPrefix3.getText() + "." + endingIPSuffix.getText());
		super.clear(startingIPSuffix);
		super.sendKeys(startingIPSuffix, "150");
		click(doneLink);
		super.clear(endingIPSuffix);
		super.sendKeys(endingIPSuffix, "220");
		click(doneLink);

		return true;
		
		// click save. Alert dialog "NetworkLANSubnetDHCPChangeIPRangeConfigurationAlertDialog" should appear.  Click close/cancel button
	}
	
	public boolean EditDHCPIPAddressRangeForThirdSubnet() {
		utils.log().info("                                               ");
		utils.log().info("************************************************");
		utils.log().info("Changing DHCP IP Address Range For Third Subnet ");
		utils.log().info("************************************************");
		
		click(thirdRadioButton);
		utils.log().info("Third Subnet - Starting DHCP IP Address Range is: " + startingIPPrefix1.getText() + startingIPPrefix2.getText() + "." + startingIPPrefix3.getText() + "." + startingIPSuffix.getText());
		utils.log().info("Third Subnet - Ending DHCP IP Address Range is: " + endingIPPrefix1.getText() + endingIPPrefix2.getText() + "." + endingIPPrefix3.getText() + "." + endingIPSuffix.getText());
		super.clear(startingIPSuffix);
		super.sendKeys(startingIPSuffix, "10");
		click(doneLink);
		super.clear(endingIPSuffix);
		super.sendKeys(endingIPSuffix, "150");
		click(doneLink);
		return true;
		
		// click save. Alert dialog "NetworkLANSubnetDHCPChangeIPRangeConfigurationAlertDialog" should appear.  Click close/cancel button
	}

	
	public boolean verifyLANDHCPRangeBetween1And255() {
		utils.log().info("                                               ");
		utils.log().info("**************************************************");
		utils.log().info("DHCP IP Address Range Should be Between 1 and 255 ");
		utils.log().info("**************************************************");
		
		click(thirdRadioButton);
		utils.log().info("Third Subnet - Starting DHCP IP Address Range is: " + startingIPPrefix1.getText() + startingIPPrefix2.getText() + "." + startingIPPrefix3.getText() + "." + startingIPSuffix.getText());
		utils.log().info("Third Subnet - Ending DHCP IP Address Range is: " + endingIPPrefix1.getText() + endingIPPrefix2.getText() + "." + endingIPPrefix3.getText() + "." + endingIPSuffix.getText());
		super.clear(startingIPSuffix);
		super.sendKeys(startingIPSuffix, "1");
		click(doneLink);
		super.clear(endingIPSuffix);
		super.sendKeys(endingIPSuffix, "255");
		click(doneLink);
		return true;
		
		// click save. Alert dialog "NetworkLANDHCPIPRangeBetween1And255AlertDialog" should appear.  Click close/cancel button
	}
	
	public boolean verifyLANDHCPRangeBetween1And2552() {
//		utils.log().info("                                               ");
//		utils.log().info("**************************************************");
//		utils.log().info("DHCP IP Address Range Should be Between 1 and 255 ");
//		utils.log().info("**************************************************");
		
//		click(thirdRadioButton);
//		utils.log().info("Third Subnet - Starting DHCP IP Address Range is: " + startingIPPrefix1.getText() + startingIPPrefix2.getText() + "." + startingIPPrefix3.getText() + "." + startingIPSuffix.getText());
//		utils.log().info("Third Subnet - Ending DHCP IP Address Range is: " + endingIPPrefix1.getText() + endingIPPrefix2.getText() + "." + endingIPPrefix3.getText() + "." + endingIPSuffix.getText());
		super.clear(startingIPSuffix);
		super.sendKeys(startingIPSuffix, "5");
		click(doneLink);
		super.clear(endingIPSuffix);
		super.sendKeys(endingIPSuffix, "25");
		click(doneLink);
		return true;
		
		// click save. Alert dialog "NetworkLANDHCPIPRangeBetween1And255AlertDialog" should appear.  Click close/cancel button
	}
	
	public boolean verifyFirstLANSubnetConfigurationWithInvalidOctet() {
		utils.log().info("                                              ");
		utils.log().info("**********************************************");
		utils.log().info("Changing 3rd Octet to Invalid IP Address Range");
		utils.log().info("**********************************************");
		
		click(firstRadioButton);
		utils.log().info("Selected First Subnet IP address Radio button option : " + firstRadiodButtonFirstDigit.getText() + firstRadioButtonSecondDigit.getText()
		+ "." + firstRadioButtonThridDigit.getText() + firstRadioButtonFourthDigit.getText());
		utils.log().info("Changing 3rd Octet value to 999");
		clear(firstRadioButtonThridDigit);
		super.sendKeys(firstRadioButtonThridDigit, "999");
		click(doneLink);
		return true;
		
		//click save.  enterValidIPAddressText1 text should be displayed
	}
	
	public boolean verifySecondLANSubnetConfigurationWithInvalidOctet() {
		utils.log().info("                                                      ");
		utils.log().info("******************************************************");
		utils.log().info("Changing 2nd and 3rd Octet to Invalid IP Address Range");
		utils.log().info("******************************************************");
		
		click(secondRadioButton);
		utils.log().info("Selected Second Subnet IP address Radion button option : " + secondRadioFirstDigit.getText() + secondRadioButtonSecondDigit.getText()
		+ "." + secondRadioButtonThridDigit.getText() + secondRadioButtonFourthDigit.getText());
		utils.log().info("Changing 2nd Octet value to 555");
		clear(secondRadioButtonSecondDigit);
		super.sendKeys(secondRadioButtonSecondDigit, "555");
		click(doneLink);
		utils.log().info("Changing 3rd Octet value to 888");
		clear(secondRadioButtonThridDigit);
		super.sendKeys(secondRadioButtonThridDigit, "888");
		click(doneLink);
		return true;
		
		//click save.  enterValidIPAddressText2 text should be displayed
	}
	
	public boolean verifyThirdLANSubnetConfigurationWithInvalidOctet() {
		utils.log().info("                                                      ");
		utils.log().info("******************************************************");
		utils.log().info("Changing 2nd and 3rd Octet to Invalid IP Address Range");
		utils.log().info("******************************************************");
		
		click(thirdRadioButton);
		utils.log().info("Selected Third Subnet IP address Radion button option : " + thirdRadioFirstDigit.getText() + thirdRadioButtonSecondDigit.getText()
		+ "." + thirdRadioButtonThridDigit.getText() + thirdRadioButtonFourthDigit.getText());
		utils.log().info("Changing 2nd Octet value to 666");
		clear(thirdRadioButtonSecondDigit);
		super.sendKeys(thirdRadioButtonSecondDigit, "666");
		click(doneLink);
		utils.log().info("Changing 3rd Octet value to 000");
		clear(thirdRadioButtonThridDigit);
		super.sendKeys(thirdRadioButtonThridDigit, "000");
		click(doneLink);
		return true;
		
		//click save.  enterValidIPAddressText3 text should be displayed
	}
	
	public boolean verifyThirdLANSubnetConfigurationWithSecondInvalidOctet() {
		utils.log().info("                                                         ");
		utils.log().info("*********************************************************");
		utils.log().info("Changing 2nd Octet value to less than 16 IP Address Range");
		utils.log().info("*********************************************************");
		
		click(thirdRadioButton);
		utils.log().info("Selected Third Subnet IP address Radion button option : " + thirdRadioFirstDigit.getText() + thirdRadioButtonSecondDigit.getText()
		+ "." + thirdRadioButtonThridDigit.getText() + thirdRadioButtonFourthDigit.getText());
		clear(thirdRadioButtonSecondDigit);
		super.sendKeys(thirdRadioButtonSecondDigit, "10");
		utils.log().info("Changing 2nd Octet value to 10");
		click(doneLink);
		return true;
		
		//click save. enterValidIPAddressTex16_31 text should be displayed
	}
	
	public boolean verifyLANDHCPRangeWithEmptySuffix() {
		utils.log().info("                                                                        ");
		utils.log().info("************************************************************************");
		utils.log().info("Select 3rd Subnet and Configure DHCP Starting IP Range with Empty Suffix");
		utils.log().info("************************************************************************");
		
		click(thirdRadioButton);
		utils.log().info("Selected Third Subnet IP address Radion button option : " + thirdRadioFirstDigit.getText() + thirdRadioButtonSecondDigit.getText()
		+ "." + thirdRadioButtonThridDigit.getText() + thirdRadioButtonFourthDigit.getText());
		super.sendKeys(startingIPSuffix, " ");
		utils.log().info("Changing 3rd Octet value to blank");
		click(doneLink);
		return true;
		
		//click save. Alert dialog "NetworkLANDHCPIPRangeBetween1And255AlertDialog" should appear.  Click close/cancel button
	}
	
	public boolean verifyLANDHCPRangeWithEmptySuffix2() {
		utils.log().info("                                                      ");
		utils.log().info("******************************************************");
		utils.log().info("Select 3rd Subnet and Configure DHCP Starting IP Range");
		utils.log().info("******************************************************");
		
		click(thirdRadioButton);
		utils.log().info("Selected Third Subnet IP address Radion button option : " + thirdRadioFirstDigit.getText() + thirdRadioButtonSecondDigit.getText()
		+ "." + thirdRadioButtonThridDigit.getText() + thirdRadioButtonFourthDigit.getText());
		super.sendKeys(startingIPSuffix, "45");
		click(doneLink);
		super.sendKeys(endingIPSuffix, "145");
		click(doneLink);
		return true;
		
		//click save. Alert dialog "NetworkLANDHCPIPRangeBetween1And255AlertDialog" should appear.  Click close/cancel button
	}
	
	
	//click Reset button. Alert dialog "NetworkLANSubnetDHCPChangeIPRangeConfigurationAlertDialog" should appear. Click close/cancel button


	@Override
	public boolean isAt() {
		if (lanSubnetConfigurationTitle.isDisplayed()) {
			utils.log().info("On LAN Subnet Configuration Page");
			return true;
		} else {
			utils.log().info("Not on LAN Subnet Configuration Page");
			return false;
		}
	}
}
