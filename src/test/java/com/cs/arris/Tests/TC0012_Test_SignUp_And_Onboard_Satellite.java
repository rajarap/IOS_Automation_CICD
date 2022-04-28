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
import com.cs.arris.Pages.EnterValidOTPPage;

import com.cs.arris.Pages.GetStartedPage;
import com.cs.arris.Pages.GrantPermissionsPage;
//import com.cs.arris.Pages.HomeNetowrkTurnOffNetworkOptimizationDialog;
import com.cs.arris.Pages.HomePage;

import com.cs.arris.Pages.InstallAdditionalSatellitePage;

//import com.cs.arris.Pages.MaximumVerificationReachedPage;
import com.cs.arris.Pages.NameYourNetwokSSIDPage;
import com.cs.arris.Pages.NetworkOptimizationDialog;
import com.cs.arris.Pages.OptimizeYourNetworkPage;

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

public class TC0012_Test_SignUp_And_Onboard_Satellite extends ParentClass
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
			  try {
				  new NameYourNetwokSSIDPage().enterSSIDName(this.ssidName);
				  new NameYourNetwokSSIDPage().enterSSIDPassword(this.ssidpass);
				  new NameYourNetwokSSIDPage().clickNextButton();
				  super.pause(60);
				  new ConnectionToWifiNeededPage().clickJoinButton();
				  super.pause(40);

			  }catch(Exception e) {
				  new TapSevenTimes().tapSeven();
				  super.pause(5);
				  new SevenTapEmail().enterEmailAddress();
				  super.pause(5);
				  new SevenTapEmail().clickSendButton();
				  Assert.fail("Main AP Onboarding - Unable to create your max network. This may be due to poor internet connection or issue in the app.");
				  new KillAndRelaunchApp().killApp();
			  }
			  
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
	  
	  
		@Test(priority = 160, dependsOnMethods = { "Verify_SignUp_And_Onboard" })
		public void Verify_Install_Left_Satellite_Page() 
		{
		    utils.log().info("                            ");
			utils.log().info("****************************");
			utils.log().info("Test: Install Satellite1    ");
			utils.log().info("****************************");
		
			SoftAssert softsatellite1 = new SoftAssert();
			
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
					}
					
					
					//3
					try {
						super.waitForVisibility(new AddSatelliteAddNewSatellitePage3().nextButton);
						
						if(new AddSatelliteAddNewSatellitePage3().isAt()) 
						{  									
							new AddSatelliteAddNewSatellitePage3().clickNextButton(); //To continue with satellite install, please connect to arris-5550 network. Please connect through the WiFi settings of your mobile device.
							utils.log().info("Waiting for 120 seconds to establish a connection with the max network");
			  				super.pause(120);
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
						new KillAndRelaunchApp().relaunchApp();
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
						new KillAndRelaunchApp().relaunchApp();
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
						  new KillAndRelaunchApp().relaunchApp();
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
						new KillAndRelaunchApp().relaunchApp();
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
						new KillAndRelaunchApp().relaunchApp();
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
						new KillAndRelaunchApp().relaunchApp();
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
						new KillAndRelaunchApp().relaunchApp();
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
						new KillAndRelaunchApp().relaunchApp();
					}

					new HomePage().verifyLeftRouterDetails();

					softsatellite1.assertAll();

				} catch (Exception e) {		
					  Assert.fail("Satellite 1 Onboarding - failed");
					  new KillAndRelaunchApp().killApp();
					  new KillAndRelaunchApp().relaunchApp();
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
						new KillAndRelaunchApp().relaunchApp();
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
						new KillAndRelaunchApp().relaunchApp();
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
						new KillAndRelaunchApp().relaunchApp();
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
						new KillAndRelaunchApp().relaunchApp();
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
						new KillAndRelaunchApp().relaunchApp();
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
						new KillAndRelaunchApp().relaunchApp();
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
						new KillAndRelaunchApp().relaunchApp();
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
						new KillAndRelaunchApp().relaunchApp();
					}

					new HomePage().verifyRightRouterDetails();

					softsatellite2.assertAll();

			} catch (Exception e) {
				  Assert.fail("Satellite 2 Onboarding - failed");
				  new KillAndRelaunchApp().killApp();
				  new KillAndRelaunchApp().relaunchApp();
			}
		
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





