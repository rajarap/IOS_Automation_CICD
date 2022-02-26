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

public class AddSatelliteAddNewSatellitePage4 extends ParentClass implements Page {
	public TestUtils utils = new TestUtils();
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"BOBAHelp\"]")
	public MobileElement helpIcon;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Add_New_BOBA_Satellite_Screen_TitleLabel\"]")
	public MobileElement addSatelliteTitle4;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Add_New_BOBA_Satellite_Screen_SubTitleLabel\"]")
	public MobileElement description;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Add_New_BOBA_Satellite_Screen_Button_Cancel\"]")
	public MobileElement cancelButton;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"BOBA Arrow\"]")
	public MobileElement backButton;

	public AddSatelliteAddNewSatellitePage4() {
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}

	public boolean clickCancelButton() {
		if (cancelButton.isDisplayed()) {
			click(cancelButton);
			utils.log().info("Clicked on Cancel Button");
			return true;
		} else {
			utils.log().info("Cancel Button is not displayed");
			return false;
		}
	}

	@Override
	public boolean isAt() {
		if (addSatelliteTitle4.isDisplayed()) {
			utils.log().info("On ADD NEW SATELLITE Page");
			return true;
		} else {
			utils.log().info("Not on ADD NEW SATELLITE Page");
			return false;
		}
	}
}
