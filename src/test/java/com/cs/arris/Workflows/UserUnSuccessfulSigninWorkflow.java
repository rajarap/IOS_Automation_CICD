package com.cs.arris.Workflows;

import java.util.function.Consumer;

import com.cs.arris.Interface.Page;
import com.cs.arris.Pages.AccessResourcesOnDevicePage;
import com.cs.arris.Pages.AccessResourcesPage;
import com.cs.arris.Pages.DeviceLocationPage;
import com.cs.arris.Pages.GetStartedPage;
import com.cs.arris.Pages.GrantPermissionsPage;
import com.cs.arris.Pages.SelectYourDevicePage;
import com.cs.arris.Pages.SelectYourDevicePage2;
import com.cs.arris.Pages.SiginPage;
import com.cs.arris.Pages.SignupPage;
import com.cs.arris.Utilities.TestUtils;

public class UserUnSuccessfulSigninWorkflow 
{
TestUtils utils = new TestUtils();
	
	//Get Started
    public static UserUnSuccessfulSigninWorkflow getStartedPage(Consumer<GetStartedPage> c){
    	GetStartedPage p = new GetStartedPage();
        c.accept(p);
        return new UserUnSuccessfulSigninWorkflow();
    }
    
    //continue
    public UserUnSuccessfulSigninWorkflow grantPermissionsPage(Consumer<GrantPermissionsPage> c){
    	GrantPermissionsPage p = new GrantPermissionsPage();
        c.accept(p);
        return this;
    }
    
    //only This Time
    public UserUnSuccessfulSigninWorkflow deviceLocationPage(Consumer<DeviceLocationPage> c){
    	DeviceLocationPage p = new DeviceLocationPage();
        c.accept(p);
        return this;
    }
    
    //Only this Time
//    public UserSigninWorkflow accessResourcesPage(Consumer<AccessResourcesPage> c){
//    	AccessResourcesPage p = new AccessResourcesPage();
//        c.accept(p);
//        return this;
//    }
//  
    //Allow
    public UserUnSuccessfulSigninWorkflow accessResourcesOnDevicePage(Consumer<AccessResourcesOnDevicePage> c){
    	AccessResourcesOnDevicePage p = new AccessResourcesOnDevicePage();
        c.accept(p);
        return this;
    }
    
    //mesh
    public UserUnSuccessfulSigninWorkflow selectYourDevicePage(Consumer<SelectYourDevicePage> c){
    	SelectYourDevicePage p = new SelectYourDevicePage();
        c.accept(p);
        return this;
    }
    
    //maxPro
    public UserUnSuccessfulSigninWorkflow selectYourDevicePage2(Consumer<SelectYourDevicePage2> c){
    	SelectYourDevicePage2 p = new SelectYourDevicePage2();
        c.accept(p);
        return this;
    }
    
    //Enter invalid email id
    public UserUnSuccessfulSigninWorkflow welcomeSigninPage(Consumer<SiginPage> c){
    	SiginPage p = new SiginPage();
    	this.waitForPageLoad(p);
        c.accept(p);
        return this;
    }
    
    //singup page appears since there is no user account matching the invalid email id
    public UserUnSuccessfulSigninWorkflow welcomeSignupPage(Consumer<SignupPage> c){
    	SignupPage p = new SignupPage();
    	this.waitForPageLoad(p);
        c.accept(p);
        return this;
    }
    
    //handle page sync techniques here
    private void waitForPageLoad(Page p){
        System.out.println("------------------------------");
        System.out.println("Waiting for " + p.toString() + " to load" );
        p.isAt();
    }
}
