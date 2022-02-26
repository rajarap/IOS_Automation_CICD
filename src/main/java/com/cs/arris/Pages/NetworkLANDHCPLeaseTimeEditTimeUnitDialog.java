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

public class NetworkLANDHCPLeaseTimeEditTimeUnitDialog extends ParentClass implements Page {
	public TestUtils utils = new TestUtils();

	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Network_LAN_DHCP_LeaseTime_Screen_Label_Edit\"]")
	public MobileElement editTimeUnitTitle;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Network_LAN_DHCP_LeaseTime_Screen_Button_Close\"]")
	public MobileElement closeIcon;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Network_LAN_DHCP_LeaseTime_Screen_Button_Radio[1]\"]")
	public MobileElement minutesRadioButton;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Network_LAN_DHCP_LeaseTime_Screen_Label_TimeLine[1]\"]")
	public MobileElement minutesLabel;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Network_LAN_DHCP_LeaseTime_Screen_Button_Radio[2]\"]")
	public MobileElement hourlyRadioButton;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Network_LAN_DHCP_LeaseTime_Screen_Label_TimeLine[2]\"]")
	public MobileElement hourlyLabel;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Network_LAN_DHCP_LeaseTime_Screen_Button_Radio[3]\"]")
	public MobileElement daysRadioButton;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Network_LAN_DHCP_LeaseTime_Screen_Label_TimeLine[3]\"]")
	public MobileElement daysLabel;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Network_LAN_DHCP_LeaseTime_Screen_Button_Radio[4]\"]")
	public MobileElement weeklyRadioButton;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Network_LAN_DHCP_LeaseTime_Screen_Label_TimeLine[4]\"]")
	public MobileElement weeklyLabel;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Network_LAN_DHCP_LeaseTime_Screen_Button_Radio[5]\"]")
	public MobileElement foreverRadioButton;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Network_LAN_DHCP_LeaseTime_Screen_Label_TimeLine[5]\"]")
	public MobileElement foreverLabel;

	public NetworkLANDHCPLeaseTimeEditTimeUnitDialog() {
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}

	public boolean clickCloseButton() {
		if (closeIcon.isDisplayed()) {
			click(closeIcon);
			utils.log().info("Clicked on Close Button");
			return true;
		} else {
			utils.log().info("Close Button is not displayed");
			return false;
		}
	}

	public boolean clickMinutesRadioButton() {
		if (minutesLabel.isDisplayed()) {
			click(minutesLabel);
			utils.log().info("Clicked on Minutes Radio Button");
			return true;
		} else {
			utils.log().info("Minutes Radio Button is not displayed");
			return false;
		}
	}

	public boolean clickHourlyRadioButton() {
		if (hourlyLabel.isDisplayed()) {
			click(hourlyLabel);
			utils.log().info("Clicked on Hourly Radio Button");
			return true;
		} else {
			utils.log().info("Hourly Radio Button is not displayed");
			return false;
		}
	}

	public boolean clickDaysRadioButton() {
		if (daysLabel.isDisplayed()) {
			click(daysLabel);
			utils.log().info("Clicked on Days Radio Button");
			return true;
		} else {
			utils.log().info("Days Radio Button is not displayed");
			return false;
		}
	}

	public boolean clickWeeklyRadioButton() {
		if (weeklyLabel.isDisplayed()) {
			click(weeklyLabel);
			utils.log().info("Clicked on Weekly Radio Button");
			return true;
		} else {
			utils.log().info("Weekly Radio Button is not displayed");
			return false;
		}
	}

	public boolean clickForeverRadioButton() {
		if (foreverLabel.isDisplayed()) {
			click(foreverLabel);
			utils.log().info("Clicked on Foever Radio Button");
			return true;
		} else {
			utils.log().info("Forever Radio Button is not displayed");
			return false;
		}
	}

	public boolean verifyUIOnLANEditLeaseTimePage() {
		utils.log().info("                                             ");
		utils.log().info("*********************************************");
		utils.log().info("Verifying UI Elements on LAN Lease Time Page ");
		utils.log().info("*********************************************");
		try
		{
			if (editTimeUnitTitle.isDisplayed())
				utils.log().info(editTimeUnitTitle.getText() + " title text is displayed ");
			else
				utils.log().info("LAN DHCP Lease Time text is not displayed");

			if (closeIcon.isDisplayed())
				utils.log().info("Close Icon is displayed ");
			else
				utils.log().info("Back Icon is not displayed");

			if (minutesRadioButton.isDisplayed())
				utils.log().info("Minutes Radio button is displayed");
			else
				utils.log().info("Help Icon is not displayed");
			
			if (minutesLabel.isDisplayed())
				utils.log().info("Minutes Label is displayed");
			else
				utils.log().info("Minutes Label is not displayed");
		
			if (hourlyRadioButton.isDisplayed())
				utils.log().info("Hourly Radio button is displayed");
			else
				utils.log().info("Set Lease Time label is displayed");
			
			if (hourlyLabel.isDisplayed())
				utils.log().info("Hourly Label is displayed");
			else
				utils.log().info("Hourly Label is not displayed");
			
			if (daysRadioButton.isDisplayed())
				utils.log().info("Days Radio button is displayed");
			else
				utils.log().info("Enter Lease Time TextBoxis not displayed");
			
			if (daysLabel.isDisplayed())
				utils.log().info("Days Label is displayed");
			else
				utils.log().info("Days Label is not displayed");
			
			if (weeklyRadioButton.isDisplayed())
				utils.log().info(" Weekly Radio button is displayed");
			else
				utils.log().info("Select Time Unit Label is not displayed");
			
			if (weeklyLabel.isDisplayed())
				utils.log().info("Weekly Label is displayed");
			else
				utils.log().info("Weekly Label is not displayed");
			
			if (foreverRadioButton.isDisplayed())
				utils.log().info("Forever Radion button is displayed");
			else
				utils.log().info("Button to select the time unit is not displayed");
			
			if (foreverLabel.isDisplayed())
				utils.log().info("Forever Label is displayed");
			else
				utils.log().info("Forever Label is not displayed");
			
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean isAt() {
		if (editTimeUnitTitle.isDisplayed()) {
			utils.log().info("On LAN DHCP Lease Edit Time Page");
			return true;
		} else {
			utils.log().info("Not on LAN DHCP Edit Lease Time Page");
			return false;
		}
	}
}
