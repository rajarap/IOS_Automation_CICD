package com.cs.arris.Tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.lang.reflect.Method;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cs.arris.Base.ParentClass;
import com.cs.arris.Pages.AppRatingDialog;
import com.cs.arris.Pages.HomePage;
import com.cs.arris.Pages.NetworkPage;
import com.cs.arris.Pages.ParentalControlWithProfilesPage;
import com.cs.arris.Pages.SiginPage;
import com.cs.arris.Utilities.TestUtils;
import com.cs.arris.Workflows.HomePage_Workflow;
import com.cs.arris.Workflows.TC52_Login_And_Verify_HomePage_Workflow;
 


public class TC03_Complex_Test extends ParentClass
{
	TestUtils utils = new TestUtils();
	String firstName;
	String lastName;
	String email;
	String passCode;
	String ssid;
	String ssidpass;
	String udid;
	String countOfDeviceSignalStrength;
	String countOfDevicesSpeedHistory;
	String countOfDevicesBlocked;
	String downloadSpeed;
	String uploadSpeed;
	int totalCountOfDevices;
	
	//Parental Control
	public TC010_Login_And_Test_Parental_Control_Page getParentalControlPageTestObject() {
		TC010_Login_And_Test_Parental_Control_Page parentalPageTest = new TC010_Login_And_Test_Parental_Control_Page();
		return parentalPageTest;
	}
	
	//Network
	public TC011_Login_And_Test_Network_Page getNetworkTestObject() {
		TC011_Login_And_Test_Network_Page networkPageTest = new TC011_Login_And_Test_Network_Page();
		return networkPageTest;
	}
	
	 @BeforeClass
	 public void beforeClass() throws Exception 
	 {
		 try 
	   	  	{
			  String dataFileName = "testdata/signup";
			  utils.log().info("Loading...Sign Up Test Data");
			  super.loadTestData(dataFileName);
			  
			  this.firstName = properties.getProperty("firstname");
			  utils.log().info("First Name : " + this.firstName);

			  this.lastName = properties.getProperty("lastname");
			  utils.log().info("Last Name : " + this.lastName);
			  
			  this.email = properties.getProperty("email");
			  utils.log().info("Email address : " + this.email);
			  
			  this.udid = properties.getProperty("udid");
			  utils.log().info("UDID : " + this.udid);
			  
			  utils.log().info("Retrieved...Sign Up Test Data");
			} catch(Exception e) {
			 e.printStackTrace();
		} 
     }
	
		  @BeforeMethod
	  public void beforeMethod(Method m) 
	  {
		   utils.log().info("\n" + "\n" + "****** starting test : " + m.getName() + " ******" + "\n");
	  }
	  
	  @Test(priority = 1)
	  public void Login_And_Onboard()
	  {
//		  TC52_Login_And_Verify_HomePage_Workflow.getStartedPage(getStarted -> {
//			  getStarted.clickGetStartedButton();
//		  }).grantPermissionsPage(grantPermission -> {
//			  grantPermission.clickContinueButton();
//		  }).deviceLocationPage(deviceLocation -> {
//			  deviceLocation.clickOnlyThisTimeLink();
//		  }).accessResourcesOnDevicePage(accessResoucesOnDevice -> {
//			  super.pause(3);
//			  accessResoucesOnDevice.clickAllowLink();
//		  }).selectYourDevicePage(selectDevice -> {
//			  selectDevice.selectSurfboardMaxOption();
//			  selectDevice.clickNextButton();
//		  }).selectYourDevicePage2(selectDevice2 -> {
//			  selectDevice2.selectMaxProAX11000RadioButton();
//			  selectDevice2.clickNextButton();
//			  super.pause(3);
//		  }).welcomeSigninPage(signin -> {
//			  signin.enterEmailAddress(email);
//			  signin.clickSigninButton();
//			  super.pause(12);
//		  }).getOTPCode(getOTP -> {
//			  passCode = getOTP.getValidOTP();
//	  		}).enterOTPPage(otpverify -> {
//			  otpverify.enterValidPassCode(passCode);
//	  		 }).codeVerifiedPage(codeVerified -> {
//				  codeVerified.getCodeVerifiedText();
//				  codeVerified.clickNextButton();
//				  super.pause(3);
//				  try
//				  {
//					  if(codeVerified.continueOnBoardingButton.isDisplayed())
//					  {
//						  codeVerified.clickContinueOnboardingButton();
//					  }
//				  }catch(Exception e)
//				  {
//					  e.getMessage();
//				  }
//			  }).setupWifi(setupwifi ->{
//				  setupwifi.clickskipTutorialButton();
//				  super.pause(3);
//		  }).homePage(home -> {
//			  try
//			  {
//				  if(home.okButton.isDisplayed())
//				  {
//					  home.clickOkButton();
//				  }
//			  }catch(Exception e)
//			  {
//				  e.getMessage();
//			  }
//		  });
	  }
	  
	  @Test(priority = 2, dependsOnMethods = {"Login_And_Onboard" })
		public void Verify_Parental_Control_UI_Page() {
			utils.log().info("                                ");
			utils.log().info("********************************");
			utils.log().info("Test: Parental Control Feature  ");
			utils.log().info("********************************");
			SoftAssert softcontrol2 = new SoftAssert();
			softcontrol2.assertTrue(new HomePage().getFooterIconsPageObject().clickParentalButton());
			if(new ParentalControlWithProfilesPage().isAt())
				softcontrol2.assertTrue(new ParentalControlWithProfilesPage().verifyUIOnParentalControlProfilesPage());
			softcontrol2.assertAll();
		}
		
		@Test(priority = 3, dependsOnMethods = {"Login_And_Onboard" , "Verify_Parental_Control_UI_Page"})
		public void Verify_Add_Profile_Page() {
			SoftAssert softcontrol3 = new SoftAssert();
			
			if(new ParentalControlWithProfilesPage().isAt())
			try {
				softcontrol3.assertTrue(new ParentalControlWithProfilesPage().enableParentalControl());	
				super.pause(2);
				if(new ParentalControlWithProfilesPage().getAppRatingDialogObject().isAt())
					softcontrol3.assertTrue(new ParentalControlWithProfilesPage().getAppRatingDialogObject().clickRemindMeLaterLink());
			}catch(Exception e) {utils.log().info("App Rating Dialog did not appear");}
			super.pause(5);
			
			if(new ParentalControlWithProfilesPage().isAt()) {
				for(int i = 1; i <= 4; i++)	{
					softcontrol3.assertTrue(new ParentalControlWithProfilesPage().clickAddProfilesLink());
					super.pause(2);
					softcontrol3.assertTrue(new ParentalControlWithProfilesPage().getAddProfileDialogObject().enterProfileName());
					super.pause(2);
					softcontrol3.assertTrue(new ParentalControlWithProfilesPage().getAddProfileDialogObject().clickCreateProfileButton());
					super.pause(3);
					
					try {
						if(new ParentalControlWithProfilesPage().getAddProfileDialogObject().profileNameExists.isDisplayed())
							softcontrol3.assertTrue(new ParentalControlWithProfilesPage().getAddProfileDialogObject().clickCloseIcon());
						if(i == 4)
						{
							softcontrol3.assertTrue(new ParentalControlWithProfilesPage().clickAddProfilesLink());
							super.pause(2);
							softcontrol3.assertTrue(new ParentalControlWithProfilesPage().getAddProfileDialogObject().enterProfileName());
							super.pause(2);
							softcontrol3.assertTrue(new ParentalControlWithProfilesPage().getAddProfileDialogObject().clickCreateProfileButton());
							super.pause(3);
						}
					}catch(Exception e) {}
				}
			}
			
			softcontrol3.assertTrue(new ParentalControlWithProfilesPage().deleteUserProfile());
			super.pause(5);
			softcontrol3.assertTrue(new ParentalControlWithProfilesPage().verifyUIForGlobalSettingsOnProfilesPage());
			softcontrol3.assertTrue(new ParentalControlWithProfilesPage().verifyUserProfile());
			
			softcontrol3.assertAll();
		}
		
		@Test(priority = 4, dependsOnMethods = {"Login_And_Onboard" , "Verify_Parental_Control_UI_Page"})
		public void Verify_User_Profile_Page() {
			SoftAssert softcontrol4 = new SoftAssert();
			if(new ParentalControlWithProfilesPage().isAt())
				softcontrol4.assertTrue(new ParentalControlWithProfilesPage().clickOnUserProfile());
			super.pause(5);
			if(new ParentalControlWithProfilesPage().getUserProfilePageObject().isAt())
				softcontrol4.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().verifyUIOnUserProfilePage());
			
