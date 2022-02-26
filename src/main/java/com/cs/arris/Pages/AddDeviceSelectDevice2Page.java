package com.cs.arris.Pages;

import org.apache.commons.lang3.time.StopWatch;
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

public class AddDeviceSelectDevice2Page extends ParentClass implements Page {
	public TestUtils utils = new TestUtils();

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Select_Your_Device_Screen_TitleLabel\"]")
	public MobileElement selectDeviceTitle;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"NavigationBar_Button_Back\"]")
	public MobileElement backIcon;

	@AndroidFindBy(id = "com.arris.sbcBeta:id/img_toolbar_remote_lca")
	public MobileElement cloudIcon;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"NavigationBar_Button_Help\"]")
	public MobileElement helpIcon;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"Select_Your_Device_CM_Selection_Screen_Image_Product[9]\"]")
	public MobileElement t25RoutersImage;

	@iOSXCUITFindBy(xpath = "///XCUIElementTypeImage[@name=\"Select_Your_Device_CM_Selection_Screen_Image_Box[9]\"]")
	public MobileElement t25RadioButton;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Select_Your_Device_Screen_Button\"]")
	public MobileElement nextButton;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Select_Your_Device_Screen_Label_Note\"]")
	public MobileElement productSelectionDescription;

	@iOSXCUITFindBy(xpath = "///XCUIElementTypeStaticText[@name=\"App Store Link\"]")
	public MobileElement playStoreLink;

	public AddDeviceSelectDevice2Page() {
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

	public boolean selectT25RadioButton() {
		super.swipeUp();
		String selector = "**/XCUIElementTypeImage[`name == \"Select_Your_Device_CM_Selection_Screen_Image_Box[9]\"`]";
		super.getDriver().findElement(MobileBy.iOSClassChain(selector)).click();
		return true;
	
//		if (t25RadioButton.isDisplayed()) {
//			click(t25RadioButton);
//			utils.log().info("Clicked on T25 Radio Button");
//			return true;
//		} else {
//			utils.log().info("T25 Radio Button is not displayed");
//			return false;
//		}
	}

	public boolean clickNextButton() {
		if (nextButton.isEnabled()) {
			click(nextButton);
			utils.log().info("Clicked on Next Button");
			return true;
		} else {
			utils.log().info("Next Button is not displayed");
			this.selectT25RadioButton();
			return false;
		}
	}

	public boolean clickPlayStoreLink() {
		if (playStoreLink.isDisplayed()) {
			click(playStoreLink);
			utils.log().info("Clicked on PlayStore Link Text");
			return true;
		} else {
			utils.log().info("PlayStore Link Text is not displayed");
			return false;
		}
	}

	public boolean verifySelectYourDevice2UI() {
		try {
			if (selectDeviceTitle.isDisplayed())
				utils.log().info(selectDeviceTitle.getText() + " text is displayed");
			else
				utils.log().info("Select Your Device Text is not displayed");

			if (backIcon.isDisplayed())
				utils.log().info("Back button is displayed");
			else
				utils.log().info("Back button is not displayed");

			if (helpIcon.isDisplayed())
				utils.log().info("Help icon is displayed");
			else
				utils.log().info("Help icon is not displayed");

			if (t25RoutersImage.isDisplayed())
				utils.log().info("T25 Router Image is displayed");
			else
				utils.log().info("T25 Router Image is not displayed");

			if (t25RadioButton.isDisplayed())
				utils.log().info("T25 Radio button is displayed");
			else
				utils.log().info("T25 Radio button is not displayed");

			if (productSelectionDescription.isDisplayed())
				utils.log().info(productSelectionDescription.getText() + " text is displayed");
			else
				utils.log().info("Product Selection text is not displayed");

			if (playStoreLink.isDisplayed())
				utils.log().info(playStoreLink.getText() + " text is displayed");
			else
				utils.log().info("Play Store Link text is not displayed");

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
		if (selectDeviceTitle.isDisplayed()) {
			utils.log().info("On Add Device - Select You Device Below 2 Page");
			return true;
		} else {
			utils.log().info("Not on  Add Device - Select You Device Below 2 Page");
			return false;
		}
	}
}
