package com.cs.arris.Workflows;

import java.util.function.Consumer;

import com.cs.arris.Interface.Page;
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
import com.cs.arris.Pages.HomePage;
import com.cs.arris.Pages.InstallAdditionalSatellitePage;
import com.cs.arris.Pages.MainDevicePage;
import com.cs.arris.Pages.NameYourNetwokSSIDPage;
import com.cs.arris.Pages.NetworkOptimizationDialog;
import com.cs.arris.Pages.NetworkPage;
import com.cs.arris.Pages.ConnectMaxRouterToMobileDevicePage;
import com.cs.arris.Pages.ConnectToBlueToothDialog;
import com.cs.arris.Pages.EnterValidOTPPage;
import com.cs.arris.Pages.ErrorCode_0000_1303_Router_Failed_To_Connect_To_Internet;
import com.cs.arris.Pages.ErrorCode_0000_1506_Warranty_Support_Page;
import com.cs.arris.Pages.ErrorCode_0015_1805_Something_Went_Wrong_Page;
import com.cs.arris.Pages.OptimizeYourNetworkPage;
import com.cs.arris.Pages.ParentalControlProfilesPage;
import com.cs.arris.Pages.PlugInMaxRouterPage;
import com.cs.arris.Pages.RetrieveOTPPage;
import com.cs.arris.Pages.SelectYourDevicePage;
import com.cs.arris.Pages.SelectYourDevicePage2;
import com.cs.arris.Pages.SetUpYourWiFiManagementPage;
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

public class TC51_Signin_And_Onboard_Workflow 
{
	
TestUtils utils = new TestUtils();
	
	//GET STARTED
    public static TC51_Signin_And_Onboard_Workflow getStartedPage(Consumer<GetStartedPage> c){
    	GetStartedPage p = new GetStartedPage();
        c.accept(p);
        return new TC51_Signin_And_Onboard_Workflow();
    }
    
    //GRANT PERMISSIONS
    public TC51_Signin_And_Onboard_Workflow grantPermissionsPage(Consumer<GrantPermissionsPage> c){
    	GrantPermissionsPage p = new GrantPermissionsPage();
        c.accept(p);
        return this;
    }
    
    //Enable DEVICE LOCATION only this time
    public TC51_Signin_And_Onboard_Workflow deviceLocationPage(Consumer<DeviceLocationPage> c){
    	DeviceLocationPage p = new DeviceLocationPage();
        c.accept(p);
        return this;
    }
    
   //Access resource on device media-contacts
    public TC51_Signin_And_Onboard_Workflow accessResourcesOnDevicePage(Consumer<AccessResourcesOnDevicePage> c){
    	AccessResourcesOnDevicePage p = new AccessResourcesOnDevicePage();
         c.accept(p);
        return this;
    }
    
    //select SURFboard MAX mesh
    public TC51_Signin_And_Onboard_Workflow selectYourDevicePage(Consumer<SelectYourDevicePage> c){
    	SelectYourDevicePage p = new SelectYourDevicePage();
        c.accept(p);
        return this;
    }
    
    //select max Pro AX11000
    public TC51_Signin_And_Onboard_Workflow selectYourDevicePage2(Consumer<SelectYourDevicePage2> c){
    	SelectYourDevicePage2 p = new SelectYourDevicePage2();
        c.accept(p);
        return this;
    }
    
    //Enter valid email id and login
    public TC51_Signin_And_Onboard_Workflow welcomeSigninPage(Consumer<SiginPage> c){
    	SiginPage p = new SiginPage();
        c.accept(p);
        return this;
    }
    
    //Get OTP from email 
    public TC51_Signin_And_Onboard_Workflow getOTPCode(Consumer<ValidOTP> c){
    	ValidOTP p = new ValidOTP();
    	c.accept(p);
    	return this;
    }
      
    
  //enter OTP
    public TC51_Signin_And_Onboard_Workflow enterOTPPage(Consumer<EnterValidOTPPage> c){
    	EnterValidOTPPage p = new EnterValidOTPPage();
        c.accept(p);
        return this;
    }
    
    
    //OTP verified
    public TC51_Signin_And_Onboard_Workflow codeVerifiedPage(Consumer<CodeVerifiedPage> c){
    	CodeVerifiedPage p = new CodeVerifiedPage();
    	this.waitForPageLoad(p);
        c.accept(p);
        return this;
    }
    
