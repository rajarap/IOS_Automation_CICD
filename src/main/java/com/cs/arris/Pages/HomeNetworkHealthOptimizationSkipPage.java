package com.cs.arris.Pages;

import org.openqa.selenium.support.PageFactory;


import com.cs.arris.Base.ParentClass;
import com.cs.arris.Interface.Page;
import com.cs.arris.Utilities.TestUtils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.touch.offset.PointOption;

public class HomeNetworkHealthOptimizationSkipPage extends ParentClass implements Page
{
	public TestUtils utils = new TestUtils();
	TouchAction action = new TouchAction(super.getDriver());


	@iOSXCUITFindBy (xpath = "//XCUIElementTypeImage[@name=\"NH_Tutorial_Screen_Image\"]")
	public MobileElement image;
	
	
	public HomeNetworkHealthOptimizationSkipPage()
	{
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}
	
	
	public boolean tapSkip()
	{
		int X1 = 187; //178 , 194 , 189
		int Y1 = 502; //501 , 502 , 501 
		PointOption p = new PointOption();
		p.withCoordinates(X1, Y1);
		action.tap(p).perform();
		return true;
	}
		
	
	@Override
	public boolean isAt() {
			return true;
	}
}
