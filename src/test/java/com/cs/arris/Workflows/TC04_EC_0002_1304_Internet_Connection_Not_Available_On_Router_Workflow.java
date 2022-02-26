package com.cs.arris.Workflows;

import java.util.function.Consumer;

import com.cs.arris.Interface.Page;
import com.cs.arris.Pages.AccessResourcesOnDevicePage;
import com.cs.arris.Pages.CodeVerifiedPage;
import com.cs.arris.Pages.CongratulationsPage;
import com.cs.arris.Pages.ConnectToWifiUsingRouterSSID;
import com.cs.arris.Pages.ConnectionToWifiNeededPage;
import com.cs.arris.Pages.DeviceLocationPage;
import com.cs.arris.Pages.GetStartedPage;
import com.cs.arris.Pages.GrantPermissionsPage;
import com.cs.arris.Pages.HomePage;
import com.cs.arris.Pages.InstallAdditionalSatellitePage;
import com.cs.arris.Pages.NameYourNetwokSSIDPage;
import com.cs.arris.Pages.NetworkOptimizationDialog;
import com.cs.arris.Pages.ConnectMaxRouterToMobileDevicePage;
import com.cs.arris.Pages.EnterValidOTPPage;
import com.cs.arris.Pages.ErrorCode_0000_1506_Warranty_Support_Page;
import com.cs.arris.Pages.ErrorCode_0015_1805_Something_Went_Wrong_Page;
import com.cs.arris.Pages.OptimizeYourNetworkPage;
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
import com.cs.arris.Utilities.ValidOTP;
import com.cs.arris.Utilities.TestUtils;
import com.cs.arris.Utilities.ValidOTP;

public class TC04_EC_0002_1304_Internet_Connection_Not_Available_On_Router_Workflow 
{
	
TestUtils utils = new TestUtils();
	
	//GET STARTED
    public static TC04_EC_0002_1304_Internet_Connection_Not_Available_On_Router_Workflow getStartedPage(Consumer<GetStartedPage> c){
    	GetStartedPage p = new GetStartedPage();
        c.accept(p);
        return new TC04_EC_0002_1304_Internet_Connection_Not_Available_On_Router_Workflow();
    }
    
    //GRANT PERMISSIONS
    public TC04_EC_0002_1304_Internet_Connection_Not_Available_On_Router_Workflow grantPermissionsPage(Consumer<GrantPermissionsPage> c){
    	GrantPermissionsPage p = new GrantPermissionsPage();
        c.accept(p);
        return this;
    }
    
    //Enable DEVICE LOCATION only this time
    public TC04_EC_0002_1304_Internet_Connection_Not_Available_On_Router_Workflow deviceLocationPage(Consumer<DeviceLocationPage> c){
    	DeviceLocationPage p = new DeviceLocationPage();
        c.accept(p);
        return this;
    }
    
   //Access resource on device media-contacts
    public TC04_EC_0002_1304_Internet_Connection_Not_Available_On_Router_Workflow accessResourcesOnDevicePage(Consumer<AccessResourcesOnDevicePage> c){
    	AccessResourcesOnDevicePage p = new AccessResourcesOnDevicePage();
         c.accept(p);
        return this;
    }
    
    //select SURFboard MAX mesh
    public TC04_EC_0002_1304_Internet_Connection_Not_Available_On_Router_Workflow selectYourDevicePage(Consumer<SelectYourDevicePage> c){
    	SelectYourDevicePage p = new SelectYourDevicePage();
        c.accept(p);
        return this;
    }
    
    //select max Pro AX11000
    public TC04_EC_0002_1304_Internet_Connection_Not_Available_On_Router_Workflow selectYourDevicePage2(Consumer<SelectYourDevicePage2> c){
    	SelectYourDevicePage2 p = new SelectYourDevicePage2();
        c.accept(p);
        return this;
    }
    
    //Enter valid email id and login
    public TC04_EC_0002_1304_Internet_Connection_Not_Available_On_Router_Workflow welcomeSigninPage(Consumer<SiginPage> c){
    	SiginPage p = new SiginPage();
        c.accept(p);
        return this;
    }
    
    //Get OTP from email 
    public TC04_EC_0002_1304_Internet_Connection_Not_Available_On_Router_Workflow getOTPCode(Consumer<ValidOTP> c){
    	ValidOTP p = new ValidOTP();
    	c.accept(p);
    	return this;
    }
      
    
  //enter OTP
    public TC04_EC_0002_1304_Internet_Connection_Not_Available_On_Router_Workflow enterOTPPage(Consumer<EnterValidOTPPage> c){
    	EnterValidOTPPage p = new EnterValidOTPPage();
        c.accept(p);
        return this;
    }
    
    
    //OTP verified
    public TC04_EC_0002_1304_Internet_Connection_Not_Available_On_Router_Workflow codeVerifiedPage(Consumer<CodeVerifiedPage> c){
    	CodeVerifiedPage p = new CodeVerifiedPage();
    	this.waitForPageLoad(p);
        c.accept(p);
        return this;
    }
    
    //Something went wrong
    public TC04_EC_0002_1304_Internet_Connection_Not_Available_On_Router_Workflow somethingWentWrongPage(Consumer<ErrorCode_0015_1805_Something_Went_Wrong_Page> c){
    	ErrorCode_0015_1805_Something_Went_Wrong_Page p = new ErrorCode_0015_1805_Something_Went_Wrong_Page();
    	this.waitForPageLoad(p);
        c.accept(p);
        return this;
    }
    
    //click skip optimization button
    public TC04_EC_0002_1304_Internet_Connection_Not_Available_On_Router_Workflow optimizeYourNetworkPage(Consumer<OptimizeYourNetworkPage> c){
    	OptimizeYourNetworkPage p = new OptimizeYourNetworkPage();
        c.accept(p);
        return this;
    }
    
    //setup home network
    public TC04_EC_0002_1304_Internet_Connection_Not_Available_On_Router_Workflow setUpHomeNetworkPage(Consumer<SetupHomeNetworkPage> c){
    	SetupHomeNetworkPage p = new SetupHomeNetworkPage();
        c.accept(p);
        return this;
    }
   
    //UnPack your Box
    public TC04_EC_0002_1304_Internet_Connection_Not_Available_On_Router_Workflow unPackYourBoxPage(Consumer<UnPackYourBoxPage> c){
    	UnPackYourBoxPage p = new UnPackYourBoxPage();
        c.accept(p);
        return this;
    }
    
    //Plugin Max Router
    public TC04_EC_0002_1304_Internet_Connection_Not_Available_On_Router_Workflow plugInYourMaxRouterPage(Consumer<PlugInMaxRouterPage> c){
    	PlugInMaxRouterPage p = new PlugInMaxRouterPage();
        c.accept(p);
        return this;
    }
    
    //Max Router successfully connected to mobile via bluetooth
    public TC04_EC_0002_1304_Internet_Connection_Not_Available_On_Router_Workflow maxRouterConnectedToMobilePage(Consumer<ConnectMaxRouterToMobileDevicePage> c){
    	ConnectMaxRouterToMobileDevicePage p = new ConnectMaxRouterToMobileDevicePage();
        c.accept(p);
        return this;
    }
    
    //Max Router could not establish a connection with Internet
    public TC04_EC_0002_1304_Internet_Connection_Not_Available_On_Router_Workflow maxRouterConnectedToInternetPage(Consumer<ConnectMaxRouterToInternetPage> c){
    	ConnectMaxRouterToInternetPage p = new ConnectMaxRouterToInternetPage();
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
