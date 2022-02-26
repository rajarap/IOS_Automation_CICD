package com.cs.arris.Pages;

import java.util.List;

import org.apache.commons.lang3.time.StopWatch;
import org.openqa.selenium.support.PageFactory;

import com.cs.arris.Base.ParentClass;
import com.cs.arris.Interface.Page;
import com.cs.arris.Utilities.Direction;
import com.cs.arris.Utilities.TestUtils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class WhosHomeRemoveMemberDialog extends ParentClass implements Page {
	public TestUtils utils = new TestUtils();

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"WH_RemoveHouseholdMem_Screen_TitleLabel\"]")
	public MobileElement removeMemberTitle;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"WH_RemoveHouseholdMem_Screen_SubTitleLabel\"]")
	public MobileElement confirmationMessage;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"WH_RemoveHouseholdMem_Screen_Remove\"]")
	public MobileElement removeButton;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"WH_RemoveHouseholdMem_Screen_Button_Cancel\"]")
	public MobileElement cancelButton;
	
	public WhosHomeRemoveMemberDialog() {
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
		
	public boolean clickRemoveButton() {
		if (removeButton.isDisplayed()) {
			click(removeButton);
			utils.log().info("Clicked on Remove Button");
			return true;
		} else {
			utils.log().info("Remove Button is not displayed");
			return false;
		}
	}
	
	@Override
	public boolean isAt() {
		if (removeMemberTitle.isDisplayed()) {
			utils.log().info("On REMOVE MEMBER Dialog");
			return true;
		} else {
			utils.log().info("Not on REMOVE MEMBER Dialog");
			return false;
		}
	}
}
