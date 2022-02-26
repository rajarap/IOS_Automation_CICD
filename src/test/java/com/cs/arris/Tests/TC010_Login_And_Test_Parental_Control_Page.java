package com.cs.arris.Tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.lang.reflect.Method;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cs.arris.Base.ParentClass;
import com.cs.arris.Pages.HomePage;
import com.cs.arris.Pages.NetworkPage;
import com.cs.arris.Pages.ParentalControlWithProfilesPage;
import com.cs.arris.Pages.SiginPage;
import com.cs.arris.Utilities.TestUtils;

import com.cs.arris.Workflows.TC52_Login_And_Verify_HomePage_Workflow;
import com.cs.arris.Workflows.TC53_Login_And_Verify_DevicesPage_Workflow;
import com.cs.arris.Workflows.TC60_Login_And_Verify_HamburgerMenuAndSettingsAboutHelpPage_Workflow;


public class TC010_Login_And_Test_Parental_Control_Page extends ParentClass {
	TestUtils utils = new TestUtils();
	String firstName;
	String lastName;
	String email;
	String passCode;
	String ssid;
	String ssidpass;
	String udid;
	String phoneToPause;
	String countOfDeviceSignalStrength;
	String countOfDevicesSpeedHistory;
	String countOfDevicesBlocked;
	String downloadSpeed;
	String uploadSpeed;
	int totalCountOfDevices;
	int countOfDevices;

