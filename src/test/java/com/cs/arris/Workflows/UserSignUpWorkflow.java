package com.cs.arris.Workflows;

import java.util.function.Consumer;

import com.cs.arris.Interface.Page;
import com.cs.arris.Pages.AccessResourcesOnDevicePage;
import com.cs.arris.Pages.AccessResourcesPage;
import com.cs.arris.Pages.CodeVerifiedPage;
import com.cs.arris.Pages.DeviceLocationPage;
import com.cs.arris.Pages.GetStartedPage;
import com.cs.arris.Pages.GrantPermissionsPage;
import com.cs.arris.Pages.EnterValidOTPPage;
import com.cs.arris.Pages.SelectYourDevicePage;
import com.cs.arris.Pages.SelectYourDevicePage2;
import com.cs.arris.Pages.SiginPage;
import com.cs.arris.Pages.SignupPage;
import com.cs.arris.Utilities.TestUtils;

public class UserSignUpWorkflow 
{
	TestUtils utils = new TestUtils();
	
	
    public static UserSignUpWorkflow getStartedPage(Consumer<GetStartedPage> c){
    	GetStartedPage p = new GetStartedPage();
        c.accept(p);
        return new UserSignUpWorkflow();
    }
    
    public UserSignUpWorkflow grantPermissionsPage(Consumer<GrantPermissionsPage> c){
    	GrantPermissionsPage p = new GrantPermissionsPage();
        c.accept(p);
        return this;
    }
    
    public UserSignUpWorkflow deviceLocationPage(Consumer<DeviceLocationPage> c){
    	DeviceLocationPage p = new DeviceLocationPage();
        c.accept(p);
        return this;
    }
    
//    //Only This Time
//    public UserSignUpWorkflow accessResourcesPage(Consumer<AccessResourcesPage> c){
//    	AccessResourcesPage p = new AccessResourcesPage();
//        c.accept(p);
//        return this;
//    }
    
    public UserSignUpWorkflow accessResourcesOnDevicePage(Consumer<AccessResourcesOnDevicePage> c){
    	AccessResourcesOnDevicePage p = new AccessResourcesOnDevicePage();
         c.accept(p);
        return this;
    }
    
    public UserSignUpWorkflow selectYourDevicePage(Consumer<SelectYourDevicePage> c){
    	SelectYourDevicePage p = new SelectYourDevicePage();
        c.accept(p);
        return this;
    }
    
    public UserSignUpWorkflow selectYourDevicePage2(Consumer<SelectYourDevicePage2> c){
    	SelectYourDevicePage2 p = new SelectYourDevicePage2();
        c.accept(p);
        return this;
    }
    
    public UserSignUpWorkflow welcomeSigninPage(Consumer<SiginPage> c){
    	SiginPage p = new SiginPage();
        c.accept(p);
        return this;
    }
    
    public UserSignUpWorkflow welcomeSignupPage(Consumer<SignupPage> c){
    	SignupPage p = new SignupPage();
    	this.waitForPageLoad(p);
        c.accept(p);
        return this;
    }
    
    public UserSignUpWorkflow otpVerificationPage(Consumer<EnterValidOTPPage> c){
    	EnterValidOTPPage p = new EnterValidOTPPage();
    	this.waitForPageLoad(p);
        c.accept(p);
        return this;
    }
    
    public UserSignUpWorkflow codeVerifiedPage(Consumer<CodeVerifiedPage> c){
    	CodeVerifiedPage p = new CodeVerifiedPage();
    	this.waitForPageLoad(p);
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
