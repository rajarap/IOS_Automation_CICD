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

public class HamburgerHelpPage extends ParentClass implements Page {
	public TestUtils utils = new TestUtils();
	public WebDriver driver;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Help\"]")
	public MobileElement helpTitle;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"NavigationBar_Button_Back\"]")
	public MobileElement backButton;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"Help_Screen_Image_Icon\"]")
	public MobileElement surfboardLogoImage;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Help_Screen_Label_Help\"]")
	public MobileElement additionalHelpText;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Help_Screen_Label_HelpInfo\"]")
	public MobileElement helpMessage;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Help_Screen_Label_Option[1]\"]")
	public MobileElement faqButton;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Help_Screen_Label_Option[2]\"]")
	public MobileElement selfHelpButton;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Help_Screen_Label_Option[3]\"]")
	public MobileElement liveChatButton;


	public HamburgerHelpPage() {
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
	
	public boolean clickBackButton() {
		if (backButton.isDisplayed()) {
			click(backButton);
			utils.log().info("Clicked on Back Button");
			return true;
		} else {
			return false;
		}
	}

	public boolean clickFAQButton() {
		if (faqButton.isDisplayed()) {
			click(faqButton);
			utils.log().info("Help Page - Clicked on FAQ Button");
			return true;
		} else {
			return false;
		}
	}


	public boolean verifyUIOnHelpPage() {
		try {
			try {
				if (helpTitle.isDisplayed())
					utils.log().info("Title " + helpTitle.getText() + " is displayed");
			} catch (Exception e) {
					utils.log().info("Help page title is not displayed");
			}

			try {
				if (surfboardLogoImage.isDisplayed())
					utils.log().info("Surfboard Logo Image is displayed");
			} catch (Exception e) {
				utils.log().info("Surfboard Logo Image is not displayed");
			}

			try {
				if (additionalHelpText.isDisplayed())
					utils.log().info("Additional Help Text " + additionalHelpText.getText() + " is displayed");
			} catch (Exception e) {
				utils.log().info("Additional Help Text is not displayed");
			}

			try {
				if (helpMessage.isDisplayed())
					utils.log().info(helpMessage.getText() + " message is displayed");
			} catch (Exception e) {
				utils.log().info("Help Message Text is not displayed");
			}

			try {
				if (faqButton.isDisplayed())
					utils.log().info("Button " + faqButton.getText() + " is displayed");
			} catch (Exception e) {
				utils.log().info("FAQ Button is not displayed");
			}

			try {
				if (selfHelpButton.isDisplayed())
					utils.log().info(selfHelpButton.getText() + " is displayed");
			} catch (Exception e) {
				utils.log().info("SelfHelp URL is not displayed");
			}

			try {
				if (liveChatButton.isDisplayed())
					utils.log().info(liveChatButton.getText() + " is displayed");
			} catch (Exception e) {
				utils.log().info("Chat With Us button is not displayed");
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean clickSelfHelp() {
		try {
			click(selfHelpButton);
			super.pause(5);
			utils.log().info("Help Page - Clicked on Self Help button");

			Set<String> allContext = super.getDriver().getContextHandles();
			for (String context : allContext) {
				if (context.contains("WEBVIEW"))
					super.getDriver().context(context);
			}
			utils.log().info("Switched to WEBVIEW");

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			String webURL = driver.getCurrentUrl(); // arris.secure.force.com/consumers
			utils.log().info("About Page - Accessed web url: " + webURL);
//			try {
//				if (webURL.contains("arris.secure.force.com/consumers/")) {
//					driver.getPageSource();
//					driver.findElement(By.id("onetrust-close-btn-container")).click();
//					driver.findElement(By.id("closeButton")).click();
//					if (driver.findElement(By.xpath("//android.view.View[@content-desc='ARRIS Horizontal Logo']/android.widget.Image")).isDisplayed())
//						utils.log().info("On arris.secure.force.com/consumers web page");
//					else
//						utils.log().info("arris.secure.force.com/consumers web page is not displayed");
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

	public boolean clickLiveChatHelp() {
		try {
			click(selfHelpButton);
			super.pause(5);
			utils.log().info("Help Page - Clicked on Chat With Us button");

			Set<String> allContext = super.getDriver().getContextHandles();
			for (String context : allContext) {
				if (context.contains("WEBVIEW"))
					super.getDriver().context(context);
			}
			utils.log().info("Switched to WEBVIEW");

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			String webURL = driver.getCurrentUrl();
			utils.log().info("About Page - Accessed web url: " + webURL);
			// www5.nohold.net/Arris/ukp.aspx?pid=15&login=1&alt1=app&alt2=mAX+Pro+W31&model=mAX+Pro+W31&donelr=1
//			if (webURL.contains(
//					"www5.nohold.net/Arris/ukp.aspx?pid=15&login=1&alt1=app&alt2=mAX+Pro+W31&model=mAX+Pro+W31&donelr=1")) {
//				driver.getPageSource();
//				if (driver
//						.findElement(
//								By.xpath("//android.view.View[@content-desc='Change Product']/android.widget.TextView"))
//						.isDisplayed()
//						&& driver
//								.findElement(By
//										.xpath("//android.view.View[@content-desc='Feedback']/android.widget.TextView"))
//								.isDisplayed())
//					utils.log().info("On www5.nohold.net/Arris/ukp.aspx web page");
//				else
//					utils.log().info("www5.nohold.net/Arris/ukp.aspx web page is not displayed");
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
		if (helpTitle.isDisplayed()) {
			utils.log().info("On Help Page");
			return true;
		} else {
			utils.log().info("Not on Help Page");
			return false;
		}
	}
}
