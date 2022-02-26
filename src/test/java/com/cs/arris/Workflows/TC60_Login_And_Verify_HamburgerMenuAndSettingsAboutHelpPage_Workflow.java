package com.cs.arris.Workflows;

import java.util.function.Consumer;

import com.cs.arris.Interface.Page;
import com.cs.arris.Pages.AboutHelpPage;
import com.cs.arris.Pages.AboutViewLicensesPage;
import com.cs.arris.Pages.AccessResourcesOnDevicePage;
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
import com.cs.arris.Pages.ParentalControlProfilesPage;
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

public class TC60_Login_And_Verify_HamburgerMenuAndSettingsAboutHelpPage_Workflow 
{
	
TestUtils utils = new TestUtils();
	
	//GET STARTED
    public static TC60_Login_And_Verify_HamburgerMenuAndSettingsAboutHelpPage_Workflow getStartedPage(Consumer<GetStartedPage> c){
    	GetStartedPage p = new GetStartedPage();
        c.accept(p);
        return new TC60_Login_And_Verify_HamburgerMenuAndSettingsAboutHelpPage_Workflow();
    }
    
    //GRANT PERMISSIONS
    public TC60_Login_And_Verify_HamburgerMenuAndSettingsAboutHelpPage_Workflow grantPermissionsPage(Consumer<GrantPermissionsPage> c){
    	GrantPermissionsPage p = new GrantPermissionsPage();
        c.accept(p);
        return this;
    }
    
    //Enable DEVICE LOCATION only this time
    public TC60_Login_And_Verify_HamburgerMenuAndSettingsAboutHelpPage_Workflow deviceLocationPage(Consumer<DeviceLocationPage> c){
    	DeviceLocationPage p = new DeviceLocationPage();
        c.accept(p);
        return this;
    }
    
   //Access resource on device media-contacts
    public TC60_Login_And_Verify_HamburgerMenuAndSettingsAboutHelpPage_Workflow accessResourcesOnDevicePage(Consumer<AccessResourcesOnDevicePage> c){
    	AccessResourcesOnDevicePage p = new AccessResourcesOnDevicePage();
         c.accept(p);
        return this;
    }
    
    //select SURFboard MAX mesh
    public TC60_Login_And_Verify_HamburgerMenuAndSettingsAboutHelpPage_Workflow selectYourDevicePage(Consumer<SelectYourDevicePage> c){
    	SelectYourDevicePage p = new SelectYourDevicePage();
        c.accept(p);
        return this;
    }
    
    //select max Pro AX11000
    public TC60_Login_And_Verify_HamburgerMenuAndSettingsAboutHelpPage_Workflow selectYourDevicePage2(Consumer<SelectYourDevicePage2> c){
    	SelectYourDevicePage2 p = new SelectYourDevicePage2();
        c.accept(p);
        return this;
    }
    
    //Enter valid email id and login
    public TC60_Login_And_Verify_HamburgerMenuAndSettingsAboutHelpPage_Workflow welcomeSigninPage(Consumer<SiginPage> c){
    	SiginPage p = new SiginPage();
        c.accept(p);
        return this;
    }
    
    //Get OTP from email 
    public TC60_Login_And_Verify_HamburgerMenuAndSettingsAboutHelpPage_Workflow getOTPCode(Consumer<ValidOTP> c){
    	ValidOTP p = new ValidOTP();
    	c.accept(p);
    	return this;
    }
      
    
  //enter OTP
    public TC60_Login_And_Verify_HamburgerMenuAndSettingsAboutHelpPage_Workflow enterOTPPage(Consumer<EnterValidOTPPage> c){
    	EnterValidOTPPage p = new EnterValidOTPPage();
        c.accept(p);
        return this;
    }
    
    
    //OTP verified
    public TC60_Login_And_Verify_HamburgerMenuAndSettingsAboutHelpPage_Workflow codeVerifiedPage(Consumer<CodeVerifiedPage> c){
    	CodeVerifiedPage p = new CodeVerifiedPage();
    	this.waitForPageLoad(p);
        c.accept(p);
        return this;
    }
    
    //Something went wrong
    public TC60_Login_And_Verify_HamburgerMenuAndSettingsAboutHelpPage_Workflow somethingWentWrongPage(Consumer<ErrorCode_0015_1805_Something_Went_Wrong_Page> c){
    	ErrorCode_0015_1805_Something_Went_Wrong_Page p = new ErrorCode_0015_1805_Something_Went_Wrong_Page();
    	this.waitForPageLoad(p);
        c.accept(p);
        return this;
    }
    
