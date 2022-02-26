package com.cs.arris.Workflows;

import java.util.function.Consumer;

import com.cs.arris.Interface.Page;
import com.cs.arris.Pages.AccessResourcesOnDevicePage;
import com.cs.arris.Pages.BlueToothPage;
import com.cs.arris.Pages.CodeVerifiedPage;
import com.cs.arris.Pages.ConnectToWifiUsingRouterSSID;
import com.cs.arris.Pages.DeviceLocationPage;
import com.cs.arris.Pages.GetStartedPage;
import com.cs.arris.Pages.GrantPermissionsPage;
import com.cs.arris.Pages.NameYourNetwokSSIDPage;
import com.cs.arris.Pages.EnterValidOTPPage;
import com.cs.arris.Pages.ErrorCode_0000_1506_Warranty_Support_Page;
import com.cs.arris.Pages.ErrorCode_0002_1002_Internet_Connection_Not_Available_On_Mobile_Device;
import com.cs.arris.Pages.Error_0005_1200_Bluetooth_Connection_Failed_Page;
import com.cs.arris.Pages.GenerateEmailAndPasscode;
import com.cs.arris.Pages.OptimizeYourNetworkPage;
import com.cs.arris.Pages.PlugInMaxRouterPage;
import com.cs.arris.Pages.RetrieveOTPPage;
import com.cs.arris.Pages.SelectYourDevicePage;
import com.cs.arris.Pages.SelectYourDevicePage2;
import com.cs.arris.Pages.SetupHomeNetworkPage;
import com.cs.arris.Pages.SiginPage;
import com.cs.arris.Pages.SignupPage;
import com.cs.arris.Pages.ConnectMaxRouterToMobileDevicePage;
import com.cs.arris.Pages.ConnectMaxRouterToInternetPage;
import com.cs.arris.Pages.SystemFirmwareUpdatePage;
import com.cs.arris.Pages.UnPackYourBoxPage;
import com.cs.arris.Utilities.ValidOTP;
import com.cs.arris.Utilities.TestUtils;

public class TC02_EC_0002_1002_Disconnect_Wifi_On_Mobile_Workflow 
{
	TestUtils utils = new TestUtils();
	
	//GET STARTED
    public static TC02_EC_0002_1002_Disconnect_Wifi_On_Mobile_Workflow getStartedPage(Consumer<GetStartedPage> c){
    	GetStartedPage p = new GetStartedPage();
        c.accept(p);
        return new TC02_EC_0002_1002_Disconnect_Wifi_On_Mobile_Workflow();
    }
    
    //GRANT PERMISSIONS
    public TC02_EC_0002_1002_Disconnect_Wifi_On_Mobile_Workflow grantPermissionsPage(Consumer<GrantPermissionsPage> c){
    	GrantPermissionsPage p = new GrantPermissionsPage();
        c.accept(p);
        return this;
    }
    
    //Enable DEVICE LOCATION only this time
    public TC02_EC_0002_1002_Disconnect_Wifi_On_Mobile_Workflow deviceLocationPage(Consumer<DeviceLocationPage> c){
    	DeviceLocationPage p = new DeviceLocationPage();
        c.accept(p);
        return this;
    }
    
    //Access resource on device media-contacts
    public TC02_EC_0002_1002_Disconnect_Wifi_On_Mobile_Workflow accessResourcesOnDevicePage(Consumer<AccessResourcesOnDevicePage> c){
    	AccessResourcesOnDevicePage p = new AccessResourcesOnDevicePage();
         c.accept(p);
        return this;
    }
    
   //Access resource on device media-contacts
    public TC02_EC_0002_1002_Disconnect_Wifi_On_Mobile_Workflow internetConnectionNotAvailable(Consumer<ErrorCode_0002_1002_Internet_Connection_Not_Available_On_Mobile_Device> c){
    	ErrorCode_0002_1002_Internet_Connection_Not_Available_On_Mobile_Device p = new ErrorCode_0002_1002_Internet_Connection_Not_Available_On_Mobile_Device();
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
