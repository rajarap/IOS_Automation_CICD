package com.cs.arris.Pages;

import org.openqa.selenium.support.PageFactory;

import com.cs.arris.Base.ParentClass;
import com.cs.arris.Interface.Page;
import com.cs.arris.Utilities.TestUtils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class AddSatelliteConnectedToNonMaxNetworkTroubleShootProceedPage extends ParentClass implements Page {
	public TestUtils utils = new TestUtils();
	

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Troubleshoot_Screen_TitleLabel\"]")
	public MobileElement connectedToNonMaxNetworkTroubleShootTitle;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Troubleshoot_Screen_Button_Proceed\"]")
	public MobileElement proceedButton;


	public AddSatelliteConnectedToNonMaxNetworkTroubleShootProceedPage() {
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}

	public boolean clickProceedButton() {
		if (proceedButton.isDisplayed()) {
			click(proceedButton);
			utils.log().info("Clicked on Proceed Button");
			return true;
		} else {
			utils.log().info("Proceed Button is not displayed");
			return false;
		}
	}
	
	@Override
	public boolean isAt() {
		if (connectedToNonMaxNetworkTroubleShootTitle.isDisplayed()) {
			utils.log().info("On Connected to non mAX network - TroubleShoot Page");
			return true;
		} else {
			utils.log().info("Not on Connected to non mAX network - TroubleShoot Page");
			return false;
		}
	}
}
