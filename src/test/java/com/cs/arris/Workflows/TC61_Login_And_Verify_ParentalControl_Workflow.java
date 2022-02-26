package com.cs.arris.Workflows;

import java.util.function.Consumer;

import com.cs.arris.Interface.Page;
import com.cs.arris.Pages.AboutHelpPage;
import com.cs.arris.Pages.AboutViewLicensesPage;
import com.cs.arris.Pages.AccessResourcesOnDevicePage;
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

public class TC61_Login_And_Verify_ParentalControl_Workflow 
{
	
TestUtils utils = new TestUtils();
	
	//GET STARTED
    public static TC61_Login_And_Verify_ParentalControl_Workflow getStartedPage(Consumer<GetStartedPage> c){
    	GetStartedPage p = new GetStartedPage();
        c.accept(p);
        return new TC61_Login_And_Verify_ParentalControl_Workflow();
    }
    
    //GRANT PERMISSIONS
    public TC61_Login_And_Verify_ParentalControl_Workflow grantPermissionsPage(Consumer<GrantPermissionsPage> c){
    	GrantPermissionsPage p = new GrantPermissionsPage();
        c.accept(p);
        return this;
    }
    
    //Enable DEVICE LOCATION only this time
    public TC61_Login_And_Verify_ParentalControl_Workflow deviceLocationPage(Consumer<DeviceLocationPage> c){
    	DeviceLocationPage p = new DeviceLocationPage();
        c.accept(p);
        return this;
    }
    
   //Access resource on device media-contacts
    public TC61_Login_And_Verify_ParentalControl_Workflow accessResourcesOnDevicePage(Consumer<AccessResourcesOnDevicePage> c){
    	AccessResourcesOnDevicePage p = new AccessResourcesOnDevicePage();
         c.accept(p);
        return this;
    }
    
    //select SURFboard MAX mesh
    public TC61_Login_And_Verify_ParentalControl_Workflow selectYourDevicePage(Consumer<SelectYourDevicePage> c){
    	SelectYourDevicePage p = new SelectYourDevicePage();
        c.accept(p);
        return this;
    }
    
    //select max Pro AX11000
    public TC61_Login_And_Verify_ParentalControl_Workflow selectYourDevicePage2(Consumer<SelectYourDevicePage2> c){
    	SelectYourDevicePage2 p = new SelectYourDevicePage2();
        c.accept(p);
        return this;
    }
    
    //Enter valid email id and login
    public TC61_Login_And_Verify_ParentalControl_Workflow welcomeSigninPage(Consumer<SiginPage> c){
    	SiginPage p = new SiginPage();
        c.accept(p);
        return this;
    }
    
    //Get OTP from email 
    public TC61_Login_And_Verify_ParentalControl_Workflow getOTPCode(Consumer<ValidOTP> c){
    	ValidOTP p = new ValidOTP();
    	c.accept(p);
    	return this;
    }
      
    
  //enter OTP
    public TC61_Login_And_Verify_ParentalControl_Workflow enterOTPPage(Consumer<EnterValidOTPPage> c){
    	EnterValidOTPPage p = new EnterValidOTPPage();
        c.accept(p);
        return this;
    }
    
    
    //OTP verified
    public TC61_Login_And_Verify_ParentalControl_Workflow codeVerifiedPage(Consumer<CodeVerifiedPage> c){
    	CodeVerifiedPage p = new CodeVerifiedPage();
    	this.waitForPageLoad(p);
        c.accept(p);
        return this;
    }
    
    //Something went wrong
    public TC61_Login_And_Verify_ParentalControl_Workflow somethingWentWrongPage(Consumer<ErrorCode_0015_1805_Something_Went_Wrong_Page> c){
    	ErrorCode_0015_1805_Something_Went_Wrong_Page p = new ErrorCode_0015_1805_Something_Went_Wrong_Page();
    	this.waitForPageLoad(p);
        c.accept(p);
        return this;
    }
    
    //Setup Wifi Management
    public TC61_Login_And_Verify_ParentalControl_Workflow setupWifi(Consumer<SetUpYourWiFiManagementPage> c){
    	SetUpYourWiFiManagementPage p = new SetUpYourWiFiManagementPage();
        c.accept(p);
        return this;
    }
    
    //Home Page
    public TC61_Login_And_Verify_ParentalControl_Workflow homePage(Consumer<HomePage> c){
    	HomePage p = new HomePage();
        c.accept(p);
        return this;
    }
    
       
    //Speed Test History Page
    public TC61_Login_And_Verify_ParentalControl_Workflow speedTestHistoryPage(Consumer<SpeedTestHistoryPage> c){
    	SpeedTestHistoryPage p = new SpeedTestHistoryPage();
        c.accept(p);
        return this;
    }
    
    //Currently Blocked Devices Page
    public TC61_Login_And_Verify_ParentalControl_Workflow currentlyBlockedDevicesPage(Consumer<CurrentlyBlockedDevicesPage> c){
    	CurrentlyBlockedDevicesPage p = new CurrentlyBlockedDevicesPage();
        c.accept(p);
        return this;
    }
    
    
    //Parental Control Page
    public TC61_Login_And_Verify_ParentalControl_Workflow parentalControlPage(Consumer<ParentalControlProfilesPage> c){
    	ParentalControlProfilesPage p = new ParentalControlProfilesPage();
        c.accept(p);
        return this;
    }
    
