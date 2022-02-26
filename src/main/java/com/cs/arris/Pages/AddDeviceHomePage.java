package com.cs.arris.Pages;

import org.apache.commons.lang3.time.StopWatch;
import org.openqa.selenium.support.PageFactory;

import com.cs.arris.Base.ParentClass;
import com.cs.arris.Interface.Page;
import com.cs.arris.Utilities.TestUtils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class AddDeviceHomePage extends ParentClass implements Page {
	public TestUtils utils = new TestUtils();

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Modem_Home_Screen_NavigationBarTitle\"]")
	public MobileElement homeTitle;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Modem_Home_Screen_Button_NavigationBarMenu\"]")
	public MobileElement navigateButton;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Modem_Home_Screen_Button_NavigationBarNotification\"]")
	public MobileElement notificationsIcon;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"mAX Router\"]")
	public MobileElement maxRouterTab;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Cable Modem\"]")
	public MobileElement cableModemTab;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Modem_Home_Screen_TitleLabel\"]")
	public MobileElement cableModemName;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"Modem_Home_Screen_Image\"]")
	public MobileElement cableModemImage;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Modem_Home_Screen_Label_Home\"]")
	public MobileElement cableModemProviderName;
	
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"Modem_Home_Screen_Button_Close\"])[2]")
	public MobileElement protectionCloseIcon;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Modem_Home_Screen_View[1]\"]")
	public MobileElement deviceDetailsText;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Modem_Home_Screen_View[2]\"]")
	public MobileElement specificationsText;

	public AddDeviceHomePage() {
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}
	
	public HomePage getHomePageObject() {
		HomePage homePage = new HomePage();
	     return homePage;
	  }	
	
	 public AddDeviceFooterIconsPage getAddDeviceFooterIconsPageObject() {
		 AddDeviceFooterIconsPage footerIconsPage = new AddDeviceFooterIconsPage();
	     return footerIconsPage;
	  }	

	 public AddDeviceHamburgerMenuPage getHamburgerMenuObject() {
		 AddDeviceHamburgerMenuPage hamburgerMenu = new AddDeviceHamburgerMenuPage();
		 return hamburgerMenu;
	 }
	 	 
	 public AddDeviceMaximumTwoDevicesDialog getMaxTwoDevicesDialogObject() {
		 AddDeviceMaximumTwoDevicesDialog maxTwoDevices = new AddDeviceMaximumTwoDevicesDialog();
		 return maxTwoDevices;
	 }
	 
	 public AddDeviceHomePageDeviceDetailsPage getDeviceDetailsPageObject() {
		 AddDeviceHomePageDeviceDetailsPage deviceDetails = new AddDeviceHomePageDeviceDetailsPage();
		 return deviceDetails;
	 }
	 
	 public AddDeviceHomePageSpecificationDetailsPage getDeviceSpecificationsPageObject() {
		 AddDeviceHomePageSpecificationDetailsPage deviceSpec = new AddDeviceHomePageSpecificationDetailsPage();
		 return deviceSpec;
	 }
	 
	 public AddDeviceNotificationsPage getNotificationsPageObject() {
		 AddDeviceNotificationsPage notifications = new AddDeviceNotificationsPage();
		 return notifications;
	 }
	 
	 public AddDeviceUserGuidePage getUserGuidePageObject() {
		 AddDeviceUserGuidePage userGuide = new AddDeviceUserGuidePage();
		 return userGuide;
	 }
	 
	 public AddDeviceFAQPage getFAQPageObject() {
		 AddDeviceFAQPage faqPage = new AddDeviceFAQPage();
		 return faqPage;
	 }
	 
	 public RemoveDevicePage getRemoveDevicePageObject() {
		 RemoveDevicePage removeDevice = new RemoveDevicePage();
		 return removeDevice;
	 }
	 
	public boolean clickNotificationsIcon() {
		if (notificationsIcon.isDisplayed()) {
			click(notificationsIcon);
			utils.log().info("Add Device Home Page - Clicked on Notifications Icon");
			return true;
		} else {
			utils.log().info(
					"Add Device Home Page - Notifications Icon is either not visible or is not present on the DOM");
			return false;
		}
	}

	public boolean clickNavigationButton() {
		if (navigateButton.isDisplayed()) {
			click(navigateButton);
			utils.log().info("Add Device Home Page  - Clicked on Navigation Icon to display the Hamburger Menu");
			return true;
		} else {
			utils.log()
					.info("Add Device Home Page  - Navigation Icon is either not visible or is not present on the DOM");
			return false;
		}
	}

	public boolean clickDeviceDetailsText() {
		if (deviceDetailsText.isDisplayed()) {
			click(deviceDetailsText);
			utils.log().info("Add Device Home Page - Clicked on Device Details Text");
			return true;
		} else {
			utils.log().info("Add Device Home Page - Device Details Text is either not visible or is not present on the DOM");
			return false;
		}
	}

	public boolean clickSpecificationsText() {
		if (specificationsText.isDisplayed()) {
			click(specificationsText);
			utils.log().info("Add Device Home Page - Clicked on Specifications Text");
			return true;
		} else {
			utils.log().info("Add Device Home Page - Specifications Text is either not visible or is not present on the DOM");
			return false;
		}
	}
	
	public boolean clickMaxRouterTab() {
		if (maxRouterTab.isDisplayed()) {
			click(maxRouterTab);
			utils.log().info("Add Device Home Page - Clicked on mAX Router Tab");
			return true;
		} else {
			utils.log().info("Add Device Home Page - mAX Router Tab is either not visible or is not present on the DOM");
			return false;
		}
	}
	
	public boolean clickCableModemTab() {
		if (cableModemTab.isDisplayed()) {
			click(cableModemTab);
			utils.log().info("Add Device Home Page - Clicked on Cable Modem Tab");
			return true;
		} else {
			utils.log().info("Add Device Home Page - Cable Modem Tab is either not visible or is not present on the DOM");
			return false;
		}
	}
	
	public boolean clickProtectionCloseIcon() {
		if (protectionCloseIcon.isDisplayed()) {
			click(protectionCloseIcon);
			utils.log().info("Add Device Home Page - Clicked on Promotion close button");
			return true;
		} else {
			utils.log().info("Add Device Home Page - Promotion close button is either not visible or is not present on the DOM");
			return false;
		}
	}

	public boolean verifyUIOnHomePage() {
		utils.log().info("*****************************************");
		utils.log().info("Details of UI Elements on the Home Page  ");
		utils.log().info("*****************************************");
		try {
			try {
				if (homeTitle.isDisplayed())
					utils.log().info("Title " + homeTitle.getText() + " is displayed");
			} catch (Exception e) {
				utils.log().info("Home Title is not displayed");
			}

			try {
				if (navigateButton.isDisplayed())
					utils.log().info("Navigate Icon is displayed");
			} catch (Exception e) {
				utils.log().info("Navigate Icon is displayed");
			}

			try {
				if (notificationsIcon.isDisplayed())
					utils.log().info("Notifications Icon is displayed");
			} catch (Exception e) {
				utils.log().info("Notifications Icon is not displayed");
			}

			try {
				if (maxRouterTab.isDisplayed())
					utils.log().info("Max Router Tab is displayed");
			} catch (Exception e) {
				utils.log().info("Max Router Tab is not displayed");
			}

			try {
				if (cableModemTab.isDisplayed())
					utils.log().info("Cable Modem Tab is displayed");
			} catch (Exception e) {
				utils.log().info("cable Modem Tab is not displayed");
			}

			try {
				if (cableModemName.isDisplayed())
					utils.log().info("Cable Modem Name : " + cableModemName.getText() + " is displayed");
			} catch (Exception e) {
				utils.log().info("Cable Modem Name is not displayed");
			}

			try {
				if (cableModemImage.isDisplayed())
					utils.log().info("Cable Modem Image is displayed");
			} catch (Exception e) {
				utils.log().info("Cable Modem Image is not displayed");
			}

			try {
				if (deviceDetailsText.isDisplayed())
					utils.log().info("Device Details Text is displayed");
			} catch (Exception e) {
				utils.log().info("Device Details is not displayed");
			}

			try {
				if (specificationsText.isDisplayed())
					utils.log().info("Specifications Text is displayed");
			} catch (Exception e) {
				utils.log().info("Specifications is not displayed");
			}

			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean isAt() {
		if (homeTitle.isDisplayed()) {
			utils.log().info("On Add Device - Home Page");
			return true;
		} else {
			utils.log().info("Not on Add Device - Home Page");
			return false;
		}
	}
}