			softcontrol4.assertAll();
		}
		
		@Test(priority = 5, dependsOnMethods = {"Login_And_Onboard" , "Verify_User_Profile_Page"})
		public void Verify_User_Profile_Help_Page() {
			SoftAssert softcontrol5 = new SoftAssert();
			softcontrol5.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().clickHelpIcon());
			super.pause(3);
			
			if(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileHelpPageObject().isAt()){
				//softcontrol5.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileHelpPageObject().verifyUIOnUserProfilePage());
				softcontrol5.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileHelpPageObject().clickCloseButton());
			}
			
			softcontrol5.assertAll();
		}
		
		@Test(priority = 6, dependsOnMethods = {"Login_And_Onboard" , "Verify_User_Profile_Page"})
		public void Verify_Edit_User_Profile_Name() {
			SoftAssert softcontrol6 = new SoftAssert();
			softcontrol6.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().getExistingUserName());
			softcontrol6.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().clickUserProfileNameEditButton());
			
			if(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalEditUserProfileDialogObject().isAt()){
		//		softcontrol6.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalEditUserProfileDialogObject().verifyUIOnEditUserProfileDialog());
				softcontrol6.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalEditUserProfileDialogObject().enterUserProfileName());
				softcontrol6.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalEditUserProfileDialogObject().clickSaveButton());
				super.pause(3);
			}
			softcontrol6.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().validateUserProfileEditedName());
			softcontrol6.assertAll();
		}
		
		@Test(priority = 7, dependsOnMethods = {"Login_And_Onboard" , "Verify_User_Profile_Page"})
		public void Verify_Add_Device_To_User_Profile() {
			SoftAssert softcontrol7 = new SoftAssert();
			softcontrol7.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().clickAddDeviceLink());
			super.pause(25);
			if(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddDevicePageObject().isAt()) {
				softcontrol7.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddDevicePageObject().verifyDevicesInAddDevicePage());
				
				utils.log().info("Clicking on Add Device button without selecting any device");
				softcontrol7.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddDevicePageObject().clickAddDeviceButton());
				
				if(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddDevicePageObject().alertTitle.isDisplayed()) {
					utils.log().info("An Alert message - " + new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddDevicePageObject().alertTitle.getText()+ "  is displayed");
					//softcontrol7.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddDevicePageObject().clickCloseButtonOnAlertDialog());	
				}
				softcontrol7.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddDevicePageObject().selectADeviceForUserProfile());
				softcontrol7.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddDevicePageObject().clickAddDeviceButton());
				super.pause(5);
				softcontrol7.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().clickAddDeviceLink());
				super.pause(25);
				softcontrol7.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddDevicePageObject().selectADeviceForUserProfile());
				softcontrol7.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddDevicePageObject().clickAddDeviceButton());
				super.pause(5);
				//softcontrol7.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddDevicePageObject().verifyDeviceCountAfterAssociatingToUser());
			}
			
			softcontrol7.assertAll();
		}
		
		@Test(priority = 8, dependsOnMethods = {"Login_And_Onboard"})
		public void Verify_Add_Device_Help_Page() {
			SoftAssert softcontrol8 = new SoftAssert();
			softcontrol8.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().clickAddDeviceLink());
			super.pause(25);
			if(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddDevicePageObject().isAt()) 
				softcontrol8.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddDevicePageObject().clickHelpIcon());
			
			if (new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddDevicePageObject().getParentalAddDeviceHelpPageObject().isAt()) 
				softcontrol8.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddDevicePageObject().getParentalAddDeviceHelpPageObject().clickCloseButton());
			
			softcontrol8.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddDevicePageObject().clickBackButton());
			super.pause(5);
			softcontrol8.assertAll();
		}
		
		@Test(priority = 9, dependsOnMethods = {"Login_And_Onboard" , "Verify_User_Profile_Page"})
		public void Verify_Devices_Associated_With_User_Profile() {
			SoftAssert softcontrol9 = new SoftAssert();
			softcontrol9.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().clickDeviceListExpandButton());
		//	softcontrol9.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().verifyAssociatedDeviceList());
			softcontrol9.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().deleteAssociatedDevice());
			softcontrol9.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().clickDeviceListExpandButton());
			
			softcontrol9.assertAll();
		}
		
		@Test(priority = 10, dependsOnMethods = {"Login_And_Onboard" , "Verify_User_Profile_Page"})
		public void Verify_Add_Rule_Help_Page() {
			SoftAssert softcontrol10 = new SoftAssert();
			softcontrol10.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().clickAddRuleLink());
			
			if(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddRulePageObject().isAt()) {
				softcontrol10.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddRulePageObject().clickHelpIcon());
				softcontrol10.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddRulePageObject().getParentalAddRuleHelpPageObject().clickCloseButton());
				softcontrol10.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddRulePageObject().clickAddScheduleButton());}
				
			softcontrol10.assertAll();
		}
		
		@Test(priority = 11, dependsOnMethods = {"Login_And_Onboard" , "Verify_User_Profile_Page"})
		public void Verify_Add_EveryDay_Schedule_To_Rule() {
			SoftAssert softcontrol11 = new SoftAssert();
			if(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddRulePageObject().getInternetBlockingScheduleDialogObject().isAt()) 
			//	softcontrol11.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddRulePageObject().getInternetBlockingScheduleDialogObject().verifyUIOnAddInternetBlockingScheduleDialog());
			
			utils.log().info("                                  ");
			utils.log().info("Selecting same start and stop time");
			utils.log().info("----------------------------------");
			
			softcontrol11.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddRulePageObject().getInternetBlockingScheduleDialogObject().clickStartTimeLink());
			softcontrol11.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddRulePageObject().getInternetBlockingScheduleDialogObject().clickDoneButton());
			softcontrol11.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddRulePageObject().getInternetBlockingScheduleDialogObject().clickStopTimeLink());
			softcontrol11.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddRulePageObject().getInternetBlockingScheduleDialogObject().clickDoneButton());
			softcontrol11.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddRulePageObject().getInternetBlockingScheduleDialogObject().clickSaveChangesButton());
			
			if(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddRulePageObject().getInternetBlockingScheduleDialogObject().errorDescriptionForSameStartEndTime.isDisplayed()) 
				utils.log().info("Alert dialog with message - " + new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddRulePageObject().getInternetBlockingScheduleDialogObject().errorDescriptionForSameStartEndTime.getText() + " - is displayed");
			
			softcontrol11.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddRulePageObject().getInternetBlockingScheduleDialogObject().clickCloseButton());

			softcontrol11.assertAll();
		}
		
		@Test(priority = 12, dependsOnMethods = {"Login_And_Onboard" , "Verify_User_Profile_Page"})
		public void Verify_Select_Start_Time_For_EveryDay_Schedule() {
			SoftAssert softcontrol12 = new SoftAssert();
			if(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddRulePageObject().isAt()) 
				softcontrol12.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddRulePageObject().clickAddScheduleButton());
			
			if(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddRulePageObject().getInternetBlockingScheduleDialogObject().isAt()) {
				softcontrol12.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddRulePageObject().getInternetBlockingScheduleDialogObject().clickEveryDayButton());
				softcontrol12.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddRulePageObject().getInternetBlockingScheduleDialogObject().clickStartTimeLink());
				softcontrol12.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddRulePageObject().getInternetBlockingScheduleDialogObject().clickDoneButton());}
			
			softcontrol12.assertAll();
		}
		
		@Test(priority = 13, dependsOnMethods = {"Login_And_Onboard" , "Verify_User_Profile_Page"})
		public void Verify_Select_Stop_Time_For_EveryDay_Schedule() {
			SoftAssert softcontrol13 = new SoftAssert();
			softcontrol13.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddRulePageObject().getInternetBlockingScheduleDialogObject().clickStopTimeLink());
			super.pause(3);
			softcontrol13.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddRulePageObject().getInternetBlockingScheduleDialogObject().selectMinutes());
			super.pause(3);
			softcontrol13.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddRulePageObject().getInternetBlockingScheduleDialogObject().clickDoneButton());
			super.pause(3);
			softcontrol13.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddRulePageObject().getInternetBlockingScheduleDialogObject().clickSaveChangesButton());
			super.pause(3);

			softcontrol13.assertAll();
		}
		
		@Test(priority = 14, dependsOnMethods = {"Login_And_Onboard" , "Verify_User_Profile_Page"})  
		public void Verify_Add_Custom_Schedule_To_Rule() {
			SoftAssert softcontrol14 = new SoftAssert();
			if(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddRulePageObject().isAt()) {
				softcontrol14.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddRulePageObject().clickAddScheduleButton());
				softcontrol14.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddRulePageObject().getInternetBlockingScheduleDialogObject().clickCustomButton());
				softcontrol14.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddRulePageObject().getInternetBlockingScheduleDialogObject().verifyUIOnCustomClick());	}

			softcontrol14.assertAll();
		}
		
		@Test(priority = 15, dependsOnMethods = {"Login_And_Onboard" , "Verify_User_Profile_Page"})
		public void Verify_Add_Custom_Schedule_Select_DOW() {
			SoftAssert softcontrol15 = new SoftAssert();
			softcontrol15.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddRulePageObject().getInternetBlockingScheduleDialogObject().clickSunday());
			softcontrol15.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddRulePageObject().getInternetBlockingScheduleDialogObject().clickTuesday());
			softcontrol15.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddRulePageObject().getInternetBlockingScheduleDialogObject().clickThrusday());

			softcontrol15.assertAll();
			}
		
		@Test(priority = 16, dependsOnMethods = {"Login_And_Onboard" , "Verify_User_Profile_Page"})
		public void Verify_Add_Custom_Schedule_Select_Start_Time() {
			SoftAssert softcontrol16 = new SoftAssert();
			softcontrol16.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddRulePageObject().getInternetBlockingScheduleDialogObject().clickStartTimeLink());
			softcontrol16.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddRulePageObject().getInternetBlockingScheduleDialogObject().clickDoneButton());
			softcontrol16.assertAll();
			}
		
		@Test(priority = 17, dependsOnMethods = {"Login_And_Onboard" , "Verify_User_Profile_Page"})
		public void Verify_Add_Custom_Schedule_Select_Stop_Time() {
			SoftAssert softcontrol17 = new SoftAssert();
			softcontrol17.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddRulePageObject().getInternetBlockingScheduleDialogObject().clickStopTimeLink());
			super.pause(3);
			softcontrol17.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddRulePageObject().getInternetBlockingScheduleDialogObject().selectMinutes());
			super.pause(3);
			softcontrol17.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddRulePageObject().getInternetBlockingScheduleDialogObject().clickDoneButton());
			super.pause(3);
			softcontrol17.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddRulePageObject().getInternetBlockingScheduleDialogObject().clickSaveChangesButton());
			super.pause(3);
			
			softcontrol17.assertAll();
		}
		
		@Test(priority = 18, dependsOnMethods = {"Login_And_Onboard"})
		public void Verify_Enable_Schedule_Time_UI_Page() {
			SoftAssert softcontrol18 = new SoftAssert();

		//	new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddRulePageObject().verifyUIonEnableScheduleTimePage();
			softcontrol18.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddRulePageObject().clickBackButton());
			super.pause(5);
			softcontrol18.assertAll();
		}
		
		@Test(priority = 19, dependsOnMethods = {"Login_And_Onboard" , "Verify_User_Profile_Page"})
		public void Delete_Rules_Associated_With_User() {
			SoftAssert softcontrol19 = new SoftAssert();
			softcontrol19.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().clickRuleListExpandButton());
			//softcontrol19.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().verifyRulesAssociatedWithUser());
			softcontrol19.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().deleteAssociatedRulesList());
			softcontrol19.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().clickRuleListExpandButton());
			softcontrol19.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().clickBackButton());
			
			softcontrol19.assertAll();
		}
		