    //Something went wrong
    public TC51_Signin_And_Onboard_Workflow somethingWentWrongPage(Consumer<ErrorCode_0015_1805_Something_Went_Wrong_Page> c){
    	ErrorCode_0015_1805_Something_Went_Wrong_Page p = new ErrorCode_0015_1805_Something_Went_Wrong_Page();
    	this.waitForPageLoad(p);
        c.accept(p);
        return this;
    }
    
    //click skip optimization button
    public TC51_Signin_And_Onboard_Workflow optimizeYourNetworkPage(Consumer<OptimizeYourNetworkPage> c){
    	OptimizeYourNetworkPage p = new OptimizeYourNetworkPage();
        c.accept(p);
        return this;
    }
    
    //setup home network
    public TC51_Signin_And_Onboard_Workflow setUpHomeNetworkPage(Consumer<SetupHomeNetworkPage> c){
    	SetupHomeNetworkPage p = new SetupHomeNetworkPage();
        c.accept(p);
        return this;
    }
   
    //UnPack your Box
    public TC51_Signin_And_Onboard_Workflow unPackYourBoxPage(Consumer<UnPackYourBoxPage> c){
    	UnPackYourBoxPage p = new UnPackYourBoxPage();
        c.accept(p);
        return this;
    }
    
    //Plugin Max Router
    public TC51_Signin_And_Onboard_Workflow plugInYourMaxRouterPage(Consumer<PlugInMaxRouterPage> c){
    	PlugInMaxRouterPage p = new PlugInMaxRouterPage();
        c.accept(p);
        return this;
    }
   
    //Blue Tooth connection dialog
    public TC51_Signin_And_Onboard_Workflow connectBlueToothDialog(Consumer<ConnectToBlueToothDialog> c){
    	ConnectToBlueToothDialog p = new ConnectToBlueToothDialog();
        c.accept(p);
        return this;
    }
    
    //Max Router successfully connected to mobile
    public TC51_Signin_And_Onboard_Workflow maxRouterConnectedToMobilePage(Consumer<ConnectMaxRouterToMobileDevicePage> c){
    	ConnectMaxRouterToMobileDevicePage p = new ConnectMaxRouterToMobileDevicePage();
        c.accept(p);
        return this;
    }
    
    //Manually Connect the Max Router to the internet
    public TC51_Signin_And_Onboard_Workflow routerUnableToConnectToInternet(Consumer<ErrorCode_0000_1303_Router_Failed_To_Connect_To_Internet> c){
    	ErrorCode_0000_1303_Router_Failed_To_Connect_To_Internet p = new ErrorCode_0000_1303_Router_Failed_To_Connect_To_Internet();
        c.accept(p);
        return this;
    }
    
    //Max Router successfully connected to internet
    public TC51_Signin_And_Onboard_Workflow maxRouterConnectedToInternetPage(Consumer<ConnectMaxRouterToInternetPage> c){
    	ConnectMaxRouterToInternetPage p = new ConnectMaxRouterToInternetPage();
        c.accept(p);
        return this;
    }
    
  //Max Router firmware update
    public TC51_Signin_And_Onboard_Workflow systemFirmwareUpdatePage(Consumer<SystemFirmwareUpdatePage> c){
    	SystemFirmwareUpdatePage p = new SystemFirmwareUpdatePage();
        c.accept(p);
        return this;
    }
    
    //Warranty and Support Page
    public TC51_Signin_And_Onboard_Workflow warrantyAndSupportPage(Consumer<ErrorCode_0000_1506_Warranty_Support_Page> c){
    	ErrorCode_0000_1506_Warranty_Support_Page p = new ErrorCode_0000_1506_Warranty_Support_Page();
        c.accept(p);
        return this;
    }
    
