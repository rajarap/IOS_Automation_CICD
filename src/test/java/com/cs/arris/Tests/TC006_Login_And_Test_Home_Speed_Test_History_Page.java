package com.cs.arris.Tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cs.arris.Base.ParentClass;
import com.cs.arris.Pages.DeviceSignalStrengthLeaderBoardPage;
import com.cs.arris.Pages.HomePage;
import com.cs.arris.Pages.HomeSpeedTestHistoryPage;
import com.cs.arris.Pages.SiginPage;
import com.cs.arris.Pages.SpeedTestPage;
import com.cs.arris.Utilities.TestUtils;
import com.cs.arris.Workflows.TC52_Login_And_Verify_HomePage_Workflow;
import com.cs.arris.Workflows.TC53_Login_And_Verify_DevicesPage_Workflow;
import com.cs.arris.Workflows.TC55_Login_And_Verify_HomeSpeedTestHistoryPage_Workflow;
 


public class TC006_Login_And_Test_Home_Speed_Test_History_Page extends ParentClass
{
	TestUtils utils = new TestUtils();
	String firstName;
	String lastName;
	String email;
	String passCode;
	String ssid;
	String ssidpass;
	String udid;
	String countOfDeviceSignalStrength;
	String countOfDevicesSpeedHistory;
	String countOfDevicesBlocked;
	String downloadSpeed;
	String uploadSpeed;
	int totalCountOfDevices;
	
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
		  utils.log().info("\n" + "\n" + "****** starting test : " + m.getName() + " ******" + "\n");
	  }
	  
	  
//	  @Test(priority = 1)
//	  public void Verify_Login_And_Onboard()
//	  {
//		  TC55_Login_And_Verify_HomeSpeedTestHistoryPage_Workflow.getStartedPage(getStarted -> {
//			  getStarted.clickGetStartedButton();
//		  }).grantPermissionsPage(grantPermission -> {
//			  grantPermission.clickContinueButton();
//		  }).deviceLocationPage(deviceLocation -> {
//			  deviceLocation.clickOnlyThisTimeLink();
//		  }).accessResourcesOnDevicePage(accessResoucesOnDevice -> {
//			  accessResoucesOnDevice.clickAllowLink();
//		  }).selectYourDevicePage(selectDevice -> {
//			  selectDevice.selectSurfboardMaxOption();
//			  selectDevice.clickNextButton();
//		  }).selectYourDevicePage2(selectDevice2 -> {
//			  selectDevice2.selectMaxProAX11000RadioButton();
//			  selectDevice2.clickNextButton();
//		  }).welcomeSigninPage(signin -> {
//			  signin.enterEmailAddress(email);
//			  signin.clickSigninButton();
//			  super.pause(12);
//		  }).getOTPCode(getOTP -> {
//			  passCode = getOTP.getValidOTP();
//	  		}).enterOTPPage(otpverify -> {
//			  otpverify.enterValidPassCode(passCode);
//	  		 }).codeVerifiedPage(codeVerified -> {
//				  codeVerified.getCodeVerifiedText();
//				  codeVerified.clickNextButton();
//				  super.pause(3);
//				  try
//				  {
//					  if(codeVerified.continueOnBoardingButton.isDisplayed())
//					  {
//						  codeVerified.clickContinueOnboardingButton();
//					  }
//				  }catch(Exception e)
//				  {
//					  e.getMessage();
//				  }
//			  }).setupWifi(setupwifi ->{
//				  setupwifi.clickskipTutorialButton();
//			  }).homePage(home -> {
//					  try {
//						  if(home.okButton.isDisplayed())
//							  home.clickOkButton();
//					  }catch(Exception e) {
//						  e.getMessage();  }
//				  });
//			}
	  
	  @Test(priority = 1)
		public void Verify_Speed_Test_And_History_Page() {
			try {
				this.Verify_Speed_Test_Page();
			}catch(Exception e) {utils.log().info("Issue in Speed Test Page");}
			
			try {
				this.Verify_Perform_Speed_Test();
			}catch(Exception e) {utils.log().info("Issue in Perform Speed Test Page");}
		
			try {
				this.Verify_Speed_Test_Help_page();
			}catch(Exception e) {utils.log().info("Issue in Speed Test Help Page");}
			
			try {
				this.Verify_Home_Speed_Test_History_Page();
			}catch(Exception e) {utils.log().info("Issue in Speed Test History Page");}

	  }
	  
	  @Test(priority = 2)
		public void Verify_Speed_Test_Page() {
			SoftAssert softspeedtest2 = new SoftAssert();
			AssertJUnit.assertTrue(new HomePage().clickNavigationButton());
			if(new HomePage().getHamburgerMenuPageObject().isAt()) 
			{
				if(new HomePage().getHamburgerMenuPageObject().speedTest.isDisplayed())
					AssertJUnit.assertTrue(new HomePage().getHamburgerMenuPageObject().clickSpeedTestButton());
			}
			if(new SpeedTestPage().isAt())
			{
				AssertJUnit.assertTrue(new SpeedTestPage().verifyUIOnSpeedTestPage());
			}
	  }
	  
	  @Test(priority = 3)
		public void Verify_Perform_Speed_Test() {
			SoftAssert softspeedtest3 = new SoftAssert();
			for (int i = 0; i < 3; i++)
			{
				AssertJUnit.assertTrue(new SpeedTestPage().performSpeedTest());
			}
		}
	  
	  @Test(priority = 4)
		public void Verify_Speed_Test_Help_page() {
			SoftAssert softspeedtest4 = new SoftAssert();
			AssertJUnit.assertTrue(new SpeedTestPage().clickHelpButton());
			AssertJUnit.assertTrue(new SpeedTestPage().getSpeedTestHelpPageObject().clickCloseButton());
			AssertJUnit.assertTrue(new SpeedTestPage().clickBackButton());
			softspeedtest4.assertAll();
		}
	  
	  @Test(priority = 5)
		public void Verify_Home_Speed_Test_History_Page() {
			SoftAssert softspeedtest5 = new SoftAssert();
			if(new HomePage().isAt()) 
				AssertJUnit.assertTrue(new HomePage().clickSpeedTestHistoryImage());
			
			if(new HomeSpeedTestHistoryPage().isAt())
				AssertJUnit.assertTrue(new HomeSpeedTestHistoryPage().verifyHomeSpeedTestHistory());
			
			AssertJUnit.assertTrue(new HomeSpeedTestHistoryPage().getFooterIconsPageObject().clickHomeButton());
		}
}

