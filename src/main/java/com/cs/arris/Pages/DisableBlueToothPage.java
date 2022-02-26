package com.cs.arris.Pages;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;

import com.cs.arris.Base.ParentClass;
import com.cs.arris.Interface.Page;
import com.cs.arris.Utilities.TestUtils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBys;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.remote.MobileCapabilityType;

public class DisableBlueToothPage extends ParentClass implements Page
{
	TestUtils utils = new TestUtils();
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.LinearLayout[@resource-id='android:id/parentPanel']"),
		@AndroidBy (xpath = "//android.widget.LinearLayout[@bounds='[1,1775][1079,2042]']"),
		@AndroidBy (id = "android:id/parentPanel") 
	})
	public MobileElement parentPanel;
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.Button[@resource-id='android:id/button1']"),
		@AndroidBy (xpath = "//android.widget.Button[@bounds='[535,1964][1016,2042]']"),
		@AndroidBy (xpath = "//android.widget.Button[@text='Allow']"),
		@AndroidBy (id = "android:id/button1") 
	})
	public MobileElement allowButton;
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.Button[@resource-id='android:id/button2']"),
		@AndroidBy (xpath = "//android.widget.Button[@bounds='[64,1964][532,2042]']"),
		@AndroidBy (xpath = "//android.widget.Button[@text='Deny']"),
		@AndroidBy (id = "android:id/button2") 
	})
	public MobileElement denyButton;
	
	public DisableBlueToothPage()
	{
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}

	public void disableBlueTooth()
	{
		try 
	    {
	        ProcessBuilder pb1 = new ProcessBuilder("/opt/homebrew/bin/adb", "shell", "am", "start", "-a", "android.bluetooth.adapter.action.REQUEST_DISABLE");
	        Process pc1 = pb1.start();
	        super.pause(2);
	        
	        if(parentPanel.isDisplayed())
	        {
	        	click(allowButton);
	        	utils.log().info("Clicked Allow button to disable Bluetooth");
	        }
	        else
	        {
	        	utils.log().info("Parent Panel is not displayed. Unable to disable bluetooth");
	        }

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public boolean isAt() {
		 if(parentPanel.isDisplayed())
	        {
	        	utils.log().info("Parent panel to allow or deny bluetooth accessibility is displayed");
	        	return true;
	        }
	        else
	        {
	        	utils.log().info("Parent panel to allow or deny bluetooth accessibility is not displayed");
	        	return false;
	        }
	}
	
}