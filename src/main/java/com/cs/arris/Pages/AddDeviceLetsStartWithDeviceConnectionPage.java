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

public class AddDeviceLetsStartWithDeviceConnectionPage extends ParentClass implements Page {
	public TestUtils utils = new TestUtils();

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Start_Device_Connection_Screen_TitleLabel_LetsStartWithDeviceConnection\"]")
	public MobileElement StartDeviceConnectionTitle;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"NavigationBar_Button_Back\"]")
	public MobileElement backIcon;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/img_toolbar_remote_lca")
	public MobileElement cloudIcon;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"NavigationBar_Button_Help\"]")
	public MobileElement helpIcon;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Start_Device_Connection_Screen_Label_Step1\"]")
	public MobileElement descriptionText1;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"2. Connect the coax cable behind the\"]")
	public MobileElement descriptionText2;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"device being installed \"]")
	public MobileElement descriptionText3;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Start_Device_Connection_Screen_Label_Step3\"]")
	public MobileElement descriptionText4;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Start_Device_Connection_Screen_Button_Next\"]")
	public MobileElement nextButton;

	public AddDeviceLetsStartWithDeviceConnectionPage() {
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
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

	public boolean clickNextButton() {
		if (nextButton.isDisplayed()) {
			click(nextButton);
			utils.log().info("Clicked Next Button on Let's Start With Device Connection");
			return true;
		} else {
			utils.log().info("Next Button is not displayed");
			return false;
		}
	}

	public boolean verifyStartDeviceConnectionUI() {
		try {
			if (StartDeviceConnectionTitle.isDisplayed())
				utils.log().info(StartDeviceConnectionTitle.getText() + " text is displayed");
			else
				utils.log().info("Steps For Activation Text is not displayed");
			if (backIcon.isDisplayed())
				utils.log().info("Back button is displayed");
			else
				utils.log().info("Back button is not displayed");

			if (helpIcon.isDisplayed())
				utils.log().info("Help icon is displayed");
			else
				utils.log().info("Help icon is not displayed");

			if (descriptionText1.isDisplayed())
				utils.log().info(descriptionText1.getText() + " text is displayed");
			else
				utils.log().info("Remove your existing modem/gateway Text is not displayed");

			if (descriptionText2.isDisplayed())
				utils.log().info(descriptionText2.getText() + " text is displayed");
			else
				utils.log().info("Connect the coax cable behind the Text is not displayed");

			if (descriptionText3.isDisplayed())
				utils.log().info(descriptionText3.getText() + " text is displayed");
			else
				utils.log().info("device being installed Text is not displayed");

			if (descriptionText4.isDisplayed())
				utils.log().info(descriptionText4.getText() + " text is displayed");
			else
				utils.log().info("Plug in and power up your device Text is not displayed");

			if (nextButton.isDisplayed())
				utils.log().info(nextButton.getText() + " button is displayed");
			else
				utils.log().info("NEXT button is not displayed");

			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean isAt() {
		if (StartDeviceConnectionTitle.isDisplayed()) {
			utils.log().info("On Add Device - Let's Start With Device Connection Page");
			return true;
		} else {
			utils.log().info("Not on Add Device - Let's Start With Device Connection Page");
			return false;
		}
	}
}
