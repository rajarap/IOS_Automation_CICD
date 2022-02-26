package com.cs.arris.Tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.lang.reflect.Method;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cs.arris.Base.ParentClass;
import com.cs.arris.Pages.AddDeviceAccessCameraDialog;
import com.cs.arris.Pages.AddDeviceActivateYourDeviceWithServiceProviderPage;
import com.cs.arris.Pages.AddDeviceChooseInternetServiceProviderPage;
import com.cs.arris.Pages.AddDeviceCongratulationsPage;
import com.cs.arris.Pages.AddDeviceEnterMACAddressManuallyPage;
import com.cs.arris.Pages.AddDeviceEstablishingConnectionPage;
import com.cs.arris.Pages.AddDeviceHomePage;
import com.cs.arris.Pages.AddDeviceLetsStartWithDeviceConnectionPage;
import com.cs.arris.Pages.AddDeviceRegistrationFailedPage;
import com.cs.arris.Pages.AddDeviceScanBarCodePage;
import com.cs.arris.Pages.AddDeviceSelectDevice1Page;
import com.cs.arris.Pages.AddDeviceSelectDevice2Page;
import com.cs.arris.Pages.AddDeviceStepsForActivationPage;
import com.cs.arris.Pages.AddDeviceSuccessPage;
import com.cs.arris.Pages.HomePage;
import com.cs.arris.Pages.NetworkPage;
import com.cs.arris.Pages.ParentalControlWithProfilesPage;
import com.cs.arris.Pages.SiginPage;
import com.cs.arris.Utilities.TestUtils;
import com.cs.arris.Workflows.HomePage_Workflow;
import com.cs.arris.Workflows.TC52_Login_And_Verify_HomePage_Workflow;
import com.cs.arris.Workflows.TC53_Login_And_Verify_DevicesPage_Workflow;
import com.cs.arris.Workflows.TC60_Login_And_Verify_HamburgerMenuAndSettingsAboutHelpPage_Workflow;
import com.cs.arris.Workflows.TC61_Login_And_Verify_ParentalControl_Workflow;
import com.cs.arris.Workflows.TC62_Login_And_Verify_Add_Device_Workflow;

public class TC013_Login_And_Test_Add_And_Remove_Device extends ParentClass {
	TestUtils utils = new TestUtils();
	String firstName;
	String lastName;
	String email;
	String passCode;
	String ssid;
	String ssidpass;
	String udid;
	String phoneToPause;
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
			utils.log().info("Loading...Test Data");
			super.loadTestData(dataFileName);

			this.firstName = properties.getProperty("firstname");
			utils.log().info("First Name : " + this.firstName);

			this.lastName = properties.getProperty("lastname");
			utils.log().info("Last Name : " + this.lastName);

			this.email = properties.getProperty("email");
			utils.log().info("Email address : " + this.email);

			this.udid = properties.getProperty("udid");
			utils.log().info("UDID : " + this.udid);

			this.phoneToPause = properties.getProperty("phoneToPauseInternet");
			utils.log().info("Phone To Pause Internet : " + this.phoneToPause);

			utils.log().info("Retrieved...Test Data");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@BeforeMethod
	public void beforeMethod(Method m) {
		utils.log().info("\n" + "\n" + "****** starting test :  " + m.getName() + "  ******" + "\n");
	}

