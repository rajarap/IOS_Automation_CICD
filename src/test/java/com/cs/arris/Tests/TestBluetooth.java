package com.cs.arris.Tests;

import com.cs.arris.Pages.BlueToothPage;
import com.cs.arris.Pages.ConnectToWifiUsingRouterSSID;
import com.cs.arris.Utilities.ValidOTP;

public class TestBluetooth {
	
	public static BlueToothPage bluetoothobj;
	
	public static void main(String[] args)
	{
		setBluetooth();
	}
	
	private static void setBluetooth() 
	{
		try {
			bluetoothobj = new BlueToothPage();
			bluetoothobj.disableBlueTooth();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
