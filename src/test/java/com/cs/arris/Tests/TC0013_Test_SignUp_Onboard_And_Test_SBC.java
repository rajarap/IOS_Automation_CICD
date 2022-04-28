package com.cs.arris.Tests;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;

import java.lang.reflect.Method;


import org.testng.annotations.BeforeMethod;

import org.testng.asserts.SoftAssert;

import com.cs.arris.Base.ParentClass;
import com.cs.arris.Pages.AccessResourcesOnDevicePage;
import com.cs.arris.Pages.AddDeviceAccessCameraDialog;
import com.cs.arris.Pages.AddDeviceActivateYourDeviceWithServiceProviderPage;
import com.cs.arris.Pages.AddDeviceChooseInternetServiceProviderPage;
import com.cs.arris.Pages.AddDeviceCongratulationsPage;
import com.cs.arris.Pages.AddDeviceEnterMACAddressManuallyPage;
import com.cs.arris.Pages.AddDeviceEstablishingConnectionPage;
import com.cs.arris.Pages.AddDeviceHomePage;
import com.cs.arris.Pages.AddDeviceLetsStartWithDeviceConnectionPage;
import com.cs.arris.Pages.AddDeviceRegistrationFailedPage;
import com.cs.arris.Pages.AddDeviceScanBarCodePage;
import com.cs.arris.Pages.AddDeviceSelectDevice1Page;
import com.cs.arris.Pages.AddDeviceSelectDevice2Page;
import com.cs.arris.Pages.AddDeviceStepsForActivationPage;
import com.cs.arris.Pages.AddDeviceSuccessPage;
import com.cs.arris.Pages.AddSatelliteAddNewSatellitePage1;
import com.cs.arris.Pages.AddSatelliteAddNewSatellitePage2;
import com.cs.arris.Pages.AddSatelliteAddNewSatellitePage3;
import com.cs.arris.Pages.AddSatelliteCongratulationsPage;
import com.cs.arris.Pages.AddSatelliteConnectedToNonMaxNetworkPage;
import com.cs.arris.Pages.AddSatelliteConnectedToNonMaxNetworkTroubleShootProceedPage;
import com.cs.arris.Pages.AddSatelliteHelpPlaceYourSatellitePage;
import com.cs.arris.Pages.AddSatelliteInstallAdditionalSatelliteDialog;
import com.cs.arris.Pages.AddSatelliteOperationFailedPage4;
//import com.cs.arris.Pages.AddSatellitePlaceYourSatellitePage;
import com.cs.arris.Pages.AddSatellitePlugInYourSatellitePage;
import com.cs.arris.Pages.AddSatelliteRegisteringDeviceFailedPage;
//import com.cs.arris.Pages.AddSatelliteRegistrationFailedPage;
import com.cs.arris.Pages.AddSatelliteSuccessfullyConnectedPage;
import com.cs.arris.Pages.AddSatelliteSuccessfullyConnectedToInternetPage;
import com.cs.arris.Pages.AddSatelliteSystemUpToDatePage;
import com.cs.arris.Pages.AddSatelliteUnPackYourSatellitePage;
//import com.cs.arris.Pages.AddSatelliteUnpackYourSatellitePage;
//import com.cs.arris.Pages.AddSatelliteUpToDatePage;
import com.cs.arris.Pages.AppRatingDialog;
import com.cs.arris.Pages.BlueToothConnectionFailedPage;
import com.cs.arris.Pages.BlueToothConnectionFailedProceedPage;
import com.cs.arris.Pages.BlueToothConnectionFailedTroubleShootPage;
//import com.cs.arris.Pages.BandSteeringModeAlertInfoDialog;
import com.cs.arris.Pages.CodeVerifiedPage;
import com.cs.arris.Pages.CongratulationsPage;
import com.cs.arris.Pages.ConnectMaxRouterToInternetPage;
import com.cs.arris.Pages.ConnectMaxRouterToMobileDevicePage;
import com.cs.arris.Pages.ConnectToBlueToothDialog;
import com.cs.arris.Pages.ConnectionToWifiNeededPage;
import com.cs.arris.Pages.DeviceLocationPage;
import com.cs.arris.Pages.DeviceSignalStrengthLeaderBoardPage;
import com.cs.arris.Pages.DevicesPage;
import com.cs.arris.Pages.EnterValidOTPPage;
import com.cs.arris.Pages.ErrorCode_0000_1506_Warranty_Support_Page;
import com.cs.arris.Pages.GetStartedPage;
import com.cs.arris.Pages.GrantPermissionsPage;
//import com.cs.arris.Pages.HomeNetowrkTurnOffNetworkOptimizationDialog;
import com.cs.arris.Pages.HomePage;
import com.cs.arris.Pages.HomeSpeedTestHistoryPage;
import com.cs.arris.Pages.InstallAdditionalSatellitePage;
import com.cs.arris.Pages.MailErrorLogsPage;
import com.cs.arris.Pages.MainDeviceAllTabPage;
//import com.cs.arris.Pages.MaximumVerificationReachedPage;
import com.cs.arris.Pages.NameYourNetwokSSIDPage;
import com.cs.arris.Pages.NetworkOptimizationDialog;
import com.cs.arris.Pages.NetworkOptimizationDialog2;
import com.cs.arris.Pages.NetworkPage;
import com.cs.arris.Pages.OptimizeYourNetworkPage;
import com.cs.arris.Pages.ParentalControlWithProfilesPage;
import com.cs.arris.Pages.PlugInMaxRouterPage;
import com.cs.arris.Pages.ResendOTPDialog;
import com.cs.arris.Pages.SelectYourDevicePage;
import com.cs.arris.Pages.SelectYourDevicePage2;
import com.cs.arris.Pages.ServiceNotAvailablePage;
import com.cs.arris.Pages.SetUpYourWiFiManagementPage;
import com.cs.arris.Pages.SetupHomeNetworkPage;
import com.cs.arris.Pages.SiginPage;
import com.cs.arris.Pages.SignupPage;
import com.cs.arris.Pages.SomethingWentWrongPage;
import com.cs.arris.Pages.SpeedTestPage;
import com.cs.arris.Pages.SystemFirmwareUpdatePage;
import com.cs.arris.Pages.TermsAndConditionsPage;
import com.cs.arris.Pages.UnPackYourBoxPage;
//import com.cs.arris.Pages.WideBandModeAlertInfoDialog;
import com.cs.arris.Utilities.Direction;
import com.cs.arris.Utilities.EmailTest;
import com.cs.arris.Utilities.KillAndRelaunchApp;
import com.cs.arris.Utilities.SerialComPortCommunicator;
import com.cs.arris.Utilities.SevenTapEmail;
import com.cs.arris.Utilities.SwipeActions;
import com.cs.arris.Utilities.TapSevenTimes;
import com.cs.arris.Utilities.TestUtils;
import com.cs.arris.Utilities.ValidOTP;
import com.cs.arris.Workflows.TC50_SignUp_And_Onboard_Workflow;

public class TC0013_Test_SignUp_Onboard_And_Test_SBC extends ParentClass
{
	TestUtils utils = new TestUtils();
	String firstName;
	String lastName;
	String email;
	String passCode;
	String ssidName;
	String ssidpass;
	String udid;
	String localWifi;
	String localWifiPwd;
	
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
			    
			  this.ssidName = super.generateRouterSSID();
			  utils.log().info("SSID Name : " + this.ssidName);
			  
			  this.ssidpass = properties.getProperty("ssidpwd");
			  utils.log().info("SSID Password : " + this.ssidpass);
			  