//		@Test(priority = 20, dependsOnMethods = {"Login_And_Onboard" , "Verify_Parental_Control_UI_Page"})
//		public void Verify_Pause_Internet_For_Selected_Users() {
//			SoftAssert softcontrol20 = new SoftAssert();
//			if(new ParentalControlWithProfilesPage().isAt()) 
//				softcontrol20.assertTrue(new ParentalControlWithProfilesPage().pauseInternetForSelectedUsers());
//			
//			softcontrol20.assertTrue(new ParentalControlWithProfilesPage().clickCurrentlyBlockedTab());
//
//			if(new ParentalControlWithProfilesPage().getParentalControlCurrentlyBlockedTabPageObject().isAt()) {
//				softcontrol20.assertTrue(new ParentalControlWithProfilesPage().getParentalControlCurrentlyBlockedTabPageObject().verifyInternetPausedUserProfiles());
//				softcontrol20.assertTrue(new ParentalControlWithProfilesPage().getParentalControlCurrentlyBlockedTabPageObject().clickProfilesTab());
//			}
//
//			softcontrol20.assertAll();
//		}
//		
//		@Test(priority = 21, dependsOnMethods = {"Login_And_Onboard" , "Verify_Parental_Control_UI_Page"})
//		public void Verify_Resume_Internet_For_Selected_Users() {
//			SoftAssert softcontrol21 = new SoftAssert();
//			
//			if(new ParentalControlWithProfilesPage().isAt()) 
//				softcontrol21.assertTrue(new ParentalControlWithProfilesPage().resumeInternetForSelectedUsers());
//			
//			softcontrol21.assertTrue(new ParentalControlWithProfilesPage().clickCurrentlyBlockedTab());
//
//			if(new ParentalControlWithProfilesPage().getParentalControlCurrentlyBlockedTabPageObject().isAt()) {
//				softcontrol21.assertTrue(new ParentalControlWithProfilesPage().getParentalControlCurrentlyBlockedTabPageObject().verifyInternetPausedUserProfiles());
//				softcontrol21.assertTrue(new ParentalControlWithProfilesPage().getParentalControlCurrentlyBlockedTabPageObject().clickProfilesTab());
//			}
//			softcontrol21.assertAll();
//		}
		
		@Test(priority = 22, dependsOnMethods = {"Login_And_Onboard" , "Verify_Parental_Control_UI_Page"})
		public void Verify_Pause_Internet_For_All_Users() {
			SoftAssert softcontrol20 = new SoftAssert();
			if(new ParentalControlWithProfilesPage().isAt()) {
				softcontrol20.assertTrue(new ParentalControlWithProfilesPage().clickGlobalSettingExpandButton());
				softcontrol20.assertTrue(new ParentalControlWithProfilesPage().enablePauseAllProfiles());
				softcontrol20.assertTrue(new ParentalControlWithProfilesPage().clickYesPauseInternetButton());
				super.pause(5);
//				softcontrol20.assertTrue(new ParentalControlWithProfilesPage().verifyPauseInternetAccessForAllUserProfile());
			}
			softcontrol20.assertAll();
		}
		
		@Test(priority = 23, dependsOnMethods = {"Login_And_Onboard" , "Verify_Parental_Control_UI_Page"})
		public void Verify_Currently_Blocked_Profiles() {
			SoftAssert softcontrol21 = new SoftAssert();
			softcontrol21.assertTrue(new ParentalControlWithProfilesPage().clickCurrentlyBlockedTab());

			if(new ParentalControlWithProfilesPage().getParentalControlCurrentlyBlockedTabPageObject().isAt()) {
				softcontrol21.assertTrue(new ParentalControlWithProfilesPage().getParentalControlCurrentlyBlockedTabPageObject().verifyInternetPausedUserProfiles());
				softcontrol21.assertTrue(new ParentalControlWithProfilesPage().getParentalControlCurrentlyBlockedTabPageObject().clickProfilesTab());
			}
			softcontrol21.assertAll();
		}
		
		@Test(priority = 24, dependsOnMethods = {"Login_And_Onboard" , "Verify_Parental_Control_UI_Page"})
		public void Verify_Resume_Internet_For_All_Users() {
			SoftAssert softcontrol22 = new SoftAssert();
			if(new ParentalControlWithProfilesPage().isAt()) {
				softcontrol22.assertTrue(new ParentalControlWithProfilesPage().disablePauseAllProfiles());
				softcontrol22.assertTrue(new ParentalControlWithProfilesPage().clickYesResumeInternetButton());
				super.pause(5);
//				softcontrol22.assertTrue(new ParentalControlWithProfilesPage().verifyResumeInternetAccessForAllUserProfile());
			}
			softcontrol22.assertAll();
		}
		
		@Test(priority = 25, dependsOnMethods = {"Login_And_Onboard" , "Verify_Parental_Control_UI_Page"})
		public void Verify_Currently_Blocked_Users_After_Resuming_Internet_For_All_Users() {
			SoftAssert softcontrol23 = new SoftAssert();
			if(new ParentalControlWithProfilesPage().isAt())
				softcontrol23.assertTrue(new ParentalControlWithProfilesPage().clickCurrentlyBlockedTab());
			
			if(new ParentalControlWithProfilesPage().getParentalControlCurrentlyBlockedTabPageObject().isAt()) {
				softcontrol23.assertTrue(new ParentalControlWithProfilesPage().getParentalControlCurrentlyBlockedTabPageObject().verifyNoBlockedProfileMessages());
				softcontrol23.assertTrue(new ParentalControlWithProfilesPage().getParentalControlCurrentlyBlockedTabPageObject().clickProfilesTab());
//				softcontrol23.assertTrue(new ParentalControlWithProfilesPage().clickGlobalSettingExpandButton());
				softcontrol23.assertTrue(new ParentalControlWithProfilesPage().disableParentalControl());
			}
			softcontrol23.assertAll();
		}
		
		@Test(priority = 26, dependsOnMethods = {"Login_And_Onboard" , "Verify_Parental_Control_UI_Page"})
		public void Verify_Parental_Control_Help_Page() {
			SoftAssert softcontrol24 = new SoftAssert();
			if(new ParentalControlWithProfilesPage().isAt())
				softcontrol24.assertTrue(new ParentalControlWithProfilesPage().clickHelpIcon());
			super.pause(3);
				
			if(new ParentalControlWithProfilesPage().getParentalHelpPageObject().isAt()) {
				softcontrol24.assertTrue(new ParentalControlWithProfilesPage().getParentalHelpPageObject().clickCloseButton());
				super.pause(3);
			}
			softcontrol24.assertTrue(new ParentalControlWithProfilesPage().getFooterIconsPageObject().clickHomeButton());

			softcontrol24.assertAll();
		}	
			
		
		@Test(priority = 27, dependsOnMethods = {"Login_And_Onboard"})
		public void Verify_Network_UI_Page() {
			utils.log().info("                          ");
			utils.log().info("**************************");
			utils.log().info("Test: Network Page Feature ");
			utils.log().info("***************************");
			SoftAssert softnet2 = new SoftAssert();
			softnet2.assertTrue(new HomePage().getFooterIconsPageObject().clickNetworkButton());
			super.pause(5);
			softnet2.assertTrue(new NetworkPage().clickNetworkSettingsExpandButton());
			softnet2.assertTrue(new NetworkPage().verifyUIOnNetworkPage());
			softnet2.assertAll();
		}

		@Test(priority = 28, dependsOnMethods = {"Login_And_Onboard", "Verify_Network_UI_Page"})
		public void Verify_Newtork_Help_Page() {
			SoftAssert softnet3 = new SoftAssert();
			softnet3.assertTrue(new NetworkPage().clickHelpButton());
			softnet3.assertTrue(new NetworkPage().getNetworkHelpPageObject().clickCloseButton());
			softnet3.assertAll();
		}

		@Test(priority = 29, dependsOnMethods = {"Login_And_Onboard", "Verify_Network_UI_Page"})
		public void Verify_Newtork_Test_Connection_Speed_Page() {
			SoftAssert softnet4 = new SoftAssert();
			softnet4.assertTrue(new NetworkPage().clickTestConnectionSpeedButton());
			softnet4.assertTrue(new NetworkPage().getSpeedTestPageObject().performSpeedTest());
			softnet4.assertTrue(new NetworkPage().getSpeedTestPageObject().clickBackButton());
			softnet4.assertAll();
		}

		@Test(priority = 30, dependsOnMethods = {"Login_And_Onboard", "Verify_Network_UI_Page"})
		public void Verify_WAN_Settings_UI_Page() {
			SoftAssert softnet5 = new SoftAssert();
//			softnet5.assertTrue(new NetworkPage().clickNetworkSettingsExpandButton());
//			super.swipeUp();
			AssertJUnit.assertTrue(new NetworkPage().clickWANSettings());
			
			try {
				if(new AppRatingDialog().isAt())
					new AppRatingDialog().clickRemindMeLaterLink();
			}catch(Exception e){utils.log().info("App Rating Dialog did not appear");}
				
			softnet5.assertTrue(new NetworkPage().getWANSettingsPageObject().verifyUIOnWANSettingsPage());

			softnet5.assertAll();
		}

		@Test(priority = 31, dependsOnMethods = {"Login_And_Onboard", "Verify_WAN_Settings_UI_Page"})
		public void Verify_WAN_Settings_Help_Page() {
			SoftAssert softnet6 = new SoftAssert();
			softnet6.assertTrue(new NetworkPage().getWANSettingsPageObject().clickHelpButton());
			if (new NetworkPage().getWANSettingsPageObject().getNetworkWanSettingsHelpPageObject().isAt())
				softnet6.assertTrue(new NetworkPage().getWANSettingsPageObject().getNetworkWanSettingsHelpPageObject().clickCloseButton());
			softnet6.assertAll();
		}

		@Test(priority = 32, dependsOnMethods = {"Login_And_Onboard", "Verify_WAN_Settings_UI_Page",})
		public void Verify_WAN_Settings_WAN_IP_Configuration_IPv4_DHCP_UI_Page() {
			SoftAssert softnet7 = new SoftAssert();
			new NetworkPage().getWANSettingsPageObject().clickWANIPConfigurationLink();
			if (new NetworkPage().getWANSettingsPageObject().getWANIPv4ConfigurationPageObject().isAt())
				softnet7.assertTrue(new NetworkPage().getWANSettingsPageObject().getWANIPv4ConfigurationPageObject().verifyUIOnWANIPv4DHCP());
			softnet7.assertAll();
		}

		@Test(priority = 33, dependsOnMethods = {"Login_And_Onboard", "Verify_WAN_Settings_UI_Page", "Verify_WAN_Settings_WAN_IP_Configuration_IPv4_DHCP_UI_Page"})
		public void Verify_WAN_Settings_WAN_IP_Configuration_IPv4_Static_UI_Page() {
			SoftAssert softnet8 = new SoftAssert();
			softnet8.assertTrue(new NetworkPage().getWANSettingsPageObject().getWANIPv4ConfigurationPageObject().verifyUIOnWANIPv4Static());
			softnet8.assertTrue(new NetworkPage().getWANSettingsPageObject().getWANIPv4ConfigurationPageObject().validationOnWANIPv4Static_MandatoryFields());
			softnet8.assertTrue(new NetworkPage().getWANSettingsPageObject().getWANIPv4ConfigurationPageObject().validationOnWANIPv4Static_InvalidWANIPAddress());
			softnet8.assertAll();
		}

		@Test(priority = 34, dependsOnMethods = {"Login_And_Onboard", "Verify_WAN_Settings_UI_Page", "Verify_WAN_Settings_WAN_IP_Configuration_IPv4_Static_UI_Page"})
		public void Verify_WAN_Settings_WAN_IP_Configuration_IPv6_Stateful_UI_Page() {
			SoftAssert softnet9 = new SoftAssert();
			softnet9.assertTrue(new NetworkPage().getWANSettingsPageObject().getWANIPv4ConfigurationPageObject().clickWANIPv6Tab());
			if (new NetworkPage().getWANSettingsPageObject().getWANIPv6ConfigurationPageObject().isAt())
				softnet9.assertTrue(new NetworkPage().getWANSettingsPageObject().getWANIPv6ConfigurationPageObject().verifyUIOnWANIPv6Stateful());
			softnet9.assertAll();
		}

		@Test(priority = 35, dependsOnMethods = {"Login_And_Onboard", "Verify_WAN_Settings_UI_Page", "Verify_WAN_Settings_WAN_IP_Configuration_IPv6_Stateful_UI_Page"})
		public void Verify_WAN_Settings_WAN_IP_Configuration_IPv6_Stateless_UI_Page() {
			SoftAssert softnet10 = new SoftAssert();
			softnet10.assertTrue(new NetworkPage().getWANSettingsPageObject().getWANIPv6ConfigurationPageObject().verifyUIOnWANIPv6Stateless());
//			softnet10.assertTrue(new NetworkPage().getWANSettingsPageObject().getWANIPv6ConfigurationPageObject().clickBackButton());
			softnet10.assertAll();
		}

		@Test(priority = 36, dependsOnMethods = {"Login_And_Onboard", "Verify_WAN_Settings_UI_Page", "Verify_WAN_Settings_WAN_IP_Configuration_IPv6_Stateful_UI_Page"})
		public void Verify_WAN_Settings_WAN_IP_Configuration_Help_Page() {
			SoftAssert softnet11 = new SoftAssert();
			new NetworkPage().getWANSettingsPageObject().getWANIPv6ConfigurationPageObject().clickHelpButton();
			if (new NetworkPage().getWANSettingsPageObject().getWANIPv6ConfigurationPageObject().getNetworkWANIPConfigurationHelpPageObject().isAt()) {
				softnet11.assertTrue(new NetworkPage().getWANSettingsPageObject().getWANIPv6ConfigurationPageObject().getNetworkWANIPConfigurationHelpPageObject().clickCloseButton());
				softnet11.assertTrue(new NetworkPage().getWANSettingsPageObject().getWANIPv6ConfigurationPageObject().clickBackButton());
				try {
					if(new AppRatingDialog().isAt())
						new AppRatingDialog().clickRemindMeLaterLink();
				}catch(Exception e){utils.log().info("App Rating Dialog did not appear");}
			}
			softnet11.assertAll();
		}
		
		@Test(priority = 37, dependsOnMethods = {"Login_And_Onboard", "Verify_WAN_Settings_UI_Page"})
		public void Verify_WAN_Settings_DNS_Configuration_IPv4_Automatic_UI_Page() 
		{
			SoftAssert softnet12 = new SoftAssert();
			softnet12.assertTrue(new NetworkPage().getWANSettingsPageObject().clickDNSConfigurationLink());
			if (new NetworkPage().getWANSettingsPageObject().getWANDNSIPv4ConfigurationPageObject().isAt()) 
				softnet12.assertTrue(new NetworkPage().getWANSettingsPageObject().getWANDNSIPv4ConfigurationPageObject().verifyUIOnDNSIPv4Automatic());
			softnet12.assertAll();
		}
		
		@Test(priority = 38, dependsOnMethods = {"Login_And_Onboard", "Verify_WAN_Settings_DNS_Configuration_IPv4_Automatic_UI_Page"})
		public void Verify_WAN_Settings_DNS_Configuration_IPv4_Static_UI_Page() 
		{
			SoftAssert softnet13 = new SoftAssert();
			softnet13.assertTrue(new NetworkPage().getWANSettingsPageObject().getWANDNSIPv4ConfigurationPageObject().verifyUIOnDNSIPv4Static());
//			softnet13.assertTrue(new NetworkPage().getWANSettingsPageObject().getWANDNSIPv4ConfigurationPageObject().validationOnWANIPv4Static_InvalidDNSIPAddress());
			softnet13.assertAll();
		}
		
		@Test(priority = 39, dependsOnMethods = {"Login_And_Onboard", "Verify_WAN_Settings_DNS_Configuration_IPv4_Static_UI_Page"})
		public void Verify_WAN_Settings_DNS_Configuration_IPv6_Automatic_UI_Page() 
		{
			SoftAssert softnet14 = new SoftAssert();
			softnet14.assertTrue(new NetworkPage().getWANSettingsPageObject().getWANDNSIPv4ConfigurationPageObject().clickDNSIPv6Tab());
			if (new NetworkPage().getWANSettingsPageObject().getWANDNSIPv6ConfigurationPageObject().isAt()) 
				softnet14.assertTrue(new NetworkPage().getWANSettingsPageObject().getWANDNSIPv6ConfigurationPageObject().verifyUIOnDNSIPv6Automatic());
			softnet14.assertAll();
		}
		
		@Test(priority = 40, dependsOnMethods = {"Login_And_Onboard", "Verify_WAN_Settings_DNS_Configuration_IPv6_Automatic_UI_Page"})
		public void Verify_WAN_Settings_DNS_Configuration_IPv6_Static_UI_Page() 
		{
			SoftAssert softnet15 = new SoftAssert();
			softnet15.assertTrue(new NetworkPage().getWANSettingsPageObject().getWANDNSIPv6ConfigurationPageObject().verifyUIOnDNSIPv6Static());
			softnet15.assertTrue(new NetworkPage().getWANSettingsPageObject().getWANDNSIPv6ConfigurationPageObject().clickBackButton());
			try{
				if(new NetworkPage().getAppRatingPageObject().isAt())
					new NetworkPage().getAppRatingPageObject().clickRemindMeLaterLink();
			}catch(Exception e) {
				utils.log().info("App Rating Dialog did not appear");}
		//	softnet15.assertTrue(new NetworkPage().getWANSettingsPageObject().clickBackButton());
			softnet15.assertAll();
		}
		
