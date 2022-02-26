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

public class WhosHomeAddHouseholdMemberDialog extends ParentClass implements Page {
	public TestUtils utils = new TestUtils();

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"WH_AddHouseholdMemPopup_Screen_TitleLabel\"]")
	public MobileElement addMemberTitle;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"WH_AddHouseholdMemPopup_Screen_View_PageIndicator\"]")
	public MobileElement pageIndicator;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"WH_AddHouseholdMemPopup_Screen_Label_Member\"]")
	public MobileElement houseHoldMemberLabel;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name=\"WH_AddHouseholdMemPopup_Screen_TextField_Member\"]")
	public MobileElement enterHouseHoldMemberNameTextBox;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"WH_AddHouseholdMemPopup_Screen_Button_Continue\"]")
	public MobileElement continueButton;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"WH_AddHouseholdMemPopup_Screen_Button_Close\"]")
	public MobileElement closeButton;
	
	public WhosHomeAddHouseholdMemberDialog() {
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}
	
	public boolean clickContinueButton() {
		if (continueButton.isDisplayed()) {
			click(continueButton);
			utils.log().info("Clicked on Continue Button");
			return true;
		} else {
			utils.log().info("Continue Button is not displayed");
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

	public boolean enterMemberName() {
		if (enterHouseHoldMemberNameTextBox.isDisplayed()) {
			sendKeys(enterHouseHoldMemberNameTextBox, super.generateMemberName());
			utils.log().info("Entered member name : " + enterHouseHoldMemberNameTextBox.getText());
			return true;
		} else {
			utils.log().info("Househole member name text box is not displayed");
			return false;
		}
	}

	public boolean verifyAddHouseHoldMemberDialogUI() {
		
		utils.log().info("                                         ");
		utils.log().info("*****************************************");
		utils.log().info("Details of UI Elements on Whos Home Page ");
		utils.log().info("*****************************************");
		try {
			try {
				if (addMemberTitle.isDisplayed())
					utils.log().info(addMemberTitle.getText() + " text is displayed");
			} catch (Exception e) {
				utils.log().info("ADD HOUSEHOLD MEMBER Text is not displayed");
			}

			try {
				if (pageIndicator.isDisplayed())
					utils.log().info("Page Indicator Image is displayed");
			} catch (Exception e) {
				utils.log().info("age Indicator  Image is not displayed");
			}
			
			try {
				if (houseHoldMemberLabel.isDisplayed())
					utils.log().info(houseHoldMemberLabel.getText() + " title is displayed");
			} catch (Exception e) {
				utils.log().info("Household Member Name label is not displayed");
			}

			try {
				if (enterHouseHoldMemberNameTextBox.isDisplayed())
					utils.log().info("Add Household memeber text box is displayed");
			} catch (Exception e) {
				utils.log().info("Add Household memeber text box is not displayed");
			}

			try {
				if (continueButton.isDisplayed())
					utils.log().info("Continue button is displayed");
			} catch (Exception e) {
				utils.log().info("Continue button is not displayed");
			}
			
			try {
				if (closeButton.isDisplayed())
					utils.log().info("Close button is displayed");
			} catch (Exception e) {
				utils.log().info("Close button is not displayed");
			}

			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean isAt() {
		if (addMemberTitle.isDisplayed()) {
			utils.log().info("On ADD HOUSEHOLD MEMBER Dialog");
			return true;
		} else {
			utils.log().info("Not on ADD HOUSEHOLD MEMBER Dialog");
			return false;
		}
	}
}
