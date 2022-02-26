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

public class NetworkHelpPage extends ParentClass implements Page {
	public TestUtils utils = new TestUtils();

	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"cross\"]")
	public MobileElement closeButton;

	@iOSXCUITFindBy(xpath="(//XCUIElementTypeStaticText[@name=\"Network Settings\"])[1]")
	public MobileElement NetworkSettingstitle;
//	
//	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"cross\"]")
//	public MobileElement mainWiFi;
//	
//	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"cross\"]")
//	public MobileElement useCardToChangeSSID;
//	
//	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"cross\"]")
//	public MobileElement pleaseNoteThat;
//	
//	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"cross\"]")
//	public MobileElement duringTheTransition;
//	
//	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"cross\"]")
//	public MobileElement enableYourGuestNetwork;
//	
//	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"cross\"]")
//	public MobileElement changeGuestNetwork;
//	
//	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"cross\"]")
//	public MobileElement summary;
//	
//	@AndroidFindBy(xpath = "//android.widget.TextView[@bounds='[157,734][1029,1283]']")
//	public MobileElement expandYourCard;
//	
//	@AndroidFindBy(xpath = "//android.widget.TextView[@bounds='[157,1280][1029,1752]']")
//	public MobileElement forSomeOfTheMoreAdvancedSettings;
//	
//	@AndroidFindBy(xpath = "//android.widget.TextView[@bounds='[52,1794][1029,2042]']")
//	public MobileElement testMySpeedConnection;
//	
//	@AndroidFindBy(xpath = "//android.widget.TextView[@bounds='[157,1406][1029,1721]']")
//	public MobileElement internetAccessSpeed;
//	
//	@AndroidFindBy(xpath = "//android.widget.TextView[@bounds='[157,1716][1029,2042]']")
//	public MobileElement speedBetweenMobileDevices;
	
	

	public NetworkHelpPage() {
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}

	public boolean clickCloseButton() {
			if (closeButton.isDisplayed()) {
				new SwipeActions().swipeScreen(Direction.UP);
				new SwipeActions().swipeScreen(Direction.UP);
				click(closeButton);
				return true;}
			else
				return false;
	}

//	public void verifyUIOnNetworkHelpPage() {
//		try {
//			if (NetworkSettingstitle.isDisplayed())
//				utils.log().info(NetworkSettingstitle.getText() + " title is displayed ");
//		} catch (Exception e) {
//			utils.log().info("Network Settings title is not displayed");
//		}
//		
//		try {
//			if (mainWiFi.isDisplayed())
//				utils.log().info("Main Wifi help is displayed ");
//		} catch (Exception e) {
//			utils.log().info("Main Wifi help is not displayed");
//		}
//		
//		try {
//			if (useCardToChangeSSID.isDisplayed())
//				utils.log().info("Use this card to Change your SSID help is displayed ");
//		} catch (Exception e) {
//			utils.log().info("Use this card to Change your SSID help is not displayed");
//		}
//		
//		try {
//			if (pleaseNoteThat.isDisplayed())
//				utils.log().info("Changing SSID and password help is displayed ");
//			new SwipeActions().swipeScreen(Direction.UP);
//		} catch (Exception e) {
//			utils.log().info("Changing SSID and password help is not displayed");
//		}
//		
//		try {
//			if (duringTheTransition.isDisplayed())
//				utils.log().info("You will be disconnected from your current network is displayed ");
//		} catch (Exception e) {
//			utils.log().info("You will be disconnected from your current network is not displayed");
//		}
//		
//		try {
//			if (enableYourGuestNetwork.isDisplayed())
//				utils.log().info("Enable your Guest Network is displayed ");
//			new SwipeActions().swipeScreen(Direction.UP);
//		} catch (Exception e) {
//			utils.log().info("Enable your Guest Network is not displayed");
//		}
//		
//		try {
//			if (changeGuestNetwork.isDisplayed())
//				utils.log().info("Change your Guest Network is displayed ");
//		} catch (Exception e) {
//			utils.log().info("Change your Guest Network is not displayed");
//		}
//		
//		try {
//			if (summary.isDisplayed())
//				utils.log().info("Network Settings is displayed ");
//		} catch (Exception e) {
//			utils.log().info("Network Settings is not displayed");
//		}
//		
//		try {
//			if (expandYourCard.isDisplayed())
//				utils.log().info("Expand your cards is displayed ");
//			new SwipeActions().swipeScreen(Direction.UP);
//		} catch (Exception e) {
//			utils.log().info("Expand your cards is not displayed");
//		}
//		
//		try {
//			if (forSomeOfTheMoreAdvancedSettings.isDisplayed())
//				utils.log().info("For More Advanced Settings is displayed ");
//		} catch (Exception e) {
//			utils.log().info("For More Advanced Settings is not displayed");
//		}
//		
//		try {
//			if (testMySpeedConnection.isDisplayed())
//				utils.log().info("Test My Connection Speed is displayed ");
//		} catch (Exception e) {
//			utils.log().info("Test My Connection Speed is not displayed");
//		}
//		
//		try {
//			if (internetAccessSpeed.isDisplayed())
//				utils.log().info("Internet Access Speed is displayed ");
//		} catch (Exception e) {
//			utils.log().info("Internet Access Speed is not displayed");
//		}
//		
//		try {
//			if (speedBetweenMobileDevices.isDisplayed())
//				utils.log().info("Internet Speed Between Mobile Devices is displayed ");
//		} catch (Exception e) {
//			utils.log().info("Internet Speed Between Mobile Devices is not displayed");
//		}
//	}

	@Override
	public boolean isAt() {
		if (NetworkSettingstitle.isDisplayed()) {
			utils.log().info("On Newtork Settings Help Page");
			return true;
		} else {
			utils.log().info("Not on Network Settings Help Page");
			return false;
		}
	}
}