//		@Test(priority = 41, dependsOnMethods = {"Login_And_Onboard", "Verify_WAN_Settings_DNS_Configuration_IPv6_Static_UI_Page"})
//		public void Verify_WAN_Settings_DNS_Configuration_Help_Page() 
//		{
//			SoftAssert softnet16 = new SoftAssert();
//			softnet16.assertTrue(new NetworkPage().getWANSettingsPageObject().getWANDNSIPv6ConfigurationPageObject().clickHelpButton());
//			if (new NetworkPage().getWANSettingsPageObject().getWANDNSIPv6ConfigurationPageObject().getNetworkWANDNSConfigurationHelpPageObject().isAt())
//				softnet16.assertTrue(new NetworkPage().getWANSettingsPageObject().getWANDNSIPv6ConfigurationPageObject().getNetworkWANDNSConfigurationHelpPageObject().clickCloseButton());
//				softnet16.assertTrue(new NetworkPage().getWANSettingsPageObject().getWANDNSIPv6ConfigurationPageObject().clickBackButton());
//				try{
//					if(new NetworkPage().getAppRatingPageObject().isAt())
//						new NetworkPage().getAppRatingPageObject().clickRemindMeLaterLink();
//				}catch(Exception e) {
//					utils.log().info("App Rating Dialog did not appear");}
//				softnet16.assertTrue(new NetworkPage().getWANSettingsPageObject().getWANDNSIPv6ConfigurationPageObject().clickBackButton());
//				softnet16.assertAll();
//		}
		
		@Test(priority = 42, dependsOnMethods = {"Login_And_Onboard", "Verify_WAN_Settings_UI_Page"})
		public void Verify_WAN_Settings_LAC_Alert_Dialog() 
		{
			SoftAssert softnet17 = new SoftAssert();
			if (new NetworkPage().getWANSettingsPageObject().isAt()) 
				softnet17.assertTrue(new NetworkPage().getWANSettingsPageObject().clickLacInfoIcon());
				if(new NetworkPage().getWANSettingsPageObject().getLACAlertDialogObject().isAt())
					softnet17.assertTrue(new NetworkPage().getWANSettingsPageObject().getLACAlertDialogObject().clickCloseDialog());
				softnet17.assertTrue(new NetworkPage().getWANSettingsPageObject().clickBackButton());
			softnet17.assertAll();
		}
		
		@Test(priority = 43, dependsOnMethods = {"Login_And_Onboard"})
		public void Verify_LAN_Settings_UI_Page() 
		{
			SoftAssert softnet18 = new SoftAssert();
			if (new NetworkPage().isAt()) {
				//softnet18.assertTrue(new NetworkPage().clickNetworkSettingsExpandButton());
				//super.pause(3);
				softnet18.assertTrue(new NetworkPage().clickLANSettings());
				try{
					if(new NetworkPage().getAppRatingPageObject().isAt())
						new NetworkPage().getAppRatingPageObject().clickRemindMeLaterLink();
				}catch(Exception e) {
					utils.log().info("App Rating Dialog did not appear");
				}
			}
			softnet18.assertTrue(new NetworkPage().getLANSettingsPageObject().verifyUIOnLANSettingsPage());
			softnet18.assertAll();
		}
		
		@Test(priority = 44, dependsOnMethods = {"Login_And_Onboard", "Verify_LAN_Settings_UI_Page"})
		public void Verify_LAN_Settings_LAN_IP_Reservation_Page() 
		{
			SoftAssert softnet19 = new SoftAssert();
			softnet19.assertTrue(new NetworkPage().getLANSettingsPageObject().clickLANIPResevationLink());
			if(new NetworkPage().getLANSettingsPageObject().getNetworkLANIPReservationPageObject().isAt())
				softnet19.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANIPReservationPageObject().verifyUIOnNetworkLANIPReservationPage());
			softnet19.assertAll();
		}
		
		@Test(priority = 45, dependsOnMethods = {"Login_And_Onboard", "Verify_LAN_Settings_LAN_IP_Reservation_Page"})
		public void Verify_LAN_Settings_LAN_IP_Reservation_Add_Reservation_Page() 
		{
			SoftAssert softnet20 = new SoftAssert();
			new NetworkPage().getLANSettingsPageObject().getNetworkLANIPReservationPageObject().clickAddReservationButton();
			super.pause(10);
			new NetworkPage().getLANSettingsPageObject().getNetworkLANIPReservationPageObject().clickAddReservationButton();
			if(new NetworkPage().getLANSettingsPageObject().getNetworkLANIPReservationPageObject().getLANIPReservationDialogObject().isAt())
			{
			//	AssertJUnit.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANIPReservationPageObject().getLANIPReservationDialogObject().verifyUIOnReserveLANIP());
				softnet20.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANIPReservationPageObject().getLANIPReservationDialogObject().enterRuleName());
				softnet20.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANIPReservationPageObject().getLANIPReservationDialogObject().enterIPAddress());
				softnet20.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANIPReservationPageObject().getLANIPReservationDialogObject().selectADevice(1));
				softnet20.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANIPReservationPageObject().getLANIPReservationDialogObject().clickSaveButton());
				softnet20.assertAll();
			}
		}
		
		@Test(priority = 46, dependsOnMethods = {"Login_And_Onboard", "Verify_LAN_Settings_LAN_IP_Reservation_Add_Reservation_Page"})
		public void Verify_LAN_Settings_LAN_IP_Reservation_Rules() 
		{
			SoftAssert softnet21 = new SoftAssert();
			softnet21.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANIPReservationPageObject().verifyRulesOnLAPIPReservationPage());
			softnet21.assertAll();
		}
		
