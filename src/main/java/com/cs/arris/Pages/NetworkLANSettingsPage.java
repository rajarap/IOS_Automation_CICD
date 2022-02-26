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

public class NetworkLANSettingsPage extends ParentClass implements Page {
	public TestUtils utils = new TestUtils();

	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"LAN Settings\"]")
	public MobileElement lanSettingsTitle;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeOther[@name=\"NavigationBar_Button_Back\"]")
	public MobileElement backIcon;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeOther[@name=\"NavigationBar_Button_Help\"]")
	public MobileElement helpIcon;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Network_Lan_Settings_Screen_Label_[1]\"]")
	public MobileElement lanIPReservationLabel;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Network_Lan_Settings_Screen_Label_[2]\"]")
	public MobileElement lanSubnetLabel;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Network_Lan_Settings_Screen_Label_[3]\"]")
	public MobileElement lanDHCPLeaseTimeLabel;

	public NetworkLANSettingsPage() {
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}

	public HomePage getHomePageObject() {
		HomePage homePage = new HomePage();
		return homePage;
	}

	public NetworkLANSettingsHelpPage getNetworkLanSettingsHelpPageObject() {
		NetworkLANSettingsHelpPage networkLANHelpPage = new NetworkLANSettingsHelpPage();
		return networkLANHelpPage;
	}

	public FooterIconsPage getFooterIconsPageObject() {
		FooterIconsPage footerIconsPage = new FooterIconsPage();
		return footerIconsPage;
	}

	public AppRatingDialog getAppRatingPageObject() {
		AppRatingDialog rating = new AppRatingDialog();
		return rating;
	}

	public NetworkLANIPReservationPage getNetworkLANIPReservationPageObject() {
		NetworkLANIPReservationPage wanIPv6Configuration = new NetworkLANIPReservationPage();
		return wanIPv6Configuration;
	}

	public NetworkLANSubnetDHCPRangeConfigurationPage getNetworkLANSubnetDHCPLRangePageObject() {
		NetworkLANSubnetDHCPRangeConfigurationPage lanDHCPConfiguration = new NetworkLANSubnetDHCPRangeConfigurationPage();
		return lanDHCPConfiguration;
	}

	public NetworkLANDHCPLeaseTimePage getNetworkLANDHCPLeaseTimePageObject() {
		NetworkLANDHCPLeaseTimePage lanLeaseTime = new NetworkLANDHCPLeaseTimePage();
		return lanLeaseTime;
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

	public boolean clickLANIPResevationLink() {
		if (lanIPReservationLabel.isDisplayed()) {
			click(lanIPReservationLabel);
			return true;
		} else {
			utils.log().info("LAN IP Reservation Link is not displayed");
			return false;
		}
	}

	public boolean clickLANSubnetLink() {
		if (lanSubnetLabel.isDisplayed()) {
			click(lanSubnetLabel);
			utils.log().info("Clicked on LAN Subnet and DHCP Range Configuration Link");
			return true;
		} else {
			utils.log().info("LAN Subnet and DHCP Range Configuration Link is not displayed");
			return false;
		}
	}

	public boolean clickDHCPLeaseTimeLink() {
		if (lanDHCPLeaseTimeLabel.isDisplayed()) {
			click(lanDHCPLeaseTimeLabel);
			utils.log().info("Clicked on LAN DHCP Lease Time Link");
			return true;
		} else {
			utils.log().info("LAN DHCP Lease Time Link is not displayed");
			return false;
		}
	}

	public boolean verifyUIOnLANSettingsPage() {
		utils.log().info("                                                     ");
		utils.log().info("*****************************************************");
		utils.log().info("Verifying UI Elements on Network - LAN Settings Page ");
		utils.log().info("*****************************************************");
		try {

			try {
				if (lanSettingsTitle.isDisplayed())
					utils.log().info(lanSettingsTitle.getText() + " title text is displayed ");
			} catch (Exception e) {
				utils.log().info("LAN Settings title text is not displayed");
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
				if (lanIPReservationLabel.isDisplayed())
					utils.log().info("LAN IP Reservation Link is displayed");
			} catch (Exception e) {
				utils.log().info("LAN IP Reservation Link is not displayed");
			}

			try {
				if (lanSubnetLabel.isDisplayed())
					utils.log().info("LAC Link is displayed");
			} catch (Exception e) {
				utils.log().info("LAC Link is not displayed");
			}
			
			try {
				if (lanDHCPLeaseTimeLabel.isDisplayed())
					utils.log().info("DNS Configuration Link is displayed ");
			} catch (Exception e) {
				utils.log().info("DNS Configuration Link is not displayed");
			}
			
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	

	@Override
	public boolean isAt() {
		if (lanSettingsTitle.isDisplayed()) {
			utils.log().info("On LAN Settings Page");
			return true;
		} else {
			utils.log().info("Not on LAN Settings Page");
			return false;
		}
	}
}
