package com.cs.arris.Tests;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.lang.reflect.Method;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cs.arris.Base.ParentClass;
import com.cs.arris.Pages.AccessResourcesOnDevicePage;
import com.cs.arris.Utilities.TestUtils;

public class AccessResourcesOnDevicePageTest extends ParentClass 
{
	TestUtils utils = new TestUtils();
	AccessResourcesOnDevicePage accessResourcesOnDevicePageObject;
	
	  @BeforeMethod
	  public void beforeMethod(Method m) 
	  {
		  accessResourcesOnDevicePageObject = new AccessResourcesOnDevicePage();
		  utils.log().info("\n" + "****** starting test:" + m.getName() + "******" + "\n");
	  }
	  
	  @Test(priority = 1)
	  public void clickAllowOnlyThisTimeLink()
	  {
		  accessResourcesOnDevicePageObject.clickAllowLink();;
	  }
	  

}
