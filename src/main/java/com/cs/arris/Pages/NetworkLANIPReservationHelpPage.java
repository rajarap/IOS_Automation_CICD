package com.cs.arris.Pages;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

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

public class NetworkLANIPReservationHelpPage extends ParentClass implements Page {
	public TestUtils utils = new TestUtils();

	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"cross\"]")
	public MobileElement closeButton;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"LAN IP Reservation\"]")
	public MobileElement lanIPReservationtitle;
	

	public NetworkLANIPReservationHelpPage() {
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}

	public boolean clickCloseButton() {
		if (closeButton.isDisplayed()) {
			new SwipeActions().swipeScreen(Direction.UP);
			click(closeButton);
			utils.log().info("Clicked on Close Button");
			return true;
		} else {
			utils.log().info("Close button is not displayed");
			return false;
		}
	}

//	public void verifyUIOnNetworWANSettingsHelpPage() {
//		try {
//			if (wanSettingstitle.isDisplayed())
//				utils.log().info(wanSettingstitle.getText() + " title is displayed ");
//		} catch (Exception e) {
//			utils.log().info("WAN Settings title is not displayed");
//		}
//		
//		try {
//			if (controlAndConfigure.isDisplayed())
//				utils.log().info("WAN Setting allows you to control and configure help is displayed ");
//		} catch (Exception e) {
//			utils.log().info("WAN Setting allows you to control and configure help is not displayed");
//		}
//		
//		try {
//			if (dhcp.isDisplayed())
//				utils.log().info("You can configure DHCP help is displayed ");
//		} catch (Exception e) {
//			utils.log().info("You can configure DHCP help is not displayed");
//		}
//		
//		try {
//			if (dns.isDisplayed())
//				utils.log().info("DNS Server can als be configured help is displayed ");
//		} catch (Exception e) {
//			utils.log().info("DNS Server can als be configured help is not displayed");
//		}
//		
//		try {
//			if (wanIPRenew.isDisplayed())
//				utils.log().info("WAN IP Renew help is displayed ");
//		} catch (Exception e) {
//			utils.log().info("WAN IP Renew help is not displayed");
//		}
//	}

	@Override
	public boolean isAt() {
		if (lanIPReservationtitle.isDisplayed()) {
			utils.log().info("On LAN IP Reservation Help Page");
			return true;
		} else {
			utils.log().info("Not on LAN IP Reservation Help Page");
			return false;
		}
	}
}
