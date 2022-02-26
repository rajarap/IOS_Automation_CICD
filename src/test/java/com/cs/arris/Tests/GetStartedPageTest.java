package com.cs.arris.Tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.cs.arris.Base.ParentClass;
import com.cs.arris.Pages.GetStartedPage;
import com.cs.arris.Utilities.TestUtils;

public class GetStartedPageTest extends ParentClass
{
	TestUtils utils = new TestUtils();
	GetStartedPage getStartedPageObject;
	SoftAssert softAssert = new SoftAssert();
	
	  @BeforeMethod
	  public void beforeMethod(Method m) 
	  {
		  getStartedPageObject = new GetStartedPage();
		  utils.log().info("\n" + "****** starting test:" + m.getName() + "******" + "\n");
	  }
	
//	  @Test(priority = 1)
//	  public void VerifyGetStartedMessage() 
//	  {
//		  System.out.println("Inside VerifyGetStartedMessage() method");
//		  
//		  String actualGetStartedMessage = getStartedPageObject.getGetStartedTitle();
//		  String expectedlGetStartedMessage = getStartedPageObject.getStrings().get("get_started_page_message");
//		  AssertJUnit.assertEquals(actualGetStartedMessage, expectedlGetStartedMessage);
//	  }
//	  
//	  @Test(priority = 2)
//	  public void clickGetStartedButton() 
//	  {
//		  String actualGetStartedButtonText = getStartedPageObject.getGetStartedButtonText();
//		  String expectedGetStartedButtonText = getStartedPageObject.getStrings().get("get_started_page_get_started_button_text");
//		  try
//		  {
//			  AssertJUnit.assertEquals(actualGetStartedButtonText, expectedGetStartedButtonText);
//		  } catch(Exception e)
//		  {
//			  e.printStackTrace();
//			  utils.log().error("\n" + "******* Get Started Button Text has changed ***********" + "\n");
//		  }
//		  getStartedPageObject.clickGetStartedButton();
//	  }
//	  
//	  @Test(priority = 3, description="Verify the Image on the Get Started Page...")
//	  public void VerifyGetStartedImage() 
//	  {
//		  boolean displayed = getStarted.getStartedImage();
//		  try
//		  {
//			  Assert.assertTrue(displayed);
//			  utils.log().error("\n" + "******* Get Started Image is displayed on the Page ***********" + "\n");
//		  } catch(Exception e)
//		  {
//			  e.printStackTrace();
//			  utils.log().error("\n" + "******* Get Started Image is not displayed on the Page ***********" + "\n");
//		  }
//	  }
}