			  this.localWifi = properties.getProperty("localWifi");
			  this.localWifiPwd = properties.getProperty("localWifiPwd");
			  	  
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
		   utils.log().info("\n" + "****** starting test:" + m.getName() + "******" + "\n");
	  }
	  
  
	  @Test(priority = 1)
	  public void Verify_SignUp_And_Onboard()
	  { 
		  try {
			  new GetStartedPage().clickGetStartedButton();
			  new GrantPermissionsPage().clickContinueButton();
			  new DeviceLocationPage().clickAllowWhileUsingAppLink();
			  super.pause(3);
			  new AccessResourcesOnDevicePage().clickOkButton();
			  new SelectYourDevicePage().selectSurfboardMaxOption();
			  new SelectYourDevicePage().clickNextButton();
			  new SelectYourDevicePage2().selectMaxProAX11000RadioButton();
			  new SelectYourDevicePage2().clickNextButton();
			  super.pause(3);
			  
			  new SiginPage().clickSignUpButton();
			  email = new SignupPage().getEmailAddress();  //userXXXX
//			  new SignupPage().enterValidEmailAddress(email+"@mailinator.com");
//			  new SignupPage().enterValidEmailAddress(email+"@mail7.io");
			  new SignupPage().enterValidEmailAddress(email+"@mailsac.com");
			  new SignupPage().enterFirstName(firstName);
			  new SignupPage().enterLastName(lastName);
			  super.pause(5);
			  new SignupPage().clickAgreeTermsAndConditionsCheckBox();
			  super.pause(5);
			  if(new TermsAndConditionsPage().isAt()) 
			  {
				for(int i=1; i<=5; i++) {
					super.swipeUp();
				}
				try {
					if(new TermsAndConditionsPage().understandAndAgreeButton.isEnabled()) 
					{
						new TermsAndConditionsPage().clickUnderstandAndAgreeButton();
						super.pause(3);
			            new SignupPage().clickSignupButton();	
			            super.pause(3);
			            new EnterValidOTPPage().enterInValidPassCode("123456");
			            super.pause(3);
			            Assert.assertTrue(new EnterValidOTPPage().verifyInvalidPassCodeMessage());
						 new EnterValidOTPPage().clickResendLink();
						 new ResendOTPDialog().clickOKButton();
						 super.pause(15);
						 new EnterValidOTPPage().clearPassCodeText();
						 super.pause(5);
						 new EnterValidOTPPage().enterValidPassCode(email);
						 super.pause(3);
						 new CodeVerifiedPage().getCodeVerifiedText();
						 new CodeVerifiedPage().clickNextButton();
				  }
				}catch(Exception e) {
					  super.pause(120);
					  new TapSevenTimes().tapSeven();
					  super.pause(5);
					  new SevenTapEmail().enterEmailAddress();
					  super.pause(5);
					  new SevenTapEmail().clickSendButton();
					  Assert.fail("Main AP Onboarding -Failed to retrieve OTP.  This may be due to non-acceissiblity of 3rd party website or may be due to non-availability of internet connection");
					  new KillAndRelaunchApp().killApp();}
			  }

			  new OptimizeYourNetworkPage().clickSkipOptimizeButton();
			  new SetupHomeNetworkPage().clickNextButton();
			  new UnPackYourBoxPage().clickNextButton();
			  
			  try {
				  new PlugInMaxRouterPage().clickNextButton();
				  super.pause(3);
				  new ConnectToBlueToothDialog().clickOkButton();
				  super.pause(60);
				  		  
				  try {
					  if(new BlueToothConnectionFailedPage().isAt()) {
						  new BlueToothConnectionFailedPage().clickTryAgainbutton();
						  super.pause(60);
					  }
				  }catch(Exception e) {}
				  
			  }catch(Exception e) {
				  super.pause(120);
				  new TapSevenTimes().tapSeven();
				  super.pause(5);
				  new SevenTapEmail().enterEmailAddress();
				  super.pause(5);
				  new SevenTapEmail().clickSendButton();
				  Assert.fail("Main AP Onboarding - Either multiple devices were found or blue tooth connection failed");
				  new KillAndRelaunchApp().killApp();
			  }


			  new ConnectMaxRouterToMobileDevicePage().clickNextButton();
			  super.pause(60);
			  new ConnectMaxRouterToInternetPage().clickNextButton();
			  super.pause(10);
			  new SystemFirmwareUpdatePage().clickNextButton();
			  super.pause(30);
			  new SomethingWentWrongPage().clickContinueButton();
			  new NameYourNetwokSSIDPage().enterSSIDName(this.ssidName);
			  new NameYourNetwokSSIDPage().enterSSIDPassword(this.ssidpass);
			  new NameYourNetwokSSIDPage().clickNextButton();
			  super.pause(60);
			  new ConnectionToWifiNeededPage().clickJoinButton();
			  super.pause(60);
			  new CongratulationsPage().clickContinueButton();
			  super.pause(5);
			  new SetUpYourWiFiManagementPage().clickskipTutorialButton();
			  super.pause(5);
			  
			  try {
				  if(new InstallAdditionalSatellitePage().allowButton.isDisplayed())
					  new InstallAdditionalSatellitePage().clickAllowButton();
				  }catch(Exception e) {}
			  
			  new InstallAdditionalSatellitePage().clickInstallLaterButton();
			  super.pause(5);
			  new NetworkOptimizationDialog().clickOkButton();
			  utils.log().info("Waiting for 60 seconds");
			  super.pause(60);
			  
			  try {
				  if(new HomePage().getAppRatingDialogObject().isAt())
					  new HomePage().getAppRatingDialogObject().clickRemindMeLaterLink();
			  }catch(Exception e) {}
			  
			  try {
		  		if(new HomePage().cloudIcon.isDisplayed()) {
		  			new HomePage().connectToSSID(this.ssidName);
		  			utils.log().info("Waiting for 60 seconds for the Wifi connection to stabilize");
		  			super.pause(60);
		  		}
		  	 }catch(Exception e) {};
		  		
			 try {
			  	if(new HomePage().remoteAccessNotAvailableLink.isDisplayed()) {
			  		new HomePage().connectToSSID(this.ssidName);
			  		utils.log().info("Waiting for 60 seconds for the Wifi connection to stabilize");
			  		super.pause(60);
			  	}
			}catch(Exception e) {};
		  		
			new HomePage().getSSIDName();  

		  }catch(Exception e) {
			  super.pause(120);
			  new TapSevenTimes().tapSeven();
			  super.pause(5);
			  new SevenTapEmail().enterEmailAddress();
			  super.pause(5);
			  new SevenTapEmail().clickSendButton();
			  Assert.fail("Main AP Onboarding - Unable to onboard your Main Max Router ");
			  new KillAndRelaunchApp().killApp();}
	  }
	  
  
	  @Test(priority = 2, dependsOnMethods = { "Verify_SignUp_And_Onboard" })
		public void Verify_Add_Device_Menu() {
			utils.log().info("                                             ");
			utils.log().info("*********************************************");
			utils.log().info("Test: Hamburger Menu - Add and Remove Device ");
			utils.log().info("*********************************************");
			
			SoftAssert softhome2 = new SoftAssert();
			try{
				new HomePage().getFooterIconsPageObject().clickHomeButton();
			
				if(new HomePage().isAt())
					softhome2.assertTrue(new HomePage().clickNavigationButton());
			
				if(new HomePage().getHamburgerMenuPageObject().isAt())
					softhome2.assertTrue(new HomePage().getHamburgerMenuPageObject().clickAddDeviceButton());
			try {
				if(new AddDeviceSelectDevice1Page().isAt()) {
					softhome2.assertTrue(new AddDeviceSelectDevice1Page().selectISPCableRadioButton());
					softhome2.assertTrue(new AddDeviceSelectDevice1Page().clickNextButton());}
			}catch (Exception e) {
				super.pause(10);
			 	new TapSevenTimes().tapSeven();
			 	super.pause(3);
			 	new SevenTapEmail().enterEmailAddress();
			 	super.pause(3); 
			 	new SevenTapEmail().clickSendButton();
			 	Assert.fail("Add Device - Failed when selecting a device");
				  new KillAndRelaunchApp().killApp();
				  super.pause(5);
				  new KillAndRelaunchApp().relaunchApp();
				  super.pause(20);
			}
			
			try {
				if(new AddDeviceSelectDevice2Page().isAt()) {
					softhome2.assertTrue(new AddDeviceSelectDevice2Page().selectT25RadioButton());
					softhome2.assertTrue(new AddDeviceSelectDevice2Page().clickNextButton());
				super.pause(5);}
			}catch (Exception e) {
				super.pause(10);
			 	new TapSevenTimes().tapSeven();
			 	super.pause(3);
			 	new SevenTapEmail().enterEmailAddress();
			 	super.pause(3); 
			 	new SevenTapEmail().clickSendButton();
			 	Assert.fail("Add Device - Failed when selecting a device on  SELECT YOUR DEVICE BELOW Page");
				  new KillAndRelaunchApp().killApp();
				  super.pause(5);
				  new KillAndRelaunchApp().relaunchApp();
				  super.pause(20);
			}
			
			try {
				if(new AddDeviceStepsForActivationPage().isAt())
					softhome2.assertTrue(new AddDeviceStepsForActivationPage().clickStartButton());
				super.pause(5);
			}catch (Exception e) {
				super.pause(10);
			 	new TapSevenTimes().tapSeven();
			 	super.pause(3);
			 	new SevenTapEmail().enterEmailAddress();
			 	super.pause(3); 
			 	new SevenTapEmail().clickSendButton();
			 	Assert.fail("Add Device - Failed on STEPS FOR ACTIVATION - LET'S START Page");
				  new KillAndRelaunchApp().killApp();
				  super.pause(5);
				  new KillAndRelaunchApp().relaunchApp();
				  super.pause(20);
			}
			
			try {
				if(new AddDeviceLetsStartWithDeviceConnectionPage().isAt())
					softhome2.assertTrue(new AddDeviceLetsStartWithDeviceConnectionPage().clickNextButton());
				super.pause(5);
			}catch (Exception e) {
				super.pause(10);
			 	new TapSevenTimes().tapSeven();
			 	super.pause(3);
			 	new SevenTapEmail().enterEmailAddress();
			 	super.pause(3); 
			 	new SevenTapEmail().clickSendButton();
			 	Assert.fail("Add Device - Failed on LET'S START WITH DEVICE CONNECTION Page");
				  new KillAndRelaunchApp().killApp();
				  super.pause(5);
				  new KillAndRelaunchApp().relaunchApp();
				  super.pause(20);
			}
			
			try {
				if(new AddDeviceChooseInternetServiceProviderPage().isAt())
					softhome2.assertTrue(new AddDeviceChooseInternetServiceProviderPage().clickNextButton());
				super.pause(5);
			}catch (Exception e) {
				super.pause(10);
			 	new TapSevenTimes().tapSeven();
			 	super.pause(3);
			 	new SevenTapEmail().enterEmailAddress();
			 	super.pause(3); 
			 	new SevenTapEmail().clickSendButton();
			 	Assert.fail("Add Device - Failed on CHOOSE YOUR INTERNET SERVICE PROVIDER Page");
				  new KillAndRelaunchApp().killApp();
				  super.pause(5);
				  new KillAndRelaunchApp().relaunchApp();
				  super.pause(20);
			}
			
			try {
				if(new AddDeviceActivateYourDeviceWithServiceProviderPage().isAt())
					softhome2.assertTrue(new AddDeviceActivateYourDeviceWithServiceProviderPage().clickSkipButton());
				super.pause(5);
			}catch (Exception e) {
				super.pause(10);
			 	new TapSevenTimes().tapSeven();
			 	super.pause(3);
			 	new SevenTapEmail().enterEmailAddress();
			 	super.pause(3); 
			 	new SevenTapEmail().clickSendButton();
			 	Assert.fail("Add Device - Failed on ACTIVATE YOUR DEVICE WITH SERVICE PROVIDER Page");
				  new KillAndRelaunchApp().killApp();
				  super.pause(5);
				  new KillAndRelaunchApp().relaunchApp();
				  super.pause(20);
			}
			
			try {
				if(new AddDeviceEstablishingConnectionPage().isAt())
					softhome2.assertTrue(new AddDeviceEstablishingConnectionPage().clickOnlineButton());
				super.pause(5);
			}catch (Exception e) {
				super.pause(10);
			 	new TapSevenTimes().tapSeven();
			 	super.pause(3);
			 	new SevenTapEmail().enterEmailAddress();
			 	super.pause(3); 
			 	new SevenTapEmail().clickSendButton();
			 	Assert.fail("Add Device - Failed on ESTABLISHING CONNECTION Page");
				  new KillAndRelaunchApp().killApp();
				  super.pause(5);
				  new KillAndRelaunchApp().relaunchApp();
				  super.pause(20);
			}
			
			try {
				if(new AddDeviceSuccessPage().isAt())
					softhome2.assertTrue(new AddDeviceSuccessPage().clickNextButton());
				super.pause(5);
			}catch (Exception e) {
				super.pause(10);
			 	new TapSevenTimes().tapSeven();
			 	super.pause(3);
			 	new SevenTapEmail().enterEmailAddress();
			 	super.pause(3); 
			 	new SevenTapEmail().clickSendButton();
			 	Assert.fail("Add Device - Failed on SUCCESS Page");
				  new KillAndRelaunchApp().killApp();
				  super.pause(5);
				  new KillAndRelaunchApp().relaunchApp();
				  super.pause(20);
			}
			
			try {
				if(new AddDeviceScanBarCodePage().isAt())
					softhome2.assertTrue(new AddDeviceScanBarCodePage().clickScanButton());
				super.pause(5);
			}catch (Exception e) {
				super.pause(10);
			 	new TapSevenTimes().tapSeven();
			 	super.pause(3);
			 	new SevenTapEmail().enterEmailAddress();
			 	super.pause(3); 
			 	new SevenTapEmail().clickSendButton();
			 	Assert.fail("Add Device - Failed on SCAN BAR CODE TO CONTINUE Page");
				  new KillAndRelaunchApp().killApp();
				  super.pause(5);
				  new KillAndRelaunchApp().relaunchApp();
				  super.pause(20);
			}
			
			try {
				if(new AddDeviceAccessCameraDialog().isAt())
					softhome2.assertTrue(new AddDeviceAccessCameraDialog().clickEnterManuallyButton());
				super.pause(5);
			}catch (Exception e) {
				super.pause(10);
			 	new TapSevenTimes().tapSeven();
			 	super.pause(3);
			 	new SevenTapEmail().enterEmailAddress();
			 	super.pause(3); 
			 	new SevenTapEmail().clickSendButton();
			 	Assert.fail("Add Device - Failed on APPLICATION WOULD LIKE TO ACCESS THE CAMERA Page");
				  new KillAndRelaunchApp().killApp();
				  super.pause(5);
				  new KillAndRelaunchApp().relaunchApp();
				  super.pause(20);
			}
			
			try {
				if(new AddDeviceEnterMACAddressManuallyPage().isAt()) {
					softhome2.assertTrue(new AddDeviceEnterMACAddressManuallyPage().enterSerialNumber());
					softhome2.assertTrue(new AddDeviceEnterMACAddressManuallyPage().enterMACAddress());
					softhome2.assertTrue(new AddDeviceEnterMACAddressManuallyPage().clickNextButton());
					super.pause(15);}
			}catch (Exception e) {
				super.pause(10);
			 	new TapSevenTimes().tapSeven();
			 	super.pause(3);
			 	new SevenTapEmail().enterEmailAddress();
			 	super.pause(3); 
			 	new SevenTapEmail().clickSendButton();
			 	Assert.fail("Add Device - Failed on ENTER S/N AND HFC MAC ADDRESS MANUALLY IN UPPERCASE Page");
				  new KillAndRelaunchApp().killApp();
				  super.pause(5);
				  new KillAndRelaunchApp().relaunchApp();
				  super.pause(20);
			}
	 
			try {
					softhome2.assertTrue(new AddDeviceRegistrationFailedPage().clickContinueButton());
					super.pause(10);
			}catch (Exception e) {
				super.pause(10);
			 	new TapSevenTimes().tapSeven();
			 	super.pause(3);
			 	new SevenTapEmail().enterEmailAddress();
			 	super.pause(3); 
			 	new SevenTapEmail().clickSendButton();
			 	Assert.fail("Add Device - Failed on REGISTRATION OF YOUR DEVICE FAILED Page");
				  new KillAndRelaunchApp().killApp();
				  super.pause(5);
				  new KillAndRelaunchApp().relaunchApp();
				  super.pause(20);
			}
			
			try {
				if(new AddDeviceCongratulationsPage().isAt())
					softhome2.assertTrue(new AddDeviceCongratulationsPage().clickContinueButton());
				super.pause(5);
			}catch (Exception e) {
				super.pause(10);
			 	new TapSevenTimes().tapSeven();
			 	super.pause(3);
			 	new SevenTapEmail().enterEmailAddress();
			 	super.pause(3); 
			 	new SevenTapEmail().clickSendButton();
			 	Assert.fail("Add Device - Failed on CONGRATULATIONS Page");
				  new KillAndRelaunchApp().killApp();
				  super.pause(5);
				  new KillAndRelaunchApp().relaunchApp();
				  super.pause(20);
			}
			
			softhome2.assertAll();
			}catch (Exception e) {
			 	Assert.fail("Failure in Add Device Functionality ");
				  new KillAndRelaunchApp().killApp();
				  super.pause(5);
				  new KillAndRelaunchApp().relaunchApp();
				  super.pause(20);
			}
	  }
	  
		@Test(priority = 3, dependsOnMethods = { "Verify_Add_Device_Menu" })
		public void Verify_Device_Details_Page() {
			SoftAssert softhome4 = new SoftAssert();
			try {
				
				try {
					if(new AddDeviceHomePage().protectionCloseIcon.isDisplayed())
						softhome4.assertTrue(new AddDeviceHomePage().clickProtectionCloseIcon());
				}catch(Exception e) {}
				
				softhome4.assertTrue(new AddDeviceHomePage().clickDeviceDetailsText());
				
				if(new AddDeviceHomePage().getDeviceDetailsPageObject().isAt()) {
					softhome4.assertTrue(new AddDeviceHomePage().getDeviceDetailsPageObject().verifyDeviceDetailsUI());
					//softhome4.assertTrue(new AddDeviceHomePage().getDeviceDetailsPageObject().clickCloseButton());
					softhome4.assertTrue(new AddDeviceHomePage().getAddDeviceFooterIconsPageObject().clickHomeButton());
				}
				softhome4.assertAll();
				
			}catch (Exception e) {
				super.pause(10);
			 	new TapSevenTimes().tapSeven();
			 	super.pause(3);
			 	new SevenTapEmail().enterEmailAddress();
			 	super.pause(3); 
			 	new SevenTapEmail().clickSendButton();
			 	Assert.fail("Add Device - Failed on Device Details Page");
				new KillAndRelaunchApp().killApp();
				super.pause(5);
				new KillAndRelaunchApp().relaunchApp();
				super.pause(15);
			}
		}
		
		@Test(priority = 4, dependsOnMethods = { "Verify_Add_Device_Menu" })
		public void Verify_Specifications_Page() {
			SoftAssert softhome5 = new SoftAssert();
			
			try {
				softhome5.assertTrue(new AddDeviceHomePage().clickSpecificationsText());
				super.pause(5);
				if(new AddDeviceHomePage().getDeviceSpecificationsPageObject().isAt())
					softhome5.assertTrue(new AddDeviceHomePage().getDeviceSpecificationsPageObject().clickBackButton());
				
				softhome5.assertAll();
			}catch (Exception e) {
				Assert.fail("Add Device - Failed on Specifications Page");
				new KillAndRelaunchApp().killApp();
				super.pause(5);
				new KillAndRelaunchApp().relaunchApp();
				super.pause(15);
			 	new TapSevenTimes().tapSeven();
			 	super.pause(3);
			 	new SevenTapEmail().enterEmailAddress();
			 	super.pause(3); 
			 	new SevenTapEmail().clickSendButton();
			}
		}
		
		@Test(priority = 5, dependsOnMethods = { "Verify_Add_Device_Menu" })
		public void Verify_Add_Additional_Device() {
			SoftAssert softhome6 = new SoftAssert();
			
			try {
				if(new AddDeviceHomePage().isAt())
					softhome6.assertTrue(new AddDeviceHomePage().clickNavigationButton());
					
				if(new AddDeviceHomePage().getHamburgerMenuObject().isAt())
					softhome6.assertTrue(new AddDeviceHomePage().getHamburgerMenuObject().clickAddDeviceButton());
					
				if(new AddDeviceHomePage().getMaxTwoDevicesDialogObject().isAt())
					softhome6.assertTrue(new AddDeviceHomePage().getMaxTwoDevicesDialogObject().clickOkButton());
				
				softhome6.assertAll();
				
			}catch (Exception e) {
				Assert.fail("Add Device - Failed on Adding additional device Page");
				new KillAndRelaunchApp().killApp();
				super.pause(5);
				new KillAndRelaunchApp().relaunchApp();
				super.pause(15);
			 	new TapSevenTimes().tapSeven();
			 	super.pause(3);
			 	new SevenTapEmail().enterEmailAddress();
			 	super.pause(3); 
			 	new SevenTapEmail().clickSendButton();
			}
		}
		
		@Test(priority = 6, dependsOnMethods = { "Verify_Add_Device_Menu" })
		public void Verify_Notifications_Page() {
			SoftAssert softhome7 = new SoftAssert();
			
			try {
				if(new AddDeviceHomePage().isAt())
					softhome7.assertTrue(new AddDeviceHomePage().clickNotificationsIcon());
				
				if(new AddDeviceHomePage().getNotificationsPageObject().isAt())
					softhome7.assertTrue(new AddDeviceHomePage().getNotificationsPageObject().clickBackButton());
				
				softhome7.assertAll();
			}catch (Exception e) {
			 	new TapSevenTimes().tapSeven();
			 	super.pause(3);
			 	new SevenTapEmail().enterEmailAddress();
			 	super.pause(3); 
			 	new SevenTapEmail().clickSendButton();
			 	Assert.fail("Add Device - Failed on Notifications Page");
				new KillAndRelaunchApp().killApp();
				super.pause(5);
				new KillAndRelaunchApp().relaunchApp();
				super.pause(15);
			}

		}
		
		@Test(priority = 7, dependsOnMethods = { "Verify_Add_Device_Menu" })
		public void Verify_User_Guide_Page() {
			SoftAssert softhome8 = new SoftAssert();
			
			try {
				if(new AddDeviceHomePage().isAt())
					softhome8.assertTrue(new AddDeviceHomePage().getAddDeviceFooterIconsPageObject().clickUserGuideButton());
				super.pause(3);

				if(new AddDeviceHomePage().getUserGuidePageObject().isAt())
					super.swipeUp();

				softhome8.assertAll();
				
			} catch (Exception e) {
				Assert.fail("Add Device - Failed on UserGuide Page");
				new KillAndRelaunchApp().killApp();
				super.pause(5);
				new KillAndRelaunchApp().relaunchApp();
				super.pause(15);
			 	new TapSevenTimes().tapSeven();
			 	super.pause(3);
			 	new SevenTapEmail().enterEmailAddress();
			 	super.pause(3); 
			 	new SevenTapEmail().clickSendButton();
			}
		}
		
		@Test(priority = 8, dependsOnMethods = { "Verify_Add_Device_Menu" })
		public void Verify_FAQ_Page() {
			SoftAssert softhome9 = new SoftAssert();
			try {
				softhome9.assertTrue(new AddDeviceHomePage().getAddDeviceFooterIconsPageObject().clickFAQButton());
				super.pause(3);
				
				if(new AddDeviceHomePage().getFAQPageObject().isAt())
					super.swipeUp();
				softhome9.assertTrue(new AddDeviceHomePage().getAddDeviceFooterIconsPageObject().clickHomeButton());
				softhome9.assertAll();
				
			} catch (Exception e) {
				Assert.fail("Add Device - Failed on FAQ Page");
				new KillAndRelaunchApp().killApp();
				super.pause(5);
				new KillAndRelaunchApp().relaunchApp();
				super.pause(15);
			 	new TapSevenTimes().tapSeven();
			 	super.pause(3);
			 	new SevenTapEmail().enterEmailAddress();
			 	super.pause(3); 
			 	new SevenTapEmail().clickSendButton();
			}

		}
		
		@Test(priority = 9, dependsOnMethods = { "Verify_Add_Device_Menu" })
		public void Verify_Remove_Device_Page() {
			SoftAssert softhome10 = new SoftAssert();
			
			try {
				if(new AddDeviceHomePage().isAt())
					softhome10.assertTrue(new AddDeviceHomePage().clickNavigationButton());
					
				if(new AddDeviceHomePage().getHamburgerMenuObject().isAt())
					softhome10.assertTrue(new AddDeviceHomePage().getHamburgerMenuObject().clickRemoveDeviceButton());
				
				if(new AddDeviceHomePage().getRemoveDevicePageObject().isAt()) {
					softhome10.assertTrue(new AddDeviceHomePage().getRemoveDevicePageObject().selectDeviceToRemove());
					softhome10.assertTrue(new AddDeviceHomePage().getRemoveDevicePageObject().clickNextButton());
					super.pause(10);}
					
				softhome10.assertAll();
			} catch (Exception e) {
				Assert.fail("Add Device - Failed on FAQ Page");
				new KillAndRelaunchApp().killApp();
				super.pause(5);
				new KillAndRelaunchApp().relaunchApp();
				super.pause(15);
			 	new TapSevenTimes().tapSeven();
			 	super.pause(3);
			 	new SevenTapEmail().enterEmailAddress();
			 	super.pause(3); 
			 	new SevenTapEmail().clickSendButton();
			}
		}
	  
		//TC008_Login_And_Test_Hamburger_Menu_And_Settings_About_Help_Page
		@Test(priority = 10, dependsOnMethods = { "Verify_SignUp_And_Onboard" })
		public void Verify_Hamburger_Menu_Page() {
			utils.log().info("                                            ");
			utils.log().info("********************************************");
			utils.log().info("Test: Hamburger Menu - Settings Menu Option ");
			utils.log().info("********************************************");
			SoftAssert softburger2 = new SoftAssert();
			new HomePage().getFooterIconsPageObject().clickHomeButton();
			softburger2.assertTrue(new HomePage().clickNavigationButton());
			if(new HomePage().getHamburgerMenuPageObject().isAt()) 
				softburger2.assertTrue(new HomePage().getHamburgerMenuPageObject().verifyUIOnHamburgerMenuPage());
			
			softburger2.assertAll();
		}
		
		@Test(priority = 11, dependsOnMethods = { "Verify_SignUp_And_Onboard" })
		public void Verify_Hamburger_Menu_Settings_UI_Page() {
			SoftAssert softburger3 = new SoftAssert();
			softburger3.assertTrue(new HomePage().getHamburgerMenuPageObject().clickSettingsButton());
//			if(new HomePage().getHamburgerMenuPageObject().getSettingsPageObject().isAt())
//				softburger3.assertTrue(new HomePage().getHamburgerMenuPageObject().getSettingsPageObject().verifyUIOnSettingsPage());

			softburger3.assertAll();
		}
		
		@Test(priority = 12)	
		public void Verify_Hamburger_Menu_Settings_Help_Page() {
			SoftAssert softburger5 = new SoftAssert();
			softburger5.assertTrue(new HomePage().getHamburgerMenuPageObject().getSettingsPageObject().clickHelpIcon());
			softburger5.assertTrue(new HomePage().getHamburgerMenuPageObject().getSettingsPageObject().getSettingsHelpPageObject().clickCloseButton());
			
			softburger5.assertAll();
		}
		
		@Test(priority = 13, dependsOnMethods = { "Verify_SignUp_And_Onboard" })
		public void Verify_Hamburger_Menu_Settings_Sign_Out() {
			SoftAssert softburger4 = new SoftAssert();
			String userEmail = new HomePage().getHamburgerMenuPageObject().getSettingsPageObject().getUserEmailAddress();
			softburger4.assertTrue(new HomePage().getHamburgerMenuPageObject().getSettingsPageObject().clickSignOutButton());
			super.pause(5);
			if(userEmail.equals(new SiginPage().emailAddressTextBox.getText())) {
				softburger4.assertTrue(new SiginPage().clickSigninButton());
				super.pause(5);	
//				try {
//					if(new EnterValidOTPPage().otpCode.isDisplayed()) {
//						passCode = new ValidOTP().getValidOTP();
//						new EnterValidOTPPage().enterValidPassCode(passCode);
//						super.pause(5);
//						new CodeVerifiedPage().getCodeVerifiedText();
//						new CodeVerifiedPage().clickNextButton();
//						super.pause(35);
//						try {
//							if(new CodeVerifiedPage().continueOnBoardingButton.isDisplayed())
//								new CodeVerifiedPage().clickContinueOnboardingButton();
//							}catch(Exception e) {}	
//						}
//					new OptimizeYourNetworkPage().clickSkipOptimizeButton();
//				}catch(Exception e) {utils.log().info("OTP screen did not appear");}
			}
			softburger4.assertAll();
		}
		
		@Test(priority = 14, dependsOnMethods = { "Verify_SignUp_And_Onboard" })
		public void Verify_Hamburger_Menu_About_UI_Page() {
		utils.log().info("                                         ");
		utils.log().info("*****************************************");
		utils.log().info("Test: Hamburger Menu - About Menu Option ");
		utils.log().info("*****************************************");
			SoftAssert softburger6 = new SoftAssert();
			new HomePage().getFooterIconsPageObject().clickHomeButton();
			softburger6.assertTrue(new HomePage().clickNavigationButton());
			if(new HomePage().getHamburgerMenuPageObject().isAt()) 
				softburger6.assertTrue(new HomePage().getHamburgerMenuPageObject().clickAboutAppButton());
			
//			if(new HomePage().getHamburgerMenuPageObject().getAboutPageObject().isAt())
//				softburger6.assertTrue(new HomePage().getHamburgerMenuPageObject().getAboutPageObject().verifyUIOnAboutPage());
			
			softburger6.assertAll();
		}
		
		@Test(priority = 15, dependsOnMethods = { "Verify_SignUp_And_Onboard" })
		public void Verify_Hamburger_Menu_About_License_Page() {
			SoftAssert softburger7 = new SoftAssert();
			softburger7.assertTrue(new HomePage().getHamburgerMenuPageObject().getAboutPageObject().clickLicenseButton());
			super.pause(3);
			if(new HomePage().getHamburgerMenuPageObject().getAboutPageObject().getLicensesPageObject().isAt())
				softburger7.assertTrue(new HomePage().getHamburgerMenuPageObject().getAboutPageObject().getLicensesPageObject().clickCloseButton());
			
			softburger7.assertAll();
		}
		
		@Test(priority = 16, dependsOnMethods = { "Verify_SignUp_And_Onboard" })
		public void Verify_Hamburger_Get_Another_Max_Page() {
			SoftAssert softburger8 = new SoftAssert();
			if(new HomePage().getHamburgerMenuPageObject().getAboutPageObject().isAt())
				softburger8.assertTrue(new HomePage().getHamburgerMenuPageObject().getAboutPageObject().clickGetAnotherMaxRouterButton());
				
			softburger8.assertAll();
		}
		
		@Test(priority = 17, dependsOnMethods = { "Verify_SignUp_And_Onboard" })
		public void Verify_Hamburger_About_Help_Page() {
			SoftAssert softburger9 = new SoftAssert();
			if(new HomePage().getHamburgerMenuPageObject().getAboutPageObject().isAt()) {
				softburger9.assertTrue(new HomePage().getHamburgerMenuPageObject().getAboutPageObject().clickHelpIcon());
				softburger9.assertTrue(new HomePage().getHamburgerMenuPageObject().getAboutPageObject().getAboutHelpPageObject().clickCloseButton());
				softburger9.assertTrue(new HomePage().getHamburgerMenuPageObject().getAboutPageObject().clickBackButton());}
			
			softburger9.assertAll();
		}
		
		@Test(priority = 18, dependsOnMethods = { "Verify_SignUp_And_Onboard" })
		public void Verify_Hamburger_Surfboard_Help_UI_Page() {
		utils.log().info("                                        ");
		utils.log().info("****************************************");
		utils.log().info("Test: Hamburger Menu - Help Menu Option ");
		utils.log().info("****************************************");
			SoftAssert softburger10 = new SoftAssert();
			new HomePage().getFooterIconsPageObject().clickHomeButton();
			softburger10.assertTrue(new HomePage().clickNavigationButton());
			
			if(new HomePage().getHamburgerMenuPageObject().isAt()) 
				softburger10.assertTrue(new HomePage().getHamburgerMenuPageObject().clickHelpMenuButton());
			
//			if(new HomePage().getHamburgerMenuPageObject().getHelpPageObject().isAt())
//				softburger10.assertTrue(new HomePage().getHamburgerMenuPageObject().getHelpPageObject().verifyUIOnHelpPage());
			
			softburger10.assertAll();
		}
			
