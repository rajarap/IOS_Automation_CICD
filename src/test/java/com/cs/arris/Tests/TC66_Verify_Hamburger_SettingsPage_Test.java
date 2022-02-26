package com.cs.arris.Tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.lang.reflect.Method;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cs.arris.Base.ParentClass;
import com.cs.arris.Pages.HomePage;
import com.cs.arris.Pages.SiginPage;
import com.cs.arris.Utilities.TestUtils;
import com.cs.arris.Workflows.HomePage_Workflow;
import com.cs.arris.Workflows.TC52_Login_And_Verify_HomePage_Workflow;
import com.cs.arris.Workflows.TC53_Login_And_Verify_DevicesPage_Workflow;
import com.cs.arris.Workflows.TC60_Login_And_Verify_HamburgerMenuAndSettingsAboutHelpPage_Workflow;

 


public class TC66_Verify_Hamburger_SettingsPage_Test extends ParentClass
{
	TestUtils utils = new TestUtils();
	String firstName;
	String lastName;
	String email;
	String passCode;
	String ssid;
	String ssidpass;
	String udid;

	 @BeforeClass
	 public void beforeClass() throws Exception 
	 {
		 try 
	   	  	{
			  String dataFileName = "testdata/signup";
			  utils.log().info("Loading...Sign Up Test Data");
			  super.loadTestData(dataFileName);
			  
			  this.firstName = properties.getProperty("firstname");
			  utils.log().info("First Name : " + this.firstName);

			  this.lastName = properties.getProperty("lastname");
			  utils.log().info("Last Name : " + this.lastName);
			  
			  this.email = properties.getProperty("email");
			  utils.log().info("Email address : " + this.email);
			  
			  this.udid = properties.getProperty("udid");
			  utils.log().info("UDID : " + this.udid);
			  
			  utils.log().info("Retrieved...Sign Up Test Data");
			} catch(Exception e) {
			 e.printStackTrace();
		} 
     }
	
	
	  @BeforeMethod
	  public void beforeMethod(Method m) 
	  {
		   utils.log().info("\n" + "****** starting test:" + m.getName() + "******" + "\n");
	  }
	  
	  
	  @Test(priority = 1)
	  public void Verify_Hamburger_Settings_Page()
	  {
		  
//		  TC66_Verify_Hamburger_SettingsAboutHelpPage_Workflow.homePage(home -> {
//		  try
//			 {
//				  if(home.okButton.isDisplayed())
//					  home.clickOkButton();
//			  }catch(Exception e){ e.getMessage(); }
//			 if(home.isAt())
//			 {
//				 home.clickNavigationButton();
//			 }
//	  		}).hamburgerMenuPage(hamburger -> {
//	  			if(hamburger.isAt())
//	  				hamburger.clickSettingsButton();
//	  		}).settingsPage(settings -> {
//	  			settings.verifyUIOnSettingsPage();
//	  			String emailAddress = settings.getUserEmailAddress();
//	  			String username = settings.getUserAccountName();
//	  			Assert.assertEquals(this.email, emailAddress);
//	  			String uname = this.firstName+" "+this.lastName;
//	  			Assert.assertEquals(uname, username);
//		  });
	  }
}