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

public class AddDeviceSelectDevice1Page extends ParentClass implements Page {
	public TestUtils utils = new TestUtils();

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Select_Your_Device_Category_Screen_TitleLabel\"]")
	public MobileElement selectDeviceTitle;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"NavigationBar_Button_Back\"]")
	public MobileElement backIcon;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Add Device\"]")
	public MobileElement cloudIcon;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"NavigationBar_Button_Help\"]")
	public MobileElement helpIcon;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"Select_Your_Device_Category_Screen_Image\"]")
	public MobileElement bgRoutersImage;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Select_Your_Device_Category_Screen_Label_Detail[2]\"]")
	public MobileElement ispCableWithoutWiFiText;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"Select_Your_Device_Category_Screen_Image_Deselect[2]\"]")
	public MobileElement ispCableWithoutWiFiRadioButton;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Select_Your_Device_Category_Screen_Button\"]")
	public MobileElement nextButton;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Select_Your_Device_Category_Screen_Button_Help\"]")
	public MobileElement helpMeWithSelectionLink;

	// On click of help me with selection link

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Select_Your_Device_Category_Screen_Label_InfoHeader\"]")
	public MobileElement selectProductCategoryTitle;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Select_Your_Device_Category_Screen_Button_Hide\"]")
	public MobileElement cancelIcon;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Select_Your_Device_Category_Screen_Button_Ok\"]")
	public MobileElement okButton;

	// On click of help me with selection link

	public AddDeviceSelectDevice1Page() {
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

	public boolean selectISPCableRadioButton() {
		if (ispCableWithoutWiFiRadioButton.isDisplayed()) {
			click(ispCableWithoutWiFiRadioButton);
			utils.log().info("Clicked on ISP Cable Connected without Wi-Fi Radio Button");
			return true;
		} else {
			utils.log().info("ISP Cable Connected without Wi-Fi Radio Button is not displayed");
			return false;
		}
	}

	public boolean clickNextButton() {
		if (nextButton.isDisplayed()) {
			click(nextButton);
			super.pause(3);
			utils.log().info("Clicked on Next Button");
			return true;
		} else {
			utils.log().info("Next Button is not displayed");
			return false;
		}
	}

	public boolean clickHelpMeWithSelectionLink() {
		if (helpMeWithSelectionLink.isDisplayed()) {
			click(helpMeWithSelectionLink);
			utils.log().info("Clicked on Help Me With the Selection help text");
			return true;
		} else {
			utils.log().info("Help Me With the Selection help text is not displayed");
			return false;
		}
	}

	public boolean clickOKButton() {
		if (selectProductCategoryTitle.isDisplayed() && okButton.isDisplayed()) {
			click(okButton);
			utils.log().info("Clicked OK button on Selecting Product Category Help Dialog");
			return true;
		} else {
			utils.log().info("Selecting Product Category Help Dialog did not appear");
			return false;
		}
	}

	public boolean verifySelectYourDevice1UI() {
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

			if (bgRoutersImage.isDisplayed())
				utils.log().info("Background Router Image is displayed");
			else
				utils.log().info("Background Router Image is not displayed");

			if (ispCableWithoutWiFiText.isDisplayed())
				utils.log().info(ispCableWithoutWiFiText.getText() + " text is displayed");
			else
				utils.log().info("ISP Cable connected without Wi-Fi text is not displayed");

			if (ispCableWithoutWiFiRadioButton.isDisplayed())
				utils.log().info("ISP Cable connected without Wi-Fi Radio button is displayed");
			else
				utils.log().info("ISP Cable connected without Wi-Fi Radio button is not displayed");

			if (helpMeWithSelectionLink.isDisplayed())
				utils.log().info(helpMeWithSelectionLink.getText() + " text is displayed");
			else
				utils.log().info("Help Me With the Selection help text is not displayed");

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
			utils.log().info("On Add Device - Select You Device Below 1 Page");
			return true;
		} else {
			utils.log().info("Not on  Add Device - Select You Device Below 1 Page");
			return false;
		}
	}
}
