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

public class AddDeviceHomePageDeviceDetailsPage extends ParentClass implements Page {
	public TestUtils utils = new TestUtils();

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"NavigationBar_Title\"]")
	public MobileElement deviceDetailsTitle;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"NavigationBar_Button\"]")
	public MobileElement closeButton;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Modem_Device_Detail_Screen_TitleLabel\"]")
	public MobileElement deviceDetailsText;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Modem_Device_Detail_Screen_Label_Title[1]\"]")
	public MobileElement productNumber;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Modem_Device_Detail_Screen_Label_Detail[1]\"]")
	public MobileElement productDetails;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Modem_Device_Detail_Screen_Label_Title[2]\"]")
	public MobileElement serviceProviderText;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Modem_Device_Detail_Screen_Label_Detail[2]\"]")
	public MobileElement serviceProviderName;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Modem_Device_Detail_Screen_Label_Title[3]\"]")
	public MobileElement hardwareSpecText;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Modem_Device_Detail_Screen_Label_Detail[3]\"]")
	public MobileElement hardwareSpecDetails;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Modem_Device_Detail_Screen_Label_Title[4]\"]")
	public MobileElement ethernetPortText;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Modem_Device_Detail_Screen_Label_Detail[4]\"]")
	public MobileElement ethernetPortDetails;

	public AddDeviceHomePageDeviceDetailsPage() {
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}
	
	 public boolean clickCloseButton() {
		 if (closeButton.isDisplayed()) {
			click(closeButton);
			utils.log().info("Clicked on Close Button");
			return true;
		} else {
			utils.log().info("Close button is not displayed");
			return false;
		}
	}

	public boolean verifyDeviceDetailsUI() {
		try {
			try {
				if (deviceDetailsTitle.isDisplayed())
					utils.log().info(deviceDetailsTitle.getText() + " text is displayed");
			} catch (Exception e) {
				utils.log().info("Device Details Text is not displayed");
			}

			try {
				if (deviceDetailsText.isDisplayed())
					utils.log().info(deviceDetailsText.getText() + " text is displayed");
			} catch (Exception e) {
				utils.log().info("Devide Details Text is not displayed");
			}

			try {
				if (closeButton.isDisplayed())
					utils.log().info("Cloe button is displayed");
			} catch (Exception e) {
				utils.log().info("Close button is not displayed");
			}

			try {
				if (productNumber.isDisplayed())
					utils.log().info(productNumber.getText() + " text is displayed");
			} catch (Exception e) {
				utils.log().info("Product Model No. text is not displayed");
			}

			try {
				if (productDetails.isDisplayed())
					utils.log().info(productDetails.getText() + " text is displayed");
			} catch (Exception e) {
				utils.log().info("Product Details is not displayed");
			}

			try {
				if (serviceProviderText.isDisplayed())
					utils.log().info(serviceProviderText.getText() + " text is displayed");
			} catch (Exception e) {
				utils.log().info("Service Provider text is not displayed");
			}

			try {
				if (serviceProviderName.isDisplayed())
					utils.log().info(serviceProviderName.getText() + " text is displayed");
			} catch (Exception e) {
				utils.log().info("Service Provider Name text is not displayed");
			}

			try {
				if (hardwareSpecText.isDisplayed())
					utils.log().info(hardwareSpecText.getText() + " text is displayed");
			} catch (Exception e) {
				utils.log().info("Hardware Spec text is not displayed");
			}

			try {
				if (hardwareSpecDetails.isDisplayed())
					utils.log().info(hardwareSpecDetails.getText() + " text is displayed");
			} catch (Exception e) {
				utils.log().info("Hardware Spec Name is not displayed");
			}

			try {
				if (ethernetPortText.isDisplayed())
					utils.log().info(ethernetPortText.getText() + " text is displayed");
			} catch (Exception e) {
				utils.log().info("Ethernet Port text is not displayed");
			}

			try {
				if (ethernetPortDetails.isDisplayed())
					utils.log().info(ethernetPortDetails.getText() + " text is displayed");
			} catch (Exception e) {
				utils.log().info("Ethernet Port Number is not displayed");
			}

			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean isAt() {
		if (deviceDetailsTitle.isDisplayed()) {
			utils.log().info("On Add Device - Device Details Page");
			return true;
		} else {
			utils.log().info("Not on Add Device - Device Details Page");
			return false;
		}
	}
}
