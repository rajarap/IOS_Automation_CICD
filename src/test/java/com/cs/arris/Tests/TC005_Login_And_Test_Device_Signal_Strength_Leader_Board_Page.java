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
import com.cs.arris.Pages.DeviceSignalStrengthLeaderBoardPage;
import com.cs.arris.Pages.DevicesPage;
import com.cs.arris.Pages.HomePage;
import com.cs.arris.Pages.MainDeviceAllTabPage;
import com.cs.arris.Pages.SiginPage;
import com.cs.arris.Utilities.TestUtils;


public class TC005_Login_And_Test_Device_Signal_Strength_Leader_Board_Page extends ParentClass {
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
		utils.log().info("\n" + "\n" + "****** starting test : " + m.getName() + " ******" + "\n");
	}

//	@Test(priority = 1)
//	public void Login_And_Onboard() {
//		TC54_Login_And_Verify_DeviceSignalStrengthLeaderBoardPage_Workflow.getStartedPage(getStarted -> {
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
//				e.getMessage();	}
//		}).setupWifi(setupwifi -> {
//			setupwifi.clickskipTutorialButton();
//			super.pause(3);
//		}).homePage(home -> {
//			  try {
//				  if(home.okButton.isDisplayed())
//					  home.clickOkButton();
//			  }catch(Exception e) {
//				  e.getMessage();  }
//			  home.clickDeviceSignalStrengthImage();
//		  });
//	}
//	
	
	@Test(priority = 1)
	public void Verify_Device_Signal_Strength_Leader_Board_Page() {
		try {
			this.Verify_Devices_Signal_Strength_UI_Page();
		}catch(Exception e) {utils.log().info("Issue in Device Page");}
		
		try {
			this.Verify_Signal_Strength_For_Devices();
		}catch(Exception e) {utils.log().info("Issue in Online Devices Page");}
	
		try {
			this.Verify_Sorting_Devices_From_Strong_To_Weak();
		}catch(Exception e) {utils.log().info("Issue in Edit Device Name Dialog");}
		
		try {
			this.Verify_Sorting_Devices_From_Weak_To_Strong();
		}catch(Exception e) {utils.log().info("Issue in Offline Devices Page");}
		
		try {
			this.Verify_Editing_Device_Name();
		}catch(Exception e) {utils.log().info("Issue in Devices Help Page");}

	}
	
	
	@Test(priority = 2)
	public void Verify_Devices_Signal_Strength_UI_Page() {
		SoftAssert softsignal2 = new SoftAssert();
		new HomePage().clickDeviceSignalStrengthImage();
		if(new DeviceSignalStrengthLeaderBoardPage().isAt()) 
			AssertJUnit.assertTrue(new DeviceSignalStrengthLeaderBoardPage().verifyUIOnDeviceSignalStrengthPage());
		softsignal2.assertAll();
	}
	
	@Test(priority = 3)
	public void Verify_Signal_Strength_For_Devices() {
		SoftAssert softsignal3 = new SoftAssert();
		AssertJUnit.assertTrue(new DeviceSignalStrengthLeaderBoardPage().verifySignalStrengthForDevices());
		softsignal3.assertAll();
	}
	
	@Test(priority = 4)
	public void Verify_Sorting_Devices_From_Strong_To_Weak() {
		SoftAssert softsignal4= new SoftAssert();
		AssertJUnit.assertTrue(new DeviceSignalStrengthLeaderBoardPage().verifySignalStrengthStrongToWeak());
		softsignal4.assertAll();
	}
	
	@Test(priority = 5)
	public void Verify_Sorting_Devices_From_Weak_To_Strong() {
		SoftAssert softsignal5= new SoftAssert();
		AssertJUnit.assertTrue(new DeviceSignalStrengthLeaderBoardPage().verifySignalStrengthWeakToStrong());
		softsignal5.assertAll();
	}
	
	@Test(priority = 6)
	public void Verify_Editing_Device_Name() {
		SoftAssert softsignal6= new SoftAssert();
//		softsignal6.assertTrue(new DeviceSignalStrengthLeaderBoardPage().clickDeviceName(2));
//		softsignal6.assertTrue(new MainDeviceAllTabPage().getEditMainDeviceNameDialogObject().editMainDeviceName());
//		softsignal6.assertTrue(new MainDeviceAllTabPage().getEditMainDeviceNameDialogObject().clickSaveButton());
		AssertJUnit.assertTrue(new DeviceSignalStrengthLeaderBoardPage().getFooterIconsPageObject().clickHomeButton());
		softsignal6.assertAll();
	}
}