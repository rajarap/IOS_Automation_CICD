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
import com.cs.arris.Pages.NetworkPage;
import com.cs.arris.Pages.SiginPage;
import com.cs.arris.Utilities.Direction;
import com.cs.arris.Utilities.SwipeActions;
import com.cs.arris.Utilities.TestUtils;

import com.cs.arris.Workflows.TC52_Login_And_Verify_HomePage_Workflow;
import com.cs.arris.Workflows.TC53_Login_And_Verify_DevicesPage_Workflow;
import com.cs.arris.Workflows.TC56_Login_And_Verify_MainDevicesPage_Workflow;


import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class TC011_Login_And_Test_Network_Page extends ParentClass {
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
//		SoftAssert softnet1 = new SoftAssert();
//		TC57_Login_And_Verify_NetworkPage_Workflow.getStartedPage(getStarted -> {
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
//		}).homePage(home -> {
//			try {
//				if (home.okButton.isDisplayed()) {
//					home.clickOkButton();
//				}
//			} catch (Exception e) {
//				e.getMessage();
//			}
//			if (home.isAt()) {
//				home.getFooterIconsPageObject().clickNetworkButton();
//			}
//		}).networkPage(network -> {
//			network.isAt();
//		});
//	}
	
	@Test(priority = 1)
	public void Verify_Network_Page() {
		try {
			this.Verify_Newtork_UI_Page();
		}catch(Exception e) {utils.log().info("Issue in Network UI Page");}
		
		try {
			this.Verify_Newtork_Help_Page();
		}catch(Exception e) {utils.log().info("Issue in Network Help Page");}
		
		try {
			this.Verify_Newtork_Test_Connection_Speed_Page();
		}catch(Exception e) {utils.log().info("Issue in Test Connection Speed Page");}
		
		try {
			this.Verify_WAN_Settings_UI_Page();
		}catch(Exception e) {utils.log().info("Issue in WAN Setting UI Page");}
		
		try {
			this.Verify_WAN_Settings_Help_Page();
		}catch(Exception e) {utils.log().info("Issue in WAN Settings Help Page");}
		
		try {
			this.Verify_WAN_Settings_WAN_IP_Configuration_IPv4_DHCP_UI_Page();
		}catch(Exception e) {utils.log().info("Issue in WAN IP Configuration IPv4 DHCP UI Page");}
		
		try {
			this.Verify_WAN_Settings_WAN_IP_Configuration_IPv4_Static_UI_Page();
		}catch(Exception e) {utils.log().info("Issue in WAN IP Configuration IPv4 Statoc UI Page");}
		
		try {
			this.Verify_WAN_Settings_WAN_IP_Configuration_IPv6_Stateful_UI_Page();
		}catch(Exception e) {utils.log().info("Issue in WAN IP Configuration IPv6 Stateful UI Page");}
		
		try {
			this.Verify_WAN_Settings_WAN_IP_Configuration_IPv6_Stateless_UI_Page();
		}catch(Exception e) {utils.log().info("Issue in WAN IP Configuration IPv4 Stateless UI Page");}
		
		try {
			this.Verify_WAN_Settings_WAN_IP_Configuration_Help_Page();
		}catch(Exception e) {utils.log().info("Issue in WAN IP Configuration Help Page");}
		
		try {
			this.Verify_WAN_Settings_DNS_Configuration_IPv4_Automatic_UI_Page();
		}catch(Exception e) {utils.log().info("Issue in WAN Settings DNS Configuration IPv4 Automatic UI Page");}
		
		try {
			this.Verify_WAN_Settings_DNS_Configuration_IPv4_Static_UI_Page();
		}catch(Exception e) {utils.log().info("Issue in WAN Settings DNS Configuration IPv4 Static UI Page");}
		
		try {
			this.Verify_WAN_Settings_DNS_Configuration_IPv6_Automatic_UI_Page();
		}catch(Exception e) {utils.log().info("Issue in WAN Settings DNS Configuration IPv6 Automatic UI Page");}
		
		try {
			this.Verify_WAN_Settings_DNS_Configuration_IPv6_Static_UI_Page();
		}catch(Exception e) {utils.log().info("Issue in WAN Settings DNS Configuration IPv4 Static UI Page");}
		
		try {
			this.Verify_WAN_Settings_DNS_Configuration_Help_Page();
		}catch(Exception e) {utils.log().info("Issue in WAN Settings DNS Configuration Help Page");}
		
		try {
			this.Verify_WAN_Settings_LAC_Alert_Dialog();
		}catch(Exception e) {utils.log().info("Issue in WAN Settings LAC ALert Dialog");}
	
		try {
			this.Verify_LAN_Settings_UI_Page();
		}catch(Exception e) {utils.log().info("Issue in LAN Settings UI Page");}
		
		try {
			this.Verify_LAN_Settings_LAN_IP_Reservation_Page();
		}catch(Exception e) {utils.log().info("Issue in LAN IP Reservation Page");}
		
		try {
			this.Verify_LAN_Settings_LAN_IP_Reservation_Add_Reservation_Page();
		}catch(Exception e) {utils.log().info("Issue in LAN IP Reservation Add Reservation Page");}
		
		try {
			this.Verify_LAN_Settings_LAN_IP_Reservation_Rules();
		}catch(Exception e) {utils.log().info("Issue in LAN IP Reservation Rules Page");}
		
		try {
			this.Verify_LAN_Settings_LAN_IP_Reservation_Edit_Devices_Page();
		}catch(Exception e) {utils.log().info("Issue in LAN IP Reservation Page Edit Devices Page");}
		
		try {
			this.Verify_LAN_Settings_LAN_IP_Reservation_Help_Page();
		}catch(Exception e) {utils.log().info("Issue in LAN IP Reservation Help Page");}
		
		try {
			this.Verify_LAN_Settings_LAN_Subnet_DHCP_Range_Configuration_Page();
		}catch(Exception e) {utils.log().info("Issue in LAN Subnet DHCP Range Configuration Page");}
		
		try {
			this.Verify_Edit_LAN_Subnet_DHCP_Range_Configuration_Page();
		}catch(Exception e) {utils.log().info("Issue in Edit LAN Subnet DHCP Range Configuration Page");}
		
		try {
			this.Edit_LAN_Subnet_Configuration_Octets();
		}catch(Exception e) {utils.log().info("Issue in LAN Subnet Configuration Octets");}
		
		try {
			this.Verify_LAN_Settings_LAN_Subnet_DHCP_Range_Configuration_Help_Page();
		}catch(Exception e) {utils.log().info("Issue in LAN Subnet DHCP Range Configuration Help Page");}
		
		try {
			this.Verify_LAN_Settings_LAN_DHCP_Lease_Time_UI_Page();
		}catch(Exception e) {utils.log().info("Issue in LAN DHCP Lease Time UI Page");}
		
		try {
			this.Verify_LAN_Settings_LAN_DHCP_Set_Lease_Time_Page();
		}catch(Exception e) {utils.log().info("Issue in LAN DHCP Lease Time Page");}
		
		try {
			this.Verify_LAN_Settings_LAN_DHCP_Set_Lease_Time_Help_Page();
		}catch(Exception e) {utils.log().info("Issue in LAN DHCP Lease Time Help Page");}
		
		
//		try {
//			this.Verify_Device_Priority_Settings_UI_Page();
//		}catch(Exception e) {utils.log().info("Issue in Device Priority Settings UI Page");}
//		
//		try {
//			this.Verify_Device_Priority_Settings_Add_Device_UI_Page();
//		}catch(Exception e) {utils.log().info("Issue in Device Priority Settings Add Device UI Page");}
//		
//		try {
//			this.Verify_Device_Priority_Settings_Add_Device_Page();
//		}catch(Exception e) {utils.log().info("Issue in Device Priority Settings Add Devices Page");}
//		
//		try {
//			this.Verify_Device_Priority_Settings_Added_Device_Page();
//		}catch(Exception e) {utils.log().info("Issue in Device Priority Settings Added Devices Page");}
//		
//		try {
//			this.Verify_Device_Priority_Settings_Add_Device_Help_Page();
//		}catch(Exception e) {utils.log().info("Issue in Device Priority Settings Add Device Help Page");}
//		
//		try {
//			this.Verify_Device_Priority_Settings_Help_Page();
//		}catch(Exception e) {utils.log().info("Issue in Device Priority Settings Help Page");}
		
//		try {
//			this.Verify_Time_Zone_Settings_UI_Page();
//		}catch(Exception e) {utils.log().info("Issue in Time Zone Settings UI Page");}
//		
//		try {
//			this.Verify_Time_Zone_Settings_Help_Page();
//		}catch(Exception e) {utils.log().info("Issue in Time Zone Settings Help Page");}
//		
//		try {
//			this.Verify_General_Settings_UI_Page();
//		}catch(Exception e) {utils.log().info("Issue in General Settings UI Page");}
//		
//		try {
//			this.Verify_General_Settings_UPnP_Settings();
//		}catch(Exception e) {utils.log().info("Issue in General Settings UPnP Page");}
//		
//		try {
//			this.Verify_General_Settings_IPv6_Enable_Settings() ;
//		}catch(Exception e) {utils.log().info("Issue in General Settings IPv6 Enable Settings Page");}
//		
//		try {
//			this.Verify_General_Settings_Bridge_Mode_Settings();
//		}catch(Exception e) {utils.log().info("Issue in General Settings Bridge Mode Page");}
//	
//		try {
//			this.Verify_General_Settings_Port_Forwarding_Settings();
//		}catch(Exception e) {utils.log().info("Issue in General Settings Port Forwaring Settings Page");}
//		
//		try {
//			this.Verify_General_Settings_Port_Forwarding_Add_Rule_Settings_Page();
//		}catch(Exception e) {utils.log().info("Issue in General Settings Port Forwarding Add Rule Settings Page");}
//		
//		try {
//			this.Verify_General_Settings_Port_Forwarding_Add_Rules();
//		}catch(Exception e) {utils.log().info("Issue in General Settings Port Forwarding Add Rules Page");}
//		
//		try {
//			this.Verify_General_Settings_Port_Forwarding_Edit_Rules();
//		}catch(Exception e) {utils.log().info("Issue in General Settings Port Forwardind Edit Rules Page");}
//		
//		try {
//			this.Verify_General_Settings_Port_Forwarding_Add_Rule_Settings_Validations();
//		}catch(Exception e) {utils.log().info("Issue in General Settings Add Rule Settings Validations Page");}
//		
//		try {
//			this.Verify_General_Settings_Port_Forwarding_Help_Page();
//		}catch(Exception e) {utils.log().info("Issue in General Settings Port Forwarding Help Page");}
		
//		try {
//			this.Verify_Guest_WiFi_Network_Page();
//		}catch(Exception e) {utils.log().info("Issue in Guest WiFi Newtork Page");}
//		
//		try {
//			this.Verify_Extended_WiFi_Settings_Page();
//		}catch(Exception e) {utils.log().info("Issue in Extended WiFi Settings Page");}
	}

	@Test(priority = 2)
	public void Verify_Newtork_UI_Page() {
		SoftAssert softnet2 = new SoftAssert();
		AssertJUnit.assertTrue(new HomePage().getFooterIconsPageObject().clickNetworkButton());
		AssertJUnit.assertTrue(new NetworkPage().verifyUIOnNetworkPage());
		softnet2.assertAll();
	}

	@Test(priority = 3)
	public void Verify_Newtork_Help_Page() {
		SoftAssert softnet3 = new SoftAssert();
		AssertJUnit.assertTrue(new NetworkPage().clickHelpButton());
		AssertJUnit.assertTrue(new NetworkPage().getNetworkHelpPageObject().clickCloseButton());
		softnet3.assertAll();
	}

	@Test(priority = 4)
	public void Verify_Newtork_Test_Connection_Speed_Page() {
		SoftAssert softnet4 = new SoftAssert();
		AssertJUnit.assertTrue(new NetworkPage().clickTestConnectionSpeedButton());
		AssertJUnit.assertTrue(new NetworkPage().getSpeedTestPageObject().performSpeedTest());
		AssertJUnit.assertTrue(new NetworkPage().getSpeedTestPageObject().clickBackButton());
		softnet4.assertAll();
	}

	@Test(priority = 5)
	public void Verify_WAN_Settings_UI_Page() {
		SoftAssert softnet5 = new SoftAssert();
		AssertJUnit.assertTrue(new NetworkPage().clickNetworkSettingsExpandButton());
		super.swipeUp();
		AssertJUnit.assertTrue(new NetworkPage().clickWANSettings());
		try {
			if (new NetworkPage().getAppRatingPageObject().isAt()) {
				AssertJUnit.assertTrue(new NetworkPage().getAppRatingPageObject().clickRemindMeLaterLink());
			}
		}catch(Exception e) {utils.log().info("App Rating Dialog did not appear");}
			AssertJUnit.assertTrue(new NetworkPage().getWANSettingsPageObject().verifyUIOnWANSettingsPage());

			softnet5.assertAll();
	}

	@Test(priority = 6)
	public void Verify_WAN_Settings_Help_Page() {
		SoftAssert softnet6 = new SoftAssert();
		AssertJUnit.assertTrue(new NetworkPage().getWANSettingsPageObject().clickHelpButton());
		if (new NetworkPage().getWANSettingsPageObject().getNetworkWanSettingsHelpPageObject().isAt())
			AssertJUnit.assertTrue(new NetworkPage().getWANSettingsPageObject().getNetworkWanSettingsHelpPageObject().clickCloseButton());
		softnet6.assertAll();
	}

	@Test(priority = 7)
	public void Verify_WAN_Settings_WAN_IP_Configuration_IPv4_DHCP_UI_Page() {
		SoftAssert softnet7 = new SoftAssert();
		new NetworkPage().getWANSettingsPageObject().clickWANIPConfigurationLink();
		if (new NetworkPage().getWANSettingsPageObject().getWANIPv4ConfigurationPageObject().isAt())
			AssertJUnit.assertTrue(new NetworkPage().getWANSettingsPageObject().getWANIPv4ConfigurationPageObject().verifyUIOnWANIPv4DHCP());
		softnet7.assertAll();
	}

	@Test(priority = 8)
	public void Verify_WAN_Settings_WAN_IP_Configuration_IPv4_Static_UI_Page() {
		SoftAssert softnet8 = new SoftAssert();
		AssertJUnit.assertTrue(new NetworkPage().getWANSettingsPageObject().getWANIPv4ConfigurationPageObject().verifyUIOnWANIPv4Static());
		softnet8.assertAll();
	}

	@Test(priority = 9)
	public void Verify_WAN_Settings_WAN_IP_Configuration_IPv6_Stateful_UI_Page() {
		SoftAssert softnet9 = new SoftAssert();
		AssertJUnit.assertTrue(new NetworkPage().getWANSettingsPageObject().getWANIPv4ConfigurationPageObject().clickWANIPv6Tab());
		if (new NetworkPage().getWANSettingsPageObject().getWANIPv6ConfigurationPageObject().isAt())
			AssertJUnit.assertTrue(new NetworkPage().getWANSettingsPageObject().getWANIPv6ConfigurationPageObject().verifyUIOnWANIPv6Stateful());
		softnet9.assertAll();
	}

	@Test(priority = 10)
	public void Verify_WAN_Settings_WAN_IP_Configuration_IPv6_Stateless_UI_Page() {
		SoftAssert softnet10 = new SoftAssert();
		AssertJUnit.assertTrue(new NetworkPage().getWANSettingsPageObject().getWANIPv6ConfigurationPageObject().verifyUIOnWANIPv6Stateless());
		softnet10.assertAll();
	}

	@Test(priority = 11)
	public void Verify_WAN_Settings_WAN_IP_Configuration_Help_Page() {
		SoftAssert softnet11 = new SoftAssert();
		new NetworkPage().getWANSettingsPageObject().getWANIPv6ConfigurationPageObject().clickHelpButton();
		if (new NetworkPage().getWANSettingsPageObject().getWANIPv6ConfigurationPageObject().getNetworkWANIPConfigurationHelpPageObject().isAt()) {
			AssertJUnit.assertTrue(new NetworkPage().getWANSettingsPageObject().getWANIPv6ConfigurationPageObject().getNetworkWANIPConfigurationHelpPageObject().clickCloseButton());
			AssertJUnit.assertTrue(new NetworkPage().getWANSettingsPageObject().getWANIPv6ConfigurationPageObject().clickBackButton());
		}
		softnet11.assertAll();
	}
	
	@Test(priority = 12)
	public void Verify_WAN_Settings_DNS_Configuration_IPv4_Automatic_UI_Page() 
	{
		SoftAssert softnet12 = new SoftAssert();
		AssertJUnit.assertTrue(new NetworkPage().getWANSettingsPageObject().clickDNSConfigurationLink());
		if (new NetworkPage().getWANSettingsPageObject().getWANDNSIPv4ConfigurationPageObject().isAt()) 
			AssertJUnit.assertTrue(new NetworkPage().getWANSettingsPageObject().getWANDNSIPv4ConfigurationPageObject().verifyUIOnDNSIPv4Automatic());
		softnet12.assertAll();
	}
	
	@Test(priority = 13)
	public void Verify_WAN_Settings_DNS_Configuration_IPv4_Static_UI_Page() 
	{
		SoftAssert softnet13 = new SoftAssert();
		AssertJUnit.assertTrue(new NetworkPage().getWANSettingsPageObject().getWANDNSIPv4ConfigurationPageObject().verifyUIOnDNSIPv4Static());
		softnet13.assertAll();
	}
	
	@Test(priority = 14)
	public void Verify_WAN_Settings_DNS_Configuration_IPv6_Automatic_UI_Page() 
	{
		SoftAssert softnet14 = new SoftAssert();
		AssertJUnit.assertTrue(new NetworkPage().getWANSettingsPageObject().getWANDNSIPv4ConfigurationPageObject().clickDNSIPv6Tab());
		if (new NetworkPage().getWANSettingsPageObject().getWANDNSIPv6ConfigurationPageObject().isAt()) 
			AssertJUnit.assertTrue(new NetworkPage().getWANSettingsPageObject().getWANDNSIPv6ConfigurationPageObject().verifyUIOnDNSIPv6Automatic());
		softnet14.assertAll();
	}
	
	@Test(priority = 15)
	public void Verify_WAN_Settings_DNS_Configuration_IPv6_Static_UI_Page() 
	{
		SoftAssert softnet15 = new SoftAssert();
		AssertJUnit.assertTrue(new NetworkPage().getWANSettingsPageObject().getWANDNSIPv6ConfigurationPageObject().verifyUIOnDNSIPv6Static());
		softnet15.assertAll();
	}
	
	@Test(priority = 16)
	public void Verify_WAN_Settings_DNS_Configuration_Help_Page() 
	{
		SoftAssert softnet16 = new SoftAssert();
		AssertJUnit.assertTrue(new NetworkPage().getWANSettingsPageObject().getWANIPv6ConfigurationPageObject().clickHelpButton());
		if (new NetworkPage().getWANSettingsPageObject().getWANIPv6ConfigurationPageObject().getNetworkWANIPConfigurationHelpPageObject().isAt())
			AssertJUnit.assertTrue(new NetworkPage().getWANSettingsPageObject().getWANIPv6ConfigurationPageObject().getNetworkWANIPConfigurationHelpPageObject().clickCloseButton());
			AssertJUnit.assertTrue(new NetworkPage().getWANSettingsPageObject().getWANIPv6ConfigurationPageObject().clickBackButton());
			try{
				if(new NetworkPage().getAppRatingPageObject().isAt())
					new NetworkPage().getAppRatingPageObject().clickRemindMeLaterLink();
			}catch(Exception e) {
				utils.log().info("App Rating Dialog did not appear");
			}
			softnet16.assertAll();
	}
	
	@Test(priority = 17)
	public void Verify_WAN_Settings_LAC_Alert_Dialog() 
	{
		SoftAssert softnet17 = new SoftAssert();
		if (new NetworkPage().getWANSettingsPageObject().isAt()) 
			AssertJUnit.assertTrue(new NetworkPage().getWANSettingsPageObject().clickLacInfoIcon());
			if(new NetworkPage().getWANSettingsPageObject().getLACAlertDialogObject().isAt())
				AssertJUnit.assertTrue(new NetworkPage().getWANSettingsPageObject().getLACAlertDialogObject().clickCloseDialog());
				AssertJUnit.assertTrue(new NetworkPage().getWANSettingsPageObject().clickBackButton());
		softnet17.assertAll();
	}
	
	@Test(priority = 18)
	public void Verify_LAN_Settings_UI_Page() 
	{
		SoftAssert softnet18 = new SoftAssert();
		if (new NetworkPage().isAt()) {
			AssertJUnit.assertTrue(new NetworkPage().clickLANSettings());
			try{
				if(new NetworkPage().getAppRatingPageObject().isAt())
					new NetworkPage().getAppRatingPageObject().clickRemindMeLaterLink();
			}catch(Exception e) {
				utils.log().info("App Rating Dialog did not appear");
			}
			AssertJUnit.assertTrue(new NetworkPage().getLANSettingsPageObject().verifyUIOnLANSettingsPage());
		}
		softnet18.assertAll();
	}
	
	@Test(priority = 19)
	public void Verify_LAN_Settings_LAN_IP_Reservation_Page() 
	{
		SoftAssert softnet19 = new SoftAssert();
		AssertJUnit.assertTrue(new NetworkPage().getLANSettingsPageObject().clickLANIPResevationLink());
		if(new NetworkPage().getLANSettingsPageObject().getNetworkLANIPReservationPageObject().isAt())
			AssertJUnit.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANIPReservationPageObject().verifyUIOnNetworkLANIPReservationPage());
		softnet19.assertAll();
	}
	
	@Test(priority = 20)
	public void Verify_LAN_Settings_LAN_IP_Reservation_Add_Reservation_Page() 
	{
		SoftAssert softnet20 = new SoftAssert();
		new NetworkPage().getLANSettingsPageObject().getNetworkLANIPReservationPageObject().clickAddReservationButton();
		if(new NetworkPage().getLANSettingsPageObject().getNetworkLANIPReservationPageObject().getLANIPReservationDialogObject().isAt())
		{
			AssertJUnit.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANIPReservationPageObject().getLANIPReservationDialogObject().verifyUIOnReserveLANIP());
			AssertJUnit.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANIPReservationPageObject().getLANIPReservationDialogObject().enterRuleName());
			AssertJUnit.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANIPReservationPageObject().getLANIPReservationDialogObject().enterIPAddress());
			AssertJUnit.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANIPReservationPageObject().getLANIPReservationDialogObject().selectADevice(1));
			AssertJUnit.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANIPReservationPageObject().getLANIPReservationDialogObject().clickSaveButton());
			softnet20.assertAll();
		}
	}
	
	@Test(priority = 21)
	public void Verify_LAN_Settings_LAN_IP_Reservation_Rules() 
	{
		SoftAssert softnet21 = new SoftAssert();
		AssertJUnit.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANIPReservationPageObject().verifyRulesOnLAPIPReservationPage());
		softnet21.assertAll();
	}
	
	@Test(priority = 22)
	public void Verify_LAN_Settings_LAN_IP_Reservation_Edit_Devices_Page() 
	{
		SoftAssert softnet22 = new SoftAssert();
		AssertJUnit.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANIPReservationPageObject().clickEditLAPIPReservation());
		if(new NetworkPage().getLANSettingsPageObject().getNetworkLANIPReservationPageObject().getEditLANIPReservationDialogObject().isAt())
		{
			AssertJUnit.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANIPReservationPageObject().getEditLANIPReservationDialogObject().verifyUIOnEditReserveLANIP());
			AssertJUnit.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANIPReservationPageObject().getEditLANIPReservationDialogObject().editRuleName());
			AssertJUnit.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANIPReservationPageObject().getEditLANIPReservationDialogObject().editIPAddress());
			AssertJUnit.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANIPReservationPageObject().getEditLANIPReservationDialogObject().clickSaveButton());
		}
		softnet22.assertAll();

	}

	@Test(priority = 23)
	public void Verify_LAN_Settings_LAN_IP_Reservation_Help_Page() {
		SoftAssert softnet23 = new SoftAssert();
		AssertJUnit.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANIPReservationPageObject().clickHelpButton());
		if (new NetworkPage().getLANSettingsPageObject().getNetworkLANIPReservationPageObject().getLanIPReservationHelpPageObject().isAt()) {
			AssertJUnit.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANIPReservationPageObject().getLanIPReservationHelpPageObject().clickCloseButton());
			AssertJUnit.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANIPReservationPageObject().clickBackButton());
		}
		softnet23.assertAll();
	}
	
	@Test(priority = 24)
	public void Verify_LAN_Settings_LAN_Subnet_DHCP_Range_Configuration_Page() 
	{
		SoftAssert softnet24 = new SoftAssert();
		AssertJUnit.assertTrue(new NetworkPage().getLANSettingsPageObject().clickLANSubnetLink());
		if(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().isAt()) {
			AssertJUnit.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().verifyUIOnLANSubnetConfigurationPage());
			AssertJUnit.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().verifyDHCPIPAddressRangeForSelectedSubnet());
		}
		softnet24.assertAll();
	}
	
	@Test(priority = 25)
	public void Verify_Edit_LAN_Subnet_DHCP_Range_Configuration_Page() 
	{
		SoftAssert softnet25 = new SoftAssert();
		
		AssertJUnit.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().EditDHCPIPAddressRangeForFirstSubnet());
		AssertJUnit.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().clickSaveButton());
		if(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().getLANDHCPChangeRangeIPDialogObject().isAt())
			AssertJUnit.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().getLANDHCPChangeRangeIPDialogObject().clickCloseButton());
		
		AssertJUnit.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().EditDHCPIPAddressRangeForSecondSubnet());
		AssertJUnit.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().clickSaveButton());
		if(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().getLANDHCPChangeRangeIPDialogObject().isAt())
			AssertJUnit.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().getLANDHCPChangeRangeIPDialogObject().clickCloseButton());
		
		AssertJUnit.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().EditDHCPIPAddressRangeForThirdSubnet());
		AssertJUnit.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().clickSaveButton());
		if(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().getLANDHCPChangeRangeIPDialogObject().isAt())
			AssertJUnit.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().getLANDHCPChangeRangeIPDialogObject().clickCloseButton());
		
		AssertJUnit.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().verifyLANDHCPRangeBetween1And255());
		AssertJUnit.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().clickSaveButton());
		if(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().getLANDHCPBetween1And255DialogObject().isAt())
			AssertJUnit.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().getLANDHCPBetween1And255DialogObject().clickCloseButton());
		
		AssertJUnit.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().verifyLANDHCPRangeWithEmptySuffix());
		AssertJUnit.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().clickSaveButton());
		if(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().getLANDHCPBetween1And255DialogObject().isAt())
			AssertJUnit.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().getLANDHCPBetween1And255DialogObject().clickCloseButton());
		
		AssertJUnit.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().clickResetToDefaultButton());
		if(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().getLANDHCPChangeRangeIPDialogObject().isAt())
			AssertJUnit.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().getLANDHCPChangeRangeIPDialogObject().clickCloseButton());

		softnet25.assertAll();
	}
	
	@Test(priority = 26)
	public void Edit_LAN_Subnet_Configuration_Octets() 
	{
		SoftAssert softnet26 = new SoftAssert();
		
		AssertJUnit.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().verifyFirstLANSubnetConfigurationWithInvalidOctet());
		AssertJUnit.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().clickSaveButton());
		utils.log().info("Validation Message : " + new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().enterValidIPAddressText1.getText() + " is displayed");
		
		AssertJUnit.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().verifySecondLANSubnetConfigurationWithInvalidOctet());
		AssertJUnit.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().clickSaveButton());
		utils.log().info("Validation Message : " + new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().enterValidIPAddressText2.getText() + " is displayed");

		AssertJUnit.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().verifyThirdLANSubnetConfigurationWithInvalidOctet());
		AssertJUnit.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().clickSaveButton());
		utils.log().info("Validation Message : " + new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().enterValidIPAddressText3.getText() + " is displayed");
		
		AssertJUnit.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().verifyThirdLANSubnetConfigurationWithSecondInvalidOctet());
		AssertJUnit.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().clickSaveButton());
		utils.log().info("Validation Message : " + new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().enterValidIPAddressTex16_31.getText() + " is displayed");
		
		softnet26.assertAll();
	}
	
	@Test(priority = 27)
	public void Verify_LAN_Settings_LAN_Subnet_DHCP_Range_Configuration_Help_Page() 
	{
		SoftAssert softnet27 = new SoftAssert();
		AssertJUnit.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().clickHelpButton());
			if(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().getLANSubnetRangeHelpPageObject().isAt()) {
				AssertJUnit.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().getLANSubnetRangeHelpPageObject().clickCloseButton());
				AssertJUnit.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANSubnetDHCPLRangePageObject().clickBackButton());
			softnet27.assertAll();
		}
	}
	
	@Test(priority = 28)
	public void Verify_LAN_Settings_LAN_DHCP_Lease_Time_UI_Page() 
	{
		SoftAssert softnet28 = new SoftAssert();
		//remove this if above test are uncommented
			new NetworkPage().clickNetworkSettingsExpandButton();
			new NetworkPage().clickLANSettings();
			try{
				if(new NetworkPage().getAppRatingPageObject().isAt())
					new NetworkPage().getAppRatingPageObject().clickRemindMeLaterLink();
			}catch(Exception e) {
				utils.log().info("App Rating Dialog did not appear");
			}
		//remove this if above test are uncommented
		
			if(new NetworkPage().getLANSettingsPageObject().isAt())
				AssertJUnit.assertTrue(new NetworkPage().getLANSettingsPageObject().clickDHCPLeaseTimeLink());
			if(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().isAt())
				AssertJUnit.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().verifyUIOnLANLeaseTimePage());
			softnet28.assertAll();
	}
	
	@Test(priority = 29)
	public void Verify_LAN_Settings_LAN_DHCP_Set_Lease_Time_Page() 
	{
		SoftAssert softnet29 = new SoftAssert();
		
		AssertJUnit.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().clickTimeUnitButton());
		if(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().getEditTimeUnitPageObject().isAt()){
			AssertJUnit.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().getEditTimeUnitPageObject().verifyUIOnLANEditLeaseTimePage());
			AssertJUnit.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().getEditTimeUnitPageObject().clickMinutesRadioButton());}
		AssertJUnit.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().verifyLeaseTimeWithMinutesTimeUnit());
		if(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().getLeaseTimeAppliedChangesDialogObject().isAt())
			AssertJUnit.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().getLeaseTimeAppliedChangesDialogObject().clickOKButton());
		
		AssertJUnit.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().clickTimeUnitButton());
		if(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().getEditTimeUnitPageObject().isAt())
			AssertJUnit.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().getEditTimeUnitPageObject().clickHourlyRadioButton());
		AssertJUnit.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().verifyLeaseTimeWithHourlyTimeUnit());
		if(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().getLeaseTimeAppliedChangesDialogObject().isAt())
			AssertJUnit.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().getLeaseTimeAppliedChangesDialogObject().clickOKButton());
		
		AssertJUnit.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().clickTimeUnitButton());
		if(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().getEditTimeUnitPageObject().isAt())
			AssertJUnit.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().getEditTimeUnitPageObject().clickDaysRadioButton());
		AssertJUnit.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().verifyLeaseTimeWithDaysTimeUnit());
		if(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().getLeaseTimeAppliedChangesDialogObject().isAt())
			AssertJUnit.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().getLeaseTimeAppliedChangesDialogObject().clickOKButton());
		
		AssertJUnit.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().clickTimeUnitButton());
		if(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().getEditTimeUnitPageObject().isAt())
			AssertJUnit.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().getEditTimeUnitPageObject().clickWeeklyRadioButton());
		AssertJUnit.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().verifyLeaseTimeWithWeeklyTimeUnit());
		if(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().getLeaseTimeAppliedChangesDialogObject().isAt())
			AssertJUnit.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().getLeaseTimeAppliedChangesDialogObject().clickOKButton());
		
		AssertJUnit.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().clickTimeUnitButton());
		if(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().getEditTimeUnitPageObject().isAt())
			AssertJUnit.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().getEditTimeUnitPageObject().clickForeverRadioButton());
		AssertJUnit.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().verifyLeaseTimeWithForeverTimeUnit());
		if(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().getLeaseTimeAppliedChangesDialogObject().isAt())
			AssertJUnit.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().getLeaseTimeAppliedChangesDialogObject().clickOKButton());
		
		AssertJUnit.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().clickTimeUnitButton());
		if(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().getEditTimeUnitPageObject().isAt())
			AssertJUnit.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().getEditTimeUnitPageObject().clickMinutesRadioButton());
		AssertJUnit.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().verifySameLeaseTimeForAnyUnit());
		if(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().getLeaseTimeAppliedChangesDialogObject().isAt())
			AssertJUnit.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().getLeaseTimeAppliedChangesDialogObject().clickOKButton());
		
		softnet29.assertAll();
	}
	
	@Test(priority = 30)
	public void Verify_LAN_Settings_LAN_DHCP_Set_Lease_Time_Help_Page() 
	{
		SoftAssert softnet30 = new SoftAssert();
		AssertJUnit.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().clickHelpButton());
		if(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().getLANDHCPLeaseTimeHelpPageObject().isAt())
			AssertJUnit.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().getLANDHCPLeaseTimeHelpPageObject().clickCloseButton());
			AssertJUnit.assertTrue(new NetworkPage().getLANSettingsPageObject().getNetworkLANDHCPLeaseTimePageObject().clickBackButton());
			try{
				if(new NetworkPage().getAppRatingPageObject().isAt())
					new NetworkPage().getAppRatingPageObject().clickRemindMeLaterLink();
			}catch(Exception e) {
				utils.log().info("App Rating Dialog did not appear");
			}
			AssertJUnit.assertTrue(new NetworkPage().getLANSettingsPageObject().clickBackButton());
			softnet30.assertAll();
	}
	
