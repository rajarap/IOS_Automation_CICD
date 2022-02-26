package com.cs.arris.Tests;

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
import com.cs.arris.Workflows.TC60_Login_And_Verify_HamburgerMenuAndSettingsAboutHelpPage_Workflow;

public class TC008_Login_And_Test_Hamburger_Menu_And_Settings_About_Help_Page extends ParentClass {
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
		utils.log().info("\n" + "****** starting test:" + m.getName() + "******" + "\n");
	}

//	@Test(priority = 1)
//	public void Verify_HamburgerMenu_And_Settings_About_Help_Page() {
//		TC60_Login_And_Verify_HamburgerMenuAndSettingsAboutHelpPage_Workflow.getStartedPage(getStarted -> {
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
	
//	@Test(priority = 1)
//	public void Verify_Hamburger_Menu_Settings_About_Help_Page() {	
//		try {
//			this.Verify_Hamburger_Menu_Page();
//		}catch(Exception e) {utils.log().info("Issue in Hamburger Menu Page");}
//		
//		try {
//			this.Verify_Hamburger_Menu_Settings_UI_Page();
//		}catch(Exception e) {utils.log().info("Issue in Hamburger Menu Settings UI Page");}
//		
//		try {
////			this.Verify_Hamburger_Menu_Settings_Sign_Out();
//		}catch(Exception e) {utils.log().info("Issue in Hamburger Menu Settings Sign Out");}
//		
//		try {
//			this.Verify_Hamburger_Menu_Settings_Help_Page();
//		}catch(Exception e) {utils.log().info("Issue in Hamburger Menu Settings Help Page");}
//		
//		try {
//			this.Verify_Hamburger_Menu_About_UI_Page();
//		}catch(Exception e) {utils.log().info("Issue in Hamburger Menu About UI Page");}
//		
//		try {
//			this.Verify_Hamburger_Menu_About_License_Page();
//		}catch(Exception e) {utils.log().info("Issue in Hamburger Menu About License Page");}
//		
//		try {
//			this.Verify_Hamburger_Get_Another_Max_Page();
//		}catch(Exception e) {utils.log().info("Issue in Hamburger Get Another Max Page");}
//		
//		try {
//			this.Verify_Hamburger_About_Help_Page();
//		}catch(Exception e) {utils.log().info("Issue in Hamburger About Help Page");}
//		
//		try {
//			this.Verify_Hamburger_Surfboard_Help_UI_Page();
//		}catch(Exception e) {utils.log().info("Issue in Hamburger Surfboard Help UI Page");}
//		
//		try {
//			this.Verify_Hamburger_Surfboard_FAQ_Help_Page();
//		}catch(Exception e) {utils.log().info("Issue in Hamburger Surfboard FAQ Help Page");}
//		
//		try {
//			this.Verify_Hamburger_Surfboard_Self_Help_Page();
//		}catch(Exception e) {utils.log().info("Issue in Hamburger Surfboard Self Help Page");}
//		
//		try {
//			this.Verify_Hamburger_Surfboard_Chat_With_US_Page();
//		}catch(Exception e) {utils.log().info("Issue in Hamburger Surfboard Chat With US Page");}
//	}
	
