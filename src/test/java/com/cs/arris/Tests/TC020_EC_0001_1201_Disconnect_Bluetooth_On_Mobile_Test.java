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
import com.cs.arris.Pages.BlueToothPage;
import com.cs.arris.Utilities.TestUtils;
import com.cs.arris.Workflows.TC01_EC_0001_1201_Disconnect_Bluetooth_On_Mobile_Workflow;
import com.cs.arris.Workflows.TC51_Signin_And_Onboard_Workflow;

import io.appium.java_client.android.AndroidDriver;

public class TC020_EC_0001_1201_Disconnect_Bluetooth_On_Mobile_Test extends ParentClass
{
	TestUtils utils = new TestUtils();
	BlueToothPage blueTooth;
	String email;
	String passCode;
	String expected_error_code_0005_1200;
	String expected_error_code_0001_1201;
	String expected_error_code_0001_0000;
	String expectedBluetoothText;
	String expectedBluetoothMessage;
	String firstName;
	String lastName;
	
	 @BeforeClass
	 public void beforeClass() throws Exception 
	 {
		 try 
	   	  	{
			  blueTooth = new BlueToothPage();
			  String dataFileName1 = "error_codes/error_codes.xml";
			  utils.log().info("Loading...Error Code XML file");
			  super.loadErrorCodesXML(dataFileName1);
			  this.expected_error_code_0005_1200 = getErrorCode().get("0005-1200");
			  this.expected_error_code_0001_1201 = getErrorCode().get("0001_1201");
			  this.expectedBluetoothText = getErrorCode().get("bluetooth_connection_failed_text");
			  this.expectedBluetoothMessage = getErrorCode().get("bluetooth_connection_failed_message");
			  utils.log().info("Retrieved...Bluetooth Error code from XML file");
			  
			  String dataFileName2 = "testdata/signup";
			  utils.log().info("Loading...Sign Up Test Data");
			  super.loadTestData(dataFileName2);
			  
			  this.firstName = properties.getProperty("firstname");
			  utils.log().info("First Name : " + this.firstName);

			  this.lastName = properties.getProperty("lastname");
			  utils.log().info("Last Name : " + this.lastName);
			  
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
		  
		   utils.log().info("****** starting test:" + m.getName() + "******" + "\n");
	  }
	  
	  @Test(priority = 1)
	  public void EC_0001_1201_Disconnect_Bluetooth_On_Mobile_Test()
	  {
		  try
		  {
			  blueTooth.disableBlueTooth();
			  TC01_EC_0001_1201_Disconnect_Bluetooth_On_Mobile_Workflow.getStartedPage(getStarted -> {
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
				  this.passCode = getotp.getValidOTP();
			  }).enterOTPPage(otpverify -> {
				  otpverify.enterValidPassCode(this.passCode);
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
				  super.pause(8);
			  }).bluetoothConnectionFailed(btConnectionFailed -> {
				  String actual_error_code = btConnectionFailed.getBluetoothConnectionErrorCode();
				  String actualBluetoothText = btConnectionFailed.getBluetoothFailedText();
				  String actualBluetoothMessage = btConnectionFailed.getBluetoothFailedMessage1();
				  
				  Assert.assertEquals(actualBluetoothText, expectedBluetoothText);
				  Assert.assertEquals(actualBluetoothMessage, expectedBluetoothMessage);
			  
				  if (actual_error_code.equals(expected_error_code_0005_1200)) //this EC is displayed if bluetooth is specifically disabled on the mobile device
				  {
					  Assert.assertEquals(actual_error_code, expected_error_code_0005_1200);
				  }else if (actual_error_code.equals(expected_error_code_0001_1201)) //this EC is displayed if bluetooth is enabled but is not able to connect to the router
				  {
					  Assert.assertEquals(actual_error_code, expected_error_code_0001_1201);
				  }else
				  {
					  Assert.assertEquals(actual_error_code, expected_error_code_0001_0000);
				  }
			  });
		  }finally
		  {
			  blueTooth.enableBlueTooth();
			  super.pause(5);
		  }
	  }
}
