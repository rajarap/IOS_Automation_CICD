package com.cs.arris.Workflows;

import java.util.function.Consumer;

import com.cs.arris.Interface.Page;
import com.cs.arris.Pages.AboutHelpPage;
import com.cs.arris.Pages.AboutViewLicensesPage;
import com.cs.arris.Pages.AccessResourcesOnDevicePage;
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
import com.cs.arris.Pages.BlankBlockedDevicesPage;
import com.cs.arris.Pages.CodeVerifiedPage;
import com.cs.arris.Pages.CongratulationsPage;
import com.cs.arris.Pages.ConnectToWifiUsingRouterSSID;
import com.cs.arris.Pages.ConnectionToWifiNeededPage;
import com.cs.arris.Pages.CurrentlyBlockedDevicesPage;
import com.cs.arris.Pages.DeviceLocationPage;
import com.cs.arris.Pages.DeviceSignalStrengthLeaderBoardPage;
import com.cs.arris.Pages.DevicesPage;
import com.cs.arris.Pages.GetStartedPage;
import com.cs.arris.Pages.GrantPermissionsPage;
import com.cs.arris.Pages.HamburgerMenuPage;
import com.cs.arris.Pages.HomePage;
import com.cs.arris.Pages.InstallAdditionalSatellitePage;
import com.cs.arris.Pages.MainDevicePage;
import com.cs.arris.Pages.NameYourNetwokSSIDPage;
import com.cs.arris.Pages.NetworkOptimizationDialog;
import com.cs.arris.Pages.NetworkPage;
import com.cs.arris.Pages.ConnectMaxRouterToMobileDevicePage;
import com.cs.arris.Pages.EnterValidOTPPage;
import com.cs.arris.Pages.ErrorCode_0000_1506_Warranty_Support_Page;
import com.cs.arris.Pages.ErrorCode_0015_1805_Something_Went_Wrong_Page;
import com.cs.arris.Pages.FAQHelpPage;
import com.cs.arris.Pages.OptimizeYourNetworkPage;
import com.cs.arris.Pages.ParentalControlAddDeviceHelpPage;
import com.cs.arris.Pages.ParentalControlAddProfileDialog;
import com.cs.arris.Pages.ParentalControlAddRuleAddInternetBlockingScheduleDialog;
import com.cs.arris.Pages.ParentalControlAddRuleHelpPage;
import com.cs.arris.Pages.ParentalControlAlertDialog;
import com.cs.arris.Pages.ParentalControlCurrentlyBlockedPage;
import com.cs.arris.Pages.ParentalControlEditUserProfileNameDialog;
import com.cs.arris.Pages.ParentalControlHelpPage;
import com.cs.arris.Pages.ParentalControlPauseInternetforAllProfilesDialog;
import com.cs.arris.Pages.ParentalControlProfilesPage;
import com.cs.arris.Pages.ParentalControlUserProfileAddDevicePage;
import com.cs.arris.Pages.ParentalControlUserProfileAddRuleDatePickerDialog;
import com.cs.arris.Pages.ParentalControlUserProfileAddRulePage;
import com.cs.arris.Pages.ParentalControlUserProfileHelpPage;
import com.cs.arris.Pages.ParentalControlUserProfilePage;
import com.cs.arris.Pages.ParentalControlWithProfilesPage;
import com.cs.arris.Pages.PlugInMaxRouterPage;
import com.cs.arris.Pages.RemoveDevicePage;
import com.cs.arris.Pages.RetrieveOTPPage;
import com.cs.arris.Pages.SelectYourDevicePage;
import com.cs.arris.Pages.SelectYourDevicePage2;
import com.cs.arris.Pages.SetUpYourWiFiManagementPage;
import com.cs.arris.Pages.HamburgerSettingsPage;
import com.cs.arris.Pages.SettingsHelpPage;
import com.cs.arris.Pages.SetupHomeNetworkPage;
import com.cs.arris.Pages.ConnectMaxRouterToInternetPage;
import com.cs.arris.Pages.SystemFirmwareUpdatePage;
import com.cs.arris.Pages.UnPackYourBoxPage;
import com.cs.arris.Pages.SiginPage;
import com.cs.arris.Pages.SignupPage;
import com.cs.arris.Pages.SpeedTestHistoryPage;
import com.cs.arris.Utilities.ValidOTP;
import com.cs.arris.Utilities.TestUtils;
import com.cs.arris.Utilities.ValidOTP;

