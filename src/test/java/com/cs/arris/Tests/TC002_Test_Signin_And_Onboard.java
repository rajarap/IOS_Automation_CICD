package com.cs.arris.Tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.lang.reflect.Method;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cs.arris.Base.ParentClass;
import com.cs.arris.Pages.MailErrorLogsPage;
import com.cs.arris.Pages.SiginPage;
import com.cs.arris.Utilities.TestUtils;
import com.cs.arris.Workflows.TC51_Signin_And_Onboard_Workflow;


public class TC002_Test_Signin_And_Onboard extends ParentClass
{
	TestUtils utils = new TestUtils();
	String firstName;
	String lastName;
	String email;
	String passCode;
	String ssidName;
	String ssidpass;
	String udid;
	
	 @BeforeClass
	 public void beforeClass() throws Exception 
	 {
		 try 
	   	  	{
			  String dataFileName = "testdata/signup";
			  super.loadTestData(dataFileName);
			  
			  this.firstName = properties.getProperty("firstname");
			  utils.log().info("First Name : " + this.firstName);

			  this.lastName = properties.getProperty("lastname");
			  utils.log().info("Last Name : " + this.lastName);
			  
			  this.email = properties.getProperty("email");
			  utils.log().info("Email address : " + this.email);
			  
			  this.ssidName = super.generateRouterSSID();
			  utils.log().info("SSID Name : " + this.ssidName);
			  
			  this.ssidpass = properties.getProperty("ssidpwd");
			  utils.log().info("SSID Password : " + this.ssidpass);
			  
			  this.udid = properties.getProperty("udid");
			  utils.log().info("UDID : " + this.udid);

			} catch(Exception e) {
			 e.printStackTrace();
		} 
     }
	
	
	  @BeforeMethod
	  public void beforeMethod(Method m) {
		  utils.log().info("\n" + "\n" + "****** starting test : " + m.getName() + " ******" + "\n");
	  }
	  
