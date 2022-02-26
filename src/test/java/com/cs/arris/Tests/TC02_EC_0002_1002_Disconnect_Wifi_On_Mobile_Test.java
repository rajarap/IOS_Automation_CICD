package com.cs.arris.Tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.IAssert;

import com.cs.arris.Base.ParentClass;
import com.cs.arris.Pages.BlueToothPage;
import com.cs.arris.Utilities.TestUtils;
import com.cs.arris.Workflows.TC01_EC_0001_1201_Disconnect_Bluetooth_On_Mobile_Workflow;
import com.cs.arris.Workflows.TC03_Verify_Invalid_OTP_Workflow;
import com.cs.arris.Workflows.TC02_EC_0002_1002_Disconnect_Wifi_On_Mobile_Workflow;
import com.cs.arris.Workflows.TC51_Signin_And_Onboard_Workflow;

import io.appium.java_client.android.AndroidDriver;

public class TC02_EC_0002_1002_Disconnect_Wifi_On_Mobile_Test extends ParentClass
{
	TestUtils utils = new TestUtils();
	String email;
	String passCode;
	String expectedText;
	String expectedMessage;
	String expected_error_code;
	String expectedTryAgainText;
	String expectedTroubleshootText;
	
	 @BeforeClass
	 public void beforeClass() throws Exception 
	 {
		 try 
	   	  	{
			  String dataFileName = "error_codes/error_codes.xml";
			  utils.log().info("Loading...Error Code XML file");
			  super.loadErrorCodesXML(dataFileName);
			  this.expected_error_code = getErrorCode().get("0002-1002");
			  this.expectedText = getErrorCode().get("internet_connection_not_available");
			  this.expectedMessage = getErrorCode().get("internet_connection_not_available_message");
			  this.expectedTryAgainText = getErrorCode().get("try_again_button");
			  this.expectedTroubleshootText = getErrorCode().get("troubleshoot_button");
			  utils.log().info("Retrieved...Internet Not Avialable Error code from XML file");
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
	  public void EC_0002_1002_Disconnect_Wifi_On_Mobile_Test()
	  {
		  try
		  {
			utils.log().info("Turning OFF Wifi..........");
			((AndroidDriver) super.getDriver()).toggleWifi(); //trun off wifi
			utils.log().info("Wifi Turned OFF");
			super.pause(2);
			TC02_EC_0002_1002_Disconnect_Wifi_On_Mobile_Workflow.getStartedPage(getStarted -> {
			  getStarted.clickGetStartedButton();
			}).grantPermissionsPage(grantPermission -> {
			  grantPermission.clickContinueButton();
			}).deviceLocationPage(deviceLocation -> {
			  deviceLocation.clickOnlyThisTimeLink();
			}).accessResourcesOnDevicePage(accessResoucesOnDevice -> {
			  accessResoucesOnDevice.clickAllowLink();
			}).internetConnectionNotAvailable(nowifi -> {
			  String actualText = nowifi.getTitleText();
			  String actualMessage = nowifi.getDescriptionMessage();
			  String actualErrCode = nowifi.getErrCode();
			  String actualTryAgainButtonText = nowifi.getTryAgainButtonText();
			  
			  Assert.assertEquals(actualText, expectedText);
			  Assert.assertEquals(actualMessage, expectedMessage);
			  Assert.assertEquals(actualErrCode, expected_error_code);
			  Assert.assertEquals(actualTryAgainButtonText, expectedTryAgainText);
			  
			  nowifi.clickTryAgainButton();
			  String actualTroubleshootButtonText = nowifi.getTroubleShootButtonText();
			  Assert.assertEquals(actualTroubleshootButtonText, expectedTroubleshootText);
  		  	});
		  }catch(Exception e){e.printStackTrace();}
		  finally {
			utils.log().info("Turning ON Wifi..........");
			((AndroidDriver) super.getDriver()).toggleWifi(); //trun on wifi
			utils.log().info("Wifi Turned ON");
		  }
	  }
}