//	@Test(priority = 31)
//	public void Verify_Device_Priority_Settings_UI_Page() 
//	{
//		SoftAssert softnet31 = new SoftAssert();
//		//remove this if above test are uncommented
//		new NetworkPage().clickNetworkSettingsExpandButton();
//		super.swipeUp();
//		softnet31.assertTrue(new NetworkPage().clickDevicePrioritySettings());
//		super.pause(25);
//		super.pause(25);
//		try{
//			if(new NetworkPage().getAppRatingPageObject().isAt())
//				new NetworkPage().getAppRatingPageObject().clickRemindMeLaterLink();
//		}catch(Exception e) {
//			utils.log().info("App Rating Dialog did not appear");
//		}
//		remove this if above test are uncommented
//		softnet31.assertTrue(new NetworkPage().clickDevicePrioritySettings());
//		if(new NetworkPage().getNetworkDevicePrioritySettingsPageObject().isAt())
//		{
//			softnet31.assertTrue(new NetworkPage().getNetworkDevicePrioritySettingsPageObject().enableDevicePrioritySettings());
//			super.pause(30);
//			softnet31.assertTrue(new NetworkPage().getNetworkDevicePrioritySettingsPageObject().verifyUIOnDevicePrioritySettingsPage());
//			softnet31.assertTrue(new NetworkPage().getNetworkDevicePrioritySettingsPageObject().clickAddDeviceButton());
//		}
//		softnet31.assertAll();
//	}
//	
//	@Test(priority = 32)
//	public void Verify_Device_Priority_Settings_Add_Device_UI_Page() 
//	{
//		SoftAssert softnet32 = new SoftAssert();
//		if(new NetworkPage().getNetworkDevicePrioritySettingsPageObject().getAddDevicePriorityPageObject().isAt()) {
//			softnet32.assertTrue(new NetworkPage().getNetworkDevicePrioritySettingsPageObject().getAddDevicePriorityPageObject().verifyUIOnAddDevicePage());
//			softnet32.assertAll();
//		}
//	}
//	
//	@Test(priority = 33)
//	public void Verify_Device_Priority_Settings_Add_Device_Page() 
//	{
//		SoftAssert softnet33 = new SoftAssert();
//		softnet33.assertTrue(new NetworkPage().getNetworkDevicePrioritySettingsPageObject().getAddDevicePriorityPageObject().verifyDeviceListForPrioritization());
//		softnet33.assertTrue(new NetworkPage().getNetworkDevicePrioritySettingsPageObject().getAddDevicePriorityPageObject().clickAddDeviceButton());
//		softnet33.assertAll();
//
//	}
//	
//	@Test(priority = 34)
//	public void Verify_Device_Priority_Settings_Added_Device_Page() 
//	{
//		SoftAssert softnet34 = new SoftAssert();
//		if(new NetworkPage().getNetworkDevicePrioritySettingsPageObject().isAt()) {
//			softnet34.assertTrue(new NetworkPage().getNetworkDevicePrioritySettingsPageObject().verifyUIOnNetworkPrioritizedDevices());
//			softnet34.assertTrue(new NetworkPage().getNetworkDevicePrioritySettingsPageObject().verifyTwoDevicesWithHighestPriority());}
//		softnet34.assertAll();
//	}
//	
//	@Test(priority = 35)
//	public void Verify_Device_Priority_Settings_Add_Device_Help_Page() 
//	{
//		SoftAssert softnet35 = new SoftAssert();
//		softnet35.assertTrue(new NetworkPage().getNetworkDevicePrioritySettingsPageObject().getAddDevicePriorityPageObject().clickHelpButton());
//		if(new NetworkPage().getNetworkDevicePrioritySettingsPageObject().getAddDevicePriorityPageObject().getAddDevicePriorityHelpPageObject().isAt())
//			softnet35.assertTrue(new NetworkPage().getNetworkDevicePrioritySettingsPageObject().getAddDevicePriorityPageObject().getAddDevicePriorityHelpPageObject().clickCloseButton());
//		softnet35.assertTrue(new NetworkPage().getNetworkDevicePrioritySettingsPageObject().getAddDevicePriorityPageObject().clickBackButton());
//		softnet35.assertAll();
//	}
//	
//	@Test(priority = 36)
//	public void Verify_Device_Priority_Settings_Help_Page() 
//	{
//		SoftAssert softnet36 = new SoftAssert();
//		softnet36.assertTrue(new NetworkPage().getNetworkDevicePrioritySettingsPageObject().clickHelpButton());
//		if(new NetworkPage().getNetworkDevicePrioritySettingsPageObject().getDevicePriorityHelpPageObject().isAt())
//			softnet36.assertTrue(new NetworkPage().getNetworkDevicePrioritySettingsPageObject().getDevicePriorityHelpPageObject().clickCloseButton());
//		softnet36.assertTrue(new NetworkPage().getNetworkDevicePrioritySettingsPageObject().clickBackButton());
//		softnet36.assertAll();
//	}
	
	@Test(priority = 37)
	public void Verify_Time_Zone_Settings_UI_Page() 
	{
		SoftAssert softnet37 = new SoftAssert();
		super.swipeUp();
		AssertJUnit.assertTrue(new NetworkPage().clickTimeZone());
		if(new NetworkPage().getTimeZoneSettingsPageObject().isAt())
			AssertJUnit.assertTrue(new NetworkPage().getTimeZoneSettingsPageObject().verifyUIOnTimeZonePage());
		softnet37.assertAll();
	}
	
	@Test(priority = 38)
	public void Verify_Time_Zone_Settings_Help_Page() 
	{
		SoftAssert softnet38 = new SoftAssert();
		AssertJUnit .assertTrue(new NetworkPage().getTimeZoneSettingsPageObject().clickHelpButton());
		if (new NetworkPage().getTimeZoneSettingsPageObject().getTimeZoneHelpPageObject().isAt())
			AssertJUnit .assertTrue(new NetworkPage().getTimeZoneSettingsPageObject().getTimeZoneHelpPageObject().clickCloseButton());
		AssertJUnit .assertTrue(new NetworkPage().getTimeZoneSettingsPageObject().clickBackButton());
		softnet38 .assertAll();
	}
	
	@Test(priority = 39)
	public void Verify_General_Settings_UI_Page() 
	{
		SoftAssert softnet39 = new SoftAssert();
		if(new NetworkPage().getGeneralSettingsPageObject().isAt())
			AssertJUnit.assertTrue(new NetworkPage().getGeneralSettingsPageObject().verifyUIOnGeneralSettingsPage());
		softnet39.assertAll();
	}
	
	@Test(priority = 40)
	public void Verify_General_Settings_UPnP_Settings() 
	{
		SoftAssert softnet40 = new SoftAssert();
		AssertJUnit.assertTrue(new NetworkPage().getGeneralSettingsPageObject().disableUPnP());
		AssertJUnit.assertTrue(new NetworkPage().getGeneralSettingsPageObject().enableUPnP());
		AssertJUnit.assertTrue(new NetworkPage().getGeneralSettingsPageObject().clickUPNPInfoIcon());
		if(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsUPnPInfoDialogObject().isAt())
			AssertJUnit.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsUPnPInfoDialogObject().clickCloseButton());
		softnet40.assertAll();
	}
	
	@Test(priority = 41)
	public void Verify_General_Settings_IPv6_Enable_Settings() 
	{
		SoftAssert softnet39 = new SoftAssert();
		AssertJUnit.assertTrue(new NetworkPage().getGeneralSettingsPageObject().clickIPv6InfoIcon());
		if(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsIPv6EnableInfoDialogObject().isAt())
			AssertJUnit.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsIPv6EnableInfoDialogObject().clickCloseButton());
		softnet39.assertAll();
	}
	
	@Test(priority = 42)
	public void Verify_General_Settings_Bridge_Mode_Settings() 
	{
		SoftAssert softnet42 = new SoftAssert();
		AssertJUnit.assertTrue(new NetworkPage().getGeneralSettingsPageObject().clickBridgeModeInfoIcon());
		if(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsBridgeModeInfoDialogObject().isAt())
			AssertJUnit.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsBridgeModeInfoDialogObject().clickCloseButton());
		softnet42.assertAll();
	}
	
	@Test(priority = 43)
	public void Verify_General_Settings_Port_Forwarding_Settings() 
	{
		SoftAssert softnet43 = new SoftAssert();
		new NetworkPage().getGeneralSettingsPageObject().clickPortForwardingink();
		if(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().isAt())
			AssertJUnit.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().verifyUIOnPortForwardingPage());
		softnet43.assertAll();
	}
	
	@Test(priority = 44)
	public void Verify_General_Settings_Port_Forwarding_Add_Rule_Settings_Page() 
	{
		SoftAssert softnet44 = new SoftAssert();
		new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().clickAddRuleButton();
		if(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().isAt())
		{
			super.getDriver().hideKeyboard();
			AssertJUnit.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().verifyUIOnPortForwardingAddRulePage());
			AssertJUnit.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().clickCloseButton());
		}
		softnet44.assertAll();
	}
	