public class TC62_Login_And_Verify_Add_Device_Workflow 
{
	
TestUtils utils = new TestUtils();
	
	//GET STARTED
    public static TC62_Login_And_Verify_Add_Device_Workflow getStartedPage(Consumer<GetStartedPage> c){
    	GetStartedPage p = new GetStartedPage();
        c.accept(p);
        return new TC62_Login_And_Verify_Add_Device_Workflow();
    }
    
    //GRANT PERMISSIONS
    public TC62_Login_And_Verify_Add_Device_Workflow grantPermissionsPage(Consumer<GrantPermissionsPage> c){
    	GrantPermissionsPage p = new GrantPermissionsPage();
        c.accept(p);
        return this;
    }
    
    //Enable DEVICE LOCATION only this time
    public TC62_Login_And_Verify_Add_Device_Workflow deviceLocationPage(Consumer<DeviceLocationPage> c){
    	DeviceLocationPage p = new DeviceLocationPage();
        c.accept(p);
        return this;
    }
    
   //Access resource on device media-contacts
    public TC62_Login_And_Verify_Add_Device_Workflow accessResourcesOnDevicePage(Consumer<AccessResourcesOnDevicePage> c){
    	AccessResourcesOnDevicePage p = new AccessResourcesOnDevicePage();
         c.accept(p);
        return this;
    }
    
    //select SURFboard MAX mesh
    public TC62_Login_And_Verify_Add_Device_Workflow selectYourDevicePage(Consumer<SelectYourDevicePage> c){
    	SelectYourDevicePage p = new SelectYourDevicePage();
        c.accept(p);
        return this;
    }
    
    //select max Pro AX11000
    public TC62_Login_And_Verify_Add_Device_Workflow selectYourDevicePage2(Consumer<SelectYourDevicePage2> c){
    	SelectYourDevicePage2 p = new SelectYourDevicePage2();
        c.accept(p);
        return this;
    }
    
    //Enter valid email id and login
    public TC62_Login_And_Verify_Add_Device_Workflow welcomeSigninPage(Consumer<SiginPage> c){
    	SiginPage p = new SiginPage();
        c.accept(p);
        return this;
    }
    
    //Get OTP from email 
    public TC62_Login_And_Verify_Add_Device_Workflow getOTPCode(Consumer<ValidOTP> c){
    	ValidOTP p = new ValidOTP();
    	c.accept(p);
    	return this;
    }
      
    
  //enter OTP
    public TC62_Login_And_Verify_Add_Device_Workflow enterOTPPage(Consumer<EnterValidOTPPage> c){
    	EnterValidOTPPage p = new EnterValidOTPPage();
        c.accept(p);
        return this;
    }
    
    
    //OTP verified
    public TC62_Login_And_Verify_Add_Device_Workflow codeVerifiedPage(Consumer<CodeVerifiedPage> c){
    	CodeVerifiedPage p = new CodeVerifiedPage();
    	this.waitForPageLoad(p);
        c.accept(p);
        return this;
    }
    
    //Something went wrong
    public TC62_Login_And_Verify_Add_Device_Workflow somethingWentWrongPage(Consumer<ErrorCode_0015_1805_Something_Went_Wrong_Page> c){
    	ErrorCode_0015_1805_Something_Went_Wrong_Page p = new ErrorCode_0015_1805_Something_Went_Wrong_Page();
    	this.waitForPageLoad(p);
        c.accept(p);
        return this;
    }
    
    //Setup Wifi Management
    public TC62_Login_And_Verify_Add_Device_Workflow setupWifi(Consumer<SetUpYourWiFiManagementPage> c){
    	SetUpYourWiFiManagementPage p = new SetUpYourWiFiManagementPage();
        c.accept(p);
        return this;
    }
    
    //Home Page
    public TC62_Login_And_Verify_Add_Device_Workflow homePage(Consumer<HomePage> c){
    	HomePage p = new HomePage();
        c.accept(p);
        return this;
    }
    
    public TC62_Login_And_Verify_Add_Device_Workflow selectModem(Consumer<AddDeviceSelectDevice1Page> c){
    	AddDeviceSelectDevice1Page p = new AddDeviceSelectDevice1Page();
        c.accept(p);
        return this;
    }
    
