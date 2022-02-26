package com.cs.arris.Pages;

import org.openqa.selenium.support.PageFactory;

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

public class NetworkTimeZoneSettingsPage extends ParentClass implements Page {
	public TestUtils utils = new TestUtils();

	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Timezone Settings\"]")
	public MobileElement timeZoneTitle;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeOther[@name=\"NavigationBar_Button_Back\"]")
	public MobileElement backIcon;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeOther[@name=\"NavigationBar_Button_Help\"]")
	public MobileElement helpIcon;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Network_TimeZone_Settings_Screen_Label_Time[1]\"]")
	public MobileElement midwayIslandLabel;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeImage[@name=\"Network_TimeZone_Settings_Screen_Label_Image1]\"]")
	public MobileElement midwayIslandCheckBox;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Network_TimeZone_Settings_Screen_Label_Time[2]\"]")
	public MobileElement hawaiiLabel;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeImage[@name=\"Network_TimeZone_Settings_Screen_Label_Image2]\"]")
	public MobileElement hawaiiCheckBox;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Network_TimeZone_Settings_Screen_Label_Time[3]\"]")
	public MobileElement alaskaLabel;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeImage[@name=\"Network_TimeZone_Settings_Screen_Label_Image3]\"]")
	public MobileElement alaskaCheckBox;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Network_TimeZone_Settings_Screen_Label_Time[4]\"]")
	public MobileElement pacificLabel;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeImage[@name=\"Network_TimeZone_Settings_Screen_Label_Image4]\"]")
	public MobileElement pacificCheckBox;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Network_TimeZone_Settings_Screen_Label_Time[5]\"]")
	public MobileElement mountainTimeLabel;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeImage[@name=\"Network_TimeZone_Settings_Screen_Label_Image5]\"]")
	public MobileElement mountainTimeCheckBox;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Network_TimeZone_Settings_Screen_Label_Time[6]\"]")
	public MobileElement centralTimeLabel;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeImage[@name=\"Network_TimeZone_Settings_Screen_Label_Image6]\"]")
	public MobileElement centralTimeCheckBox;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Network_TimeZone_Settings_Screen_Label_Time[7]\"]")
	public MobileElement easternTimeLabel;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeImage[@name=\"Network_TimeZone_Settings_Screen_Label_Image7]\"]")
	public MobileElement easternTimeCheckBox;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Network_TimeZone_Settings_Screen_Label_Time[8]\"]")
	public MobileElement atlanticLabel;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeImage[@name=\"Network_TimeZone_Settings_Screen_Label_Image8]\"]")
	public MobileElement atlanticCheckBox;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Network_TimeZone_Settings_Screen_Button\"]")
	public MobileElement saveButton;

	public NetworkTimeZoneSettingsPage() {
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}

	public HomePage getHomePageObject() {
		HomePage homePage = new HomePage();
		return homePage;
	}

	public FooterIconsPage getFooterIconsPageObject() {
		FooterIconsPage footerIconsPage = new FooterIconsPage();
		return footerIconsPage;
	}

	public NetworkWANSettingsPage getWANSettingsPageObject() {
		NetworkWANSettingsPage wanSettings = new NetworkWANSettingsPage();
		return wanSettings;
	}

	public NetworkTimeZoneSettingsHelpPage getTimeZoneHelpPageObject() {
		NetworkTimeZoneSettingsHelpPage timeZoneSettings = new NetworkTimeZoneSettingsHelpPage();
		return timeZoneSettings;

	}

	public boolean clickBackButton() {
		if (backIcon.isDisplayed()) {
			click(backIcon);
			utils.log().info("Clicked on Back Button");
			return true;
		} else {
			utils.log().info("Back Button is not displayed");
			return false;
		}
	}

	public boolean clickHelpButton() {
		if (helpIcon.isDisplayed()) {
			click(helpIcon);
			return true;
		} else {
			utils.log().info("Help button is not displayed");
			return false;
		}
	}

	public boolean clickSaveButton() {
		if (saveButton.isDisplayed()) {
			click(saveButton);
			utils.log().info("Clicked on Save button");
			return true;
		} else {
			utils.log().info("Save button is not displayed");
			return false;
		}
	}

	public boolean clickMidwayTimeZone() {
		if (midwayIslandLabel.isDisplayed() && midwayIslandCheckBox.isDisplayed()) {
			click(midwayIslandCheckBox);
			return true;
		} else {
			utils.log().info("Midway Island, Samoa (GMT-11:00) checkbox is not displayed");
			return false;
		}
	}

	public boolean clickHawaiiTimeZone() {
		if (hawaiiLabel.isDisplayed() && hawaiiCheckBox.isDisplayed()) {
			click(hawaiiCheckBox);
			return true;
		} else {
			utils.log().info("Hawaii (GMT-10:00) checkbox is not displayed");
			return false;
		}
	}

	public boolean clickHAlaskaTimeZone() {
		if (alaskaLabel.isDisplayed() && alaskaCheckBox.isDisplayed()) {
			click(alaskaCheckBox);
			return true;
		}else {
			utils.log().info("Alaska (GMT-09:00) checkbox is not displayed");
			return false;
		}
	}

	public boolean clickPacificiTimeZone() {
		if (pacificLabel.isDisplayed() && pacificCheckBox.isDisplayed()) {
			click(pacificCheckBox);
			return true;
		} else {
			utils.log().info("Pacific Time, Tijuana (GMT-08:00) checkbox is not displayed");
			return false;
		}
	}

	public boolean clickMoutainTimeZone() {
		if (mountainTimeLabel.isDisplayed() && mountainTimeCheckBox.isDisplayed()) {
			click(hawaiiCheckBox);
			return true;
		} else {
			utils.log().info("Mountain Time (GMT-07:00) checkbox is not displayed");
			return false;
		}
	}

	public boolean clickCentralTimeZone() {
		if (centralTimeLabel.isDisplayed() && centralTimeCheckBox.isDisplayed()) {
			click(centralTimeCheckBox);
			return true;
		} else {
			utils.log().info("Central Time (GMT-06:00) checkbox is not displayed");
			return false;
		}
	}

	public boolean clickEasternTimeZone() {
		if (easternTimeLabel.isDisplayed() && easternTimeCheckBox.isDisplayed()) {
			click(easternTimeCheckBox);
			return true;
		} else {
			utils.log().info("Eastern Time (GMT-05:00) checkbox is not displayed");
			return false;
		}
	}

	public boolean clickAtlanticTimeZone() {
		if (atlanticLabel.isDisplayed() && atlanticCheckBox.isDisplayed()) {
			click(atlanticCheckBox);
			return true;
		} else {
			utils.log().info("Atlantic Time (GMT-04:00) checkbox is not displayed");
			return false;
		}
	}

	public boolean verifyUIOnTimeZonePage() {
		utils.log().info("                                           ");
		utils.log().info("*******************************************");
		utils.log().info("Verifying UI Elements on TimeZone Settings ");
		utils.log().info("*******************************************");
		try {
			if (timeZoneTitle.isDisplayed())
				utils.log().info(timeZoneTitle.getText() + " title text is displayed ");

			if (backIcon.isDisplayed())
				utils.log().info("Back Icon is displayed ");

			if (helpIcon.isDisplayed())
				utils.log().info("Help Icon is displayed");

			if (midwayIslandLabel.isDisplayed())
				utils.log().info("Midway Island, Samoa (GMT-11:00) option is displayed");

			if (midwayIslandCheckBox.isDisplayed())
				utils.log().info("Midway Island, Samoa (GMT-11:00) checkbox is displayed");

			if (hawaiiLabel.isDisplayed())
				utils.log().info("Hawaii (GMT-10:00) option is displayed");

			if (hawaiiCheckBox.isDisplayed())
				utils.log().info("Hawaii (GMT-10:00) checkbox is displayed");

			if (alaskaLabel.isDisplayed())
				utils.log().info("Alaska (GMT-09:00) option is displayed");

			if (alaskaCheckBox.isDisplayed())
				utils.log().info("Alaska (GMT-09:00) checkbox is displayed");

			if (pacificLabel.isDisplayed())
				utils.log().info("Pacific Time, Tijuana (GMT-08:00) option is displayed");

			if (pacificCheckBox.isDisplayed())
				utils.log().info("Pacific Time, Tijuana (GMT-08:00) checkbox is displayed");

			if (mountainTimeLabel.isDisplayed())
				utils.log().info("Mountain Time (GMT-07:00) option is displayed");

			if (mountainTimeCheckBox.isDisplayed())
				utils.log().info("Mountain Time (GMT-07:00) checkbox is displayed");

			if (centralTimeLabel.isDisplayed())
				utils.log().info("Central Time (GMT-06:00) option is displayed");
			
			super.swipeUp();

			if (centralTimeCheckBox.isDisplayed())
				utils.log().info("Central Time (GMT-06:00) checkbox is displayed");

			if (easternTimeLabel.isDisplayed())
				utils.log().info("Eastern Time (GMT-05:00) option is displayed");

			if (easternTimeCheckBox.isDisplayed())
				utils.log().info("Eastern Time (GMT-05:00) checkbox is displayed");

			if (atlanticLabel.isDisplayed())
				utils.log().info("Atlantic Time (GMT-04:00) option is displayed");

			if (atlanticCheckBox.isDisplayed())
				utils.log().info("Atlantic Time (GMT-04:00) checkbox is displayed");

			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean isAt() {
		if (timeZoneTitle.isDisplayed()) {
			utils.log().info("On Time Zone Settings Page");
			return true;
		} else {
			utils.log().info("Not on Time Zone Settings Page");
			return false;
		}
	}
}
