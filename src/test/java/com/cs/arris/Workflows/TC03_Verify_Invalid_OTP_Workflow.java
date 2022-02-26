package com.cs.arris.Workflows;

import java.util.function.Consumer;

import com.cs.arris.Interface.Page;
import com.cs.arris.Pages.AccessResourcesOnDevicePage;
import com.cs.arris.Pages.CodeVerifiedPage;
import com.cs.arris.Pages.ConnectToWifiUsingRouterSSID;
import com.cs.arris.Pages.DeviceLocationPage;
import com.cs.arris.Pages.GetStartedPage;
import com.cs.arris.Pages.GrantPermissionsPage;
import com.cs.arris.Pages.NameYourNetwokSSIDPage;
import com.cs.arris.Pages.EnterValidOTPPage;
import com.cs.arris.Pages.ErrorCode_0000_1506_Warranty_Support_Page;
import com.cs.arris.Pages.ErrorCode_0015_1805_Something_Went_Wrong_Page;
import com.cs.arris.Pages.Error_0005_1200_Bluetooth_Connection_Failed_Page;
import com.cs.arris.Pages.GenerateEmailAndPasscode;
import com.cs.arris.Pages.OptimizeYourNetworkPage;
import com.cs.arris.Pages.PlugInMaxRouterPage;
import com.cs.arris.Pages.ResendOTPDialog;
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
import com.cs.arris.Pages.ValidationCodePage;
import com.cs.arris.Utilities.InValidOTP;
import com.cs.arris.Utilities.ValidOTP;
import com.cs.arris.Utilities.TestUtils;

public class TC03_Verify_Invalid_OTP_Workflow 
{
	TestUtils utils = new TestUtils();
	
	//GET STARTED
    public static TC03_Verify_Invalid_OTP_Workflow getStartedPage(Consumer<GetStartedPage> c){
    	GetStartedPage p = new GetStartedPage();
        c.accept(p);
        return new TC03_Verify_Invalid_OTP_Workflow();
    }
    
    //GRANT PERMISSIONS
    public TC03_Verify_Invalid_OTP_Workflow grantPermissionsPage(Consumer<GrantPermissionsPage> c){
    	GrantPermissionsPage p = new GrantPermissionsPage();
        c.accept(p);
        return this;
    }
    
    //Enable DEVICE LOCATION only this time
    public TC03_Verify_Invalid_OTP_Workflow deviceLocationPage(Consumer<DeviceLocationPage> c){
    	DeviceLocationPage p = new DeviceLocationPage();
        c.accept(p);
        return this;
    }
    
   //Access resource on device media-contacts
    public TC03_Verify_Invalid_OTP_Workflow accessResourcesOnDevicePage(Consumer<AccessResourcesOnDevicePage> c){
    	AccessResourcesOnDevicePage p = new AccessResourcesOnDevicePage();
         c.accept(p);
        return this;
    }
    
    //select SURFboard MAX mesh
    public TC03_Verify_Invalid_OTP_Workflow selectYourDevicePage(Consumer<SelectYourDevicePage> c){
    	SelectYourDevicePage p = new SelectYourDevicePage();
        c.accept(p);
        return this;
    }
    
    //select max Pro AX11000
    public TC03_Verify_Invalid_OTP_Workflow selectYourDevicePage2(Consumer<SelectYourDevicePage2> c){
    	SelectYourDevicePage2 p = new SelectYourDevicePage2();
        c.accept(p);
        return this;
    }
       
    //click Signup on the Sigin page
    public TC03_Verify_Invalid_OTP_Workflow welcomeSigninPage(Consumer<SiginPage> c){
    	SiginPage p = new SiginPage();
        c.accept(p);
        return this;
    }
     
    //Get OTP from email 
    public TC03_Verify_Invalid_OTP_Workflow getOTPCode(Consumer<InValidOTP> c){
    	InValidOTP p = new InValidOTP();
    	c.accept(p);
    	return this;
    }
      
    //enter OTP
    public TC03_Verify_Invalid_OTP_Workflow enterOTPPage(Consumer<EnterValidOTPPage> c){
    	EnterValidOTPPage p = new EnterValidOTPPage();
        c.accept(p);
        return this;
    }
    
    //Open Resend OTP dialog (onclick Resend button on enterOTP Page
    public TC03_Verify_Invalid_OTP_Workflow resendOTPDialog(Consumer<ResendOTPDialog> c){
    	ResendOTPDialog p = new ResendOTPDialog();
        c.accept(p);
        return this;
    }
    
    //Open validation page (onclick Idid not recieve link on Resend OTP dialog
    public TC03_Verify_Invalid_OTP_Workflow validationCodePage(Consumer<ValidationCodePage> c){
    	ValidationCodePage p = new ValidationCodePage();
        c.accept(p);
        return this;
    }
    
    //OTP verified
    public TC03_Verify_Invalid_OTP_Workflow codeVerifiedPage(Consumer<CodeVerifiedPage> c){
    	CodeVerifiedPage p = new CodeVerifiedPage();
        c.accept(p);
        return this;
    }
    
    //Something went wrong
    public TC03_Verify_Invalid_OTP_Workflow somethingWentWrongPage(Consumer<ErrorCode_0015_1805_Something_Went_Wrong_Page> c){
    	ErrorCode_0015_1805_Something_Went_Wrong_Page p = new ErrorCode_0015_1805_Something_Went_Wrong_Page();
    	this.waitForPageLoad(p);
        c.accept(p);
        return this;
    }
    
    //Check if optimization page is displayed
    public TC03_Verify_Invalid_OTP_Workflow optimizeYourNetworkPage(Consumer<OptimizeYourNetworkPage> c){
    	OptimizeYourNetworkPage p = new OptimizeYourNetworkPage();
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
