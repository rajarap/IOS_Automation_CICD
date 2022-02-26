package com.cs.arris.Pages;

import java.util.List;

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

public class NetworkLANIPReservationPage extends ParentClass implements Page {
	public TestUtils utils = new TestUtils();

	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Network_Lan_IP_Reservation_Screen_NavigationBar_TitleLabel\"]")
	public MobileElement lanIPTitle;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Network_Lan_IP_Reservation_Screen_NavigationBar_Button_Back\"]")
	public MobileElement backIcon;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Network_Lan_IP_Reservation_Screen_NavigationBar_Button_Help\"]")
	public MobileElement helpIcon;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Network_Lan_IP_Reservation_Screen_Button\"]")
	public MobileElement addReservationButton;

	public NetworkLANIPReservationPage() {
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

	public AppRatingDialog getAppRatingPageObject() {
		AppRatingDialog rating = new AppRatingDialog();
		return rating;
	}

	public NetworkReserveLANIPDialog getLANIPReservationDialogObject() {
		NetworkReserveLANIPDialog reserveLanIP = new NetworkReserveLANIPDialog();
		return reserveLanIP;
	}
	
	public NetworkEditReserveLANIPDialog getEditLANIPReservationDialogObject() {
		NetworkEditReserveLANIPDialog editReserveLanIP = new NetworkEditReserveLANIPDialog();
		return editReserveLanIP;
	}

	public NetworkLANSettingsPage getLANSettingsPageObject() {
		NetworkLANSettingsPage lanSettings = new NetworkLANSettingsPage();
		return lanSettings;
	}
	
	public NetworkLANIPReservationHelpPage getLanIPReservationHelpPageObject() {
		NetworkLANIPReservationHelpPage networkLANIPHelpPage = new NetworkLANIPReservationHelpPage();
		return networkLANIPHelpPage;
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

	public boolean clickAddReservationButton() {
		if (addReservationButton.isDisplayed()) {
			click(addReservationButton);
			utils.log().info("Clicked on ADD RESERVATION button");
			return true;
		} else {
			utils.log().info("ADD RESERVATION button is not displayed");
			return false;
		}
	}


	public boolean verifyUIOnNetworkLANIPReservationPage() {
		utils.log().info("                                                 ");
		utils.log().info("*************************************************");
		utils.log().info("Verifying UI Elements on LAN IP Reservation Page ");
		utils.log().info("*************************************************");
		try {
			try {
				if (lanIPTitle.isDisplayed())
					utils.log().info(lanIPTitle.getText() + " title text is displayed ");
			} catch (Exception e) {
				utils.log().info("LAN IP Reservation title text is not displayed");
			}

			try {
				if (backIcon.isDisplayed())
					utils.log().info("Back Icon is displayed ");
			} catch (Exception e) {
				utils.log().info("LAN IP Reservation title text is not displayed");
			}

			try {
				if (helpIcon.isDisplayed())
					utils.log().info("Help Icon is displayed");
			} catch (Exception e) {
				utils.log().info("LAN IP Reservation title text is not displayed");
			}

			try {
				if (addReservationButton.isDisplayed())
					utils.log().info(addReservationButton.getText() + " button is displayed");
			} catch (Exception e) {
				utils.log().info("LAN IP Reservation title text is not displayed");
			}

			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifyRulesOnLAPIPReservationPage() {
		utils.log().info("                                           ");
		utils.log().info("*******************************************");
		utils.log().info("Verifying Rules on LAN IP Reservation Page ");
		utils.log().info("*******************************************");
		
		int size = super.getDriver().findElementsByXPath("//XCUIElementTypeApplication[@name=\"SBC Test\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable").size();
	//	utils.log().info("Size of Rule List is : " + size);
		
		try {
			for (int i = 1; i <= size; i++) {
				utils.log().info("Rules with Reserved IP address  : " + i);
				utils.log().info("---------------------------------------");

				List<MobileElement> entity = (List<MobileElement>) super.getDriver().findElementsByXPath(
						"//XCUIElementTypeApplication[@name=\"SBC Test\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell["+i+"]");

				for (MobileElement e : entity) {
					if (super.getDriver().findElementByXPath("//XCUIElementTypeStaticText[@name=\"Network_Lan_IP_Reservation_Screen_Label_Header["+i+"]\"]").isDisplayed())
						utils.log().info("Rule Name: " + super.getDriver().findElementByXPath("//XCUIElementTypeStaticText[@name=\"Network_Lan_IP_Reservation_Screen_Label_Header["+i+"]\"]").getText());

					if (super.getDriver().findElementByXPath("//XCUIElementTypeStaticText[@name=\"Network_Lan_IP_Reservation_Screen_Label_IPTitle["+i+"]\"]").isDisplayed() && 
							(super.getDriver().findElementByXPath("//XCUIElementTypeStaticText[@name=\"Network_Lan_IP_Reservation_Screen_Label_IP["+i+"]\"]").isDisplayed()))
						utils.log().info(super.getDriver().findElementByXPath("//XCUIElementTypeStaticText[@name=\"Network_Lan_IP_Reservation_Screen_Label_IPTitle["+i+"]\"]").getText() + " : "
								+ (super.getDriver().findElementByXPath("//XCUIElementTypeStaticText[@name=\"Network_Lan_IP_Reservation_Screen_Label_IP["+i+"]\"]").getText()));

					if (super.getDriver().findElementByXPath("//XCUIElementTypeStaticText[@name=\"Network_Lan_IP_Reservation_Screen_Label_MacTitle["+i+"]\"]").isDisplayed() && 
							(super.getDriver().findElementByXPath("//XCUIElementTypeStaticText[@name=\"Network_Lan_IP_Reservation_Screen_Label_Mac["+i+"]\"]").isDisplayed()))
						utils.log().info(super.getDriver().findElementByXPath("//XCUIElementTypeStaticText[@name=\"Network_Lan_IP_Reservation_Screen_Label_MacTitle["+i+"]\"]").getText() + " : "
								+ (super.getDriver().findElementByXPath("//XCUIElementTypeStaticText[@name=\"Network_Lan_IP_Reservation_Screen_Label_Mac["+i+"]\"]").getText()));

					if (super.getDriver().findElementByXPath("//XCUIElementTypeButton[@name=\"Network_Lan_IP_Reservation_Screen_Button_Modify["+i+"]\"]").isDisplayed())
						utils.log().info("Edit Icon is displayed");
				}
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean clickEditLAPIPReservation() {
		try {
			for (int i = 1; i <= 1; i++) {
				List<MobileElement> entity = (List<MobileElement>) super.getDriver().findElementsByXPath(
				"//XCUIElementTypeApplication[@name=\"SBC Test\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell["+i+"]");

				for (MobileElement e : entity) {
					click(super.getDriver().findElementByXPath("//XCUIElementTypeButton[@name=\"Network_Lan_IP_Reservation_Screen_Button_Modify["+i+"]\"]"));
				}
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	@Override
	public boolean isAt() {
		if (lanIPTitle.isDisplayed()) {
			utils.log().info("On LAN IP Reservation Page");
			return true;
		} else {
			utils.log().info("Not on LAN IP Reservation Page");
			return false;
		}
	}
}