//	@Test(priority = 45)
//	public void Verify_General_Settings_Port_Forwarding_Add_Rules() 
//	{
//		SoftAssert softnet45 = new SoftAssert();
////		if(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().isAt()) 
////		{
//		for(int i = 1 ; i <=3 ; i++)
//		{
//			softnet45.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().clickAddRuleButton());
//			softnet45.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().enterPortRuleName());
//			softnet45.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().selectTCP());
//			softnet45.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().enterInternalPortStart());
//			softnet45.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().enterInternalPortEnd());
//			softnet45.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().enterExternalPortStart());
//			softnet45.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().enterExternalPortEnd());
//			softnet45.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().enterIPAddress());
//			softnet45.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().clickSaveButton());
//			
//			try {
//				if(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().portNameDialogError.isDisplayed())
//					softnet45.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().enterPortRuleName());
//				else if(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().internalPortStartError.isDisplayed())
//					softnet45.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().enterInternalPortStart());
//				else if(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().internalPortEndError.isDisplayed())
//					softnet45.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().enterInternalPortEnd());
//				else if(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().externalPortStartError.isDisplayed())
//					softnet45.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().enterExternalPortStart());
//				else if(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().externalPortEndError.isDisplayed())
//					softnet45.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().enterExternalPortEnd());
//				else
//					utils.log().info("All Port details are valid");
//			}catch(Exception e) {utils.log().info("All Port details are valid");}
//			super.pause(15);
//			try {
//				if(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().getPortRuleEditFailedDialogObject().isAt()) 
//					softnet45.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject()
//							.getPortRuleEditFailedDialogObject().clickOKButton());
//					}catch(Exception e) {utils.log().info("Port Rule Edit Failed Dialog did not appear");}
//		}
//		softnet45.assertAll();
//	}
		