//		@Test(priority = 19, dependsOnMethods = { "Verify_SignUp_And_Onboard" })
//		public void Verify_Hamburger_Surfboard_FAQ_Help_Page() {
//			SoftAssert softburger11 = new SoftAssert();
//			softburger11.assertTrue(new HomePage().getHamburgerMenuPageObject().getHelpPageObject().clickFAQButton());
//			
//			if(new HomePage().getHamburgerMenuPageObject().getHelpPageObject().getFAQHelpPageObject().isAt()) {
//				//softburger11.assertTrue(new HomePage().getHamburgerMenuPageObject().getHelpPageObject().getFAQHelpPageObject().verifyUIOnFAQHelpPage());
//				softburger11.assertTrue(new HomePage().getHamburgerMenuPageObject().getHelpPageObject().getFAQHelpPageObject().clickBackButton());}
//			
//			softburger11.assertAll();
//		}
		
		@Test(priority = 20, dependsOnMethods = { "Verify_SignUp_And_Onboard" })
		public void Verify_Hamburger_Surfboard_Self_Help_Page() {
			SoftAssert softburger12 = new SoftAssert();
			softburger12.assertTrue(new HomePage().getHamburgerMenuPageObject().getHelpPageObject().clickSelfHelp());
			
			softburger12.assertAll();
		}
		
		@Test(priority = 21, dependsOnMethods = { "Verify_SignUp_And_Onboard" })
		public void Verify_Hamburger_Surfboard_Chat_With_US_Page() {
			SoftAssert softburger13 = new SoftAssert();
			softburger13.assertTrue(new HomePage().getHamburgerMenuPageObject().getHelpPageObject().clickLiveChatHelp());
			softburger13.assertTrue(new HomePage().getHamburgerMenuPageObject().getHelpPageObject().clickBackButton());
			
			softburger13.assertAll();
		}	
		
		
		//TC009_Login_And_Test_Hamburger_Menu_Amazon_Feature
		@Test(priority = 22, dependsOnMethods = { "Verify_SignUp_And_Onboard" })
		public void Verify_Amazon_Features_UI_Page() {
		utils.log().info("                                                   ");
		utils.log().info("***************************************************");
		utils.log().info("Test: Hamburger Menu - Amazon Features Menu Option ");
		utils.log().info("***************************************************");
			SoftAssert softfeatures3 = new SoftAssert();
			new HomePage().getFooterIconsPageObject().clickHomeButton();
			softfeatures3.assertTrue(new HomePage().clickNavigationButton());
			softfeatures3.assertTrue(new HomePage().getHamburgerMenuPageObject().clickAmazonFeaturesButton());
//			if(new HomePage().getHamburgerMenuPageObject().getAmazonFeaturesPageObject().isAt())
//				softfeatures3.assertTrue(new HomePage().getHamburgerMenuPageObject().getAmazonFeaturesPageObject().verifyUIOnAFFSPage());
			
			softfeatures3.assertAll();
		}
		
		@Test(priority = 23, dependsOnMethods = { "Verify_SignUp_And_Onboard" })
		public void Verify_Get_Alexa_Skills_Drop_Down_Box() {
			SoftAssert softfeatures4 = new SoftAssert();
			softfeatures4.assertTrue(new HomePage().getHamburgerMenuPageObject().getAmazonFeaturesPageObject().clickGetAlexaSkillsButton());
			softfeatures4.assertTrue(new HomePage().getHamburgerMenuPageObject().getAmazonFeaturesPageObject().alexaSkillsContent.isDisplayed());
			softfeatures4.assertTrue(new HomePage().getHamburgerMenuPageObject().getAmazonFeaturesPageObject().clickAlexaSkillsButtonAgain());
			
			softfeatures4.assertAll();
		}
		
		@Test(priority = 24, dependsOnMethods = { "Verify_SignUp_And_Onboard" })
		public void Verify_Show_Password_Button() {
			SoftAssert softfeatures5 = new SoftAssert();
			softfeatures5.assertTrue(new HomePage().getHamburgerMenuPageObject().getAmazonFeaturesPageObject().clickShowPasswordButton());
			softfeatures5.assertTrue(new HomePage().getHamburgerMenuPageObject().getAmazonFeaturesPageObject().clickShowPasswordButtonAgain());
			
			softfeatures5.assertAll();

		}
		
		@Test(priority = 25, dependsOnMethods = { "Verify_SignUp_And_Onboard" })
		public void Verify_Copy_Password() {
			SoftAssert softfeatures6 = new SoftAssert();
			softfeatures6.assertTrue(new HomePage().getHamburgerMenuPageObject().getAmazonFeaturesPageObject().clickCopyPasswordButton());
			softfeatures6.assertTrue(new HomePage().getHamburgerMenuPageObject().getAmazonFeaturesPageObject().clickCopyPasswordOKButton());
			softfeatures6.assertTrue(new HomePage().getHamburgerMenuPageObject().getAmazonFeaturesPageObject().clickBackButton());
			
			softfeatures6.assertAll();
		}
		
//		@Test(priority = 26, dependsOnMethods = { "Verify_SignUp_And_Onboard" })
//		public void Verify_AlexaSkills_Link() {
//			SoftAssert softfeatures6 = new SoftAssert();
//			softfeatures6.assertTrue(new HomePage().getHamburgerMenuPageObject().getAmazonFeaturesPageObject().clickAlexaSkillsLink());
//			
//			softfeatures6.assertAll();
//		}
		
	  
		  @Test(priority = 31, dependsOnMethods = { "Verify_SignUp_And_Onboard"})
			public void Verify_Speed_Test_Page() {
				utils.log().info("                                         ");
				utils.log().info("*****************************************");
				utils.log().info("Test: Speed Test and Speed Test History   ");
				utils.log().info("******************************************");
				SoftAssert softspeedtest2 = new SoftAssert();
				new HomePage().getFooterIconsPageObject().clickHomeButton();
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
			
				softspeedtest2.assertAll();
		  }
		  
		  @Test(priority = 32, dependsOnMethods = { "Verify_SignUp_And_Onboard", "Verify_Speed_Test_Page"})
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
		  
		  @Test(priority = 33, dependsOnMethods = { "Verify_SignUp_And_Onboard", "Verify_Speed_Test_Page"})
			public void Verify_Speed_Test_Help_page() {
				SoftAssert softspeedtest4 = new SoftAssert();
				softspeedtest4.assertTrue(new SpeedTestPage().clickHelpButton());
				softspeedtest4.assertTrue(new SpeedTestPage().getSpeedTestHelpPageObject().clickCloseButton());
				softspeedtest4.assertTrue(new SpeedTestPage().clickBackButton());
				softspeedtest4.assertAll();
			}
		  
		  @Test(priority = 34, dependsOnMethods = { "Verify_SignUp_And_Onboard", "Verify_Speed_Test_Page"})
			public void Verify_Home_Speed_Test_History_Page() {
				SoftAssert softspeedtest5 = new SoftAssert();
				if(new HomePage().isAt()) 
					super.swipeUp();
				super.pause(5);
				softspeedtest5.assertTrue(new HomePage().clickSpeedTestHistoryImage());
				
				if(new HomeSpeedTestHistoryPage().isAt())
					softspeedtest5.assertTrue(new HomeSpeedTestHistoryPage().verifyHomeSpeedTestHistory());
				
				softspeedtest5.assertTrue(new HomeSpeedTestHistoryPage().getFooterIconsPageObject().clickHomeButton());
				super.swipeDown();
				
				softspeedtest5.assertAll();
		  }
	  
		  @Test(priority = 35, dependsOnMethods = { "Verify_SignUp_And_Onboard" })
			public void Verify_Main_Device_UI_On_All_Tab_Page() {
			  
				utils.log().info("                          ");
				utils.log().info("**************************");
				utils.log().info("Test: Verify Main Device  ");
				utils.log().info("**************************");
				SoftAssert softmain2 = new SoftAssert();
				new HomePage().getFooterIconsPageObject().clickHomeButton();
				super.swipeDown();
				super.pause(5);
				softmain2.assertTrue(new HomePage().clickMainDeviceImage());
				super.pause(5);
				
				softmain2.assertAll();
			}
			
			@Test(priority = 36, dependsOnMethods    = { "Verify_SignUp_And_Onboard", "Verify_Main_Device_UI_On_All_Tab_Page" })
			public void Verify_LED_Settings_UI_On_All_Tab() {
				SoftAssert softmain3 = new SoftAssert();
				softmain3.assertTrue(new MainDeviceAllTabPage().verifyUIOnLedSettings());
				
				softmain3.assertAll();
			}
			
			@Test(priority = 37, dependsOnMethods = { "Verify_SignUp_And_Onboard",  "Verify_LED_Settings_UI_On_All_Tab"})
			public void Verify_Decrease_LED_Settings_On_All_Tab_Page() {
				SoftAssert softmain4 = new SoftAssert();
				new MainDeviceAllTabPage().clickLEDExpandButton();
				new MainDeviceAllTabPage().mobileSwipeSeekBar(Direction.LEFT);
				
				softmain4.assertAll();
			}
			
			@Test(priority = 38, dependsOnMethods = { "Verify_SignUp_And_Onboard",  "Verify_LED_Settings_UI_On_All_Tab"})
	  		public void Verify_Increase_LED_Settings_On_All_Tab_Page() {
				SoftAssert softmain5 = new SoftAssert();
				new MainDeviceAllTabPage().mobileSwipeSeekBar(Direction.RIGHT);
				new MainDeviceAllTabPage().clickLEDExpandButton();
				
				softmain5.assertAll();
			}
			
			@Test(priority = 39, dependsOnMethods = { "Verify_SignUp_And_Onboard",  "Verify_Main_Device_UI_On_All_Tab_Page"})
			public void Verify_Devices_Count_Validation_On_All_Tab_Page() {
				SoftAssert softmain6 = new SoftAssert();
				//softmain6.assertTrue(new MainDeviceAllTabPage().allTabvalidations());

				softmain6.assertAll();
			}
			
			@Test(priority = 40, dependsOnMethods = { "Verify_SignUp_And_Onboard",  "Verify_Main_Device_UI_On_All_Tab_Page"})
			public void Verify_Connected_Devices_On_All_Tab_Page() {
				SoftAssert softmain7 = new SoftAssert();
				softmain7.assertTrue(new MainDeviceAllTabPage().verifyConnectedDeviceDetails());
				
				softmain7.assertAll();
			}
			
			@Test(priority = 41, dependsOnMethods = { "Verify_SignUp_And_Onboard",  "Verify_Main_Device_UI_On_All_Tab_Page"})
			public void Verify_Main_Router_Details_On_All_Tab_Page() {
				SoftAssert softmain8 = new SoftAssert();
				softmain8.assertTrue(new MainDeviceAllTabPage().verifyMainRouterDetails());
				
				softmain8.assertAll();
			}
			
