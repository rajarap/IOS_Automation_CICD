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

public class HamburgerAboutPage extends ParentClass implements Page {
	public TestUtils utils = new TestUtils();
	public WebDriver driver;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"NavigationBar_Button_Back\"]")
	public MobileElement backButton;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"NavigationBar_Button_Help\"]")
	public MobileElement helpIcon;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"About\"]")
	public MobileElement aboutTitle;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"About_Screen_Image\"]")
	public MobileElement routerImage;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"About_Screen_Image_Icon\"]")
	public MobileElement surfboardImage;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"About_Screen_Label_Firmware\"]")
	public MobileElement firmwareVersionText;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"About_Screen_Label_Version\"]")
	public MobileElement appVersionText;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"About_Screen_Label_Model\"]")
	public MobileElement modelNameText;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"About_Screen_Button_Eula\"]")
	public MobileElement viewLicensesButton;

	// click to purchase new max Router
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"About_Screen_Button\"]")
	public MobileElement getAnotherMaxRouterButton;

	public HamburgerAboutPage() {
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

	public boolean clickLicenseButton() {
		if (viewLicensesButton.isDisplayed()) {
			click(viewLicensesButton);
			utils.log().info("About Page - Clicked on View License Button");
			return true;
		} else {
			return false;
		}
	}



	public boolean verifyUIOnAboutPage() {
		utils.log().info("******************************************************");
		utils.log().info("Details of UI Elements on the Hamburger - About Page  ");
		utils.log().info("******************************************************");
		try {
			try {
				if (aboutTitle.isDisplayed())
					utils.log().info("Title " + aboutTitle.getText() + " is displayed");
			} catch (Exception e) {
				utils.log().info("About page title is not displayed");
			}

			try {
				if (routerImage.isDisplayed())
					utils.log().info("Router Image is displayed");
			} catch (Exception e) {
				utils.log().info("Router Image is not displayed");
			}

			try {
				if (surfboardImage.isDisplayed())
					utils.log().info("Surfboard Image is displayed");
			} catch (Exception e) {
				utils.log().info("Surfboard Image is not displayed");
			}

			try {
				if (firmwareVersionText.isDisplayed())
					utils.log().info(firmwareVersionText.getText() + " is displayed");
			} catch (Exception e) {
				utils.log().info("Firmware Version is not displayed");
			}

			try {
				if (appVersionText.isDisplayed())
					utils.log().info(appVersionText.getText() + " is displayed");
			} catch (Exception e) {
				utils.log().info("App Version is not displayed");
			}

			try {
				if (modelNameText.isDisplayed())
					utils.log().info(modelNameText.getText() + " is displayed");
			} catch (Exception e) {
				utils.log().info("Model Name is not displayed");
			}
			
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean clickGetAnotherMaxRouterButton() {
		try {
			click(getAnotherMaxRouterButton);
			super.pause(5);
			utils.log().info("About Page - Clicked on Get Another Max Router button");

			Set<String> allContext = super.getDriver().getContextHandles();
			for (String context : allContext) {
				if (context.contains("WEBVIEW"))
					super.getDriver().context(context);
			}
			utils.log().info("Switched to WEBVIEW");

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			String webURL = driver.getCurrentUrl();// http://shop.surfboard.com
			utils.log().info("About Page - Accessed web url: " + webURL);
//			try {
//				if (webURL.equalsIgnoreCase("http://shop.surfboard.com")) {
//					driver.getPageSource();
//					if (driver.findElement(By.xpath("//XCUIElementTypeLink[@name=\" MORE\"]")).isDisplayed() && driver.findElement(By.xpath(
//											"//XCUIElementTypeLink[@name=\" SIGN IN\"]")).isDisplayed())
//						utils.log().info("On shop.surfboard.com web page");
//					else
//						utils.log().info("shop.surfboard.com web page is not displayed");
//				}
//			} catch (Exception e) {
//				utils.log().info("Unable to fetch Self Help Web Page objects");
//			}
			
			if (driver != null)
				driver.quit();
			
			super.getDriver().context("NATIVE_APP");
			utils.log().info("Switched to NATIVE_APP View");
			super.getDriver().activateApp("com.arris.sbcBeta");
			
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean isAt() {
		if (aboutTitle.isDisplayed()) {
			utils.log().info("On About Page");
			return true;
		} else {
			utils.log().info("Not on About Page");
			return false;
		}
	}
}
