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

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cs.arris.Base.ParentClass;
import com.cs.arris.Pages.HomePage;
import com.cs.arris.Pages.MainDeviceAllTabPage;
import com.cs.arris.Pages.SiginPage;
import com.cs.arris.Utilities.TestUtils;
import com.cs.arris.Workflows.HomePage_Workflow;
import com.cs.arris.Workflows.TC52_Login_And_Verify_HomePage_Workflow;
import com.cs.arris.Workflows.TC53_Login_And_Verify_DevicesPage_Workflow;
import com.cs.arris.Workflows.TC59_Login_And_Verify_AmazonFeatures_Workflow;
import com.cs.arris.Workflows.TC60_Login_And_Verify_HamburgerMenuAndSettingsAboutHelpPage_Workflow;

public class TC009_Login_And_Test_Hamburger_Menu_Amazon_Feature extends ParentClass {
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
	public void beforeClass() throws Exception {
		try {
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
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@BeforeMethod
	public void beforeMethod(Method m) {
		utils.log().info("\n" + "\n" + "****** starting test :  " + m.getName() + "  ******" + "\n");
	}

//	@Test(priority = 1)
//	public void Login_And_Onboard() {
//		TC59_Login_And_Verify_AmazonFeatures_Workflow.getStartedPage(getStarted -> {
//			getStarted.clickGetStartedButton();
//		}).grantPermissionsPage(grantPermission -> {
//			grantPermission.clickContinueButton();
//		}).deviceLocationPage(deviceLocation -> {
//			deviceLocation.clickOnlyThisTimeLink();
//		}).accessResourcesOnDevicePage(accessResoucesOnDevice -> {
//			super.pause(3);
//			accessResoucesOnDevice.clickAllowLink();
//		}).selectYourDevicePage(selectDevice -> {
//			selectDevice.selectSurfboardMaxOption();
//			selectDevice.clickNextButton();
//		}).selectYourDevicePage2(selectDevice2 -> {
//			selectDevice2.selectMaxProAX11000RadioButton();
//			selectDevice2.clickNextButton();
//			super.pause(3);
//		}).welcomeSigninPage(signin -> {
//			signin.enterEmailAddress(email);
//			signin.clickSigninButton();
//			super.pause(12);
//		}).getOTPCode(getOTP -> {
//			passCode = getOTP.getValidOTP();
//		}).enterOTPPage(otpverify -> {
//			otpverify.enterValidPassCode(passCode);
//		}).codeVerifiedPage(codeVerified -> {
//			codeVerified.getCodeVerifiedText();
//			codeVerified.clickNextButton();
//			super.pause(3);
//			try {
//				if (codeVerified.continueOnBoardingButton.isDisplayed()) {
//					codeVerified.clickContinueOnboardingButton();
//				}
//			} catch (Exception e) {
//				e.getMessage();
//			}
//		}).setupWifi(setupwifi -> {
//			setupwifi.clickskipTutorialButton();
//			super.pause(3);
//		}).homePage(home -> {
//			  try {
//				  if(home.okButton.isDisplayed())
//					  home.clickOkButton();
//			  }catch(Exception e) {
//				  e.getMessage();  }
//		  });
//	}
	
	@Test(priority = 1)
	public void Verify_Hamburger_Menu_Amazon_Feature_Page() {	
		try {
			this.Verify_Hamburger_Menu_Page();
		}catch(Exception e) {utils.log().info("Issue in Hamburger Menu Page");}
		
		try {
			this.Verify_Amazon_Features_UI_Page();
		}catch(Exception e) {utils.log().info("Issue in Amazon Features UI Page");}
		
		try {
			this.Verify_Amazon_Features_UI_Page();
		}catch(Exception e) {utils.log().info("Issue in Verify Amazon Features UI Page");}
		
		try {
			this.Verify_Get_Alexa_Skills_Drop_Down_Box();
		}catch(Exception e) {utils.log().info("Issue in Get Alexa Skills Drop Down Box");}
		
		try {
			this.Verify_Show_Password_Button();
		}catch(Exception e) {utils.log().info("Issue in Show Password Button");}
		
		try {
			this.Verify_Copy_Password();
		}catch(Exception e) {utils.log().info("Issue in Copy Password");}
		
		try {
			this.Verify_Amazon_Alexa_Skills_Link();
		}catch(Exception e) {utils.log().info("Issue in Amazon Alexa Skills Link");}
		
		try {
			this.Verify_Please_Tap_Here_Link();
		}catch(Exception e) {utils.log().info("Issue in Please Tap Here Link");}
		
		try {
			this.Verify_Enable_AFFS_Feature();
		}catch(Exception e) {utils.log().info("Issue in Enable AFFS Feature");}
		
		try {
			this.Verify_Disable_AFFS_Feature();
		}catch(Exception e) {utils.log().info("Issue in Disable AFFS Feature");}
		
		try {
			this. Verify_Amazon_Feature_Help_Page();
		}catch(Exception e) {utils.log().info("Issue in Amazon Feature Help Page");}
	}
	
	@Test(priority = 2)
	public void Verify_Hamburger_Menu_Page() {
		SoftAssert softfeatures2 = new SoftAssert();
		AssertJUnit.assertTrue(new HomePage().clickNavigationButton());
		if(new HomePage().getHamburgerMenuPageObject().isAt()) 
			AssertJUnit.assertTrue(new HomePage().getHamburgerMenuPageObject().verifyUIOnHamburgerMenuPage());
	}
	
	@Test(priority = 3)
	public void Verify_Amazon_Features_UI_Page() {
		SoftAssert softfeatures3 = new SoftAssert();
		AssertJUnit.assertTrue(new HomePage().getHamburgerMenuPageObject().clickAmazonFeaturesButton());
		if(new HomePage().getHamburgerMenuPageObject().getAmazonFeaturesPageObject().isAt())
			AssertJUnit.assertTrue(new HomePage().getHamburgerMenuPageObject().getAmazonFeaturesPageObject().verifyUIOnAFFSPage());
	}
	
	@Test(priority = 4)
	public void Verify_Get_Alexa_Skills_Drop_Down_Box() {
		SoftAssert softfeatures4 = new SoftAssert();
		AssertJUnit.assertTrue(new HomePage().getHamburgerMenuPageObject().getAmazonFeaturesPageObject().clickGetAlexaSkillsButton());
		AssertJUnit.assertTrue(new HomePage().getHamburgerMenuPageObject().getAmazonFeaturesPageObject().alexaSkillsContent.isDisplayed());
		AssertJUnit.assertTrue(new HomePage().getHamburgerMenuPageObject().getAmazonFeaturesPageObject().clickAlexaSkillsButtonAgain());
	}
	
	@Test(priority = 5)
	public void Verify_Show_Password_Button() {
		SoftAssert softfeatures5 = new SoftAssert();
		AssertJUnit.assertTrue(new HomePage().getHamburgerMenuPageObject().getAmazonFeaturesPageObject().clickShowPasswordButton());
		AssertJUnit.assertTrue(new HomePage().getHamburgerMenuPageObject().getAmazonFeaturesPageObject().getPasswordText());
		AssertJUnit.assertTrue(new HomePage().getHamburgerMenuPageObject().getAmazonFeaturesPageObject().clickShowPasswordButton());
		AssertJUnit.assertTrue(new HomePage().getHamburgerMenuPageObject().getAmazonFeaturesPageObject().getPasswordText());
	}
	
	@Test(priority = 6)
	public void Verify_Copy_Password() {
		SoftAssert softfeatures6 = new SoftAssert();
		AssertJUnit.assertTrue(new HomePage().getHamburgerMenuPageObject().getAmazonFeaturesPageObject().clickCopyPasswordButton());
		if(new HomePage().getHamburgerMenuPageObject().getAmazonFeaturesPageObject().clickCopyPasswordOKButton());
	}
	
	@Test(priority = 7)
	public void Verify_Amazon_Alexa_Skills_Link() {
		SoftAssert softfeatures7 = new SoftAssert();
		AssertJUnit.assertTrue(new HomePage().getHamburgerMenuPageObject().getAmazonFeaturesPageObject().clickAlexaSkillsLink());
	}
	
	@Test(priority = 8)
	public void Verify_Please_Tap_Here_Link() {
		SoftAssert softfeatures6 = new SoftAssert();
		AssertJUnit.assertTrue(new HomePage().getHamburgerMenuPageObject().getAmazonFeaturesPageObject().clickPleaseTapHereLink());
	}

	@Test(priority = 9)
	public void Verify_Enable_AFFS_Feature() {
		SoftAssert softfeatures9 = new SoftAssert();
		AssertJUnit.assertTrue(new HomePage().getHamburgerMenuPageObject().getAmazonFeaturesPageObject().enableAFFS());
		if(new HomePage().getHamburgerMenuPageObject().getAmazonFeaturesPageObject().getAmazonWifiSimpleSetupPageObject().isAt())
			AssertJUnit.assertTrue(new HomePage().getHamburgerMenuPageObject().getAmazonFeaturesPageObject().getAmazonWifiSimpleSetupPageObject().clickCloseButton());
	}
	
	@Test(priority = 10)
	public void Verify_Disable_AFFS_Feature() {
		SoftAssert softfeatures10 = new SoftAssert();
		AssertJUnit.assertTrue(new HomePage().getHamburgerMenuPageObject().getAmazonFeaturesPageObject().disableAFFS());
	}
		
	@Test(priority = 11)
	public void Verify_Amazon_Feature_Help_Page() {
		SoftAssert softfeatures11 = new SoftAssert();
		AssertJUnit.assertTrue(new HomePage().getHamburgerMenuPageObject().getAmazonFeaturesPageObject().clickHelpIcon());
		
		if(new HomePage().getHamburgerMenuPageObject().getAmazonFeaturesPageObject().getAFFSHelpPageObject().isAt())
			AssertJUnit.assertTrue(new HomePage().getHamburgerMenuPageObject().getAmazonFeaturesPageObject().getAFFSHelpPageObject().clickCloseButton());
		
		AssertJUnit.assertTrue(new HomePage().getHamburgerMenuPageObject().getAmazonFeaturesPageObject().clickBackButton());
	}
}