//	@Test(priority = 46)
//
//	public void Verify_General_Settings_Port_Forwarding_Edit_Rules() 
//	{
//		SoftAssert softnet46 = new SoftAssert();
//		if(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().isAt()) 
//		{
//			softnet46.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().clickEditPortFowardingRuleIcon());
//			softnet46.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().enterPortRuleName());
//			softnet46.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().selectUDP());
//			softnet46.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().enterInternalPortStart());
//			softnet46.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().enterInternalPortEnd());
//			softnet46.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().enterExternalPortStart());
//			softnet46.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().enterExternalPortEnd());
//			softnet46.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().enterIPAddress());
//			softnet46.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().clickSaveButton());
//			try {
//				if(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().portNameDialogError.isDisplayed())
//					softnet46.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().enterPortRuleName());
//				else if(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().internalPortStartError.isDisplayed())
//					softnet46.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().enterInternalPortStart());
//				else if(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().internalPortEndError.isDisplayed())
//					softnet46.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().enterInternalPortEnd());
//				else if(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().externalPortStartError.isDisplayed())
//					softnet46.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().enterExternalPortStart());
//				else if(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().externalPortEndError.isDisplayed())
//					softnet46.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().enterExternalPortEnd());
//				else
//					utils.log().info("All Port details are valid");
//			}catch(Exception e) {utils.log().info("All Port details are valid");}
//			
//			super.pause(15);
//			try {
//			if(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().getPortRuleEditFailedDialogObject().isAt()) 
//				softnet46.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject()
//						.getPortRuleEditFailedDialogObject().clickOKButton());
//				}catch(Exception e) {utils.log().info("Port Rule Edit Failed Dialog did not appear");}
//		}
//		softnet46.assertAll();
//	}

