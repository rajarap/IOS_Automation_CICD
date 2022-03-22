package com.cs.arris.Utilities;

import com.cs.arris.Base.ParentClass;

public class BTPairing extends ParentClass{
	
	public void openDeviceSettings()
	{
		super.getDriver().activateApp("com.android.settings");
		
	}

}
