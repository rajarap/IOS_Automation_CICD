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
import com.cs.arris.Pages.DeviceSignalStrengthLeaderBoardPage;
import com.cs.arris.Pages.DevicesPage;
import com.cs.arris.Pages.HomePage;
import com.cs.arris.Pages.HomeSpeedTestHistoryPage;
import com.cs.arris.Pages.MainDeviceAllTabPage;
import com.cs.arris.Pages.NetworkPage;
import com.cs.arris.Pages.ParentalControlWithProfilesPage;
import com.cs.arris.Pages.SiginPage;
import com.cs.arris.Pages.SpeedTestPage;
import com.cs.arris.Pages.WhosHomeWelcomePage;
import com.cs.arris.Utilities.Direction;
import com.cs.arris.Utilities.TestUtils;
import com.cs.arris.Workflows.TC52_Login_And_Verify_HomePage_Workflow;

 
public class TC02_Medium_Test extends ParentClass
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
	
	//Main Device Page
	public TC007_Login_And_Test_Main_Device_Page getMainDevicePageTestObject() {
		TC007_Login_And_Test_Main_Device_Page mainDevicePageTest = new TC007_Login_And_Test_Main_Device_Page();
		return mainDevicePageTest;
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
//			utils.log().info("                        ");
//			utils.log().info("************************");
//			utils.log().info("Test: Login And Onboard ");
//			utils.log().info("************************");
//			
//			TC52_Login_And_Verify_HomePage_Workflow.getStartedPage(getStarted -> {
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
	  
	  @Test(priority = 2, dependsOnMethods = { "Login_And_Onboard" })
		public void Verify_Main_Device_UI_On_All_Tab_Page() {
		  
			utils.log().info("                          ");
			utils.log().info("**************************");
			utils.log().info("Test: Verify Main Device  ");
			utils.log().info("**************************");
			SoftAssert softmain2 = new SoftAssert();
			super.pause(15);
			softmain2.assertTrue(new HomePage().clickMainDeviceImage());
			super.pause(5);
			if(new MainDeviceAllTabPage().isAt()) 
				softmain2.assertTrue(new MainDeviceAllTabPage().verifyUIOnMainDevicePage());
			
			softmain2.assertAll();
		}
		
		@Test(priority = 3, dependsOnMethods    = { "Login_And_Onboard", "Verify_Main_Device_UI_On_All_Tab_Page" })
		public void Verify_LED_Settings_UI_On_All_Tab() {
			SoftAssert softmain3 = new SoftAssert();
			softmain3.assertTrue(new MainDeviceAllTabPage().verifyUIOnLedSettings());
			
			softmain3.assertAll();
		}
		
		@Test(priority = 4, dependsOnMethods = { "Login_And_Onboard",  "Verify_LED_Settings_UI_On_All_Tab"})
		public void Verify_Decrease_LED_Settings_On_All_Tab_Page() {
			SoftAssert softmain4 = new SoftAssert();
			new MainDeviceAllTabPage().clickLEDExpandButton();
			new MainDeviceAllTabPage().mobileSwipeSeekBar(Direction.LEFT);
			
			softmain4.assertAll();
		}
		
		@Test(priority = 5, dependsOnMethods = { "Login_And_Onboard",  "Verify_LED_Settings_UI_On_All_Tab"})
  		public void Verify_Increase_LED_Settings_On_All_Tab_Page() {
			SoftAssert softmain5 = new SoftAssert();
			new MainDeviceAllTabPage().mobileSwipeSeekBar(Direction.RIGHT);
			new MainDeviceAllTabPage().clickLEDExpandButton();
			
			softmain5.assertAll();
		}
		
		@Test(priority = 6, dependsOnMethods = { "Login_And_Onboard",  "Verify_Main_Device_UI_On_All_Tab_Page"})
		public void Verify_Devices_Count_Validation_On_All_Tab_Page() {
			SoftAssert softmain6 = new SoftAssert();
			softmain6.assertTrue(new MainDeviceAllTabPage().allTabvalidations());
			
			softmain6.assertAll();
		}
		
		@Test(priority = 7, dependsOnMethods = { "Login_And_Onboard",  "Verify_Main_Device_UI_On_All_Tab_Page"})
		public void Verify_Connected_Devices_On_All_Tab_Page() {
			SoftAssert softmain7 = new SoftAssert();
			softmain7.assertTrue(new MainDeviceAllTabPage().verifyConnectedDeviceDetails());
			
			softmain7.assertAll();
		}
		
		@Test(priority = 8, dependsOnMethods = { "Login_And_Onboard",  "Verify_Main_Device_UI_On_All_Tab_Page"})
		public void Verify_Main_Router_Details_On_All_Tab_Page() {
			SoftAssert softmain8 = new SoftAssert();
			softmain8.assertTrue(new MainDeviceAllTabPage().verifyMainRouterDetails());
			softmain8.assertAll();
		}
		
		@Test(priority = 9, dependsOnMethods = { "Login_And_Onboard",  "Verify_Main_Device_UI_On_All_Tab_Page"})
		public void Verify_Edit_Main_Router_Name_On_All_Tab_Page() {
			SoftAssert softmain9 = new SoftAssert();
			softmain9.assertTrue(new MainDeviceAllTabPage().clickMainDeviceEditIcon());
			if(new MainDeviceAllTabPage().getEditMainDeviceNameDialogObject().isAt())
			{
			//	softmain9.assertTrue(new MainDeviceAllTabPage().getEditMainDeviceNameDialogObject().verifyUIOnEditDeviceNameDialog());
				softmain9.assertTrue(new MainDeviceAllTabPage().getEditMainDeviceNameDialogObject().editMainDeviceName());
				softmain9.assertTrue(new MainDeviceAllTabPage().getEditMainDeviceNameDialogObject().clickSaveButton());
				super.pause(5);
				
				if(new MainDeviceAllTabPage().getEditMainDeviceNameDialogObject().successTitle.isDisplayed())
					softmain9.assertTrue(new MainDeviceAllTabPage().getEditMainDeviceNameDialogObject().clickOkButton());
				
				softmain9.assertTrue(new MainDeviceAllTabPage().clickMainDeviceEditIcon());
				softmain9.assertTrue(new MainDeviceAllTabPage().getEditMainDeviceNameDialogObject().editMainDeviceName2());
				softmain9.assertTrue(new MainDeviceAllTabPage().getEditMainDeviceNameDialogObject().clickSaveButton());
				super.pause(5);
				
				if(new MainDeviceAllTabPage().getEditMainDeviceNameDialogObject().successTitle.isDisplayed())
					softmain9.assertTrue(new MainDeviceAllTabPage().getEditMainDeviceNameDialogObject().clickOkButton());
			}
			
			softmain9.assertAll();
		}
		
//		@Test(priority = 10, dependsOnMethods = { "Login_And_Onboard",  "Verify_Main_Device_UI_On_All_Tab_Page"})
//		public void Verify_Edit_Connected_Device_Name_On_All_Tab_Page() {
//			SoftAssert softmain10 = new SoftAssert();
//				softmain10.assertTrue(new MainDeviceAllTabPage().clickDeviceNameEditIcon());
//				if(new MainDeviceAllTabPage().getEditDeviceNameDialogObject().isAt())
//				{
//				//	softmain10.assertTrue(new MainDeviceAllTabPage().getEditDeviceNameDialogObject().verifyUIOnEditDeviceNameDialog());
//					softmain10.assertTrue(new MainDeviceAllTabPage().getEditDeviceNameDialogObject().editDeviceName());
//					softmain10.assertTrue(new MainDeviceAllTabPage().getEditDeviceNameDialogObject().clickSaveButton());
//					super.pause(5);
//				}
//				
//				softmain10.assertTrue(new MainDeviceAllTabPage().clickDeviceNameEditIcon());
//			//	softmain10.assertTrue(new MainDeviceAllTabPage().getEditDeviceNameDialogObject().verifyUIOnEditDeviceNameDialog());
//				softmain10.assertTrue(new MainDeviceAllTabPage().getEditDeviceNameDialogObject().editDeviceName());
//				softmain10.assertTrue(new MainDeviceAllTabPage().getEditDeviceNameDialogObject().clickSaveButton());
//				
//			softmain10.assertAll();
//		}
		
		@Test(priority = 11, dependsOnMethods = { "Login_And_Onboard"})
		public void Verify_Main_Device_UI_On_5GHz_Tab_Page() {
			SoftAssert softmain11 = new SoftAssert();
			softmain11.assertTrue(new MainDeviceAllTabPage().click5GhzTab());
//			if(new MainDeviceAllTabPage().get5GHzPageObject().isAt())
//				softmain11.assertTrue(new MainDeviceAllTabPage().get5GHzPageObject().verifyUIOn5GHzDevicePage());
			softmain11.assertAll();
		}
//		
//		@Test(priority = 12)
//		public void Verify_LED_Settings_UI_On_5GHz_Tab_Page() {
//			SoftAssert softmain12 = new SoftAssert();
//			softmain12.assertTrue(new MainDeviceAllTabPage().get5GHzPageObject().verifyUIOnLedSettings());
//			
//			softmain12.assertAll();
//		}
//		
//		@Test(priority = 13)
//		public void Verify_Decrease_LED_Settings_On_5GHz_Tab_Page() {
//			SoftAssert softmain13 = new SoftAssert();
//			new MainDeviceAllTabPage().get5GHzPageObject().clickLEDExpandButton();
//			new MainDeviceAllTabPage().get5GHzPageObject().mobileSwipeSeekBar(Direction.LEFT);
//			
//			softmain13.assertAll();
//		}
//		
//		@Test(priority = 14)
//		public void Verify_Increase_LED_Settings_On_5GHz_Tab_Page() {
//			SoftAssert softmain14 = new SoftAssert();
//			new MainDeviceAllTabPage().get5GHzPageObject().mobileSwipeSeekBar(Direction.RIGHT);
//			new MainDeviceAllTabPage().get5GHzPageObject().clickLEDExpandButton();
//			
//			softmain14.assertAll();
//		}
		
		@Test(priority = 15, dependsOnMethods = { "Login_And_Onboard",  "Verify_Main_Device_UI_On_5GHz_Tab_Page"})
		public void Verify_Devices_Count_Validation_On_5GHz_Tab_Page() {
			SoftAssert softmain15 = new SoftAssert();
			softmain15.assertTrue(new MainDeviceAllTabPage().get5GHzPageObject().GHz5Tabvalidations());
			
		softmain15.assertAll();
		}
		
		@Test(priority = 16, dependsOnMethods = { "Login_And_Onboard",  "Verify_Main_Device_UI_On_5GHz_Tab_Page"})
		public void Verify_Connected_Devices_On_5GHz_Tab_Page() {
			SoftAssert softmain16 = new SoftAssert();
			softmain16.assertTrue(new MainDeviceAllTabPage().get5GHzPageObject().verifyConnectedDeviceDetails());
			softmain16.assertAll();
		}
		
//		@Test(priority = 17)
//		public void Verify_Main_Router_Details_On_5GHz_Tab_Page() {
//			SoftAssert softmain17= new SoftAssert();
//			softmain17.assertTrue(new MainDeviceAllTabPage().get5GHzPageObject().verifyMainRouterDetails());
//			super.swipeDown();
//			softmain17.assertAll();
//		}
//		
//		@Test(priority = 18)
//		public void Verify_Edit_Main_Router_Name_On_5GHz_Tab_Page() {
//			SoftAssert softmain18 = new SoftAssert();
//			softmain18.assertTrue(new MainDeviceAllTabPage().clickMainDeviceEditIcon());
//			if(new MainDeviceAllTabPage().get5GHzPageObject().getEditMainDeviceNameDialogObject().isAt())
//			{
//				softmain18.assertTrue(new MainDeviceAllTabPage().getEditMainDeviceNameDialogObject().verifyUIOnEditDeviceNameDialog());
//				softmain18.assertTrue(new MainDeviceAllTabPage().getEditMainDeviceNameDialogObject().editMainDeviceName());
//				softmain18.assertTrue(new MainDeviceAllTabPage().getEditMainDeviceNameDialogObject().clickSaveButton());
////				softmain18.assertTrue(new MainDeviceAllTabPage().clickMainDeviceEditIcon());
////				softmain18.assertTrue(new MainDeviceAllTabPage().getEditMainDeviceNameDialogObject().editMainDeviceName1());
////				softmain18.assertTrue(new MainDeviceAllTabPage().getEditMainDeviceNameDialogObject().clickSaveButton());
//			}
//			softmain18.assertAll();
//		}
//		
////		@Test(priority = 19)
////		public void Verify_Edit_Connected_Device_Name_On_5GHz_Tab_Page() {
////			SoftAssert softmain19 = new SoftAssert();
////			if (new MainDeviceAllTabPage().get5GHzPageObject().allDevicesCount > 0) {
////				softmain19.assertTrue(new MainDeviceAllTabPage().get5GHzPageObject().clickDeviceName(1));
////				if(new MainDeviceAllTabPage().getEditDeviceNameDialogObject().isAt())
////				{
////					softmain19.assertTrue(new MainDeviceAllTabPage().get5GHzPageObject().getEditDeviceNameDialogObject().verifyUIOnEditDeviceNameDialog());
////					softmain19.assertTrue(new MainDeviceAllTabPage().get5GHzPageObject().getEditDeviceNameDialogObject().editDeviceName1());
////					softmain19.assertTrue(new MainDeviceAllTabPage().get5GHzPageObject().getEditDeviceNameDialogObject().clickSaveButton());
////					softmain19.assertTrue(new MainDeviceAllTabPage().get5GHzPageObject().clickDeviceName(1));
////					softmain19.assertTrue(new MainDeviceAllTabPage().get5GHzPageObject().getEditDeviceNameDialogObject().editDeviceName1());
////					softmain19.assertTrue(new MainDeviceAllTabPage().getEthernetPageObject().getEditDeviceNameDialogObject().clickSaveButton());
////				}
////			}else {
////				utils.log().info("There are no 5.0GHz devices connected to the Main Router ");
////			}
////				
////			softmain19.assertAll();
////		}
////		
////		
		@Test(priority = 20, dependsOnMethods = { "Login_And_Onboard"})
		public void Verify_Main_Device_UI_On_24GHz_Tab_Page() {
			SoftAssert softmain20 = new SoftAssert();
			softmain20.assertTrue(new MainDeviceAllTabPage().click24GhzTab());
//			if(new MainDeviceAllTabPage().get24GHzPageObject().isAt())
//				softmain20.assertTrue(new MainDeviceAllTabPage().get24GHzPageObject().verifyUIOn24GHzDevicePage());
//			
			softmain20.assertAll();
		}
		
//		@Test(priority = 21)
//		public void Verify_LED_Settings_UI_On_24GHz_Tab_Page() {
//			SoftAssert softmain21 = new SoftAssert();
//			softmain21.assertTrue(new MainDeviceAllTabPage().get24GHzPageObject().verifyUIOnLedSettings());
//			
//			softmain21.assertAll();
//		}
//		
//		@Test(priority = 22)
//		public void Verify_Decrease_LED_Settings_On_24GHz_Tab_Page() {
//			SoftAssert softmain22 = new SoftAssert();
//			new MainDeviceAllTabPage().get24GHzPageObject().clickLEDExpandButton();
//			new MainDeviceAllTabPage().get24GHzPageObject().mobileSwipeSeekBar(Direction.LEFT);
//			
//			softmain22.assertAll();
//		}
//		
//		@Test(priority = 23)
//		public void Verify_Increase_LED_Settings_On_24GHz_Tab_Page() {
//			SoftAssert softmain23 = new SoftAssert();
//			new MainDeviceAllTabPage().get24GHzPageObject().mobileSwipeSeekBar(Direction.RIGHT);
//			new MainDeviceAllTabPage().get24GHzPageObject().clickLEDExpandButton();
//			
//			softmain23.assertAll();
//		}
//		
		@Test(priority = 24, dependsOnMethods = { "Login_And_Onboard",  "Verify_Main_Device_UI_On_24GHz_Tab_Page"})
		public void Verify_Devices_Count_Validation_On_24GHz_Tab_Page() {
			SoftAssert softmain24 = new SoftAssert();
			softmain24.assertTrue(new MainDeviceAllTabPage().get24GHzPageObject().GHz24Tabvalidations());
			softmain24.assertAll();
		}
		
		@Test(priority = 25, dependsOnMethods = { "Login_And_Onboard",  "Verify_Main_Device_UI_On_24GHz_Tab_Page"})
		public void Verify_Connected_Devices_On_24GHz_Tab_Page() {
			SoftAssert softmain25 = new SoftAssert();
			softmain25.assertTrue(new MainDeviceAllTabPage().get24GHzPageObject().verifyConnectedDeviceDetails());
			
			softmain25.assertAll();
		}
		
//		@Test(priority = 26)
//		public void Verify_Main_Router_Details_On_24GHz_Tab_Page() {
//			SoftAssert softmain26 = new SoftAssert();
//			softmain26.assertTrue(new MainDeviceAllTabPage().get24GHzPageObject().verifyMainRouterDetails());
//			super.swipeDown();
//			softmain26.assertAll();
//		}
//////		
//////		@Test(priority = 27)
//////		public void Verify_Edit_Main_Router_Name_On_24GHz_Tab_Page() {
//////			SoftAssert softmain27 = new SoftAssert();
//////			softmain27.assertTrue(new MainDeviceAllTabPage().clickMainDeviceName());
//////			if(new MainDeviceAllTabPage().get24GHzPageObject().getEditMainDeviceNameDialogObject().isAt())
//////			{
//////				softmain27.assertTrue(new MainDeviceAllTabPage().getEditMainDeviceNameDialogObject().verifyUIOnEditDeviceNameDialog());
//////				softmain27.assertTrue(new MainDeviceAllTabPage().getEditDeviceNameDialogObject().editDeviceName1());
//////				softmain27.assertTrue(new MainDeviceAllTabPage().getEditDeviceNameDialogObject().clickSaveButton());
//////				softmain27.assertTrue(new MainDeviceAllTabPage().clickDeviceName(1));
//////				softmain27.assertTrue(new MainDeviceAllTabPage().getEditDeviceNameDialogObject().editDeviceName1());
//////				softmain27.assertTrue(new MainDeviceAllTabPage().getEditDeviceNameDialogObject().clickSaveButton());
//////			}
//////			
//////			softmain27.assertAll();
//////		}
//////		
//////		@Test(priority = 28)
//////		public void Verify_Edit_Connected_Device_Name_On_24GHz_Tab_Page() {
//////			SoftAssert softmain28 = new SoftAssert();
//////			if (new MainDeviceAllTabPage().get24GHzPageObject().allDevicesCount > 0) {
//////				softmain28.assertTrue(new MainDeviceAllTabPage().getEthernetPageObject().clickDeviceName(1));
//////				if(new MainDeviceAllTabPage().getEditDeviceNameDialogObject().isAt())
//////				{
//////					softmain28.assertTrue(new MainDeviceAllTabPage().get24GHzPageObject().getEditDeviceNameDialogObject().verifyUIOnEditDeviceNameDialog());
//////					softmain28.assertTrue(new MainDeviceAllTabPage().get24GHzPageObject().getEditDeviceNameDialogObject().editDeviceName1());
//////					softmain28.assertTrue(new MainDeviceAllTabPage().get24GHzPageObject().getEditDeviceNameDialogObject().clickSaveButton());
//////					softmain28.assertTrue(new MainDeviceAllTabPage().get24GHzPageObject().clickDeviceName(1));
//////					softmain28.assertTrue(new MainDeviceAllTabPage().get24GHzPageObject().getEditDeviceNameDialogObject().editDeviceName2());
//////					softmain28.assertTrue(new MainDeviceAllTabPage().get24GHzPageObject().getEditDeviceNameDialogObject().clickSaveButton());
//////				}
//////			}else {
//////				utils.log().info("There are no 2.4GHz devices connected to the Main Router ");
//////			}
//////			
//////			softmain28.assertAll();
//////		}
////		
		@Test(priority = 29, dependsOnMethods = { "Login_And_Onboard"})
		public void Verify_Main_Device_UI_On_Ethernet_Tab_Page() {
			SoftAssert softmain29 = new SoftAssert();
			softmain29.assertTrue(new MainDeviceAllTabPage().clickEthernetTab());
//			if(new MainDeviceAllTabPage().getEthernetPageObject().isAt())
//				softmain29.assertTrue(new MainDeviceAllTabPage().getEthernetPageObject().verifyUIOnEthernetDevicePage());
//			
			softmain29.assertAll();
		}
		
//		@Test(priority = 30)
//		public void Verify_LED_Settings_UI_On_Ethernet_Tab_Page() {
//			SoftAssert softmain30 = new SoftAssert();
//			AssertJUnit.assertTrue(new MainDeviceAllTabPage().getEthernetPageObject().verifyUIOnLedSettings());
//			
//			softmain30.assertAll();
//		}
//		
//		@Test(priority = 31)
//		public void Verify_Decrease_LED_Settings_On_Ethernet_Tab_Page() {
//			SoftAssert softmain31 = new SoftAssert();
//			new MainDeviceAllTabPage().getEthernetPageObject().clickLEDExpandButton();
//			new MainDeviceAllTabPage().getEthernetPageObject().mobileSwipeSeekBar(Direction.LEFT);
//			
//			softmain31.assertAll();
//		}
//		
//		@Test(priority = 32)
//		public void Verify_Increase_LED_Settings_On_Ethernet_Tab_Page() {
//			SoftAssert softmain32 = new SoftAssert();
//			new MainDeviceAllTabPage().getEthernetPageObject().mobileSwipeSeekBar(Direction.RIGHT);
//			new MainDeviceAllTabPage().getEthernetPageObject().clickLEDExpandButton();
//			softmain32.assertAll();
//		}
//		
		@Test(priority = 33, dependsOnMethods = { "Login_And_Onboard",  "Verify_Main_Device_UI_On_Ethernet_Tab_Page"})
		public void Verify_Devices_Count_Validation_On_Ethernet_Tab_Page() {
			SoftAssert softmain33 = new SoftAssert();
			softmain33.assertTrue(new MainDeviceAllTabPage().getEthernetPageObject().ethernetTabvalidations());
			
			softmain33.assertAll();
		}
		
		@Test(priority = 34, dependsOnMethods = { "Login_And_Onboard",  "Verify_Main_Device_UI_On_Ethernet_Tab_Page"})
		public void Verify_Connected_Devices_On_Ethernet_Tab_Page() {
			SoftAssert softmain34 = new SoftAssert();
			softmain34.assertTrue(new MainDeviceAllTabPage().getEthernetPageObject().verifyConnectedDeviceDetails());
			
			softmain34.assertAll();
		}
		
//		@Test(priority = 35)
//		public void Verify_Main_Router_Details_On_Ethernet_Tab_Page() {
//			SoftAssert softmain35 = new SoftAssert();
//			softmain35.assertTrue(new MainDeviceAllTabPage().getEthernetPageObject().verifyMainRouterDetails());
//			super.swipeDown();
//			softmain35.assertAll();
//		}
//		
//		@Test(priority = 36)
//		public void Verify_Edit_Main_Router_Name_On_Ethernet_Tab_Page() {
//			SoftAssert softmain36 = new SoftAssert();
//			softmain36.assertTrue(new MainDeviceAllTabPage().clickMainDeviceName());
//			if(new MainDeviceAllTabPage().getEthernetPageObject().getEditMainDeviceNameDialogObject().isAt())
//			{
//				softmain36.assertTrue(new MainDeviceAllTabPage().getEditMainDeviceNameDialogObject().verifyUIOnEditDeviceNameDialog());
//				softmain36.assertTrue(new MainDeviceAllTabPage().getEditDeviceNameDialogObject().editDeviceName1());
//				softmain36.assertTrue(new MainDeviceAllTabPage().getEditDeviceNameDialogObject().clickSaveButton());
//				softmain36.assertTrue(new MainDeviceAllTabPage().clickDeviceName(1));
//				softmain36.assertTrue(new MainDeviceAllTabPage().getEditDeviceNameDialogObject().editDeviceName1());
//				softmain36.assertTrue(new MainDeviceAllTabPage().getEditDeviceNameDialogObject().clickSaveButton());
//			}
//			
//			softmain36.assertAll();
//		}
//		
//		@Test(priority = 37)
//		public void Verify_Edit_Connected_Device_Name_On_Ethernet_Tab_Page() {
//			SoftAssert softmain37 = new SoftAssert();
//			if (new MainDeviceAllTabPage().getEthernetPageObject().allDevicesCount > 0) {
//				softmain37.assertTrue(new MainDeviceAllTabPage().getEthernetPageObject().clickDeviceName(1));
//				if(new MainDeviceAllTabPage().getEditDeviceNameDialogObject().isAt())
//				{
//					softmain37.assertTrue(new MainDeviceAllTabPage().getEthernetPageObject().getEditDeviceNameDialogObject().verifyUIOnEditDeviceNameDialog());
//					softmain37.assertTrue(new MainDeviceAllTabPage().getEthernetPageObject().getEditDeviceNameDialogObject().editDeviceName1());
//					softmain37.assertTrue(new MainDeviceAllTabPage().getEthernetPageObject().getEditDeviceNameDialogObject().clickSaveButton());
//					softmain37.assertTrue(new MainDeviceAllTabPage().getEthernetPageObject().clickDeviceName(1));
//					softmain37.assertTrue(new MainDeviceAllTabPage().getEthernetPageObject().getEditDeviceNameDialogObject().editDeviceName2());
//					softmain37.assertTrue(new MainDeviceAllTabPage().getEthernetPageObject().getEditDeviceNameDialogObject().clickSaveButton());
//				}
//			}else {
//				utils.log().info("There are no Ethernet devices connected to the Main Router ");
//			}
//			softmain37.assertAll();
//		}

		@Test(priority = 38, dependsOnMethods = { "Login_And_Onboard"})
		public void Verify_Main_Device_Help_Page() {
			SoftAssert softmain38 = new SoftAssert();
			softmain38.assertTrue(new MainDeviceAllTabPage().getEthernetPageObject().clickHelpButton());
			
			if(new MainDeviceAllTabPage().getMainRouterDetailsHelpPageObject().isAt())
				new MainDeviceAllTabPage().getMainRouterDetailsHelpPageObject().clickCloseButton();
			
			new MainDeviceAllTabPage().getEthernetPageObject().clickBackButton();
			
			softmain38.assertAll();
		}
	  
		@Test(priority = 39, dependsOnMethods = { "Login_And_Onboard"})
		public void Verify_Devices_UI_Page() {
			utils.log().info("                                            ");
			utils.log().info("********************************************");
			utils.log().info("Test: Online and Offline Connected Devices  ");
			utils.log().info("********************************************");
			SoftAssert softdevices2 = new SoftAssert();
			new HomePage().getFooterIconsPageObject().clickHomeButton();
			if(new HomePage().isAt())
				softdevices2.assertTrue(new HomePage().clickDevicesImage());
			if(new DevicesPage().isAt()) 
				softdevices2.assertTrue(new DevicesPage().verifyUIOnDevicesPage());
			softdevices2.assertAll();
		}
			
		@Test(priority = 40, dependsOnMethods = { "Login_And_Onboard", "Verify_Devices_UI_Page"})
		public void Verify_Online_Devices_Details() 
		{
			SoftAssert softdevices3 = new SoftAssert();
			softdevices3.assertTrue(new DevicesPage().verifyOnlineDeviceDetails());
			softdevices3.assertAll();
		}
		
//		@Test(priority = 41, dependsOnMethods = { "Login_And_Onboard", "Verify_Devices_UI_Page"})
//		public void Verify_Edit_Device_Name() 
//		{
//			SoftAssert softdevices4 = new SoftAssert();
//			softdevices4.assertTrue(new DevicesPage().verifyEditDeviceName());
//			softdevices4.assertAll();
//		}
//		
		@Test(priority = 42, dependsOnMethods = { "Login_And_Onboard", "Verify_Devices_UI_Page"})
		public void Verify_Offline_Devices_Details() 
		{
			SoftAssert softdevices5 = new SoftAssert();
			softdevices5.assertTrue(new DevicesPage().verifyOfflineDeviceDetails());
			softdevices5.assertAll();
		}
		
		@Test(priority = 43, dependsOnMethods = { "Login_And_Onboard", "Verify_Devices_UI_Page"})
		public void Verify_Devices_Help_Page() 
		{
			SoftAssert softdevices6 = new SoftAssert();
			softdevices6.assertTrue(new DevicesPage().clickHelpButton());
			if(new DevicesPage().getDevicesHelpPageObject().isAt())
				softdevices6.assertTrue(new DevicesPage().getDevicesHelpPageObject().clickCloseButton());
			softdevices6.assertTrue(new DevicesPage().clickBackButton());
			softdevices6.assertAll();
		}
	  
		@Test(priority = 44, dependsOnMethods = { "Login_And_Onboard"})
		public void Verify_Devices_Signal_Strength_UI_Page() {
			utils.log().info("                                            ");
			utils.log().info("********************************************");
			utils.log().info("Test: Device Signal Strength Leader Board   ");
			utils.log().info("********************************************");
			SoftAssert softsignal2 = new SoftAssert();
			new HomePage().getFooterIconsPageObject().clickHomeButton();
			super.swipeUp();
			new HomePage().clickDeviceSignalStrengthImage();
			if(new DeviceSignalStrengthLeaderBoardPage().isAt()) 
				softsignal2.assertTrue(new DeviceSignalStrengthLeaderBoardPage().verifyUIOnDeviceSignalStrengthPage());
			softsignal2.assertAll();
		}
		
//		@Test(priority = 45, dependsOnMethods = { "Login_And_Onboard", "Verify_Devices_Signal_Strength_UI_Page"})
//		public void Verify_Signal_Strength_For_Devices() {
//			SoftAssert softsignal3 = new SoftAssert();
//			softsignal3.assertTrue(new DeviceSignalStrengthLeaderBoardPage().verifySignalStrengthForDevices());
//			softsignal3.assertAll();
//		}
		
		@Test(priority = 46, dependsOnMethods = { "Login_And_Onboard", "Verify_Devices_Signal_Strength_UI_Page"})
		public void Verify_Sorting_Devices_From_Strong_To_Weak() {
			SoftAssert softsignal4= new SoftAssert();
			softsignal4.assertTrue(new DeviceSignalStrengthLeaderBoardPage().verifySignalStrengthStrongToWeak());
			softsignal4.assertAll();
		}
		
		@Test(priority = 47, dependsOnMethods = { "Login_And_Onboard", "Verify_Devices_Signal_Strength_UI_Page"})
		public void Verify_Sorting_Devices_From_Weak_To_Strong() {
			SoftAssert softsignal5= new SoftAssert();
			softsignal5.assertTrue(new DeviceSignalStrengthLeaderBoardPage().verifySignalStrengthWeakToStrong());
			softsignal5.assertAll();
		}
		
		@Test(priority = 48, dependsOnMethods = { "Login_And_Onboard", "Verify_Devices_Signal_Strength_UI_Page"})
		public void Verify_Editing_Device_Name() {
			SoftAssert softsignal6= new SoftAssert();
//			softsignal6.assertTrue(new DeviceSignalStrengthLeaderBoardPage().clickEditDeviceName(1));
//			softsignal6.assertTrue(new MainDeviceAllTabPage().getEditMainDeviceNameDialogObject().editMainDeviceName());
//			softsignal6.assertTrue(new MainDeviceAllTabPage().getEditMainDeviceNameDialogObject().clickSaveButton());
			softsignal6.assertTrue(new DeviceSignalStrengthLeaderBoardPage().getFooterIconsPageObject().clickHomeButton());
			softsignal6.assertAll();
		}
	  
	  @Test(priority = 49, dependsOnMethods = { "Login_And_Onboard"})
		public void Verify_Speed_Test_Page() {
			utils.log().info("                                ");
			utils.log().info("********************************");
			utils.log().info("Test: Home Speed Test History   ");
			utils.log().info("********************************");
			SoftAssert softspeedtest2 = new SoftAssert();
			softspeedtest2.assertTrue(new HomePage().clickNavigationButton());
			if(new HomePage().getHamburgerMenuPageObject().isAt()) 
			{
				if(new HomePage().getHamburgerMenuPageObject().speedTest.isDisplayed())
					softspeedtest2.assertTrue(new HomePage().getHamburgerMenuPageObject().clickSpeedTestButton());
				try {
					if(new AppRatingDialog().isAt())
						new AppRatingDialog().clickRemindMeLaterLink();
				}catch(Exception e){}
			}
			if(new SpeedTestPage().isAt())
			{
				softspeedtest2.assertTrue(new SpeedTestPage().verifyUIOnSpeedTestPage());
			}
			
			softspeedtest2.assertAll();
	  }
	  
	  @Test(priority = 50, dependsOnMethods = { "Login_And_Onboard", "Verify_Speed_Test_Page"})
		public void Verify_Perform_Speed_Test() {
			SoftAssert softspeedtest3 = new SoftAssert();
			softspeedtest3.assertTrue(new SpeedTestPage().performSpeedTest());
			try {
				for (int i = 0; i < 2; i++)
				{
					softspeedtest3.assertTrue(new SpeedTestPage().runSpeedTestAgain());
				}
			}catch(Exception e){}
			
			softspeedtest3.assertAll();
		}
	  
	  @Test(priority = 51, dependsOnMethods = { "Login_And_Onboard", "Verify_Speed_Test_Page"})
		public void Verify_Speed_Test_Help_page() {
			SoftAssert softspeedtest4 = new SoftAssert();
			softspeedtest4.assertTrue(new SpeedTestPage().clickHelpButton());
			softspeedtest4.assertTrue(new SpeedTestPage().getSpeedTestHelpPageObject().clickCloseButton());
			softspeedtest4.assertTrue(new SpeedTestPage().clickBackButton());
			softspeedtest4.assertAll();
		}
	  
	  @Test(priority = 52, dependsOnMethods = { "Login_And_Onboard", "Verify_Speed_Test_Page"})
		public void Verify_Home_Speed_Test_History_Page() {
			SoftAssert softspeedtest5 = new SoftAssert();
			if(new HomePage().isAt()) 
				super.swipeUp();
			softspeedtest5.assertTrue(new HomePage().clickSpeedTestHistoryImage());
			
			if(new HomeSpeedTestHistoryPage().isAt())
				softspeedtest5.assertTrue(new HomeSpeedTestHistoryPage().verifyHomeSpeedTestHistory());
			
			softspeedtest5.assertTrue(new HomeSpeedTestHistoryPage().getFooterIconsPageObject().clickHomeButton());
			
			softspeedtest5.assertAll();
	  }
	  
//	  @Test(priority = 53, dependsOnMethods = { "Login_And_Onboard"})
//		public void Verify_Whos_Home_Page() {
//			utils.log().info("                                ");
//			utils.log().info("********************************");
//			utils.log().info("Test: Whos Home Feature         ");
//			utils.log().info("********************************");
//			SoftAssert softwhoshome1 = new SoftAssert();
//			new HomePage().getFooterIconsPageObject().clickHomeButton();
//			super.swipeUp();
//			softwhoshome1.assertTrue(new HomePage().clickWhoseHomeText());	
//			softwhoshome1.assertTrue(new HomePage().getWhoseHomePageObject().verifyWhoseHomeWelcomePage());
//			softwhoshome1.assertTrue(new HomePage().getWhoseHomePageObject().clickAddMemeberButton());
//			if(new HomePage().getWhoseHomePageObject().getHomeMonitoringPageObject().isAt()) 
//				new HomePage().getWhoseHomePageObject().getHomeMonitoringPageObject().enableMonitoring();
//			
//			softwhoshome1.assertAll();
//	  }
//	  
//	  @Test(priority = 54, dependsOnMethods = { "Login_And_Onboard"})
//		public void Verify_Add_Member_Dialog() {
//			SoftAssert softwhoshome2 = new SoftAssert();
//						
//			if(new HomePage().getWhoseHomePageObject().getAddMemberDialogObject().isAt()) 
//			{
//		//		softwhoshome2.assertTrue(new HomePage().getWhoseHomePageObject().getAddMemberDialogObject().verifyAddHouseHoldMemberDialogUI());
//				softwhoshome2.assertTrue(new HomePage().getWhoseHomePageObject().getAddMemberDialogObject().enterMemberName());
//				softwhoshome2.assertTrue(new HomePage().getWhoseHomePageObject().getAddMemberDialogObject().clickContinueButton());
//			}
//			
//			softwhoshome2.assertAll();
//	  }
//	  
//	  @Test(priority = 55, dependsOnMethods = { "Login_And_Onboard"})
//		public void Verify_Pick_A_Device_Dialog() {
//			SoftAssert softwhoshome3 = new SoftAssert();
//			if(new HomePage().getWhoseHomePageObject().getPickADeviceDialogObject().isAt()) 
//			{
//				softwhoshome3.assertTrue(new HomePage().getWhoseHomePageObject().getPickADeviceDialogObject().clickPhoneButton());
//				softwhoshome3.assertTrue(new HomePage().getWhoseHomePageObject().getPickADeviceDialogObject().verifyPickAPhoneDevice());
//				
//				softwhoshome3.assertTrue(new HomePage().getWhoseHomePageObject().getPickADeviceDialogObject().clickTabButton());
//				softwhoshome3.assertTrue(new HomePage().getWhoseHomePageObject().getPickADeviceDialogObject().verifyPickATabDevice());
//				
//				softwhoshome3.assertTrue(new HomePage().getWhoseHomePageObject().getPickADeviceDialogObject().clickComputerButton());
//				softwhoshome3.assertTrue(new HomePage().getWhoseHomePageObject().getPickADeviceDialogObject().verifyPickAComputerDevice());
//				
//				softwhoshome3.assertTrue(new HomePage().getWhoseHomePageObject().getPickADeviceDialogObject().clickIOTButton());
//				softwhoshome3.assertTrue(new HomePage().getWhoseHomePageObject().getPickADeviceDialogObject().verifyPickAIOTDevice());
//			}
//			
//			softwhoshome3.assertAll();
//	  }
//	  
//	  @Test(priority = 56, dependsOnMethods = { "Login_And_Onboard"})
//		public void Verify_Pick_A_Phone_Device() {
//			SoftAssert softwhoshome4 = new SoftAssert();
//			if(new HomePage().getWhoseHomePageObject().getPickADeviceDialogObject().isAt()) 
//			{
//				softwhoshome4.assertTrue(new HomePage().getWhoseHomePageObject().getPickADeviceDialogObject().clickPhoneButton());
//				softwhoshome4.assertTrue(new HomePage().getWhoseHomePageObject().getPickADeviceDialogObject().pickAPhoneDevice());
//				softwhoshome4.assertTrue(new HomePage().getWhoseHomePageObject().getPickADeviceDialogObject().clickSaveButton());
//				super.pause(5);
//			}
//			softwhoshome4.assertAll();
//	  }
//	  
//	  @Test(priority = 57, dependsOnMethods = { "Login_And_Onboard"})
//		public void Verify_Add_Member_In_Whos_Home_Monitoring_Page() {
//			SoftAssert softwhoshome5 = new SoftAssert();
//
//			if(new HomePage().getWhoseHomePageObject().getHomeMonitoringPageObject().isAt()) 
//			{
//				softwhoshome5.assertTrue(new HomePage().getWhoseHomePageObject().getHomeMonitoringPageObject().clickAddButton());
//				softwhoshome5.assertTrue(new HomePage().getWhoseHomePageObject().getAddMemberDialogObject().enterMemberName());
//				softwhoshome5.assertTrue(new HomePage().getWhoseHomePageObject().getAddMemberDialogObject().clickContinueButton());
//				super.pause(5);
//			}
//			
//			if(new HomePage().getWhoseHomePageObject().getPickADeviceDialogObject().isAt()) 
//			{
//				softwhoshome5.assertTrue(new HomePage().getWhoseHomePageObject().getPickADeviceDialogObject().clickIOTButton());
//				softwhoshome5.assertTrue(new HomePage().getWhoseHomePageObject().getPickADeviceDialogObject().pickAIOTDevice());
//				softwhoshome5.assertTrue(new HomePage().getWhoseHomePageObject().getPickADeviceDialogObject().clickSaveButton());
//				super.pause(5);
//			}
//			
//			if(new HomePage().getWhoseHomePageObject().getHomeMonitoringPageObject().isAt()) 
//			{
//				softwhoshome5.assertTrue(new HomePage().getWhoseHomePageObject().getHomeMonitoringPageObject().clickAddButton());
//				softwhoshome5.assertTrue(new HomePage().getWhoseHomePageObject().getAddMemberDialogObject().enterMemberName());
//				softwhoshome5.assertTrue(new HomePage().getWhoseHomePageObject().getAddMemberDialogObject().clickContinueButton());
//				super.pause(5);
//			}
//			
//			if(new HomePage().getWhoseHomePageObject().getPickADeviceDialogObject().isAt()) 
//			{
//				softwhoshome5.assertTrue(new HomePage().getWhoseHomePageObject().getPickADeviceDialogObject().clickPhoneButton());
//				softwhoshome5.assertTrue(new HomePage().getWhoseHomePageObject().getPickADeviceDialogObject().pickAPhoneDevice());
//				softwhoshome5.assertTrue(new HomePage().getWhoseHomePageObject().getPickADeviceDialogObject().clickSaveButton());
//				super.pause(5);
//			}
//
//
//			softwhoshome5.assertAll();
//	  }
//	  
//	  @Test(priority = 58, dependsOnMethods = { "Login_And_Onboard"})
//		public void Verify_Whos_Home_Monitoring_Page() {
//			SoftAssert softwhoshome6 = new SoftAssert();
//			if(new HomePage().getWhoseHomePageObject().getHomeMonitoringPageObject().isAt()) 
//			{
//		//		softwhoshome6.assertTrue(new HomePage().getWhoseHomePageObject().getHomeMonitoringPageObject().verifyWhoseHomeWelcomePage());
//				softwhoshome6.assertTrue(new HomePage().getWhoseHomePageObject().getHomeMonitoringPageObject().listOFMonitoringMembers());
//			}
//			
//			try {
//				if(new AppRatingDialog().isAt())
//					new AppRatingDialog().clickRemindMeLaterLink();
//			}catch(Exception e){}
//
//			softwhoshome6.assertAll();
//	  }
//	  
//	  @Test(priority = 59, dependsOnMethods = { "Login_And_Onboard"})
//		public void Verify_Whos_Home_Monitoring_Page_Change_Member_Name() {
//			SoftAssert softwhoshome7 = new SoftAssert();
//			if(new HomePage().getWhoseHomePageObject().getHomeMonitoringPageObject().isAt()) 
//			{
//				softwhoshome7.assertTrue(new HomePage().getWhoseHomePageObject().getHomeMonitoringPageObject().selectMemberOptionIcon());
//				softwhoshome7.assertTrue(new HomePage().getWhoseHomePageObject().getHomeMonitoringPageObject().clickChangeNameOption());
//			}
//			
//			if(new HomePage().getWhoseHomePageObject().getHomeMonitoringPageObject().getChangeMemberNamePageObject().isAt()) {
//				softwhoshome7.assertTrue(new HomePage().getWhoseHomePageObject().getHomeMonitoringPageObject().getChangeMemberNamePageObject().enterMemberName());
//				softwhoshome7.assertTrue(new HomePage().getWhoseHomePageObject().getHomeMonitoringPageObject().getChangeMemberNamePageObject().clickUpdateButton());
//			}
//			super.pause(5);
//			
//			softwhoshome7.assertAll();
//	  }
//	  
//	  @Test(priority = 60, dependsOnMethods = { "Login_And_Onboard"})
//		public void Verify_Whos_Home_Monitoring_Page_Change_Device_Name() {
//			SoftAssert softwhoshome8 = new SoftAssert();
//			if(new HomePage().getWhoseHomePageObject().getHomeMonitoringPageObject().isAt()) 
//			{
//				softwhoshome8.assertTrue(new HomePage().getWhoseHomePageObject().getHomeMonitoringPageObject().selectMemberOptionIcon());
//				softwhoshome8.assertTrue(new HomePage().getWhoseHomePageObject().getHomeMonitoringPageObject().clickChangeDeviceOption());
//			}
//			
//			if(new HomePage().getWhoseHomePageObject().getHomeMonitoringPageObject().getChangeMemberDeviceNamePageObject().isAt()) {
//				softwhoshome8.assertTrue(new HomePage().getWhoseHomePageObject().getHomeMonitoringPageObject().getChangeMemberDeviceNamePageObject().pickAPhoneDevice());
//				softwhoshome8.assertTrue(new HomePage().getWhoseHomePageObject().getHomeMonitoringPageObject().getChangeMemberNamePageObject().clickUpdateButton());
//			}
//			super.pause(5);
//			
//			softwhoshome8.assertAll();
//	  }
//	  
//	  @Test(priority = 61, dependsOnMethods = { "Login_And_Onboard"})
//		public void Verify_Whos_Home_Monitoring_Page_Remove_Member_Name() {
//			SoftAssert softwhoshome9 = new SoftAssert();
//			if(new HomePage().getWhoseHomePageObject().getHomeMonitoringPageObject().isAt()) 
//			{
//				softwhoshome9.assertTrue(new HomePage().getWhoseHomePageObject().getHomeMonitoringPageObject().selectMemberOptionIcon());
//				softwhoshome9.assertTrue(new HomePage().getWhoseHomePageObject().getHomeMonitoringPageObject().clickRemoveMemberOption());
//			}
//			
//			if(new HomePage().getWhoseHomePageObject().getHomeMonitoringPageObject().getRemoveMemberPageObject().isAt()) 
//				softwhoshome9.assertTrue(new HomePage().getWhoseHomePageObject().getHomeMonitoringPageObject().getRemoveMemberPageObject().clickRemoveButton());
//			
//			super.pause(5);
//			
//			softwhoshome9.assertAll();
//	  }
//	  
//	  @Test(priority = 62, dependsOnMethods = { "Login_And_Onboard"})
//		public void Verify_Whos_Home_Monitoring_Page_Add_Notification1() {
//			SoftAssert softwhoshome10 = new SoftAssert();
//			if(new HomePage().getWhoseHomePageObject().getHomeMonitoringPageObject().isAt()) 
//				softwhoshome10.assertTrue(new HomePage().getWhoseHomePageObject().getHomeMonitoringPageObject().clickNotifyMeText());
//			
//			if(new HomePage().getWhoseHomePageObject().getHomeMonitoringPageObject().getNotifyMeWhenPageObject().isAt())
//				softwhoshome10.assertTrue(new HomePage().getWhoseHomePageObject().getHomeMonitoringPageObject().getNotifyMeWhenPageObject().clickaddButton());
//				softwhoshome10.assertTrue(new HomePage().getWhoseHomePageObject().getHomeMonitoringPageObject().getNotifyMeWhenPageObject().getAddNewNotificationPageObject().selectMemberOne());
//				softwhoshome10.assertTrue(new HomePage().getWhoseHomePageObject().getHomeMonitoringPageObject().getNotifyMeWhenPageObject().getAddNewNotificationPageObject().clickLeavesHomeRadioButton());
//			super.swipeUp();
//			
//			softwhoshome10.assertTrue(new HomePage().getWhoseHomePageObject().getHomeMonitoringPageObject().getNotifyMeWhenPageObject().getAddNewNotificationPageObject().clickEveryDayRadioButton());
//			
//			softwhoshome10.assertTrue(new HomePage().getWhoseHomePageObject().getHomeMonitoringPageObject().getNotifyMeWhenPageObject().getAddNewNotificationPageObject().clickSelectTimeButton());
//			softwhoshome10.assertTrue(new HomePage().getWhoseHomePageObject().getHomeMonitoringPageObject().getNotifyMeWhenPageObject().getAddNewNotificationPageObject().selectMinutes());
//			softwhoshome10.assertTrue(new HomePage().getWhoseHomePageObject().getHomeMonitoringPageObject().getNotifyMeWhenPageObject().getAddNewNotificationPageObject().clickTimePickerDoneButton());
//			
//			softwhoshome10.assertTrue(new HomePage().getWhoseHomePageObject().getHomeMonitoringPageObject().getNotifyMeWhenPageObject().getAddNewNotificationPageObject().clickSelectToleranceButton());
//			softwhoshome10.assertTrue(new HomePage().getWhoseHomePageObject().getHomeMonitoringPageObject().getNotifyMeWhenPageObject().getAddNewNotificationPageObject().click10MinToleranceButton());
//			softwhoshome10.assertTrue(new HomePage().getWhoseHomePageObject().getHomeMonitoringPageObject().getNotifyMeWhenPageObject().getAddNewNotificationPageObject().clickSaveButton());
//			
//			super.pause(5);
//			
//			softwhoshome10.assertAll();
//	  }
//	  
////	  @Test(priority = 63, dependsOnMethods = { "Login_And_Onboard"})
////		public void Verify_Whos_Home_Monitoring_Page_Add_Notification2() {
////			SoftAssert softwhoshome11 = new SoftAssert();
////			
////			if(new HomePage().getWhoseHomePageObject().getHomeMonitoringPageObject().getNotifyMeWhenPageObject().isAt())
////				softwhoshome11.assertTrue(new HomePage().getWhoseHomePageObject().getHomeMonitoringPageObject().getNotifyMeWhenPageObject().clickaddButton());
////				softwhoshome11.assertTrue(new HomePage().getWhoseHomePageObject().getHomeMonitoringPageObject().getNotifyMeWhenPageObject().getAddNewNotificationPageObject().selectMemberTwo());
////				softwhoshome11.assertTrue(new HomePage().getWhoseHomePageObject().getHomeMonitoringPageObject().getNotifyMeWhenPageObject().getAddNewNotificationPageObject().clickEntersHomeRadioButton());
////			super.swipeUp();
////			
////			softwhoshome11.assertTrue(new HomePage().getWhoseHomePageObject().getHomeMonitoringPageObject().getNotifyMeWhenPageObject().getAddNewNotificationPageObject().clickCustomRadioButton());
////			
////			softwhoshome11.assertTrue(new HomePage().getWhoseHomePageObject().getHomeMonitoringPageObject().getNotifyMeWhenPageObject().getAddNewNotificationPageObject().clickMondayButton());
////			softwhoshome11.assertTrue(new HomePage().getWhoseHomePageObject().getHomeMonitoringPageObject().getNotifyMeWhenPageObject().getAddNewNotificationPageObject().clickWednesdayButton());
////			softwhoshome11.assertTrue(new HomePage().getWhoseHomePageObject().getHomeMonitoringPageObject().getNotifyMeWhenPageObject().getAddNewNotificationPageObject().clickFridayButton());
////			
////			softwhoshome11.assertTrue(new HomePage().getWhoseHomePageObject().getHomeMonitoringPageObject().getNotifyMeWhenPageObject().getAddNewNotificationPageObject().clickSelectTimeButton());
////			softwhoshome11.assertTrue(new HomePage().getWhoseHomePageObject().getHomeMonitoringPageObject().getNotifyMeWhenPageObject().getAddNewNotificationPageObject().selectMinutes());
////			softwhoshome11.assertTrue(new HomePage().getWhoseHomePageObject().getHomeMonitoringPageObject().getNotifyMeWhenPageObject().getAddNewNotificationPageObject().clickTimePickerDoneButton());
////			
////			softwhoshome11.assertTrue(new HomePage().getWhoseHomePageObject().getHomeMonitoringPageObject().getNotifyMeWhenPageObject().getAddNewNotificationPageObject().clickSelectToleranceButton());
////			softwhoshome11.assertTrue(new HomePage().getWhoseHomePageObject().getHomeMonitoringPageObject().getNotifyMeWhenPageObject().getAddNewNotificationPageObject().click20MinToleranceButton());
////			softwhoshome11.assertTrue(new HomePage().getWhoseHomePageObject().getHomeMonitoringPageObject().getNotifyMeWhenPageObject().getAddNewNotificationPageObject().clickSaveButton());
////			
//////			softwhoshome11.assertTrue(new HomePage().getWhoseHomePageObject().getHomeMonitoringPageObject().getNotifyMeWhenPageObject().Verify_Member_Notifications());
////			
////			super.pause(5);
////			
////			softwhoshome11.assertAll();
////	  }
//	  
//	  @Test(priority = 63, dependsOnMethods = { "Login_And_Onboard"})
//		public void Verify_Whos_Home_Monitoring_Page_Verify_Notification2() {
//			SoftAssert softwhoshome12 = new SoftAssert();
//			
//			if(new HomePage().getWhoseHomePageObject().getHomeMonitoringPageObject().getNotifyMeWhenPageObject().isAt())
//				softwhoshome12.assertTrue(new HomePage().getWhoseHomePageObject().getHomeMonitoringPageObject().getNotifyMeWhenPageObject().verifyMemberNotifications());
//			
//			softwhoshome12.assertAll();
//	  }
	  
  }