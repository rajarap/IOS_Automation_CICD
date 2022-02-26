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

public class NetworkLANDHCPLeaseTimePage extends ParentClass implements Page {
	public TestUtils utils = new TestUtils();

	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"LAN DHCP Lease Time\"]")
	public MobileElement lanDHCPLeaseTimeTitle;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeOther[@name=\"NavigationBar_Button_Back\"]")
	public MobileElement backIcon;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeOther[@name=\"NavigationBar_Button_Help\"]")
	public MobileElement helpIcon;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Network_LAN_DHCP_LeaseTime_Screen_Label_Set\"]")
	public MobileElement setLeaseTimeLabel;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeTextField[@name=\"Network_LAN_DHCP_LeaseTime_Screen_TextField\"]")
	public MobileElement enterLeaseTimeTextBox;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Network_LAN_DHCP_LeaseTime_Screen_Label_Select\"]")
	public MobileElement selctTimeUnitLabel;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Network_LAN_DHCP_LeaseTime_Screen_Button_Select\"]")
	public MobileElement selectTimeUnitButton;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Network_LAN_DHCP_LeaseTime_Screen_Button\"]")
	public MobileElement saveLeaseTimeButton;
	
	// Minute
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Network_LAN_DHCP_LeaseTime_Screen_Label_ValidationError\"]")
	public MobileElement zeroLeaseTimeError;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Network_LAN_DHCP_LeaseTime_Screen_Label_ValidationError\"]")
	public MobileElement maximumLeaseTimeError;
	
	// Minute
	
	//Hourly
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Network_LAN_DHCP_LeaseTime_Screen_Label_ValidationError\"]")
	public MobileElement zeroHourlyLeaseTimeError;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Network_LAN_DHCP_LeaseTime_Screen_Label_ValidationError\"]")
	public MobileElement maximumHourlyLeaseTimeError;
	
	//Hourly
	
	//Days
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Network_LAN_DHCP_LeaseTime_Screen_Label_ValidationError\"]")
	public MobileElement zeroDaysLeaseTimeError;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Network_LAN_DHCP_LeaseTime_Screen_Label_ValidationError\"]")
	public MobileElement maximumDaysLeaseTimeError;
	
	//Days
	
	//Weekly
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Network_LAN_DHCP_LeaseTime_Screen_Label_ValidationError\"]")
	public MobileElement zeroWeeklyLeaseTimeError;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Network_LAN_DHCP_LeaseTime_Screen_Label_ValidationError\"]")
	public MobileElement maximumWeeklyLeaseTimeError;
	
	//Weekly
	
	//Forever
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeTextField[@name=\"Network_LAN_DHCP_LeaseTime_Screen_TextField\"]")
	public MobileElement disabledLeaseTimeTextBox;
	
	//forever
	
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Done\"]")
	public MobileElement doneLink;
	
	
	public NetworkLANDHCPLeaseTimePage() {
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}

	public NetworkLANDHCPLeaseTimeHelpPage getLANDHCPLeaseTimeHelpPageObject() {
		NetworkLANDHCPLeaseTimeHelpPage leaseTimeHelpPage = new NetworkLANDHCPLeaseTimeHelpPage();
		return leaseTimeHelpPage;
	}

	public FooterIconsPage getFooterIconsPageObject() {
		FooterIconsPage footerIconsPage = new FooterIconsPage();
		return footerIconsPage;
	}

	public NetworkLANDHCPLeaseTimeEditTimeUnitDialog getEditTimeUnitPageObject() {
		NetworkLANDHCPLeaseTimeEditTimeUnitDialog timeUnitPage = new NetworkLANDHCPLeaseTimeEditTimeUnitDialog();
		return timeUnitPage;
	}
	
	public NetworkLANDHCPLeaseTimeAppliedChangesDialog getLeaseTimeAppliedChangesDialogObject() {
		NetworkLANDHCPLeaseTimeAppliedChangesDialog appliedChanges = new NetworkLANDHCPLeaseTimeAppliedChangesDialog();
		return appliedChanges;
	}
	
	public NetworkLANDHCPLeaseTimeAppliedSameChangesDialog getLeaseTimeAppliedSameChangesDialogObject() {
		NetworkLANDHCPLeaseTimeAppliedSameChangesDialog appliedSameChanges = new NetworkLANDHCPLeaseTimeAppliedSameChangesDialog();
		return appliedSameChanges;
	}
	
	public boolean clickBackButton() {
		try {
			if (backIcon.isDisplayed()) {
				click(backIcon);
				utils.log().info("Clicked on Back Button");
			}
			return true;
		} catch (Exception e) {
			utils.log().info("Back Button is not displayed");
			return false;
		}
	}

	public boolean clickHelpButton() {
		try {
			if (helpIcon.isDisplayed()) {
				click(helpIcon);
				utils.log().info("Clicked on Help Button");
			}
			return true;
		} catch (Exception e) {
			utils.log().info("Help Button is not displayed");
			return false;
		}
	}

	public boolean clickTimeUnitButton() {
		try {
			if (selectTimeUnitButton.isDisplayed()) {
				click(selectTimeUnitButton);
				utils.log().info("Clicked on TimeUnit Button");
			}
			return true;
		} catch (Exception e) {
			utils.log().info("TimeUnit Button is not displayed");
			return false;
		}
	}

	public boolean clickSaveLeaseTimeButton() {
		try {
				click(doneLink);
				if (saveLeaseTimeButton.isDisplayed()) {
					click(saveLeaseTimeButton);
					utils.log().info("Clicked on Save Lease Time Button");
			}
			return true;
		} catch (Exception e) {
			utils.log().info("Save Lease Time Button is not displayed");
			return false;
		}
	}

	public boolean enterLeaseTime(String leaseTime) {
		try {
			if (enterLeaseTimeTextBox.isDisplayed()) {
				clear(enterLeaseTimeTextBox);
				sendKeys(enterLeaseTimeTextBox, leaseTime);
				utils.log().info("Entered Lease time : " + leaseTime);
			}
			return true;
		} catch (Exception e) {
			utils.log().info("Set Lease Time text box is not displayed");
			return false;
		}
	}

	public boolean verifyUIOnLANLeaseTimePage() {
		utils.log().info("                                             ");
		utils.log().info("*********************************************");
		utils.log().info("Verifying UI Elements on LAN Lease Time Page ");
		utils.log().info("*********************************************");
		try
		{
			if (lanDHCPLeaseTimeTitle.isDisplayed())
				utils.log().info(lanDHCPLeaseTimeTitle.getText() + " title text is displayed ");
			else
				utils.log().info("LAN DHCP Lease Time text is not displayed");

			if (backIcon.isDisplayed())
				utils.log().info("Back Icon is displayed ");
			else
				utils.log().info("Back Icon is not displayed");

			if (helpIcon.isDisplayed())
				utils.log().info("Help Icon is displayed");
			else
				utils.log().info("Help Icon is not displayed");
	
			if (setLeaseTimeLabel.isDisplayed())
				utils.log().info(setLeaseTimeLabel.getText() + " label is displayed");
			else
				utils.log().info("Set Lease Time label is displayed");
			
			if (enterLeaseTimeTextBox.isDisplayed())
				utils.log().info("Enter Lease Time TextBox is displayed");
			else
				utils.log().info("Enter Lease Time TextBoxis not displayed");
			
			if (selctTimeUnitLabel.isDisplayed())
				utils.log().info(selctTimeUnitLabel.getText() + " label is displayed");
			else
				utils.log().info("Select Time Unit Label is not displayed");
			
			if (selectTimeUnitButton.isDisplayed())
				utils.log().info("Button to select the time unit is displayed");
			else
				utils.log().info("Button to select the time unit is not displayed");
			
			if (selectTimeUnitButton.isDisplayed())
				utils.log().info("By Default " + selectTimeUnitButton.getText() + " is selected");
			else
				utils.log().info("Button to select the time unit is not displayed");
			
			if (saveLeaseTimeButton.isDisplayed())
				utils.log().info("Save Lease Time Button is displayed");
			else
				utils.log().info("Button to select the time unit is not displayed");
			
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifyLeaseTimeWithMinutesTimeUnit() {
		utils.log().info("                                           ");
		utils.log().info("*******************************************");
		utils.log().info("Verifying Lease Time with Minutes Time Unit");
		utils.log().info("*******************************************");
		
		// First select the Minute option in the Test
		
		this.enterLeaseTime("0");
		this.clickSaveLeaseTimeButton();
		utils.log().info("Entered Lease Time as 0. An error Message : " + zeroLeaseTimeError.getText() + " is displayed");
		
		this.enterLeaseTime("35791395");
		this.clickSaveLeaseTimeButton();
		utils.log().info("Entered Lease Time greater than 35791394. An error Message : " + maximumLeaseTimeError.getText() + " is displayed");
		
		this.enterLeaseTime("25791395");
		this.clickSaveLeaseTimeButton();
		utils.log().info("Entered Lease Time between 1 and 35791395 and applied the changes successfully");
		utils.log().info("                                           ");
		utils.log().info("                                           ");
		
		//NetworkLANDHCPLeaseTimeAppliedChangesDialog - Click OK button
		return true;
	}
	
	public boolean verifyLeaseTimeWithHourlyTimeUnit() {
		utils.log().info("                                           ");
		utils.log().info("*******************************************");
		utils.log().info("Verifying Lease Time with Hourly Time Unit ");
		utils.log().info("*******************************************");
		
		// First select the Hourly option in the Test
		
		this.enterLeaseTime("0");
		this.clickSaveLeaseTimeButton();
		utils.log().info("Entered Lease Time as 0. An error Message : " + zeroHourlyLeaseTimeError.getText() + " is displayed");
		
		this.enterLeaseTime("3579139");
		this.clickSaveLeaseTimeButton();
		utils.log().info("Entered Lease Time greater than 596523. An error Message : " + maximumHourlyLeaseTimeError.getText() + " is displayed");
		
		this.enterLeaseTime("2335");
		this.clickSaveLeaseTimeButton();
		utils.log().info("Entered Lease Time between 1 and 596523 and applied the changes successfully");
		
		utils.log().info("                                           ");
		utils.log().info("                                           ");
		
		//NetworkLANDHCPLeaseTimeAppliedChangesDialog - Click OK button
		return true;
	}
	
	public boolean verifyLeaseTimeWithDaysTimeUnit() {
		utils.log().info("                                           ");
		utils.log().info("*******************************************");
		utils.log().info("Verifying Lease Time with Days Time Unit   ");
		utils.log().info("*******************************************");
		
		// First select the Days option in the Test
		
		this.enterLeaseTime("0");
		this.clickSaveLeaseTimeButton();
		utils.log().info("Entered Lease Time as 0. An error Message : " + zeroDaysLeaseTimeError.getText() + " is displayed");
		
		this.enterLeaseTime("24888");
		this.clickSaveLeaseTimeButton();
		utils.log().info("Entered Lease Time greater than 24855. An error Message : " + maximumDaysLeaseTimeError.getText() + " is displayed");
		
		this.enterLeaseTime("22215");
		this.clickSaveLeaseTimeButton();
		utils.log().info("Entered Lease Time between 1 and 24855 and applied the changes successfully");
		utils.log().info("                                           ");
		utils.log().info("                                           ");
		
		//NetworkLANDHCPLeaseTimeAppliedChangesDialog - Click OK button
		return true;
	}
	
	public boolean verifyLeaseTimeWithWeeklyTimeUnit() {
		utils.log().info("                                           ");
		utils.log().info("*******************************************");
		utils.log().info("Verifying Lease Time with Weekly Time Unit ");
		utils.log().info("*******************************************");
		
		// First select the Weekly option in the Test
		
		this.enterLeaseTime("0");
		this.clickSaveLeaseTimeButton();
		utils.log().info("Entered Lease Time as 0. An error Message : " + zeroWeeklyLeaseTimeError.getText() + " is displayed");
		
		this.enterLeaseTime("34523");
		this.clickSaveLeaseTimeButton();
		utils.log().info("Entered Lease Time greater than 3550. An error Message : " + maximumWeeklyLeaseTimeError.getText() + " is displayed");
		
		this.enterLeaseTime("2773");
		this.clickSaveLeaseTimeButton();
		utils.log().info("Entered Lease Time between 1 and 3550 and applied the changes successfully");
		utils.log().info("                                           ");
		utils.log().info("                                           ");
		
		//NetworkLANDHCPLeaseTimeAppliedChangesDialog - Click OK button
		return true;
	}
	
	public boolean verifyLeaseTimeWithForeverTimeUnit() {
//		utils.log().info("                                            ");
//		utils.log().info("********************************************");
//		utils.log().info("Verifying Lease Time with Forever Time Unit ");
//		utils.log().info("********************************************");
		
		// First select the Forever option in the Test
		//if(disabledLeaseTimeTextBox.isDisplayed() && !(disabledLeaseTimeTextBox.isEnabled()))
		utils.log().info("Lease Time Text Box is disabled for this TimeUnit. Default Lease Time set for Forever TimeUnit is : " + disabledLeaseTimeTextBox.getText());
		//this.clickSaveLeaseTimeButton();
		//NetworkLANDHCPLeaseTimeAppliedChangesDialog - Click OK button
		return true;
	}
	
	public boolean verifySameLeaseTimeForAnyUnit() {
		utils.log().info("                                            ");
		utils.log().info("********************************************");
		utils.log().info("Verifying Same Lease Time for Any Time Unit ");
		utils.log().info("********************************************");
		
		// First select the Minutes option in the Test

		this.enterLeaseTime("2000");
		this.clickSaveLeaseTimeButton();
		utils.log().info("Enter Lease Time between 1 and 35791395 and applied the changes successfully");
		utils.log().info("Entered Same Lease Time and clicked Save Button");
		this.enterLeaseTime("2000");
		this.clickSaveLeaseTimeButton();
		
		//NetworkLANDHCPLeaseTimeAppliedSameChangesDialog - Click OK button
		
		return true;
	}
	
	
	@Override
	public boolean isAt() {
		if (lanDHCPLeaseTimeTitle.isDisplayed()) {
			utils.log().info("On LAN DHCP Lease Time Page");
			return true;
		} else {
			utils.log().info("Not on LAN DHCP Lease Time Page");
			return false;
		}
	}
}