    //Create SSID and password page
    public TC51_Signin_And_Onboard_Workflow nameYourNetworkPage(Consumer<NameYourNetwokSSIDPage> c){
    	NameYourNetwokSSIDPage p = new NameYourNetwokSSIDPage();
        c.accept(p);
        return this;
    }
        
  //Connection Wifi Required. Disconnect form local Wifi to router wifi
    public TC51_Signin_And_Onboard_Workflow connectNeeded(Consumer<ConnectionToWifiNeededPage> c){
    	ConnectionToWifiNeededPage p = new ConnectionToWifiNeededPage();
        c.accept(p);
        return this;
    }
    
    //Connect to Wifi via max rounter by providing the SSID and password
//    public W31OB_SignUp_Workflow connectToMaxRouterWifiPage(Consumer<ConnectToWifiUsingRouterSSID> c){
//    	ConnectToWifiUsingRouterSSID p = new ConnectToWifiUsingRouterSSID();
//        c.accept(p);
//        return this;
//    }
    
    //
    public TC51_Signin_And_Onboard_Workflow congratulations(Consumer<CongratulationsPage> c){
    	CongratulationsPage p = new CongratulationsPage();
        c.accept(p);
        return this;
    }
    
    //Setup Wifi Management
    public TC51_Signin_And_Onboard_Workflow setupWifi(Consumer<SetUpYourWiFiManagementPage> c){
    	SetUpYourWiFiManagementPage p = new SetUpYourWiFiManagementPage();
        c.accept(p);
        return this;
    }
    
    //Setup Wifi Management
    public TC51_Signin_And_Onboard_Workflow installSatellite(Consumer<InstallAdditionalSatellitePage> c){
    	InstallAdditionalSatellitePage p = new InstallAdditionalSatellitePage();
        c.accept(p);
        return this;
    }
    
    //Network Optimization dialog
    public TC51_Signin_And_Onboard_Workflow networkOptimization(Consumer<NetworkOptimizationDialog> c){
    	NetworkOptimizationDialog p = new NetworkOptimizationDialog();
        c.accept(p);
        return this;
    }
    
    //Setup Home Management
    public TC51_Signin_And_Onboard_Workflow homePage(Consumer<HomePage> c){
    	HomePage p = new HomePage();
        c.accept(p);
        return this;
    }
    
    //Main Device Page
    public TC51_Signin_And_Onboard_Workflow mainDevicePage(Consumer<MainDevicePage> c){
    	MainDevicePage p = new MainDevicePage();
        c.accept(p);
        return this;
    }

    //Devices Page
    public TC51_Signin_And_Onboard_Workflow devicesPage(Consumer<DevicesPage> c){
    	DevicesPage p = new DevicesPage();
        c.accept(p);
        return this;
    }
    
    //Device Signal Strength Leader Board Page
    public TC51_Signin_And_Onboard_Workflow deviceSignalStrengthPage(Consumer<DeviceSignalStrengthLeaderBoardPage> c){
    	DeviceSignalStrengthLeaderBoardPage p = new DeviceSignalStrengthLeaderBoardPage();
        c.accept(p);
        return this;
    }
       
    //Speed Test History Page
    public TC51_Signin_And_Onboard_Workflow speedTestHistoryPage(Consumer<SpeedTestHistoryPage> c){
    	SpeedTestHistoryPage p = new SpeedTestHistoryPage();
        c.accept(p);
        return this;
    }
    
    //Currently Blocked Devices Page
    public TC51_Signin_And_Onboard_Workflow currentlyBlockedDevicesPage(Consumer<CurrentlyBlockedDevicesPage> c){
    	CurrentlyBlockedDevicesPage p = new CurrentlyBlockedDevicesPage();
        c.accept(p);
        return this;
    }
    
    //Network Page
    public TC51_Signin_And_Onboard_Workflow networkPage(Consumer<NetworkPage> c){
    	NetworkPage p = new NetworkPage();
        c.accept(p);
        return this;
    }
    
    //Parental Control Page
    public TC51_Signin_And_Onboard_Workflow parentalControlPage(Consumer<ParentalControlProfilesPage> c){
    	ParentalControlProfilesPage p = new ParentalControlProfilesPage();
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