//		@Test(priority = 47, dependsOnMethods = {"Login_And_Onboard", "Verify_LAN_Settings_LAN_IP_Reservation_Rules"})
//		public void Verify_LAN_Settings_LAN_IP_Reservation_Edit_Page() 
//		{
//			SoftAssert softnet22 = new SoftAssert();
//			softnet22.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANIPReservationPageObject().clickEditLAPIPReservation());
//			if(new NetworkPage().getLANSettingsPageObject().getNetworkLANIPReservationPageObject().getEditLANIPReservationDialogObject().isAt())
//			{
//		//		AssertJUnit.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANIPReservationPageObject().getEditLANIPReservationDialogObject().verifyUIOnEditReserveLANIP());
//				softnet22.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANIPReservationPageObject().getEditLANIPReservationDialogObject().editRuleName());
//				super.pause(3);
//				softnet22.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANIPReservationPageObject().getEditLANIPReservationDialogObject().editIPAddress());
//				super.pause(3);
//				softnet22.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANIPReservationPageObject().getEditLANIPReservationDialogObject().clickSaveButton());
//			}
//			softnet22.assertAll();
//		}

		@Test(priority = 48, dependsOnMethods = {"Login_And_Onboard", "Verify_LAN_Settings_LAN_IP_Reservation_Page"})
		public void Verify_LAN_Settings_LAN_IP_Reservation_Help_Page() {
			SoftAssert softnet23 = new SoftAssert();
			softnet23.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANIPReservationPageObject().clickHelpButton());
			if (new NetworkPage().getLANSettingsPageObject().getNetworkLANIPReservationPageObject().getLanIPReservationHelpPageObject().isAt()) {
				softnet23.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANIPReservationPageObject().getLanIPReservationHelpPageObject().clickCloseButton());
				softnet23.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANIPReservationPageObject().clickBackButton());
			}
			softnet23.assertAll();
		}
		
		@Test(priority = 49, dependsOnMethods = {"Login_And_Onboard", "Verify_LAN_Settings_UI_Page"})
		public void Verify_LAN_Settings_LAN_Subnet_DHCP_Range_Configuration_Page() 
		{
			SoftAssert softnet24 = new SoftAssert();
			softnet24.assertTrue(new NetworkPage().getLANSettingsPageObject().clickLANSubnetLink());
			if(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().isAt()) {
				softnet24.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().verifyUIOnLANSubnetConfigurationPage());
				softnet24.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().verifyDHCPIPAddressRangeForSelectedSubnet());
			}
			softnet24.assertAll();
		}
		
		@Test(priority = 50, dependsOnMethods = {"Login_And_Onboard", "Verify_LAN_Settings_LAN_Subnet_DHCP_Range_Configuration_Page"})
		public void Verify_Edit_LAN_Subnet_DHCP_Range_Configuration_Page() 
		{
			SoftAssert softnet25 = new SoftAssert();
			
			softnet25.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().EditDHCPIPAddressRangeForFirstSubnet());
			softnet25.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().clickSaveButton());
			if(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().getLANDHCPChangeRangeIPDialogObject().isAt())
				softnet25.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().getLANDHCPChangeRangeIPDialogObject().clickCloseButton());
			
			softnet25.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().EditDHCPIPAddressRangeForSecondSubnet());
			softnet25.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().clickSaveButton());
			if(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().getLANDHCPChangeRangeIPDialogObject().isAt())
				softnet25.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().getLANDHCPChangeRangeIPDialogObject().clickCloseButton());
			
			softnet25.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().EditDHCPIPAddressRangeForThirdSubnet());
			softnet25.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().clickSaveButton());
			if(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().getLANDHCPChangeRangeIPDialogObject().isAt())
				softnet25.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().getLANDHCPChangeRangeIPDialogObject().clickCloseButton());
			
			softnet25.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().verifyLANDHCPRangeBetween1And255());
			softnet25.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().clickSaveButton());
			utils.log().info("Validation Message : " + new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().enterDHCPRangeBtw1And255.getText() + " is displayed");
			softnet25.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().verifyLANDHCPRangeBetween1And2552());
			
			softnet25.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().verifyLANDHCPRangeWithEmptySuffix());
			softnet25.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().clickSaveButton());
			utils.log().info("Validation Message : " + new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().enterValidDHCPRangeBtw1And255.getText() + " is displayed");
			softnet25.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().verifyLANDHCPRangeWithEmptySuffix2());
			
			softnet25.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().clickResetToDefaultButton());
			if(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().getLANDHCPChangeRangeIPDialogObject().isAt())
				softnet25.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().getLANDHCPChangeRangeIPDialogObject().clickCloseButton());

			softnet25.assertAll();
		}
		
		@Test(priority = 51, dependsOnMethods = {"Login_And_Onboard", "Verify_LAN_Settings_LAN_Subnet_DHCP_Range_Configuration_Page"})
		public void Edit_LAN_Subnet_Configuration_Octets() 
		{
			SoftAssert softnet26 = new SoftAssert();
			
			softnet26.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().verifyFirstLANSubnetConfigurationWithInvalidOctet());
			softnet26.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().clickSaveButton());
			utils.log().info("Validation Message : " + new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().enterValidIPAddressText1.getText() + " is displayed");
			
			softnet26.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().verifySecondLANSubnetConfigurationWithInvalidOctet());
			AssertJUnit.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().clickSaveButton());
			utils.log().info("Validation Message : " + new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().enterValidIPAddressText2.getText() + " is displayed");

			softnet26.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().verifyThirdLANSubnetConfigurationWithInvalidOctet());
			AssertJUnit.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().clickSaveButton());
			utils.log().info("Validation Message : " + new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().enterValidIPAddressText3.getText() + " is displayed");
			
			softnet26.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().verifyThirdLANSubnetConfigurationWithSecondInvalidOctet());
			softnet26.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().clickSaveButton());
			utils.log().info("Validation Message : " + new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().enterValidIPAddressTex16_31.getText() + " is displayed");
			
			softnet26.assertAll();
		}
		
		@Test(priority = 52, dependsOnMethods = {"Login_And_Onboard", "Verify_LAN_Settings_LAN_Subnet_DHCP_Range_Configuration_Page"})
		public void Verify_LAN_Settings_LAN_Subnet_DHCP_Range_Configuration_Help_Page() 
		{
			SoftAssert softnet27 = new SoftAssert();
			softnet27.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().clickHelpButton());
				if(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().getLANSubnetRangeHelpPageObject().isAt()) {
					softnet27.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().getLANSubnetRangeHelpPageObject().clickCloseButton());
					softnet27.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().clickBackButton());
				softnet27.assertAll();
			}
		}
		
		@Test(priority = 53, dependsOnMethods = {"Login_And_Onboard", "Verify_LAN_Settings_UI_Page"})
		public void Verify_LAN_Settings_LAN_DHCP_Lease_Time_UI_Page() 
		{
			SoftAssert softnet28 = new SoftAssert();	
				if(new NetworkPage().getLANSettingsPageObject().isAt())
					softnet28.assertTrue(new NetworkPage().getLANSettingsPageObject().clickDHCPLeaseTimeLink());
				if(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().isAt())
					softnet28.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().verifyUIOnLANLeaseTimePage());
				softnet28.assertAll();
		}
		
		@Test(priority = 54, dependsOnMethods = {"Login_And_Onboard", "Verify_LAN_Settings_LAN_DHCP_Lease_Time_UI_Page"})
		public void Verify_LAN_Settings_LAN_DHCP_Set_Lease_Time_Page() 
		{
			SoftAssert softnet29 = new SoftAssert();
			
			softnet29.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().clickTimeUnitButton());
			if(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().getEditTimeUnitPageObject().isAt()){
				softnet29.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().getEditTimeUnitPageObject().verifyUIOnLANEditLeaseTimePage());
				softnet29.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().getEditTimeUnitPageObject().clickCloseButton());}

			softnet29.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().clickTimeUnitButton());
			if(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().getEditTimeUnitPageObject().isAt())
				softnet29.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().getEditTimeUnitPageObject().clickMinutesRadioButton());
			softnet29.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().verifyLeaseTimeWithMinutesTimeUnit());
			if(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().getLeaseTimeAppliedChangesDialogObject().isAt())
				softnet29.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().getLeaseTimeAppliedChangesDialogObject().clickOKButton());
			
			softnet29.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().clickTimeUnitButton());
			if(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().getEditTimeUnitPageObject().isAt())
				softnet29.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().getEditTimeUnitPageObject().clickHourlyRadioButton());
			softnet29.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().verifyLeaseTimeWithHourlyTimeUnit());
			if(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().getLeaseTimeAppliedChangesDialogObject().isAt())
				softnet29.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().getLeaseTimeAppliedChangesDialogObject().clickOKButton());
			
			softnet29.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().clickTimeUnitButton());
			if(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().getEditTimeUnitPageObject().isAt())
				softnet29.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().getEditTimeUnitPageObject().clickDaysRadioButton());
			softnet29.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().verifyLeaseTimeWithDaysTimeUnit());
			if(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().getLeaseTimeAppliedChangesDialogObject().isAt())
				softnet29.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().getLeaseTimeAppliedChangesDialogObject().clickOKButton());
			
			softnet29.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().clickTimeUnitButton());
			if(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().getEditTimeUnitPageObject().isAt())
				softnet29.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().getEditTimeUnitPageObject().clickWeeklyRadioButton());
			softnet29.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().verifyLeaseTimeWithWeeklyTimeUnit());
			if(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().getLeaseTimeAppliedChangesDialogObject().isAt())
				softnet29.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().getLeaseTimeAppliedChangesDialogObject().clickOKButton());
			
