package com.cs.arris.Tests;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.lang.reflect.Method;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cs.arris.Base.ParentClass;
import com.cs.arris.Pages.SamplePage;
import com.cs.arris.Utilities.TestUtils;

public class SampleTest extends ParentClass {
	TestUtils utils = new TestUtils();
	SamplePage sample;
	
	  @BeforeMethod
	  public void beforeMethod(Method m) {
		  sample = new SamplePage();
		  utils.log().info("\n" + "****** starting test:" + m.getName() + "******" + "\n");
	  }
	  
	  @Test(priority = 1)
	  public void displayAppiumURL() {
		  utils.log("Verifying appium URL");
		  sample.displayAppiumURL();
		  
	  }
	  
	  @Test(priority = 2)
	  public void displayAppLocation() {
		  utils.log("Verifying app location");
		  sample.displayAppLocation();
	  }

	  @Test(priority = 3)
	  public void displayAutomationName() {
		  utils.log("Verifying automation name");
		  sample.displayAutomationName();
	  }
	  
	  @Test(priority = 4)
	  public void displayUDID() {
		  utils.log("Verifying UDID");
		  sample.displayUDID();
	  }
	  
	  @Test(priority = 5)
	  public void displayAndroidHome() {
		  utils.log("Verifying android home");
		  sample.displayAndroidHome();
	  }

	  @Test(priority = 6)
	  public void displayJVMLocation() {
		  utils.log("Verifying JVM Location");
		  sample.displayJVMLocation();
	  }
}
