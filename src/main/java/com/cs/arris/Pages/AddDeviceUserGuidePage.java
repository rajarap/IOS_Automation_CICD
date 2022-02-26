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

public class AddDeviceUserGuidePage extends ParentClass implements Page {
	public TestUtils utils = new TestUtils();

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"User_Guide_Screen_NavigationBarTitle\"]")
	public MobileElement userGuideTitle;

//	@AndroidFindBy(id = "com.arris.sbcBeta:id/ivBackButton")
//	public MobileElement backIcon;
	
	 public AddDeviceFooterIconsPage getAddDeviceFooterIconsPageObject() {
		 AddDeviceFooterIconsPage footerIconsPage = new AddDeviceFooterIconsPage();
	     return footerIconsPage;
	  }	

	public AddDeviceUserGuidePage() {
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}

//	public boolean clickBackButton() {
//		if (backIcon.isDisplayed()) {
//			click(backIcon);
//			utils.log().info("Clicked on Back Button");
//			return true;
//		} else {
//			utils.log().info("Back Button is not displayed");
//			return false;
//		}
//	}

	@Override
	public boolean isAt() {
		if (userGuideTitle.isDisplayed()) {
			utils.log().info("On Add Device - User Guide Page");
			return true;
		} else {
			utils.log().info("Not on Add Device - User Guide Page");
			return false;
		}
	}
}