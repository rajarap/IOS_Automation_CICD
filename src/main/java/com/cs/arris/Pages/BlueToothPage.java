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

public class BlueToothPage extends ParentClass implements Page
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
	
	public BlueToothPage()
	{
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}

	public void enableBlueTooth()
	{
		try 
	    {
	        ProcessBuilder pb1 = new ProcessBuilder("/opt/homebrew/bin/adb", "shell", "am", "start", "-a", "android.bluetooth.adapter.action.REQUEST_ENABLE");
	        Process pc1 = pb1.start();
	        
	        if(parentPanel.isDisplayed())
	        {
	        	click(allowButton);
	        	utils.log().info("Clicked Allow button to enable Bluetooth");
	        }
	        else
	        {
	        	utils.log().info("Parent Panel is not displayed. Unable to enable bluetooth");
	        }

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void disableBlueTooth()
	{
		try 
	    {
	        ProcessBuilder pb1 = new ProcessBuilder("/opt/homebrew/bin/adb", "shell", "am", "start", "-a", "android.bluetooth.adapter.action.REQUEST_DISABLE");
	        Process pc1 = pb1.start();
	        
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


//try {
////setBlueTooth(driver, BTOff);
//ProcessBuilder pb1 = new ProcessBuilder("/opt/homebrew/bin/adb", "-s", "RZ8M3002DGL", "shell", "am", "start", "-a", "android.settings.BLUETOOTH_SETTINGS");
//Process pc1 = pb1.start();
//ProcessBuilder pb2 = new ProcessBuilder("/opt/homebrew/bin/adb", "-s", "RZ8M3002DGL", "shell", "input", "keyevent", "19");
//Process pc2 = pb2.start();
//System.out.println("KeyEvent 19 done");
//ProcessBuilder pb3 = new ProcessBuilder("/opt/homebrew/bin/adb", "-s", "RZ8M3002DGL", "shell", "input", "keyevent", "23");
//Process pc3 = pb3.start();
//System.out.println("KeyEvent 23 done");
//} catch (IOException e) {
//	e.printStackTrace();
//}

//public BlueToothPage()
//{
//	try {
//		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
//		desiredCapabilities.setCapability(MobileCapabilityType.UDID, "RZ8M3002DGL");
//		desiredCapabilities.setCapability(MobileCapabilityType.VERSION, "11");
//		desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET, false);
//		driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
//	} catch (MalformedURLException e) {
//		e.printStackTrace();
//	}
//}
//
//public void disableBlueTooth()
//{
//    try 
//    {
//        ProcessBuilder pb1 = new ProcessBuilder("/opt/homebrew/bin/adb", "-s", "RZ8M3002DGL", "shell", "am", "start", "-a", "android.settings.BLUETOOTH_SETTINGS");
//        Process pc1 = pb1.start();
//    	ProcessBuilder pb2 = new ProcessBuilder("/opt/homebrew/bin/adb", "-s", "RZ8M3002DGL", "shell", "settings", "put", "global", "bluetooth_disabled_profiles", "1");
//    	Process pc2 = pb2.start();
//	} catch (IOException e) {
//		e.printStackTrace();
//	}
//}
//
//public void enableBlueTooth()
//{
//    try
//    {
//        ProcessBuilder pb1 = new ProcessBuilder("/opt/homebrew/bin/adb", "-s", "RZ8M3002DGL", "shell", "am", "start", "-a", "android.settings.BLUETOOTH_SETTINGS");
//        Process pc1 = pb1.start();
//    	ProcessBuilder pb2 = new ProcessBuilder("/opt/homebrew/bin/adb", "-s", "RZ8M3002DGL", "shell", "settings", "put", "global", "bluetooth_on", "0");
//    	Process pc2 = pb2.start();
//    }catch (IOException e) {
//    	e.printStackTrace();
//	}
//}
//
// public void setBlueTooth(AndroidDriver<MobileElement> driver, String statusToSet) 
// {
//    try 
//    {
//    	//String actualStatus = "on";	    	//utils.log().info("Bluetooth is currently : " + actualStatus);
//    	
//        ProcessBuilder pb1 = new ProcessBuilder("/opt/homebrew/bin/adb", "-s", "RZ8M3002DGL", "shell", "am", "start", "-a", "android.settings.BLUETOOTH_SETTINGS");
//        Process pc1 = pb1.start();
//       // MobileElement bluetoothIcon = driver.findElement(By.xpath("//android.widget.Switch[@content-desc='Bluetooth']"));
//        MobileElement bluetoothIcon = driver.findElement(By.xpath("//android.widget.Switch[@text='Bluetooth, On']"));
//      //  MobileElement bluetoothIcon = driver.findElement(By.id("com.android.settings:id/switch_widget"));
//        String actualStatus = bluetoothIcon.getText();
//        System.out.println("Bluetooth is currently : " + actualStatus);
//        super.pause(10);
//        if (!actualStatus.equalsIgnoreCase(statusToSet)) 
//        {
//        	System.out.println("Inside If block");
//	        ProcessBuilder pb2 = new ProcessBuilder("/opt/homebrew/bin/adb", "-s", "RZ8M3002DGL", "shell", "input", "keyevent", "19");
//	        Process pc2 = pb2.start();
//	        System.out.println("KeyEvent 19 done");
//	        ProcessBuilder pb3 = new ProcessBuilder("/opt/homebrew/bin/adb", "-s", "RZ8M3002DGL", "shell", "input", "keyevent", "23");
//	        Process pc3 = pb3.start();
//	        System.out.println("KeyEvent 23 done");
//	        ProcessBuilder pb4 = new ProcessBuilder("/opt/homebrew/bin/adb", "-s", "RZ8M3002DGL", "shell", "input", "keyevent", "3");
//	        Process pc4 = pb4.start();
//	        System.out.println("KeyEvent 3 done");
//        }
//    } catch (Exception e) { e.printStackTrace(); }
// }
//
//@Override
//public boolean isAt() {
//	super.pause();
//	return true;
//}
//
//}