    //Setup Wifi Management
    public TC60_Login_And_Verify_HamburgerMenuAndSettingsAboutHelpPage_Workflow setupWifi(Consumer<SetUpYourWiFiManagementPage> c){
    	SetUpYourWiFiManagementPage p = new SetUpYourWiFiManagementPage();
        c.accept(p);
        return this;
    }
    
    //Home Page
    public static TC60_Login_And_Verify_HamburgerMenuAndSettingsAboutHelpPage_Workflow homePage(Consumer<HomePage> c){
    	HomePage p = new HomePage();
        c.accept(p);
        return new TC60_Login_And_Verify_HamburgerMenuAndSettingsAboutHelpPage_Workflow();
    }
    
    //Devices Page - Till here
    public TC60_Login_And_Verify_HamburgerMenuAndSettingsAboutHelpPage_Workflow devicesPage(Consumer<DevicesPage> c){
    	DevicesPage p = new DevicesPage();
        c.accept(p);
        return this;
    }
    
    //Device Signal Strength Leader Board Page
    public TC60_Login_And_Verify_HamburgerMenuAndSettingsAboutHelpPage_Workflow deviceSignalStrengthPage(Consumer<DeviceSignalStrengthLeaderBoardPage> c){
    	DeviceSignalStrengthLeaderBoardPage p = new DeviceSignalStrengthLeaderBoardPage();
        c.accept(p);
        return this;
    }
       
    //Speed Test History Page
    public TC60_Login_And_Verify_HamburgerMenuAndSettingsAboutHelpPage_Workflow speedTestHistoryPage(Consumer<SpeedTestHistoryPage> c){
    	SpeedTestHistoryPage p = new SpeedTestHistoryPage();
        c.accept(p);
        return this;
    }
    
    //Currently Blocked Devices Page
    public TC60_Login_And_Verify_HamburgerMenuAndSettingsAboutHelpPage_Workflow currentlyBlockedDevicesPage(Consumer<CurrentlyBlockedDevicesPage> c){
    	CurrentlyBlockedDevicesPage p = new CurrentlyBlockedDevicesPage();
        c.accept(p);
        return this;
    }
    
    //Network Page
    public TC60_Login_And_Verify_HamburgerMenuAndSettingsAboutHelpPage_Workflow networkPage(Consumer<NetworkPage> c){
    	NetworkPage p = new NetworkPage();
        c.accept(p);
        return this;
    }
    
    //Parental Control Page
    public TC60_Login_And_Verify_HamburgerMenuAndSettingsAboutHelpPage_Workflow parentalControlPage(Consumer<ParentalControlProfilesPage> c){
    	ParentalControlProfilesPage p = new ParentalControlProfilesPage();
        c.accept(p);
        return this;
    }
    
    //Hamburger Manu Page
    public TC60_Login_And_Verify_HamburgerMenuAndSettingsAboutHelpPage_Workflow hamburgerMenuPage(Consumer<HamburgerMenuPage> c){
    	HamburgerMenuPage p = new HamburgerMenuPage();
        c.accept(p);
        return this;
    }
    
    //Settings About Help Page 
    public TC60_Login_And_Verify_HamburgerMenuAndSettingsAboutHelpPage_Workflow settingsAboutHelpPage(Consumer<HamburgerSettingsPage> c){
    	HamburgerSettingsPage p = new HamburgerSettingsPage();
        c.accept(p);
        return this;
    }
    
    //Settings Help Page 
    public TC60_Login_And_Verify_HamburgerMenuAndSettingsAboutHelpPage_Workflow settingsHelpPage(Consumer<SettingsHelpPage> c){
    	SettingsHelpPage p = new SettingsHelpPage();
        c.accept(p);
        return this;
    }
    
    //About Help Page 
    public TC60_Login_And_Verify_HamburgerMenuAndSettingsAboutHelpPage_Workflow aboutHelpPage(Consumer<AboutHelpPage> c){
    	AboutHelpPage p = new AboutHelpPage();
        c.accept(p);
        return this;
    }
    
    //About View Licenses Page 
    public TC60_Login_And_Verify_HamburgerMenuAndSettingsAboutHelpPage_Workflow aboutViewLicensesPage(Consumer<AboutViewLicensesPage> c){
    	AboutViewLicensesPage p = new AboutViewLicensesPage();
        c.accept(p);
        return this;
    }
    
    //FAQ Help Page 
    public TC60_Login_And_Verify_HamburgerMenuAndSettingsAboutHelpPage_Workflow faqHelpPage(Consumer<FAQHelpPage> c){
    	FAQHelpPage p = new FAQHelpPage();
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