	@Test(priority = 1)
	public void Login_And_Onboard() {
		TC62_Login_And_Verify_Add_Device_Workflow.getStartedPage(getStarted -> {
			getStarted.clickGetStartedButton();
		}).grantPermissionsPage(grantPermission -> {
			grantPermission.clickContinueButton();
		}).deviceLocationPage(deviceLocation -> {
			deviceLocation.clickOnlyThisTimeLink();
		}).accessResourcesOnDevicePage(accessResoucesOnDevice -> {
			super.pause(3);
			accessResoucesOnDevice.clickAllowLink();
		}).selectYourDevicePage(selectDevice -> {
			selectDevice.selectSurfboardMaxOption();
			selectDevice.clickNextButton();
		}).selectYourDevicePage2(selectDevice2 -> {
			selectDevice2.selectMaxProAX11000RadioButton();
			selectDevice2.clickNextButton();
			super.pause(3);
		}).welcomeSigninPage(signin -> {
			signin.enterEmailAddress(email);
			signin.clickSigninButton();
			super.pause(12);
		}).getOTPCode(getOTP -> {
			passCode = getOTP.getValidOTP();
		}).enterOTPPage(otpverify -> {
			otpverify.enterValidPassCode(passCode);
		}).codeVerifiedPage(codeVerified -> {
			codeVerified.getCodeVerifiedText();
			codeVerified.clickNextButton();
			super.pause(3);
			try {
				if (codeVerified.continueOnBoardingButton.isDisplayed()) {
					codeVerified.clickContinueOnboardingButton();
				}
			} catch (Exception e) {
				e.getMessage();
			}
		}).setupWifi(setupwifi -> {
			setupwifi.clickskipTutorialButton();
			super.pause(3);
		}).homePage(home -> {
//			try {
//				if (home.okButton.isDisplayed()) {
//					home.clickOkButton();
//				}
//			} catch (Exception e) {
//				e.getMessage();
//			}
//			if (home.isAt()) 
//				home.clickNavigationButton();
//
//			if(home.getHamburgerMenuPageObject().isAt())
//				home.getHamburgerMenuPageObject().clickAddDeviceButton();
//			}).selectModem(modem -> {
//				modem.selectISPCableRadioButton();
//				modem.clickNextButton();
//			}).selectDevice(device -> {
//				device.selectT25RadioButton();
//				device.clickNextButton();
//				super.pause(5);
//			}).deviceActivation(activation -> {
//				activation.clickStartButton();
//			}).deviceConnection(connection -> {
//				connection.clickNextButton();
//			}).internetServiceProvider(provider -> {
//				provider.verifyChoosingInternetProviderUI();
//				provider.clickNextButton();
//			}).activateDevice(activate -> {
//				activate.clickSkipButton();
//			}).establishConnection(connection -> {
//				connection.clickOnlineButton();
//			}).deviceSuccess(success -> {
//				success.clickNextButton();
//			}).scanBarCode(scan -> {
//				scan.clickScanButton();
//			}).accessCamera(camera -> {
//				camera.clickEnterManuallyButton();
//			}).macAddress(macaddress -> {
//				macaddress.enterSerialNumber();
//				macaddress.enterMACAddress();
//				macaddress.clickNextButton();
//			}).registrationFailed(registration -> {
//				registration.clickContinueButton();
//			}).congratulatios(congrats -> {
//				congrats.clickContinueButton();
			});
	}
	
	@Test(priority = 1)
	public void Verify_Hamburger_Menu_Add_Remove_Device_Page() {
		try {
			this.Verify_Add_Device_Menu();
		}catch(Exception e) {utils.log().info("Issue in Add Device Page");}
		
		try {
			this.Verify_Cable_Modem_Tab();
		}catch(Exception e) {utils.log().info("Issue in Cable Modem Tab");}
		
		try {
			this.Verify_Max_Router_Tab();
		}catch(Exception e) {utils.log().info("Issue in Max Router Tab");}
		
		try {
			this.Verify_Device_Details_Page();
		}catch(Exception e) {utils.log().info("Issue in Device Details Page");}
		
		try {
			this.Verify_Specifications_Page();
		}catch(Exception e) {utils.log().info("Issue in Specifications Page");}
		
		try {
			this.Verify_Add_Additional_Device();
		}catch(Exception e) {utils.log().info("Issue in Add Additional Device");}
		
		try {
			this.Verify_Notifications_Page();
		}catch(Exception e) {utils.log().info("Issue in Notifications Page");}
		
		try {
			this.Verify_User_Guide_Page();
		}catch(Exception e) {utils.log().info("Issue in User Guide Page");}
		
		try {
			this.Verify_FAQ_Page();
		}catch(Exception e) {utils.log().info("Issue in FAQ Page");}
		
		try {
			this.Verify_Remove_Device_Page();
		}catch(Exception e) {utils.log().info("Issue in Remove Device Page");}
	}
	
