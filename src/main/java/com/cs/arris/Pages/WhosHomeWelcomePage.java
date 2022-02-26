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

public class WhosHomeWelcomePage extends ParentClass implements Page {
	public TestUtils utils = new TestUtils();

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"WH_Welcome_Screen_TitleLabel\"]")
	public MobileElement whosHomeWelcomePageTitle;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"WH_Welcome_Screen_SubTitleLabel\"]")
	public MobileElement whosHomeWelcomePageSubTitle;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"WH_Welcome_Screen_Image\"]")
	public MobileElement image;

	//You just need to pick a dedicated mobile device for each household member to monitor their entry and exit.
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"WH_Welcome_Screen_Label_Info\"]")
	public MobileElement whosHomeInfo;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"WH_Welcome_Screen_Button_Add\"]")
	public MobileElement addMemberButton;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"WH_Welcome_Screen_Button_Back\"]")
	public MobileElement backButton;
	
	public WhosHomeWelcomePage() {
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}

	public WhosHomeAddHouseholdMemberDialog getAddMemberDialogObject() {
		WhosHomeAddHouseholdMemberDialog addMember = new WhosHomeAddHouseholdMemberDialog();
		return addMember;
	}
	
	public WhosHomePickADeviceDialog getPickADeviceDialogObject() {
		WhosHomePickADeviceDialog pickDevice = new WhosHomePickADeviceDialog();
		return pickDevice;
	}
	
	public WhosHomeMonitoringPage getHomeMonitoringPageObject() {
		WhosHomeMonitoringPage homeMonitoring = new WhosHomeMonitoringPage();
		return homeMonitoring;
	}

	
	public boolean clickBackButton() {
		if (backButton.isDisplayed()) {
			click(backButton);
			utils.log().info("Clicked on Back Button");
			return true;
		} else {
			utils.log().info("Back Button is not displayed");
			return false;
		}
	}

	public boolean clickAddMemeberButton() {
		if (addMemberButton.isDisplayed()) {
			click(addMemberButton);
			utils.log().info("Clicked on Add Household Member Button");
			return true;
		} else {
			utils.log().info("Add Household Member button is not displayed");
			return false;
		}
	}

	public boolean verifyWhoseHomeWelcomePage() {
		utils.log().info("                                                ");
		utils.log().info("************************************************");
		utils.log().info("Details of UI Elements on Whos Home Welcome Page");
		utils.log().info("************************************************");
		try {
			try {
				if (whosHomeWelcomePageTitle.isDisplayed())
					utils.log().info(whosHomeWelcomePageTitle.getText() + " text is displayed");
			} catch (Exception e) {
				utils.log().info("Welcome to Who’s Home Text is not displayed");
			}

			try {
				if (whosHomeWelcomePageSubTitle.isDisplayed())
					utils.log().info(whosHomeWelcomePageSubTitle.getText() + " title is displayed");
			} catch (Exception e) {
				utils.log().info("Find out who’s home and who’s not sub title is not displayed");
			}

			try {
				if (image.isDisplayed())
					utils.log().info("Who's home Image is displayed");	
			} catch (Exception e) {
				utils.log().info("Who's home Image is not displayed");
			}

			try {
				if (addMemberButton.isDisplayed())
					utils.log().info("Adding Household Member button is displayed");
			} catch (Exception e) {
				utils.log().info("Add Household Member button is not displayed");
			}

			try {
				if (backButton.isDisplayed())
					utils.log().info("BACK button is displayed");
			} catch (Exception e) {
				utils.log().info("BACK button is not displayed");
			}

			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean isAt() {
		if (whosHomeWelcomePageTitle.isDisplayed()) {
			utils.log().info("On Welcome to Who's Home Page");
			return true;
		} else {
			utils.log().info("Not on Welcome to Who's Home Page");
			return false;
		}
	}
}
