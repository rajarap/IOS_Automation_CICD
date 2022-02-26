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
import com.cs.arris.Utilities.TestUtils;
import com.cs.arris.Workflows.TC04_EC_0002_1304_Internet_Connection_Not_Available_On_Router_Workflow;
import com.cs.arris.Workflows.TC05_EC_0000_1303_Router_Failed_To_Connect_To_Internet_Workflow;
import com.cs.arris.Workflows.TC51_Signin_And_Onboard_Workflow;

public class TC05_EC_0000_1303_Router_Failed_To_Connect_To_Internet_Test extends ParentClass
{
	TestUtils utils = new TestUtils();
	String firstName;
	String lastName;
	String email;
	String passCode;
	String ssid;
	String ssidpass;
	String udid;
	
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
			  
			  this.ssid = properties.getProperty("ssidname");
			  utils.log().info("SSID Name : " + this.ssid);
			  
			  this.ssidpass = properties.getProperty("ssidpwd");
			  utils.log().info("SSID Password : " + this.ssidpass);
			  
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
	  public void EC_0000_1303_Router_Failed_To_Connect_To_Internet_Test()
	  {
		  TC05_EC_0000_1303_Router_Failed_To_Connect_To_Internet_Workflow.getStartedPage(getStarted -> {
			  getStarted.clickGetStartedButton();
		  }).grantPermissionsPage(grantPermission -> {
			  grantPermission.clickContinueButton();
		  }).deviceLocationPage(deviceLocation -> {
			  deviceLocation.clickOnlyThisTimeLink();
		  }).accessResourcesOnDevicePage(accessResoucesOnDevice -> {
			  accessResoucesOnDevice.clickAllowLink();
			  super.pause(5);
		  }).selectYourDevicePage(selectDevice -> {
			  selectDevice.selectSurfboardMaxOption();
			  selectDevice.clickNextButton();
		  }).selectYourDevicePage2(selectDevice2 -> {
			  selectDevice2.selectMaxProAX11000RadioButton();
			  selectDevice2.clickNextButton();
			  super.pause(5);
		  }).welcomeSigninPage(signin -> {
			  signin.enterEmailAddress(email);
			  signin.clickSigninButton();
			  super.pause(10);
		  }).getOTPCode(getOTP -> {
			  passCode = getOTP.getValidOTP();
	  		}).enterOTPPage(otpverify -> {
			  otpverify.enterValidPassCode(passCode);
	  		 }).codeVerifiedPage(codeVerified -> {
				  codeVerified.getCodeVerifiedText();
				  codeVerified.clickNextButton();
				  super.pause(3);
				  try
				  {
					  if(codeVerified.continueOnBoardingButton.isDisplayed())
					  {
						  codeVerified.clickContinueOnboardingButton();
					  }
				  }catch(Exception e)
				  {
					  e.getMessage();
				  }
		  }).optimizeYourNetworkPage(optimize -> {
			  optimize.clickSkipOptimizeButton();
		  }).setUpHomeNetworkPage(homeNetwork -> {
			  homeNetwork.clickNextButton();
		  }).unPackYourBoxPage(unpackBox -> {
			  unpackBox.clickNextButton();
		  }).plugInYourMaxRouterPage(pluginRouter -> {
			  pluginRouter.clickNextButton();
			  super.pause(20);
		  }).maxRouterConnectedToMobilePage(connectedRouterToMobile -> {
			  try
			  {
				  connectedRouterToMobile.clickNextButton();
				  super.pause(120);
			  }catch(Exception e)
			  {
				  e.getMessage();
			  }
			//add 0002-1304 - Internet Connection Not available on Router
		  }).maxRouterConnectedToInternetPage(connecedRouterToInternet -> {
			  connecedRouterToInternet.clickTryAgainButton();
			  super.pause(10);
		  });
	  }
}