//	@Test(priority = 47)
//	public void Verify_General_Settings_Port_Forwarding_Add_Rule_Settings_Validations() 
//	{
//		SoftAssert softnet47 = new SoftAssert();
//		new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().clickAddRuleButton();
//		if(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().isAt())
//		{
//			softnet47.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().verifyEnterPortForwardingRuleName());
//			softnet47.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().verifyEnterInternalPortStart());
//			softnet47.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().verifyEnterInternalPortEnd());
//			softnet47.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().verifyInternalPortStartLessThenPortEnd());
//			softnet47.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().verifyEnterExternalPortStart());
//			softnet47.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().verifyEnterExternalPortEnd());
//			softnet47.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().verifyExternalPortStartLessThenPortEnd());
//			softnet47.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().verifyEnterValidIPAddress());
//			softnet47.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().verifyEnterInValidIPAddress());
//			softnet47.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().clickSaveButton());
//			try {
//				if(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().portNameDialogError.isDisplayed())
//					softnet47.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().enterPortRuleName());
//				else if(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().internalPortStartError.isDisplayed())
//					softnet47.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().enterInternalPortStart());
//				else if(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().internalPortEndError.isDisplayed())
//					softnet47.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().enterInternalPortEnd());
//				else if(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().externalPortStartError.isDisplayed())
//					softnet47.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().enterExternalPortStart());
//				else if(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().externalPortEndError.isDisplayed())
//					softnet47.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().enterExternalPortEnd());
//				else
//					utils.log().info("All Port details are valid");
//			}catch(Exception e) {utils.log().info("All Port details are valid");}
//			
//			super.pause(20);
//			try {
//			if(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject().getPortRuleEditFailedDialogObject().isAt()) 
//				softnet47.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingAddRulePageObject()
//						.getPortRuleEditFailedDialogObject().clickOKButton());
//				}catch(Exception e) {utils.log().info("Port Rule Edit Failed Dialog did not appear");}
//		}
//		softnet47.assertAll();
//	}
//	
//	@Test(priority = 48)
//	public void Verify_General_Settings_Port_Forwarding_Help_Page() 
//	{
//		SoftAssert softnet48 = new SoftAssert();
//		softnet48.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().clickHelpButton());
//		if(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingHelpPageObject().isAt())
//			softnet48.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().getPortForwardingHelpPageObject().clickCloseButton());
//		
//		softnet48.assertTrue(new NetworkPage().getGeneralSettingsPageObject().getNetworkGeneralSettingsPortForwardingPageObject().clickBackButton());
//		try{
//			if(new NetworkPage().getAppRatingPageObject().isAt())
//				new NetworkPage().getAppRatingPageObject().clickRemindMeLaterLink();
//		}catch(Exception e) {
//			utils.log().info("App Rating Dialog did not appear");
//		}
//		softnet48.assertTrue(new NetworkPage().getGeneralSettingsPageObject().clickBackButton());
//		softnet48.assertTrue(new NetworkPage().clickNetworkSettingsExpandButton());
//		softnet48.assertAll();
//	}
	
