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
import com.cs.arris.Pages.SpeedTestPage;
import com.cs.arris.Utilities.TestUtils;

public class TC007_Login_And_Test_Main_Device_Page extends ParentClass {
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
//		TC56_Login_And_Verify_MainDevicesPage_Workflow.getStartedPage(getStarted -> {
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
//	public void Verify_Main_Device_Page() {
//		try {
//			this.Verify_Main_Device_UI_On_All_Tab_Page();
//		}catch(Exception e) {utils.log().info("Issue in Main Device UI on All Tab");}
//		
//		try {
//			this.Verify_LED_Settings_UI_On_All_Tab();
//		}catch(Exception e) {utils.log().info("Issue in LED Settings UI on All Tab");}
//	
//		try {
//			this.Verify_Decrease_LED_Settings_On_All_Tab_Page();
//		}catch(Exception e) {utils.log().info("Issue in Decrease LED Settings UI on All Tab");}
//		
//		try {
//			this.Verify_Increase_LED_Settings_On_All_Tab_Page();
//		}catch(Exception e) {utils.log().info("Issue in Increase LED Settings UI on All Tab");}
//		
//		try {
//			this.Verify_Devices_Count_Validation_On_All_Tab_Page();
//		}catch(Exception e) {utils.log().info("Issue in Device Count Validations on All Tab");}
//		
//		try {
//			this.Verify_Connected_Devices_On_All_Tab_Page();
//		}catch(Exception e) {utils.log().info("Issue in Connected Devices on All Tab");}
//		
//		try {
//			this.Verify_Main_Router_Details_On_All_Tab_Page();
//		}catch(Exception e) {utils.log().info("Issue in Main Router Details on All Tab");}
//		
//		try {
//			this.Verify_Edit_Main_Router_Name_On_All_Tab_Page();
//		}catch(Exception e) {utils.log().info("Issue in Editing Main Router Name on All Tab");}
//		
//		try {
//			this.Verify_Edit_Connected_Device_Name_On_All_Tab_Page();
//		}catch(Exception e) {utils.log().info("Issue in Editing Connected Device Name on All Tab");}
//		
//		try {
//			this.Verify_Main_Device_UI_On_5GHz_Tab_Page();
//		}catch(Exception e) {utils.log().info("Issue in Main Device UI on 5GHz Tab");}
//		
//		try {
//			this.Verify_Devices_Count_Validation_On_5GHz_Tab_Page();
//		}catch(Exception e) {utils.log().info("Issue in Device Count Validations on 5GHz Tab");}
//		
//		try {
//			this.Verify_Connected_Devices_On_5GHz_Tab_Page();
//		}catch(Exception e) {utils.log().info("Issue in Connected Devices on 5GHz Tab");}
//		
//		try {
//			this.Verify_Main_Device_UI_On_24GHz_Tab_Page();
//		}catch(Exception e) {utils.log().info("Issue in Main Device UI on 2.4GHz Tab");}
//		
//		try {
//			this.Verify_Devices_Count_Validation_On_24GHz_Tab_Page();
//		}catch(Exception e) {utils.log().info("Issue in Device Count Validations on 2.4GHz Tab");}
//		
//		try {
//			this.Verify_Connected_Devices_On_24GHz_Tab_Page();
//		}catch(Exception e) {utils.log().info("Issue in Connected Devices on 2.4GHz Tab");}
//		
//		try {
//			this.Verify_Main_Device_UI_On_Ethernet_Tab_Page();
//		}catch(Exception e) {utils.log().info("Issue in Main Device UI on Ethernet Tab");}
//		
//		try {
//			this.Verify_Devices_Count_Validation_On_Ethernet_Tab_Page();
//		}catch(Exception e) {utils.log().info("Issue in Device Count Validations on Ethernet Tab");}
//		
//		try {
//			this.Verify_Connected_Devices_On_Ethernet_Tab_Page();
//		}catch(Exception e) {utils.log().info("Issue in Connected Devices on Ethernet Tab");}
//		
//		try {
//			this.Verify_Main_Device_Help_Page();
//		}catch(Exception e) {utils.log().info("Issue in Main Device Help Page");}
//	}
//	
//	
//	@Test(priority = 2)
//	public void Verify_Main_Device_UI_On_All_Tab_Page() {
//		SoftAssert softmain2 = new SoftAssert();
//		softmain2.assertTrue(new HomePage().clickMainDeviceImage());
//		if(new MainDeviceAllTabPage().isAt()) 
//			softmain2.assertTrue(new MainDeviceAllTabPage().verifyUIOnMainDevicePage());
//		
//		softmain2.assertAll();
//	}
//	
//	@Test(priority = 3)
//	public void Verify_LED_Settings_UI_On_All_Tab() {
//		SoftAssert softmain3 = new SoftAssert();
//		softmain3.assertTrue(new MainDeviceAllTabPage().verifyUIOnLedSettings());
//		
//		softmain3.assertAll();
//	}
//	
//	@Test(priority = 4)
//	public void Verify_Decrease_LED_Settings_On_All_Tab_Page() {
//		SoftAssert softmain4 = new SoftAssert();
//		softmain4.assertTrue(new MainDeviceAllTabPage().decreaseLedBrightnessSettings());
//		
//		softmain4.assertAll();
//	}
//	
//	@Test(priority = 5)
//	public void Verify_Increase_LED_Settings_On_All_Tab_Page() {
//		SoftAssert softmain5 = new SoftAssert();
//		softmain5.assertTrue(new MainDeviceAllTabPage().increaseLedBrightnessSettings());
//		
//		softmain5.assertAll();
//	}
//	
//	@Test(priority = 6)
//	public void Verify_Devices_Count_Validation_On_All_Tab_Page() {
//		SoftAssert softmain6 = new SoftAssert();
//		softmain6.assertTrue(new MainDeviceAllTabPage().allTabvalidations());
//		
//		softmain6.assertAll();
//	}
//	
//	@Test(priority = 7)
//	public void Verify_Connected_Devices_On_All_Tab_Page() {
//		SoftAssert softmain7 = new SoftAssert();
//		softmain7.assertTrue(new MainDeviceAllTabPage().verifyConnectedDeviceDetails());
//		
//		softmain7.assertAll();
//	}
//	
//	@Test(priority = 8)
//	public void Verify_Main_Router_Details_On_All_Tab_Page() {
//		SoftAssert softmain8 = new SoftAssert();
//		softmain8.assertTrue(new MainDeviceAllTabPage().verifyMainRouterDetails());
//		super.swipeDown();
//		softmain8.assertAll();
//	}
//	
//	@Test(priority = 9)
//	public void Verify_Edit_Main_Router_Name_On_All_Tab_Page() {
//		SoftAssert softmain9 = new SoftAssert();
////		softmain9.assertTrue(new MainDeviceAllTabPage().clickMainDeviceName());
////		if(new MainDeviceAllTabPage().getEditMainDeviceNameDialogObject().isAt())
////		{
////			softmain9.assertTrue(new MainDeviceAllTabPage().getEditMainDeviceNameDialogObject().verifyUIOnEditDeviceNameDialog());
////			softmain9.assertTrue(new MainDeviceAllTabPage().getEditMainDeviceNameDialogObject().editMainDeviceName());
////			softmain9.assertTrue(new MainDeviceAllTabPage().getEditMainDeviceNameDialogObject().clickSaveButton());
////		}
//		
//		softmain9.assertAll();
//	}
//	
//	@Test(priority = 10)
//	public void Verify_Edit_Connected_Device_Name_On_All_Tab_Page() {
//		SoftAssert softmain10 = new SoftAssert();
//		softmain10.assertTrue(new MainDeviceAllTabPage().clickDeviceName(1));
//		if(new MainDeviceAllTabPage().getEditDeviceNameDialogObject().isAt())
//		{
//			softmain10.assertTrue(new MainDeviceAllTabPage().getEditDeviceNameDialogObject().verifyUIOnEditDeviceNameDialog());
//			softmain10.assertTrue(new MainDeviceAllTabPage().getEditDeviceNameDialogObject().editDeviceName());
//			softmain10.assertTrue(new MainDeviceAllTabPage().getEditDeviceNameDialogObject().clickSaveButton());
//		}
//		
//		softmain10.assertAll();
//	}
//	
//
//	
//	@Test(priority = 11)
//	public void Verify_Main_Device_UI_On_5GHz_Tab_Page() {
//		SoftAssert softmain11 = new SoftAssert();
//		softmain11.assertTrue(new MainDeviceAllTabPage().click5GhzTab());
//		if(new MainDeviceAllTabPage().get5GHzPageObject().isAt())
//			softmain11.assertTrue(new MainDeviceAllTabPage().get5GHzPageObject().verifyUIOn5GHzDevicePage());
//		
//		softmain11.assertAll();
//	}
//	
//	@Test(priority = 12)
//	public void Verify_LED_Settings_UI_On_5GHz_Tab_Page() {
//		SoftAssert softmain12 = new SoftAssert();
//		softmain12.assertTrue(new MainDeviceAllTabPage().get5GHzPageObject().verifyUIOnLedSettings());
//		
//		softmain12.assertAll();
//	}
//	
//	@Test(priority = 13)
//	public void Verify_Decrease_LED_Settings_On_5GHz_Tab_Page() {
//		SoftAssert softmain13 = new SoftAssert();
//		softmain13.assertTrue(new MainDeviceAllTabPage().get5GHzPageObject().decreaseLedBrightnessSettings());
//		
//		softmain13.assertAll();
//	}
//	
//	@Test(priority = 14)
//	public void Verify_Increase_LED_Settings_On_5GHz_Tab_Page() {
//		SoftAssert softmain14 = new SoftAssert();
//		softmain14.assertTrue(new MainDeviceAllTabPage().get5GHzPageObject().increaseLedBrightnessSettings());
//		
//		softmain14.assertAll();
//	}
//	
//	@Test(priority = 15)
//	public void Verify_Devices_Count_Validation_On_5GHz_Tab_Page() {
//		SoftAssert softmain15 = new SoftAssert();
//		softmain15.assertTrue(new MainDeviceAllTabPage().get5GHzPageObject().GHz5Tabvalidations());
//		
//		softmain15.assertAll();
//		
//	}
//	
//	@Test(priority = 16)
//	public void Verify_Connected_Devices_On_5GHz_Tab_Page() {
//		SoftAssert softmain16 = new SoftAssert();
//		softmain16.assertTrue(new MainDeviceAllTabPage().get5GHzPageObject().verifyConnectedDeviceDetails());
//		
//		softmain16.assertAll();
//	}
//	
//	@Test(priority = 17)
//	public void Verify_Main_Router_Details_On_5GHz_Tab_Page() {
//		SoftAssert softmain17= new SoftAssert();
//		softmain17.assertTrue(new MainDeviceAllTabPage().get5GHzPageObject().verifyMainRouterDetails());
//		super.swipeDown();
//		softmain17.assertAll();
//	}
//	
//	@Test(priority = 18)
//	public void Verify_Edit_Main_Router_Name_On_5GHz_Tab_Page() {
//		SoftAssert softmain18 = new SoftAssert();
////		softmain18.assertTrue(new MainDeviceAllTabPage().clickMainDeviceName());
////		if(new MainDeviceAllTabPage().get5GHzPageObject().getEditMainDeviceNameDialogObject().isAt())
////		{
////			softmain18.assertTrue(new MainDeviceAllTabPage().get5GHzPageObject().getEditMainDeviceNameDialogObject().verifyUIOnEditDeviceNameDialog());
////			softmain18.assertTrue(new MainDeviceAllTabPage().get5GHzPageObject().getEditMainDeviceNameDialogObject().editMainDeviceName());
////			softmain18.assertTrue(new MainDeviceAllTabPage().get5GHzPageObject().getEditMainDeviceNameDialogObject().clickSaveButton());
////		}
//		softmain18.assertAll();
//	}
//	
//	@Test(priority = 19)
//	public void Verify_Edit_Connected_Device_Name_On_5GHz_Tab_Page() {
//		SoftAssert softmain19 = new SoftAssert();
//		softmain19.assertTrue(new MainDeviceAllTabPage().get5GHzPageObject().clickDeviceName(1));
//		if(new MainDeviceAllTabPage().getEditDeviceNameDialogObject().isAt())
//		{
//			softmain19.assertTrue(new MainDeviceAllTabPage().get5GHzPageObject().getEditDeviceNameDialogObject().verifyUIOnEditDeviceNameDialog());
//			softmain19.assertTrue(new MainDeviceAllTabPage().get5GHzPageObject().getEditDeviceNameDialogObject().editDeviceName());
//			softmain19.assertTrue(new MainDeviceAllTabPage().get5GHzPageObject().getEditDeviceNameDialogObject().clickSaveButton());
//		}
//		softmain19.assertAll();
//	}
//	
//	
//	@Test(priority = 20)
//	public void Verify_Main_Device_UI_On_24GHz_Tab_Page() {
//		SoftAssert softmain20 = new SoftAssert();
//		softmain20.assertTrue(new MainDeviceAllTabPage().click24GhzTab());
//		if(new MainDeviceAllTabPage().get24GHzPageObject().isAt())
//			softmain20.assertTrue(new MainDeviceAllTabPage().get24GHzPageObject().verifyUIOn24GHzDevicePage());
//		
//		softmain20.assertAll();
//	}
//	
//	@Test(priority = 21)
//	public void Verify_LED_Settings_UI_On_24GHz_Tab_Page() {
//		SoftAssert softmain21 = new SoftAssert();
//		softmain21.assertTrue(new MainDeviceAllTabPage().get24GHzPageObject().verifyUIOnLedSettings());
//		
//		softmain21.assertAll();
//	}
//	
//	@Test(priority = 22)
//	public void Verify_Decrease_LED_Settings_On_24GHz_Tab_Page() {
//		SoftAssert softmain22 = new SoftAssert();
//		softmain22.assertTrue(new MainDeviceAllTabPage().get24GHzPageObject().decreaseLedBrightnessSettings());
//		
//		softmain22.assertAll();
//	}
//	
//	@Test(priority = 23)
//	public void Verify_Increase_LED_Settings_On_24GHz_Tab_Page() {
//		SoftAssert softmain23 = new SoftAssert();
//		softmain23.assertTrue(new MainDeviceAllTabPage().get24GHzPageObject().increaseLedBrightnessSettings());
//		
//		softmain23.assertAll();
//	}
//	
//	@Test(priority = 24)
//	public void Verify_Devices_Count_Validation_On_24GHz_Tab_Page() {
//		SoftAssert softmain24 = new SoftAssert();
//		softmain24.assertTrue(new MainDeviceAllTabPage().get24GHzPageObject().GHz24Tabvalidations());
//		softmain24.assertAll();
//	}
//	
//	@Test(priority = 25)
//	public void Verify_Connected_Devices_On_24GHz_Tab_Page() {
//		SoftAssert softmain25 = new SoftAssert();
//		softmain25.assertTrue(new MainDeviceAllTabPage().get24GHzPageObject().verifyConnectedDeviceDetails());
//		
//		softmain25.assertAll();
//	}
//	
//	@Test(priority = 26)
//	public void Verify_Main_Router_Details_On_24GHz_Tab_Page() {
//		SoftAssert softmain26 = new SoftAssert();
//		softmain26.assertTrue(new MainDeviceAllTabPage().get24GHzPageObject().verifyMainRouterDetails());
//		super.swipeDown();
//		softmain26.assertAll();
//	}
//	
//	@Test(priority = 27)
//	public void Verify_Edit_Main_Router_Name_On_24GHz_Tab_Page() {
//		SoftAssert softmain27 = new SoftAssert();
////		softmain27.assertTrue(new MainDeviceAllTabPage().clickMainDeviceName());
////		if(new MainDeviceAllTabPage().get24GHzPageObject().getEditMainDeviceNameDialogObject().isAt())
////		{
////			softmain27.assertTrue(new MainDeviceAllTabPage().get24GHzPageObject().getEditMainDeviceNameDialogObject().verifyUIOnEditDeviceNameDialog());
////			softmain27.assertTrue(new MainDeviceAllTabPage().get24GHzPageObject().getEditMainDeviceNameDialogObject().editMainDeviceName());
////			softmain27.assertTrue(new MainDeviceAllTabPage().get24GHzPageObject().getEditMainDeviceNameDialogObject().clickSaveButton());
////		}
//		
//		softmain27.assertAll();
//	}
//	
//	@Test(priority = 28)
//	public void Verify_Edit_Connected_Device_Name_On_24GHz_Tab_Page() {
//		SoftAssert softmain28 = new SoftAssert();
//		softmain28.assertTrue(new MainDeviceAllTabPage().get24GHzPageObject().clickDeviceName(1));
//		if(new MainDeviceAllTabPage().getEditDeviceNameDialogObject().isAt())
//		{
//			softmain28.assertTrue(new MainDeviceAllTabPage().get24GHzPageObject().getEditDeviceNameDialogObject().verifyUIOnEditDeviceNameDialog());
//			softmain28.assertTrue(new MainDeviceAllTabPage().get24GHzPageObject().getEditDeviceNameDialogObject().editDeviceName());
//			softmain28.assertTrue(new MainDeviceAllTabPage().get24GHzPageObject().getEditDeviceNameDialogObject().clickSaveButton());
//		}
//		
//		softmain28.assertAll();
//	}
//	
//	@Test(priority = 29)
//	public void Verify_Main_Device_UI_On_Ethernet_Tab_Page() {
//		SoftAssert softmain29 = new SoftAssert();
//		softmain29.assertTrue(new MainDeviceAllTabPage().clickEthernetTab());
//		if(new MainDeviceAllTabPage().getEthernetPageObject().isAt())
//			softmain29.assertTrue(new MainDeviceAllTabPage().getEthernetPageObject().verifyUIOnEthernetDevicePage());
//		
//		softmain29.assertAll();
//	}
//	
//	@Test(priority = 30)
//	public void Verify_LED_Settings_UI_On_Ethernet_Tab_Page() {
//		SoftAssert softmain30 = new SoftAssert();
//		softmain30.assertTrue(new MainDeviceAllTabPage().getEthernetPageObject().verifyUIOnLedSettings());
//		
//		softmain30.assertAll();
//	}
//	
//	@Test(priority = 31)
//	public void Verify_Decrease_LED_Settings_On_Ethernet_Tab_Page() {
//		SoftAssert softmain31 = new SoftAssert();
//		softmain31.assertTrue(new MainDeviceAllTabPage().getEthernetPageObject().decreaseLedBrightnessSettings());
//		
//		softmain31.assertAll();
//	}
//	
//	@Test(priority = 32)
//	public void Verify_Increase_LED_Settings_On_Ethernet_Tab_Page() {
//		SoftAssert softmain32 = new SoftAssert();
//		softmain32.assertTrue(new MainDeviceAllTabPage().getEthernetPageObject().increaseLedBrightnessSettings());
//		softmain32.assertAll();
//	}
//	
//	@Test(priority = 33)
//	public void Verify_Devices_Count_Validation_On_Ethernet_Tab_Page() {
//		SoftAssert softmain33 = new SoftAssert();
//		softmain33.assertTrue(new MainDeviceAllTabPage().getEthernetPageObject().ethernetTabvalidations());
//		
//		softmain33.assertAll();
//	}
//	
//	@Test(priority = 34)
//	public void Verify_Connected_Devices_On_Ethernet_Tab_Page() {
//		SoftAssert softmain34 = new SoftAssert();
//		softmain34.assertTrue(new MainDeviceAllTabPage().getEthernetPageObject().verifyConnectedDeviceDetails());
//		
//		softmain34.assertAll();
//	}
//	
//	@Test(priority = 35)
//	public void Verify_Main_Router_Details_On_Ethernet_Tab_Page() {
//		SoftAssert softmain35 = new SoftAssert();
//		softmain35.assertTrue(new MainDeviceAllTabPage().getEthernetPageObject().verifyMainRouterDetails());
//		super.swipeDown();
//		softmain35.assertAll();
//	}
//	
//	@Test(priority = 36)
//	public void Verify_Edit_Main_Router_Name_On_Ethernet_Tab_Page() {
//		SoftAssert softmain36 = new SoftAssert();
////		softmain36.assertTrue(new MainDeviceAllTabPage().clickMainDeviceName());
////		if(new MainDeviceAllTabPage().getEthernetPageObject().getEditMainDeviceNameDialogObject().isAt())
////		{
////			softmain36.assertTrue(new MainDeviceAllTabPage().getEthernetPageObject().getEditMainDeviceNameDialogObject().verifyUIOnEditDeviceNameDialog());
////			softmain36.assertTrue(new MainDeviceAllTabPage().getEthernetPageObject().getEditMainDeviceNameDialogObject().editMainDeviceName());
////			softmain36.assertTrue(new MainDeviceAllTabPage().getEthernetPageObject().getEditMainDeviceNameDialogObject().clickSaveButton());
////		}
//		
//		softmain36.assertAll();
//	}
//	
//	@Test(priority = 37)
//	public void Verify_Edit_Connected_Device_Name_On_Ethernet_Tab_Page() {
//		SoftAssert softmain37 = new SoftAssert();
//		softmain37.assertTrue(new MainDeviceAllTabPage().getEthernetPageObject().clickDeviceName(1));
//		if(new MainDeviceAllTabPage().getEditDeviceNameDialogObject().isAt())
//		{
//			softmain37.assertTrue(new MainDeviceAllTabPage().getEthernetPageObject().getEditDeviceNameDialogObject().verifyUIOnEditDeviceNameDialog());
//			softmain37.assertTrue(new MainDeviceAllTabPage().getEthernetPageObject().getEditDeviceNameDialogObject().editDeviceName());
//			softmain37.assertTrue(new MainDeviceAllTabPage().getEthernetPageObject().getEditDeviceNameDialogObject().clickSaveButton());
//		}
//		
//		softmain37.assertAll();
//	}
//
//	@Test(priority = 38)
//	public void Verify_Main_Device_Help_Page() {
//		SoftAssert softmain38 = new SoftAssert();
//		softmain38.assertTrue(new MainDeviceAllTabPage().getEthernetPageObject().clickHelpButton());
//		if(new MainDeviceAllTabPage().getMainRouterDetailsHelpPageObject().isAt())
//			new MainDeviceAllTabPage().getMainRouterDetailsHelpPageObject().clickCloseButton();
//		new MainDeviceAllTabPage().getEthernetPageObject().clickBackButton();
//		
//		softmain38.assertAll();
//	}
}