package com.cs.arris.Tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.io.InputStream;
import java.lang.reflect.Method;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.cs.arris.Base.ParentClass;
import com.cs.arris.Utilities.TestUtils;
import com.cs.arris.Workflows.UserSignUpWorkflow;

public class SignUpTest extends ParentClass
{
	TestUtils utils = new TestUtils();
	String firstName;
	String lastName;
	String email;
	SoftAssert softAssert;
	
	 @BeforeClass
	 public void beforeClass() throws Exception 
	 {
		 softAssert = new SoftAssert();
    	  try 
    	  {
			  String dataFileName = "testdata/signup";
			  utils.log().info("Loading...Sign Up Test Data");
			  super.loadTestData(dataFileName);
			  this.firstName = properties.getProperty("firstname");
			  this.lastName = properties.getProperty("lastname");
			  this.email = properties.getProperty("email");
			  utils.log().info("Retrieved...Sign Up Test Data");
		  } catch(Exception e) {
			  e.printStackTrace();
			  throw e;
		  } 
     }
	
	  @BeforeMethod
	  public void beforeMethod(Method m) 
	  {
		   utils.log().info("\n" + "****** starting test:" + m.getName() + "******" + "\n");
	  }
	  
	  @Test(priority = 1)
	  public void signUp()
	  {
		  UserSignUpWorkflow.getStartedPage(getStarted -> {
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
			  signin.clickSignUpButton();
		  }).welcomeSignupPage(signup -> {
			  getDriver().hideKeyboard();
//			  signup.enterFirstName(this.firstName);
//			  super.pause(1);
//			  signup.enterLastName(this.lastName);
//			  super.pause(1);
//			  signup.enterValidEmailAddress(this.email);
//			  super.pause(1);
//			  signup.clickSignupButton();
//			  super.pause(15);
		  }).otpVerificationPage(otpverify -> {
			  otpverify.enterValidPassCode(this.email);
		  }).codeVerifiedPage(codeVerified -> {
			  codeVerified.getCodeVerifiedText();
		  });
	  }

}




































//@BeforeClass
//public void beforeClass() throws Exception 
//{
//	 softAssert = new SoftAssert();
//	  try 
//	  {
//		  String dataFileName = "testdata/signup";
//		  utils.log().info("Loading...Sign Up Test Data");
//		  super.loadTestData(dataFileName);
//		  this.firstName = properties.getProperty("firstname");
//		  System.out.println("first name : " + this.firstName);
//		  this.lastName = properties.getProperty("lastname");
//		  System.out.println("last name : " + this.lastName);
//		  this.email = properties.getProperty("email");
//		  System.out.println("email : " + this.email);
//		  utils.log().info("Retrieved...Sign Up Test Data");
//	  } catch(Exception e) {
//		  e.printStackTrace();
//		  throw e;
//	  } 
//}

//{
//	  UserSignUpWorkflow.getStartedPage(getStarted -> {
//		  getStarted.getGetStartedMessage();
//		  String actualMessage = getStarted.getGetStartedMessage();
//		  String expectedMessage = getStrings().get("get_started_page_message");
//		  softAssert.assertEquals(actualMessage, expectedMessage);
//		  
//		  String actualText = getStarted.getGetStartedButtonText();
//		  String expectedText = getStrings().get("get_started_page_get_started_button_text");
//		  softAssert.assertEquals(actualText, expectedText);
//		  
//		  boolean flag = getStarted.clickGetStartedButton();
//		  if(flag)
//		  {
//			  utils.log("Get Started Button is displayed and is enabled on the Get Started Page");
//		  }else
//		  {
//			  Assert.fail("Get Started button is not enabled!!!!");
//		  }
//	  }).grantPermissionsPage(grantPermission -> {
//		  grantPermission.clickContinueButton();
//		  boolean flag = grantPermission.clickContinueButton();
//		  if(flag)
//		  {
//			  utils.log("Continue Button is displayed and is enabled");
//		  }else
//		  {
//			  utils.log("Continue Button is either not displayed or is not enabled on the Grant Permission page!!!!");
//			  Assert.fail("Continue Button is either not displayed or is not enabled on the Grant Permissions page!!!!");
//		  }
//	  }).deviceLocationPage(deviceLocation -> {
//		  deviceLocation.clickOnlyThisTimeLink();
//	  }).accessResourcesOnDevicePage(accessResoucesOnDevice -> {
//		  accessResoucesOnDevice.clickOnAllowLink();
//	  }).selectYourDevicePage(selectDevice -> {
//		  selectDevice.selectSurfboardMaxOption();
//		  selectDevice.clickNextButton();
//	  }).selectYourDevicePage2(selectDevice2 -> {
//		  selectDevice2.selectMaxProAX11000RadioButton();
//		  selectDevice2.clickNextButton();
//	  }).welcomeSigninPage(signin -> {
//		  signin.clickSignUpButton();
//	  }).welcomeSignupPage(signup -> {
//		  signup.enterFirstName(this.firstName);
//		  signup.enterLastName(this.lastName);
//		  signup.enterValidEmailAddress(this.email);
//		  signup.clickSignupButton();
//	  }).otpVerificationPage(otpverify -> {
//		  String actualEmailAddress = otpverify.verifyEmailAddress();
//		  String expectedEmailAddress = email;
//		  if (actualEmailAddress != expectedEmailAddress)
//		  {
//			  Assert.assertEquals(actualEmailAddress, expectedEmailAddress);
//		  	  utils.log("Incorrect Email Address is displayed on the OTP verification Page");
//		  }else {utils.log("Correct Email Address is displayed on the OTP verification Page");}
//		  otpverify.enterPassCode();
//	  }).codeVerifiedPage(codeVerified -> {
//		  codeVerified.clickNextButton();
//	  });
//}