////3
//try {
//	
//	super.waitForVisibility(new AddSatelliteAddNewSatellitePage3().nextButton);
//	
//	if(new AddSatelliteAddNewSatellitePage3().isAt()) 
//	{
//		new HomePage().checkConnectedWifiNetworkName(ssidName);
//		
//		if(! super.networkName.equals(this.ssidName))
//		{
//			utils.log().info("Network and SSID name are not same ");
//			new HomePage().connectToSSID(this.ssidName);
//			utils.log().info("Waiting for 60 seconds for the Wifi connection to stabilize on the homepage");
//  			super.pause(60);
//		}else {
//			utils.log().info("Already connected to " + this.ssidName + " home network");
//		}
//		
//		new AddSatelliteAddNewSatellitePage3().clickNextButton(); //To continue with satellite install, please connect to arris-5550 network. Please connect through the WiFi settings of your mobile device.
//		utils.log().info("Waiting for 60 seconds to establish a connection with the max network");
//			super.pause(60);
//	}
//	
//} catch (Exception e) {
//	utils.log().info("Clicking on Cancel button on Add Satellite Page 3 and proceed to home page");
//	new AddSatelliteAddNewSatellitePage3().clickCancelButton();
//	 if(new HomePage().isAt()) {
//		 	super.pause(10);
//		 	new TapSevenTimes().tapSeven();
//		 	super.pause(3);
//		 	new SevenTapEmail().enterEmailAddress();
//		 	super.pause(3); 
//		 	new SevenTapEmail().clickSendButton();
//	 }
//}





//new OptimizeYourNetworkPage().clickSkipOptimizeButton();
//new SetupHomeNetworkPage().clickNextButton();
//new UnPackYourBoxPage().clickNextButton();
//try {
//	  if(new PlugInMaxRouterPage().isAt()) {
//		  new PlugInMaxRouterPage().clickNextButton();
//		  super.pause(2);
//		  new ConnectToBlueToothDialog().clickOkButton();
//		  super.pause(15);
//	  }
//		  
//	  try {
//			if (new BlueToothConnectionFailedPage().isAt()) {
//				new BlueToothConnectionFailedPage().clickTryAgainbutton();
//				utils.log().info("Waiting for 120 seconds trying to establish connection with bluetooth");
//				super.pause(120);}
//		} catch (Exception e5) {}
//		
//		
//		try {
//			if (new BlueToothConnectionFailedTroubleShootPage().isAt()) 
//				new BlueToothConnectionFailedTroubleShootPage().clickTroubleShootButton();
//			
//			if (new BlueToothConnectionFailedProceedPage().isAt()) 
//				new BlueToothConnectionFailedProceedPage().clickProceedButton();
//			
//			utils.log().info("Waiting for 120 seconds trying to establish connection with bluetooth");
//			super.pause(120);
//		} catch (Exception e6) {}
//
//	} catch (Exception e) {
//		super.pause(10);
//	 	new TapSevenTimes().tapSeven();
//	 	super.pause(3);
//	 	new SevenTapEmail().enterEmailAddress();
//	 	super.pause(3); 
//	 	new SevenTapEmail().clickSendButton();
//		Assert.fail("Main AP Onboarding - Unable to connect Max Router to your Mobile Device due to blue tooth connection failure");
//		new KillAndRelaunchApp().killApp();
//	}
//
//new ConnectMaxRouterToMobileDevicePage().clickNextButton();
//super.pause(55);
//new ConnectMaxRouterToInternetPage().clickNextButton();
//super.pause(10);
//new SystemFirmwareUpdatePage().clickNextButton();
//super.pause(30);