//	@Test(priority = 2)
//	public void Verify_Hamburger_Menu_Page() {
//		SoftAssert softburger2 = new SoftAssert();
//		softburger2.assertTrue(new HomePage().clickNavigationButton());
//		if(new HomePage().getHamburgerMenuPageObject().isAt()) 
//			softburger2.assertTrue(new HomePage().getHamburgerMenuPageObject().verifyUIOnHamburgerMenuPage());
//		
//		softburger2.assertAll();
//	}
//	
//	@Test(priority = 3)
//	public void Verify_Hamburger_Menu_Settings_UI_Page() {
//		SoftAssert softburger3 = new SoftAssert();
//		softburger3.assertTrue(new HomePage().getHamburgerMenuPageObject().clickSettingsButton());
//		if(new HomePage().getHamburgerMenuPageObject().getSettingAboutHelpPageObject().isAt())
//			softburger3.assertTrue(new HomePage().getHamburgerMenuPageObject().getSettingAboutHelpPageObject().verifyUIOnSettingsPage());
//			//softburger3.assertTrue(new HomePage().getHamburgerMenuPageObject().getSettingAboutHelpPageObject().clickBackButton());
//		softburger3.assertAll();
//	}
//	
//	@Test(priority = 4)
//	public void Verify_Hamburger_Menu_Settings_Sign_Out() {
//		SoftAssert softburger4 = new SoftAssert();
////		String userEmail = new HomePage().getHamburgerMenuPageObject().getSettingAboutHelpPageObject().getUserEmailAddress();
//		softburger4.assertTrue(new HomePage().getHamburgerMenuPageObject().getSettingAboutHelpPageObject().clickSignOutButton());
//		new SiginPage().emailAddressTextBox.getText();
//		try {
////			if(userEmail.equals(new SiginPage().emailAddress.getText())) {
////				softburger4.assertTrue(new SiginPage().clickSigninButton());
////				super.pause(5);	}
//		}catch(Exception e) {}
//		softburger4.assertAll();
//	}
//	
//	@Test(priority = 5)
//	public void Verify_Hamburger_Menu_Settings_Help_Page() {
//		SoftAssert softburger5 = new SoftAssert();
////		softburger5.assertTrue(new HomePage().clickNavigationButton());
////		if(new HomePage().getHamburgerMenuPageObject().isAt()) {
//			softburger5.assertTrue(new HomePage().getHamburgerMenuPageObject().getSettingAboutHelpPageObject().clickHelpIcon());
//			softburger5.assertTrue(new HomePage().getHamburgerMenuPageObject().getSettingAboutHelpPageObject().clickBackButton());
//		
//		softburger5.assertAll();
//	}
//	
//
//	@Test(priority = 6)
//	public void Verify_Hamburger_Menu_About_UI_Page() {
//		SoftAssert softburger6 = new SoftAssert();
//		softburger6.assertTrue(new HomePage().clickNavigationButton());
//		if(new HomePage().getHamburgerMenuPageObject().isAt()) 
//			softburger6.assertTrue(new HomePage().getHamburgerMenuPageObject().clickAboutAppButton());
//		
//		if(new HomePage().getHamburgerMenuPageObject().getSettingAboutHelpPageObject().isAtAboutPage())
//			softburger6.assertTrue(new HomePage().getHamburgerMenuPageObject().getSettingAboutHelpPageObject().verifyUIOnAboutPage());
//		
//		softburger6.assertAll();
//	}
//	
//	@Test(priority = 7)
//	public void Verify_Hamburger_Menu_About_License_Page() {
//		SoftAssert softburger7 = new SoftAssert();
//		softburger7.assertTrue(new HomePage().getHamburgerMenuPageObject().getSettingAboutHelpPageObject().clickLicenseButton());
//		super.pause(3);
//		if(new HomePage().getHamburgerMenuPageObject().getSettingAboutHelpPageObject().getLicensesPageObject().isAt())
//		{
//			//softburger7.assertTrue(new HomePage().getHamburgerMenuPageObject().getSettingAboutHelpPageObject().getLicensesPageObject().verifyUIOnLicensesPage());
//			softburger7.assertTrue(new HomePage().getHamburgerMenuPageObject().getSettingAboutHelpPageObject().getLicensesPageObject().clickCloseButton());
//		}
//		softburger7.assertAll();
//	}
//	
//	@Test(priority = 8)
//	public void Verify_Hamburger_Get_Another_Max_Page() {
//		SoftAssert softburger8 = new SoftAssert();
////		if(new HomePage().getHamburgerMenuPageObject().getSettingAboutHelpPageObject().isAtAboutPage())
//			softburger8.assertTrue(new HomePage().getHamburgerMenuPageObject().getSettingAboutHelpPageObject().clickGetAnotherMaxRouterButton());
////		softburger8.assertTrue(new HomePage().getHamburgerMenuPageObject().getSettingAboutHelpPageObject().clickBackButton());
//			
//		softburger8.assertAll();
//	}
//	
//	@Test(priority = 9)
//	public void Verify_Hamburger_About_Help_Page() {
//		SoftAssert softburger9 = new SoftAssert();
//		softburger9.assertTrue(new HomePage().getHamburgerMenuPageObject().getSettingAboutHelpPageObject().clickHelpIcon());
//		softburger9.assertTrue(new HomePage().getHamburgerMenuPageObject().getSettingAboutHelpPageObject().getAboutHelpPageObject().clickCloseButton());
//		softburger9.assertTrue(new HomePage().getHamburgerMenuPageObject().getSettingAboutHelpPageObject().clickBackButton());
//		
//		softburger9.assertAll();
//	}
//	
//	@Test(priority = 10)
//	public void Verify_Hamburger_Surfboard_Help_UI_Page() {
//		SoftAssert softburger10 = new SoftAssert();
//		softburger10.assertTrue(new HomePage().clickNavigationButton());
//		if(new HomePage().getHamburgerMenuPageObject().isAt()) 
//			softburger10.assertTrue(new HomePage().getHamburgerMenuPageObject().clickHelpMenuButton());
//		
//		if(new HomePage().getHamburgerMenuPageObject().getSettingAboutHelpPageObject().isAtHelpPage())
//			softburger10.assertTrue(new HomePage().getHamburgerMenuPageObject().getSettingAboutHelpPageObject().verifyUIOnHelpPage());
//		
//		softburger10.assertAll();
//	}
//		
//	@Test(priority = 11)
//	public void Verify_Hamburger_Surfboard_FAQ_Help_Page() {
//		SoftAssert softburger11 = new SoftAssert();
//		softburger11.assertTrue(new HomePage().getHamburgerMenuPageObject().getSettingAboutHelpPageObject().clickFAQButton());
//		
//		if(new HomePage().getHamburgerMenuPageObject().getSettingAboutHelpPageObject().getFAQHelpPageObject().isAt()) {
//			softburger11.assertTrue(new HomePage().getHamburgerMenuPageObject().getSettingAboutHelpPageObject().getFAQHelpPageObject().verifyUIOnFAQHelpPage());
//			softburger11.assertTrue(new HomePage().getHamburgerMenuPageObject().getSettingAboutHelpPageObject().getFAQHelpPageObject().clickBackButton());}
//		
//		softburger11.assertAll();
//	}
//	
//	@Test(priority = 12)
//	public void Verify_Hamburger_Surfboard_Self_Help_Page() {
//		SoftAssert softburger12 = new SoftAssert();
//		softburger12.assertTrue(new HomePage().getHamburgerMenuPageObject().getSettingAboutHelpPageObject().clickSelfHelp());
//		
//		softburger12.assertAll();
//	}
//	
//	@Test(priority = 13)
//	public void Verify_Hamburger_Surfboard_Chat_With_US_Page() {
//		SoftAssert softburger13 = new SoftAssert();
//		softburger13.assertTrue(new HomePage().getHamburgerMenuPageObject().getSettingAboutHelpPageObject().clickLiveChatHelp());
//		softburger13.assertTrue(new HomePage().getHamburgerMenuPageObject().getSettingAboutHelpPageObject().clickBackButton());
//		
//		softburger13.assertAll();
//	}	
}