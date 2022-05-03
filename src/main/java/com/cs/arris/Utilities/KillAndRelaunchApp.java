package com.cs.arris.Utilities;

import com.cs.arris.Base.ParentClass;
import com.cs.arris.Interface.Page;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.touch.offset.PointOption;

public class KillAndRelaunchApp extends ParentClass{
	public TestUtils utils = new TestUtils();

		
	public void killApp() {
		super.getDriver().terminateApp("com.arris.sbcBeta");
		super.pause(10);
	}
	
	public void relaunchApp() {
		super.getDriver().activateApp("com.arris.sbcBeta");
		super.pause(10);
	}


}