	@BeforeClass
	public void beforeClass() throws Exception {
		try {
			String dataFileName = "testdata/signup";
			utils.log().info("Loading...Test Data");
			super.loadTestData(dataFileName);

			this.firstName = properties.getProperty("firstname");
			utils.log().info("First Name : " + this.firstName);

			this.lastName = properties.getProperty("lastname");
			utils.log().info("Last Name : " + this.lastName);

			this.email = properties.getProperty("email");
			utils.log().info("Email address : " + this.email);

			this.udid = properties.getProperty("udid");
			utils.log().info("UDID : " + this.udid);

			this.phoneToPause = properties.getProperty("phoneToPauseInternet");
			utils.log().info("Phone To Pause Internet : " + this.phoneToPause);

			utils.log().info("Retrieved...Test Data");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@BeforeMethod
	public void beforeMethod(Method m) {
		utils.log().info("\n" + "\n" + "****** starting test :  " + m.getName() + "  ******" + "\n");
	}

//	@Test(priority = 1)
//	public void Login_And_Onboard() {
//		TC61_Login_And_Verify_ParentalControl_Workflow.getStartedPage(getStarted -> {
//			getStarted.clickGetStartedButton();
//		}).grantPermissionsPage(grantPermission -> {
//			grantPermission.clickContinueButton();
//		}).deviceLocationPage(deviceLocation -> {
//			deviceLocation.clickOnlyThisTimeLink();
//		}).accessResourcesOnDevicePage(accessResoucesOnDevice -> {
//			super.pause(3);
//			accessResoucesOnDevice.clickAllowLink();
//		}).selectYourDevicePage(selectDevice -> {
//			selectDevice.selectSurfboardMaxOption();
//			selectDevice.clickNextButton();
//		}).selectYourDevicePage2(selectDevice2 -> {
//			selectDevice2.selectMaxProAX11000RadioButton();
//			selectDevice2.clickNextButton();
//			super.pause(3);
//		}).welcomeSigninPage(signin -> {
//			signin.enterEmailAddress(email);
//			signin.clickSigninButton();
//			super.pause(12);
//		}).getOTPCode(getOTP -> {
//			passCode = getOTP.getValidOTP();
//		}).enterOTPPage(otpverify -> {
//			otpverify.enterValidPassCode(passCode);
//		}).codeVerifiedPage(codeVerified -> {
//			codeVerified.getCodeVerifiedText();
//			codeVerified.clickNextButton();
//			super.pause(3);
//			try {
//				if (codeVerified.continueOnBoardingButton.isDisplayed()) {
//					codeVerified.clickContinueOnboardingButton();
//				}
//			} catch (Exception e) {
//				e.getMessage();
//			}
//		}).setupWifi(setupwifi -> {
//			setupwifi.clickskipTutorialButton();
//		}).homePage(home -> {
//			try {
//				if (home.okButton.isDisplayed()) {
//					home.clickOkButton();
//				}
//			} catch (Exception e) {
//				e.getMessage();
//			}
//			//home.verifyUIOnHomePage();
//			//countOfDevices= home.getTotalCountOfDevices();
//			home.getFooterIconsPageObject().clickParentalButton();
//		});
//	}
	@Test(priority = 1)
	public void Verify_Parental_Control() {
		try {
			this.Verify_Parental_Control_UI_Page();
		}catch(Exception e) {utils.log().info("Issue in Parental Control UI Page");}
		
		try {
			this.Verify_Add_Profile_Page();
		}catch(Exception e) {utils.log().info("Issue in Add Profile Page");}
		
		try {
			this.Verify_User_Profile_Page();
		}catch(Exception e) {utils.log().info("Issue in User Profile Page");}
		
		try {
			this.Verify_User_Profile_Help_Page();
		}catch(Exception e) {utils.log().info("Issue in User Profile Help Page");}
		
		try {
			this.Verify_Parental_Control_UI_Page();
		}catch(Exception e) {utils.log().info("Issue in Parental Control UI Page");}
		
		try {
			this.Verify_Add_Profile_Page();
		}catch(Exception e) {utils.log().info("Issue in Add Profile Page");}
		
		try {
			this.Verify_User_Profile_Page();
		}catch(Exception e) {utils.log().info("Issue in User Profile Page");}
		
		try {
			this.Verify_Devices_Associated_With_User_Profile();
		}catch(Exception e) {utils.log().info("Issue in Devices Associated With User Profile");}
		
		try {
			this.Verify_Add_Rule_To_User_Profile();
		}catch(Exception e) {utils.log().info("Issue in Add Rule To User Profile");}
		
		try {
			this.Verify_Add_EveryDay_Schedule_To_Rule();
		}catch(Exception e) {utils.log().info("Issue in Add EveryDay Schedule To Rule");}
		
		try {
			this.Verify_Select_Start_Time_For_EveryDay_Schedule();
		}catch(Exception e) {utils.log().info("Issue in Select Start Time For EveryDay Schedule");}

		try {
			this.Verify_Select_Stop_Time_For_EveryDay_Schedule();
		}catch(Exception e) {utils.log().info("Issue in Select Stop Time For EveryDay Schedule");}
		
		try {
			this.Verify_Add_Custom_Schedule_To_Rule();
		}catch(Exception e) {utils.log().info("Issue in Add Custom Schedule To Rule");}
		
		try {
			this.Verify_Add_Custom_Schedule_Select_DOW();
		}catch(Exception e) {utils.log().info("Issue in Add Custom Schedule Select DOW");}
		
		try {
			this.Verify_Add_Custom_Schedule_Select_Start_Time();
		}catch(Exception e) {utils.log().info("Issue in Custom Schedule Select Start Time");}
		
		try {
			this.Verify_Add_Custom_Schedule_Select_Stop_Time();
		}catch(Exception e) {utils.log().info("Issue in Add Custom Schedule Select Stop Time");}
		
		try {
			this.Verify_Enable_Schedule_Time_UI_Page();
		}catch(Exception e) {utils.log().info("Issue in Enable Schedule Time UI Page");}
		
		try {
			this.Verify_Rules_Associated_With_User();
		}catch(Exception e) {utils.log().info("Issue in Verify Rules Associated With User");}
		
//		try {
//			this.Verify_Pause_Internet_For_All_Users();
//		}catch(Exception e) {utils.log().info("Issue in Pause Internet For All Users");}
//		
//		try {
//			this.Verify_Currently_Blocked_Profiles();
//		}catch(Exception e) {utils.log().info("Issue in Currently Blocked Profiles");}
//		
//		try {
//			this.Verify_Resume_Internet_For_All_Users();
//		}catch(Exception e) {utils.log().info("Issue in Resume Internet For All Users");}
		
		try {
			this.Verify_Currently_Blocked_Users_After_Resuming_Internet_For_All_Users();
		}catch(Exception e) {utils.log().info("Issue in Currently Blocked Users After Resuming Internet For All Users");}
		
		try {
			this.Verify_Parental_Control_Help_Page();
		}catch(Exception e) {utils.log().info("Issue in Parental Control Help Page");}
	}
		
	@Test(priority = 2)
	public void Verify_Parental_Control_UI_Page() {
		SoftAssert softcontrol2 = new SoftAssert();
		AssertJUnit.assertTrue(new HomePage().getFooterIconsPageObject().clickParentalButton());
		if(new ParentalControlWithProfilesPage().isAt())
			AssertJUnit.assertTrue(new ParentalControlWithProfilesPage().verifyUIOnParentalControlProfilesPage());
		softcontrol2.assertAll();
	}
	
	@Test(priority = 3)
	public void Verify_Add_Profile_Page() {
		SoftAssert softcontrol3 = new SoftAssert();
		if(new ParentalControlWithProfilesPage().isAt())
			AssertJUnit.assertTrue(new ParentalControlWithProfilesPage().enableParentalControl());
		super.pause(5);
		
		try {
			if(new ParentalControlWithProfilesPage().getAppRatingDialogObject().isAt())
				AssertJUnit.assertTrue(new ParentalControlWithProfilesPage().getAppRatingDialogObject().clickRemindMeLaterLink());
		}catch(Exception e) {utils.log().info("App Rating Dialog did not appear");}
		
		if(new ParentalControlWithProfilesPage().isAt()) {
			for(int i = 1; i <= 3; i++)	{
				AssertJUnit.assertTrue(new ParentalControlWithProfilesPage().clickAddProfilesLink());
				AssertJUnit.assertTrue(new ParentalControlWithProfilesPage().getAddProfileDialogObject().enterProfileName());
				AssertJUnit.assertTrue(new ParentalControlWithProfilesPage().getAddProfileDialogObject().clickCreateProfileButton());
			}
		}
		if(new ParentalControlWithProfilesPage().isAt()) 
			AssertJUnit.assertTrue(new ParentalControlWithProfilesPage().verifyUserProfile());
		softcontrol3.assertAll();
	}
	
	@Test(priority = 4)
	public void Verify_User_Profile_Page() {
		SoftAssert softcontrol4 = new SoftAssert();
		if(new ParentalControlWithProfilesPage().isAt())
			AssertJUnit.assertTrue(new ParentalControlWithProfilesPage().clickOnUserProfile());
		
		if(new ParentalControlWithProfilesPage().getUserProfilePageObject().isAt())
			AssertJUnit.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().verifyUIOnUserProfilePage());
		
		super.pause(5);
		
		softcontrol4.assertAll();
	}
	
	@Test(priority = 5)
	public void Verify_User_Profile_Help_Page() {
		SoftAssert softcontrol5 = new SoftAssert();
		AssertJUnit.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().clickHelpIcon());
		super.pause(3);
		
		if(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileHelpPageObject().isAt()){
			AssertJUnit.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileHelpPageObject().verifyUIOnUserProfilePage());
			AssertJUnit.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileHelpPageObject().clickCloseButton());
		}
		
		softcontrol5.assertAll();
	}
	
	@Test(priority = 6)
	public void Verify_Edit_User_Profile_Name() {
		SoftAssert softcontrol6 = new SoftAssert();
		AssertJUnit.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().getExistingUserName());
		AssertJUnit.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().clickUserProfileNameEditButton());
		
		if(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalEditUserProfileDialogObject().isAt()){
			AssertJUnit.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalEditUserProfileDialogObject().verifyUIOnEditUserProfileDialog());
			AssertJUnit.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalEditUserProfileDialogObject().enterUserProfileName());
			AssertJUnit.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalEditUserProfileDialogObject().clickSaveButton());
			super.pause(3);
		}
		AssertJUnit.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().validateUserProfileEditedName());
		softcontrol6.assertAll();
	}
	
	@Test(priority = 7)
	public void Verify_Add_Device_To_User_Profile() {
		SoftAssert softcontrol7 = new SoftAssert();
		AssertJUnit.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().clickAddDeviceLink());
		
		if(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddDevicePageObject().isAt()) {
			AssertJUnit.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddDevicePageObject().verifyDevicesInAddDevicePage());
			utils.log().info("Clicking on Add Device button without selecting any device");
			AssertJUnit.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddDevicePageObject().clickAddDeviceButton());
			
