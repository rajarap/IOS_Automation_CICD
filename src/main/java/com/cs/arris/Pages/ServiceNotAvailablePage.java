package com.cs.arris.Pages;

import com.cs.arris.Base.ParentClass;
import com.cs.arris.Interface.Page;
import com.cs.arris.Utilities.TestUtils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class ServiceNotAvailablePage  extends ParentClass implements Page
{
	public TestUtils utils = new TestUtils();
	
	@AndroidFindBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/tv_error_frag_title']") 
	public MobileElement serviceNotAvailableText;
	
	@AndroidFindBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/tv_error_frag_description']") 
	public MobileElement issueConnectingToBackOfficeText;
	
	@AndroidFindBy (xpath = "//android.widget.TextView[@text='0003-1003']") 
	public MobileElement error_code;
	
	@AndroidFindBy (id = "//com.arris.sbcBeta:id/btn_error_frag_retry") 
	public MobileElement tryAgainButton;	
	
	
	@Override
	public boolean isAt() {
		super.pause();
		return true;
	}
	
}
