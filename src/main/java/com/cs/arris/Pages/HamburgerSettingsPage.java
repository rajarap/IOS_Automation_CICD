package com.cs.arris.Pages;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
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
import io.github.bonigarcia.wdm.WebDriverManager;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.nativekey.KeyEventFlag;
import io.appium.java_client.android.nativekey.PressesKey;

public class HamburgerSettingsPage extends ParentClass implements Page {
	public TestUtils utils = new TestUtils();
	public WebDriver driver;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Settings\"]")
	public MobileElement settingsTitle;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"NavigationBar_Button_Back\"]")
	public MobileElement backButton;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"NavigationBar_Button_Help\"]")
	public MobileElement helpIcon;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Settings_Screen_TitleLabel\"]")
	public MobileElement accountSettingsTitle;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Settings_Screen_Label_Name\"]")
	public MobileElement nameLabel;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Settings_Screen_Label_UserName\"]")
	public MobileElement accountName;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"Settings_Screen_Image_User\"]")
	public MobileElement userImage;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Settings_Screen_Label_Email\"]")
	public MobileElement emailLabel;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Settings_Screen_Label_EmailId\"]")
	public MobileElement emailAddress;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"Settings_Screen_Image_Email\"]")
	public MobileElement emailImage;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Settings_Screen_Button\"]")
	public MobileElement signoutButton;


	public HamburgerSettingsPage() {
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}

	public AboutViewLicensesPage getLicensesPageObject() {
		AboutViewLicensesPage licensePage = new AboutViewLicensesPage();
		return licensePage;
	}

	public AboutHelpPage getAboutHelpPageObject() {
		AboutHelpPage aboutHelpPage = new AboutHelpPage();
		return aboutHelpPage;
	}

	public SettingsHelpPage getSettingsHelpPageObject() {
		SettingsHelpPage settingsHelpPage = new SettingsHelpPage();
		return settingsHelpPage;
	}

	public FAQHelpPage getFAQHelpPageObject() {
		FAQHelpPage faqHelpPage = new FAQHelpPage();
		return faqHelpPage;
	}
	
	public boolean clickHelpIcon() {
		if (helpIcon.isDisplayed()) {
			click(helpIcon);
			utils.log().info("Clicked on Help Button");
			return true;
		} else {
			return false;
		}
	}
	
	public boolean clickBackButton() {
		if (backButton.isDisplayed()) {
			click(backButton);
			utils.log().info("Clicked on Back Button");
			return true;
		} else {
			return false;
		}
	}

	public boolean clickSignOutButton() {
		if (signoutButton.isDisplayed()) {
			click(signoutButton);
			utils.log().info("Settings Page - Clicked on Sign Out button");
			return true;
		} else {
			return false;
		}
	}

	public boolean verifyUIOnSettingsPage() {
		utils.log().info("*********************************************************");
		utils.log().info("Details of UI Elements on the Hamburger - Settings Page  ");
		utils.log().info("*********************************************************");
		try {
			try {
				if (settingsTitle.isDisplayed())
					utils.log().info("Title " + settingsTitle.getText() + " is displayed");
			} catch (Exception e) {
				utils.log().info("Settings page title is not displayed");
			}

			try {
				if (accountSettingsTitle.isDisplayed())
					utils.log().info(accountSettingsTitle.getText() + " text is displayed");
			} catch (Exception e) {
				utils.log().info("Account Settings Text is not displayed");
			}

			try {
				if (nameLabel.isDisplayed())
					utils.log().info(nameLabel.getText() + " label is displayed");
			} catch (Exception e) {
				utils.log().info("Name Label is not displayed");
			}

			try {
				if (accountName.isDisplayed())
					utils.log().info("Users account firstname and lastname is displayed : " + accountName.getText());
			} catch (Exception e) {
				utils.log().info("Users account firstname and lastname is not displayed");
			}

			try {
				if (userImage.isDisplayed())
					utils.log().info("User Image is displayed");
			} catch (Exception e) {
				utils.log().info("User Image Label is not displayed");
			}

			try {
				if (emailImage.isDisplayed())
					utils.log().info("Email Address image is displayed");
			} catch (Exception e) {
				utils.log().info("Email Address image is not displayed");
			}

			try {
				if (emailLabel.isDisplayed())
					utils.log().info(emailLabel.getText() + " label is displayed");
			} catch (Exception e) {
				utils.log().info("Email Label is not displayed");
			}

			try {
				if (emailAddress.isDisplayed())
					utils.log().info("Email Address " + emailAddress.getText() + " is displayed");
			} catch (Exception e) {
				utils.log().info("Email Address is not displayed");
			}
			
			try {
				if (signoutButton.isDisplayed())
					utils.log().info("Sign Out button is displayed");
			} catch (Exception e) {
				utils.log().info("Sign Out button is not displayed");
			}

			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public String getUserEmailAddress() {
		return emailAddress.getText();
	}

	@Override
	public boolean isAt() {
		if (accountSettingsTitle.isDisplayed()) {
			utils.log().info("On Settings Page");
			return true;
		} else {
			utils.log().info("Not on Settings Page");
			return false;
		}
	}
}
