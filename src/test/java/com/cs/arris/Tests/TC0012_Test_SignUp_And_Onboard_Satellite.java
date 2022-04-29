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
			  utils.log().info("Waiting for 120 seconds");
			  super.pause(120);
			  
			  try {
				  if(new HomePage().getAppRatingDialogObject().isAt())
					  new HomePage().getAppRatingDialogObject().clickRemindMeLaterLink();
			  }catch(Exception e) {}
			  
			  try {
		  		if(new HomePage().cloudIcon.isDisplayed()) {
		  			new HomePage().connectToSSID(this.ssidName);
		  			utils.log().info("Waiting for 120 seconds for the Wifi connection to stabilize");
		  			super.pause(120);
		  		}
		  	 }catch(Exception e) {};
		  		
			 try {
			  	if(new HomePage().remoteAccessNotAvailableLink.isDisplayed()) {
			  		new HomePage().connectToSSID(this.ssidName);
			  		utils.log().info("Waiting for 120 seconds for the Wifi connection to stabilize");
			  		super.pause(120);
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
							utils.log().info("Waiting for 60 seconds ");
							super.pause(60);
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
							utils.log().info("Waiting for 60 seconds");
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