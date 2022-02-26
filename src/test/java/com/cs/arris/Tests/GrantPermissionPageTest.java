package com.cs.arris.Tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cs.arris.Base.ParentClass;
import com.cs.arris.Pages.GrantPermissionsPage;
import com.cs.arris.Utilities.TestUtils;

public class GrantPermissionPageTest extends ParentClass 
{
	TestUtils utils = new TestUtils();
	GrantPermissionsPage grantPermissionsPageObject;
	
	  @BeforeMethod
	  public void beforeMethod(Method m) 
	  {
		  grantPermissionsPageObject = new GrantPermissionsPage();
		  utils.log().info("\n" + "****** starting test:" + m.getName() + "******" + "\n");
	  }
	  
//	  GrantPermissionTest(GrantPermissionsPage obj)
//	  {
//		  grantPermissionsPageObject = obj;
//	  }
	  
	  @Test(priority = 1, description="Verifying Help Icon on Grant Permissions Page...")
	  public void VerifyHelpIcon() 
	  {
		  boolean helpIcon = grantPermissionsPageObject.VerifyHelpIcon();
		  if (helpIcon)
			  utils.log().info("Help Icon is displayed on the Grant Permissions Page");
		  else
			  utils.log().info("Help Icon is not displayed on the Grant Permissions Page");
	  }
	  
	  @Test(priority = 2, description="Verifying Grant Access Permissions Message...")
	  public void VerifyGrantAccessPermissionMessage() 
	  {
		  String actualGrantAccessPermissionMessage = grantPermissionsPageObject.getGrantAccessPermissionMessage();
		  String expectedGrantAccessPermissionMessage = getStrings().get("grant_access_permission_page_message");
		  AssertJUnit.assertEquals(actualGrantAccessPermissionMessage, expectedGrantAccessPermissionMessage);
	  }
	  
	  @Test(priority = 3, description="Verifying Access to Resources Message...")
	  public void VerifyAccessToResourcesMessage() 
	  {
		  String actualAccessToResourcesMessage = grantPermissionsPageObject.getAccessToResourceMessage();
		  String expectedAccessToResourcesMessage = getStrings().get("grant_access_permission_page_access_to_resources");
		  AssertJUnit.assertEquals(actualAccessToResourcesMessage, expectedAccessToResourcesMessage);
	  }
	  
	  @Test(priority = 4, description="Verifying Location Message...")
	  public void VerifyLocationMessage() 
	  {
		  String actualLocationMessage = grantPermissionsPageObject.getLocationMessage();
		  String expectedLocationMessage = getStrings().get("grant_access_permission_page_location_message");
		  AssertJUnit.assertEquals(actualLocationMessage, expectedLocationMessage);
	  }
	  
	  @Test(priority = 5, description="Verifying Location Text...")
	  public void VerifyLocationText() 
	  {
		  String actualLocationText = grantPermissionsPageObject.getLocationText();
		  String expectedLocationText = getStrings().get("grant_access_permission_page_location_message");
		  AssertJUnit.assertEquals(actualLocationText, expectedLocationText);
	  }
	  
	  @Test(priority = 6, description="Verifying Location Icon...")
	  public void VerifyLocationIcon() 
	  {
		  boolean locationIcon = grantPermissionsPageObject.VerifyLocationIcon();
		  if (locationIcon)
			  utils.log().info("Location Icon is displayed on the Grant Permissions Page");
		  else
			  utils.log().info("Location Icon is not displayed on the Grant Permissions Page");
	  }
	  
	  @Test(priority = 7, description="Verifying Storage Message...")
	  public void VerifyStorageMessage() 
	  {
		  String actualStorageMessage = grantPermissionsPageObject.getStorageMessage();
		  String expectedStorageMessage = getStrings().get("grant_access_permission_page_storage_message");
		  AssertJUnit.assertEquals(actualStorageMessage, expectedStorageMessage);
	  }
	  
	  @Test(priority = 8, description="Verifying Storage Text...")
	  public void VerifyStorageText() 
	  {
		  String actualStorageText = grantPermissionsPageObject.getLocationText();
		  String expectedStorageText = getStrings().get("grant_access_permission_page_storage_text");
		  AssertJUnit.assertEquals(actualStorageText, expectedStorageText);
	  }
	  
	  @Test(priority = 9, description="Verifying Storage Icon...")
	  public void VerifyStorageIcon() 
	  {
		  boolean storageIcon = grantPermissionsPageObject.VerifyStorageIcon();
		  if (storageIcon)
			  utils.log().info("Storage Icon is displayed on the Grant Permissions Page");
		  else
			  utils.log().info("Storage Icon is not displayed on the Grant Permissions Page");
	  }
	  
	  @Test(priority = 10, description="Verifying Phone Message...")
	  public void VerifyPhonenMessage() 
	  {
		  String actualPhoneMessage = grantPermissionsPageObject.getPhoneMessage();
		  String expectedPhoneMessage = getStrings().get("grant_access_permission_page_phone_message");
		  AssertJUnit.assertEquals(actualPhoneMessage, expectedPhoneMessage);
	  }
	  
	  @Test(priority = 11, description="Verifying Phone Text...")
	  public void VerifyPhoneText() 
	  {
		  String actualPhoneText = grantPermissionsPageObject.getPhoneText();
		  String expectedPhoneText = getStrings().get("rant_access_permission_page_phone_text");
		  AssertJUnit.assertEquals(actualPhoneText, expectedPhoneText);
	  }
	  
	  @Test(priority = 12, description="Verifying Phone Icon...")
	  public void VerifyPhoneIcon() 
	  {
		  boolean phoneIcon = grantPermissionsPageObject.VerifyPhoneIcon();
		  if (phoneIcon)
			  utils.log().info("Phone Icon is displayed on the Grant Permissions Page");
		  else
			  utils.log().info("Phone Icon is not displayed on the Grant Permissions Page");
	  }
	  
	  @Test(priority = 13, description="Verify and click the Continue button...")
	  public void clickOnContinuedButton() 
	  {
		  String actualContinueButtonText = grantPermissionsPageObject.getContinueButtonText();
		  String expectedContinueButtonText = getStrings().get("grant_access_permission_page_continue_button_text");
		  try
		  {
			  AssertJUnit.assertEquals(actualContinueButtonText, expectedContinueButtonText);
		  } catch(Exception e)
		  {
			  e.printStackTrace();
			  utils.log().error("\n" + "******* Continue Button Text has changed ***********" + "\n");
		  }
		  
		  grantPermissionsPageObject.clickContinueButton();
	  }
	  
	  @AfterMethod
	  public void afterMethod() 
	  {		  
	  }
	  
	  @AfterClass
	  public void afterClass() 
	  {
	  }

}
