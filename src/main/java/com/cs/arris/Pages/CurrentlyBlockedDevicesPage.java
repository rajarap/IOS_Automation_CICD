package com.cs.arris.Pages;

import org.openqa.selenium.support.PageFactory;

import com.cs.arris.Base.ParentClass;
import com.cs.arris.Interface.Page;
import com.cs.arris.Utilities.TestUtils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CurrentlyBlockedDevicesPage extends ParentClass implements Page
{
	public TestUtils utils = new TestUtils();
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.Button[@resource-id='com.arris.sbcBeta:id/buttonOnline']"),  //Online
		@AndroidBy (xpath = "//android.widget.Button[@bounds='[79,397][541,484]']"),
		@AndroidBy (id = "com.arris.sbcBeta:id/buttonOnline") 
	})
	public MobileElement onlineButton; 
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.Button[@resource-id='com.arris.sbcBeta:id/buttonOffline']"),  //Offline
		@AndroidBy (xpath = "//android.widget.Button[@bounds='[539,397][1001,484]']"),
		@AndroidBy (id = "com.arris.sbcBeta:id/buttonOffline") 
	})
	public MobileElement offlineButton; 
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.ImageButton[@content-desc='Navigate up']"),  //back button
		@AndroidBy (xpath = "//android.widget.ImageButton[@bounds='[0,112][147,259]']")
	})
	public MobileElement backButton; 
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.ImageView[@resource-id='com.arris.sbcBeta:id/helpIcon']"),  //help Icon
		@AndroidBy (xpath = "//android.widget.ImageButton[@bounds='[980,153][1046,219]']"),
		@AndroidBy (id = "com.arris.sbcBeta:id/helpIcon") 
	})
	public MobileElement helpIcon; 
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txtAllDeviceTitleOne']"),  //main device name
		@AndroidBy (xpath = "//android.widget.TextView[@bounds='[55,380][141,437]']"),
		@AndroidBy (id = "com.arris.sbcBeta:id/txtAllDeviceTitleOne") 
	})
	public MobileElement mainDeviceName;
	
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//androidx.recyclerview.widget.RecyclerView[@resource-id='com.arris.sbcBeta:id/recycleViewDiningRoom']"),  //list of devices connected to the main device (router)
		@AndroidBy (id = "com.arris.sbcBeta:id/recycleViewDiningRoom") 
	})
	public MobileElement listOfDevicesConnected;
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.LinearLayout[@resource-id='com.arris.sbcBeta:id/home_view"),  
		@AndroidBy (xpath = "//android.widget.LinearLayout[@bounds='[0,2000][355,2042]']"),
		@AndroidBy (id = "com.arris.sbcBeta:id/home_view") 
	})
	public MobileElement homeButton; 
	 
	
	public CurrentlyBlockedDevicesPage()
	{
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}
	
	public void clickHomeButton()
	{
		click(homeButton);
	}
	 
	
	
	
	@Override
	public boolean isAt() {
		super.pause();
		return true;
	}
}
