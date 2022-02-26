package com.cs.arris.Pages;

import java.util.List;

import org.apache.commons.lang3.time.StopWatch;
import org.openqa.selenium.support.PageFactory;

import com.cs.arris.Base.ParentClass;
import com.cs.arris.Interface.Page;
import com.cs.arris.Utilities.Direction;
import com.cs.arris.Utilities.TestUtils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class WhosHomeAddNewNotificationPage extends ParentClass implements Page {
	public TestUtils utils = new TestUtils();

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"WH_Add_Edit_Notification_Screen_TitleLabel\"]")
	public MobileElement addNotificationTitle;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"WH_Add_Edit_Notification_Screen_Button_Close\"]")
	public MobileElement closeButton;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"WH_Add_Edit_Notification_Screen_Label_Notify\"]")
	public MobileElement notifyMeWhenLabel;
	
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"WH_Add_Edit_Notification_Screen_Label_Initial[1]\"]")
	public MobileElement selectMemberOneInitialIcon;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"WH_Add_Edit_Notification_Screen_Label_Name[1]\"]")
	public MobileElement selectMemberOneName;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"WH_Add_Edit_Notification_Screen_Label_Selection[1]\"]")
	public MobileElement selectMemberOneRadioButton;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"WH_Add_Edit_Notification_Screen_Label_Initial[2]\"]")
	public MobileElement selectMemberTwoInitialIcon;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"WH_Add_Edit_Notification_Screen_Label_Name[2]\"]")
	public MobileElement selectMemberTwoName;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"WH_Add_Edit_Notification_Screen_Label_Selection[2]\"]")
	public MobileElement selectMemberTwoRadioButton;
	
	
	
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"WH_Add_Edit_Notification_Screen_Label_Event\"]")
	public MobileElement onTheEventOfLabel;
	
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"WH_Add_Edit_Notification_Screen_Image_Leaves\"]")
	public MobileElement leavesHomeIcon;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"WH_Add_Edit_Notification_Screen_Label_Leaves\"]")
	public MobileElement leavesHomeLabel;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"WH_Add_Edit_Notification_Screen_Button_Leaves\"]")
	public MobileElement leavesHomeRadioButton;
	
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"WH_Add_Edit_Notification_Screen_Image_Enter\"]")
	public MobileElement entersHomeIcon;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"WH_Add_Edit_Notification_Screen_Label_Enter\"]")
	public MobileElement entersHomeLabel;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"WH_Add_Edit_Notification_Screen_Button_Enter\"]")
	public MobileElement entersHomeRadioButton;
	
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"WH_Add_Edit_Notification_Screen_Image_Doesnt\"]")
	public MobileElement doesntLeaveHomeIcon;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"WH_Add_Edit_Notification_Screen_Label_Doesnt\"]")
	public MobileElement doesntLeaveHomeLabel;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"WH_Add_Edit_Notification_Screen_Button_Doesnt\"]")
	public MobileElement doesntLeaveHomeRadioButton;
	
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"WH_Add_Edit_Notification_Screen_Image_DoesntEnter\"]")
	public MobileElement doesntEnterHomeIcon;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"WH_Add_Edit_Notification_Screen_Label_DoesntEnter\"]")
	public MobileElement doesntEnterHomeLabel;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"WH_Add_Edit_Notification_Screen_Button_DoesntEnter\"]")
	public MobileElement doesntEnterHomeRadioButton;
	
	
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"WH_Add_Edit_Notification_Screen_Label_Schedule\"]")
	public MobileElement timeScheduleLabel;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"WH_Add_Edit_Notification_Screen_Label_Select\"]")
	public MobileElement selectScheduleLabel;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"WH_Add_Edit_Notification_Screen_Label_Everyday\"]")
	public MobileElement everydayLabel;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"WH_Add_Edit_Notification_Screen_Button_Everyday\"]")
	public MobileElement everydayRadioButton;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"WH_Add_Edit_Notification_Screen_Label_Custom\"]")
	public MobileElement customLabel;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"WH_Add_Edit_Notification_Screen_Button_Custom\"]")
	public MobileElement customRadioButton;
	
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"WH_Add_Edit_Notification_Screen_Label_AtTime\"]")
	public MobileElement atATimeLabel;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"WH_Add_Edit_Notification_Screen_Button_Time\"]")
	public MobileElement timeButton;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"WH_Add_Edit_Notification_Screen_Label_AddTolerance\"]")
	public MobileElement addToleranceLabel;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"WH_Add_Edit_Notification_Screen_Button_Tolerance\"]")
	public MobileElement selectTolerance;
	
	
	//on-click of timeButton - Time Picker dialog appears
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"WH_Add_Edit_Notification_Screen_Button_Cancel\"]")
	public MobileElement timePickerCancelButton;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"WH_Add_Edit_Notification_Screen_Button_Done\"]")
	public MobileElement timePickerDoneButton;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeDatePicker[@name=\"WH_Add_Edit_Notification_Screen_TimePicker\"]/XCUIElementTypePicker/XCUIElementTypePickerWheel[1]")
	public MobileElement hourPicker;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeDatePicker[@name=\"WH_Add_Edit_Notification_Screen_TimePicker\"]/XCUIElementTypePicker/XCUIElementTypePickerWheel[2]")
	public MobileElement minutePicker;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeDatePicker[@name=\"WH_Add_Edit_Notification_Screen_TimePicker\"]/XCUIElementTypePicker/XCUIElementTypePickerWheel[3]")
	public MobileElement meridianPicker;
	
	
	//on-click on selectTolerance list box
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"WH_Add_Edit_Notification_Screen_Label_ToleranceOption[1]\"]")
	public MobileElement tenMinutes;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"WH_Add_Edit_Notification_Screen_Label_ToleranceOption[2]\"]")
	public MobileElement twentyMinutes;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"WH_Add_Edit_Notification_Screen_Label_ToleranceOption[3]\"]")
	public MobileElement thirtyMinutes;
	
	//when Custom option is selected
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"WH_Add_Edit_Notification_Screen_Label_SelectDays\"]")
	public MobileElement selectDaysLabel;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"WH_Add_Edit_Notification_Screen_Button_Monday\"]")
	public MobileElement monday;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"WH_Add_Edit_Notification_Screen_Button_Tuesday\"]")
	public MobileElement tuesday;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"WH_Add_Edit_Notification_Screen_Button_Wednesday\"]")
	public MobileElement wednesday;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"WH_Add_Edit_Notification_Screen_Button_Thursday\"]")
	public MobileElement thrusday;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"WH_Add_Edit_Notification_Screen_Button_Friday\"]")
	public MobileElement friday;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"WH_Add_Edit_Notification_Screen_Button_Saturday\"]")
	public MobileElement saturday;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"WH_Add_Edit_Notification_Screen_Button\"]")
	public MobileElement saveButton;
	
	public WhosHomeAddNewNotificationPage() {
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}

	public boolean clickCloseButton() {
		if (closeButton.isDisplayed()) {
			click(closeButton);
			utils.log().info("Clicked on Close Button");
			return true;
		} else {
			utils.log().info("Close Button is not displayed");
			return false;
		}
	}
	
	public boolean clickLeavesHomeRadioButton() {
		if (leavesHomeRadioButton.isDisplayed()) {
			click(leavesHomeRadioButton);
			utils.log().info("Clicked on Leaves Home Radio Button");
			return true;
		} else {
			utils.log().info("Leaves Home Radio Button is not displayed");
			return false;
		}
	}
	
	public boolean clickDoesNotLeaveHomeRadioButton() {
		if (doesntLeaveHomeRadioButton.isDisplayed()) {
			click(doesntLeaveHomeRadioButton);
			utils.log().info("Clicked on Does Not Leave Home Radio Button");
			return true;
		} else {
			utils.log().info("Does Not Leave Home Radio Button is not displayed");
			return false;
		}
	}
	
	public boolean clickEntersHomeRadioButton() {
		if (entersHomeRadioButton.isDisplayed()) {
			click(entersHomeRadioButton);
			utils.log().info("Clicked on Enters Home Radio Button");
			return true;
		} else {
			utils.log().info("Enters Home Radio Button is not displayed");
			return false;
		}
	}
	
	public boolean clickDoesNotEnterHomeRadioButton() {
		if (doesntEnterHomeRadioButton.isDisplayed()) {
			click(doesntEnterHomeRadioButton);
			utils.log().info("Clicked on Does Not Enter Home Radio Button");
			return true;
		} else {
			utils.log().info("Does Not Enter Home Radio Button is not displayed");
			return false;
		}
	}
	
	public boolean clickEveryDayRadioButton() {
		if (everydayRadioButton.isDisplayed()) {
			click(everydayRadioButton);
			utils.log().info("Clicked on EveryDay Radio Button");
			return true;
		} else {
			utils.log().info("EveryDay Radio Button is not displayed");
			return false;
		}
	}
	
	public boolean clickCustomRadioButton() {
		if (customRadioButton.isDisplayed()) {
			click(customRadioButton);
			utils.log().info("Clicked on Custom Radio Button");
			return true;
		} else {
			utils.log().info("Custom Radio Button is not displayed");
			return false;
		}
	}
	
	public boolean clickSelectTimeButton() {
		if (timeButton.isDisplayed()) {
			click(timeButton);
			utils.log().info("Clicked on Time Button");
			return true;
		} else {
			utils.log().info("Time Button is not displayed");
			return false;
		}
	}
	
	public boolean clickTimePickerDoneButton() {
		if (timePickerDoneButton.isDisplayed()) {
			click(timePickerDoneButton);
			utils.log().info("Clicked on Time Picker Done Button");
			return true;
		} else {
			utils.log().info("Time Picker Done Button is not displayed");
			return false;
		}
	}
	
	public boolean clickTimePickerCancelButton() {
		if (timePickerCancelButton.isDisplayed()) {
			click(timePickerCancelButton);
			utils.log().info("Clicked on Time Picker Cancel Button");
			return true;
		} else {
			utils.log().info("Time Picker Cancel Button is not displayed");
			return false;
		}
	}
	
	public boolean clickSelectToleranceButton() {
		if (selectTolerance.isDisplayed()) {
			click(selectTolerance);
			utils.log().info("Clicked on Select Tolerance List Box");
			return true;
		} else {
			utils.log().info("Select Tolerance List Box is not displayed");
			return false;
		}
	}
	
	public boolean click10MinToleranceButton() {
		if (tenMinutes.isDisplayed()) {
			click(tenMinutes);
			utils.log().info("Selected 10 min option from the Select Tolerance List Box");
			return true;
		} else {
			utils.log().info("10 min option inSelect Tolerance List Box is not displayed");
			return false;
		}
	}
	
	public boolean click20MinToleranceButton() {
		if (twentyMinutes.isDisplayed()) {
			click(twentyMinutes);
			utils.log().info("Selected 20 min option from the Select Tolerance List Box");
			return true;
		} else {
			utils.log().info("20 min option in Select Tolerance List Box is not displayed");
			return false;
		}
	}
	
	public boolean click30MinToleranceButton() {
		if (thirtyMinutes.isDisplayed()) {
			click(thirtyMinutes);
			utils.log().info("Selected 30 min option from the Select Tolerance List Box");
			return true;
		} else {
			utils.log().info("30 min option inSelect Tolerance List Box is not displayed");
			return false;
		}
	}
	
	public boolean clickMondayButton() {
		if (monday.isDisplayed()) {
			click(monday);
			utils.log().info("Selected option Monday");
			return true;
		} else {
			utils.log().info("Monday option is not displayed");
			return false;
		}
	}
	
	public boolean clickTuesdayButton() {
		if (tuesday.isDisplayed()) {
			click(tuesday);
			utils.log().info("Selected option Tuesday");
			return true;
		} else {
			utils.log().info("Tuesday option is not displayed");
			return false;
		}
	}
	
	public boolean clickWednesdayButton() {
		if (wednesday.isDisplayed()) {
			click(wednesday);
			utils.log().info("Selected option Wednesday");
			return true;
		} else {
			utils.log().info("Wednesday option is not displayed");
			return false;
		}
	}
	
	public boolean clickThrusdayButton() {
		if (thrusday.isDisplayed()) {
			click(thrusday);
			utils.log().info("Selected option Thrusday");
			return true;
		} else {
			utils.log().info("Thrusday option is not displayed");
			return false;
		}
	}
	
	public boolean clickFridayButton() {
		if (friday.isDisplayed()) {
			click(friday);
			utils.log().info("Selected option Friday");
			return true;
		} else {
			utils.log().info("Friday option is not displayed");
			return false;
		}
	}
	
	public boolean clickSaturdaydayButton() {
		if (saturday.isDisplayed()) {
			click(saturday);
			utils.log().info("Selected option Saturday");
			return true;
		} else {
			utils.log().info("Saturday option is not displayed");
			return false;
		}
	}
	
	public boolean clickSaveButton() {
		if (saveButton.isDisplayed()) {
			click(saveButton);
			utils.log().info("Clicked on Save Button");
			return true;
		} else {
			utils.log().info("Save Button is not displayed");
			return false;
		}
	}
	
	public boolean selectMinutes()
	{
		super.swipeWhosHomeNotificationMinutes(Direction.UP);
		return true;
	}
	
	
	public boolean verifyAddNewNotificationPageUI() {
		utils.log().info("                                                   ");
		utils.log().info("***************************************************");
		utils.log().info("Details of UI Elements on Add New Notification Page");
		utils.log().info("***************************************************");
		try {
			try {
				if (addNotificationTitle.isDisplayed())
					utils.log().info(addNotificationTitle.getText() + "title text is displayed");
			} catch (Exception e) {
				utils.log().info("ADD NEW NOTIFICATION title text is not displayed");
			}

			try {
				if (onTheEventOfLabel.isDisplayed())
					utils.log().info(onTheEventOfLabel.getText() + " label is displayed");
			} catch (Exception e) {
				utils.log().info("On the event of label is not displayed");
			}

			try {
				if (leavesHomeIcon.isDisplayed())
					utils.log().info("Leaves Home Icon is displayed");
			} catch (Exception e) {
				utils.log().info("Leaves Home Icon is not displayed");
			}

			try {
				if (leavesHomeLabel.isDisplayed())
					utils.log().info(leavesHomeLabel.getText() + " label is displayed");
			} catch (Exception e) {
				utils.log().info("Leaves Home label is not displayed");
			}

			try {
				if (leavesHomeRadioButton.isDisplayed())
					utils.log().info("Leaves Home Radio button is displayed");
			} catch (Exception e) {
				utils.log().info("Leaves Home Radio button is not displayed");
			}

			try {
				if (entersHomeIcon.isDisplayed())
					utils.log().info("Enters Home Icon is displayed");
			} catch (Exception e) {
				utils.log().info("Enters Home Icon is not displayed");
			}

			try {
				if (entersHomeLabel.isDisplayed())
					utils.log().info(entersHomeLabel.getText() + " label is displayed");
			} catch (Exception e) {
				utils.log().info("Enters Home label is not displayed");
			}

			try {
				if (entersHomeRadioButton.isDisplayed())
					utils.log().info("Enters Home Radio button is displayed");
			} catch (Exception e) {
				utils.log().info("Enters Home Radio button is not displayed");
			}

			try {
				if (doesntLeaveHomeIcon.isDisplayed())
					utils.log().info("Does Not Leave Home Icon is displayed");
			} catch (Exception e) {
				utils.log().info("Does Not Leave Home Icon is not displayed");
			}

			try {
				if (doesntLeaveHomeLabel.isDisplayed())
					utils.log().info(doesntLeaveHomeLabel.getText() + " label is displayed");
			} catch (Exception e) {
				utils.log().info("Does Not Leave Home label is not displayed");
			}

			try {
				if (doesntLeaveHomeRadioButton.isDisplayed())
					utils.log().info("Does Not Leave Home Radio button is displayed");
			} catch (Exception e) {
				utils.log().info("Does Not Leave Home Radio button is not displayed");
			}

			try {
				if (doesntEnterHomeIcon.isDisplayed())
					utils.log().info("Does Not Enter Home Icon is displayed");
			} catch (Exception e) {
				utils.log().info("Does Not Enter Home Icon is not displayed");
			}

			try {
				if (doesntEnterHomeLabel.isDisplayed())
					utils.log().info(doesntEnterHomeLabel.getText() + " label is displayed");
			} catch (Exception e) {
				utils.log().info("Does Not Enter Home label is not displayed");
			}

			try {
				if (doesntEnterHomeRadioButton.isDisplayed())
					utils.log().info("Does Not Enter Home Radio button is displayed");
			} catch (Exception e) {
				utils.log().info("Does Not Enter Home Radio button is not displayed");
			}

			super.swipeUp();

			try {
				if (timeScheduleLabel.isDisplayed())
					utils.log().info("Time Schedule Label is displayed");
			} catch (Exception e) {
				utils.log().info("Time Schedule Label is not displayed");
			}

			try {
				if (selectScheduleLabel.isDisplayed())
					utils.log().info("Select Schedule Label is displayed");
			} catch (Exception e) {
				utils.log().info("Select Schedule Label is not displayed");
			}

			try {
				if (everydayRadioButton.isDisplayed() && everydayRadioButton.isSelected())
					utils.log().info("EveryDay Radio button is displayed and is currently selected");
			} catch (Exception e) {
				utils.log().info("EveryDay Radio button is not displayed");
			}

			try {
				if (everydayLabel.isDisplayed())
					utils.log().info("EveryDay Label is displayed");
			} catch (Exception e) {
				utils.log().info("EveryDay Label is not displayed");
			}

			try {
				if (customRadioButton.isDisplayed() && (!customRadioButton.isSelected()))
					utils.log().info("Custom Radio button is displayed but is not currently selected");
			} catch (Exception e) {
				utils.log().info("Custom Radio button is not displayed");
			}

			try {
				if (customLabel.isDisplayed())
					utils.log().info("Custom Label is displayed");
			} catch (Exception e) {
				utils.log().info("Custom Label is not displayed");
			}

			try {
				if (atATimeLabel.isDisplayed())
					utils.log().info("At a time label is displayed");
			} catch (Exception e) {
				utils.log().info("At a time label is not displayed");
			}

			try {
				if (timeButton.isDisplayed())
					utils.log().info("Button to select time is displayed");
			} catch (Exception e) {
				utils.log().info("Button to select time is not displayed");
			}

			try {
				if (addToleranceLabel.isDisplayed())
					utils.log().info("Tolerance (+/-) label is displayed");
			} catch (Exception e) {
				utils.log().info("Tolerance (+/-) label is not displayed");
			}

			try {
				if (selectTolerance.isDisplayed())
					utils.log().info("Select Tolerance List Box is displayed");
			} catch (Exception e) {
				utils.log().info("Select Tolerance List Box is not displayed");
			}
			
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	
	public boolean selectMemberOne() {
		try {
			try {
				if (selectMemberOneInitialIcon.isDisplayed() && selectMemberOneName.isDisplayed() && selectMemberOneRadioButton.isDisplayed())
					utils.log().info("Selecting Member : " + selectMemberOneName.getText());
					click(selectMemberOneRadioButton);
			} catch (Exception e) {
				utils.log().info("ADD NEW NOTIFICATION title text is not displayed");
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean selectMemberTwo() {
		try {
			try {
				if (selectMemberTwoInitialIcon.isDisplayed() && selectMemberTwoName.isDisplayed() && selectMemberTwoRadioButton.isDisplayed())
					utils.log().info("Selecting Member : " + selectMemberTwoName.getText());
					click(selectMemberTwoRadioButton);
			} catch (Exception e) {
				utils.log().info("ADD NEW NOTIFICATION title text is not displayed");
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	

	@Override
	public boolean isAt() {
		if (addNotificationTitle.isDisplayed()) {
			utils.log().info("On ADD NEW NOTIFICATION Page");
			return true;
		} else {
			utils.log().info("Not on ADD NEW NOTIFICATION Page");
			return false;
		}
	}
}