	@Test(priority = 2)
	public void Verify_Add_Device_Menu() {
		SoftAssert softhome2 = new SoftAssert();
		if(new HomePage().isAt())
			AssertJUnit.assertTrue(new HomePage().clickNavigationButton());
		
		if(new HomePage().getHamburgerMenuPageObject().isAt())
			AssertJUnit.assertTrue(new HomePage().getHamburgerMenuPageObject().clickAddDeviceButton());
		
		if(new AddDeviceSelectDevice1Page().isAt()) {
			AssertJUnit.assertTrue(new AddDeviceSelectDevice1Page().selectISPCableRadioButton());
			AssertJUnit.assertTrue(new AddDeviceSelectDevice1Page().clickNextButton());}
		
		if(new AddDeviceSelectDevice2Page().isAt()) {
			AssertJUnit.assertTrue(new AddDeviceSelectDevice2Page().selectT25RadioButton());
			AssertJUnit.assertTrue(new AddDeviceSelectDevice2Page().clickNextButton());
			super.pause(5);}
		
		if(new AddDeviceStepsForActivationPage().isAt())
			AssertJUnit.assertTrue(new AddDeviceStepsForActivationPage().clickStartButton());
		
		if(new AddDeviceLetsStartWithDeviceConnectionPage().isAt())
			AssertJUnit.assertTrue(new AddDeviceLetsStartWithDeviceConnectionPage().clickNextButton());
		
		if(new AddDeviceChooseInternetServiceProviderPage().isAt())
			AssertJUnit.assertTrue(new AddDeviceChooseInternetServiceProviderPage().clickNextButton());
		
		if(new AddDeviceActivateYourDeviceWithServiceProviderPage().isAt())
			AssertJUnit.assertTrue(new AddDeviceActivateYourDeviceWithServiceProviderPage().clickSkipButton());
		
		if(new AddDeviceEstablishingConnectionPage().isAt())
			AssertJUnit.assertTrue(new AddDeviceEstablishingConnectionPage().clickOnlineButton());
		
		if(new AddDeviceSuccessPage().isAt())
			AssertJUnit.assertTrue(new AddDeviceSuccessPage().clickNextButton());
		
		if(new AddDeviceScanBarCodePage().isAt())
			AssertJUnit.assertTrue(new AddDeviceScanBarCodePage().clickScanButton());
		
		if(new AddDeviceAccessCameraDialog().isAt())
			AssertJUnit.assertTrue(new AddDeviceAccessCameraDialog().clickEnterManuallyButton());
		
		if(new AddDeviceEnterMACAddressManuallyPage().isAt()) {
			AssertJUnit.assertTrue(new AddDeviceEnterMACAddressManuallyPage().enterSerialNumber());
			AssertJUnit.assertTrue(new AddDeviceEnterMACAddressManuallyPage().enterMACAddress());
			AssertJUnit.assertTrue(new AddDeviceEnterMACAddressManuallyPage().clickNextButton());}
		
		if(new AddDeviceRegistrationFailedPage().isAt())
			AssertJUnit.assertTrue(new AddDeviceRegistrationFailedPage().clickContinueButton());
		
		if(new AddDeviceCongratulationsPage().isAt())
			AssertJUnit.assertTrue(new AddDeviceCongratulationsPage().clickContinueButton());
		
		softhome2.assertAll();
	}
		
	@Test(priority = 2)
	public void Verify_Cable_Modem_Tab() {
		SoftAssert softhome0 = new SoftAssert();
		if(new AddDeviceHomePage().isAt())
			AssertJUnit.assertTrue(new AddDeviceHomePage().verifyUIOnHomePage());
		
		softhome0.assertAll();
	}
	
	@Test(priority = 3)
	public void Verify_Max_Router_Tab() {
		SoftAssert softhome3 = new SoftAssert();
		AssertJUnit.assertTrue(new AddDeviceHomePage().clickMaxRouterTab());
		AssertJUnit.assertTrue(new AddDeviceHomePage().getHomePageObject().verifyUIOnHomePage());
		AssertJUnit.assertTrue(new AddDeviceHomePage().clickCableModemTab());
		
		softhome3.assertAll();
	}
	
	@Test(priority = 4)
	public void Verify_Device_Details_Page() {
		SoftAssert softhome4 = new SoftAssert();
		AssertJUnit.assertTrue(new AddDeviceHomePage().clickDeviceDetailsText());
		if(new AddDeviceHomePage().getDeviceDetailsPageObject().isAt()) {
			AssertJUnit.assertTrue(new AddDeviceHomePage().getDeviceDetailsPageObject().verifyDeviceDetailsUI());
			AssertJUnit.assertTrue(new AddDeviceHomePage().getDeviceDetailsPageObject().clickCloseButton());
		}
		
		softhome4.assertAll();
	}
	