	  @Test(priority = 1)
	  public void Verify_Signin_And_Onboard()
	  {
		  TC51_Signin_And_Onboard_Workflow.getStartedPage(getStarted -> {
			  getStarted.clickGetStartedButton();
		  }).grantPermissionsPage(grantPermission -> {
			  grantPermission.clickContinueButton();
			  super.pause(5);
		  }).deviceLocationPage(deviceLocation -> {
			  deviceLocation.clickWhileUsingAppLink();
			  super.pause(5);
		  }).accessResourcesOnDevicePage(accessResoucesOnDevice -> {
			  accessResoucesOnDevice.clickOkButton();
		  }).selectYourDevicePage(selectDevice -> {
			  selectDevice.selectSurfboardMaxOption();
			  selectDevice.clickNextButton();
			  super.pause(5);
		  }).selectYourDevicePage2(selectDevice2 -> {
			  selectDevice2.selectMaxProAX11000RadioButton();
			  selectDevice2.clickNextButton();
			  super.pause(5);
		  }).welcomeSigninPage(signin -> {
			  signin.clearEmailAddress();
			  signin.enterEmailAddress(email);
			  signin.clickSigninButton();
			  super.pause(12);
		  }).getOTPCode(getOTP -> {
			  passCode = getOTP.getValidOTP();
	  		}).enterOTPPage(otpverify -> {
			  otpverify.enterValidPassCode(passCode);
			  super.pause(5);
	  		 }).codeVerifiedPage(codeVerified -> {
				  codeVerified.getCodeVerifiedText();
				  codeVerified.clickNextButton();
				  super.pause(35);
				  try{
					  if(codeVerified.continueOnBoardingButton.isDisplayed()){
						  new MailErrorLogsPage().checkError();
						  try {
						  	if(new MailErrorLogsPage().isAt()) {
						  		new MailErrorLogsPage().enterEmailAddress();
						  		new MailErrorLogsPage().clickSendButton();
						  		super.pause(5);
						  	}
						  }catch(Exception e) {}
						  codeVerified.clickContinueOnboardingButton();}
				  }catch(Exception e){ e.getMessage();}
		  }).optimizeYourNetworkPage(optimize -> {
			  optimize.clickSkipOptimizeButton();
		  }).setUpHomeNetworkPage(homeNetwork -> {
			  homeNetwork.clickNextButton();
		  }).unPackYourBoxPage(unpackBox -> {
			  unpackBox.clickNextButton();
		  }).plugInYourMaxRouterPage(pluginRouter -> {
			  pluginRouter.clickNextButton();
			  super.pause(5);
		  }).connectBlueToothDialog(bluetooth -> {
			  bluetooth.clickOkButton();
			  super.pause(15);
		  }).maxRouterConnectedToMobilePage(connectedRouterToMobile -> {
			  connectedRouterToMobile.clickNextButton();
			  super.pause(20);
//			  super.pause(150);
//			  if(connectedRouterToMobile.getTryAgainButton()) {
//				  utils.log().info("Connect the mAX Router to Wifi manually");
//				  super.pause(100);
//				  connectedRouterToMobile.clickTryAgainButton();
//				  super.pause(5);
//			  }else {
//				  utils.log().info("Try Again button is not displayed");
//			  }
////		  }).routerUnableToConnectToInternet(noInternet -> {
////			  if(noInternet.getTryAgainButton()) {
////				  utils.log().info("Connect the mAX Router to Wifi manually");
////				  super.pause(90);
////				  noInternet.clickTryAgainButton();}
//			//add 0002-1304 - Internet Connection Not available on Router
		  }).maxRouterConnectedToInternetPage(connecedRouterToInternet -> {
			  connecedRouterToInternet.clickNextButton();
			  super.pause(25);
		  }).systemFirmwareUpdatePage(firmwareUpdate -> {
			  firmwareUpdate.clickNextButton();
			  super.pause(30);
			  try{
				  if(firmwareUpdate.continueButton.isDisplayed()){
					  firmwareUpdate.clickContinueButton();}
			  }catch(Exception e){ e.getMessage();}
//		  }).warrantyAndSupportPage(warrantyAndSupport -> { 
//			  warrantyAndSupport.clickContinueButton();
//			  super.pause(15);
		  }).nameYourNetworkPage(nameYourNetwork -> {
			  nameYourNetwork.enterSSIDName(this.ssidName);
			  nameYourNetwork.enterSSIDPassword(this.ssidpass);
			  super.pause(10);
			  try{
				  if(nameYourNetwork.doneLink.isDisplayed())
					  nameYourNetwork.doneLink.click();
			  }catch(Exception e){ e.getMessage();}
			  nameYourNetwork.clickNextButton();
			  super.pause(50);
		  }).connectNeeded(connectionRequired -> { //connect SSID network to wifi
			  connectionRequired.clickJoinButton();
			  super.pause(30);
		  }).congratulations(congrats -> {
			  congrats.clickContinueButton();
			  super.pause(5);
		  }).setupWifi(setupwifi ->{
			  setupwifi.clickskipTutorialButton();
			  super.pause(5);
		  }).installSatellite(insatellite -> {
			  try {
				  if(insatellite.allowButton.isDisplayed()) 
					  click(insatellite.allowButton);
			  }catch(Exception e) {}
			  insatellite.clickInstallLaterButton();
			  super.pause(5);
		  }).networkOptimization(optimization -> {
			  optimization.clickOkButton();
			  super.pause(25);
	  	  }).homePage(homepage -> {	
	  		super.pause(12);
	  		try {
	  			if(homepage.getAppRatingDialogObject().isAt())
		  			homepage.getAppRatingDialogObject().clickRemindMeLaterLink();
	  		}catch(Exception e) {};
	  		try {
	  			if(homepage.cloudIcon.isDisplayed() || homepage.remoteAccessNotAvailableLink.isDisplayed())
		  			homepage.connectToSSID(this.ssidName);
	  		}catch(Exception e) {};
		  });
	  }
}