//	@Test(priority = 49)
//	public void Verify_Guest_WiFi_Network_Page() 
//	{
//		SoftAssert softnet49 = new SoftAssert();
//		try {
//			if (new NetworkPage().guestNetworkToggleButton.isSelected()) 
//				new NetworkPage().disableGuestWifiNetwork();
//		}catch(Exception e) {}
//		
//		softnet49.assertTrue(new NetworkPage().enableGuestWifiNetwork());
//		try {
//			if(new NetworkPage().getEnableGuestNetworkAlertDialogObject().isAt())
//				softnet49.assertTrue(new NetworkPage().getEnableGuestNetworkAlertDialogObject().clickCloseButton());
//			super.pause(20);
//		}catch(Exception e) {}
//		
//		try {
//			if(new NetworkPage().getEnableGuestNetworkDialogObject().isAt()) {
//				super.getDriver().hideKeyboard();
//				softnet49.assertTrue(new NetworkPage().getEnableGuestNetworkDialogObject().verifyUIOnGuestNetworkPage());
//				softnet49.assertTrue(new NetworkPage().getEnableGuestNetworkDialogObject().validateGuestNetworkPage());
//				softnet49.assertTrue(new NetworkPage().getEnableGuestNetworkDialogObject().enterGuestNetworkName());
//				softnet49.assertTrue(new NetworkPage().getEnableGuestNetworkDialogObject().enterGuestNetworkPassword());
//				softnet49.assertTrue(new NetworkPage().getEnableGuestNetworkDialogObject().clickSaveChangesButton());
//				if(new NetworkPage().getEnableGuestNetworkAlertDialogObject().isAt())
//					softnet49.assertTrue(new NetworkPage().getEnableGuestNetworkAlertDialogObject().clickOkButton());
//				}
//			}catch(Exception e) {utils.log().info("Enable Guest Network Page did not appear");}
//		
//		try {
//			if(new NetworkPage().guestNetworkExpandIcon.isDisplayed()) {
//				softnet49.assertTrue(new NetworkPage().clickGuestNetworkExpandButton());
//				softnet49.assertTrue(new NetworkPage().clickGuestNetworkEditdButton());
//					if(new NetworkPage().getEditGuestNetworkDialogObject().isAt()) {
//						softnet49.assertTrue(new NetworkPage().getEditGuestNetworkDialogObject().createGuestNetwork());
//						softnet49.assertTrue(new NetworkPage().getEditGuestNetworkDialogObject().clickSaveChangesButton()); 
//						try {
//							if(new NetworkPage().getEnableGuestNetworkAlertDialogObject().isAt())
//								softnet49.assertTrue(new NetworkPage().getEnableGuestNetworkAlertDialogObject().clickOkButton());
//						}catch(Exception e) {utils.log().info("Guest Network Alert dialog did not appear");}
//					}
//				softnet49.assertTrue(new NetworkPage().clickGuestNetworkExpandButton());}
//		}catch(Exception e) {utils.log().info("Guest Network is not Created");}
//		
//		softnet49.assertAll();
//	}
//	
//	@Test(priority = 50)
//	public void Verify_Extended_WiFi_Settings_Page() 
//	{
//		SoftAssert softnet50 = new SoftAssert();
//		softnet50.assertTrue(new NetworkPage().clickExtendedWifiSettingsExpandButton());
//		softnet50.assertTrue(new NetworkPage().enable5GHzWidebandMode());
//		if(new NetworkPage().get5GHzWidebandModeAlertDialogObject().isAt())
//			softnet50.assertTrue(new NetworkPage().get5GHzWidebandModeAlertDialogObject().clickOKButton());
//		softnet50.assertTrue(new NetworkPage().clickfiveGHzWidebandInfoIcon());
//		
//		if(new NetworkPage().get5GHzWidebandModeAlertDialogObject().isAt())
//			softnet50.assertTrue(new NetworkPage().get5GHzWidebandModeAlertDialogObject().clickCloseButton());
//		
//		softnet50.assertTrue(new NetworkPage().clickExtendedWifiSettingsExpandButton());
//		softnet50.assertTrue(new NetworkPage().clickBackButton());
//		softnet50.assertAll();
//	}
}

