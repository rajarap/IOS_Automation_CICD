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

import io.appium.java_client.MobileBy;
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

public class AmazonFeaturesInformationPage extends ParentClass implements Page {
	public TestUtils utils = new TestUtils();
	public WebDriver driver;
 
	@iOSXCUITFindBy(iOSNsPredicate = "label == \"Amazon Features\" AND name == \"Amazon Features\" AND value == \"Amazon Features\"")
	public MobileElement amazonTitle;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"BOBA Arrow\"]")
	public MobileElement backButton;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"BOBAHelp\"]")
	public MobileElement helpIcon;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Amazon Features\"]")
	public MobileElement amazonFeaturesTab;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Alexa Skills\"]")
	public MobileElement alexaSkillsTab;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"Amazon_Features_Screen_Image\"]")
	public MobileElement affsImage;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Amazon_Features_Screen_Label_Get\"]")
	public MobileElement getAmazonFeaturesText;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Amazon_Features_Screen_Label_Step1\"]")	
	public MobileElement openAmazonAppText;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Amazon_Features_Screen_Label_Step2\"]")
	public MobileElement tapMenuSelectFeatureText;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"Amazon_Features_Screen_Image_Select\"]")
	public MobileElement enableAFFSCheckbox;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Amazon_Features_Screen_Label_Enable\"]")
	public MobileElement enableAFFSText;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Amazon_Features_Screen_Button_Continue\"]")
	public MobileElement continueButton;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Amazon_Features_Screen_Button_Dismiss\"]")
	public MobileElement dismissButton;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Error_Alert_Screen_TitleLabel\"]")
	public MobileElement amazonFeaturesUpdatedTitle;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Error_Alert_Screen_SubTitleLabel\"]")
	public MobileElement amazonFeaturesSuccessTitle;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Error_Alert_Screen_Button\"]")
	public MobileElement okButton;
	
	
	public AmazonFeaturesInformationPage() {
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}

	public AmazonWiFiSimpleSetupDialog getAmazonWifiSimpleSetupPageObject() {
		AmazonWiFiSimpleSetupDialog simpleSetupPage = new AmazonWiFiSimpleSetupDialog();
		return simpleSetupPage;
	}

	public AFFSHelpPage getAFFSHelpPageObject() {
		AFFSHelpPage affsHelpPage = new AFFSHelpPage();
		return affsHelpPage;
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
	
	public boolean selectAFFSCheckbox() {
		if (enableAFFSCheckbox.isSelected()) {
			utils.log().info("Amazon Frustration Free Setup Feature is already selected");
			return true;
		}else {
			click(enableAFFSCheckbox);
			utils.log().info("Amazon Frustration Free Setup Feature is selected");
			return false;
		}
	}
	
	public boolean disableAFFS() {
		if (!(enableAFFSCheckbox.isSelected())) {
			utils.log().info("Amazon Frustration Free Setup Feature is not selected");
			return true;
		} else {
			click(enableAFFSCheckbox);
			utils.log().info("Amazon Frustration Free Setup Feature is not selected");
			return false;
		}
	}
	
	public boolean clickContinueButton() {
		if (continueButton.isDisplayed()) {
			click(continueButton);
			utils.log().info("Clicked on Continue Button");
			return true;
		} else {
			return false;
		}
	}
	
	public boolean clickDismissButtonn() {
		if (dismissButton.isDisplayed()) {
			click(dismissButton);
			utils.log().info("Clicked on Dismiss Button Again");
			return true;
		} else {
			return false;
		}
	}
	
	public boolean clickOKButton() {
		if (okButton.isDisplayed()) {
			click(okButton);
			utils.log().info("Clicked on AFFS Feature Update Success OK Button");
			return true;
		} else {
			return false;
		}
	}

	public boolean verifyUIOnAFFSPage() {
		utils.log().info("****************************************************");
		utils.log().info("Details of UI Elements on the Amazon Features Page  ");
		utils.log().info("****************************************************");
		try {
			if (amazonTitle.isDisplayed())
				utils.log().info("Title " + amazonTitle.getText() + " is displayed");
			else
				utils.log().info("Amazon Feature title is not displayed");

			if (backButton.isDisplayed())
				utils.log().info("Back button is displayed");
			else
				utils.log().info("Back Button is not displayed");

			if (helpIcon.isDisplayed())
				utils.log().info("Help icon is displayed");
			else
				utils.log().info("Help icon is not displayed");

			if (amazonFeaturesTab.isDisplayed())
				utils.log().info("Amazon Feature Tab is displayed");
			else
				utils.log().info("Amazon Feature Tab is not displayed");
			
			if (alexaSkillsTab.isDisplayed())
				utils.log().info("Alexa Feature Tab is displayed");
			else
			utils.log().info("Alexa Feature Tab is not displayed");

			if (enableAFFSCheckbox.isDisplayed())
				utils.log().info("AFFS checkbox is displayed");
			else
				utils.log().info("AFFS checkbox is not displayed");

			if (enableAFFSText.isDisplayed())
				utils.log().info("Enable Frustation Free Setup text is displayed");
			else
				utils.log().info("Enable Frustation Free Setup text is not displayed");

			if (continueButton.isDisplayed())
				utils.log().info("Continue Button is displayed");
			else
				utils.log().info("Continue Button is not displayed");
			
			if (dismissButton.isDisplayed())
				utils.log().info("Dismiss Button icon is displayed");
			else
				utils.log().info("Dismiss Button icon is not displayed");

			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean isAt() {
		if (amazonTitle.isDisplayed()) {
			utils.log().info("On Amazon Features Information Page");
			return true;
		} else {
			utils.log().info("Not on Amazon Features Information Page");
			return false;
		}
	}
}
