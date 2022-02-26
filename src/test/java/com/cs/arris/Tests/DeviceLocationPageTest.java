package com.cs.arris.Tests;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.lang.reflect.Method;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cs.arris.Base.ParentClass;
import com.cs.arris.Pages.DeviceLocationPage;
import com.cs.arris.Utilities.TestUtils;

public class DeviceLocationPageTest extends ParentClass 
{
	TestUtils utils = new TestUtils();
	DeviceLocationPage deviceLocationPageObject;
	
	  @BeforeMethod
	  public void beforeMethod(Method m) 
	  {
		  deviceLocationPageObject = new DeviceLocationPage();
		  utils.log().info("\n" + "****** starting test:" + m.getName() + "******" + "\n");
	  }
	  
	  @Test(priority = 1)
	  public void clickWhileUsingThisAppDeviceLocation()
	  {
		  deviceLocationPageObject.clickWhileUsingTheAppLink();
	  }
	  
	  @Test(priority = 2, enabled=false)
	  public void clickDenyDeviceLocation()
	  {
		  deviceLocationPageObject.clickDenyLink();
	  }
	  
	  @Test(priority = 3, enabled=false)
	  public void clickOnlyThisTimeDeviceLocation()
	  {
		  deviceLocationPageObject.clickOnlyThisTimeLink();
	  }

}