//			if(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddDevicePageObject().alertTitle.isDisplayed()) {
//				utils.log().info("Alert dialog box with message - " + new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddDevicePageObject().description.getText()+ " - is displayed");
//				softcontrol7.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddDevicePageObject().clickCloseButtonOnAlertDialog());	
//			}
				
			AssertJUnit.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddDevicePageObject().selectADeviceForUserProfile());
			AssertJUnit.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddDevicePageObject().clickAddDeviceButton());
			//softcontrol7.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddDevicePageObject().verifyDeviceCountAfterAssociatingToUser());
		}
		
		softcontrol7.assertAll();
	}
	
	@Test(priority = 8)
	public void Verify_Add_Device_Help_Page() {
		SoftAssert softcontrol8 = new SoftAssert();
//		softcontrol8.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddDevicePageObject().clickHelpIcon());
//		
//		if (new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddDevicePageObject().getParentalAddDeviceHelpPageObject().isAt()) 
//			softcontrol8.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddDevicePageObject().getParentalAddDeviceHelpPageObject().clickCloseButton());
		
		AssertJUnit.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddDevicePageObject().clickBackButton());
		
		softcontrol8.assertAll();
	}
	
	@Test(priority = 9)
	public void Verify_Devices_Associated_With_User_Profile() {
		SoftAssert softcontrol9 = new SoftAssert();
		AssertJUnit.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().verifyAssociatedDeviceList());
		AssertJUnit.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().clickDeviceListExpandButton());
		
		softcontrol9.assertAll();
	}
	
	@Test(priority = 10)
	public void Verify_Add_Rule_To_User_Profile() {
		SoftAssert softcontrol10 = new SoftAssert();
		AssertJUnit.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().clickAddRuleLink());
		
		if(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddRulePageObject().isAt()) 
			AssertJUnit.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddRulePageObject().clickAddScheduleButton());
		
		softcontrol10.assertAll();
	}
	
	@Test(priority = 11)
	public void Verify_Add_EveryDay_Schedule_To_Rule() {
		SoftAssert softcontrol11 = new SoftAssert();
		if(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddRulePageObject().getInternetBlockingScheduleDialogObject().isAt()) 
			AssertJUnit.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddRulePageObject().getInternetBlockingScheduleDialogObject().verifyUIOnAddInternetBlockingScheduleDialog());
		utils.log().info("                                                          ");
		utils.log().info("Selecting same start and stop time");
		AssertJUnit.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddRulePageObject().getInternetBlockingScheduleDialogObject().clickStartTimeLink());
		AssertJUnit.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddRulePageObject().getInternetBlockingScheduleDialogObject().getDatePickerDialogObject().clickOkButton());
		AssertJUnit.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddRulePageObject().getInternetBlockingScheduleDialogObject().clickStopTimeLink());
		AssertJUnit.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddRulePageObject().getInternetBlockingScheduleDialogObject().getDatePickerDialogObject().clickOkButton());
		AssertJUnit.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddRulePageObject().getInternetBlockingScheduleDialogObject().clickSaveChangesButton());
		
		if(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddRulePageObject().getInternetBlockingScheduleDialogObject().errorDescriptionForSameStartEndTime.isDisplayed())
			utils.log().info("Alert dialog with message - " + new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddRulePageObject().getInternetBlockingScheduleDialogObject().errorDescriptionForSameStartEndTime.getText() + " - is displayed");

		AssertJUnit.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddRulePageObject().getInternetBlockingScheduleDialogObject().clickCloseButton());

		softcontrol11.assertAll();
	}
	
	@Test(priority = 12)
	public void Verify_Select_Start_Time_For_EveryDay_Schedule() {
		SoftAssert softcontrol12 = new SoftAssert();
		if(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddRulePageObject().isAt()) 
			AssertJUnit.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddRulePageObject().clickAddScheduleButton());
		
		if(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddRulePageObject().getInternetBlockingScheduleDialogObject().isAt()) {
			AssertJUnit.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddRulePageObject().getInternetBlockingScheduleDialogObject().clickEveryDayButton());
			AssertJUnit.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddRulePageObject().getInternetBlockingScheduleDialogObject().clickStartTimeLink());}
		
		if (new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddRulePageObject().getInternetBlockingScheduleDialogObject().getDatePickerDialogObject().isAt()) 
			AssertJUnit.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddRulePageObject().getInternetBlockingScheduleDialogObject().getDatePickerDialogObject().clickOkButton());

		softcontrol12.assertAll();
	}
	
	@Test(priority = 13)
	public void Verify_Select_Stop_Time_For_EveryDay_Schedule() {
		SoftAssert softcontrol13 = new SoftAssert();
		super.pause(65);
		AssertJUnit.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddRulePageObject().getInternetBlockingScheduleDialogObject().clickStopTimeLink());
		
		if (new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddRulePageObject().getInternetBlockingScheduleDialogObject().getDatePickerDialogObject().isAt()) 
			AssertJUnit.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddRulePageObject().getInternetBlockingScheduleDialogObject().getDatePickerDialogObject().clickOkButton());
			
		AssertJUnit.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddRulePageObject().getInternetBlockingScheduleDialogObject().clickSaveChangesButton());
		super.pause(3);

		softcontrol13.assertAll();
	}
	
	@Test(priority = 14)
	public void Verify_Add_Custom_Schedule_To_Rule() {
		SoftAssert softcontrol14 = new SoftAssert();
		if(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddRulePageObject().isAt()) {
			AssertJUnit.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddRulePageObject().clickAddScheduleButton());
			AssertJUnit.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddRulePageObject().getInternetBlockingScheduleDialogObject().clickCustomButton());
			AssertJUnit.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddRulePageObject().getInternetBlockingScheduleDialogObject().verifyUIOnCustomClick());
		}
		softcontrol14.assertAll();
	}
	
	@Test(priority = 15)
	public void Verify_Add_Custom_Schedule_Select_DOW() {
		SoftAssert softcontrol15 = new SoftAssert();
		AssertJUnit.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddRulePageObject().getInternetBlockingScheduleDialogObject().clickSunday());
		AssertJUnit.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddRulePageObject().getInternetBlockingScheduleDialogObject().clickTuesday());
		AssertJUnit.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddRulePageObject().getInternetBlockingScheduleDialogObject().clickThrusday());

		softcontrol15.assertAll();
		}
	
	@Test(priority = 16)
	public void Verify_Add_Custom_Schedule_Select_Start_Time() {
		SoftAssert softcontrol16 = new SoftAssert();
		AssertJUnit.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddRulePageObject().getInternetBlockingScheduleDialogObject().clickStartTimeLink());
		
		if (new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddRulePageObject().getInternetBlockingScheduleDialogObject().getDatePickerDialogObject().isAt())
			AssertJUnit.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddRulePageObject().getInternetBlockingScheduleDialogObject().getDatePickerDialogObject().clickOkButton());
		
		softcontrol16.assertAll();
		}
	
	@Test(priority = 17)
	public void Verify_Add_Custom_Schedule_Select_Stop_Time() {
		SoftAssert softcontrol17 = new SoftAssert();
		super.pause(65);
		AssertJUnit.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddRulePageObject().getInternetBlockingScheduleDialogObject().clickStopTimeLink());
		
		if (new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddRulePageObject().getInternetBlockingScheduleDialogObject().getDatePickerDialogObject().isAt()) 
			AssertJUnit.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddRulePageObject().getInternetBlockingScheduleDialogObject().getDatePickerDialogObject().clickOkButton());
		
		AssertJUnit.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddRulePageObject().getInternetBlockingScheduleDialogObject().clickSaveChangesButton());
		super.pause(3);
		
		softcontrol17.assertAll();
	}
	
	@Test(priority = 18)
	public void Verify_Enable_Schedule_Time_UI_Page() {
		SoftAssert softcontrol18 = new SoftAssert();
		AssertJUnit.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddRulePageObject().verifyUIonEnableScheduleTimePage());
		AssertJUnit.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddRulePageObject().clickBackButton());
		
		softcontrol18.assertAll();
	}
	
	@Test(priority = 19)
	public void Verify_Rules_Associated_With_User() {
		SoftAssert softcontrol19 = new SoftAssert();
		AssertJUnit.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().clickRuleListExpandButton());