//			@Test(priority = 42, dependsOnMethods = { "Verify_SignUp_And_Onboard",  "Verify_Main_Device_UI_On_All_Tab_Page"})
//			public void Verify_Edit_Main_Router_Name_On_All_Tab_Page() {
//				SoftAssert softmain9 = new SoftAssert();
//				softmain9.assertTrue(new MainDeviceAllTabPage().clickMainDeviceEditIcon());
//				
//				if(new MainDeviceAllTabPage().getEditMainDeviceNameDialogObject().isAt())
//				{
//					softmain9.assertTrue(new MainDeviceAllTabPage().getEditMainDeviceNameDialogObject().editMainDeviceName());
//					softmain9.assertTrue(new MainDeviceAllTabPage().getEditMainDeviceNameDialogObject().clickSaveButton());
//					super.pause(5);				
//				}
//				
//				softmain9.assertAll();
//			}
			
			@Test(priority = 44, dependsOnMethods = { "Verify_SignUp_And_Onboard"})
			public void Verify_Main_Device_UI_On_5GHz_Tab_Page() {
				SoftAssert softmain11 = new SoftAssert();		
				super.pause(3);	
				softmain11.assertTrue(new MainDeviceAllTabPage().click5GhzTab());
				
				softmain11.assertAll();
			}
			
			@Test(priority = 48, dependsOnMethods = { "Verify_SignUp_And_Onboard",  "Verify_Main_Device_UI_On_5GHz_Tab_Page"})
			public void Verify_Devices_Count_Validation_On_5GHz_Tab_Page() {
				SoftAssert softmain15 = new SoftAssert();
				super.pause(20);
			//	softmain15.assertTrue(new MainDeviceAllTabPage().get5GHzPageObject().GHz5Tabvalidations());
				
			softmain15.assertAll();
			}
			
			@Test(priority = 49, dependsOnMethods = { "Verify_SignUp_And_Onboard",  "Verify_Main_Device_UI_On_5GHz_Tab_Page"})
			public void Verify_Connected_Devices_On_5GHz_Tab_Page() {
				SoftAssert softmain16 = new SoftAssert();
				softmain16.assertTrue(new MainDeviceAllTabPage().get5GHzPageObject().verifyConnectedDeviceDetails());
				
				softmain16.assertAll();
			}

			@Test(priority = 53, dependsOnMethods = { "Verify_SignUp_And_Onboard"})
			public void Verify_Main_Device_UI_On_24GHz_Tab_Page() {
				SoftAssert softmain20 = new SoftAssert();
				super.pause(3);	
				softmain20.assertTrue(new MainDeviceAllTabPage().click24GhzTab());

				softmain20.assertAll();
			}
		
			@Test(priority = 57, dependsOnMethods = { "Verify_SignUp_And_Onboard",  "Verify_Main_Device_UI_On_24GHz_Tab_Page"})
			public void Verify_Devices_Count_Validation_On_24GHz_Tab_Page() {
				SoftAssert softmain24 = new SoftAssert();
				//softmain24.assertTrue(new MainDeviceAllTabPage().get24GHzPageObject().GHz24Tabvalidations());
				softmain24.assertAll();
			}
			
			@Test(priority = 58, dependsOnMethods = { "Verify_SignUp_And_Onboard",  "Verify_Main_Device_UI_On_24GHz_Tab_Page"})
			public void Verify_Connected_Devices_On_24GHz_Tab_Page() {
				SoftAssert softmain25 = new SoftAssert();
				softmain25.assertTrue(new MainDeviceAllTabPage().get24GHzPageObject().verifyConnectedDeviceDetails());
				
				softmain25.assertAll();
			}

			@Test(priority = 62, dependsOnMethods = { "Verify_SignUp_And_Onboard"})
			public void Verify_Main_Device_UI_On_Ethernet_Tab_Page() {
				SoftAssert softmain29 = new SoftAssert();
				super.pause(3);	
				softmain29.assertTrue(new MainDeviceAllTabPage().clickEthernetTab());	
				softmain29.assertAll();
			}
				
			@Test(priority = 66, dependsOnMethods = { "Verify_SignUp_And_Onboard",  "Verify_Main_Device_UI_On_Ethernet_Tab_Page"})
			public void Verify_Devices_Count_Validation_On_Ethernet_Tab_Page() {
				SoftAssert softmain33 = new SoftAssert();
				//softmain33.assertTrue(new MainDeviceAllTabPage().getEthernetPageObject().ethernetTabvalidations());
				
				softmain33.assertAll();
			}
			
			@Test(priority = 67, dependsOnMethods = { "Verify_SignUp_And_Onboard",  "Verify_Main_Device_UI_On_Ethernet_Tab_Page"})
			public void Verify_Connected_Devices_On_Ethernet_Tab_Page() {
				SoftAssert softmain34 = new SoftAssert();
				softmain34.assertTrue(new MainDeviceAllTabPage().getEthernetPageObject().verifyConnectedDeviceDetails());
				
				softmain34.assertAll();
			}

			@Test(priority = 71, dependsOnMethods = { "Verify_SignUp_And_Onboard"})
			public void Verify_Main_Device_Help_Page() {
				SoftAssert softmain38 = new SoftAssert();
				softmain38.assertTrue(new MainDeviceAllTabPage().getEthernetPageObject().clickHelpButton());
				
				if(new MainDeviceAllTabPage().getMainRouterDetailsHelpPageObject().isAt())
					new MainDeviceAllTabPage().getMainRouterDetailsHelpPageObject().clickCloseButton();
				
				new MainDeviceAllTabPage().getEthernetPageObject().clickBackButton();
							
				softmain38.assertAll();
			}
		  
			@Test(priority = 72, dependsOnMethods = { "Verify_SignUp_And_Onboard"})
			public void Verify_Devices_UI_Page() {
				utils.log().info("                                            ");
				utils.log().info("********************************************");
				utils.log().info("Test: Online and Offline Connected Devices  ");
				utils.log().info("********************************************");
				SoftAssert softdevices2 = new SoftAssert();
				new HomePage().getFooterIconsPageObject().clickHomeButton();
				super.pause(5);
				super.swipeDown();
				super.pause(5);
				if(new HomePage().isAt())
					softdevices2.assertTrue(new HomePage().clickDevicesImage());
				
				softdevices2.assertAll();
			}
				
			@Test(priority = 73, dependsOnMethods = { "Verify_SignUp_And_Onboard", "Verify_Devices_UI_Page"})
			public void Verify_Online_Devices_Details() 
			{
				SoftAssert softdevices3 = new SoftAssert();
				softdevices3.assertTrue(new DevicesPage().verifyOnlineDeviceDetails());
				
				softdevices3.assertAll();
			}
			
			@Test(priority = 74, dependsOnMethods = { "Verify_SignUp_And_Onboard", "Verify_Devices_UI_Page"})
			public void Verify_Offline_Devices_Details() 
			{
				SoftAssert softdevices5 = new SoftAssert();
				softdevices5.assertTrue(new DevicesPage().verifyOfflineDeviceDetails());
				
				softdevices5.assertAll();
			}
			
			@Test(priority = 75, dependsOnMethods = { "Verify_SignUp_And_Onboard", "Verify_Devices_UI_Page"})
			public void Verify_Devices_Help_Page() 
			{
				SoftAssert softdevices6 = new SoftAssert();
				softdevices6.assertTrue(new DevicesPage().clickHelpButton());
				if(new DevicesPage().getDevicesHelpPageObject().isAt())
					softdevices6.assertTrue(new DevicesPage().getDevicesHelpPageObject().clickCloseButton());
				softdevices6.assertTrue(new DevicesPage().clickBackButton());
				
				softdevices6.assertAll();
			}
		  
			@Test(priority = 76, dependsOnMethods = { "Verify_SignUp_And_Onboard"})
			public void Verify_Devices_Signal_Strength_UI_Page() {
				utils.log().info("                                            ");
				utils.log().info("********************************************");
				utils.log().info("Test: Device Signal Strength Leader Board   ");
				utils.log().info("********************************************");
				SoftAssert softsignal2 = new SoftAssert();
				new HomePage().getFooterIconsPageObject().clickHomeButton();
				super.swipeUp();
				new HomePage().clickDeviceSignalStrengthImage();
				
				softsignal2.assertAll();
			}
				
			@Test(priority = 77, dependsOnMethods = { "Verify_SignUp_And_Onboard", "Verify_Devices_Signal_Strength_UI_Page"})
			public void Verify_Sorting_Devices_From_Strong_To_Weak() {
				SoftAssert softsignal4= new SoftAssert();
				super.pause(5);
				softsignal4.assertTrue(new DeviceSignalStrengthLeaderBoardPage().verifySignalStrengthStrongToWeak());
				
				softsignal4.assertAll();
			}
			
			@Test(priority = 78, dependsOnMethods = { "Verify_SignUp_And_Onboard", "Verify_Devices_Signal_Strength_UI_Page"})
			public void Verify_Sorting_Devices_From_Weak_To_Strong() {
				SoftAssert softsignal5= new SoftAssert();
				super.pause(5);
				softsignal5.assertTrue(new DeviceSignalStrengthLeaderBoardPage().verifySignalStrengthWeakToStrong());
				new DeviceSignalStrengthLeaderBoardPage().getFooterIconsPageObject().clickHomeButton();
				
				softsignal5.assertAll();
			}
			
			  @Test(priority = 79, dependsOnMethods = {"Verify_SignUp_And_Onboard" })
				public void Verify_Parental_Control_UI_Page() {
					utils.log().info("                                ");
					utils.log().info("********************************");
					utils.log().info("Test: Parental Control Feature  ");
					utils.log().info("********************************");
					SoftAssert softcontrol2 = new SoftAssert();
					softcontrol2.assertTrue(new HomePage().getFooterIconsPageObject().clickParentalButton());

					softcontrol2.assertAll();
				}
				
				@Test(priority = 80, dependsOnMethods = {"Verify_SignUp_And_Onboard" , "Verify_Parental_Control_UI_Page"})
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
						for(int i = 1; i <= 3; i++)	{
							softcontrol3.assertTrue(new ParentalControlWithProfilesPage().clickAddProfilesLink());
							softcontrol3.assertTrue(new ParentalControlWithProfilesPage().getAddProfileDialogObject().enterProfileName());
							softcontrol3.assertTrue(new ParentalControlWithProfilesPage().getAddProfileDialogObject().clickCreateProfileButton());
							super.pause(3);
						}
					}
					
					softcontrol3.assertAll();
				}
				
				@Test(priority = 81, dependsOnMethods = {"Verify_SignUp_And_Onboard" , "Verify_Parental_Control_UI_Page"})
				public void Verify_User_Profile_Page() {
					SoftAssert softcontrol4 = new SoftAssert();
					if(new ParentalControlWithProfilesPage().isAt())
						softcontrol4.assertTrue(new ParentalControlWithProfilesPage().clickOnUserProfile());
					super.pause(5);
					
					softcontrol4.assertAll();
				}
							
				@Test(priority = 83, dependsOnMethods = {"Verify_SignUp_And_Onboard" , "Verify_User_Profile_Page"})
				public void Verify_Edit_User_Profile_Name() {
					SoftAssert softcontrol6 = new SoftAssert();
					softcontrol6.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().getExistingUserName());
					softcontrol6.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().clickUserProfileNameEditButton());
					
					if(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalEditUserProfileDialogObject().isAt()){
						softcontrol6.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalEditUserProfileDialogObject().enterUserProfileName());
						softcontrol6.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalEditUserProfileDialogObject().clickSaveButton());
						super.pause(3);
					}
					softcontrol6.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().validateUserProfileEditedName());
					softcontrol6.assertAll();
				}
				
				@Test(priority = 84, dependsOnMethods = {"Verify_SignUp_And_Onboard" , "Verify_User_Profile_Page"})
				public void Verify_Add_Device_To_User_Profile() {
					SoftAssert softcontrol7 = new SoftAssert();
					softcontrol7.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().clickAddDeviceLink());
					super.pause(40);
					
					if(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddDevicePageObject().isAt()) {
						
						utils.log().info("Clicking on Add Device button without selecting any device");
						softcontrol7.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddDevicePageObject().clickAddDeviceButton());
						super.pause(40);
						if(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddDevicePageObject().alertTitle.isDisplayed()) {
							utils.log().info("An Alert message - " + new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddDevicePageObject().alertTitle.getText()+ "  is displayed");
						}
						softcontrol7.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddDevicePageObject().selectADeviceForUserProfile());
						softcontrol7.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddDevicePageObject().clickAddDeviceButton());
					}
					
					softcontrol7.assertAll();
				}
						
				@Test(priority = 87, dependsOnMethods = {"Verify_SignUp_And_Onboard" , "Verify_User_Profile_Page"})
				public void Verify_Add_Rule_Page() {
					SoftAssert softcontrol10 = new SoftAssert();
					softcontrol10.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().clickAddRuleLink());
					super.pause(40);
					if(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddRulePageObject().isAt()) {
						softcontrol10.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddRulePageObject().clickHelpIcon());
						softcontrol10.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddRulePageObject().getParentalAddRuleHelpPageObject().clickCloseButton());
						softcontrol10.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddRulePageObject().clickAddScheduleButton());}
						
					softcontrol10.assertAll();
				}
				
				@Test(priority = 88, dependsOnMethods = {"Verify_SignUp_And_Onboard" , "Verify_User_Profile_Page"})
				public void Verify_Add_EveryDay_Schedule_To_Rule() {
					SoftAssert softcontrol11 = new SoftAssert();
			
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
				
				@Test(priority = 89, dependsOnMethods = {"Verify_SignUp_And_Onboard" , "Verify_User_Profile_Page"})
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
				
				@Test(priority = 90, dependsOnMethods = {"Verify_SignUp_And_Onboard" , "Verify_User_Profile_Page"})
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
				
				@Test(priority = 91, dependsOnMethods = {"Verify_SignUp_And_Onboard" , "Verify_User_Profile_Page"})  
				public void Verify_Add_Custom_Schedule_To_Rule() {
					SoftAssert softcontrol14 = new SoftAssert();
					if(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddRulePageObject().isAt()) {
						softcontrol14.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddRulePageObject().clickAddScheduleButton());
						softcontrol14.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddRulePageObject().getInternetBlockingScheduleDialogObject().clickCustomButton());
						}

					softcontrol14.assertAll();
				}
				
				@Test(priority = 92, dependsOnMethods = {"Verify_SignUp_And_Onboard" , "Verify_User_Profile_Page"})
				public void Verify_Add_Custom_Schedule_Select_DOW() {
					SoftAssert softcontrol15 = new SoftAssert();
					softcontrol15.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddRulePageObject().getInternetBlockingScheduleDialogObject().clickMonday());
					softcontrol15.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddRulePageObject().getInternetBlockingScheduleDialogObject().clickThrusday());
					softcontrol15.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddRulePageObject().getInternetBlockingScheduleDialogObject().clickSaturday());

					softcontrol15.assertAll();
					}
				
				@Test(priority = 93, dependsOnMethods = {"Verify_SignUp_And_Onboard" , "Verify_User_Profile_Page"})
				public void Verify_Add_Custom_Schedule_Select_Start_Time() {
					SoftAssert softcontrol16 = new SoftAssert();
					softcontrol16.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddRulePageObject().getInternetBlockingScheduleDialogObject().clickStartTimeLink());
					softcontrol16.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddRulePageObject().getInternetBlockingScheduleDialogObject().clickDoneButton());
					softcontrol16.assertAll();
					}
				
				@Test(priority = 94, dependsOnMethods = {"Verify_SignUp_And_Onboard" , "Verify_User_Profile_Page"})
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
				
				@Test(priority = 95, dependsOnMethods = {"Verify_SignUp_And_Onboard"})
				public void Verify_Enable_Schedule_Time_UI_Page() {
					SoftAssert softcontrol18 = new SoftAssert();

					softcontrol18.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().getParentalUserProfileAddRulePageObject().clickBackButton());
					super.pause(5);
					softcontrol18.assertTrue(new ParentalControlWithProfilesPage().getUserProfilePageObject().clickBackButton());
					softcontrol18.assertAll();
				}
				
				@Test(priority = 99, dependsOnMethods = {"Verify_SignUp_And_Onboard" , "Verify_Parental_Control_UI_Page"})
				public void Verify_Pause_Internet_For_All_Users() {
					SoftAssert softcontrol20 = new SoftAssert();
					if(new ParentalControlWithProfilesPage().isAt()) {
						softcontrol20.assertTrue(new ParentalControlWithProfilesPage().enablePauseAllProfiles());
						softcontrol20.assertTrue(new ParentalControlWithProfilesPage().clickYesPauseInternetButton());
						super.pause(15);
					}
					softcontrol20.assertAll();
				}
				
				@Test(priority = 100, dependsOnMethods = {"Verify_SignUp_And_Onboard" , "Verify_Parental_Control_UI_Page"})
				public void Verify_Currently_Blocked_Profiles() {
					SoftAssert softcontrol21 = new SoftAssert();
					softcontrol21.assertTrue(new ParentalControlWithProfilesPage().clickCurrentlyBlockedTab());

					if(new ParentalControlWithProfilesPage().getParentalControlCurrentlyBlockedTabPageObject().isAt()) {
						softcontrol21.assertTrue(new ParentalControlWithProfilesPage().getParentalControlCurrentlyBlockedTabPageObject().verifyInternetPausedUserProfiles());
						softcontrol21.assertTrue(new ParentalControlWithProfilesPage().getParentalControlCurrentlyBlockedTabPageObject().clickProfilesTab());
					}
					softcontrol21.assertAll();
				}
				
				@Test(priority = 101, dependsOnMethods = {"Verify_SignUp_And_Onboard" , "Verify_Parental_Control_UI_Page"})
				public void Verify_Resume_Internet_For_All_Users() {
					SoftAssert softcontrol22 = new SoftAssert();
					if(new ParentalControlWithProfilesPage().isAt()) {
						softcontrol22.assertTrue(new ParentalControlWithProfilesPage().disablePauseAllProfiles());
						softcontrol22.assertTrue(new ParentalControlWithProfilesPage().clickYesResumeInternetButton());
						super.pause(60);
					}
					softcontrol22.assertAll();
				}
				
				@Test(priority = 102, dependsOnMethods = {"Verify_SignUp_And_Onboard" , "Verify_Parental_Control_UI_Page"})
				public void Verify_Currently_Blocked_Users_After_Resuming_Internet_For_All_Users() {
					SoftAssert softcontrol23 = new SoftAssert();
					if(new ParentalControlWithProfilesPage().isAt())
						softcontrol23.assertTrue(new ParentalControlWithProfilesPage().clickCurrentlyBlockedTab());
					super.pause(20);
					if(new ParentalControlWithProfilesPage().getParentalControlCurrentlyBlockedTabPageObject().isAt()) {
						softcontrol23.assertTrue(new ParentalControlWithProfilesPage().getParentalControlCurrentlyBlockedTabPageObject().verifyNoBlockedProfileMessages());
						softcontrol23.assertTrue(new ParentalControlWithProfilesPage().getParentalControlCurrentlyBlockedTabPageObject().clickProfilesTab());
						new ParentalControlWithProfilesPage().disableParentalControl();
					}
					softcontrol23.assertAll();
				}
				
				@Test(priority = 103, dependsOnMethods = {"Verify_SignUp_And_Onboard" , "Verify_Parental_Control_UI_Page"})
				public void Verify_Parental_Control_Help_Page() {
					SoftAssert softcontrol24 = new SoftAssert();
					if(new ParentalControlWithProfilesPage().isAt())
						softcontrol24.assertTrue(new ParentalControlWithProfilesPage().clickHelpIcon());
					super.pause(3);
						
					if(new ParentalControlWithProfilesPage().getParentalHelpPageObject().isAt()) {
						softcontrol24.assertTrue(new ParentalControlWithProfilesPage().getParentalHelpPageObject().clickCloseButton());
						super.pause(3);
					}

					softcontrol24.assertAll();
				}	
				
				@Test(priority = 105, dependsOnMethods = { "Verify_SignUp_And_Onboard" })
				public void Verify_Network_Health_Page() {
				utils.log().info("                            ");
				utils.log().info("*****************************");
				utils.log().info("Test: Network Health Feature ");
				utils.log().info("*****************************");
					SoftAssert softnetwork1 = new SoftAssert();
					new HomePage().getFooterIconsPageObject().clickHomeButton();
					super.pause(10);
					super.swipeDown();
					softnetwork1.assertTrue(new HomePage().clickTapHereToTurnON());
					super.pause(5);
					softnetwork1.assertTrue(new HomePage().getSkipTutorialPageObject().tapSkip());

					
					
					if(new HomePage().getNetworkOtptimizationPageObject().isAt()) {
						softnetwork1.assertTrue(new HomePage().getNetworkOtptimizationPageObject().clickOptimizationIcon());
					}
					
					softnetwork1.assertAll();
				}
				
				@Test(priority = 106, dependsOnMethods = { "Verify_Network_Health_Page" })
				public void Verify_Network_Optimization_Settings_Page() {
					SoftAssert softnetwork2 = new SoftAssert();
						
					if(new HomePage().getNetworkOtptimizationPageObject().getOptimizationSettinsPageObject().isAt()) {
						softnetwork2.assertTrue(new HomePage().getNetworkOtptimizationPageObject().getOptimizationSettinsPageObject().enableHealthOptimization());
					}
						
					softnetwork2.assertAll();
				}
				
				@Test(priority = 107, dependsOnMethods = { "Verify_Network_Health_Page" })
				public void Verify_Connected_Device_Signal_Strength_Sensitivity_Medium() {
					SoftAssert softnetwork3 = new SoftAssert();
					super.swipeDown();
					if(new HomePage().getNetworkOtptimizationPageObject().getOptimizationSettinsPageObject().isAt()) 
						softnetwork3.assertTrue(new HomePage().getNetworkOtptimizationPageObject().getOptimizationSettinsPageObject().clickConnectedDeviceSignalButton());
					
					try {				
						if(new HomePage().getNetworkOtptimizationPageObject().getOptimizationSettinsPageObject().getConnectedDevicesPageObject().isAt()) 
							softnetwork3.assertTrue(new HomePage().getNetworkOtptimizationPageObject().getOptimizationSettinsPageObject().getConnectedDevicesPageObject().verifyConnectedDevicesPageUI());
						softnetwork3.assertTrue(new HomePage().getNetworkOtptimizationPageObject().getOptimizationSettinsPageObject().getConnectedDevicesPageObject().clickBackButton());
						
						try {
							if(new AppRatingDialog().isAt())
								new AppRatingDialog().clickRemindMeLaterLink();
						}catch(Exception e){utils.log().info("App Rating Dialog did not appear");}
					}catch(Exception e){}
					
					softnetwork3.assertAll();
				}
				
				@Test(priority = 108, dependsOnMethods = { "Verify_Network_Health_Page" })
				public void Verify_Satellite_Signal_Strength_Sensitivity_Medium() {
					SoftAssert softnetwork4 = new SoftAssert();
						
					if(new HomePage().getNetworkOtptimizationPageObject().getOptimizationSettinsPageObject().isAt()) 
						softnetwork4.assertTrue(new HomePage().getNetworkOtptimizationPageObject().getOptimizationSettinsPageObject().clickSatelliteSignalButton());
					
					try {				
						if(new HomePage().getNetworkOtptimizationPageObject().getOptimizationSettinsPageObject().getSatelliteSignalPageObject().isAt()) 
							softnetwork4.assertTrue(new HomePage().getNetworkOtptimizationPageObject().getOptimizationSettinsPageObject().getSatelliteSignalPageObject().verifySatelliteSignalStrengthsPageUI());
						softnetwork4.assertTrue(new HomePage().getNetworkOtptimizationPageObject().getOptimizationSettinsPageObject().getSatelliteSignalPageObject().clickBackButton());
						try {
							if(new AppRatingDialog().isAt())
								new AppRatingDialog().clickRemindMeLaterLink();
						}catch(Exception e){utils.log().info("App Rating Dialog did not appear");}
					}catch(Exception e){}
						
						softnetwork4.assertAll();
				}
				
				@Test(priority = 109, dependsOnMethods = { "Verify_Network_Health_Page" })
				public void Verify_Satellite_Link_Rate_Sensitivity_Medium() {
					SoftAssert softnetwork5 = new SoftAssert();
					super.swipeUp();
					if(new HomePage().getNetworkOtptimizationPageObject().getOptimizationSettinsPageObject().isAt()) 
						softnetwork5.assertTrue(new HomePage().getNetworkOtptimizationPageObject().getOptimizationSettinsPageObject().clickSatelliteLinkRateButton());
					
					try {				
						if(new HomePage().getNetworkOtptimizationPageObject().getOptimizationSettinsPageObject().getSatelliteLinkRatePageObject().isAt()) 
							softnetwork5.assertTrue(new HomePage().getNetworkOtptimizationPageObject().getOptimizationSettinsPageObject().getSatelliteLinkRatePageObject().verifySatelliteLinkRatePageUI());
						softnetwork5.assertTrue(new HomePage().getNetworkOtptimizationPageObject().getOptimizationSettinsPageObject().getSatelliteLinkRatePageObject().clickBackButton());
						try {
							if(new AppRatingDialog().isAt())
								new AppRatingDialog().clickRemindMeLaterLink();
						}catch(Exception e){utils.log().info("App Rating Dialog did not appear");}
					}catch(Exception e){}
						
						softnetwork5.assertAll();
				}
				
				@Test(priority = 110, dependsOnMethods = { "Verify_Network_Health_Page" })
				public void Verify_ISP_Speed_Link_Rate_Sensitivity_Medium() {
					SoftAssert softnetwork6 = new SoftAssert();
					super.swipeUp();
					if(new HomePage().getNetworkOtptimizationPageObject().getOptimizationSettinsPageObject().isAt()) 
						softnetwork6.assertTrue(new HomePage().getNetworkOtptimizationPageObject().getOptimizationSettinsPageObject().clickISPSpeedRateButton());
					
					try {		
						if(new HomePage().getNetworkOtptimizationPageObject().getOptimizationSettinsPageObject().getISPSpeedRatePageObject().isAt()) 
							softnetwork6.assertTrue(new HomePage().getNetworkOtptimizationPageObject().getOptimizationSettinsPageObject().getISPSpeedRatePageObject().verifyISPSpeedRatePageUI());
						softnetwork6.assertTrue(new HomePage().getNetworkOtptimizationPageObject().getOptimizationSettinsPageObject().getISPSpeedRatePageObject().clickBackButton());
						
						try {
							if(new AppRatingDialog().isAt())
								new AppRatingDialog().clickRemindMeLaterLink();
						}catch(Exception e){utils.log().info("App Rating Dialog did not appear");}
					}catch(Exception e){}
						softnetwork6.assertAll();
				}
				
				@Test(priority = 111, dependsOnMethods = { "Verify_Network_Health_Page" })
				public void Verify_Connected_Device_Signal_Strength_Sensitivity_High() {
					SoftAssert softnetwork7 = new SoftAssert();
					super.swipeDown();
					
					if(new HomePage().getNetworkOtptimizationPageObject().getOptimizationSettinsPageObject().isAt()) 
						new HomePage().getNetworkOtptimizationPageObject().getOptimizationSettinsPageObject().tapHigh();
					softnetwork7.assertTrue(new HomePage().getNetworkOtptimizationPageObject().getOptimizationSettinsPageObject().clickConnectedDeviceSignalButton());
					
					try {
						if(new HomePage().getNetworkOtptimizationPageObject().getOptimizationSettinsPageObject().getConnectedDevicesPageObject().isAt()) 
							softnetwork7.assertTrue(new HomePage().getNetworkOtptimizationPageObject().getOptimizationSettinsPageObject().getConnectedDevicesPageObject().verifyConnectedDevicesPageUI());
						softnetwork7.assertTrue(new HomePage().getNetworkOtptimizationPageObject().getOptimizationSettinsPageObject().getConnectedDevicesPageObject().clickBackButton());
						try {
							if(new AppRatingDialog().isAt())
								new AppRatingDialog().clickRemindMeLaterLink();
						}catch(Exception e){utils.log().info("App Rating Dialog did not appear");}
					}catch(Exception e){}
						
					softnetwork7.assertAll();
				}
				
				@Test(priority = 112, dependsOnMethods = { "Verify_Network_Health_Page" })
				public void Verify_Satellite_Signal_Strength_Sensitivity_High() {
					SoftAssert softnetwork8 = new SoftAssert();
						
					if(new HomePage().getNetworkOtptimizationPageObject().getOptimizationSettinsPageObject().isAt()) 
						softnetwork8.assertTrue(new HomePage().getNetworkOtptimizationPageObject().getOptimizationSettinsPageObject().clickSatelliteSignalButton());
					
					try {
						if(new HomePage().getNetworkOtptimizationPageObject().getOptimizationSettinsPageObject().getSatelliteSignalPageObject().isAt()) 
							softnetwork8.assertTrue(new HomePage().getNetworkOtptimizationPageObject().getOptimizationSettinsPageObject().getSatelliteSignalPageObject().verifySatelliteSignalStrengthsPageUI());
						softnetwork8.assertTrue(new HomePage().getNetworkOtptimizationPageObject().getOptimizationSettinsPageObject().getSatelliteSignalPageObject().clickBackButton());
						try {
							if(new AppRatingDialog().isAt())
								new AppRatingDialog().clickRemindMeLaterLink();
						}catch(Exception e){utils.log().info("App Rating Dialog did not appear");}
					}catch(Exception e){}
					
					softnetwork8.assertAll();
				}
				
				@Test(priority = 113, dependsOnMethods = { "Verify_Network_Health_Page" })
				public void Verify_Satellite_Link_Rate_Sensitivity_High() {
					SoftAssert softnetwork9 = new SoftAssert();
					super.swipeUp();
					if(new HomePage().getNetworkOtptimizationPageObject().getOptimizationSettinsPageObject().isAt()) 
						softnetwork9.assertTrue(new HomePage().getNetworkOtptimizationPageObject().getOptimizationSettinsPageObject().clickSatelliteLinkRateButton());
					
					try {		
						if(new HomePage().getNetworkOtptimizationPageObject().getOptimizationSettinsPageObject().getSatelliteLinkRatePageObject().isAt()) 
							softnetwork9.assertTrue(new HomePage().getNetworkOtptimizationPageObject().getOptimizationSettinsPageObject().getSatelliteLinkRatePageObject().verifySatelliteLinkRatePageUI());
						softnetwork9.assertTrue(new HomePage().getNetworkOtptimizationPageObject().getOptimizationSettinsPageObject().getSatelliteLinkRatePageObject().clickBackButton());
						try {
							if(new AppRatingDialog().isAt())
								new AppRatingDialog().clickRemindMeLaterLink();
						}catch(Exception e){utils.log().info("App Rating Dialog did not appear");}
					}catch(Exception e){}
						
						softnetwork9.assertAll();
				}
				
				@Test(priority = 114, dependsOnMethods = { "Verify_Network_Health_Page" })
				public void Verify_ISP_Speed_Link_Rate_Sensitivity_High() {
					SoftAssert softnetwork10 = new SoftAssert();
					super.swipeUp();
					if(new HomePage().getNetworkOtptimizationPageObject().getOptimizationSettinsPageObject().isAt()) 
						softnetwork10.assertTrue(new HomePage().getNetworkOtptimizationPageObject().getOptimizationSettinsPageObject().clickISPSpeedRateButton());
					
					try {
				
						if(new HomePage().getNetworkOtptimizationPageObject().getOptimizationSettinsPageObject().getISPSpeedRatePageObject().isAt()) 
							softnetwork10.assertTrue(new HomePage().getNetworkOtptimizationPageObject().getOptimizationSettinsPageObject().getISPSpeedRatePageObject().verifyISPSpeedRatePageUI());
						softnetwork10.assertTrue(new HomePage().getNetworkOtptimizationPageObject().getOptimizationSettinsPageObject().getISPSpeedRatePageObject().clickBackButton());
						try {
							if(new AppRatingDialog().isAt())
								new AppRatingDialog().clickRemindMeLaterLink();
						}catch(Exception e){utils.log().info("App Rating Dialog did not appear");}
					}catch(Exception e){}
					
						softnetwork10.assertAll();
				}
				
				@Test(priority = 115, dependsOnMethods = { "Verify_Network_Health_Page" })
				public void Verify_Connected_Device_Signal_Strength_Sensitivity_Low() {
					SoftAssert softnetwork11 = new SoftAssert();
					super.swipeDown();
					if(new HomePage().getNetworkOtptimizationPageObject().getOptimizationSettinsPageObject().isAt()) 
						new HomePage().getNetworkOtptimizationPageObject().getOptimizationSettinsPageObject().tapLow();
					softnetwork11.assertTrue(new HomePage().getNetworkOtptimizationPageObject().getOptimizationSettinsPageObject().clickConnectedDeviceSignalButton());
					
					try {				
						if(new HomePage().getNetworkOtptimizationPageObject().getOptimizationSettinsPageObject().getConnectedDevicesPageObject().isAt()) 
							softnetwork11.assertTrue(new HomePage().getNetworkOtptimizationPageObject().getOptimizationSettinsPageObject().getConnectedDevicesPageObject().verifyConnectedDevicesPageUI());
						softnetwork11.assertTrue(new HomePage().getNetworkOtptimizationPageObject().getOptimizationSettinsPageObject().getConnectedDevicesPageObject().clickBackButton());
						try {
							if(new AppRatingDialog().isAt())
								new AppRatingDialog().clickRemindMeLaterLink();
						}catch(Exception e){utils.log().info("App Rating Dialog did not appear");}
					}catch(Exception e){}
						
						softnetwork11.assertAll();
				}
				
				@Test(priority = 116, dependsOnMethods = { "Verify_Network_Health_Page" })
				public void Verify_Satellite_Signal_Strength_Sensitivity_Low() {
					SoftAssert softnetwork12 = new SoftAssert();
						
					if(new HomePage().getNetworkOtptimizationPageObject().getOptimizationSettinsPageObject().isAt()) 
						softnetwork12.assertTrue(new HomePage().getNetworkOtptimizationPageObject().getOptimizationSettinsPageObject().clickSatelliteSignalButton());
					
					try {
						if(new HomePage().getNetworkOtptimizationPageObject().getOptimizationSettinsPageObject().getSatelliteSignalPageObject().isAt()) 
							softnetwork12.assertTrue(new HomePage().getNetworkOtptimizationPageObject().getOptimizationSettinsPageObject().getSatelliteSignalPageObject().verifySatelliteSignalStrengthsPageUI());
						softnetwork12.assertTrue(new HomePage().getNetworkOtptimizationPageObject().getOptimizationSettinsPageObject().getSatelliteSignalPageObject().clickBackButton());
						try {
							if(new AppRatingDialog().isAt())
								new AppRatingDialog().clickRemindMeLaterLink();
						}catch(Exception e){utils.log().info("App Rating Dialog did not appear");}
					}catch(Exception e){}
						
						softnetwork12.assertAll();
				}
				
				@Test(priority = 117, dependsOnMethods = { "Verify_Network_Health_Page" })
				public void Verify_Satellite_Link_Rate__Sensitivity_Low() {
					SoftAssert softnetwork13 = new SoftAssert();
					super.swipeUp();
					if(new HomePage().getNetworkOtptimizationPageObject().getOptimizationSettinsPageObject().isAt()) 
						softnetwork13.assertTrue(new HomePage().getNetworkOtptimizationPageObject().getOptimizationSettinsPageObject().clickSatelliteLinkRateButton());
					
					try {				
						if(new HomePage().getNetworkOtptimizationPageObject().getOptimizationSettinsPageObject().getSatelliteLinkRatePageObject().isAt()) 
							softnetwork13.assertTrue(new HomePage().getNetworkOtptimizationPageObject().getOptimizationSettinsPageObject().getSatelliteLinkRatePageObject().verifySatelliteLinkRatePageUI());
						softnetwork13.assertTrue(new HomePage().getNetworkOtptimizationPageObject().getOptimizationSettinsPageObject().getSatelliteLinkRatePageObject().clickBackButton());
						try {
							if(new AppRatingDialog().isAt())
								new AppRatingDialog().clickRemindMeLaterLink();
						}catch(Exception e){utils.log().info("App Rating Dialog did not appear");}
					}catch(Exception e){}
						
						softnetwork13.assertAll();
				}
				
				@Test(priority = 118, dependsOnMethods = { "Verify_Network_Health_Page" })
				public void Verify_ISP_Speed_Link_Rate_Sensitivity_Low() {
					SoftAssert softnetwork14 = new SoftAssert();
					super.swipeUp();
					if(new HomePage().getNetworkOtptimizationPageObject().getOptimizationSettinsPageObject().isAt()) 
						softnetwork14.assertTrue(new HomePage().getNetworkOtptimizationPageObject().getOptimizationSettinsPageObject().clickISPSpeedRateButton());
					
					try {				
						if(new HomePage().getNetworkOtptimizationPageObject().getOptimizationSettinsPageObject().getISPSpeedRatePageObject().isAt()) 
							softnetwork14.assertTrue(new HomePage().getNetworkOtptimizationPageObject().getOptimizationSettinsPageObject().getISPSpeedRatePageObject().verifyISPSpeedRatePageUI());
						softnetwork14.assertTrue(new HomePage().getNetworkOtptimizationPageObject().getOptimizationSettinsPageObject().getISPSpeedRatePageObject().clickBackButton());
						
						try {
							if(new AppRatingDialog().isAt())
								new AppRatingDialog().clickRemindMeLaterLink();
						}catch(Exception e){utils.log().info("App Rating Dialog did not appear");}
					}catch(Exception e){}
						
						if(new HomePage().getNetworkOtptimizationPageObject().getOptimizationSettinsPageObject().isAt()) 
							new HomePage().getNetworkOtptimizationPageObject().getOptimizationSettinsPageObject().tapMedium();
						
						new HomePage().getNetworkOtptimizationPageObject().getOptimizationSettinsPageObject().clickBackButton();
						
						softnetwork14.assertAll();
				}
				
				@Test(priority = 119, dependsOnMethods = { "Verify_Network_Health_Page" })
				public void Verify_Network_Optimization_Recommendations() {
					SoftAssert softnetwork15 = new SoftAssert();
						super.swipeDown();
					if(new HomePage().getNetworkOtptimizationPageObject().isAt()) 
						softnetwork15.assertTrue(new HomePage().getNetworkOtptimizationPageObject().verifyNetworkAfterOptimization());	
					
					softnetwork15.assertAll();
				}
				
				@Test(priority = 120, dependsOnMethods = { "Verify_Network_Health_Page" })
				public void Verify_Disabled_Network_Optimization_Settings() {
					SoftAssert softnetwork16 = new SoftAssert();
					
					new HomePage().getNetworkOtptimizationPageObject().clickOptimizationIcon();
						
					if(new HomePage().getNetworkOtptimizationPageObject().getOptimizationSettinsPageObject().isAt()) 
						softnetwork16.assertTrue(new HomePage().getNetworkOtptimizationPageObject().getOptimizationSettinsPageObject().disableHealthOptimization());
					super.pause(3);
					softnetwork16.assertTrue(new HomePage().getNetworkOtptimizationPageObject().getOptimizationSettinsPageObject().clickBackButton());
					softnetwork16.assertTrue(new HomePage().getNetworkOtptimizationPageObject().clickBackButton());

					softnetwork16.assertAll();
				}
				
				@Test(priority = 122, dependsOnMethods = {"Verify_SignUp_And_Onboard"})
				public void Verify_Network_UI_Page() {
					utils.log().info("                          ");
					utils.log().info("**************************");
					utils.log().info("Test: Network Page Feature ");
					utils.log().info("***************************");
					SoftAssert softnet2 = new SoftAssert();
					softnet2.assertTrue(new HomePage().getFooterIconsPageObject().clickNetworkButton());
					super.pause(5);
//					softnet2.assertTrue(new NetworkPage().clickNetworkSettingsExpandButton());
					softnet2.assertTrue(new NetworkPage().verifyUIOfMainWifi());
					softnet2.assertAll();
				}


				@Test(priority = 125, dependsOnMethods = {"Verify_SignUp_And_Onboard", "Verify_Network_UI_Page"})
				public void Verify_Newtork_Test_Connection_Speed_Page() {
					SoftAssert softnet4 = new SoftAssert();
				//	super.swipeUp();
					softnet4.assertTrue(new NetworkPage().clickTestConnectionSpeedButton());
					softnet4.assertTrue(new NetworkPage().getSpeedTestPageObject().performSpeedTest());
					softnet4.assertTrue(new NetworkPage().getSpeedTestPageObject().clickBackButton());
					softnet4.assertAll();
				}

				@Test(priority = 126, dependsOnMethods = {"Verify_SignUp_And_Onboard", "Verify_Network_UI_Page"})
				public void Verify_WAN_Settings_UI_Page() {
					SoftAssert softnet5 = new SoftAssert();
					super.pause(5);
					softnet5.assertTrue(new NetworkPage().clickNetworkSettingsExpandButton());
					super.swipeUp();
					softnet5.assertTrue(new NetworkPage().clickWANSettings());
					
					try {
						if(new AppRatingDialog().isAt())
							new AppRatingDialog().clickRemindMeLaterLink();
					}catch(Exception e){utils.log().info("App Rating Dialog did not appear");}

					softnet5.assertAll();
				}

				@Test(priority = 127, dependsOnMethods = {"Verify_SignUp_And_Onboard", "Verify_WAN_Settings_UI_Page",})
				public void Verify_WAN_Settings_WAN_IP_Configuration_IPv4_DHCP_UI_Page() {
					SoftAssert softnet7 = new SoftAssert();
					new NetworkPage().getWANSettingsPageObject().clickWANIPConfigurationLink();
					if (new NetworkPage().getWANSettingsPageObject().getWANIPv4ConfigurationPageObject().isAt())
						softnet7.assertTrue(new NetworkPage().getWANSettingsPageObject().getWANIPv4ConfigurationPageObject().verifyUIOnWANIPv4DHCP());
					softnet7.assertAll();
				}

				@Test(priority = 128, dependsOnMethods = {"Verify_SignUp_And_Onboard", "Verify_WAN_Settings_UI_Page", "Verify_WAN_Settings_WAN_IP_Configuration_IPv4_DHCP_UI_Page"})
				public void Verify_WAN_Settings_WAN_IP_Configuration_IPv4_Static_UI_Page() {
					SoftAssert softnet8 = new SoftAssert();
					softnet8.assertTrue(new NetworkPage().getWANSettingsPageObject().getWANIPv4ConfigurationPageObject().verifyUIOnWANIPv4Static());
					softnet8.assertAll();
				}

				@Test(priority = 129, dependsOnMethods = {"Verify_SignUp_And_Onboard", "Verify_WAN_Settings_UI_Page", "Verify_WAN_Settings_WAN_IP_Configuration_IPv4_Static_UI_Page"})
				public void Verify_WAN_Settings_WAN_IP_Configuration_IPv6_Stateful_UI_Page() {
					SoftAssert softnet9 = new SoftAssert();
					softnet9.assertTrue(new NetworkPage().getWANSettingsPageObject().getWANIPv4ConfigurationPageObject().clickWANIPv6Tab());
					if (new NetworkPage().getWANSettingsPageObject().getWANIPv6ConfigurationPageObject().isAt())
						softnet9.assertTrue(new NetworkPage().getWANSettingsPageObject().getWANIPv6ConfigurationPageObject().verifyUIOnWANIPv6Stateful());
					softnet9.assertAll();
				}

				@Test(priority = 130, dependsOnMethods = {"Verify_SignUp_And_Onboard", "Verify_WAN_Settings_UI_Page", "Verify_WAN_Settings_WAN_IP_Configuration_IPv6_Stateful_UI_Page"})
				public void Verify_WAN_Settings_WAN_IP_Configuration_IPv6_Stateless_UI_Page() {
					SoftAssert softnet10 = new SoftAssert();
					softnet10.assertTrue(new NetworkPage().getWANSettingsPageObject().getWANIPv6ConfigurationPageObject().verifyUIOnWANIPv6Stateless());
//					softnet10.assertTrue(new NetworkPage().getWANSettingsPageObject().getWANIPv6ConfigurationPageObject().clickBackButton());
					softnet10.assertAll();
				}

				@Test(priority = 131, dependsOnMethods = {"Verify_SignUp_And_Onboard", "Verify_WAN_Settings_UI_Page", "Verify_WAN_Settings_WAN_IP_Configuration_IPv6_Stateful_UI_Page"})
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
				
				@Test(priority = 132, dependsOnMethods = {"Verify_SignUp_And_Onboard", "Verify_WAN_Settings_UI_Page"})
				public void Verify_WAN_Settings_DNS_Configuration_IPv4_Automatic_UI_Page() 
				{
					SoftAssert softnet12 = new SoftAssert();
					softnet12.assertTrue(new NetworkPage().getWANSettingsPageObject().clickDNSConfigurationLink());
					if (new NetworkPage().getWANSettingsPageObject().getWANDNSIPv4ConfigurationPageObject().isAt()) 
						softnet12.assertTrue(new NetworkPage().getWANSettingsPageObject().getWANDNSIPv4ConfigurationPageObject().verifyUIOnDNSIPv4Automatic());
					softnet12.assertAll();
				}
				
				@Test(priority = 133, dependsOnMethods = {"Verify_SignUp_And_Onboard", "Verify_WAN_Settings_DNS_Configuration_IPv4_Automatic_UI_Page"})
				public void Verify_WAN_Settings_DNS_Configuration_IPv4_Static_UI_Page() 
				{
					SoftAssert softnet13 = new SoftAssert();
					softnet13.assertTrue(new NetworkPage().getWANSettingsPageObject().getWANDNSIPv4ConfigurationPageObject().verifyUIOnDNSIPv4Static());
					softnet13.assertAll();
				}
				
				@Test(priority = 134, dependsOnMethods = {"Verify_SignUp_And_Onboard", "Verify_WAN_Settings_DNS_Configuration_IPv4_Static_UI_Page"})
				public void Verify_WAN_Settings_DNS_Configuration_IPv6_Automatic_UI_Page() 
				{
					SoftAssert softnet14 = new SoftAssert();
					softnet14.assertTrue(new NetworkPage().getWANSettingsPageObject().getWANDNSIPv4ConfigurationPageObject().clickDNSIPv6Tab());
					if (new NetworkPage().getWANSettingsPageObject().getWANDNSIPv6ConfigurationPageObject().isAt()) 
						softnet14.assertTrue(new NetworkPage().getWANSettingsPageObject().getWANDNSIPv6ConfigurationPageObject().verifyUIOnDNSIPv6Automatic());
					softnet14.assertAll();
				}
				
				@Test(priority = 135, dependsOnMethods = {"Verify_SignUp_And_Onboard", "Verify_WAN_Settings_DNS_Configuration_IPv6_Automatic_UI_Page"})
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

					softnet15.assertAll();
				}

				
				@Test(priority = 137, dependsOnMethods = {"Verify_SignUp_And_Onboard", "Verify_WAN_Settings_UI_Page"})
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
				
				@Test(priority = 138, dependsOnMethods = {"Verify_SignUp_And_Onboard"})
				public void Verify_LAN_Settings_UI_Page() 
				{
					SoftAssert softnet18 = new SoftAssert();
					if (new NetworkPage().isAt()) {
						super.pause(5);
						softnet18.assertTrue(new NetworkPage().clickLANSettings());
						try{
							if(new NetworkPage().getAppRatingPageObject().isAt())
								new NetworkPage().getAppRatingPageObject().clickRemindMeLaterLink();
						}catch(Exception e) {
							utils.log().info("App Rating Dialog did not appear");
						}
					}
					softnet18.assertAll();
				}
				
				@Test(priority = 139, dependsOnMethods = {"Verify_SignUp_And_Onboard", "Verify_LAN_Settings_UI_Page"})
				public void Verify_LAN_Settings_LAN_IP_Reservation_Page() 
				{
					SoftAssert softnet19 = new SoftAssert();
					super.pause(5);
					softnet19.assertTrue(new NetworkPage().getLANSettingsPageObject().clickLANIPResevationLink());
					softnet19.assertAll();
				}
				
				@Test(priority = 140, dependsOnMethods = {"Verify_SignUp_And_Onboard", "Verify_LAN_Settings_LAN_IP_Reservation_Page"})
				public void Verify_LAN_Settings_LAN_IP_Reservation_Add_Reservation_Page() 
				{
					SoftAssert softnet20 = new SoftAssert();
					super.pause(5);
					new NetworkPage().getLANSettingsPageObject().getNetworkLANIPReservationPageObject().clickAddReservationButton();
					if(new NetworkPage().getLANSettingsPageObject().getNetworkLANIPReservationPageObject().getLANIPReservationDialogObject().isAt())
					{
						super.pause(5);
						softnet20.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANIPReservationPageObject().getLANIPReservationDialogObject().enterRuleName());
						softnet20.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANIPReservationPageObject().getLANIPReservationDialogObject().enterIPAddress());
						softnet20.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANIPReservationPageObject().getLANIPReservationDialogObject().selectADevice(1));
						softnet20.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANIPReservationPageObject().getLANIPReservationDialogObject().clickSaveButton());
						softnet20.assertAll();
					}
				}
				
				@Test(priority = 141, dependsOnMethods = {"Verify_SignUp_And_Onboard", "Verify_LAN_Settings_LAN_IP_Reservation_Add_Reservation_Page"})
				public void Verify_LAN_Settings_LAN_IP_Reservation_Rules() 
				{
					SoftAssert softnet21 = new SoftAssert();
					super.pause(5);
					softnet21.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANIPReservationPageObject().verifyRulesOnLAPIPReservationPage());
					softnet21.assertAll();
				}
				
				@Test(priority = 143, dependsOnMethods = {"Verify_SignUp_And_Onboard", "Verify_LAN_Settings_LAN_IP_Reservation_Page"})
				public void Verify_LAN_Settings_LAN_IP_Reservation_Help_Page() {
					SoftAssert softnet23 = new SoftAssert();
					super.pause(5);
					softnet23.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANIPReservationPageObject().clickHelpButton());
					if (new NetworkPage().getLANSettingsPageObject().getNetworkLANIPReservationPageObject().getLanIPReservationHelpPageObject().isAt()) {
						softnet23.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANIPReservationPageObject().getLanIPReservationHelpPageObject().clickCloseButton());
						softnet23.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANIPReservationPageObject().clickBackButton());
					}
					softnet23.assertAll();
				}
				
				@Test(priority = 144, dependsOnMethods = {"Verify_SignUp_And_Onboard", "Verify_LAN_Settings_UI_Page"})
				public void Verify_LAN_Settings_LAN_Subnet_DHCP_Range_Configuration_Page() 
				{
					SoftAssert softnet24 = new SoftAssert();
					super.pause(5);
					softnet24.assertTrue(new NetworkPage().getLANSettingsPageObject().clickLANSubnetLink());
					if(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().isAt()) {
					//	softnet24.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().verifyUIOnLANSubnetConfigurationPage());
						softnet24.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().verifyDHCPIPAddressRangeForSelectedSubnet());
					}
					softnet24.assertAll();
				}
				
				@Test(priority = 145, dependsOnMethods = {"Verify_SignUp_And_Onboard", "Verify_LAN_Settings_LAN_Subnet_DHCP_Range_Configuration_Page"})
				public void Verify_Edit_LAN_Subnet_DHCP_Range_Configuration_Page() 
				{
					SoftAssert softnet25 = new SoftAssert();
					super.pause(5);
					
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
				
				@Test(priority = 146, dependsOnMethods = {"Verify_SignUp_And_Onboard", "Verify_LAN_Settings_LAN_Subnet_DHCP_Range_Configuration_Page"})
				public void Edit_LAN_Subnet_Configuration_Octets() 
				{
					SoftAssert softnet26 = new SoftAssert();
					super.pause(5);
					
					softnet26.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().verifyFirstLANSubnetConfigurationWithInvalidOctet());
					softnet26.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().clickSaveButton());
					utils.log().info("Validation Message : " + new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().enterValidIPAddressText1.getText() + " is displayed");
					
					softnet26.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().verifySecondLANSubnetConfigurationWithInvalidOctet());
					softnet26.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().clickSaveButton());
					utils.log().info("Validation Message : " + new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().enterValidIPAddressText2.getText() + " is displayed");

					softnet26.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().verifyThirdLANSubnetConfigurationWithInvalidOctet());
					softnet26.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().clickSaveButton());
					utils.log().info("Validation Message : " + new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().enterValidIPAddressText3.getText() + " is displayed");
					
					softnet26.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().verifyThirdLANSubnetConfigurationWithSecondInvalidOctet());
					softnet26.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().clickSaveButton());
					utils.log().info("Validation Message : " + new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().enterValidIPAddressTex16_31.getText() + " is displayed");
					
					softnet26.assertAll();
				}
				
				@Test(priority = 147, dependsOnMethods = {"Verify_SignUp_And_Onboard", "Verify_LAN_Settings_LAN_Subnet_DHCP_Range_Configuration_Page"})
				public void Verify_LAN_Settings_LAN_Subnet_DHCP_Range_Configuration_Help_Page() 
				{
					SoftAssert softnet27 = new SoftAssert();
					super.pause(5);
					softnet27.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().clickHelpButton());
						if(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().getLANSubnetRangeHelpPageObject().isAt()) {
							softnet27.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().getLANSubnetRangeHelpPageObject().clickCloseButton());
							softnet27.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().clickBackButton());
						softnet27.assertAll();
					}
				}
				
				@Test(priority = 148, dependsOnMethods = {"Verify_SignUp_And_Onboard", "Verify_LAN_Settings_UI_Page"})
				public void Verify_LAN_Settings_LAN_DHCP_Lease_Time_UI_Page() 
				{
					SoftAssert softnet28 = new SoftAssert();	
						if(new NetworkPage().getLANSettingsPageObject().isAt())
							super.pause(5);
							softnet28.assertTrue(new NetworkPage().getLANSettingsPageObject().clickDHCPLeaseTimeLink());
						softnet28.assertAll();
				}
				
				@Test(priority = 149, dependsOnMethods = {"Verify_SignUp_And_Onboard", "Verify_LAN_Settings_LAN_DHCP_Lease_Time_UI_Page"})
				public void Verify_LAN_Settings_LAN_DHCP_Set_Lease_Time_Page() 
				{
					SoftAssert softnet29 = new SoftAssert();
					super.pause(5);
					
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
					
					softnet29.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().clickTimeUnitButton());
					if(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().getEditTimeUnitPageObject().isAt())
						softnet29.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().getEditTimeUnitPageObject().clickForeverRadioButton());
					softnet29.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().verifyLeaseTimeWithForeverTimeUnit());

					
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
					softnet29.assertTrue(new NetworkPage().getLANSettingsPageObject().clickBackButton());
					
					softnet29.assertAll();
				}
						
