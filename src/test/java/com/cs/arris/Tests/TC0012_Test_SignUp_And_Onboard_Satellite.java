package com.cs.arris.Tests;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.AssertJUnit;
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
import com.cs.arris.Pages.AddSatelliteCongratulationsPage;
import com.cs.arris.Pages.AddSatelliteInstallAdditionalSatelliteDialog;
//import com.cs.arris.Pages.AddSatellitePlaceYourSatellitePage;
import com.cs.arris.Pages.AddSatellitePlugInYourSatellitePage;
//import com.cs.arris.Pages.AddSatelliteRegistrationFailedPage;
import com.cs.arris.Pages.AddSatelliteSuccessfullyConnectedPage;
import com.cs.arris.Pages.AddSatelliteSuccessfullyConnectedToInternetPage;
//import com.cs.arris.Pages.AddSatelliteUnpackYourSatellitePage;
//import com.cs.arris.Pages.AddSatelliteUpToDatePage;
import com.cs.arris.Pages.AppRatingDialog;
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
		  	utils.log().info("Manually switch on and reest your mAX MainAP Router");
		  	super.pause(10);
//			utils.log().info("Factory Resetting MainAP");
//			SerialComPortCommunicator.resetMAXRouter("/dev/tty.usbserial-142330");
//			super.pause(75);
		  try {
			  new GetStartedPage().clickGetStartedButton();
			  new GrantPermissionsPage().clickContinueButton();
			  new DeviceLocationPage().clickAllowWhileUsingAppLink();
			  super.pause(5);
			  new AccessResourcesOnDevicePage().clickOkButton();
			  new SelectYourDevicePage().selectSurfboardMaxOption();
			  new SelectYourDevicePage().clickNextButton();
			  new SelectYourDevicePage2().selectMaxProAX11000RadioButton();
			  new SelectYourDevicePage2().clickNextButton();
			  super.pause(5);
			  
			  new SiginPage().clickSignUpButton();
			  email = new SignupPage().getEmailAddress();  //userXXXX
			  new SignupPage().enterValidEmailAddress(email+"@mail7.io");
			  new SignupPage().enterFirstName(firstName);
			  new SignupPage().enterLastName(lastName);
			  new SignupPage().clickAgreeTermsAndConditionsCheckBox();
			  super.pause(5);
			  if(new TermsAndConditionsPage().isAt()) {
				for(int i=1; i<=7; i++) {
					super.swipeUp();
				}
				  super.pause(3);
				  if(new TermsAndConditionsPage().understandAndAgreeButton.isEnabled()) {
						new TermsAndConditionsPage().clickUnderstandAndAgreeButton();
						super.pause(3);
			            new SignupPage().clickSignupButton();		  
			            new EnterValidOTPPage().enterInValidPassCode("123456");
			            Assert.assertTrue(new EnterValidOTPPage().verifyInvalidPassCodeMessage());
						 new EnterValidOTPPage().clickResendLink();
						 new ResendOTPDialog().clickOKButton();
						 super.pause(15);
						 new EnterValidOTPPage().clearPassCodeText();
						 new EnterValidOTPPage().enterValidPassCode(email);
						 super.pause(3);
						 new CodeVerifiedPage().getCodeVerifiedText();
						 new CodeVerifiedPage().clickNextButton();
				  }
			  }
			  super.pause(3);
			  new OptimizeYourNetworkPage().clickSkipOptimizeButton();
			  new SetupHomeNetworkPage().clickNextButton();
			  new UnPackYourBoxPage().clickNextButton();
			  new PlugInMaxRouterPage().clickNextButton();
			  super.pause(2);
			  new ConnectToBlueToothDialog().clickOkButton();
			  super.pause(15);
			  new ConnectMaxRouterToMobileDevicePage().clickNextButton();
			  super.pause(55);
			  new ConnectMaxRouterToInternetPage().clickNextButton();
			  super.pause(10);
			  new SystemFirmwareUpdatePage().clickNextButton();
			  super.pause(30);
			  new SomethingWentWrongPage().clickContinueButton();
			  new NameYourNetwokSSIDPage().enterSSIDName(this.ssidName);
			  new NameYourNetwokSSIDPage().enterSSIDPassword(this.ssidpass);
			  try {
				  if(new NameYourNetwokSSIDPage().doneLink.isDisplayed())
					  new NameYourNetwokSSIDPage().clickDoneLink();
			  }catch(Exception e) {}
			  new NameYourNetwokSSIDPage().clickNextButton();
			  super.pause(60);
			  new ConnectionToWifiNeededPage().clickJoinButton();
			  super.pause(30);
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
			  super.pause(25);
			  try {
				  if(new HomePage().getAppRatingDialogObject().isAt())
					  new HomePage().getAppRatingDialogObject().clickRemindMeLaterLink();
			  }catch(Exception e) {}
			  try {
		  			if(new HomePage().cloudIcon.isDisplayed() || new HomePage().remoteAccessNotAvailableLink.isDisplayed())
		  				new HomePage().connectToSSID(this.ssidName);
		  		}catch(Exception e) {};
			  new HomePage().getSSIDName();  

		  }catch(Exception e) {
			  new TapSevenTimes().tapSeven();
			  super.pause(3);
			  new SevenTapEmail().enterEmailAddress();
			  super.pause(3);
			  new SevenTapEmail().clickSendButton();
			  new KillAndRelaunchApp().killApp();}
	  }
	  
  
}



