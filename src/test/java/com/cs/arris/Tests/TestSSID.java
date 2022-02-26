package com.cs.arris.Tests;

import com.cs.arris.Pages.ConnectToWifiUsingRouterSSID;
import com.cs.arris.Utilities.ValidOTP;

public class TestSSID {
	
	public static ConnectToWifiUsingRouterSSID connectSSID;
	
	public static String ssid = "arris1";
	public static String ssidpwd = "1234567890";
	public static String udid = "RZ8M3002DGL";
	
	public static void main(String[] args)
	{
		connectSSID();
	}
	
	private static void connectSSID() 
	{
		try {
			connectSSID = new ConnectToWifiUsingRouterSSID();
			connectSSID.turnOnRouterWifi(ssid, ssidpwd);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