    public TC62_Login_And_Verify_Add_Device_Workflow selectDevice(Consumer<AddDeviceSelectDevice2Page> c){
    	AddDeviceSelectDevice2Page p = new AddDeviceSelectDevice2Page();
        c.accept(p);
        return this;
    }
    
    public TC62_Login_And_Verify_Add_Device_Workflow deviceActivation(Consumer<AddDeviceStepsForActivationPage> c){
    	AddDeviceStepsForActivationPage p = new AddDeviceStepsForActivationPage();
        c.accept(p);
        return this;
    }
    
    public TC62_Login_And_Verify_Add_Device_Workflow deviceConnection(Consumer<AddDeviceLetsStartWithDeviceConnectionPage> c){
    	AddDeviceLetsStartWithDeviceConnectionPage p = new AddDeviceLetsStartWithDeviceConnectionPage();
        c.accept(p);
        return this;
    }
    
    public TC62_Login_And_Verify_Add_Device_Workflow internetServiceProvider(Consumer<AddDeviceChooseInternetServiceProviderPage> c){
    	AddDeviceChooseInternetServiceProviderPage p = new AddDeviceChooseInternetServiceProviderPage();
        c.accept(p);
        return this;
    }
       
    public TC62_Login_And_Verify_Add_Device_Workflow activateDevice(Consumer<AddDeviceActivateYourDeviceWithServiceProviderPage> c){
    	AddDeviceActivateYourDeviceWithServiceProviderPage p = new AddDeviceActivateYourDeviceWithServiceProviderPage();
        c.accept(p);
        return this;
    }
    
    public TC62_Login_And_Verify_Add_Device_Workflow establishConnection(Consumer<AddDeviceEstablishingConnectionPage> c){
    	AddDeviceEstablishingConnectionPage p = new AddDeviceEstablishingConnectionPage();
        c.accept(p);
        return this;
    }
    
    public TC62_Login_And_Verify_Add_Device_Workflow deviceSuccess(Consumer<AddDeviceSuccessPage> c){
    	AddDeviceSuccessPage p = new AddDeviceSuccessPage();
        c.accept(p);
        return this;
    }
    
    public TC62_Login_And_Verify_Add_Device_Workflow scanBarCode(Consumer<AddDeviceScanBarCodePage> c){
    	AddDeviceScanBarCodePage p = new AddDeviceScanBarCodePage();
        c.accept(p);
        return this;
    }
    
    public TC62_Login_And_Verify_Add_Device_Workflow accessCamera(Consumer<AddDeviceAccessCameraDialog> c){
    	AddDeviceAccessCameraDialog p = new AddDeviceAccessCameraDialog();
        c.accept(p);
        return this;
    }
    
    public TC62_Login_And_Verify_Add_Device_Workflow macAddress(Consumer<AddDeviceEnterMACAddressManuallyPage> c){
    	AddDeviceEnterMACAddressManuallyPage p = new AddDeviceEnterMACAddressManuallyPage();
        c.accept(p);
        return this;
    }
    
    public TC62_Login_And_Verify_Add_Device_Workflow registrationFailed(Consumer<AddDeviceRegistrationFailedPage> c){
    	AddDeviceRegistrationFailedPage p = new AddDeviceRegistrationFailedPage();
        c.accept(p);
        return this;
    }
    
    public TC62_Login_And_Verify_Add_Device_Workflow congratulatios(Consumer<AddDeviceCongratulationsPage> c){
    	AddDeviceCongratulationsPage p = new AddDeviceCongratulationsPage();
        c.accept(p);
        return this;
    }
    
    public TC62_Login_And_Verify_Add_Device_Workflow deviceHomePage(Consumer<AddDeviceHomePage> c){
    	AddDeviceHomePage p = new AddDeviceHomePage();
        c.accept(p);
        return this;
    }
    
    public TC62_Login_And_Verify_Add_Device_Workflow removeDevicePage(Consumer<RemoveDevicePage> c){
    	RemoveDevicePage p = new RemoveDevicePage();
        c.accept(p);
        return this;
    }
    
           
  //handle page sync techniques here
    private void waitForPageLoad(Page p){
        System.out.println("------------------------------");
        System.out.println("Waiting for " + p.toString() + " to load" );
        // wait till p.isAt() returns true with a timeout
    }
    

}