//			softnet29.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().clickTimeUnitButton());
//			if(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().getEditTimeUnitPageObject().isAt())
//				softnet29.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().getEditTimeUnitPageObject().clickForeverRadioButton());
//			softnet29.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().verifyLeaseTimeWithForeverTimeUnit());
//			softnet29.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().clickSaveLeaseTimeButton());
//			if(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().getLeaseTimeAppliedChangesDialogObject().isAt())
//				softnet29.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().getLeaseTimeAppliedChangesDialogObject().clickOKButton());
			
			softnet29.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().clickTimeUnitButton());
			if(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().getEditTimeUnitPageObject().isAt())
				softnet29.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().getEditTimeUnitPageObject().clickMinutesRadioButton());
			softnet29.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().verifySameLeaseTimeForAnyUnit());
			if(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().getLeaseTimeAppliedChangesDialogObject().isAt())
				softnet29.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().getLeaseTimeAppliedChangesDialogObject().clickOKButton());
			
			softnet29.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().clickBackButton());
			try{
				if(new NetworkPage().getAppRatingPageObject().isAt())
					new NetworkPage().getAppRatingPageObject().clickRemindMeLaterLink();
			}catch(Exception e) {
				utils.log().info("App Rating Dialog did not appear");
				}
			AssertJUnit.assertTrue(new NetworkPage().getLANSettingsPageObject().clickBackButton());
			
			softnet29.assertAll();
		}
		