    //Parental Control Page
    public TC61_Login_And_Verify_ParentalControl_Workflow blankBlockedDevicesPage(Consumer<BlankBlockedDevicesPage> c){
    	BlankBlockedDevicesPage p = new BlankBlockedDevicesPage();
        c.accept(p);
        return this;
    }
    
    public TC61_Login_And_Verify_ParentalControl_Workflow parentalControlWithProfilesPage(Consumer<ParentalControlWithProfilesPage> c){
    	ParentalControlWithProfilesPage p = new ParentalControlWithProfilesPage();
        c.accept(p);
        return this;
    }
    
    public TC61_Login_And_Verify_ParentalControl_Workflow parentalControlUserProfilesPage(Consumer<ParentalControlUserProfilePage> c){
    	ParentalControlUserProfilePage p = new ParentalControlUserProfilePage();
        c.accept(p);
        return this;
    }
    
    public TC61_Login_And_Verify_ParentalControl_Workflow parentalControlUserProfileHelpPage(Consumer<ParentalControlUserProfileHelpPage> c){
    	ParentalControlUserProfileHelpPage p = new ParentalControlUserProfileHelpPage();
        c.accept(p);
        return this;
    }
    
    public TC61_Login_And_Verify_ParentalControl_Workflow parentalControlUserProfileAddDevicePage(Consumer<ParentalControlUserProfileAddDevicePage> c){
    	ParentalControlUserProfileAddDevicePage p = new ParentalControlUserProfileAddDevicePage();
        c.accept(p);
        return this;
    }
    
    public TC61_Login_And_Verify_ParentalControl_Workflow parentalControlPauseInternetFoAllDialog(Consumer<ParentalControlPauseInternetforAllProfilesDialog> c){
    	ParentalControlPauseInternetforAllProfilesDialog p = new ParentalControlPauseInternetforAllProfilesDialog();
        c.accept(p);
        return this;
    }
    
    public TC61_Login_And_Verify_ParentalControl_Workflow parentalControlHelpPage(Consumer<ParentalControlHelpPage> c){
    	ParentalControlHelpPage p = new ParentalControlHelpPage();
        c.accept(p);
        return this;
    }
    
    public TC61_Login_And_Verify_ParentalControl_Workflow parentalControlCurrentlyBlockedPage(Consumer<ParentalControlCurrentlyBlockedPage> c){
    	ParentalControlCurrentlyBlockedPage p = new ParentalControlCurrentlyBlockedPage();
        c.accept(p);
        return this;
    }
    
    public TC61_Login_And_Verify_ParentalControl_Workflow parentalControlAlertDialog(Consumer<ParentalControlAlertDialog> c){
    	ParentalControlAlertDialog p = new ParentalControlAlertDialog();
        c.accept(p);
        return this;
    }
    
    public TC61_Login_And_Verify_ParentalControl_Workflow parentalControlAddProfileDialog(Consumer<ParentalControlAddProfileDialog> c){
    	ParentalControlAddProfileDialog p = new ParentalControlAddProfileDialog();
        c.accept(p);
        return this;
    }
    
    public TC61_Login_And_Verify_ParentalControl_Workflow parentalControlAddDeviceHelpPage(Consumer<ParentalControlAddDeviceHelpPage> c){
    	ParentalControlAddDeviceHelpPage p = new ParentalControlAddDeviceHelpPage();
        c.accept(p);
        return this;
    }
    
    public TC61_Login_And_Verify_ParentalControl_Workflow parentalControlEditUserProfileDialog(Consumer<ParentalControlEditUserProfileNameDialog> c){
    	ParentalControlEditUserProfileNameDialog p = new ParentalControlEditUserProfileNameDialog();
        c.accept(p);
        return this;
    }
    
    public TC61_Login_And_Verify_ParentalControl_Workflow parentalControlUserProfileAddRulePage(Consumer<ParentalControlUserProfileAddRulePage> c){
    	ParentalControlUserProfileAddRulePage p = new ParentalControlUserProfileAddRulePage();
        c.accept(p);
        return this;
    }

    public TC61_Login_And_Verify_ParentalControl_Workflow parentalControlAddRuleHelpPage(Consumer<ParentalControlAddRuleHelpPage> c){
    	ParentalControlAddRuleHelpPage p = new ParentalControlAddRuleHelpPage();
        c.accept(p);
       return this;  
    }
   
    public TC61_Login_And_Verify_ParentalControl_Workflow parentalControlInternetBlockingPage(Consumer<ParentalControlAddRuleAddInternetBlockingScheduleDialog> c){
    	ParentalControlAddRuleAddInternetBlockingScheduleDialog p = new ParentalControlAddRuleAddInternetBlockingScheduleDialog();
        c.accept(p);
       return this;  
    }
    
    public TC61_Login_And_Verify_ParentalControl_Workflow parentalControlDatePickerDialog(Consumer<ParentalControlUserProfileAddRuleDatePickerDialog> c){
    	ParentalControlUserProfileAddRuleDatePickerDialog p = new ParentalControlUserProfileAddRuleDatePickerDialog();
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