//				@Test(priority = 151, dependsOnMethods = {"Verify_SignUp_And_Onboard"})
//				public void Verify_Device_Priority_Settings_UI_Page() 
//				{
//					SoftAssert softnet31 = new SoftAssert();
//					softnet31.assertTrue(new NetworkPage().clickDevicePrioritySettings());
//					try{
//						if(new NetworkPage().getAppRatingPageObject().isAt())
//							new NetworkPage().getAppRatingPageObject().clickRemindMeLaterLink();
//					}catch(Exception e) {
//						utils.log().info("App Rating Dialog did not appear");
//					}
//					
//					if(new NetworkPage().getNetworkDevicePrioritySettingsPageObject().isAt())
//					{
//						softnet31.assertTrue(new NetworkPage().getNetworkDevicePrioritySettingsPageObject().enableDevicePrioritySettings());
//						super.pause(5);
//						try{
//							if(new NetworkPage().getAppRatingPageObject().isAt())
//								new NetworkPage().getAppRatingPageObject().clickRemindMeLaterLink();
//						}catch(Exception e) {
//							utils.log().info("App Rating Dialog did not appear");
//						}
//						
//						softnet31.assertTrue(new NetworkPage().getNetworkDevicePrioritySettingsPageObject().clickAddDeviceButton());
//						super.pause(40);
//					}
//					softnet31.assertAll();
//				}
//				
//			
//				@Test(priority = 153, dependsOnMethods = {"Verify_SignUp_And_Onboard"})
//				public void Verify_Device_Priority_Settings_Add_Device_Page() 
//				{
//					SoftAssert softnet33 = new SoftAssert();
//
//					utils.log().info("Clicking on Add Device button without selecting a device ");
//					softnet33.assertTrue(new NetworkPage().getNetworkDevicePrioritySettingsPageObject().getAddDevicePriorityPageObject().clickAddDeviceButton());
//					
//					if(new NetworkPage().getNetworkDevicePrioritySettingsPageObject().getAddDevicePriorityPageObject().addDeviceErrorMessage.isDisplayed())
//						utils.log().info(new NetworkPage().getNetworkDevicePrioritySettingsPageObject().getAddDevicePriorityPageObject().addDeviceErrorMessage.getText() + " error message is displayed");
//
//					softnet33.assertTrue(new NetworkPage().getNetworkDevicePrioritySettingsPageObject().getAddDevicePriorityPageObject().selectDeviceFromList());
//					softnet33.assertTrue(new NetworkPage().getNetworkDevicePrioritySettingsPageObject().getAddDevicePriorityPageObject().clickAddDeviceButton());
//					super.pause(40);
//					
//					softnet33.assertTrue(new NetworkPage().getNetworkDevicePrioritySettingsPageObject().clickAddDeviceButton());
//					super.pause(40);
//					softnet33.assertTrue(new NetworkPage().getNetworkDevicePrioritySettingsPageObject().getAddDevicePriorityPageObject().selectDeviceFromList());
//					softnet33.assertTrue(new NetworkPage().getNetworkDevicePrioritySettingsPageObject().getAddDevicePriorityPageObject().clickAddDeviceButton());
//					super.pause(40);
//
//					softnet33.assertAll();
//				}
//
//				@Test(priority = 154, dependsOnMethods = {"Verify_SignUp_And_Onboard", "Verify_Device_Priority_Settings_Add_Device_Page"})
//				public void Verify_Device_Priority_Settings_Added_Device_Page() 
//				{
//					SoftAssert softnet34 = new SoftAssert();
//					if(new NetworkPage().getNetworkDevicePrioritySettingsPageObject().isAt())
//					{
//	//					softnet34.assertTrue(new NetworkPage().getNetworkDevicePrioritySettingsPageObject().verifyUIOnNetworkPrioritizedDevices());
//						softnet34.assertTrue(new NetworkPage().getNetworkDevicePrioritySettingsPageObject().verifyTwoDevicesWithHighestPriority());
//						
//						if(new NetworkPage().getNetworkDevicePrioritySettingsPageObject().getAddedTwoHighestPriorityDevicesDialogObject().isAt())
//							softnet34.assertTrue(new NetworkPage().getNetworkDevicePrioritySettingsPageObject().getAddedTwoHighestPriorityDevicesDialogObject().clickOkButton());
//						super.pause(3);
//					}
//					softnet34.assertAll();
//				}
//				
//				
//				@Test(priority = 156, dependsOnMethods = {"Verify_SignUp_And_Onboard", "Verify_Device_Priority_Settings_UI_Page"})
//				public void Verify_Device_Priority_Settings_Help_Page() 
//				{
//					SoftAssert softnet36 = new SoftAssert();
//					softnet36.assertTrue(new NetworkPage().getNetworkDevicePrioritySettingsPageObject().clickHelpButton());
//					
//					if(new NetworkPage().getNetworkDevicePrioritySettingsPageObject().getDevicePriorityHelpPageObject().isAt())
//						softnet36.assertTrue(new NetworkPage().getNetworkDevicePrioritySettingsPageObject().getDevicePriorityHelpPageObject().clickCloseButton());
//					
//					softnet36.assertTrue(new NetworkPage().getNetworkDevicePrioritySettingsPageObject().clickBackButton());
//					softnet36.assertAll();
//				}
				
				@Test(priority = 157, dependsOnMethods = {"Verify_SignUp_And_Onboard", "Verify_Network_UI_Page"})
				public void Verify_Time_Zone_Settings_UI_Page() 
				{
					SoftAssert softnet37 = new SoftAssert();
					super.swipeUp();
					super.pause(5);
					softnet37.assertTrue(new NetworkPage().clickTimeZone());
					if(new NetworkPage().getTimeZoneSettingsPageObject().isAt())
						softnet37.assertTrue(new NetworkPage().getTimeZoneSettingsPageObject().verifyUIOnTimeZonePage());
					softnet37.assertTrue(new NetworkPage().getTimeZoneSettingsPageObject().clickHawaiiTimeZone());
					softnet37.assertTrue(new NetworkPage().getTimeZoneSettingsPageObject().clickSaveButton());
					super.pause(10);
//					softnet37.assertTrue(new NetworkPage().clickNetworkSettingsExpandButton());
//					softnet37.assertTrue(new NetworkPage().getFooterIconsPageObject().clickHomeButton());
					softnet37.assertAll();
				}
				
				@Test(priority = 158, dependsOnMethods = {"Verify_SignUp_And_Onboard", "Verify_Time_Zone_Settings_UI_Page"})
				public void Verify_Time_Zone_Settings_Help_Page() 
				{
					SoftAssert softnet38 = new SoftAssert();
					softnet38.assertTrue(new NetworkPage().clickTimeZone());
					softnet38.assertTrue(new NetworkPage().getTimeZoneSettingsPageObject().clickHelpButton());
					if (new NetworkPage().getTimeZoneSettingsPageObject().getTimeZoneHelpPageObject().isAt())
						softnet38.assertTrue(new NetworkPage().getTimeZoneSettingsPageObject().getTimeZoneHelpPageObject().clickCloseButton());
					softnet38.assertTrue(new NetworkPage().getTimeZoneSettingsPageObject().clickBackButton());
					softnet38.assertTrue(new NetworkPage().clickNetworkSettingsExpandButton());
					softnet38.assertTrue(new NetworkPage().getFooterIconsPageObject().clickHomeButton());
					softnet38.assertAll();
				}
				
				
				
				@Test(priority = 160, dependsOnMethods = { "Verify_SignUp_And_Onboard" })
				public void Verify_Install_Left_Satellite_Page() 
				{
				    utils.log().info("                            ");
					utils.log().info("****************************");
					utils.log().info("Test: Install Satellite1    ");
					utils.log().info("****************************");
				
					SoftAssert softsatellite1 = new SoftAssert();
					new HomePage().getFooterIconsPageObject().clickHomeButton();
					performFactoryReset("Satellite1", "/dev/tty.usbserial-142310");
					  
						try {
							
							try {
					  			if(new HomePage().cloudIcon.isDisplayed() || new HomePage().remoteAccessNotAvailableLink.isDisplayed()) {
					  				new HomePage().connectToSSID(this.ssidName);
					  				utils.log().info("Waiting for 120 seconds for the Wifi connection to stabilize on the homepage");
					  				super.pause(120);
								}else {utils.log().info("Remote access to your network is currently available");}
					  		}catch(Exception e) {};
					  		
							
							new HomePage().clickNavigationButton();
							new HomePage().getHamburgerMenuPageObject().clickAddSatelliteButton();
							new AddSatelliteInstallAdditionalSatelliteDialog().clickInstallSatelliteButton();
							
							
							// 1
							try 
							{
								if(new AddSatelliteAddNewSatellitePage1().isAt()) 
								{
									new AddSatelliteAddNewSatellitePage1().clickNextButton();// Each satellite expands your network
									utils.log().info("Waiting for 60 seconds ");
									super.pause(60);
									
									try
									{
										if(new AddSatelliteConnectedToNonMaxNetworkPage().isAt())
										{
											utils.log().info("Connected to a non max network");
											utils.log().info("Trying to re-establish connection with max router");
											new HomePage().connectToSSID(this.ssidName);
											utils.log().info("Waiting for 120 seconds for the Wifi connection to stabilize on the homepage");
							  				super.pause(120);
							  				
							  				if(new AddSatelliteConnectedToNonMaxNetworkPage().tryAgainStaticText.isDisplayed()) 
							  				{
							  					new AddSatelliteConnectedToNonMaxNetworkPage().clickTryAgainButton();
							  				} else {
							  					new AddSatelliteConnectedToNonMaxNetworkPage().clickTroubleShootButton();
							  					super.pause(3);
							  					new AddSatelliteConnectedToNonMaxNetworkTroubleShootProceedPage().clickProceedButton();
							  				}
										}
									}catch(Exception e) {}
								}
							}catch(Exception e) {
								super.pause(10);
								new TapSevenTimes().tapSeven();
								super.pause(3);
								new SevenTapEmail().enterEmailAddress();
								super.pause(3); 
								new SevenTapEmail().clickSendButton();
								  new KillAndRelaunchApp().killApp();
								  super.pause(5);
								  new KillAndRelaunchApp().relaunchApp();
								  super.pause(20);

							}
							
							
							//2
							try 
							{		
								super.waitForVisibility(new AddSatelliteAddNewSatellitePage2().nextButton);
								
								if(new AddSatelliteAddNewSatellitePage2().isAt()) 
								{											
									new AddSatelliteAddNewSatellitePage2().clickNextButton(); //Your network is being configured for satellite install.
									utils.log().info("Waiting for 120 seconds ");
									super.pause(120);
								}
									
								try {
									if(new AddSatelliteOperationFailedPage4().isAt()) {
									//	utils.log().info("Adding Satellite operation failed");
										utils.log().info("Trying to re-establish connection with max router network");
										new HomePage().connectToSSID(this.ssidName);
										utils.log().info("Waiting for 120 seconds to establish a connection with the max router network");
							  			super.pause(120);
									}
								}catch(Exception e) {
									super.pause(5);
									new TapSevenTimes().tapSeven();
									super.pause(3);
									new SevenTapEmail().enterEmailAddress();
									super.pause(3); 
									new SevenTapEmail().clickSendButton();
									  new KillAndRelaunchApp().killApp();
									  super.pause(5);
									  new KillAndRelaunchApp().relaunchApp();
									  super.pause(20);
								}
								

								try	{
									if(new AddSatelliteConnectedToNonMaxNetworkPage().isAt())
									{
										utils.log().info("Connected to a non max network");
										utils.log().info("Trying to re-establish connection with max router network");
										new HomePage().connectToSSID(this.ssidName);
										utils.log().info("Waiting for 120 seconds to establish a connection with the max router network");
							  			super.pause(120);
							  				
							  			if(new AddSatelliteConnectedToNonMaxNetworkPage().tryAgainStaticText.isDisplayed()) 
							  			{
							  				new AddSatelliteConnectedToNonMaxNetworkPage().clickTryAgainButton();
							  			} else {
							  				new AddSatelliteConnectedToNonMaxNetworkPage().clickTroubleShootButton();
							  				super.pause(3);
							  				new AddSatelliteConnectedToNonMaxNetworkTroubleShootProceedPage().clickProceedButton();
							  			}
									}
								}catch(Exception e) {}
								
							} catch (Exception e) {
							 	super.pause(5);
							 	new TapSevenTimes().tapSeven();
							 	super.pause(3);
							 	new SevenTapEmail().enterEmailAddress();
							 	super.pause(3); 
							 	new SevenTapEmail().clickSendButton();
								  new KillAndRelaunchApp().killApp();
								  super.pause(5);
								  new KillAndRelaunchApp().relaunchApp();
								  super.pause(20);
							}
						
							
							//3
							try {
								super.waitForVisibility(new AddSatelliteAddNewSatellitePage3().nextButton);
								
								if(new AddSatelliteAddNewSatellitePage3().isAt()) 
								{  									
									new AddSatelliteAddNewSatellitePage3().clickNextButton(); //To continue with satellite install, please connect to arris-5550 network. Please connect through the WiFi settings of your mobile device.
									utils.log().info("Waiting for 60 seconds to establish a connection with the max network");
					  				super.pause(60);
								}
					  				
					  			try {
									if(new AddSatelliteOperationFailedPage4().isAt()) {
										utils.log().info("Adding Satellite operation failed.");
										utils.log().info("Trying to re-establish connection with max router network");
										new HomePage().connectToSSID(this.ssidName);
										utils.log().info("Waiting for 120 seconds to establish a connection with the max router network");
							  			super.pause(120);
									}
								}catch(Exception e) {
									 super.pause(10);
									 new TapSevenTimes().tapSeven();
									 super.pause(3);
									 new SevenTapEmail().enterEmailAddress();
									 super.pause(3); 
									 new SevenTapEmail().clickSendButton();
									  new KillAndRelaunchApp().killApp();
									  super.pause(5);
									  new KillAndRelaunchApp().relaunchApp();
									  super.pause(20);
								}
									
								try	{
									if(new AddSatelliteConnectedToNonMaxNetworkPage().isAt())
									{
										utils.log().info("Connected to a non max network");
										utils.log().info("Trying to re-establish connection with max router network");
										new HomePage().connectToSSID(this.ssidName);
										utils.log().info("Waiting for 120 seconds to establish a connection with the max router network");
							  			super.pause(120);
							  				
							  			if(new AddSatelliteConnectedToNonMaxNetworkPage().tryAgainStaticText.isDisplayed()) 
							  			{
							  				new AddSatelliteConnectedToNonMaxNetworkPage().clickTryAgainButton();
							 			} else {
							  				new AddSatelliteConnectedToNonMaxNetworkPage().clickTroubleShootButton();
							  				super.pause(3);
							  				new AddSatelliteConnectedToNonMaxNetworkTroubleShootProceedPage().clickProceedButton();
							  				}
									}
								}catch(Exception e) {}

							} catch (Exception e) {
								super.pause(10);
								new TapSevenTimes().tapSeven();
								super.pause(3);
								new SevenTapEmail().enterEmailAddress();
								super.pause(3); 
								new SevenTapEmail().clickSendButton();
								  new KillAndRelaunchApp().killApp();
								  super.pause(5);
								  new KillAndRelaunchApp().relaunchApp();
								  super.pause(20);
							}
							
							//Unpack your satellite
							try{
								if(new AddSatelliteUnPackYourSatellitePage().isAt())
								{
									new AddSatelliteUnPackYourSatellitePage().clickNextButton();
									super.waitForVisibility(new AddSatelliteHelpPlaceYourSatellitePage().skipButton);
								}
							} catch (Exception e) {
								super.pause(10);
							 	new TapSevenTimes().tapSeven();
							 	super.pause(3);
							 	new SevenTapEmail().enterEmailAddress();
							 	super.pause(3); 
							 	new SevenTapEmail().clickSendButton();
								Assert.fail("Satellite 1 Onboarding - Failed at Unpack your satellite");
								  new KillAndRelaunchApp().killApp();
								  super.pause(5);
								  new KillAndRelaunchApp().relaunchApp();
								  super.pause(20);
							}
							
							//Help Place your satellite
							try
							{
								if(new AddSatelliteHelpPlaceYourSatellitePage().isAt())
								{
									new AddSatelliteHelpPlaceYourSatellitePage().clickSkipButton();
									super.waitForVisibility(new AddSatellitePlugInYourSatellitePage().nextButton);
								}
							} catch (Exception e) {
								super.pause(10);
							 	new TapSevenTimes().tapSeven();
							 	super.pause(3);
							 	new SevenTapEmail().enterEmailAddress();
							 	super.pause(3); 
							 	new SevenTapEmail().clickSendButton();
								Assert.fail("Satellite 1 Onboarding - Failed at We did like to help you place your satellite");
								  new KillAndRelaunchApp().killApp();
								  super.pause(5);
								  new KillAndRelaunchApp().relaunchApp();
								  super.pause(20);
							}
							
							//Plug in your satellite
							try
							{
								if(new AddSatellitePlugInYourSatellitePage().isAt())
								{
									new AddSatellitePlugInYourSatellitePage().clickNextButton();
									utils.log().info("Waiting for 120 seconds to establish connection with your max router bluetooth");
									super.pause(120);
								}
								
								try	{
									if(new AddSatelliteConnectedToNonMaxNetworkPage().isAt())
									{
										utils.log().info("Connected to a non max network");
										utils.log().info("Trying to re-establish connection with max router network");
										new HomePage().connectToSSID(this.ssidName);
										utils.log().info("Waiting for 120 seconds to establish a connection with the max router network");
							  			super.pause(120);
						  				
						  				if(new AddSatelliteConnectedToNonMaxNetworkPage().tryAgainStaticText.isDisplayed()) 
						  				{
						  					new AddSatelliteConnectedToNonMaxNetworkPage().clickTryAgainButton();
						  				} else {
						  					new AddSatelliteConnectedToNonMaxNetworkPage().clickTroubleShootButton();
						  					super.pause(3);
						  					new AddSatelliteConnectedToNonMaxNetworkTroubleShootProceedPage().clickProceedButton();
						  				}
									}
								}catch(Exception e) {}
								
								try {
									if (new BlueToothConnectionFailedPage().isAt()) {
										new BlueToothConnectionFailedPage().clickTryAgainbutton();
										utils.log().info("Waiting for 120 seconds trying to establish connection with your max router bluetooth");
										super.pause(120);}
								} catch (Exception e5) {
								}
								
								
								try {
									if (new BlueToothConnectionFailedTroubleShootPage().isAt()) 
										new BlueToothConnectionFailedTroubleShootPage().clickTroubleShootButton();
									
									if (new BlueToothConnectionFailedProceedPage().isAt()) 
										new BlueToothConnectionFailedProceedPage().clickProceedButton();
									
									utils.log().info("Waiting for 120 seconds trying to establish connection with your max router bluetooth");
									super.pause(120);
								} catch (Exception e6) {}

							} catch (Exception e) {
								super.pause(10);
							 	new TapSevenTimes().tapSeven();
							 	super.pause(3);
							 	new SevenTapEmail().enterEmailAddress();
							 	super.pause(3); 
							 	new SevenTapEmail().clickSendButton();
								  Assert.fail("Satellite 1 Onboarding - Unable to connect to your Mobile Device due to blue tooth connection failure");
								  new KillAndRelaunchApp().killApp();
								  super.pause(5);
								  new KillAndRelaunchApp().relaunchApp();
								  super.pause(20);
							}
							
							//Successfully Connected (to Bluetooth) Page
							try
							{
								super.waitForVisibility(new AddSatelliteSuccessfullyConnectedPage().nextButton);
								if(new AddSatelliteSuccessfullyConnectedPage().isAt())
								{
									new AddSatelliteSuccessfullyConnectedPage().clickNextButton();
									utils.log().info("Waiting for 120 seconds to connect your max router to the internet");
									super.pause(120);
								}
								
								try {
									if (new BlueToothConnectionFailedPage().isAt()) 
									{
										new BlueToothConnectionFailedPage().clickTryAgainbutton();
										utils.log().info("Waiting for 120 seconds trying to establish connection with your max router bluetooth");
										super.pause(120);
										
										super.waitForVisibility(new AddSatelliteSuccessfullyConnectedPage().nextButton);
										
										if(new AddSatelliteSuccessfullyConnectedPage().isAt())
										{
											new AddSatelliteSuccessfullyConnectedPage().clickNextButton();
											utils.log().info("Waiting for 120 seconds to connect your max router to the internet");
											super.pause(120);
										}
									}
								} catch (Exception e5) {}
								
												
								try {
									if (new BlueToothConnectionFailedTroubleShootPage().isAt()) 
										new BlueToothConnectionFailedTroubleShootPage().clickTroubleShootButton();
									
									if (new BlueToothConnectionFailedProceedPage().isAt()) 
									{
										new BlueToothConnectionFailedProceedPage().clickProceedButton();
										utils.log().info("Waiting for 120 seconds trying to establish connection with your max router bluetooth");
										super.pause(120);
										
										super.waitForVisibility(new AddSatelliteSuccessfullyConnectedPage().nextButton);
										
										if(new AddSatelliteSuccessfullyConnectedPage().isAt())
										{
											new AddSatelliteSuccessfullyConnectedPage().clickNextButton();
											utils.log().info("Waiting for 120 seconds to connect your max router to the internet");
											super.pause(120);
										}
									}
								} catch (Exception e6) {}

							} catch (Exception e) {
								super.pause(10);
							 	new TapSevenTimes().tapSeven();
							 	super.pause(3);
							 	new SevenTapEmail().enterEmailAddress();
							 	super.pause(3); 
							 	new SevenTapEmail().clickSendButton();
								Assert.fail("Satellite 1 Onboarding - Unable to connect Max Router to your Mobile Device due to blue tooth connection failure");
								  new KillAndRelaunchApp().killApp();
								  super.pause(5);
								  new KillAndRelaunchApp().relaunchApp();
								  super.pause(20);
							}
							
							
							//Successfully Connected to Internet Page
							try {
								super.waitForVisibility(new AddSatelliteSuccessfullyConnectedToInternetPage().nextButton);
								if(new AddSatelliteSuccessfullyConnectedToInternetPage().isAt()) 
								{
									new AddSatelliteSuccessfullyConnectedToInternetPage().clickNextButton();
									super.waitForVisibility(new AddSatelliteSystemUpToDatePage().nextButton);
								}

							}catch(Exception e) {
								super.pause(10);
							 	new TapSevenTimes().tapSeven();
							 	super.pause(3);
							 	new SevenTapEmail().enterEmailAddress();
							 	super.pause(3); 
							 	new SevenTapEmail().clickSendButton();
								Assert.fail("Satellite 1 Onboarding - Unable to connect your max router to the Internet");
								  new KillAndRelaunchApp().killApp();
								  super.pause(5);
								  new KillAndRelaunchApp().relaunchApp();
								  super.pause(20);
							}
							
							
							//Firmware update page
							try {
								if(new AddSatelliteSystemUpToDatePage().isAt()) {
									new AddSatelliteSystemUpToDatePage().clickNextButton();
									super.waitForVisibility(new AddSatelliteRegisteringDeviceFailedPage().continueButton);
									}
							}catch(Exception e) {
								super.pause(10);
							 	new TapSevenTimes().tapSeven();
							 	super.pause(3);
							 	new SevenTapEmail().enterEmailAddress();
							 	super.pause(3); 
							 	new SevenTapEmail().clickSendButton();
							 	Assert.fail("Satellite 1 Onboarding - Unable to update firmware on Satellite 1 ");
								  new KillAndRelaunchApp().killApp();
								  super.pause(5);
								  new KillAndRelaunchApp().relaunchApp();
								  super.pause(20);
							}
							
							//Registration Failed Page
							try {
								if(new AddSatelliteRegisteringDeviceFailedPage().isAt()) {
									new AddSatelliteRegisteringDeviceFailedPage().clickContinueButton();
									super.waitForVisibility(new AddSatelliteCongratulationsPage().continueButton);
								}
							}catch(Exception e) {
								super.pause(10);
							 	new TapSevenTimes().tapSeven();
							 	super.pause(3);
							 	new SevenTapEmail().enterEmailAddress();
							 	super.pause(3); 
							 	new SevenTapEmail().clickSendButton();
							 	Assert.fail("Satellite 1 Onboarding - Failure to add Satellite ");
								  new KillAndRelaunchApp().killApp();
								  super.pause(5);
								  new KillAndRelaunchApp().relaunchApp();
								  super.pause(20);
							}
							
							//Congratulations Page
							try {

								if(new AddSatelliteCongratulationsPage().isAt()) {
									new AddSatelliteCongratulationsPage().clickContinueButton();
									super.pause(60);
									}
							}catch(Exception e) {
								super.pause(10);
							 	new TapSevenTimes().tapSeven();
							 	super.pause(3);
							 	new SevenTapEmail().enterEmailAddress();
							 	super.pause(3); 
							 	new SevenTapEmail().clickSendButton();
							 	Assert.fail("Satellite 1 Onboarding - Failed at Congratulations Page" );
								  new KillAndRelaunchApp().killApp();
								  super.pause(5);
								  new KillAndRelaunchApp().relaunchApp();
								  super.pause(20);
							}

							new HomePage().verifyLeftRouterDetails();

							softsatellite1.assertAll();

						} catch (Exception e) {		
							  Assert.fail("Satellite 1 Onboarding - failed");
							  new KillAndRelaunchApp().killApp();
							  super.pause(5);
							  new KillAndRelaunchApp().relaunchApp();
							  super.pause(20);
						}  
					
				}

				
				@Test(priority = 161, dependsOnMethods = { "Verify_SignUp_And_Onboard" })
				public void Verify_Install_Right_Satellite_Page() 
				{
					utils.log().info("                             ");
					utils.log().info("*****************************");
					utils.log().info("Test: Install Satellite2     ");
					utils.log().info("*****************************");
					
					SoftAssert softsatellite2 = new SoftAssert();
					
					performFactoryReset("Satellite2", "/dev/tty.usbserial-142340");
					
					try {
						
							try {
					  			if(new HomePage().cloudIcon.isDisplayed() || new HomePage().remoteAccessNotAvailableLink.isDisplayed()) {
					  				new HomePage().connectToSSID(this.ssidName);
					  				utils.log().info("Waiting for 120 seconds for the Wifi connection to stabilize on the homepage");
					  				super.pause(120);
								}else {utils.log().info("Remote access to your network is currently available");}
					  		}catch(Exception e) {};
				  		
						
					  		new HomePage().clickNavigationButton();
					  		new HomePage().getHamburgerMenuPageObject().clickAddSatelliteButton();
					  		new AddSatelliteInstallAdditionalSatelliteDialog().clickInstallSatelliteButton();
						
					  		// 1
							try 
							{
								if(new AddSatelliteAddNewSatellitePage1().isAt()) 
								{
									new AddSatelliteAddNewSatellitePage1().clickNextButton();// Each satellite expands your network
									utils.log().info("Waiting for 60 seconds ");
									super.pause(60);
									
									try
									{
										if(new AddSatelliteConnectedToNonMaxNetworkPage().isAt())
										{
											utils.log().info("Connected to a non max network");
											utils.log().info("Trying to re-establish connection with max router network");
											new HomePage().connectToSSID(this.ssidName);
											utils.log().info("Waiting for 120 seconds to establish a connection with the max router network");
								  			super.pause(120);
							  				
							  				if(new AddSatelliteConnectedToNonMaxNetworkPage().tryAgainStaticText.isDisplayed()) 
							  				{
							  					new AddSatelliteConnectedToNonMaxNetworkPage().clickTryAgainButton();
							  				} else {
							  					new AddSatelliteConnectedToNonMaxNetworkPage().clickTroubleShootButton();
							  					super.pause(3);
							  					new AddSatelliteConnectedToNonMaxNetworkTroubleShootProceedPage().clickProceedButton();
							  				}
										}
									}catch(Exception e) {}
								}
							}catch(Exception e) {
								utils.log().info("Clicking on Cancel button on Add Satellite Page 1 and proceed to home page");
								new AddSatelliteAddNewSatellitePage1().clickCancelButton();
								 if(new HomePage().isAt()) {
									 	super.pause(10);
									 	new TapSevenTimes().tapSeven();
									 	super.pause(3);
									 	new SevenTapEmail().enterEmailAddress();
									 	super.pause(3); 
									 	new SevenTapEmail().clickSendButton();
										  new KillAndRelaunchApp().killApp();
										  super.pause(5);
										  new KillAndRelaunchApp().relaunchApp();
										  super.pause(20);
								 }
							}
					  		

							//Unpack your satellite
							try{
								if(new AddSatelliteUnPackYourSatellitePage().isAt())
								{
									new AddSatelliteUnPackYourSatellitePage().clickNextButton();
									super.waitForVisibility(new AddSatelliteHelpPlaceYourSatellitePage().skipButton);
								}
							} catch (Exception e) {
								super.pause(10);
							 	new TapSevenTimes().tapSeven();
							 	super.pause(3);
							 	new SevenTapEmail().enterEmailAddress();
							 	super.pause(3); 
							 	new SevenTapEmail().clickSendButton();
								Assert.fail("Satellite 1 Onboarding - Failed at Unpack your satellite");
								  new KillAndRelaunchApp().killApp();
								  super.pause(5);
								  new KillAndRelaunchApp().relaunchApp();
								  super.pause(20);
							}
							
							//Help Place your satellite
							try
							{
								if(new AddSatelliteHelpPlaceYourSatellitePage().isAt())
								{
									new AddSatelliteHelpPlaceYourSatellitePage().clickSkipButton();
									super.waitForVisibility(new AddSatellitePlugInYourSatellitePage().nextButton);
								}
							} catch (Exception e) {
								super.pause(10);
							 	new TapSevenTimes().tapSeven();
							 	super.pause(3);
							 	new SevenTapEmail().enterEmailAddress();
							 	super.pause(3); 
							 	new SevenTapEmail().clickSendButton();
								Assert.fail("Satellite 1 Onboarding - Failed at We did like to help you place your satellite");
								  new KillAndRelaunchApp().killApp();
								  super.pause(5);
								  new KillAndRelaunchApp().relaunchApp();
								  super.pause(20);
							}
							
							//Plug in your satellite
							try
							{
								if(new AddSatellitePlugInYourSatellitePage().isAt())
								{
									new AddSatellitePlugInYourSatellitePage().clickNextButton();
									utils.log().info("Waiting for 120 seconds to establish connection with your max router bluetooth");
									super.pause(120);
								}
								
								try {
									if (new BlueToothConnectionFailedPage().isAt()) {
										new BlueToothConnectionFailedPage().clickTryAgainbutton();
										utils.log().info("Waiting for 120 seconds trying to establish connection with your max router bluetooth");
										super.pause(120);}
								} catch (Exception e5) {
								}
								
								
								try {
									if (new BlueToothConnectionFailedTroubleShootPage().isAt()) 
										new BlueToothConnectionFailedTroubleShootPage().clickTroubleShootButton();
									
									if (new BlueToothConnectionFailedProceedPage().isAt()) 
										new BlueToothConnectionFailedProceedPage().clickProceedButton();
									
									utils.log().info("Waiting for 120 seconds trying to establish connection with your max router bluetooth");
									super.pause(120);
								} catch (Exception e6) {}

							} catch (Exception e) {
								super.pause(10);
							 	new TapSevenTimes().tapSeven();
							 	super.pause(3);
							 	new SevenTapEmail().enterEmailAddress();
							 	super.pause(3); 
							 	new SevenTapEmail().clickSendButton();
								Assert.fail("Satellite 1 Onboarding - Unable to connect to your Mobile Device due to blue tooth connection failure");
								  new KillAndRelaunchApp().killApp();
								  super.pause(5);
								  new KillAndRelaunchApp().relaunchApp();
								  super.pause(20);
							}
							
							
							//Successfully Connected (to Bluetooth) Page
							try
							{
								super.waitForVisibility(new AddSatelliteSuccessfullyConnectedPage().nextButton);
								if(new AddSatelliteSuccessfullyConnectedPage().isAt())
								{
									new AddSatelliteSuccessfullyConnectedPage().clickNextButton();
									utils.log().info("Waiting for 120 seconds to connect your max router to the internet");
									super.pause(120);
								}
								
								try {
									if (new BlueToothConnectionFailedPage().isAt()) 
									{
										new BlueToothConnectionFailedPage().clickTryAgainbutton();
										utils.log().info("Waiting for 120 seconds trying to establish connection with your max router bluetooth");
										super.pause(120);
										
										super.waitForVisibility(new AddSatelliteSuccessfullyConnectedPage().nextButton);
										
										if(new AddSatelliteSuccessfullyConnectedPage().isAt())
										{
											new AddSatelliteSuccessfullyConnectedPage().clickNextButton();
											utils.log().info("Waiting for 120 seconds to connect your max router to the internet");
											super.pause(120);
										}
									}
								} catch (Exception e5) {}
								
												
								try {
									if (new BlueToothConnectionFailedTroubleShootPage().isAt()) 
										new BlueToothConnectionFailedTroubleShootPage().clickTroubleShootButton();
									
									if (new BlueToothConnectionFailedProceedPage().isAt()) 
									{
										new BlueToothConnectionFailedProceedPage().clickProceedButton();
										utils.log().info("Waiting for 120 seconds trying to establish connection with your max router bluetooth");
										super.pause(120);
										
										super.waitForVisibility(new AddSatelliteSuccessfullyConnectedPage().nextButton);
										
										if(new AddSatelliteSuccessfullyConnectedPage().isAt())
										{
											new AddSatelliteSuccessfullyConnectedPage().clickNextButton();
											utils.log().info("Waiting for 120 seconds to connect your max router to the internet");
											super.pause(120);
										}
									}
								} catch (Exception e6) {}

							} catch (Exception e) {
								super.pause(10);
							 	new TapSevenTimes().tapSeven();
							 	super.pause(3);
							 	new SevenTapEmail().enterEmailAddress();
							 	super.pause(3); 
							 	new SevenTapEmail().clickSendButton();
								Assert.fail("Satellite 1 Onboarding - Unable to connect Max Router to your Mobile Device due to blue tooth connection failure");
								  new KillAndRelaunchApp().killApp();
								  super.pause(5);
								  new KillAndRelaunchApp().relaunchApp();
								  super.pause(20);
							}
							
							
							//Successfully Connected to Internet Page
							try {
								super.waitForVisibility(new AddSatelliteSuccessfullyConnectedToInternetPage().nextButton);
								if(new AddSatelliteSuccessfullyConnectedToInternetPage().isAt()) 
								{
									new AddSatelliteSuccessfullyConnectedToInternetPage().clickNextButton();
									super.waitForVisibility(new AddSatelliteSystemUpToDatePage().nextButton);
								}

							}catch(Exception e) {
								super.pause(10);
							 	new TapSevenTimes().tapSeven();
							 	super.pause(3);
							 	new SevenTapEmail().enterEmailAddress();
							 	super.pause(3); 
							 	new SevenTapEmail().clickSendButton();
								Assert.fail("Satellite 1 Onboarding - Unable to connect your max router to the Internet");
								  new KillAndRelaunchApp().killApp();
								  super.pause(5);
								  new KillAndRelaunchApp().relaunchApp();
								  super.pause(20);
							}
							
							//Firmware update page
							try {
								if(new AddSatelliteSystemUpToDatePage().isAt()) {
									new AddSatelliteSystemUpToDatePage().clickNextButton();
									super.waitForVisibility(new AddSatelliteRegisteringDeviceFailedPage().continueButton);
									}
							}catch(Exception e) {
								super.pause(10);
							 	new TapSevenTimes().tapSeven();
							 	super.pause(3);
							 	new SevenTapEmail().enterEmailAddress();
							 	super.pause(3); 
							 	new SevenTapEmail().clickSendButton();
							 	Assert.fail("Satellite 1 Onboarding - Unable to update firmware on Satellite 1 ");
								  new KillAndRelaunchApp().killApp();
								  super.pause(5);
								  new KillAndRelaunchApp().relaunchApp();
								  super.pause(20);
							}
							
							//Registration Failed Page
							try {
								if(new AddSatelliteRegisteringDeviceFailedPage().isAt()) {
									new AddSatelliteRegisteringDeviceFailedPage().clickContinueButton();
									super.waitForVisibility(new AddSatelliteCongratulationsPage().continueButton);
								}
							}catch(Exception e) {
								super.pause(10);
							 	new TapSevenTimes().tapSeven();
							 	super.pause(3);
							 	new SevenTapEmail().enterEmailAddress();
							 	super.pause(3); 
							 	new SevenTapEmail().clickSendButton();
							 	Assert.fail("Satellite 1 Onboarding - Failure to add Satellite ");
								  new KillAndRelaunchApp().killApp();
								  super.pause(5);
								  new KillAndRelaunchApp().relaunchApp();
								  super.pause(20);
							}
							
							//Congratulations Page
							try {
								if(new AddSatelliteCongratulationsPage().isAt()) {
									new AddSatelliteCongratulationsPage().clickContinueButton();
									super.pause(60);
									}
							}catch(Exception e) {
								super.pause(10);
							 	new TapSevenTimes().tapSeven();
							 	super.pause(3);
							 	new SevenTapEmail().enterEmailAddress();
							 	super.pause(3); 
							 	new SevenTapEmail().clickSendButton();
							 	Assert.fail("Satellite 1 Onboarding - Failed at Congratulations Page" );
								  new KillAndRelaunchApp().killApp();
								  super.pause(5);
								  new KillAndRelaunchApp().relaunchApp();
								  super.pause(20);
							}

							new HomePage().verifyRightRouterDetails();

							softsatellite2.assertAll();

					} catch (Exception e) {
						  Assert.fail("Satellite 2 Onboarding - failed");
						  new KillAndRelaunchApp().killApp();
						  super.pause(5);
						  new KillAndRelaunchApp().relaunchApp();
						  super.pause(20);
					}
				
				}
				
				
				
