package com.cs.arris.Pages;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.support.PageFactory;

import com.cs.arris.Base.ParentClass;
import com.cs.arris.Interface.Page;
import com.cs.arris.Utilities.TestUtils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.connection.ConnectionState;
import io.appium.java_client.android.connection.ConnectionStateBuilder;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.remote.MobileCapabilityType;

public class ConnectToWifiUsingRouterSSID extends ParentClass
{
	public TestUtils utils = new TestUtils();
	public String ssid;
	public String pwd;
	public String udid;
	
	public void turnOnRouterWifi(String ssid, String pwd)
	{
		this.ssid = ssid;
		this.pwd = pwd;
		Capabilities cap = getDriver().getCapabilities();
        try {
        	//adb shell am start -n com.steinwurf.adbjoinwifi/.MainActivity -e ssid arrisw311 -e password_type WPA -e password 1234567890
        	utils.log().info("Connecting to mAX Router " + this.ssid + " Home Network on " + cap.getCapability(MobileCapabilityType.UDID).toString() + " device" );
        	Runtime.getRuntime().exec(new String[]{"bash", "-l", "-c", "adb -s" + cap.getCapability(MobileCapabilityType.UDID).toString() + "shell am start -n com.steinwurf.adbjoinwifi/.MainActivity -e ssid " + this.ssid + " -e password_type WPA -e password " + this.pwd});
        	super.pause(5);
        	Runtime.getRuntime().exec(new String[]{"bash", "-l", "-c", "adb -s" + cap.getCapability(MobileCapabilityType.UDID).toString() + "shell input keyevent 3"});
            utils.log().info("Connected to mAX Router " + this.ssid + " Home Network on " + cap.getCapability(MobileCapabilityType.UDID).toString() + " device" );
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	//Tested																										
	public void turnOnMaxRouterWifi(String ssid, String pwd, String udid)
	{
		this.ssid = ssid;
		this.pwd = pwd;
		this.udid = udid;
       
        try {
        	ProcessBuilder pb1 = new ProcessBuilder("/opt/homebrew/bin/adb", "-s", this.udid, "shell", "am", "start", "-n", "com.steinwurf.adbjoinwifi/.MainActivity", "-e", "ssid", this.ssid, "-e", "password_type", "WPA", "-e", "password", this.pwd);
        	Process pc1 = pb1.start();
            pc1.waitFor(5, TimeUnit.SECONDS);
            ProcessBuilder pb2 = new ProcessBuilder("/opt/homebrew/bin/adb", "-s", this.udid, "shell", "input", "keyevent", "3");
            Process pc2 = pb2.start();
            pc2.waitFor(5, TimeUnit.SECONDS);
        } catch (Exception e) {
            e.printStackTrace();
		}
	}
}