	@Test(priority = 5)
	public void Verify_Specifications_Page() {
		SoftAssert softhome5 = new SoftAssert();
		AssertJUnit.assertTrue(new AddDeviceHomePage().clickSpecificationsText());
		super.pause(5);
		if(new AddDeviceHomePage().getDeviceSpecificationsPageObject().isAt())
			AssertJUnit.assertTrue(new AddDeviceHomePage().getDeviceSpecificationsPageObject().clickBackButton());
		
		softhome5.assertAll();
	}
	
	@Test(priority = 6)
	public void Verify_Add_Additional_Device() {
		SoftAssert softhome6 = new SoftAssert();
		if(new AddDeviceHomePage().isAt())
			AssertJUnit.assertTrue(new AddDeviceHomePage().clickNavigationButton());
			
		if(new AddDeviceHomePage().getHamburgerMenuObject().isAt())
			AssertJUnit.assertTrue(new AddDeviceHomePage().getHamburgerMenuObject().clickAddDeviceButton());
			
		if(new AddDeviceHomePage().getMaxTwoDevicesDialogObject().isAt())
			AssertJUnit.assertTrue(new AddDeviceHomePage().getMaxTwoDevicesDialogObject().clickOkButton());
		
		softhome6.assertAll();
	}
	
	@Test(priority = 7)
	public void Verify_Notifications_Page() {
		SoftAssert softhome7 = new SoftAssert();
		if(new AddDeviceHomePage().isAt())
			AssertJUnit.assertTrue(new AddDeviceHomePage().clickNotificationsIcon());
		
		if(new AddDeviceHomePage().getNotificationsPageObject().isAt())
			AssertJUnit.assertTrue(new AddDeviceHomePage().getNotificationsPageObject().clickBackButton());
		
		softhome7.assertAll();
	}
	
	@Test(priority = 8)
	public void Verify_User_Guide_Page() {
		SoftAssert softhome8 = new SoftAssert();
		if(new AddDeviceHomePage().isAt())
			AssertJUnit.assertTrue(new AddDeviceHomePage().getAddDeviceFooterIconsPageObject().clickUserGuideButton());
		super.pause(3);

		if(new AddDeviceHomePage().getUserGuidePageObject().isAt())
			super.swipeUp();
//			softhome8.assertTrue(new AddDeviceHomePage().getUserGuidePageObject().clickBackButton());
		
		softhome8.assertAll();
	}
	
	@Test(priority = 9)
	public void Verify_FAQ_Page() {
		SoftAssert softhome9 = new SoftAssert();
		if(new AddDeviceHomePage().isAt())
			AssertJUnit.assertTrue(new AddDeviceHomePage().getAddDeviceFooterIconsPageObject().clickFAQButton());
		super.pause(3);
		
		if(new AddDeviceHomePage().getFAQPageObject().isAt())
			super.swipeUp();
//			softhome9.assertTrue(new AddDeviceHomePage().getUserGuidePageObject().clickBackButton());
		
		softhome9.assertAll();
	}
	
	@Test(priority = 10)
	public void Verify_Remove_Device_Page() {
		SoftAssert softhome10 = new SoftAssert();
		if(new AddDeviceHomePage().isAt())
			AssertJUnit.assertTrue(new AddDeviceHomePage().clickNavigationButton());
			
		if(new AddDeviceHomePage().getHamburgerMenuObject().isAt())
//			softhome10.assertTrue(new AddDeviceHomePage().getHamburgerMenuObject().clickRemoveDeviceeButton());
		
		if(new AddDeviceHomePage().getRemoveDevicePageObject().isAt()) {
			AssertJUnit.assertTrue(new AddDeviceHomePage().getRemoveDevicePageObject().selectDeviceToRemove());
			AssertJUnit.assertTrue(new AddDeviceHomePage().getRemoveDevicePageObject().clickNextButton());
			super.pause(3);}
			
		softhome10.assertAll();
	}
}
	