//		softcontrol19.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().verifyRulesAssociatedWithUser());
		AssertJUnit.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().clickRuleListExpandButton());
		AssertJUnit.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().clickBackButton());
		
		softcontrol19.assertAll();
	}
	
//	@Test(priority = 20)
//	public void Verify_Pause_Internet_For_All_Users() {
//		SoftAssert softcontrol20 = new SoftAssert();
//		if(new ParentalControlWithProfilesPage().isAt()) {
//			softcontrol20.assertTrue(new ParentalControlWithProfilesPage().enablePauseInternetAccessForAllUserProfiles());
//			softcontrol20.assertTrue(new ParentalControlWithProfilesPage().verifyPauseInternetAccessForAllUserProfile());
//		}
//		softcontrol20.assertAll();
//	}
//	
//	@Test(priority = 21)
//	public void Verify_Currently_Blocked_Profiles() {
//		SoftAssert softcontrol21 = new SoftAssert();
//		softcontrol21.assertTrue(new ParentalControlWithProfilesPage().clickCurrentlyBlockedTab());
//
//		if(new ParentalControlWithProfilesPage().getParentalControlCurrentlyBlockedTabPageObject().isAt()) {
//			softcontrol21.assertTrue(new ParentalControlWithProfilesPage().getParentalControlCurrentlyBlockedTabPageObject().verifyInternetPausedUserProfiles());
//			softcontrol21.assertTrue(new ParentalControlWithProfilesPage().getParentalControlCurrentlyBlockedTabPageObject().clickProfilesTab());
//		}
//		softcontrol21.assertAll();
//	}
//	
//	@Test(priority = 22)
//	public void Verify_Resume_Internet_For_All_Users() {
//		SoftAssert softcontrol22 = new SoftAssert();
//		if(new ParentalControlWithProfilesPage().isAt()) {
//			softcontrol22.assertTrue(new ParentalControlWithProfilesPage().disablePauseInternetAccessForAllProfiles());
//			softcontrol22.assertTrue(new ParentalControlWithProfilesPage().verifyResumeInternetAccessForAllUserProfile());
//		}
//		softcontrol22.assertAll();
//	}
	
	@Test(priority = 23)
	public void Verify_Currently_Blocked_Users_After_Resuming_Internet_For_All_Users() {
		SoftAssert softcontrol23 = new SoftAssert();
		if(new ParentalControlWithProfilesPage().isAt())
			AssertJUnit.assertTrue(new ParentalControlWithProfilesPage().clickCurrentlyBlockedTab());
		
		if(new ParentalControlWithProfilesPage().getParentalControlCurrentlyBlockedTabPageObject().isAt()) {
			AssertJUnit.assertTrue(new ParentalControlWithProfilesPage().getParentalControlCurrentlyBlockedTabPageObject().verifyNoBlockedProfileMessages());
			AssertJUnit.assertTrue(new ParentalControlWithProfilesPage().getParentalControlCurrentlyBlockedTabPageObject().clickProfilesTab());
		}
		softcontrol23.assertAll();
	}
	
	@Test(priority = 24)
	public void Verify_Parental_Control_Help_Page() {
		SoftAssert softcontrol24 = new SoftAssert();
		if(new ParentalControlWithProfilesPage().isAt())
			AssertJUnit.assertTrue(new ParentalControlWithProfilesPage().clickHelpIcon());
		super.pause(3);
			
		if(new ParentalControlWithProfilesPage().getParentalHelpPageObject().isAt()) {
		//	softcontrol24.assertTrue(new ParentalControlWithProfilesPage().getParentalHelpPageObject().verifyUIOnParentalControlOverviewHelpPage());
			AssertJUnit.assertTrue(new ParentalControlWithProfilesPage().getParentalHelpPageObject().clickCloseButton());
			super.pause(3);
		}
		AssertJUnit.assertTrue(new ParentalControlWithProfilesPage().clickBackButton());

		softcontrol24.assertAll();
	}		
}