//		@Test(priority = 55, dependsOnMethods = {"Login_And_Onboard", "Verify_LAN_Settings_LAN_DHCP_Lease_Time_UI_Page"})
//		public void Verify_LAN_Settings_LAN_DHCP_Set_Lease_Time_Help_Page() 
//		{
//			SoftAssert softnet30 = new SoftAssert();
//			softnet30.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().clickHelpButton());
//			if(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().getLANDHCPLeaseTimeHelpPageObject().isAt())
//				softnet30.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().getLANDHCPLeaseTimeHelpPageObject().clickCloseButton());
//				softnet30.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().clickBackButton());
//				try{
//					if(new NetworkPage().getAppRatingPageObject().isAt())
//						new NetworkPage().getAppRatingPageObject().clickRemindMeLaterLink();
//				}catch(Exception e) {
//					utils.log().info("App Rating Dialog did not appear");
//					}
//				softnet30.assertTrue(new NetworkPage().getLANSettingsPageObject().clickBackButton());
//				softnet30.assertAll();
//		}
		
		@Test(priority = 56, dependsOnMethods = {"Login_And_Onboard", "Verify_LAN_Settings_UI_Page"})
		public void Verify_Device_Priority_Settings_UI_Page() 
		{
			SoftAssert softnet31 = new SoftAssert();
			softnet31.assertTrue(new NetworkPage().clickDevicePrioritySettings());
			try{
				if(new NetworkPage().getAppRatingPageObject().isAt())
					new NetworkPage().getAppRatingPageObject().clickRemindMeLaterLink();
			}catch(Exception e) {
				utils.log().info("App Rating Dialog did not appear");
			}
			
			if(new NetworkPage().getNetworkDevicePrioritySettingsPageObject().isAt())
			{
				softnet31.assertTrue(new NetworkPage().getNetworkDevicePrioritySettingsPageObject().enableDevicePrioritySettings());
				try{
					if(new NetworkPage().getAppRatingPageObject().isAt())
						new NetworkPage().getAppRatingPageObject().clickRemindMeLaterLink();
				}catch(Exception e) {
					utils.log().info("App Rating Dialog did not appear");
				}
				
				softnet31.assertTrue(new NetworkPage().getNetworkDevicePrioritySettingsPageObject().verifyUIOnDevicePrioritySettingsPage());
				softnet31.assertTrue(new NetworkPage().getNetworkDevicePrioritySettingsPageObject().clickAddDeviceButton());
				super.pause(25);
			}
			softnet31.assertAll();
		}
		
		@Test(priority = 57, dependsOnMethods = {"Login_And_Onboard", "Verify_Device_Priority_Settings_UI_Page"})
		public void Verify_Device_Priority_Settings_Add_Device_UI_Page() 
		{
			SoftAssert softnet32 = new SoftAssert();
			if(new NetworkPage().getNetworkDevicePrioritySettingsPageObject().getAddDevicePriorityPageObject().isAt()) {
				softnet32.assertTrue(new NetworkPage().getNetworkDevicePrioritySettingsPageObject().getAddDevicePriorityPageObject().verifyUIOnAddDevicePage());
				softnet32.assertAll();
			}
		}
		
		@Test(priority = 58, dependsOnMethods = {"Login_And_Onboard", "Verify_Device_Priority_Settings_Add_Device_UI_Page"})
		public void Verify_Device_Priority_Settings_Add_Device_Page() 
		{
			SoftAssert softnet33 = new SoftAssert();
			softnet33.assertTrue(new NetworkPage().getNetworkDevicePrioritySettingsPageObject().getAddDevicePriorityPageObject().verifyDeviceListForPrioritization());
			utils.log().info("Clicking on Add Device button without selecting a device ");
			softnet33.assertTrue(new NetworkPage().getNetworkDevicePrioritySettingsPageObject().getAddDevicePriorityPageObject().clickAddDeviceButton());
			
			if(new NetworkPage().getNetworkDevicePrioritySettingsPageObject().getAddDevicePriorityPageObject().addDeviceErrorMessage.isDisplayed())
				utils.log().info(new NetworkPage().getNetworkDevicePrioritySettingsPageObject().getAddDevicePriorityPageObject().addDeviceErrorMessage.getText() + " error message is displayed");

			softnet33.assertTrue(new NetworkPage().getNetworkDevicePrioritySettingsPageObject().getAddDevicePriorityPageObject().selectDeviceFromList());
			softnet33.assertTrue(new NetworkPage().getNetworkDevicePrioritySettingsPageObject().getAddDevicePriorityPageObject().clickAddDeviceButton());
			super.pause(3);
			
			softnet33.assertTrue(new NetworkPage().getNetworkDevicePrioritySettingsPageObject().clickAddDeviceButton());
			super.pause(25);
			softnet33.assertTrue(new NetworkPage().getNetworkDevicePrioritySettingsPageObject().getAddDevicePriorityPageObject().selectDeviceFromList());
			softnet33.assertTrue(new NetworkPage().getNetworkDevicePrioritySettingsPageObject().getAddDevicePriorityPageObject().clickAddDeviceButton());
			super.pause(5);

			softnet33.assertAll();
		}

		@Test(priority = 59, dependsOnMethods = {"Login_And_Onboard", "Verify_Device_Priority_Settings_Add_Device_Page"})
		public void Verify_Device_Priority_Settings_Added_Device_Page() 
		{
			SoftAssert softnet34 = new SoftAssert();
			if(new NetworkPage().getNetworkDevicePrioritySettingsPageObject().isAt())
			{
				softnet34.assertTrue(new NetworkPage().getNetworkDevicePrioritySettingsPageObject().verifyUIOnNetworkPrioritizedDevices());
				softnet34.assertTrue(new NetworkPage().getNetworkDevicePrioritySettingsPageObject().verifyTwoDevicesWithHighestPriority());
				
				if(new NetworkPage().getNetworkDevicePrioritySettingsPageObject().getAddedTwoHighestPriorityDevicesDialogObject().isAt())
					softnet34.assertTrue(new NetworkPage().getNetworkDevicePrioritySettingsPageObject().getAddedTwoHighestPriorityDevicesDialogObject().clickOkButton());
				super.pause(3);
			}
			softnet34.assertAll();
		}
		
		@Test(priority = 60, dependsOnMethods = {"Login_And_Onboard", "Verify_Device_Priority_Settings_Add_Device_Page"})
		public void Verify_Device_Priority_Settings_Add_Device_Help_Page() 
		{
			SoftAssert softnet35 = new SoftAssert();
			softnet35.assertTrue(new NetworkPage().getNetworkDevicePrioritySettingsPageObject().clickAddDeviceButton());
			softnet35.assertTrue(new NetworkPage().getNetworkDevicePrioritySettingsPageObject().getAddDevicePriorityPageObject().clickHelpButton());
			
			if(new NetworkPage().getNetworkDevicePrioritySettingsPageObject().getAddDevicePriorityPageObject().getAddDevicePriorityHelpPageObject().isAt())
				softnet35.assertTrue(new NetworkPage().getNetworkDevicePrioritySettingsPageObject().getAddDevicePriorityPageObject().getAddDevicePriorityHelpPageObject().clickCloseButton());
			
			softnet35.assertTrue(new NetworkPage().getNetworkDevicePrioritySettingsPageObject().getAddDevicePriorityPageObject().clickBackButton());
			softnet35.assertAll();
		}
		
		@Test(priority = 61, dependsOnMethods = {"Login_And_Onboard", "Verify_Device_Priority_Settings_UI_Page"})
		public void Verify_Device_Priority_Settings_Help_Page() 
		{
			SoftAssert softnet36 = new SoftAssert();
			softnet36.assertTrue(new NetworkPage().getNetworkDevicePrioritySettingsPageObject().clickHelpButton());
			
			if(new NetworkPage().getNetworkDevicePrioritySettingsPageObject().getDevicePriorityHelpPageObject().isAt())
				softnet36.assertTrue(new NetworkPage().getNetworkDevicePrioritySettingsPageObject().getDevicePriorityHelpPageObject().clickCloseButton());
			
			softnet36.assertTrue(new NetworkPage().getNetworkDevicePrioritySettingsPageObject().clickBackButton());
			softnet36.assertAll();
		}
		
		@Test(priority = 62, dependsOnMethods = {"Login_And_Onboard", "Verify_Network_UI_Page"})
		public void Verify_Time_Zone_Settings_UI_Page() 
		{
			SoftAssert softnet37 = new SoftAssert();
			super.swipeUp();
			softnet37.assertTrue(new NetworkPage().clickTimeZone());
			if(new NetworkPage().getTimeZoneSettingsPageObject().isAt())
				softnet37.assertTrue(new NetworkPage().getTimeZoneSettingsPageObject().verifyUIOnTimeZonePage());
			softnet37.assertTrue(new NetworkPage().getTimeZoneSettingsPageObject().clickAtlanticTimeZone());
			softnet37.assertTrue(new NetworkPage().getTimeZoneSettingsPageObject().clickSaveButton());
			softnet37.assertAll();
		}
		
		@Test(priority = 63, dependsOnMethods = {"Login_And_Onboard", "Verify_Time_Zone_Settings_UI_Page"})
		public void Verify_Time_Zone_Settings_Help_Page() 
		{
			SoftAssert softnet38 = new SoftAssert();
			softnet38.assertTrue(new NetworkPage().clickTimeZone());
			softnet38.assertTrue(new NetworkPage().getTimeZoneSettingsPageObject().clickHelpButton());
			if (new NetworkPage().getTimeZoneSettingsPageObject().getTimeZoneHelpPageObject().isAt())
				softnet38.assertTrue(new NetworkPage().getTimeZoneSettingsPageObject().getTimeZoneHelpPageObject().clickCloseButton());
			softnet38.assertTrue(new NetworkPage().getTimeZoneSettingsPageObject().clickBackButton());
			softnet38.assertAll();
		}
		
		@Test(priority = 64, dependsOnMethods = {"Login_And_Onboard", "Verify_Network_UI_Page"})
		public void Verify_General_Settings_UI_Page() 
		{
			SoftAssert softnet39 = new SoftAssert();
			new NetworkPage().clickGeneralSettings(); 
			try{
				if(new NetworkPage().getAppRatingPageObject().isAt())
					new NetworkPage().getAppRatingPageObject().clickRemindMeLaterLink();
			}catch(Exception e) {}
			
			softnet39.assertTrue(new NetworkPage().getGeneralSettingsPageObject().verifyUIOnGeneralSettingsPage());
			softnet39.assertAll();
		}
		
		@Test(priority = 65, dependsOnMethods = {"Login_And_Onboard", "Verify_General_Settings_UI_Page"})
		public void Verify_General_Settings_UPnP_Settings() 
		{
			SoftAssert softnet40 = new SoftAssert();
			softnet40.assertTrue(new NetworkPage().getGeneralSettingsPageObject().disableUPnP());
			
			try{
				if(new NetworkPage().getAppRatingPageObject().isAt())
					new NetworkPage().getAppRatingPageObject().clickRemindMeLaterLink();
			}catch(Exception e) {
				utils.log().info("App Rating Dialog did not appear");
			}
			
			softnet40.assertTrue(new NetworkPage().getGeneralSettingsPageObject().enableUPnP());
			super.pause(15);
			softnet40.assertTrue(new NetworkPage().getGeneralSettingsPageObject().clickUPNPInfoIcon());
			
			if(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsUPnPInfoDialogObject().isAt())
				softnet40.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsUPnPInfoDialogObject().clickCloseButton());
			softnet40.assertAll();
		}
		
		@Test(priority = 66, dependsOnMethods = {"Login_And_Onboard", "Verify_General_Settings_UI_Page"})
		public void Verify_General_Settings_IPv6_Enable_Settings() 
		{
			SoftAssert softnet39 = new SoftAssert();
			softnet39.assertTrue(new NetworkPage().getGeneralSettingsPageObject().clickIPv6InfoIcon());
			if(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsIPv6EnableInfoDialogObject().isAt())
				softnet39.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsIPv6EnableInfoDialogObject().clickCloseButton());
			softnet39.assertAll();
		}
		
		@Test(priority = 67, dependsOnMethods = {"Login_And_Onboard", "Verify_General_Settings_UI_Page"})
		public void Verify_General_Settings_Bridge_Mode_Settings() 
		{
			SoftAssert softnet42 = new SoftAssert();
			softnet42.assertTrue(new NetworkPage().getGeneralSettingsPageObject().clickBridgeModeInfoIcon());
			
			if(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsBridgeModeInfoDialogObject().isAt())
				softnet42.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsBridgeModeInfoDialogObject().clickCloseButton());
			softnet42.assertAll();
		}
		
		@Test(priority = 68, dependsOnMethods = {"Login_And_Onboard", "Verify_General_Settings_UI_Page"})
		public void Verify_General_Settings_Port_Forwarding_Settings() 
		{
			SoftAssert softnet43 = new SoftAssert();
			new NetworkPage().getGeneralSettingsPageObject().clickPortForwardingink();
			if(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().isAt())
				softnet43.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().verifyUIOnPortForwardingPage());
			softnet43.assertAll();
		}
		
		@Test(priority = 69, dependsOnMethods = {"Login_And_Onboard", "Verify_General_Settings_Port_Forwarding_Settings"})
		public void Verify_General_Settings_Port_Forwarding_Add_Rule_Settings_Page() 
		{
			SoftAssert softnet44 = new SoftAssert();
			new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().clickAddRuleButton();
			if(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().isAt())
			{
				//super.getDriver().hideKeyboard();
				softnet44.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().verifyUIOnPortForwardingAddRulePage());
				softnet44.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().clickCloseButton());
			}
			softnet44.assertAll();
		}
		
		@Test(priority = 70, dependsOnMethods = {"Login_And_Onboard", "Verify_General_Settings_Port_Forwarding_Settings"})
		public void Verify_General_Settings_Port_Forwarding_Add_Rules() 
		{
			SoftAssert softnet45 = new SoftAssert();
//			if(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().isAt()) 
//			{
			for(int i = 1 ; i <=3 ; i++)
			{
				softnet45.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().clickAddRuleButton());
				softnet45.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().enterPortRuleName());
				softnet45.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().selectTCP());
				softnet45.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().enterInternalPortStart());
				softnet45.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().enterInternalPortEnd());
				softnet45.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().enterExternalPortStart());
				softnet45.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().enterExternalPortEnd());
				softnet45.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().enterIPAddress());
				softnet45.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().clickSaveButton());
				
				try {
				if(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().allFieldsAreMandatoryError.isDisplayed()) {
					softnet45.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().enterPortRuleName());
					softnet45.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().clickSaveButton());}
					}catch(Exception e) {}
					
				try {
					if(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().internalPortStartError.isDisplayed()) {
						softnet45.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().enterInternalPortStart());
						softnet45.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().clickSaveButton());}
					}catch(Exception e) {}
					
				try {
					if(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().internalPortEndError.isDisplayed()) {
						softnet45.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().enterInternalPortEnd());
						softnet45.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().clickSaveButton());}
					}catch(Exception e) {}
						
				try {
					if(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().externalPortStartError.isDisplayed()) {
						softnet45.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().enterExternalPortStart());
						softnet45.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().clickSaveButton());}
					}catch(Exception e) {}
					
				try {
					if(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().externalPortEndError.isDisplayed()) {
						softnet45.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().enterExternalPortEnd());
						softnet45.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().clickSaveButton());}
					}catch(Exception e) {}
					
					utils.log().info("All Port details are valid");
					softnet45.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().clickSaveButton());
					super.pause(15);
					
				try {
					if(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().getPortRuleEditFailedDialogObject().isAt()) 
						softnet45.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject()
								.getPortRuleEditFailedDialogObject().clickOKButton());
					}catch(Exception e) {
							utils.log().info("Port Rule Edit Failed Dialog did not appear");
					}
			}
			softnet45.assertAll();
		}
	

		@Test(priority = 71)
		public void Verify_General_Settings_Port_Forwarding_Edit_Rules() 
		{
			SoftAssert softnet46 = new SoftAssert();
			if(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().isAt()) 
			{
				softnet46.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().clickEditPortFowardingRuleIcon());
				softnet46.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().enterPortRuleName());
				softnet46.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().selectUDP());
				softnet46.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().enterInternalPortStart());
				softnet46.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().enterInternalPortEnd());
				softnet46.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().enterExternalPortStart());
				softnet46.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().enterExternalPortEnd());
				softnet46.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().enterIPAddress());
				softnet46.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().clickSaveButton());

					try {
					if(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().allFieldsAreMandatoryError.isDisplayed())
						softnet46.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().enterPortRuleName());
					}catch(Exception e) {}
					
					try {
					 if(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().internalPortStartError.isDisplayed())
						 softnet46.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().enterInternalPortStart());
					}catch(Exception e) {}
					
					try {
					 if(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().internalPortEndError.isDisplayed())
						 softnet46.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().enterInternalPortEnd());
					}catch(Exception e) {}
					
					try {
					if(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().externalPortStartError.isDisplayed())
						softnet46.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().enterExternalPortStart());
					}catch(Exception e) {}
				
					try {
						if(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().externalPortEndError.isDisplayed())
							softnet46.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().enterExternalPortEnd());
					}catch(Exception e) {}

					utils.log().info("All Port details are valid");
					softnet46.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().clickSaveButton());
				
				super.pause(15);
				try {
					if(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().getPortRuleEditFailedDialogObject().isAt()) 
						softnet46.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject()
							.getPortRuleEditFailedDialogObject().clickOKButton());
					}catch(Exception e) {utils.log().info("Port Rule Edit Failed Dialog did not appear");}
			}
			softnet46.assertAll();
		}
