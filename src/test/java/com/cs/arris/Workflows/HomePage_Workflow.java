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
import com.cs.arris.Pages.EnterValidOTPPage;
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

public class HomePage_Workflow 
{
	
TestUtils utils = new TestUtils();
	
	//GET STARTED
    public static HomePage_Workflow homePage(Consumer<HomePage> c){
    	HomePage p = new HomePage();
        c.accept(p);
        return new HomePage_Workflow();
    }
    
    //Main Device Page
    public HomePage_Workflow mainDevicePage(Consumer<MainDevicePage> c){
    	MainDevicePage p = new MainDevicePage();
        c.accept(p);
        return this;
    }

    //Devices Page
    public HomePage_Workflow devicesPage(Consumer<DevicesPage> c){
    	DevicesPage p = new DevicesPage();
        c.accept(p);
        return this;
    }
    
    //Device Signal Strength Leader Board Page
    public HomePage_Workflow deviceSignalStrengthPage(Consumer<DeviceSignalStrengthLeaderBoardPage> c){
    	DeviceSignalStrengthLeaderBoardPage p = new DeviceSignalStrengthLeaderBoardPage();
        c.accept(p);
        return this;
    }
       
    //Speed Test History Page
    public HomePage_Workflow speedTestHistoryPage(Consumer<SpeedTestHistoryPage> c){
    	SpeedTestHistoryPage p = new SpeedTestHistoryPage();
        c.accept(p);
        return this;
    }
    
    //Currently Blocked Devices Page
    public HomePage_Workflow currentlyBlockedDevicesPage(Consumer<CurrentlyBlockedDevicesPage> c){
    	CurrentlyBlockedDevicesPage p = new CurrentlyBlockedDevicesPage();
        c.accept(p);
        return this;
    }
    
    //Network Page
    public HomePage_Workflow networkPage(Consumer<NetworkPage> c){
    	NetworkPage p = new NetworkPage();
        c.accept(p);
        return this;
    }
    
    //Parental Control Page
    public HomePage_Workflow parentalControlPage(Consumer<ParentalControlProfilesPage> c){
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