//				@Test(priority = 163, dependsOnMethods = {"Verify_SignUp_And_Onboard", "Verify_Network_UI_Page"})
//				public void Verify_General_Settings_UI_Page() 
//				{
//					SoftAssert softnet39 = new SoftAssert();
//					new HomePage().getFooterIconsPageObject().clickNetworkButton();
//					new NetworkPage().clickNetworkSettingsExpandButton();
//					new NetworkPage().clickGeneralSettings(); 
//					try{
//						if(new NetworkPage().getAppRatingPageObject().isAt())
//							new NetworkPage().getAppRatingPageObject().clickRemindMeLaterLink();
//					}catch(Exception e) {}
//					
//					softnet39.assertAll();
//				}
//				
//				@Test(priority = 164, dependsOnMethods = {"Verify_SignUp_And_Onboard", "Verify_General_Settings_UI_Page"})
//				public void Verify_General_Settings_UPnP_Settings() 
//				{
//					SoftAssert softnet40 = new SoftAssert();
//					try{
//						if(new NetworkPage().getAppRatingPageObject().isAt())
//							new NetworkPage().getAppRatingPageObject().clickRemindMeLaterLink();
//					}catch(Exception e) {
//						utils.log().info("App Rating Dialog did not appear");
//					}
//					
//					softnet40.assertTrue(new NetworkPage().getGeneralSettingsPageObject().clickUPNPInfoIcon());
//					super.pause(10);
//					if(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsUPnPInfoDialogObject().isAt())
//						softnet40.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsUPnPInfoDialogObject().clickCloseButton());
//					softnet40.assertAll();
//				}
//				
//				@Test(priority = 165, dependsOnMethods = {"Verify_SignUp_And_Onboard", "Verify_General_Settings_UI_Page"})
//				public void Verify_General_Settings_IPv6_Enable_Settings() 
//				{
//					SoftAssert softnet39 = new SoftAssert();
//					softnet39.assertTrue(new NetworkPage().getGeneralSettingsPageObject().clickIPv6InfoIcon());
//					super.pause(10);
//					if(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsIPv6EnableInfoDialogObject().isAt())
//						softnet39.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsIPv6EnableInfoDialogObject().clickCloseButton());
//					softnet39.assertAll();
//				}
//				
//				@Test(priority = 166, dependsOnMethods = {"Verify_SignUp_And_Onboard", "Verify_General_Settings_UI_Page"})
//				public void Verify_General_Settings_Bridge_Mode_Settings() 
//				{
//					SoftAssert softnet42 = new SoftAssert();
//					softnet42.assertTrue(new NetworkPage().getGeneralSettingsPageObject().clickBridgeModeInfoIcon());
//					super.pause(10);
//					if(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsBridgeModeInfoDialogObject().isAt())
//						softnet42.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsBridgeModeInfoDialogObject().clickCloseButton());
//					softnet42.assertAll();
//				}
//				
//				@Test(priority = 167, dependsOnMethods = {"Verify_SignUp_And_Onboard", "Verify_General_Settings_UI_Page"})
//				public void Verify_General_Settings_Port_Forwarding_Settings() 
//				{
//					SoftAssert softnet43 = new SoftAssert();
//					new NetworkPage().getGeneralSettingsPageObject().clickPortForwardingink();
//					super.pause(10);
//					softnet43.assertAll();
//				}
//				
//				@Test(priority = 168, dependsOnMethods = {"Verify_SignUp_And_Onboard", "Verify_General_Settings_Port_Forwarding_Settings"})
//				public void Verify_General_Settings_Port_Forwarding_Add_Rules() 
//				{
//					SoftAssert softnet45 = new SoftAssert();
//					if(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().isAt()) 
//					{
////					for(int i = 1 ; i <=3 ; i++)
////					{
//						softnet45.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().clickAddRuleButton());
//						softnet45.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().enterPortRuleName());
//						softnet45.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().selectTCP());
//						softnet45.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().enterInternalPortStart());
//						softnet45.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().enterInternalPortEnd());
//						softnet45.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().enterExternalPortStart());
//						softnet45.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().enterExternalPortEnd());
//						softnet45.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().enterIPAddress());
//						softnet45.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().clickSaveButton());
//						
////						try {
////							if(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().allFieldsAreMandatoryError.isDisplayed()) {
////							softnet45.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().enterPortRuleName());
////							softnet45.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().clickSaveButton());}
////							}catch(Exception e) {}
////							
////						try {
////							if(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().internalPortStartError.isDisplayed()) {
////								softnet45.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().enterInternalPortStart());
////								softnet45.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().clickSaveButton());}
////							}catch(Exception e) {}
////							
////						try {
////							if(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().internalPortEndError.isDisplayed()) {
////								softnet45.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().enterInternalPortEnd());
////								softnet45.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().clickSaveButton());}
////							}catch(Exception e) {}
////								
////						try {
////							if(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().externalPortStartError.isDisplayed()) {
////								softnet45.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().enterExternalPortStart());
////								softnet45.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().clickSaveButton());}
////							}catch(Exception e) {}
////							
////						try {
////							if(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().externalPortEndError.isDisplayed()) {
////								softnet45.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().enterExternalPortEnd());
////								softnet45.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().clickSaveButton());}
////							}catch(Exception e) {}
////							
////							
//						try {
//							if(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().getPortRuleEditFailedDialogObject().isAt()) 
//								softnet45.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject()
//										.getPortRuleEditFailedDialogObject().clickOKButton());
//							}catch(Exception e) {
//									utils.log().info("Port Rule Edit Failed Dialog did not appear");
//							}
//				}
//					new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().clickBackButton();
//					new NetworkPage().getGeneralSettingsPageObject().clickBackButton();
//					softnet45.assertAll();
//				}
			
						
				@Test(priority = 123, dependsOnMethods = {"Verify_SignUp_And_Onboard", "Verify_Network_UI_Page"})
	//	@Test(priority = 162, dependsOnMethods = {"Verify_SignUp_And_Onboard"})
				public void Verify_Extended_WiFi_Settings_Page() 
				{
					SoftAssert softnet50 = new SoftAssert();
					
//					new NetworkPage().getFooterIconsPageObject().clickNetworkButton(); 
					super.pause(5);
					softnet50.assertTrue(new NetworkPage().clickExtendedWifiSettingsExpandButton());
					super.pause(5);
					softnet50.assertTrue(new NetworkPage().enable5GHzWidebandMode());
					if(new NetworkPage().get5GHzWidebandModeAlertDialogObject().isAt())
						softnet50.assertTrue(new NetworkPage().get5GHzWidebandModeAlertDialogObject().clickCancelButton());
					super.pause(5);
					softnet50.assertTrue(new NetworkPage().clickfiveGHzWidebandInfoIcon());
					if(new NetworkPage().get5GHzWidebandModeDialogObject().isAt())
						softnet50.assertTrue(new NetworkPage().get5GHzWidebandModeDialogObject().clickCloseButton());
					super.pause(5);
					softnet50.assertTrue(new NetworkPage().enableBandSteeringMode());
					if(new NetworkPage().getBandSteeringModeAlertDialogObject().isAt())
						softnet50.assertTrue(new NetworkPage().getBandSteeringModeAlertDialogObject().clickCancelButton());
					super.pause(5);
					softnet50.assertTrue(new NetworkPage().clickBandSteeringInfoIcon());
					if(new NetworkPage().getBandSteeringModeDialogObject().isAt())
						softnet50.assertTrue(new NetworkPage().getBandSteeringModeDialogObject().clickCloseButton());
					
					softnet50.assertTrue(new NetworkPage().clickExtendedWifiSettingsExpandButton());
					softnet50.assertAll();
				}

				@Test(priority = 124, dependsOnMethods = {"Verify_SignUp_And_Onboard"})
				public void Verify_New_Guest_WiFi_Network() 
				{
					SoftAssert softnet49 = new SoftAssert();
					
//					new HomePage().getFooterIconsPageObject().clickNetworkButton();
					super.pause(5);
					softnet49.assertTrue(new NetworkPage().enableGuestWifiNetwork());
					
					try{
						if(new NetworkPage().getAppRatingPageObject().isAt())
							new NetworkPage().getAppRatingPageObject().clickRemindMeLaterLink();
					}catch(Exception e) {
						utils.log().info("App Rating Dialog did not appear");
					}
	
					try {
						if(new NetworkPage().getEnableGuestNetworkDialogObject().isAt()) {
							super.pause(5);
							softnet49.assertTrue(new NetworkPage().getEnableGuestNetworkDialogObject().enterGuestNetworkName());
							softnet49.assertTrue(new NetworkPage().getEnableGuestNetworkDialogObject().enterGuestNetworkPassword());
							softnet49.assertTrue(new NetworkPage().getEnableGuestNetworkDialogObject().clickSaveChangesButton());
				
							if(new NetworkPage().getEnableGuestNetworkAlertDialogObject().isAt())
								softnet49.assertTrue(new NetworkPage().getEnableGuestNetworkAlertDialogObject().clickOkButton());
							}
							super.pause(20);
							try {
								if(new ConnectionToWifiNeededPage().joinButton.isDisplayed())
									new ConnectionToWifiNeededPage().clickJoinButton();
							}catch(Exception e) {}
			
							utils.log().info("Waiting for 120 seconds to create guest wifi connection");
							super.pause(120);
					}catch(Exception e) {utils.log().info("Enable Guest Network Page did not appear");}

					softnet49.assertAll();
				}
				
				private void performFactoryReset(String satelliteName, String usbserial) {
					  try {
							utils.log().info("Factory Reset : " + satelliteName);
							SerialComPortCommunicator.resetMAXRouter(usbserial);
							utils.log().info("Waiting for 60 seconds to perform the Factory reset");
							super.pause(60);	
					  }catch(Exception e) {utils.log().info("Unable to Factory reset on : " + satelliteName);}
				}
}



