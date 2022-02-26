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

public class WhosHomeChangeMemberNameDialog extends ParentClass implements Page {
	public TestUtils utils = new TestUtils();

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"WH_AddHouseholdMemPopup_Screen_TitleLabel\"]")
	public MobileElement changeMemberNameTitle;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"WH_AddHouseholdMemPopup_Screen_Label_Member\"]")
	public MobileElement memberLabel;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name=\"WH_AddHouseholdMemPopup_Screen_TextField_Member\"]")
	public MobileElement enterMemberNameTextBox;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"WH_AddHouseholdMemPopup_Screen_Button_Continue\"]")
	public MobileElement updateButton;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"WH_AddHouseholdMemPopup_Screen_Button_Close\"]")
	public MobileElement closeButton;
	
	//Profile with this name exists. Please enter another name.
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"Error_Alert_Screen_Image_Close\"]")
	public MobileElement closeIcon;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Error_Alert_Screen_SubTitleLabel\"]")
	public MobileElement memberNameExists;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Error_Alert_Screen_Button\"]")
	public MobileElement okButton;
	
	public WhosHomeChangeMemberNameDialog() {
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}

	public boolean clickUpdateButton() {
		if (updateButton.isDisplayed()) {
			click(updateButton);
			utils.log().info("Clicked on Update Button");
			return true;
		} else {
			utils.log().info("Update Button is not displayed");
			return false;
		}
	}
	
	public boolean clickCloseButton() {
		if (closeButton.isDisplayed()) {
			click(closeButton);
			utils.log().info("Clicked on Close Button");
			return true;
		} else {
			utils.log().info("Close Button is not displayed");
			return false;
		}
	}
	
	public boolean clickCloseIcon() {
		if (closeIcon.isDisplayed()) {
			click(closeIcon);
			utils.log().info("Clicked on Close Icon");
			return true;
		} else {
			utils.log().info("Close Icon is not displayed");
			return false;
		}
	}
	
	public boolean clickOKButton() {
		if (okButton.isDisplayed()) {
			click(okButton);
			utils.log().info("Clicked on OK Button");
			return true;
		} else {
			utils.log().info("OK Button is not displayed");
			return false;
		}
	}
	
	public boolean enterMemberName() {
		if (enterMemberNameTextBox.isDisplayed()) {
			clear(enterMemberNameTextBox);
			sendKeys(enterMemberNameTextBox, super.generateMemberName());
			utils.log().info("Entered member name : " + enterMemberNameTextBox.getText());
			return true;
		} else {
			utils.log().info("Househole member name text box is not displayed");
			return false;
		}
	}
	
	
	
	//Click Update button without chaning the member name.  Below dialod shoould appear.
	
	
	
	@Override
	public boolean isAt() {
		if (changeMemberNameTitle.isDisplayed()) {
			utils.log().info("On CHANGE NAME Dialog");
			return true;
		} else {
			utils.log().info("Not on CHANGE NAME Dialog");
			return false;
		}
	}
}
