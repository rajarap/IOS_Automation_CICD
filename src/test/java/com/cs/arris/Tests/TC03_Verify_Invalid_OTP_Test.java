package com.cs.arris.Tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.IAssert;

import com.cs.arris.Base.ParentClass;
import com.cs.arris.Utilities.TestUtils;
import com.cs.arris.Workflows.TC01_EC_0001_1201_Disconnect_Bluetooth_On_Mobile_Workflow;
import com.cs.arris.Workflows.TC03_Verify_Invalid_OTP_Workflow;
import com.cs.arris.Workflows.TC51_Signin_And_Onboard_Workflow;

public class TC03_Verify_Invalid_OTP_Test extends ParentClass
{
	TestUtils utils = new TestUtils();
	String email;
	String passCode;
	String expectedBluetoothText;
	String expectedBluetoothMessage;
	
	 @BeforeClass
	 public void beforeClass() throws Exception 
	 {
		 try 
		 {
			String dataFileName = "testdata/signup";
			utils.log().info("Loading...Sign Up Test Data");
			super.loadTestData(dataFileName);
				    
			this.email = properties.getProperty("email");
			utils.log().info("Email address : " + this.email);
				  
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
	  public void Verify_Invalid_PassCode()
	  {
		  TC03_Verify_Invalid_OTP_Workflow.getStartedPage(getStarted -> {
			  getStarted.clickGetStartedButton();
		  }).grantPermissionsPage(grantPermission -> {
			  grantPermission.clickContinueButton();
		  }).deviceLocationPage(deviceLocation -> {
			  deviceLocation.clickOnlyThisTimeLink();
		  }).accessResourcesOnDevicePage(accessResoucesOnDevice -> {
			  accessResoucesOnDevice.clickAllowLink();
		  }).selectYourDevicePage(selectDevice -> {
			  selectDevice.selectSurfboardMaxOption();
			  selectDevice.clickNextButton();
		  }).selectYourDevicePage2(selectDevice2 -> {
			  selectDevice2.selectMaxProAX11000RadioButton();
			  selectDevice2.clickNextButton();
		  }).welcomeSigninPage(signin -> {
			  signin.enterEmailAddress(email);
			  signin.clickSigninButton();
			  super.pause(10);
		  }).getOTPCode(getotp -> {
			  this.passCode = getotp.getInValidOTP();
		  }).enterOTPPage(otpverify -> {
			  otpverify.enterInValidPassCode(this.passCode);
			  Assert.assertTrue(otpverify.verifyInvalidPassCodeMessage());
			  otpverify.clickResendLink();
		  }).resendOTPDialog(resendOTP -> {
			  resendOTP.clickOKButton();
			  super.pause(10);
		  }).getOTPCode(getotp -> {
			  this.passCode = getotp.getValidOTP();
	  	  }).enterOTPPage(otpverifi-> {
	  		  otpverifi.clearPassCodeText();
			  otpverifi.enterValidPassCode(this.passCode);
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
	  	  }).optimizeYourNetworkPage(optimizeNetwork -> {
	  		  Assert.assertTrue(optimizeNetwork.skipOptimizeButton.isDisplayed());
		  });
		  
	  }
}
