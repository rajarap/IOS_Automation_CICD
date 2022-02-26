package com.cs.arris.Tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
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
import com.cs.arris.Workflows.UserUnSuccessfulSigninWorkflow;

public class SigninAsInvalidUserTest extends ParentClass
{
	TestUtils utils = new TestUtils();
	String invalidEmail;
	
	@BeforeClass
	 public void beforeClass() throws Exception 
	 {
		try 
  	  {
			  String dataFileName = "testdata/signup";
			  utils.log().info("Loading...Sign Up Test Data");
			  super.loadTestData(dataFileName);
			  this.invalidEmail = properties.getProperty("invalidemail");
			  System.out.println("email : " + this.invalidEmail);
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
	  public void signInAsInValidUser()
	  {
		  UserUnSuccessfulSigninWorkflow.getStartedPage(getStarted -> {
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
		  }).welcomeSigninPage(signin ->{
			  signin.enterEmailAddress(this.invalidEmail);
			  signin.clickSigninButton();
		  }).welcomeSignupPage(signup -> {
			  signup.isAt();
		  });
	  }


}
