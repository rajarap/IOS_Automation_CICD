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

public class AmazonFeaturesPage extends ParentClass implements Page {
	public TestUtils utils = new TestUtils();
	public WebDriver driver;
 
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Amazon Features\"]")
	public MobileElement amazonTitle;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"NavigationBar_Button_Back\"]")
	public MobileElement backButton;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"NavigationBar_Button_Help\"]")
	public MobileElement helpIcon;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"Amazon_Features_Screen_Image\"]")
	public MobileElement amazonSurfboardImage;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Amazon_Features_Screen_Label_Setup\"]")
	public MobileElement enableDisableAFFSText;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeSwitch[@name=\"Amazon_Features_Screen_Switch\"]")
	public MobileElement AFFSToggleButton;
	
//	@iOSXCUITFindBy(xpath = "//XCUIElementTypeSwitch[@name=\"Amazon_Features_Screen_Switch\"]")
//	public MobileElement AFFSToggleButtonDisabled;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Amazon_Features_Screen_Button\"]")	
	public MobileElement pleaseTapHere;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Amazon_Features_Screen_Button_Skills\"]")
	public MobileElement getAlexaSkillsButton;
	
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\" (1) Open the Amazon Alexa app.\"])[1]")
	public MobileElement alexaSkillsContent;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Amazon_Features_Screen_Label_Password\"]")
	public MobileElement passwordLabel;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeSecureTextField[@name=\"Amazon_Features_Screen_TextField_Password\"]")
	public MobileElement passwordTextBox;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Amazon_Features_Screen_Button_Eye\"]")
	public MobileElement showpassword;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Amazon_Features_Screen_Button_Copy\"]")
	public MobileElement passwordCopyButton;
		
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Amazon_Features_Screen_Button_Link\"]")
	public MobileElement alexaSkillsLink;
	
	
	//Password Copied Dialog
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Error_Alert_Screen_TitleLabel\"]")
	public MobileElement passwordCopiedText;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Error_Alert_Screen_Button\"]")
	public MobileElement okbutton;
	
		
	public AmazonFeaturesPage() {
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
	
	public boolean enableAFFS() {
		try {
			String str = super.getDriver().findElementByXPath("//XCUIElementTypeSwitch[@name=\"Amazon_Features_Screen_Switch\"]").getAttribute("value");
			int value = Integer.parseInt(str);
			if(value == 0)  //disabled
			{
				super.getDriver().findElementByXPath("//XCUIElementTypeSwitch[@name=\"Amazon_Features_Screen_Switch\"]").click();
				utils.log().info("Amazon Frustration Free Setup Feature is enabled");
			}else {
				utils.log().info("Amazon Frustration Free Setup Feature is already enabled");
			}
			return true;
		} catch(Exception e) {
			utils.log().info("");
			return true;
		}
	}
	
	public boolean disableAFFS() {
		try {
			String str = super.getDriver().findElementByXPath("//XCUIElementTypeSwitch[@name=\"Amazon_Features_Screen_Switch\"]").getAttribute("value");
			int value = Integer.parseInt(str);
			if(value == 1)  //enabled
			{
				//click(parentalControlToggleButton);  click to enable parental control switch button
				super.getDriver().findElementByXPath("//XCUIElementTypeSwitch[@name=\"Amazon_Features_Screen_Switch\"]").click();
				utils.log().info("Amazon Frustration Free Setup Feature is disabled.");
			}else {
				utils.log().info("Amazon Frustration Free Setup Feature is already disabled");
			}
			return true;
		} catch(Exception e) {
			utils.log().info("");
			return true;
		}
	}
	
	public boolean clickGetAlexaSkillsButton() {
		if (getAlexaSkillsButton.isDisplayed()) {
			click(getAlexaSkillsButton);
			utils.log().info("Clicked on Get Alexa Skills Button");
			return true;
		} else {
			return false;
		}
	}
	
	public boolean clickAlexaSkillsButtonAgain() {
		if (getAlexaSkillsButton.isDisplayed()) {
			super.swipeDown();
			click(getAlexaSkillsButton);
			utils.log().info("Clicked on Get Alexa Skills Button Again");
			return true;
		} else {
			return false;
		}
	}

	public boolean clickShowPasswordButton() {
		if (showpassword.isDisplayed()) {
			click(showpassword);
			utils.log().info("Clicked on Show Password Button");
			return true;
		} else {
			return false;
		}
	}
	
	public boolean clickShowPasswordButtonAgain() {
		if (showpassword.isDisplayed()) {
			click(showpassword);
			utils.log().info("Clicked on Show Password Button Again");
			return true;
		} else {
			return false;
		}
	}
	
	public boolean clickCopyPasswordButton() {
		if (passwordCopyButton.isDisplayed()) {
			click(passwordCopyButton);
			utils.log().info("Clicked on Copy Password Button");
			return true;
		} else {
			return false;
		}
	}
	
	public boolean getPasswordText() {
		if (passwordTextBox.isDisplayed()) {
			utils.log().info("Password is : " + passwordTextBox.getText());
			return true;
		} else {
			return false;
		}
	}
	
	public boolean clickCopyPasswordOKButton()
	{
		if(passwordCopiedText.isDisplayed())
		{
	//		utils.log().info(passwordCopiedText.getText());
			if (okbutton.isDisplayed()) {
				click(okbutton);
				utils.log().info("Clicked on Copy Password Ok button");
			}		
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
			try {
				if (amazonTitle.isDisplayed())
					utils.log().info("Title " + amazonTitle.getText() + " is displayed");
			} catch (Exception e) {
				utils.log().info("Amazon Feature title is not displayed");
			}

			try {
				if (backButton.isDisplayed())
					utils.log().info("Back button is displayed");
			} catch (Exception e) {
				utils.log().info("Back Button is not displayed");
			}

			try {
				if (helpIcon.isDisplayed())
					utils.log().info("Help icon is displayed");
			} catch (Exception e) {
				utils.log().info("Help icon is not displayed");
			}

			try {
				if (amazonSurfboardImage.isDisplayed())
					utils.log().info("Amazon Surfboard Image is displayed");
			} catch (Exception e) {
				utils.log().info("Amazon Surfboard Image is not displayed");
			}
			
			try {
				if (enableDisableAFFSText.isDisplayed())
					utils.log().info(enableDisableAFFSText.getText() + " text is displayed");
			} catch (Exception e) {
				utils.log().info("Enable/Disable AFFS text is not displayed");
			}
			
			try {
				if (AFFSToggleButton.isDisplayed())
					utils.log().info("AFFS Toggle button is displayed");
			}catch(Exception t) {
				utils.log().info("AFFS Toggle button is not displayed");
			}

//			if (pleaseTapHere.isDisplayed())
//				utils.log().info(pleaseTapHere.getText() + " is displayed");
//			else
//				utils.log().info("Please Tap Here text is not displayed");
//
//			if (getAlexaSkillsButton.isDisplayed())
//				utils.log().info(getAlexaSkillsButton.getText() + " is displayed");
//			else
//				utils.log().info("Get Alexa Skills text is not displayed");

			try {
				if (passwordLabel.isDisplayed())
					utils.log().info(passwordLabel.getText() + " label is displayed");
			} catch (Exception e) {
				utils.log().info("Password Label is not displayed");
			}

			try {
				if (passwordTextBox.isDisplayed())
					utils.log().info("Text box to enter password is displayed");
			} catch (Exception e) {
				utils.log().info("Text box to enter password is not displayed");
			}
			
			try {
				if (showpassword.isDisplayed())
					utils.log().info("Show password icon is displayed");
			} catch (Exception e) {
				utils.log().info("Show password icon is not displayed");
			}
			
			try {
				if (passwordCopyButton.isDisplayed())
					utils.log().info("Password copy button is displayed");
			} catch (Exception e) {
				utils.log().info("Password copy button is not displayed");
			}
			
			try {
				if (alexaSkillsLink.isDisplayed())
					utils.log().info("Alexa Skills link is displayed");
			} catch (Exception e) {
					utils.log().info("Alexa Skills link  is not displayed");
			}

			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean clickAlexaSkillsLink() {
		try {
			String selector = "**/XCUIElementTypeStaticText[`label == \"www.amazon.com/alexaskills\"`]";
			super.getDriver().findElement(MobileBy.iOSClassChain(selector)).click();
			super.pause(5);
			utils.log().info("Clicked on " + super.getDriver().findElement(MobileBy.iOSClassChain(selector)).getText() +  " link");	
			
			Set<String> allContext = super.getDriver().getContextHandles();
			for (String context : allContext) {
				if (context.contains("WEBVIEW"))
					super.getDriver().context(context);
			}
			utils.log().info("Switched to WEBVIEW");

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.navigate().to(alexaSkillsLink.getText());
			String webURL = driver.getCurrentUrl();
//			try {
//				if (webURL.equalsIgnoreCase(alexaSkillsLink.getText())) {
//					driver.getPageSource();
//					if (driver.findElement(By.xpath("//android.webkit.WebView[@text='Alexa Skills and Features | Amazon.com']")).isDisplayed())
//						utils.log().info("On www.amazon.com/alexaskills web page");
//					else
//						utils.log().info("www.amazon.com/alexaskills web page is not displayed");
//				}
//			} catch (Exception e) {
//				utils.log().info("Unable to fetch alexa skills Web Page objects");
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

	public boolean clickPleaseTapHereLink() {
		try {
			click(pleaseTapHere);
			super.pause(5);
			utils.log().info("Clicked on Please Tap Here Link");
						
			Set<String> allContext = super.getDriver().getContextHandles();
			for (String context : allContext) {
				if (context.contains("WEBVIEW"))
					super.getDriver().context(context);
			}
			utils.log().info("Switched to WEBVIEW");

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			String webURL = driver.getCurrentUrl(); 
//			try {
//				if (webURL.contains("amazon.com/gp/help/customer/")) {
////					driver.getPageSource();
//					if (driver
//							.findElement(By.xpath("//android.view.View[@content-desc='Where's My Stuff?'])[1]/android.view.View/android.widget.TextView[2]")).isDisplayed())
//						utils.log().info("On amazon.com/gp/help/customer web page");
//					else
//						utils.log().info("amazon.com/gp/help/customer web page is not displayed");
//				}
//			} catch (Exception e) {
//				utils.log().info("Unable to fetch amazon.com/gp/help/customer web page objects");
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
		if (amazonTitle.isDisplayed()) {
			utils.log().info("On Amazon Features Page");
			return true;
		} else {
			utils.log().info("Not on Amazon Features Page");
			return false;
		}
	}
}