////
////		@Test(priority = 72)
////		public void Verify_General_Settings_Port_Forwarding_Add_Rule_Settings_Validations() 
////		{
////			SoftAssert softnet47 = new SoftAssert();
////			new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().clickAddRuleButton();
////			if(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().isAt())
////			{
////				softnet47.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().verifyEnterPortForwardingRuleName());
////				softnet47.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().verifyEnterInternalPortStart());
////				softnet47.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().verifyEnterInternalPortEnd());
////				softnet47.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().verifyInternalPortStartLessThenPortEnd());
////				softnet47.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().verifyEnterExternalPortStart());
////				softnet47.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().verifyEnterExternalPortEnd());
////				softnet47.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().verifyExternalPortStartLessThenPortEnd());
////				softnet47.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().verifyEnterValidIPAddress());
////				softnet47.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().verifyEnterInValidIPAddress());
////				softnet47.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().clickSaveButton());
////				try {
////					if(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().portNameDialogError.isDisplayed())
////						softnet47.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().enterPortRuleName());
////					else if(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().internalPortStartError.isDisplayed())
////						softnet47.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().enterInternalPortStart());
////					else if(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().internalPortEndError.isDisplayed())
////						softnet47.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().enterInternalPortEnd());
////					else if(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().externalPortStartError.isDisplayed())
////						softnet47.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().enterExternalPortStart());
////					else if(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().externalPortEndError.isDisplayed())
////						softnet47.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().enterExternalPortEnd());
////					else
////						utils.log().info("All Port details are valid");
////					softnet47.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().clickSaveButton());
////				}catch(Exception e) {utils.log().info("All Port details are valid");}
////				
////				super.pause(20);
////				try {
////				if(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().getPortRuleEditFailedDialogObject().isAt()) 
////					softnet47.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject()
////							.getPortRuleEditFailedDialogObject().clickOKButton());
////					}catch(Exception e) {utils.log().info("Port Rule Edit Failed Dialog did not appear");}
////			}
////			softnet47.assertAll();
////		}
//		
		@Test(priority = 73, dependsOnMethods = {"Login_And_Onboard", "Verify_General_Settings_Port_Forwarding_Settings"})
		public void Verify_General_Settings_Port_Forwarding_Help_Page() 
		{
			SoftAssert softnet48 = new SoftAssert();
			softnet48.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().clickHelpButton());
			if(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingHelpPageObject().isAt())
				softnet48.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingHelpPageObject().clickCloseButton());
			
			softnet48.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().clickBackButton());
			try{
				if(new NetworkPage().getAppRatingPageObject().isAt())
					new NetworkPage().getAppRatingPageObject().clickRemindMeLaterLink();
			}catch(Exception e) {
				utils.log().info("App Rating Dialog did not appear");
			}
			softnet48.assertTrue(new NetworkPage().getGeneralSettingsPageObject().clickBackButton());
			softnet48.assertTrue(new NetworkPage().clickNetworkSettingsExpandButton());
			softnet48.assertAll();
		}
		
		@Test(priority = 74, dependsOnMethods = {"Login_And_Onboard"})
		public void Verify_Existing_Guest_WiFi_Network() 
		{
			SoftAssert softnet49 = new SoftAssert();
			try {
				if (new NetworkPage().guestNetworkExpandIcon.isDisplayed())
					new NetworkPage().verifyGuestWifiNetwork();
				}catch(Exception e) {utils.log().info("Guest Wifi Network is not created");}
		}
		
		
		@Test(priority = 75, dependsOnMethods = {"Login_And_Onboard"})
		public void Verify_New_Guest_WiFi_Network() 
		{
			SoftAssert softnet49 = new SoftAssert();
			
			if(new NetworkPage().isGuestWifiDisabled()) 
			{
				softnet49.assertTrue(new NetworkPage().enableGuestWifiNetwork());
				try {
					if(new NetworkPage().getEnableGuestNetworkAlertDialogObject().isAt())
						softnet49.assertTrue(new NetworkPage().getEnableGuestNetworkAlertDialogObject().clickOkButton());
					super.pause(40);
					
					if(new NetworkPage().joinButton.isDisplayed())
						softnet49.assertTrue(new NetworkPage().clickJoinButton());
					super.pause(15);
				}catch(Exception e) {}
					
				try {
					if(new NetworkPage().getEnableGuestNetworkDialogObject().isAt()) {
						softnet49.assertTrue(new NetworkPage().getEnableGuestNetworkDialogObject().verifyUIOnGuestNetworkPage());
						softnet49.assertTrue(new NetworkPage().getEnableGuestNetworkDialogObject().enterGuestNetworkName());
						softnet49.assertTrue(new NetworkPage().getEnableGuestNetworkDialogObject().enterGuestNetworkPassword());
						softnet49.assertTrue(new NetworkPage().getEnableGuestNetworkDialogObject().clickSaveChangesButton());
						
						if(new NetworkPage().getEnableGuestNetworkAlertDialogObject().isAt())
							softnet49.assertTrue(new NetworkPage().getEnableGuestNetworkAlertDialogObject().clickOkButton());
						}
						super.pause(30);
					}catch(Exception e) {utils.log().info("Enable Guest Network Page did not appear");}
					
					try {
						if(new NetworkPage().guestNetworkExpandIcon.isDisplayed()) {
							softnet49.assertTrue(new NetworkPage().clickGuestNetworkExpandButton());
							softnet49.assertTrue(new NetworkPage().clickGuestNetworkEditdButton());
								if(new NetworkPage().getEditGuestNetworkDialogObject().isAt()) {
									softnet49.assertTrue(new NetworkPage().getEditGuestNetworkDialogObject().createGuestNetwork());
									softnet49.assertTrue(new NetworkPage().getEditGuestNetworkDialogObject().clickSaveChangesButton()); 
									try {
										if(new NetworkPage().getEnableGuestNetworkAlertDialogObject().isAt())
											softnet49.assertTrue(new NetworkPage().getEnableGuestNetworkAlertDialogObject().clickOkButton());
										super.pause(35);
										if(new NetworkPage().joinButton.isDisplayed()) {
											softnet49.assertTrue(new NetworkPage().clickJoinButton());
										super.pause(20);}
									}catch(Exception e) {utils.log().info("Guest Network Alert dialog did not appear");}
								}
							softnet49.assertTrue(new NetworkPage().clickGuestNetworkExpandButton());}
					}catch(Exception e) {utils.log().info("Guest Network is not Created");}
			}

			softnet49.assertAll();
		}
		
		@Test(priority = 76, dependsOnMethods = {"Login_And_Onboard", "Verify_Network_UI_Page"})
		public void Verify_Extended_WiFi_Settings_Page() 
		{
			SoftAssert softnet50 = new SoftAssert();
			softnet50.assertTrue(new NetworkPage().clickExtendedWifiSettingsExpandButton());
			
			softnet50.assertTrue(new NetworkPage().enable5GHzWidebandMode());
			try {
				if(new NetworkPage().get5GHzWidebandModeAlertDialogObject().isAt())
					softnet50.assertTrue(new NetworkPage().get5GHzWidebandModeAlertDialogObject().clickOKButton());
					super.pause(15);
			}catch(Exception e) {}
			
//			softnet50.assertTrue(new NetworkPage().clickfiveGHzWidebandInfoIcon());
//			if(new NetworkPage().get5GHzWidebandModeDialogObject().isAt())
//				softnet50.assertTrue(new NetworkPage().get5GHzWidebandModeDialogObject().clickCloseButton());
			
			softnet50.assertTrue(new NetworkPage().enableBandSteeringMode());
			try {
				if(new NetworkPage().getBandSteeringModeAlertDialogObject().isAt())
					AssertJUnit.assertTrue(new NetworkPage().getBandSteeringModeAlertDialogObject().clickOKButton());
			}catch(Exception e) {}
				
			softnet50.assertTrue(new NetworkPage().clickBandSteeringInfoIcon());
			if(new NetworkPage().getBandSteeringModeDialogObject().isAt())
				AssertJUnit.assertTrue(new NetworkPage().getBandSteeringModeDialogObject().clickCloseButton());
			
			softnet50.assertTrue(new NetworkPage().clickExtendedWifiSettingsExpandButton());
			softnet50.assertAll();
		}
}




//@Test(priority = 74, dependsOnMethods = {"Login_And_Onboard"})
//public void Verify_Guest_WiFi_Network_Page() 
//{
//	SoftAssert softnet49 = new SoftAssert();
//	try {
//		if (new NetworkPage().guestNetworkExpandIcon.isDisplayed()) {
//			new NetworkPage().verifyGuestWifiNetwork();}
//	}catch(Exception e) {}
//	
//	try {
//		if(! new NetworkPage().guestNetworkExpandIcon.isDisplayed()) {
//			softnet49.assertTrue(new NetworkPage().enableGuestWifiNetwork());
//			try {
//				if(new NetworkPage().getEnableGuestNetworkAlertDialogObject().isAt())
//					softnet49.assertTrue(new NetworkPage().getEnableGuestNetworkAlertDialogObject().clickOkButton());
//				super.pause(40);
//				
//				if(new NetworkPage().joinButton.isDisplayed())
//					softnet49.assertTrue(new NetworkPage().clickJoinButton());
//				super.pause(15);
//			}catch(Exception e) {}
//			
//			try {
//				if(new NetworkPage().getEnableGuestNetworkDialogObject().isAt()) {
//					softnet49.assertTrue(new NetworkPage().getEnableGuestNetworkDialogObject().verifyUIOnGuestNetworkPage());
//					//softnet49.assertTrue(new NetworkPage().getEnableGuestNetworkDialogObject().validateGuestNetworkPage());
//					softnet49.assertTrue(new NetworkPage().getEnableGuestNetworkDialogObject().enterGuestNetworkName());
//					softnet49.assertTrue(new NetworkPage().getEnableGuestNetworkDialogObject().enterGuestNetworkPassword());
//					softnet49.assertTrue(new NetworkPage().getEnableGuestNetworkDialogObject().clickSaveChangesButton());
//				
//					if(new NetworkPage().getEnableGuestNetworkAlertDialogObject().isAt())
//						softnet49.assertTrue(new NetworkPage().getEnableGuestNetworkAlertDialogObject().clickOkButton());
//					}
//					super.pause(30);
//				}catch(Exception e) {utils.log().info("Enable Guest Network Page did not appear");}
//			
//			try {
//				if(new NetworkPage().guestNetworkExpandIcon.isDisplayed()) {
//					softnet49.assertTrue(new NetworkPage().clickGuestNetworkExpandButton());
//					softnet49.assertTrue(new NetworkPage().clickGuestNetworkEditdButton());
//						if(new NetworkPage().getEditGuestNetworkDialogObject().isAt()) {
//							softnet49.assertTrue(new NetworkPage().getEditGuestNetworkDialogObject().createGuestNetwork());
//							softnet49.assertTrue(new NetworkPage().getEditGuestNetworkDialogObject().clickSaveChangesButton()); 
//							try {
//								if(new NetworkPage().getEnableGuestNetworkAlertDialogObject().isAt())
//									softnet49.assertTrue(new NetworkPage().getEnableGuestNetworkAlertDialogObject().clickOkButton());
//								super.pause(35);
//								if(new NetworkPage().joinButton.isDisplayed()) {
//									softnet49.assertTrue(new NetworkPage().clickJoinButton());
//								super.pause(20);}
//							}catch(Exception e) {utils.log().info("Guest Network Alert dialog did not appear");}
//						}
//					softnet49.assertTrue(new NetworkPage().clickGuestNetworkExpandButton());}
//			}catch(Exception e) {utils.log().info("Guest Network is not Created");}
//		}
//	}catch(Exception e) {}
//
//	softnet49.assertAll();
//}