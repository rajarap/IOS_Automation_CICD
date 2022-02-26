package com.cs.arris.Pages;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.cs.arris.Base.ParentClass;
import com.cs.arris.Interface.Page;
import com.cs.arris.Utilities.TestUtils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class MainDeviceRestartRouterDialog extends ParentClass implements Page {
	public TestUtils utils = new TestUtils();

	@AndroidFindBy(id = "com.arris.sbcBeta:id/tvReboot") 
	public MobileElement restartRouterTitle;

	@AndroidFindBy(xpath = "//android.widget.TextView[@bounds='[164,1114][916,1277]']")
	public MobileElement restartMessage;
	
	@AndroidFindBy(id = "com.arris.sbcBeta:id/restartDevice") 
	public MobileElement restartRouterButton;
	
	@AndroidFindBy(id = "com.arris.sbcBeta:id/ivClose") 
	public MobileElement closeButton;

	
	public MainDeviceRestartRouterDialog() {
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}

	public boolean clickCloseButton() {
		if (closeButton.isDisplayed()) {
			click(closeButton); 
			utils.log().info("Clicked Close Button");
			return true;
		} else {
			return false;
		}
	}
	
	public boolean clickRestartButton() {
		if (restartRouterButton.isDisplayed()) {
			click(restartRouterButton); 
			utils.log().info("Clicked Restart Router Button");
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean isAt() {
		if (restartRouterTitle.isDisplayed()) {
			utils.log().info("On Restart Router Dialog");
			return true;
		} else {
			utils.log().info("Not on Restart Router Dialog");
			return false;
		}

	}

}
